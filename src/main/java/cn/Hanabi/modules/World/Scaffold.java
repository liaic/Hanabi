package cn.Hanabi.modules.World;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import cn.Hanabi.injection.interfaces.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.network.play.client.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;
import ClassSub.*;
import net.minecraft.block.*;

public class Scaffold extends Mod
{
    public Value<Boolean> tower;
    public Value<Boolean> noswing;
    public static Value<String> mode;
    public static float yaw;
    public static float pitch;
    public static List<Block> blacklistedBlocks;
    private Class191 timer;
    public static ItemStack currentlyHolding;
    Class191 tDelay;
    Class241 blockdata;
    double y;
    boolean sneaking;
    int count;
    boolean isSneaking;
    int theSlot;
    int slot;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static List<Block> getBlacklistedBlocks() {
        return Scaffold.blacklistedBlocks;
    }
    
    public Scaffold() {
        super("Scaffold", Category.WORLD);
        this.tower = new Value<Boolean>("Scaffold_Tower", true);
        this.noswing = new Value<Boolean>("Scaffold_NoSwing", true);
        this.timer = new Class191();
        this.tDelay = new Class191();
        this.theSlot = -1;
        Scaffold.mode.addValue("HypixelCN");
        Scaffold.mode.addValue("HypixelGlobal");
        Scaffold.mode.addValue("AAC");
        this.setState(true);
        Scaffold.blacklistedBlocks = Arrays.asList(Blocks.field_150350_a, Blocks.field_150355_j, Blocks.field_150358_i, Blocks.field_150353_l, Blocks.field_150356_k, Blocks.field_150381_bn, Blocks.field_150404_cg, Blocks.field_150410_aZ, Blocks.field_150397_co, Blocks.field_150411_aY, Blocks.field_150431_aC, Blocks.field_150432_aD, Blocks.field_150403_cj, Blocks.field_150365_q, Blocks.field_150482_ag, Blocks.field_150412_bA, Blocks.field_150486_ae, Blocks.field_150447_bR, Blocks.field_150478_aa, Blocks.field_150467_bQ, Blocks.field_150447_bR, Blocks.field_150323_B, Blocks.field_150421_aI, Blocks.field_150335_W, Blocks.field_150352_o, Blocks.field_150366_p, Blocks.field_150369_x, Blocks.field_150439_ay, Blocks.field_150449_bY, Blocks.field_150450_ax, Blocks.field_150452_aw, Blocks.field_150456_au, Blocks.field_150445_bS, Blocks.field_150443_bT, Blocks.field_150430_aB, Blocks.field_150471_bO, Blocks.field_150442_at, Blocks.field_150329_H, Blocks.field_150473_bD, Blocks.field_150479_bC, Blocks.field_150448_aq, Blocks.field_150392_bi, Blocks.field_150328_O, Blocks.field_150337_Q, Blocks.field_150338_P, Blocks.field_150395_bd, Blocks.field_150415_aT, Blocks.field_150327_N, Blocks.field_150468_ap, Blocks.field_150460_al, Blocks.field_150354_m, Blocks.field_150434_aF, Blocks.field_150367_z, Blocks.field_150323_B, Blocks.field_150409_cd, Blocks.field_150462_ai, Blocks.field_150321_G, Blocks.field_150423_aK, Blocks.field_150345_g, Blocks.field_150463_bK, Blocks.field_180407_aO);
    }
    
    public void onEnable() {
        this.tDelay.reset();
        Scaffold.yaw = 999.0f;
        Scaffold.pitch = 999.0f;
        this.count = 1;
        this.blockdata = null;
        if (Scaffold.mc.field_71439_g != null) {
            this.y = Scaffold.mc.field_71439_g.field_70163_u;
        }
        this.sneaking = true;
        super.onEnable();
    }
    
    public void onDisable() {
        Scaffold.yaw = 999.0f;
        Scaffold.pitch = 999.0f;
        this.blockdata = null;
        Class296.getTimer().field_74278_d = 1.0f;
        if (this.sneaking && !Scaffold.mc.field_71439_g.func_70093_af()) {
            Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)Scaffold.mc.field_71439_g, C0BPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (Scaffold.mc.field_71439_g.field_82175_bq) {
            Scaffold.mc.field_71439_g.field_70733_aJ = 0.0f;
            Scaffold.mc.field_71439_g.field_110158_av = 0;
            Scaffold.mc.field_71439_g.field_82175_bq = false;
        }
    }
    
    @EventTarget
    public void onPre(final EventPreMotion eventPreMotion) {
        this.getBestBlocks();
        if (this.sneaking && !Scaffold.mc.field_71439_g.func_70093_af()) {
            Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)Scaffold.mc.field_71439_g, C0BPacketEntityAction.Action.STOP_SNEAKING));
            this.sneaking = !this.sneaking;
        }
        if (!this.hotbarContainBlock()) {
            this.blockdata = null;
            return;
        }
        if (((IKeyBinding)Scaffold.mc.field_71474_y.field_74311_E).getPress() && Class295.MovementInput()) {
            Class295.setSpeed(Class295.getBaseMoveSpeed() * 0.6);
            this.isSneaking = true;
        }
        else {
            this.isSneaking = false;
        }
        double n = Scaffold.mc.field_71439_g.field_70165_t;
        double n2 = Scaffold.mc.field_71439_g.field_70161_v;
        final double n3 = (double)Scaffold.mc.field_71439_g.field_71158_b.field_78900_b;
        final double n4 = (double)Scaffold.mc.field_71439_g.field_71158_b.field_78902_a;
        final float field_70177_z = Scaffold.mc.field_71439_g.field_70177_z;
        if (!Scaffold.mc.field_71439_g.field_70123_F) {
            final double[] array = (double[])this.getExpandCoords(n, n2, n3, n4, field_70177_z);
            n = array[0];
            n2 = array[1];
        }
        if (this.isAirBlock(Scaffold.mc.field_71441_e.func_180495_p(new BlockPos(Scaffold.mc.field_71439_g.field_70165_t, Scaffold.mc.field_71439_g.field_70163_u - 1.0 - (this.isSneaking ? 0.01 : 0.0), Scaffold.mc.field_71439_g.field_70161_v)).func_177230_c())) {
            n = Scaffold.mc.field_71439_g.field_70165_t;
            n2 = Scaffold.mc.field_71439_g.field_70161_v;
        }
        this.y = Scaffold.mc.field_71439_g.field_70163_u;
        final BlockPos blockPos = new BlockPos(n, this.y - 1.0 - (this.isSneaking ? 0.01 : 0.0), n2);
        final Block func_177230_c = Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final Class241 blockData = this.getBlockData(blockPos);
        this.setSpeed("Hypixel", eventPreMotion);
        if (this.getBlockCount() > 0 && this.tower.getValueState() && !Class295.isMoving2() && !Class295.isMoving2()) {
            this.tower("Hypixel", eventPreMotion);
        }
        if (blockData != null && this.isAirBlock(func_177230_c)) {
            this.blockdata = blockData;
            final float[] array2 = (float[])getRotations(blockData.position, blockData.face);
            eventPreMotion.setYaw(array2[0] + (float)randomNumber(1.0, -1.0));
            eventPreMotion.setPitch(array2[1]);
            Scaffold.yaw = array2[0];
            Scaffold.pitch = array2[1];
            if (!((IKeyBinding)Scaffold.mc.field_71474_y.field_74314_A).getPress() && Scaffold.mc.field_71439_g.field_70122_E && Class206.isOnGround(0.001) && Scaffold.mc.field_71439_g.field_70124_G) {
                eventPreMotion.setOnGround(false);
            }
        }
        if (Class295.MovementInput() && !Scaffold.mode.isCurrentMode("HypixelCN") && Scaffold.mode.isCurrentMode("AAC")) {
            Class295.setSpeed(0.11);
        }
    }
    
    @EventTarget
    public void onPost(final EventPostMotion eventPostMotion) {
        if (!this.tDelay.isDelayComplete(80L) && Class206.isOnGround(0.01) && !((IKeyBinding)Scaffold.mc.field_71474_y.field_74314_A).getPress()) {
            return;
        }
        final BlockPos blockPos = new BlockPos(Scaffold.mc.field_71439_g.field_70165_t, this.y - 1.0 - (this.isSneaking ? 0.01 : 0.0), Scaffold.mc.field_71439_g.field_70161_v);
        final Block func_177230_c = Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final Class241 blockData = this.getBlockData(blockPos);
        this.tDelay.reset();
        final int field_70461_c = Scaffold.mc.field_71439_g.field_71071_by.field_70461_c;
        final ItemStack itemStack = new ItemStack(Item.func_150899_d(261));
        this.theSlot = -1;
        try {
            for (int i = 36; i < 45; ++i) {
                this.theSlot = i - 36;
                final Container field_71069_bz = Scaffold.mc.field_71439_g.field_71069_bz;
                if (!Container.func_94527_a(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i), itemStack, true) && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b() instanceof ItemBlock && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c() != null && this.isValid(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b()) && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().field_77994_a != 0) {
                    break;
                }
            }
        }
        catch (Exception ex) {}
        try {
            if (!(Scaffold.mc.field_71439_g.field_71071_by.func_70301_a(this.theSlot).func_77973_b() instanceof ItemBlock)) {
                Class295.tellPlayer("§b[Hanabi]没方块了好兄弟");
                this.set(false);
                return;
            }
        }
        catch (Exception ex2) {
            Class295.tellPlayer("§b[Hanabi]没方块了好兄弟");
            this.set(false);
            return;
        }
        ++this.count;
        if (blockData != null) {
            if (this.isAirBlock(func_177230_c)) {
                final boolean b = Scaffold.mc.field_71439_g.field_71071_by.field_70461_c != this.theSlot;
                if (b) {
                    Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(this.theSlot));
                }
                Scaffold.currentlyHolding = Scaffold.mc.field_71439_g.field_71071_by.func_70301_a(this.theSlot);
                Scaffold.mc.field_71442_b.func_178890_a(Scaffold.mc.field_71439_g, Scaffold.mc.field_71441_e, Scaffold.mc.field_71439_g.field_71071_by.func_70301_a(this.theSlot), blockData.position, blockData.face, getVec3(blockData.position, blockData.face));
                if (b) {
                    Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(Scaffold.mc.field_71439_g.field_71071_by.field_70461_c));
                }
                if (this.timer.isDelayComplete(250L)) {
                    this.timer.reset();
                }
                if ((boolean)this.noswing.getValueState()) {
                    Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0APacketAnimation());
                }
                else {
                    Scaffold.mc.field_71439_g.func_71038_i();
                }
            }
        }
        else {
            Scaffold.currentlyHolding = null;
        }
    }
    
    @EventTarget
    public void onPacket(final EventPacket eventPacket) {
        final Packet packet = eventPacket.getPacket();
        if (packet instanceof C09PacketHeldItemChange) {
            final C09PacketHeldItemChange c09PacketHeldItemChange = (C09PacketHeldItemChange)packet;
        }
    }
    
    @EventTarget
    public void onSafe(final EventSafeWalk eventSafeWalk) {
        if (!this.isSneaking) {
            eventSafeWalk.setSafe(true);
        }
    }
    
    @EventTarget
    public void onMove(final EventMove eventMove) {
        if (Scaffold.mode.isCurrentMode("HypixelGlobal")) {
            eventMove.x *= 0.75;
            eventMove.z *= 0.75;
        }
    }
    
    protected void swap(final int n, final int n2) {
        Scaffold.mc.field_71442_b.func_78753_a(Scaffold.mc.field_71439_g.field_71069_bz.field_75152_c, n, n2, 2, (EntityPlayer)Scaffold.mc.field_71439_g);
    }
    
    private boolean invCheck() {
        for (int i = 36; i < 45; ++i) {
            if (Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                final Item func_77973_b = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b();
                if (func_77973_b instanceof ItemBlock && this.isValid(func_77973_b)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getBlockCount() {
        int n = 0;
        for (int i = 0; i < 45; ++i) {
            if (Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                final Item func_77973_b = func_75211_c.func_77973_b();
                if (func_75211_c.func_77973_b() instanceof ItemBlock && this.isValid(func_77973_b)) {
                    n += func_75211_c.field_77994_a;
                }
            }
        }
        return n;
    }
    
    public boolean isAirBlock(final Block block) {
        return block.func_149688_o().func_76222_j() && (!(block instanceof BlockSnow) || block.func_149669_A() <= 0.125);
    }
    
    public int getBiggestBlockSlotInv() {
        int n = -1;
        int field_77994_a = 0;
        if (this.getBlockCount() == 0) {
            return -1;
        }
        for (int i = 9; i < 36; ++i) {
            if (Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                final Item func_77973_b = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b();
                final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                if (func_77973_b instanceof ItemBlock && this.isValid(func_77973_b) && func_75211_c.field_77994_a > field_77994_a) {
                    field_77994_a = func_75211_c.field_77994_a;
                    n = i;
                }
            }
        }
        return n;
    }
    
    public int getBiggestBlockSlotHotbar() {
        int n = -1;
        int field_77994_a = 0;
        if (this.getBlockCount() == 0) {
            return -1;
        }
        for (int i = 36; i < 45; ++i) {
            if (Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                final Item func_77973_b = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b();
                final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                if (func_77973_b instanceof ItemBlock && this.isValid(func_77973_b) && func_75211_c.field_77994_a > field_77994_a) {
                    field_77994_a = func_75211_c.field_77994_a;
                    n = i;
                }
            }
        }
        return n;
    }
    
    public void getBestBlocks() {
        if (this.getBlockCount() == 0) {
            return;
        }
        final ItemStack itemStack = new ItemStack(Item.func_150899_d(261));
        final int biggestBlockSlotInv = this.getBiggestBlockSlotInv();
        final int biggestBlockSlotHotbar = this.getBiggestBlockSlotHotbar();
        int n = (this.getBiggestBlockSlotHotbar() > 0) ? this.getBiggestBlockSlotHotbar() : this.getBiggestBlockSlotInv();
        int n2 = 42;
        if (biggestBlockSlotHotbar > 0 && biggestBlockSlotInv > 0 && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(biggestBlockSlotInv).func_75216_d() && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(biggestBlockSlotHotbar).func_75216_d() && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(biggestBlockSlotHotbar).func_75211_c().field_77994_a < Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(biggestBlockSlotInv).func_75211_c().field_77994_a) {
            n = biggestBlockSlotInv;
        }
        if (this.hotbarContainBlock()) {
            for (int i = 36; i < 45; ++i) {
                if (Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                    final Item func_77973_b = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b();
                    if (func_77973_b instanceof ItemBlock && this.isValid(func_77973_b)) {
                        n2 = i;
                        break;
                    }
                }
            }
        }
        else {
            for (int j = 36; j < 45; ++j) {
                if (!Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(j).func_75216_d()) {
                    n2 = j;
                    break;
                }
            }
        }
        if (Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n2).field_75222_d != n) {
            this.swap(n, n2 - 36);
            Scaffold.mc.field_71442_b.func_78765_e();
        }
    }
    
    public static Vec3 getVec3(final BlockPos blockPos, final EnumFacing enumFacing) {
        final double n = blockPos.func_177958_n() + 0.5;
        final double n2 = blockPos.func_177956_o() + 0.5;
        final double n3 = blockPos.func_177952_p() + 0.5;
        double n4 = n + enumFacing.func_82601_c() / 2.0;
        double n5 = n3 + enumFacing.func_82599_e() / 2.0;
        double n6 = n2 + enumFacing.func_96559_d() / 2.0;
        if (enumFacing == EnumFacing.UP || enumFacing == EnumFacing.DOWN) {
            n4 += randomNumber(0.3, -0.3);
            n5 += randomNumber(0.3, -0.3);
        }
        else {
            n6 += randomNumber(0.3, -0.3);
        }
        if (enumFacing == EnumFacing.WEST || enumFacing == EnumFacing.EAST) {
            n5 += randomNumber(0.3, -0.3);
        }
        if (enumFacing == EnumFacing.SOUTH || enumFacing == EnumFacing.NORTH) {
            n4 += randomNumber(0.3, -0.3);
        }
        return new Vec3(n4, n6, n5);
    }
    
    private boolean isPosSolid(final BlockPos blockPos) {
        final Block func_177230_c = Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        return (func_177230_c.func_149688_o().func_76220_a() || !func_177230_c.func_149751_l() || func_177230_c.func_149686_d() || func_177230_c instanceof BlockLadder || func_177230_c instanceof BlockCarpet || func_177230_c instanceof BlockSnow || func_177230_c instanceof BlockSkull) && !func_177230_c.func_149688_o().func_76224_d() && !(func_177230_c instanceof BlockContainer);
    }
    
    private void ItemSpoof() {
        final ItemStack itemStack = new ItemStack(Item.func_150899_d(261));
        try {
            int i = 36;
            while (i < 45) {
                final int field_70461_c = i - 36;
                final Container field_71069_bz = Scaffold.mc.field_71439_g.field_71069_bz;
                if (!Container.func_94527_a(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i), itemStack, true) && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b() instanceof ItemBlock && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c() != null && this.isValid(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b()) && Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().field_77994_a != 0) {
                    if (Scaffold.mc.field_71439_g.field_71071_by.field_70461_c != field_70461_c) {
                        Scaffold.mc.field_71439_g.field_71071_by.field_70461_c = field_70461_c;
                        Scaffold.mc.field_71442_b.func_78765_e();
                        break;
                    }
                    break;
                }
                else {
                    ++i;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public static float[] getRotations(final BlockPos blockPos, final EnumFacing enumFacing) {
        final double n = blockPos.func_177958_n() + 0.5 - Scaffold.mc.field_71439_g.field_70165_t + enumFacing.func_82601_c() / 2.0;
        final double n2 = blockPos.func_177952_p() + 0.5 - Scaffold.mc.field_71439_g.field_70161_v + enumFacing.func_82599_e() / 2.0;
        final double n3 = Scaffold.mc.field_71439_g.field_70163_u + Scaffold.mc.field_71439_g.func_70047_e() - (blockPos.func_177956_o() + 0.5);
        final double n4 = (double)MathHelper.func_76133_a(n * n + n2 * n2);
        float n5 = (float)(Math.atan2(n2, n) * 180.0 / 3.141592653589793) - 90.0f;
        final float n6 = (float)(Math.atan2(n3, n4) * 180.0 / 3.141592653589793);
        if (n5 < 0.0f) {
            n5 += 360.0f;
        }
        return new float[] { n5, n6 };
    }
    
    private boolean hotbarContainBlock() {
        int i = 36;
        while (i < 45) {
            try {
                final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                if (func_75211_c == null || func_75211_c.func_77973_b() == null || !(func_75211_c.func_77973_b() instanceof ItemBlock) || !this.isValid(func_75211_c.func_77973_b())) {
                    ++i;
                    continue;
                }
                return true;
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
        return false;
    }
    
    private boolean isValid(final Item item) {
        return item instanceof ItemBlock && !Scaffold.blacklistedBlocks.contains(((ItemBlock)item).func_179223_d());
    }
    
    public void tower(final String s, final EventPreMotion eventPreMotion) {
        final BlockPos blockPos = new BlockPos(Scaffold.mc.field_71439_g.field_70165_t, Scaffold.mc.field_71439_g.field_70163_u - 1.0, Scaffold.mc.field_71439_g.field_70161_v);
        final Block func_177230_c = Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final Class241 blockData = this.getBlockData(blockPos);
        if (!((IKeyBinding)Scaffold.mc.field_71474_y.field_74314_A).getPress()) {
            if (Class295.isMoving2() && s.equalsIgnoreCase("Hypixel")) {
                if (Class206.isOnGround(0.76) && !Class206.isOnGround(0.75) && Scaffold.mc.field_71439_g.field_70181_x > 0.23 && Scaffold.mc.field_71439_g.field_70181_x < 0.25) {
                    Scaffold.mc.field_71439_g.field_70181_x = Math.round(Scaffold.mc.field_71439_g.field_70163_u) - Scaffold.mc.field_71439_g.field_70163_u;
                }
                if (!Class206.isOnGround(1.0E-4)) {
                    if (Scaffold.mc.field_71439_g.field_70181_x > 0.1 && Scaffold.mc.field_71439_g.field_70163_u >= Math.round(Scaffold.mc.field_71439_g.field_70163_u) - 1.0E-4 && Scaffold.mc.field_71439_g.field_70163_u <= Math.round(Scaffold.mc.field_71439_g.field_70163_u) + 1.0E-4) {
                        Scaffold.mc.field_71439_g.field_70181_x = 0.0;
                    }
                }
            }
            return;
        }
        if (s.equalsIgnoreCase("Hypixel")) {
            if (Class295.isMoving2()) {
                if (Class206.isOnGround(0.76) && !Class206.isOnGround(0.75) && Scaffold.mc.field_71439_g.field_70181_x > 0.23 && Scaffold.mc.field_71439_g.field_70181_x < 0.25) {
                    Scaffold.mc.field_71439_g.field_70181_x = Math.round(Scaffold.mc.field_71439_g.field_70163_u) - Scaffold.mc.field_71439_g.field_70163_u;
                }
                if (Class206.isOnGround(1.0E-4)) {
                    Scaffold.mc.field_71439_g.field_70181_x = 0.41993956416514;
                    final EntityPlayerSP field_71439_g = Scaffold.mc.field_71439_g;
                    field_71439_g.field_70159_w *= 0.9;
                    final EntityPlayerSP field_71439_g2 = Scaffold.mc.field_71439_g;
                    field_71439_g2.field_70179_y *= 0.9;
                }
                else if (Scaffold.mc.field_71439_g.field_70163_u >= Math.round(Scaffold.mc.field_71439_g.field_70163_u) - 1.0E-4 && Scaffold.mc.field_71439_g.field_70163_u <= Math.round(Scaffold.mc.field_71439_g.field_70163_u) + 1.0E-4) {
                    Scaffold.mc.field_71439_g.field_70181_x = 0.0;
                }
            }
            else {
                Scaffold.mc.field_71439_g.field_70159_w = 0.0;
                Scaffold.mc.field_71439_g.field_70179_y = 0.0;
                Scaffold.mc.field_71439_g.field_70747_aH = 0.0f;
                if (this.isAirBlock(func_177230_c) && blockData != null) {
                    Scaffold.mc.field_71439_g.field_70181_x = 0.4195751556457;
                    final EntityPlayerSP field_71439_g3 = Scaffold.mc.field_71439_g;
                    field_71439_g3.field_70159_w *= 0.75;
                    final EntityPlayerSP field_71439_g4 = Scaffold.mc.field_71439_g;
                    field_71439_g4.field_70179_y *= 0.75;
                }
            }
        }
    }
    
    public void setSpeed(final String s, final EventPreMotion eventPreMotion) {
        final double field_70159_w = Scaffold.mc.field_71439_g.field_70159_w;
        final double field_70179_y = Scaffold.mc.field_71439_g.field_70179_y;
    }
    
    public double[] getExpandCoords(final double n, final double n2, final double n3, final double n4, final float n5) {
        Block block = Scaffold.mc.field_71441_e.func_180495_p(new BlockPos(n, Scaffold.mc.field_71439_g.field_70163_u - 1.0, n2)).func_177230_c();
        double n6 = -999.0;
        double n7 = -999.0;
        double n8 = 0.0;
        final double n9 = 0.8;
        while (!this.isAirBlock(block)) {
            ++n8;
            if (n8 > n9) {
                n8 = n9;
            }
            n6 = n + (n3 * 0.45 * Math.cos(Math.toRadians((double)(n5 + 90.0f))) + n4 * 0.45 * Math.sin(Math.toRadians((double)(n5 + 90.0f)))) * n8;
            n7 = n2 + (n3 * 0.45 * Math.sin(Math.toRadians((double)(n5 + 90.0f))) - n4 * 0.45 * Math.cos(Math.toRadians((double)(n5 + 90.0f)))) * n8;
            if (n8 == n9) {
                break;
            }
            block = Scaffold.mc.field_71441_e.func_180495_p(new BlockPos(n6, Scaffold.mc.field_71439_g.field_70163_u - 1.0, n7)).func_177230_c();
        }
        return new double[] { n6, n7 };
    }
    
    public static double randomNumber(final double n, final double n2) {
        return Math.random() * (n - n2) + n2;
    }
    
    public Class241 getBlockData(BlockPos func_177977_b) {
        Object o = null;
        int n = 0;
        while (o == null) {
            if (n >= 2) {
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(0, 0, 1))) {
                o = new Class241(func_177977_b.func_177982_a(0, 0, 1), EnumFacing.NORTH, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(0, 0, -1))) {
                o = new Class241(func_177977_b.func_177982_a(0, 0, -1), EnumFacing.SOUTH, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(1, 0, 0))) {
                o = new Class241(func_177977_b.func_177982_a(1, 0, 0), EnumFacing.WEST, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(-1, 0, 0))) {
                o = new Class241(func_177977_b.func_177982_a(-1, 0, 0), EnumFacing.EAST, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(0, -1, 0))) {
                o = new Class241(func_177977_b.func_177982_a(0, -1, 0), EnumFacing.UP, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(0, 1, 0)) && this.isSneaking) {
                o = new Class241(func_177977_b.func_177982_a(0, 1, 0), EnumFacing.DOWN, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(0, 1, 1)) && this.isSneaking) {
                o = new Class241(func_177977_b.func_177982_a(0, 1, 1), EnumFacing.DOWN, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(0, 1, -1)) && this.isSneaking) {
                o = new Class241(func_177977_b.func_177982_a(0, 1, -1), EnumFacing.DOWN, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(1, 1, 0)) && this.isSneaking) {
                o = new Class241(func_177977_b.func_177982_a(1, 1, 0), EnumFacing.DOWN, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(-1, 1, 0)) && this.isSneaking) {
                o = new Class241(func_177977_b.func_177982_a(-1, 1, 0), EnumFacing.DOWN, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(1, 0, 1))) {
                o = new Class241(func_177977_b.func_177982_a(1, 0, 1), EnumFacing.NORTH, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(-1, 0, -1))) {
                o = new Class241(func_177977_b.func_177982_a(-1, 0, -1), EnumFacing.SOUTH, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(1, 0, 1))) {
                o = new Class241(func_177977_b.func_177982_a(1, 0, 1), EnumFacing.WEST, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(-1, 0, -1))) {
                o = new Class241(func_177977_b.func_177982_a(-1, 0, -1), EnumFacing.EAST, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(-1, 0, 1))) {
                o = new Class241(func_177977_b.func_177982_a(-1, 0, 1), EnumFacing.NORTH, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(1, 0, -1))) {
                o = new Class241(func_177977_b.func_177982_a(1, 0, -1), EnumFacing.SOUTH, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(1, 0, -1))) {
                o = new Class241(func_177977_b.func_177982_a(1, 0, -1), EnumFacing.WEST, (Class257)null);
                break;
            }
            if (!this.isBlockPosAir(func_177977_b.func_177982_a(-1, 0, 1))) {
                o = new Class241(func_177977_b.func_177982_a(-1, 0, 1), EnumFacing.EAST, (Class257)null);
                break;
            }
            func_177977_b = func_177977_b.func_177977_b();
            ++n;
        }
        return (Class241)o;
    }
    
    public boolean isBlockPosAir(final BlockPos blockPos) {
        return this.getBlockByPos(blockPos) == Blocks.field_150350_a || this.getBlockByPos(blockPos) instanceof BlockLiquid;
    }
    
    public Block getBlockByPos(final BlockPos blockPos) {
        return Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    public Vec3 getBlockSide(final BlockPos blockPos, final EnumFacing enumFacing) {
        if (enumFacing == EnumFacing.NORTH) {
            return new Vec3(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p() - 0.5);
        }
        if (enumFacing == EnumFacing.EAST) {
            return new Vec3(blockPos.func_177958_n() + 0.5, (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
        }
        if (enumFacing == EnumFacing.SOUTH) {
            return new Vec3(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p() + 0.5);
        }
        if (enumFacing == EnumFacing.WEST) {
            return new Vec3(blockPos.func_177958_n() - 0.5, (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
        }
        return new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
    }
    
    static {
        Scaffold.mode = new Value<String>("Scaffold", "Mode", 0);
        Scaffold.yaw = 999.0f;
        Scaffold.pitch = 999.0f;
        Scaffold.currentlyHolding = null;
    }
}
