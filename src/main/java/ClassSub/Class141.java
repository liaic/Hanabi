package ClassSub;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import cn.Hanabi.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.hmlProject.*;
import java.awt.*;
import org.lwjgl.opengl.*;
import java.util.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.io.*;

public class Class141 extends GuiScreen
{
    public ArrayList<Class159> slots;
    public ScaledResolution sr;
    public Class191 timer;
    public boolean coolDown;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class141() {
        super();
        this.slots = new ArrayList<Class159>();
        this.timer = new Class191();
        this.coolDown = true;
    }
    
    public void func_73866_w_() {
        this.sr = new ScaledResolution(Minecraft.func_71410_x());
        this.coolDown = true;
        this.timer.reset();
        this.slots.clear();
        this.slots.add(new Class159("单人游戏", HanabiFonts.ICON_MAINMENU_SINGLE, (GuiScreen)new GuiSelectWorld((GuiScreen)this)));
        this.slots.add(new Class159("多人游戏", HanabiFonts.ICON_MAINMENU_MULTI, (GuiScreen)new GuiMultiplayer((GuiScreen)this)));
        this.slots.add(new Class159("黑卡管理", HanabiFonts.ICON_MAINMENU_ALTMANAGER, (GuiScreen)new Class324()));
        this.slots.add(new Class159("游戏设置", HanabiFonts.ICON_MAINMENU_SETTINGS, (GuiScreen)new GuiOptions((GuiScreen)this, this.field_146297_k.field_71474_y)));
        this.slots.add(new Class159("退出游戏", HanabiFonts.ICON_MAINMENU_QUITGAME, (GuiScreen)null));
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.sr = new ScaledResolution(Minecraft.func_71410_x());
        if (this.coolDown && this.timer.isDelayComplete(500L)) {
            this.coolDown = false;
            this.timer.reset();
        }
        Class284.drawImage(new ResourceLocation("Client/mainmenu/mainmenu.png"), 0, 0, this.sr.func_78326_a(), this.sr.func_78328_b());
        int n4 = this.sr.func_78326_a() / 2 - 150;
        final int n5 = this.sr.func_78328_b() / 2;
        for (final Class159 class159 : this.slots) {
            class159.draw(n, n2, n4, n5);
            if (!this.coolDown && !Hanabi.INSTANCE.loadFont) {
                class159.onClick(n, n2, n4, n5);
            }
            n4 += 70;
        }
        final String string = "欢迎回来, " + Mod.fuck;
        Hanabi.INSTANCE.fontManager.wqy18.drawString(string, this.sr.func_78326_a() - 55 - Hanabi.INSTANCE.fontManager.wqy18.func_78256_a(string), 20.0f, -1);
        final int size = HMLManager.hooks.size();
        Hanabi.INSTANCE.fontManager.wqy18.func_78276_b("已加载" + size + "个HML Module.", 3, 2, Color.GREEN.getRGB());
        if (size > 0) {
            Hanabi.INSTANCE.fontManager.wqy18.func_78276_b("警告！HML Project尚不完善，可能导致不可预料的错误。", 3, 13, Color.RED.getRGB());
        }
        GL11.glPushMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.0f);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.func_148821_a(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.func_71410_x().func_175598_ae().field_78724_e.func_110577_a(new ResourceLocation("Client/mainmenu/avatar.png"));
        this.drawScaledTexturedModalRect(this.sr.func_78326_a() - 46, 9.0, 0.0, 0.0, 32.0, 32.0, 8.1f);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        Class284.drawArc(this.sr.func_78326_a() - 30, 25.0f, 16.0, Class59.WHITE.c, 0, 360.0, 2);
        GL11.glPopMatrix();
        Hanabi.INSTANCE.fontManager.comfortaa17.drawString("HML Project API - Build 0", 2.0f, this.sr.func_78328_b() - 20, -1);
        if (Hanabi.INSTANCE.loadFont) {
            final UnicodeFontRenderer wqy18 = Hanabi.INSTANCE.fontManager.wqy18;
            final StringBuilder append = new StringBuilder().append("正在加载剩余字体,请稍后... (");
            final FontManager fontManager = Hanabi.INSTANCE.fontManager;
            wqy18.drawString(append.append(FontManager.fontName).append(")").toString(), 2.0f, this.sr.func_78328_b() - 10, -1);
        }
        else {
            Hanabi.INSTANCE.fontManager.comfortaa17.drawString("Hanabi build 1.4.2 - by Margele", 2.0f, this.sr.func_78328_b() - 10, -1);
        }
        super.func_73863_a(n, n2, n3);
    }
    
    public void drawScaledTexturedModalRect(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final float n7) {
        final float n8 = 0.00390625f * n7;
        final float n9 = 0.00390625f * n7;
        final Tessellator func_178181_a = Tessellator.func_178181_a();
        final WorldRenderer func_178180_c = func_178181_a.func_178180_c();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        func_178180_c.func_181662_b(n + 0.0, n2 + n6, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + 0.0) * n8), (double)((float)(n4 + n6) * n9)).func_181675_d();
        func_178180_c.func_181662_b(n + n5, n2 + n6, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + n5) * n8), (double)((float)(n4 + n6) * n9)).func_181675_d();
        func_178180_c.func_181662_b(n + n5, n2 + 0.0, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + n5) * n8), (double)((float)(n4 + 0.0) * n9)).func_181675_d();
        func_178180_c.func_181662_b(n + 0.0, n2 + 0.0, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + 0.0) * n8), (double)((float)(n4 + 0.0) * n9)).func_181675_d();
        func_178181_a.func_78381_a();
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) throws IOException {
        super.func_73864_a(n, n2, n3);
    }
    
    public void func_73876_c() {
        super.func_73876_c();
    }
    
    public void func_146281_b() {
        super.func_146281_b();
    }
}
