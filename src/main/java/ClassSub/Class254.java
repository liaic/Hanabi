package ClassSub;

import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import cn.Hanabi.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.value.*;
import org.lwjgl.input.*;
import java.util.*;
import java.io.*;

public class Class254 extends GuiScreen
{
    private int stage;
    UnicodeFontRenderer font;
    ScaledResolution sr;
    public static float scale;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class254() {
        super();
        this.stage = 0;
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.sr = new ScaledResolution(this.field_146297_k);
        if (this.sr.func_78328_b() > 420 && this.sr.func_78326_a() > 570) {
            Class254.scale = 1.0f;
        }
        else {
            Class254.scale = 0.8f;
        }
        GL11.glScaled((double)Class254.scale, (double)Class254.scale, (double)Class254.scale);
        Class284.drawImage(new ResourceLocation("Client/newui/background.png"), 0, 0, (int)(this.sr.func_78326_a() * (1.0f / Class254.scale)), (int)(this.sr.func_78328_b() * (1.0f / Class254.scale)));
        this.font = Hanabi.INSTANCE.fontManager.comfortaa20;
        Class284.drawImage(new ResourceLocation("Client/newui/navibar_no.png"), 5, 10, 355, 31);
        Class284.drawImage(new ResourceLocation("Client/newui/navibar_yes.png"), 71 * this.stage + 5, 10, 71, 31);
        this.font.drawCenteredString("Combat", 41.0f, 18.0f, 15658734);
        this.font.drawCenteredString("Movement", 111.0f, 18.0f, 15658734);
        this.font.drawCenteredString("Render", 181.0f, 18.0f, 15658734);
        this.font.drawCenteredString("Player", 251.0f, 18.0f, 15658734);
        this.font.drawCenteredString("World", 321.0f, 18.0f, 15658734);
        this.font = Hanabi.INSTANCE.fontManager.comfortaa16;
        int n4 = 46;
        int n5 = 5;
        int n6 = 0;
        Category category = Category.COMBAT;
        if (this.stage == 0) {
            category = Category.COMBAT;
        }
        if (this.stage == 1) {
            category = Category.MOVEMENT;
        }
        if (this.stage == 2) {
            category = Category.RENDER;
        }
        if (this.stage == 3) {
            category = Category.PLAYER;
        }
        if (this.stage == 4) {
            category = Category.WORLD;
        }
        for (final Mod mod : ModManager.getEnabledModListHUD()) {
            if (mod.getCategory() == category) {
                int n7 = 0;
                for (final Value value : Value.list) {
                    final boolean b = false;
                    final String s = ((String[])value.getValueName().split("_"))[0];
                    final String s2 = ((String[])value.getValueName().split("_"))[1];
                    if (!s.equalsIgnoreCase(mod.getName())) {
                        continue;
                    }
                    ++n7;
                    if (value.isValueMode) {
                        ++n7;
                    }
                    if (n7 <= 6 || n4 == 46 || b) {
                        continue;
                    }
                    n4 = 46;
                    n5 += 140;
                }
                ++n6;
                Class284.drawImage(new ResourceLocation("Client/newui/navibar_no.png"), n5, n4, 130, n7 * 20 + 25);
                int n8 = 0;
                for (final Value<Boolean> value2 : Value.list) {
                    final String s3 = ((String[])value2.getValueName().split("_"))[0];
                    final String string = ((String[])value2.getValueName().split("_"))[1];
                    if (!s3.equalsIgnoreCase(mod.getName())) {
                        continue;
                    }
                    ++n8;
                    if (value2.isValueBoolean) {
                        if ((boolean)value2.getValueState()) {
                            this.font.drawString(string, 12 + n5 + 16.0f, n4 + 6 + n8 * 20, 15658734);
                            Class284.drawImage(new ResourceLocation("Client/newui/value_boolean_true.png"), 12 + n5, n4 + 6 + n8 * 20, 10, 10);
                        }
                        else {
                            this.font.drawString(string, 12 + n5 + 16.0f, n4 + 6 + n8 * 20, 13421772);
                            Class284.drawImage(new ResourceLocation("Client/newui/value_boolean_false.png"), 12 + n5, n4 + 6 + n8 * 20, 10, 10);
                        }
                    }
                    if (value2.isValueDouble) {
                        final int n9 = (int)(107.0 * (((Object)value2.getValueState() - (double)(Object)value2.getValueMin()) / ((Object)value2.getValueMax() - (double)(Object)value2.getValueMin())));
                        Class284.drawImage(new ResourceLocation("Client/newui/value_boolean_true.png"), 12 + n5, n4 + 6 + n8 * 20 + 10, n9, 2);
                        Class284.drawImage(new ResourceLocation("Client/newui/value_boolean_false.png"), 12 + n5 + n9, n4 + 6 + n8 * 20 + 10, 107 - n9, 2);
                        Class284.drawImage(new ResourceLocation("Client/newui/value_boolean_true.png"), 12 + n5 + n9, n4 + 4 + n8 * 20 + 10, 6, 6);
                        this.font.drawString(string, 12.0f + n5, n4 + 4 + n8 * 20, 15658734);
                        this.font.drawString(((Double)(Object)value2.getValueState()).toString(), 12.0f + n5 + 108.0f - this.font.func_78256_a(((Double)(Object)value2.getValueState()).toString()), n4 + 4 + n8 * 20, 10526880);
                        if (Mouse.isButtonDown(0) && (Object)value2.getValueState() > (double)(Object)value2.getValueMin() && this.isHovering(n, n2, 4 + n5, n4 + 4 + n8 * 20 + 6, n9 + 9 + n5, 2 + n4 + 6 + n8 * 20 + 16) && !this.isHovering(n, n2, 12 + n5 + n9, n4 + 4 + n8 * 20 + 10, 18 + n5 + n9, 6 + n4 + 4 + n8 * 20 + 10)) {
                            value2.setValueState((Boolean)(Object)formatDouble((double)(Object)value2.getValueState() - value2.getSteps()));
                        }
                        if (Mouse.isButtonDown(0) && (Object)value2.getValueState() < (double)(Object)value2.getValueMax() && this.isHovering(n, n2, 15 + n5 + n9, n4 + 4 + n8 * 20 + 6, 125 + n5, 2 + n4 + 6 + n8 * 20 + 16) && !this.isHovering(n, n2, 12 + n5 + n9, n4 + 4 + n8 * 20 + 10, 18 + n5 + n9, 6 + n4 + 4 + n8 * 20 + 10)) {
                            value2.setValueState((Boolean)(Object)formatDouble((double)(Object)value2.getValueState() + value2.getSteps()));
                        }
                    }
                    if (!value2.isValueMode) {
                        continue;
                    }
                    ++n8;
                    this.font.drawString(value2.getModeTitle(), 12.0f + n5, n4 + 8 + (n8 - 1) * 20, 13421772);
                    Class284.drawImage(new ResourceLocation("Client/newui/value_menu.png"), 12 + n5, n4 + n8 * 20, 108, 20);
                    this.font.drawString(value2.getModeAt(value2.getCurrentMode()), 18.0f + n5, n4 + 24 + (n8 - 1) * 20, 15658734);
                    this.font.drawString("<" + (value2.getCurrentMode() + 1) + "/" + value2.mode.size() + ">", 90.0f + n5, n4 + 24 + (n8 - 1) * 20, 11184810);
                }
                this.font.drawString(mod.getName(), 12.0f + n5, n4 + 6, 15658734);
                if (mod.isEnabled()) {
                    Class284.drawImage(new ResourceLocation("Client/newui/mod_enable_bg.png"), n5 + 130 - 30, n4 + 5, 22, 11);
                    Class284.drawImage(new ResourceLocation("Client/newui/mod_enable_button.png"), n5 + 130 - 30 + 11, n4 + 5, 11, 11);
                }
                else {
                    Class284.drawImage(new ResourceLocation("Client/newui/mod_disable_bg.png"), n5 + 130 - 30, n4 + 5, 22, 11);
                    Class284.drawImage(new ResourceLocation("Client/newui/mod_disable_button.png"), n5 + 130 - 30, n4 + 5, 11, 11);
                }
                n4 += n8 * 20 + 30;
                if (n4 <= this.sr.func_78328_b() * (1.0f / Class254.scale) - 150.0f) {
                    continue;
                }
                n4 = 46;
                n5 += 140;
            }
        }
    }
    
    public static double formatDouble(final double n) {
        return Math.round(n * 100.0) / 100.0;
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) throws IOException {
    }
    
    protected void func_146286_b(final int n, final int n2, final int n3) {
        if (this.isHovering(n, n2, 5, 10, 76, 36)) {
            this.stage = 0;
        }
        if (this.isHovering(n, n2, 76, 10, 147, 36)) {
            this.stage = 1;
        }
        if (this.isHovering(n, n2, 147, 10, 218, 36)) {
            this.stage = 2;
        }
        if (this.isHovering(n, n2, 218, 10, 289, 36)) {
            this.stage = 3;
        }
        if (this.isHovering(n, n2, 289, 10, 360, 36)) {
            this.stage = 4;
        }
        Category category = Category.COMBAT;
        if (this.stage == 0) {
            category = Category.COMBAT;
        }
        if (this.stage == 1) {
            category = Category.MOVEMENT;
        }
        if (this.stage == 2) {
            category = Category.RENDER;
        }
        if (this.stage == 3) {
            category = Category.PLAYER;
        }
        if (this.stage == 4) {
            category = Category.WORLD;
        }
        int n4 = 46;
        int n5 = 5;
        int n6 = 0;
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        for (final Mod mod : ModManager.getEnabledModListHUD()) {
            if (mod.getCategory() == category) {
                int n7 = 0;
                for (final Value value : Value.list) {
                    final boolean b = false;
                    final String s = ((String[])value.getValueName().split("_"))[0];
                    final String s2 = ((String[])value.getValueName().split("_"))[1];
                    if (!s.equalsIgnoreCase(mod.getName())) {
                        continue;
                    }
                    if (++n7 <= 6 || n4 == 46 || b) {
                        continue;
                    }
                    n4 = 46;
                    n5 += 140;
                }
                int n8 = 0;
                for (final Value<Boolean> value2 : Value.list) {
                    final String s3 = ((String[])value2.getValueName().split("_"))[0];
                    final String s4 = ((String[])value2.getValueName().split("_"))[1];
                    if (!s3.equalsIgnoreCase(mod.getName())) {
                        continue;
                    }
                    ++n8;
                    if (value2.isValueBoolean && this.isHovering(n, n2, 12 + n5, n4 + 6 + n8 * 20, 12 + n5 + 10, n4 + 6 + n8 * 20 + 10)) {
                        value2.setValueState(!(boolean)value2.getValueState());
                    }
                    if (!value2.isValueMode) {
                        continue;
                    }
                    ++n8;
                    if (!this.isHovering(n, n2, 12 + n5, n4 + n8 * 20, 120 + n5, 20 + n4 + n8 * 20)) {
                        continue;
                    }
                    if (value2.mode.size() <= value2.getCurrentMode() + 1) {
                        value2.setCurrentMode(0);
                    }
                    else {
                        value2.setCurrentMode(value2.getCurrentMode() + 1);
                    }
                }
                ++n6;
                if (this.isHovering(n, n2, n5 + 130 - 30, n4 + 5, n5 + 130 - 30 + 22, n4 + 5 + 11)) {
                    mod.set(!mod.isEnabled());
                }
                n4 += n8 * 20 + 30;
                if (n4 <= scaledResolution.func_78328_b() * (1.0f / Class254.scale) - 150.0f) {
                    continue;
                }
                n4 = 46;
                n5 += 140;
            }
        }
    }
    
    private boolean isHovering(final int n, final int n2, int n3, int n4, int n5, int n6) {
        n3 *= Class254.scale;
        n4 *= Class254.scale;
        n5 *= Class254.scale;
        n6 *= Class254.scale;
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
    
    public void func_146281_b() {
        try {
            this.field_146297_k.field_71460_t.func_181022_b();
        }
        catch (Throwable t) {}
    }
    
    static {
        Class254.scale = 1.0f;
    }
}
