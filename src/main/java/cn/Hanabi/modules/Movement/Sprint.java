package cn.Hanabi.modules.Movement;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import ClassSub.*;
import net.minecraft.potion.*;
import com.darkmagician6.eventapi.*;

public class Sprint extends Mod
{
    public static boolean isSprinting;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Sprint() {
        super("Sprint", Category.MOVEMENT);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (Class21.abuses < 0 && Class295.MovementInput()) {
            Sprint.mc.field_71439_g.func_70690_d(new PotionEffect(Potion.field_76431_k.func_76396_c(), 100, 1));
        }
        final boolean b = Sprint.mc.field_71439_g.func_71024_bL().func_75116_a() > 6.0f || Sprint.mc.field_71439_g.field_71075_bZ.field_75101_c;
        if (Class295.MovementInput() && b) {
            Sprint.isSprinting = true;
            Sprint.mc.field_71439_g.func_70031_b(true);
        }
        else {
            Sprint.isSprinting = false;
        }
    }
    
    public void onDisable() {
        Sprint.isSprinting = false;
        Sprint.mc.field_71439_g.func_70031_b(false);
        super.onDisable();
    }
}
