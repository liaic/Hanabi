package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.events.*;
import net.minecraft.client.entity.*;

public class Class297
{
    Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class297() {
        super();
        this.mc = Minecraft.func_71410_x();
    }
    
    public void onPre(final EventPreMotion eventPreMotion) {
        if (this.mc.field_71439_g.field_70122_E && Class295.MovementInput() && !this.mc.field_71439_g.func_70090_H()) {
            Class296.getTimer().field_74278_d = 1.0f;
            this.mc.field_71439_g.func_70664_aZ();
        }
        else if (Class295.MovementInput() && !this.mc.field_71439_g.func_70090_H()) {
            Class295.setSpeed(0.8);
        }
        if (!Class295.MovementInput()) {
            final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
            final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
            final double n = 0.0;
            field_71439_g2.field_70179_y = n;
            field_71439_g.field_70159_w = n;
        }
    }
}
