package cn.Hanabi.modules.World;

import cn.Hanabi.value.*;
import net.minecraft.block.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.modules.*;
import net.minecraft.init.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import io.netty.util.internal.*;
import cn.Hanabi.events.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import ClassSub.*;
import java.util.*;

public class Scaffold_ extends Mod
{
    private Class171 blockData;
    private Class191 time;
    private Class191 delay;
    private Class191 timer2;
    private Value<Boolean> tower;
    private Value<Boolean> noSwing;
    private Value<Boolean> nosprint;
    private Value<Boolean> aac;
    private double olddelay;
    private BlockPos blockpos;
    private EnumFacing facing;
    private boolean rotated;
    private boolean should;
    private static int[] Facing;
    public static List<Block> blacklistedBlocks;
    private Class191 spacetimer;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    @EventTarget
    public void onKey(final EventKey eventKey) {
        if (eventKey.getKey() == 57) {
            this.timer2.reset();
            this.spacetimer.reset();
        }
    }
    
    public Scaffold_() {
        super("Scaffold", Category.WORLD);
        this.time = new Class191();
        this.delay = new Class191();
        this.timer2 = new Class191();
        this.tower = new Value<Boolean>("Scaffold_Tower", true);
        this.noSwing = new Value<Boolean>("Scaffold_NoSwing", false);
        this.nosprint = new Value<Boolean>("Scaffold_NoSprint", false);
        this.aac = new Value<Boolean>("Scaffold_AAC", false);
        this.rotated = false;
        this.should = false;
        this.spacetimer = new Class191();
        if (Class69.password.length() < 32) {
            System.exit(0);
        }
    }
    
    private boolean couldBlockBePlaced() {
        final double field_70165_t = Scaffold_.mc.field_71439_g.field_70165_t;
        final double field_70161_v = Scaffold_.mc.field_71439_g.field_70161_v;
        final double doubleRandom = this.getDoubleRandom(0.12, 0.2);
        switch (((int[])Facing())[Scaffold_.mc.field_71439_g.func_174811_aO().ordinal()]) {
            case 3: {
                if (Scaffold_.mc.field_71441_e.func_180495_p(new BlockPos(Scaffold_.mc.field_71439_g.field_70165_t, Scaffold_.mc.field_71439_g.field_70163_u - 0.1, field_70161_v + doubleRandom)).func_177230_c() != Blocks.field_150350_a) {
                    break;
                }
                return true;
            }
            case 4: {
                if (Scaffold_.mc.field_71441_e.func_180495_p(new BlockPos(Scaffold_.mc.field_71439_g.field_70165_t, Scaffold_.mc.field_71439_g.field_70163_u - 0.1, field_70161_v - doubleRandom)).func_177230_c() != Blocks.field_150350_a) {
                    break;
                }
                return true;
            }
            case 5: {
                if (Scaffold_.mc.field_71441_e.func_180495_p(new BlockPos(field_70165_t + doubleRandom, Scaffold_.mc.field_71439_g.field_70163_u - 0.1, Scaffold_.mc.field_71439_g.field_70161_v)).func_177230_c() != Blocks.field_150350_a) {
                    break;
                }
                return true;
            }
            case 6: {
                if (Scaffold_.mc.field_71441_e.func_180495_p(new BlockPos(field_70165_t - doubleRandom, Scaffold_.mc.field_71439_g.field_70163_u - 0.1, Scaffold_.mc.field_71439_g.field_70161_v)).func_177230_c() != Blocks.field_150350_a) {
                    break;
                }
                return true;
            }
        }
        return false;
    }
    
    @EventTarget
    public void onPre(final EventPreMotion eventPreMotion) {
        if (Scaffold_.mc.field_71439_g != null) {
            this.blockData = this.getBlockData(new BlockPos((Vec3i)new BlockPos(Scaffold_.mc.field_71439_g.field_70165_t, Scaffold_.mc.field_71439_g.field_70163_u - 0.5, Scaffold_.mc.field_71439_g.field_70161_v)));
            final int blockItem = this.getBlockItem();
            if (this.nosprint.getValueState() || this.aac.getValueState()) {
                Scaffold_.mc.field_71439_g.func_70031_b(false);
            }
            final Item func_77973_b = Scaffold_.mc.field_71439_g.field_71071_by.func_70301_a(blockItem).func_77973_b();
            if (this.blockData != null && blockItem != -1 && func_77973_b != null && func_77973_b instanceof ItemBlock) {
                final Vec3 blockSide = this.getBlockSide(this.blockData.pos, this.blockData.face);
                final float[] array = (float[])Class229.getRotationsNeededBlock(blockSide.field_72450_a, blockSide.field_72448_b - 0.24, blockSide.field_72449_c);
                if (!(boolean)this.aac.getValueState()) {
                    eventPreMotion.yaw = array[0] / 1.101228f;
                    eventPreMotion.pitch = array[1] / 1.102311f;
                }
                if ((boolean)this.aac.getValueState()) {
                    if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74351_w).getPress()) {
                        eventPreMotion.yaw += 180.0f;
                        if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74370_x).getPress()) {
                            eventPreMotion.yaw -= 45.0f;
                        }
                        else if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74366_z).getPress()) {
                            eventPreMotion.yaw += 45.0f;
                        }
                    }
                    else if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74368_y).getPress()) {
                        eventPreMotion.yaw = Scaffold_.mc.field_71439_g.field_70177_z;
                        if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74370_x).getPress()) {
                            eventPreMotion.yaw += 45.0f;
                        }
                        else if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74366_z).getPress()) {
                            eventPreMotion.yaw -= 45.0f;
                        }
                    }
                    else if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74370_x).getPress()) {
                        eventPreMotion.yaw += 90.0f;
                    }
                    else if (((IKeyBinding)Scaffold_.mc.field_71474_y.field_74366_z).getPress()) {
                        eventPreMotion.yaw -= 90.0f;
                    }
                    eventPreMotion.yaw += new Random().nextInt(5);
                    eventPreMotion.pitch = 82 + new Random().nextInt(3);
                    if (Class295.MovementInput() && !(boolean)this.nosprint.getValueState()) {
                        Class295.setSpeed(0.11);
                    }
                }
            }
        }
        Scaffold_.mc.field_71439_g.field_70759_as = eventPreMotion.getYaw();
        Scaffold_.mc.field_71439_g.field_70761_aq = eventPreMotion.getYaw();
    }
    
    public Vec3 scale(final Vec3 vec3, final double n) {
        return new Vec3(vec3.field_72450_a * n, vec3.field_72448_b * n, vec3.field_72449_c * n);
    }
    
    @EventTarget
    public void onPost(final EventPostMotion eventPostMotion) {
        if (Scaffold_.mc.field_71439_g != null && this.blockData != null) {
            final int blockItem = this.getBlockItem();
            final Random random = new Random();
            final Item func_77973_b = Scaffold_.mc.field_71439_g.field_71071_by.func_70301_a(blockItem).func_77973_b();
            final boolean b = Scaffold_.mc.field_71439_g.field_71071_by.field_70461_c != blockItem;
            if (b) {
                Scaffold_.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(blockItem));
            }
            if (blockItem != -1 && func_77973_b != null && func_77973_b instanceof ItemBlock) {
                Vec3 vec3;
                if ((boolean)this.aac.getValueState()) {
                    vec3 = this.scale(new Vec3((Vec3i)this.blockData.pos).func_72441_c((double)(random.nextFloat() / 3.0f), (double)(random.nextFloat() / 3.0f), (double)(random.nextFloat() / 3.0f)).func_178787_e(new Vec3(this.blockData.face.func_176730_m())), random.nextFloat() / 3.0f);
                }
                else {
                    vec3 = this.scale(new Vec3((Vec3i)this.blockData.pos).func_72441_c(0.5, 0.5, 0.5).func_178787_e(new Vec3(this.blockData.face.func_176730_m())), 0.5);
                }
                if (Scaffold_.mc.field_71442_b.func_178890_a(Scaffold_.mc.field_71439_g, Scaffold_.mc.field_71441_e, Scaffold_.mc.field_71439_g.field_71071_by.func_70301_a(blockItem), this.blockData.pos, this.blockData.face, vec3) && (this.time.isDelayComplete(random.nextInt(300)) || !(boolean)this.aac.getValueState())) {
                    this.delay.reset();
                    this.blockData = null;
                    this.time.reset();
                    if (this.tower.getValueState() && !((IKeyBinding)Scaffold_.mc.field_71474_y.field_74366_z).getPress() && !((IKeyBinding)Scaffold_.mc.field_71474_y.field_74370_x).getPress() && !((IKeyBinding)Scaffold_.mc.field_71474_y.field_74351_w).getPress() && ((IKeyBinding)Scaffold_.mc.field_71474_y.field_74314_A).getPress()) {
                        final EntityPlayerSP field_71439_g = Scaffold_.mc.field_71439_g;
                        final EntityPlayerSP field_71439_g2 = Scaffold_.mc.field_71439_g;
                        final double n = 0.0;
                        field_71439_g2.field_70179_y = n;
                        field_71439_g.field_70159_w = n;
                        Scaffold_.mc.field_71439_g.field_70181_x = 0.4199323;
                        if (this.timer2.isDelayComplete(1500L)) {
                            Scaffold_.mc.field_71439_g.field_70181_x = -0.27994532;
                            this.timer2.reset();
                        }
                    }
                    if ((boolean)this.noSwing.getValueState()) {
                        Scaffold_.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0APacketAnimation());
                    }
                    else {
                        Scaffold_.mc.field_71439_g.func_71038_i();
                    }
                }
            }
            if (b) {
                this.sendCurrentItem();
            }
        }
        ((IMinecraft)Scaffold_.mc).setRightClickDelayTimer(6);
    }
    
    public float[] getIntaveRots(final BlockPos blockPos, final EnumFacing enumFacing) {
        double n = blockPos.func_177958_n() + 0.5;
        double n2 = blockPos.func_177956_o() + 0.5;
        double n3 = blockPos.func_177952_p() + 0.5;
        if (enumFacing != null) {
            if (EnumFacing.UP != null) {
                n2 += 0.5;
            }
            else if (EnumFacing.DOWN != null) {
                n2 -= 0.5;
            }
            else if (EnumFacing.WEST != null) {
                n += 0.5;
            }
            else if (EnumFacing.EAST != null) {
                n -= 0.5;
            }
            else if (EnumFacing.NORTH != null) {
                n3 += 0.5;
            }
            else if (EnumFacing.SOUTH != null) {
                n3 -= 0.5;
            }
        }
        final double n4 = n - Scaffold_.mc.field_71439_g.field_70165_t;
        final double n5 = n2 - Scaffold_.mc.field_71439_g.field_70163_u + Scaffold_.mc.field_71439_g.func_70047_e();
        final double n6 = n3 - Scaffold_.mc.field_71439_g.field_70161_v;
        return new float[] { MathHelper.func_76142_g((float)(Math.atan2(n6, n4) * 180.0 / 3.141592653589793) - 90.0f), MathHelper.func_76142_g((float)(-Math.atan2(n5, Math.sqrt(n4 * n4 + n6 * n6)) * 180.0 / 3.141592653589793)) };
    }
    
    private double getDoubleRandom(final double n, final double n2) {
        return ThreadLocalRandom.current().nextDouble(n, n2);
    }
    
    @EventTarget
    public void onSafe(final EventSafeWalk eventSafeWalk) {
        eventSafeWalk.setSafe(true);
    }
    
    private boolean canPlace(final EntityPlayerSP entityPlayerSP, final WorldClient worldClient, final ItemStack itemStack, final BlockPos blockPos, final EnumFacing enumFacing, final Vec3 vec3) {
        return itemStack.func_77973_b() instanceof ItemBlock && ((ItemBlock)itemStack.func_77973_b()).func_179222_a((World)worldClient, blockPos, enumFacing, (EntityPlayer)entityPlayerSP, itemStack);
    }
    
    private void setBlockAndFacing(final BlockPos blockPos) {
        if (Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(0, -1, 0)).func_177230_c() != Blocks.field_150350_a) {
            this.blockpos = blockPos.func_177982_a(0, -1, 0);
            this.facing = EnumFacing.UP;
        }
        else if (Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(-1, 0, 0)).func_177230_c() != Blocks.field_150350_a) {
            this.blockpos = blockPos.func_177982_a(-1, 0, 0);
            this.facing = EnumFacing.EAST;
        }
        else if (Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(1, 0, 0)).func_177230_c() != Blocks.field_150350_a) {
            this.blockpos = blockPos.func_177982_a(1, 0, 0);
            this.facing = EnumFacing.WEST;
        }
        else if (Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(0, 0, -1)).func_177230_c() != Blocks.field_150350_a) {
            this.blockpos = blockPos.func_177982_a(0, 0, -1);
            this.facing = EnumFacing.SOUTH;
        }
        else if (Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(0, 0, 1)).func_177230_c() != Blocks.field_150350_a) {
            this.blockpos = blockPos.func_177982_a(0, 0, 1);
            this.facing = EnumFacing.NORTH;
        }
        else {
            this.facing = null;
        }
    }
    
    private void sendCurrentItem() {
        Scaffold_.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(Scaffold_.mc.field_71439_g.field_71071_by.field_70461_c));
    }
    
    private int getBlockItem() {
        int n = -1;
        for (int i = 8; i >= 0; --i) {
            if (Scaffold_.mc.field_71439_g.field_71071_by.func_70301_a(i) != null && Scaffold_.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemBlock && !Scaffold_.blacklistedBlocks.contains(Block.func_149634_a(Scaffold_.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b()))) {
                n = i;
            }
        }
        return n;
    }
    
    private Class171 getBlockData(final BlockPos blockPos) {
        if (this.getBlockData(blockPos, 1) != null) {
            return this.getBlockData(blockPos, 1);
        }
        if (this.getBlockData(blockPos.func_177977_b(), 1) != null) {
            return this.getBlockData(blockPos.func_177977_b(), 1);
        }
        return null;
    }
    
    public Class171 getBlockData(final BlockPos blockPos, final int n) {
        return (Class171)((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(0, 0, n)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(0, 0, n), EnumFacing.NORTH) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(0, 0, -n)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(0, 0, -n), EnumFacing.SOUTH) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(n, 0, 0)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(n, 0, 0), EnumFacing.WEST) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(-n, 0, 0)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(-n, 0, 0), EnumFacing.EAST) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(0, -n, 0)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(0, -n, 0), EnumFacing.UP) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(1, 0, n)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(1, 0, n), EnumFacing.NORTH) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(-1, 0, -n)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(-1, 0, -n), EnumFacing.SOUTH) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(n, 0, 1)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(n, 0, 1), EnumFacing.WEST) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(-n, 0, -1)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(-n, 0, -1), EnumFacing.EAST) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(-1, 0, n)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(-1, 0, n), EnumFacing.NORTH) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(1, 0, -n)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(1, 0, -n), EnumFacing.SOUTH) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(n, 0, -1)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(n, 0, -1), EnumFacing.WEST) : ((Scaffold_.mc.field_71441_e.func_180495_p(blockPos.func_177982_a(-n, 0, 1)).func_177230_c() != Blocks.field_150350_a) ? new Class171(blockPos.func_177982_a(-n, 0, 1), EnumFacing.EAST) : null)))))))))))));
    }
    
    public Vec3 getBlockSide(final BlockPos blockPos, final EnumFacing enumFacing) {
        return (enumFacing == EnumFacing.NORTH) ? new Vec3(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p() - 0.5) : ((enumFacing == EnumFacing.EAST) ? new Vec3(blockPos.func_177958_n() + 0.5, (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p()) : ((enumFacing == EnumFacing.SOUTH) ? new Vec3(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p() + 0.5) : ((enumFacing == EnumFacing.WEST) ? new Vec3(blockPos.func_177958_n() - 0.5, (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p()) : new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p()))));
    }
    
    public void onEnable() {
        this.timer2.reset();
        super.onEnable();
    }
    
    public void onDisable() {
        super.onDisable();
        this.timer2.reset();
        this.sendCurrentItem();
        ((IKeyBinding)Scaffold_.mc.field_71474_y.field_74311_E).setPress(false);
        Class296.getTimer().field_74278_d = 1.0f;
    }
    
    static int[] Facing() {
        final int[] facing = Scaffold_.Facing;
        if (Scaffold_.Facing != null) {
            return facing;
        }
        final int[] facing2 = new int[((EnumFacing[])EnumFacing.values()).length];
        try {
            facing2[EnumFacing.DOWN.ordinal()] = 1;
            facing2[EnumFacing.EAST.ordinal()] = 6;
            facing2[EnumFacing.NORTH.ordinal()] = 3;
            facing2[EnumFacing.SOUTH.ordinal()] = 4;
            facing2[EnumFacing.UP.ordinal()] = 2;
            facing2[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        return Scaffold_.Facing = facing2;
    }
    
    static {
        Scaffold_.blacklistedBlocks = Arrays.asList(Blocks.field_150350_a, Blocks.field_150355_j, Blocks.field_150358_i, Blocks.field_150353_l, Blocks.field_150356_k, Blocks.field_150381_bn, Blocks.field_150404_cg, Blocks.field_150410_aZ, Blocks.field_150397_co, Blocks.field_150411_aY, Blocks.field_150431_aC, Blocks.field_150432_aD, Blocks.field_150403_cj, Blocks.field_150365_q, Blocks.field_150482_ag, Blocks.field_150412_bA, Blocks.field_150486_ae, Blocks.field_150478_aa, Blocks.field_150467_bQ, Blocks.field_150447_bR, Blocks.field_150323_B, Blocks.field_150421_aI, Blocks.field_150335_W, Blocks.field_150352_o, Blocks.field_150366_p, Blocks.field_150369_x, Blocks.field_150439_ay, Blocks.field_150449_bY, Blocks.field_150450_ax, Blocks.field_150452_aw, Blocks.field_150456_au, Blocks.field_150445_bS, Blocks.field_150443_bT, Blocks.field_150430_aB, Blocks.field_150471_bO, Blocks.field_150442_at, Blocks.field_150477_bB);
    }
}
