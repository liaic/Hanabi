package ClassSub;

import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class Class100 extends GuiScreen
{
    private final Class324 manager;
    private GuiTextField nameField;
    private Class245 pwField;
    private String status;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class100(final Class324 manager) {
        super();
        this.status = EnumChatFormatting.GRAY + "Waiting...";
        this.manager = manager;
    }
    
    public void func_146284_a(final GuiButton guiButton) {
        switch (guiButton.field_146127_k) {
            case 1: {
                this.field_146297_k.func_147108_a((GuiScreen)this.manager);
                break;
            }
            case 0: {
                this.manager.selectedAlt.setMask(this.nameField.func_146179_b());
                this.manager.selectedAlt.setPassword(this.pwField.getText());
                this.status = "Edited!";
                break;
            }
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        this.func_146276_q_();
        final ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
        Class284.drawRect(0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), 0);
        this.func_73732_a(this.field_146289_q, "Edit Alt", this.field_146294_l / 2, 10, -1);
        this.func_73732_a(this.field_146289_q, this.status, this.field_146294_l / 2, 20, -1);
        this.nameField.func_146194_f();
        this.pwField.drawTextBox();
        if (this.nameField.func_146179_b().isEmpty()) {
            this.func_73731_b(this.field_146297_k.field_71466_p, "New name", this.field_146294_l / 2 - 96, 66, -7829368);
        }
        if (this.pwField.getText().isEmpty()) {
            this.func_73731_b(this.field_146297_k.field_71466_p, "New password", this.field_146294_l / 2 - 96, 106, -7829368);
        }
        super.func_73863_a(n, n2, n3);
    }
    
    public void func_73866_w_() {
        this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 92 + 12, "Edit"));
        this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 116 + 12, "Cancel"));
        this.nameField = new GuiTextField(99997, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 60, 200, 20);
        this.pwField = new Class245(this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 100, 100, 200, 20);
    }
    
    protected void func_73869_a(final char c, final int n) {
        this.nameField.func_146201_a(c, n);
        this.pwField.textboxKeyTyped(c, n);
        if (c == '\t' && (this.nameField.func_146206_l() || this.pwField.isFocused())) {
            this.nameField.func_146195_b(!this.nameField.func_146206_l());
            this.pwField.setFocused(!this.pwField.isFocused());
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
        this.nameField.func_146192_a(n, n2, n3);
        this.pwField.mouseClicked(n, n2, n3);
    }
}
