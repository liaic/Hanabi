package cn.Hanabi.modules.Movement;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Combat.*;
import ClassSub.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import net.minecraft.network.play.client.*;

public class NoSlow extends Mod
{
    public Value<String> mode;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public NoSlow() {
        super("NoSlow", Category.MOVEMENT);
        (this.mode = new Value<String>("NoSlow", "Mode", 0)).addValue("Hypixel");
        this.mode.addValue("NCP");
        this.mode.addValue("AAC");
    }
    
    @EventTarget
    public void onPre(final EventPreMotion eventPreMotion) {
        if (NoSlow.mc.field_71439_g.func_71039_bw() && Class295.isMoving() && Class206.isOnGround(0.42) && KillAura.target == null && (this.mode.isCurrentMode("AAC") || this.mode.isCurrentMode("NCP"))) {
            if (this.mode.isCurrentMode("AAC")) {
                Class296.getTimer().field_74278_d = 0.7f;
            }
            final double field_70165_t = NoSlow.mc.field_71439_g.field_70165_t;
            final double field_70163_u = NoSlow.mc.field_71439_g.field_70163_u;
            final double field_70161_v = NoSlow.mc.field_71439_g.field_70161_v;
            NoSlow.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
        }
        if (!NoSlow.mc.field_71439_g.func_71039_bw() && this.mode.isCurrentMode("AAC")) {
            Class296.getTimer().field_74278_d = 1.0f;
        }
    }
    
    @EventTarget
    public void onPost(final EventPostMotion eventPostMotion) {
        if (NoSlow.mc.field_71439_g.func_71039_bw() && Class295.isMoving() && Class206.isOnGround(0.42) && KillAura.target == null && (this.mode.isCurrentMode("AAC") || this.mode.isCurrentMode("NCP"))) {
            final double field_70165_t = NoSlow.mc.field_71439_g.field_70165_t;
            final double field_70163_u = NoSlow.mc.field_71439_g.field_70163_u;
            final double field_70161_v = NoSlow.mc.field_71439_g.field_70161_v;
            NoSlow.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C08PacketPlayerBlockPlacement(NoSlow.mc.field_71439_g.field_71071_by.func_70448_g()));
        }
    }
}
