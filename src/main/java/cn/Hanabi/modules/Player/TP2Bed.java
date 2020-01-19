package cn.Hanabi.modules.Player;

import net.minecraft.util.*;
import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import java.util.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.injection.interfaces.*;
import cn.Hanabi.events.*;
import net.minecraft.client.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import ClassSub.*;

public class TP2Bed extends Mod
{
    public BlockPos playerBed;
    public BlockPos fuckingBed;
    public ArrayList<BlockPos> posList;
    Class191 timer;
    public Value<Double> delay;
    private ArrayList<Class235> path;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public TP2Bed() {
        super("TP2Bed", Category.PLAYER);
        this.timer = new Class191();
        this.delay = new Value<Double>("TP2Bed_Delay", 600.0, 200.0, 3000.0, 100.0);
        this.path = new ArrayList<Class235>();
    }
    
    public void onEnable() {
        try {
            (this.posList = new ArrayList<BlockPos>(Class34.list)).sort(this::lambda$onEnable$0);
            if (this.posList.size() < 3) {
                this.set(false);
            }
            final ArrayList<BlockPos> list = new ArrayList<BlockPos>(this.posList);
            int n = 1;
            for (final BlockPos blockPos : list) {
                if (++n % 2 == 1) {
                    this.posList.remove(blockPos);
                }
            }
            this.playerBed = this.posList.get(0);
            this.posList.remove(0);
            if (TP2Bed.mc.field_71439_g.field_70122_E && TP2Bed.mc.field_71439_g.field_70124_G && Class206.isOnGround(0.01)) {
                for (int i = 0; i < 49; ++i) {
                    TP2Bed.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TP2Bed.mc.field_71439_g.field_70165_t, TP2Bed.mc.field_71439_g.field_70163_u + 0.06249, TP2Bed.mc.field_71439_g.field_70161_v, false));
                    TP2Bed.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TP2Bed.mc.field_71439_g.field_70165_t, TP2Bed.mc.field_71439_g.field_70163_u, TP2Bed.mc.field_71439_g.field_70161_v, false));
                }
                TP2Bed.mc.field_71439_g.field_70122_E = false;
                Class206.setMotion(0.0);
                TP2Bed.mc.field_71439_g.field_70747_aH = 0.0f;
            }
            this.fuckingBed = this.posList.get(0);
        }
        catch (Throwable t) {
            this.set(false);
        }
    }
    
    @EventTarget
    public void onPacket(final EventPacket eventPacket) {
        if (eventPacket.getPacket() instanceof C03PacketPlayer) {}
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        try {
            for (final Class235 class235 : this.path) {
                TP2Bed.mc.func_175598_ae();
                final double n = class235.getX() - ((IRenderManager)TP2Bed.mc.func_175598_ae()).getRenderPosX();
                TP2Bed.mc.func_175598_ae();
                final double n2 = class235.getY() - ((IRenderManager)TP2Bed.mc.func_175598_ae()).getRenderPosY();
                TP2Bed.mc.func_175598_ae();
                Class284.drawEntityESP(n, n2, class235.getZ() - ((IRenderManager)TP2Bed.mc.func_175598_ae()).getRenderPosZ(), TP2Bed.mc.field_71439_g.func_174813_aQ().field_72336_d - TP2Bed.mc.field_71439_g.func_174813_aQ().field_72340_a, TP2Bed.mc.field_71439_g.func_174813_aQ().field_72337_e - TP2Bed.mc.field_71439_g.func_174813_aQ().field_72338_b + 0.25, 0.0f, 1.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.0f, 1.0f, 2.0f);
            }
        }
        catch (Exception ex) {}
    }
    
    @Override
    protected void onDisable() {
        Class296.canSendMotionPacket = true;
        super.onDisable();
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        for (final BlockPos blockPos : this.posList) {
            if (!(TP2Bed.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockBed)) {
                Class295.tellPlayer("§b[Hanabi]Destory!" + blockPos);
                this.posList.remove(blockPos);
                this.posList.sort(this::lambda$onUpdate$1);
                this.fuckingBed = this.posList.get(0);
            }
        }
        if (TP2Bed.mc.field_71439_g.func_70011_f((double)this.fuckingBed.func_177958_n(), (double)this.fuckingBed.func_177956_o(), (double)this.fuckingBed.func_177952_p()) < 4.0) {
            Class296.canSendMotionPacket = true;
            Class295.tellPlayer("§b[Hanabi]Teleported! :3");
            this.set(false);
        }
        if (this.timer.isDelayComplete(this.delay.getValueState())) {
            this.path = this.computePath(new Class235(TP2Bed.mc.field_71439_g.field_70165_t, TP2Bed.mc.field_71439_g.field_70163_u, TP2Bed.mc.field_71439_g.field_70161_v), new Class235((double)(this.fuckingBed.func_177958_n() + 1), (double)this.fuckingBed.func_177956_o(), (double)(this.fuckingBed.func_177952_p() + 1)));
            if (TP2Bed.mc.field_71439_g.func_70011_f((double)this.fuckingBed.func_177958_n(), (double)this.fuckingBed.func_177956_o(), (double)this.fuckingBed.func_177952_p()) > 4.0) {
                Class295.tellPlayer("§b[Hanabi]Trying to teleport...");
                Class296.canSendMotionPacket = false;
                for (final Class235 class235 : this.path) {
                    TP2Bed.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(class235.getX(), class235.getY(), class235.getZ(), true));
                }
            }
            this.timer.reset();
        }
        if (this.posList.size() == 0) {
            this.set(false);
        }
    }
    
    public double getDistanceToBlock(final BlockPos blockPos) {
        return TP2Bed.mc.field_71439_g.func_70011_f((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
    }
    
    private boolean canPassThrow(final BlockPos blockPos) {
        final Block func_177230_c = Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p())).func_177230_c();
        return func_177230_c.func_149688_o() == Material.field_151579_a || func_177230_c.func_149688_o() == Material.field_151585_k || func_177230_c.func_149688_o() == Material.field_151582_l || func_177230_c == Blocks.field_150468_ap || func_177230_c == Blocks.field_150355_j || func_177230_c == Blocks.field_150358_i || func_177230_c == Blocks.field_150444_as || func_177230_c == Blocks.field_150472_an;
    }
    
    private ArrayList<Class235> computePath(Class235 addVector, final Class235 class235) {
        if (!this.canPassThrow(new BlockPos(addVector.mc()))) {
            addVector = addVector.addVector(0.0, 1.0, 0.0);
        }
        final Class101 class236 = new Class101(addVector, class235);
        class236.compute();
        int n = 0;
        Class235 class237 = null;
        Class235 class238 = null;
        final ArrayList<Class235> list = new ArrayList<Class235>();
        final ArrayList<Class235> path = class236.getPath();
        for (final Class235 class239 : path) {
            if (n == 0 || n == path.size() - 1) {
                if (class237 != null) {
                    list.add(class237.addVector(0.5, 0.0, 0.5));
                }
                list.add(class239.addVector(0.5, 0.0, 0.5));
                class238 = class239;
            }
            else {
                boolean b = true;
                Label_0399: {
                    if (class239.squareDistanceTo(class238) > 25.0) {
                        b = false;
                    }
                    else {
                        final double min = Math.min(class238.getX(), class239.getX());
                        final double min2 = Math.min(class238.getY(), class239.getY());
                        final double min3 = Math.min(class238.getZ(), class239.getZ());
                        final double max = Math.max(class238.getX(), class239.getX());
                        final double max2 = Math.max(class238.getY(), class239.getY());
                        final double max3 = Math.max(class238.getZ(), class239.getZ());
                        for (int n2 = (int)min; n2 <= max; ++n2) {
                            for (int n3 = (int)min2; n3 <= max2; ++n3) {
                                for (int n4 = (int)min3; n4 <= max3; ++n4) {
                                    if (!Class101.checkPositionValidity(n2, n3, n4, false)) {
                                        b = false;
                                        break Label_0399;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!b) {
                    list.add(class237.addVector(0.5, 0.0, 0.5));
                    class238 = class237;
                }
            }
            class237 = class239;
            ++n;
        }
        return list;
    }
    
    private int lambda$onUpdate$1(final BlockPos blockPos, final BlockPos blockPos2) {
        return (int)(this.getDistanceToBlock(blockPos) - this.getDistanceToBlock(blockPos2));
    }
    
    private int lambda$onEnable$0(final BlockPos blockPos, final BlockPos blockPos2) {
        return (int)(this.getDistanceToBlock(blockPos) - this.getDistanceToBlock(blockPos2));
    }
}
