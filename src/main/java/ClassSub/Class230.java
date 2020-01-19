package ClassSub;

import java.awt.*;
import java.awt.datatransfer.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import org.lwjgl.input.*;
import java.io.*;

public final class Class230 extends GuiScreen
{
    private Class245 password;
    private final GuiScreen previousScreen;
    private Class133 thread;
    private GuiTextField username;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class230(final GuiScreen previousScreen) {
        super();
        this.previousScreen = previousScreen;
    }
    
    protected void func_146284_a(final GuiButton guiButton) {
        try {
            switch (guiButton.field_146127_k) {
                case 1: {
                    this.field_146297_k.func_147108_a(this.previousScreen);
                    break;
                }
                case 0: {
                    (this.thread = new Class133(new Class98(this.username.func_146179_b(), this.password.getText()))).start();
                    break;
                }
                case 2: {
                    final String s = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                    if (s.contains(":")) {
                        final String[] array = (String[])s.split(":");
                        this.username.func_146180_a(array[0]);
                        this.password.setText(array[1]);
                        break;
                    }
                    break;
                }
            }
        }
        catch (Throwable t) {
            throw new RuntimeException();
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.func_146276_q_();
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        Class284.drawRect(0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), 0);
        this.username.func_146194_f();
        this.password.drawTextBox();
        this.func_73732_a(this.field_146297_k.field_71466_p, "Alt Login", this.field_146294_l / 2, 20, -1);
        this.func_73732_a(this.field_146297_k.field_71466_p, (this.thread == null) ? (EnumChatFormatting.GRAY + "Idle...") : this.thread.getStatus(), this.field_146294_l / 2, 29, -1);
        if (this.username.func_146179_b().isEmpty()) {
            this.func_73731_b(this.field_146297_k.field_71466_p, "Username / E-Mail", this.field_146294_l / 2 - 96, 66, -7829368);
        }
        if (this.password.getText().isEmpty()) {
            this.func_73731_b(this.field_146297_k.field_71466_p, "Password", this.field_146294_l / 2 - 96, 106, -7829368);
        }
        super.func_73863_a(n, n2, n3);
    }
    
    public void func_73866_w_() {
        final int n = this.field_146295_m / 4 + 24;
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, n + 72 + 12, "Login"));
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, n + 72 + 12 + 24, "Back"));
        this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, n + 72 + 12 + 48, "Import user:pass"));
        this.username = new GuiTextField(n, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 60, 200, 20);
        this.password = new Class245(this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 100, 200, 20);
        this.username.func_146195_b(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    protected void func_73869_a(final char c, final int n) {
        try {
            super.func_73869_a(c, n);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        if (c == '\t') {
            if (!this.username.func_146206_l() && !this.password.isFocused()) {
                this.username.func_146195_b(true);
            }
            else {
                this.username.func_146195_b(this.password.isFocused());
                this.password.setFocused(!this.username.func_146206_l());
            }
        }
        if (c == '\r') {
            this.func_146284_a(this.field_146292_n.get(0));
        }
        this.username.func_146201_a(c, n);
        this.password.textboxKeyTyped(c, n);
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) {
        try {
            super.func_73864_a(n, n2, n3);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        this.username.func_146192_a(n, n2, n3);
        this.password.mouseClicked(n, n2, n3);
    }
    
    public void func_146281_b() {
        Keyboard.enableRepeatEvents(false);
    }
    
    public void func_73876_c() {
        this.username.func_146178_a();
        this.password.updateCursorCounter();
    }
}
