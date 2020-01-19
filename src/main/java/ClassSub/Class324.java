package ClassSub;

import net.minecraft.util.*;
import cn.Hanabi.*;
import java.io.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import java.awt.*;
import java.util.*;

public class Class324 extends GuiScreen
{
    private GuiButton login;
    private GuiButton remove;
    private GuiButton rename;
    private Class133 loginThread;
    private int offset;
    public Class98 selectedAlt;
    private String status;
    private ResourceLocation background;
    private GuiTextField seatchField;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class324() {
        super();
        this.background = new ResourceLocation("textures/mainmenubackground.png");
        this.selectedAlt = null;
        this.status = EnumChatFormatting.GRAY + "Idle...";
    }
    
    public void func_146284_a(final GuiButton guiButton) {
        switch (guiButton.field_146127_k) {
            case 1: {
                (this.loginThread = new Class133(this.selectedAlt)).start();
                Hanabi.INSTANCE.altFileMgr.saveFiles();
                break;
            }
            case 2: {
                if (this.loginThread != null) {
                    this.loginThread = null;
                }
                Class91.registry.remove(this.selectedAlt);
                this.status = "§aRemoved.";
                try {
                    Hanabi.INSTANCE.altFileMgr.getFile(Class169.class).saveFile();
                }
                catch (Exception ex2) {}
                this.selectedAlt = null;
                break;
            }
            case 3: {
                this.field_146297_k.func_147108_a((GuiScreen)new Class54(this));
                break;
            }
            case 4: {
                this.field_146297_k.func_147108_a((GuiScreen)new Class230(this));
                break;
            }
            case 5: {
                final ArrayList<Class98> registry = Class91.registry;
                final Random random = new Random();
                if (registry.size() > 1) {
                    (this.loginThread = new Class133(registry.get(random.nextInt(Class91.registry.size())))).start();
                    break;
                }
                this.status = EnumChatFormatting.RED + "There's no any alts!";
                break;
            }
            case 6: {
                this.field_146297_k.func_147108_a((GuiScreen)new Class100(this));
                break;
            }
            case 7: {
                this.field_146297_k.func_147108_a((GuiScreen)null);
                break;
            }
            case 8: {
                Class91.registry.clear();
                try {
                    Hanabi.INSTANCE.altFileMgr.getFile(Class169.class).loadFile();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                this.status = "§bReloaded!";
                break;
            }
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.func_146276_q_();
        if (Mouse.hasWheel()) {
            final int dWheel = Mouse.getDWheel();
            if (dWheel < 0) {
                this.offset += 26;
                if (this.offset < 0) {
                    this.offset = 0;
                }
            }
            else if (dWheel > 0) {
                this.offset -= 26;
                if (this.offset < 0) {
                    this.offset = 0;
                }
            }
        }
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        scaledResolution.func_78326_a();
        scaledResolution.func_78328_b();
        GlStateManager.func_179144_i(0);
        Class284.drawRect(0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), getColor(0, 50));
        this.func_73731_b(this.field_146289_q, this.field_146297_k.func_110432_I().func_111285_a(), 10, 10, 14540253);
        this.func_73732_a(this.field_146289_q, "Account Manager - " + Class91.registry.size() + " alts", this.field_146294_l / 2, 10, -1);
        this.func_73732_a(this.field_146289_q, (this.loginThread == null) ? this.status : this.loginThread.getStatus(), this.field_146294_l / 2, 20, -1);
        Class284.drawOutlinedRect(50.0f, 33.0f, this.field_146294_l - 50, this.field_146295_m - 50, 1.0f, getColor(225, 50), getColor(160, 150));
        GL11.glPushMatrix();
        this.prepareScissorBox(0.0f, 33.0f, this.field_146294_l, this.field_146295_m - 50);
        GL11.glEnable(3089);
        int n4 = 38;
        for (final Class98 class98 : this.getAlts()) {
            if (this.isAltInArea(n4)) {
                String s;
                if (class98.getMask().equals("")) {
                    s = class98.getUsername();
                }
                else {
                    s = class98.getMask();
                }
                String replaceAll;
                if (class98.getPassword().equals("")) {
                    replaceAll = "§cCracked";
                }
                else {
                    replaceAll = class98.getPassword().replaceAll(".", "*");
                }
                if (class98 == this.selectedAlt) {
                    if (this.isMouseOverAlt(n, n2, n4 - this.offset) && Mouse.isButtonDown(0)) {
                        Class284.drawOutlinedRect(52.0f, n4 - this.offset - 4, this.field_146294_l - 52, n4 - this.offset + 20, 1.0f, getColor(145, 50), -2142943931);
                    }
                    else if (this.isMouseOverAlt(n, n2, n4 - this.offset)) {
                        Class284.drawOutlinedRect(52.0f, n4 - this.offset - 4, this.field_146294_l - 52, n4 - this.offset + 20, 1.0f, getColor(145, 50), -2142088622);
                    }
                    else {
                        Class284.drawOutlinedRect(52.0f, n4 - this.offset - 4, this.field_146294_l - 52, n4 - this.offset + 20, 1.0f, getColor(145, 50), -2144259791);
                    }
                }
                else if (this.isMouseOverAlt(n, n2, n4 - this.offset) && Mouse.isButtonDown(0)) {
                    Class284.drawOutlinedRect(52.0f, n4 - this.offset - 4, this.field_146294_l - 52, n4 - this.offset + 20, 1.0f, -getColor(145, 50), -2146101995);
                }
                else if (this.isMouseOverAlt(n, n2, n4 - this.offset)) {
                    Class284.drawOutlinedRect(52.0f, n4 - this.offset - 4, this.field_146294_l - 52, n4 - this.offset + 20, 1.0f, getColor(145, 50), -2145180893);
                }
                this.func_73732_a(this.field_146289_q, s, this.field_146294_l / 2, n4 - this.offset, -1);
                this.func_73732_a(this.field_146289_q, replaceAll, this.field_146294_l / 2, n4 - this.offset + 10, getColor(110));
                n4 += 26;
            }
        }
        GL11.glDisable(3089);
        GL11.glPopMatrix();
        super.func_73863_a(n, n2, n3);
        if (this.selectedAlt == null) {
            this.login.field_146124_l = false;
            this.remove.field_146124_l = false;
            this.rename.field_146124_l = false;
        }
        else {
            this.login.field_146124_l = true;
            this.remove.field_146124_l = true;
            this.rename.field_146124_l = true;
        }
        if (Keyboard.isKeyDown(200)) {
            this.offset -= 26;
        }
        else if (Keyboard.isKeyDown(208)) {
            this.offset += 26;
        }
        if (this.offset < 0) {
            this.offset = 0;
        }
        this.seatchField.func_146194_f();
        if (this.seatchField.func_146179_b().isEmpty() && !this.seatchField.func_146206_l()) {
            this.func_73731_b(this.field_146297_k.field_71466_p, "Search Alt", this.field_146294_l / 2 - 264, this.field_146295_m - 18, -1);
        }
    }
    
    public static int getColor(final int n, final int n2, final int n3, final int n4) {
        return 0x0 | n4 << 24 | n << 16 | n2 << 8 | n3;
    }
    
    public static int getColor(final Color color) {
        return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
    
    public static int getColor(final int n) {
        return getColor(n, n, n, 255);
    }
    
    public static int getColor(final int n, final int n2) {
        return getColor(n, n, n, n2);
    }
    
    public void func_73866_w_() {
        this.field_146292_n.add(this.login = new GuiButton(1, this.field_146294_l / 2 - 122, this.field_146295_m - 48, 100, 20, "Login"));
        this.field_146292_n.add(this.remove = new GuiButton(2, this.field_146294_l / 2 - 16, this.field_146295_m - 24, 100, 20, "Remove"));
        this.field_146292_n.add(new GuiButton(3, this.field_146294_l / 2 + 4 + 86, this.field_146295_m - 48, 100, 20, "Add"));
        this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 - 16, this.field_146295_m - 48, 100, 20, "Direct Login"));
        this.field_146292_n.add(new GuiButton(5, this.field_146294_l / 2 - 122, this.field_146295_m - 24, 100, 20, "Random"));
        this.field_146292_n.add(this.rename = new GuiButton(6, this.field_146294_l / 2 + 90, this.field_146295_m - 24, 100, 20, "Edit"));
        this.field_146292_n.add(new GuiButton(7, this.field_146294_l / 2 - 190, this.field_146295_m - 24, 60, 20, "Back"));
        this.field_146292_n.add(new GuiButton(8, this.field_146294_l / 2 - 190, this.field_146295_m - 48, 60, 20, "Reload"));
        this.seatchField = new GuiTextField(99998, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 268, this.field_146295_m - 21, 68, 14);
        this.login.field_146124_l = false;
        this.remove.field_146124_l = false;
        this.rename.field_146124_l = false;
    }
    
    protected void func_73869_a(final char c, final int n) {
        this.seatchField.func_146201_a(c, n);
        if ((c == '\t' || c == '\r') && this.seatchField.func_146206_l()) {
            this.seatchField.func_146195_b(!this.seatchField.func_146206_l());
        }
        try {
            super.func_73869_a(c, n);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean isAltInArea(final int n) {
        return n - this.offset <= this.field_146295_m - 50;
    }
    
    private boolean isMouseOverAlt(final int n, final int n2, final int n3) {
        return n >= 52 && n2 >= n3 - 4 && n <= this.field_146294_l - 52 && n2 <= n3 + 20 && n >= 0 && n2 >= 33 && n <= this.field_146294_l && n2 <= this.field_146295_m - 50;
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        this.seatchField.func_146192_a(n, n2, n3);
        if (this.offset < 0) {
            this.offset = 0;
        }
        int n4 = 38 - this.offset;
        for (final Class98 selectedAlt : this.getAlts()) {
            if (this.isMouseOverAlt(n, n2, n4)) {
                if (selectedAlt == this.selectedAlt) {
                    this.func_146284_a(this.field_146292_n.get(0));
                    return;
                }
                this.selectedAlt = selectedAlt;
            }
            n4 += 26;
        }
        try {
            super.func_73864_a(n, n2, n3);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private List<Class98> getAlts() {
        final ArrayList<Class98> list = new ArrayList<Class98>();
        for (final Class98 class98 : Class91.registry) {
            if (this.seatchField.func_146179_b().isEmpty() || class98.getMask().toLowerCase().contains(this.seatchField.func_146179_b().toLowerCase()) || class98.getUsername().toLowerCase().contains(this.seatchField.func_146179_b().toLowerCase())) {
                list.add(class98);
            }
        }
        return list;
    }
    
    public void prepareScissorBox(final float n, final float n2, final float n3, final float n4) {
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        final int func_78325_e = scaledResolution.func_78325_e();
        GL11.glScissor((int)(n * func_78325_e), (int)((scaledResolution.func_78328_b() - n4) * func_78325_e), (int)((n3 - n) * func_78325_e), (int)((n4 - n2) * func_78325_e));
    }
}
