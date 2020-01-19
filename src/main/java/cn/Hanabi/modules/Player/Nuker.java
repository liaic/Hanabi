package cn.Hanabi.modules.Player;

import java.util.*;
import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.block.*;
import ClassSub.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.*;
import net.minecraft.network.*;

public class Nuker extends Mod
{
    ArrayList positions;
    private Class191 timer2;
    private Class191 timer;
    private Value mode;
    private Value<Double> reach;
    private Value<Double> delay;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Nuker() {
        super("Nuker", Category.PLAYER);
        this.positions = null;
        this.timer2 = new Class191();
        this.timer = new Class191();
        this.mode = new Value("Nuker", "Mode", 0);
        this.reach = new Value<Double>("Nuker_Reach", 6.0, 1.0, 6.0, 0.1);
        this.delay = new Value<Double>("Nuker_Delay", 120.0, 0.0, 1000.0, 10.0);
        this.mode.mode.add("Bed");
        this.mode.mode.add("Egg");
        this.mode.mode.add("Cake");
    }
    
    @EventTarget
    public void onPre(final EventPreMotion eventPreMotion) {
        this.standartDestroyer(eventPreMotion);
    }
    
    private void standartDestroyer(final EventPreMotion eventPreMotion) {
        BlockPos blockPos;
        while ((blockPos = BlockPos.func_177980_a(Nuker.mc.field_71439_g.func_180425_c().func_177973_b(new Vec3i((double)this.reach.getValueState(), (double)this.reach.getValueState(), (double)this.reach.getValueState())), Nuker.mc.field_71439_g.func_180425_c().func_177971_a(new Vec3i((double)this.reach.getValueState(), (double)this.reach.getValueState(), (double)this.reach.getValueState()))).iterator().next()) != null && (!(Nuker.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockBed) || !this.mode.isCurrentMode("Bed")) && (!(Nuker.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockDragonEgg) || !this.mode.isCurrentMode("Egg"))) {
            if (Nuker.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockCake) {
                if (!this.mode.isCurrentMode("Cake")) {
                    continue;
                }
                break;
            }
        }
        if (blockPos instanceof BlockPos) {
            final float[] array = (float[])Class229.getRotationsNeededBlock(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p());
            eventPreMotion.yaw = array[0];
            eventPreMotion.pitch = array[1];
            if (this.timer.isDelayComplete(this.delay.getValueState())) {
                Nuker.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                Nuker.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                Nuker.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, EnumFacing.DOWN));
                Nuker.mc.field_71439_g.func_71038_i();
                this.timer.reset();
            }
        }
    }
}
