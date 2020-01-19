package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.value.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;

public class Class109
{
    Minecraft mc;
    Value<Double> timer;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class109() {
        super();
        this.mc = Minecraft.func_71410_x();
        this.timer = new Value<Double>("Fly_MotionSpeed", 1.0, 1.0, 10.0, 1.0);
    }
    
    public void onPre() {
        this.mc.field_71439_g.field_70181_x = 0.0;
        if (Class295.MovementInput()) {
            Class295.setSpeed((double)this.timer.getValueState() * 0.5);
        }
        else {
            Class295.setSpeed(0.0);
        }
        if (((IKeyBinding)this.mc.field_71474_y.field_74311_E).getPress()) {
            final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
            --field_71439_g.field_70181_x;
        }
        else if (((IKeyBinding)this.mc.field_71474_y.field_74314_A).getPress()) {
            final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
            ++field_71439_g2.field_70181_x;
        }
    }
}
