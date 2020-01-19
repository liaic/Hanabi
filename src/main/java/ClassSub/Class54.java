package ClassSub;

import net.minecraft.util.*;
import java.awt.*;
import java.awt.datatransfer.*;
import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import java.io.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import cn.Hanabi.*;
import com.mojang.authlib.exceptions.*;

public class Class54 extends GuiScreen
{
    private final Class324 manager;
    private Class245 password;
    private String status;
    private GuiTextField username;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class54(final Class324 manager) {
        super();
        this.status = EnumChatFormatting.GRAY + "Idle...";
        this.manager = manager;
    }
    
    protected void func_146284_a(final GuiButton guiButton) {
        switch (guiButton.field_146127_k) {
            case 0: {
                new Class252(this.username.func_146179_b(), this.password.getText()).start();
                break;
            }
            case 1: {
                this.field_146297_k.func_147108_a((GuiScreen)this.manager);
                break;
            }
            case 2: {
                String s;
                try {
                    s = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                }
                catch (Exception ex) {
                    break;
                }
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
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.func_146276_q_();
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        Class284.drawRect(0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), 0);
        this.username.func_146194_f();
        this.password.drawTextBox();
        this.func_73732_a(this.field_146289_q, "Add Alt", this.field_146294_l / 2, 20, -1);
        if (this.username.func_146179_b().isEmpty()) {
            this.func_73731_b(this.field_146297_k.field_71466_p, "Username / E-Mail", this.field_146294_l / 2 - 96, 66, -7829368);
        }
        if (this.password.getText().isEmpty()) {
            this.func_73731_b(this.field_146297_k.field_71466_p, "Password", this.field_146294_l / 2 - 96, 106, -7829368);
        }
        this.func_73732_a(this.field_146289_q, this.status, this.field_146294_l / 2, 30, -1);
        super.func_73863_a(n, n2, n3);
    }
    
    public void func_73866_w_() {
        Keyboard.enableRepeatEvents(true);
        this.field_146292_n.clear();
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 92 + 12, "Login"));
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 116 + 12, "Back"));
        this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 116 + 36, "Import user:pass"));
        this.username = new GuiTextField(99999, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 60, 200, 20);
        this.password = new Class245(this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 100, 200, 20);
    }
    
    protected void func_73869_a(final char c, final int n) {
        this.username.func_146201_a(c, n);
        this.password.textboxKeyTyped(c, n);
        if (c == '\t' && (this.username.func_146206_l() || this.password.isFocused())) {
            this.username.func_146195_b(!this.username.func_146206_l());
            this.password.setFocused(!this.password.isFocused());
        }
        if (c == '\r') {
            this.func_146284_a(this.field_146292_n.get(0));
        }
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
    
    static void access$0(final Class54 class54, final String status) {
        class54.status = status;
    }
}
