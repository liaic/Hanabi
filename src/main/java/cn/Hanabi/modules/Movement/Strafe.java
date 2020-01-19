package cn.Hanabi.modules.Movement;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import cn.Hanabi.injection.interfaces.*;
import ClassSub.*;
import com.darkmagician6.eventapi.*;

public class Strafe extends Mod
{
    public boolean air;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Strafe() {
        super("Strafe", Category.MOVEMENT);
        this.air = true;
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotion eventPreMotion) {
        if (!Strafe.mc.field_71439_g.field_70122_E && ((IKeyBinding)Strafe.mc.field_71474_y.field_74314_A).getPress()) {
            Class295.setSpeed(Class295.getSpeed());
        }
    }
}
