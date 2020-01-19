package cn.Hanabi.injection.mixins;

import net.minecraft.client.entity.*;
import net.minecraft.client.network.*;
import net.minecraft.world.*;
import com.mojang.authlib.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.World.*;
import ClassSub.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import org.spongepowered.asm.mixin.*;
import cn.Hanabi.modules.Movement.*;
import cn.Hanabi.*;
import net.minecraft.enchantment.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.boss.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.events.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.crash.*;

@Mixin({ EntityPlayerSP.class })
public class MixinEntityPlayerSP extends AbstractClientPlayer implements IEntityPlayerSP
{
    private double cachedX;
    private double cachedY;
    private double cachedZ;
    private float cachedRotationPitch;
    private float cachedRotationYaw;
    private int cacheSprintToggleTimer;
    private float cacheStrafe;
    private float cacheForward;
    private float cacheYaw;
    private float cachePitch;
    @Shadow
    protected int field_71156_d;
    @Shadow
    public MovementInput field_71158_b;
    @Shadow
    private boolean field_175171_bO;
    @Shadow
    @Final
    public NetHandlerPlayClient field_71174_a;
    @Shadow
    private boolean field_175170_bN;
    @Shadow
    private double field_175172_bI;
    @Shadow
    private double field_175166_bJ;
    @Shadow
    private double field_175167_bK;
    @Shadow
    private float field_175164_bL;
    @Shadow
    private float field_175165_bM;
    @Shadow
    private int field_175168_bP;
    
    public MixinEntityPlayerSP() {
        super((World)null, (GameProfile)null);
        this.cacheSprintToggleTimer = 0;
        this.cacheStrafe = 0.0f;
        this.cacheForward = 0.0f;
        this.cacheYaw = 0.0f;
        this.cachePitch = 0.0f;
    }
    
    @Inject(method = { "onUpdate" }, at = { @At("HEAD") })
    public void eventUpdate(final CallbackInfo info) {
        if (Minecraft.func_71410_x().field_71439_g != null && Minecraft.func_71410_x().field_71441_e != null) {
            final EventUpdate event = new EventUpdate();
            EventManager.call((Event)event);
        }
    }
    
    @Overwrite
    public void func_175161_p() {
        final boolean flag = this.func_70051_ag() && (!ModManager.getModule("Scaffold").getState() || !Scaffold.mode.isCurrentMode("HypixelGlobal"));
        final EventPreMotion pre = new EventPreMotion(this.field_70163_u, this.field_70177_z, this.field_70125_A, this.field_70122_E);
        EventManager.call((Event)pre);
        if (pre.cancel) {
            final EventPostMotion post = new EventPostMotion();
            EventManager.call((Event)post);
            return;
        }
        if (flag != this.field_175171_bO) {
            if (Class296.canSendMotionPacket) {
                if (flag) {
                    this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, C0BPacketEntityAction.Action.START_SPRINTING));
                }
                else {
                    this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, C0BPacketEntityAction.Action.STOP_SPRINTING));
                }
            }
            this.field_175171_bO = flag;
        }
        final boolean flag2 = this.func_70093_af();
        if (flag2 != this.field_175170_bN) {
            if (Class296.canSendMotionPacket) {
                if (flag2) {
                    this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, C0BPacketEntityAction.Action.START_SNEAKING));
                }
                else {
                    this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, C0BPacketEntityAction.Action.STOP_SNEAKING));
                }
            }
            this.field_175170_bN = flag2;
        }
        if (this.func_175160_A()) {
            final double d0 = this.field_70165_t - this.field_175172_bI;
            final double d2 = this.func_174813_aQ().field_72338_b - this.field_175166_bJ;
            final double d3 = this.field_70161_v - this.field_175167_bK;
            final double d4 = (double)(pre.yaw - this.field_175164_bL);
            final double d5 = (double)(pre.pitch - this.field_175165_bM);
            boolean flag3 = d0 * d0 + d2 * d2 + d3 * d3 > 9.0E-4 || this.field_175168_bP >= 20;
            final boolean flag4 = d4 != 0.0 || d5 != 0.0;
            if (Class296.canSendMotionPacket) {
                if (this.field_70154_o == null) {
                    if (flag3 && flag4) {
                        this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C06PacketPlayerPosLook(this.field_70165_t, pre.y, this.field_70161_v, pre.yaw, pre.pitch, pre.onGround));
                    }
                    else if (flag3) {
                        this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.field_70165_t, pre.y, this.field_70161_v, pre.onGround));
                    }
                    else if (flag4) {
                        this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C05PacketPlayerLook(pre.yaw, pre.pitch, pre.onGround));
                    }
                    else {
                        this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer(pre.onGround));
                    }
                }
                else {
                    this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C06PacketPlayerPosLook(this.field_70159_w, -999.0, this.field_70179_y, pre.yaw, pre.pitch, pre.onGround));
                    flag3 = false;
                }
            }
            ++this.field_175168_bP;
            if (flag3) {
                this.field_175172_bI = this.field_70165_t;
                this.field_175166_bJ = pre.y;
                this.field_175167_bK = this.field_70161_v;
                this.field_175168_bP = 0;
            }
            if (flag4) {
                this.field_175164_bL = pre.yaw;
                this.field_175165_bM = pre.pitch;
            }
            final EventPostMotion post2 = new EventPostMotion();
            EventManager.call((Event)post2);
        }
    }
    
    @Inject(method = { "onLivingUpdate" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/util/MovementInput;updatePlayerMoveState()V", shift = At.Shift.AFTER) })
    private void onNoSlowEnable(final CallbackInfo callbackInfo) {
        if (!this.isSlow()) {
            return;
        }
        if (((NoSlow)Hanabi.INSTANCE.moduleManager.getModule(NoSlow.class)).isEnabled()) {
            this.cacheStrafe = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_78902_a;
            this.cacheForward = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_78900_b;
        }
    }
    
    @Inject(method = { "onLivingUpdate" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;pushOutOfBlocks(DDD)Z", shift = At.Shift.BEFORE) })
    public void onToggledTimerZero(final CallbackInfo callbackInfo) {
        if (!this.isSlow()) {
            return;
        }
        if (((NoSlow)Hanabi.INSTANCE.moduleManager.getModule(NoSlow.class)).isEnabled()) {
            Minecraft.func_71410_x().field_71439_g.field_71158_b.field_78902_a = this.cacheStrafe;
            Minecraft.func_71410_x().field_71439_g.field_71158_b.field_78900_b = this.cacheForward;
        }
    }
    
    public final boolean isSlow() {
        return Minecraft.func_71410_x().field_71439_g.func_71039_bw() && !Minecraft.func_71410_x().field_71439_g.func_70115_ae();
    }
    
    @Shadow
    protected void func_110318_g() {
    }
    
    @Shadow
    public boolean func_175160_A() {
        return false;
    }
    
    @Shadow
    protected boolean func_145771_j(final double x, final double y, final double z) {
        return false;
    }
    
    public void func_71059_n(final Entity targetEntity) {
        if (targetEntity.func_70075_an() && !targetEntity.func_85031_j((Entity)this)) {
            float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            int i = 0;
            float f2 = 0.0f;
            if (targetEntity instanceof EntityLivingBase) {
                f2 = EnchantmentHelper.func_152377_a(this.func_70694_bm(), ((EntityLivingBase)targetEntity).func_70668_bt());
            }
            else {
                f2 = EnchantmentHelper.func_152377_a(this.func_70694_bm(), EnumCreatureAttribute.UNDEFINED);
            }
            i += EnchantmentHelper.func_77501_a((EntityLivingBase)this);
            if (this.func_70051_ag()) {
                ++i;
            }
            if (f > 0.0f || f2 > 0.0f) {
                final boolean flag = this.field_70143_R > 0.0f && !this.field_70122_E && !this.func_70617_f_() && !this.func_70090_H() && !this.func_70644_a(Potion.field_76440_q) && this.field_70154_o == null && targetEntity instanceof EntityLivingBase;
                if (flag && f > 0.0f) {
                    f *= 1.5f;
                }
                f += f2;
                boolean flag2 = false;
                final int j = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
                if (targetEntity instanceof EntityLivingBase && j > 0 && !targetEntity.func_70027_ad()) {
                    flag2 = true;
                    targetEntity.func_70015_d(1);
                }
                final double d0 = targetEntity.field_70159_w;
                final double d2 = targetEntity.field_70181_x;
                final double d3 = targetEntity.field_70179_y;
                final boolean flag3 = targetEntity.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this), f);
                if (flag3) {
                    if (i > 0) {
                        targetEntity.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927f / 180.0f) * i * 0.5f), 0.1, (double)(MathHelper.func_76134_b(this.field_70177_z * 3.1415927f / 180.0f) * i * 0.5f));
                        if (!((KeepSprint)Hanabi.INSTANCE.moduleManager.getModule(KeepSprint.class)).getState()) {
                            this.field_70159_w *= 0.6;
                            this.field_70179_y *= 0.6;
                            this.func_70031_b(false);
                        }
                    }
                    if (targetEntity instanceof EntityPlayerMP && targetEntity.field_70133_I) {
                        ((EntityPlayerMP)targetEntity).field_71135_a.func_147359_a((Packet)new S12PacketEntityVelocity(targetEntity));
                        targetEntity.field_70133_I = false;
                        targetEntity.field_70159_w = d0;
                        targetEntity.field_70181_x = d2;
                        targetEntity.field_70179_y = d3;
                    }
                    if (flag) {
                        this.func_71009_b(targetEntity);
                    }
                    if (f2 > 0.0f) {
                        this.func_71047_c(targetEntity);
                    }
                    if (f >= 18.0f) {
                        this.func_71029_a((StatBase)AchievementList.field_75999_E);
                    }
                    this.func_130011_c(targetEntity);
                    if (targetEntity instanceof EntityLivingBase) {
                        EnchantmentHelper.func_151384_a((EntityLivingBase)targetEntity, (Entity)this);
                    }
                    EnchantmentHelper.func_151385_b((EntityLivingBase)this, targetEntity);
                    final ItemStack itemstack = this.func_71045_bC();
                    Entity entity = targetEntity;
                    if (targetEntity instanceof EntityDragonPart) {
                        final IEntityMultiPart ientitymultipart = ((EntityDragonPart)targetEntity).field_70259_a;
                        if (ientitymultipart instanceof EntityLivingBase) {
                            entity = (Entity)ientitymultipart;
                        }
                    }
                    if (itemstack != null && entity instanceof EntityLivingBase) {
                        itemstack.func_77961_a((EntityLivingBase)entity, (EntityPlayer)this);
                        if (itemstack.field_77994_a <= 0) {
                            this.func_71028_bD();
                        }
                    }
                    if (targetEntity instanceof EntityLivingBase) {
                        this.func_71064_a(StatList.field_75951_w, Math.round(f * 10.0f));
                        if (j > 0) {
                            targetEntity.func_70015_d(j * 4);
                        }
                    }
                    this.func_71020_j(0.3f);
                }
                else if (flag2) {
                    targetEntity.func_70066_B();
                }
            }
        }
    }
    
    public float func_70111_Y() {
        final Hitbox hitBox = (Hitbox)Hanabi.INSTANCE.moduleManager.getModule(Hitbox.class);
        return hitBox.getState() ? Hitbox.getSize() : super.func_70111_Y();
    }
    
    public void func_70091_d(final double x, final double y, final double z) {
        final EventMove event = new EventMove(x, y, z);
        EventManager.call((Event)event);
        this.onMoveEntity(event.getX(), event.getY(), event.getZ());
    }
    
    public void onMoveEntity(double x, double y, double z) {
        if (this.field_70145_X) {
            this.func_174826_a(this.func_174813_aQ().func_72317_d(x, y, z));
            this.field_70165_t = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
            this.field_70163_u = this.func_174813_aQ().field_72338_b;
            this.field_70161_v = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
        }
        else {
            this.field_70170_p.field_72984_F.func_76320_a("move");
            final double d0 = this.field_70165_t;
            final double d2 = this.field_70163_u;
            final double d3 = this.field_70161_v;
            if (this.field_70134_J) {
                this.field_70134_J = false;
                x *= 0.25;
                y *= 0.05000000074505806;
                z *= 0.25;
                this.field_70159_w = 0.0;
                this.field_70181_x = 0.0;
                this.field_70179_y = 0.0;
            }
            final EventSafeWalk event = new EventSafeWalk(false);
            EventManager.call((Event)event);
            double d4 = x;
            final double d5 = y;
            double d6 = z;
            final boolean flag = this.field_70122_E && this.func_70093_af() && !ModManager.getModule("Scaffold").isEnabled() && this instanceof EntityPlayer;
            final boolean safeMode = this.field_70122_E && event.getSafe() && this instanceof EntityPlayer;
            if (flag || safeMode) {
                final double d7 = 0.05;
                while (x != 0.0 && this.field_70170_p.func_72945_a((Entity)this, this.func_174813_aQ().func_72317_d(x, -1.0, 0.0)).isEmpty()) {
                    if (x < d7 && x >= -d7) {
                        x = 0.0;
                    }
                    else if (x > 0.0) {
                        x -= d7;
                    }
                    else {
                        x += d7;
                    }
                    d4 = x;
                }
                while (z != 0.0 && this.field_70170_p.func_72945_a((Entity)this, this.func_174813_aQ().func_72317_d(0.0, -1.0, z)).isEmpty()) {
                    if (z < d7 && z >= -d7) {
                        z = 0.0;
                    }
                    else if (z > 0.0) {
                        z -= d7;
                    }
                    else {
                        z += d7;
                    }
                    d6 = z;
                }
                while (x != 0.0 && z != 0.0 && this.field_70170_p.func_72945_a((Entity)this, this.func_174813_aQ().func_72317_d(x, -1.0, z)).isEmpty()) {
                    if (x < d7 && x >= -d7) {
                        x = 0.0;
                    }
                    else if (x > 0.0) {
                        x -= d7;
                    }
                    else {
                        x += d7;
                    }
                    d4 = x;
                    if (z < d7 && z >= -d7) {
                        z = 0.0;
                    }
                    else if (z > 0.0) {
                        z -= d7;
                    }
                    else {
                        z += d7;
                    }
                    d6 = z;
                }
            }
            final List<AxisAlignedBB> list1 = (List<AxisAlignedBB>)this.field_70170_p.func_72945_a((Entity)this, this.func_174813_aQ().func_72321_a(x, y, z));
            final AxisAlignedBB axisalignedbb = this.func_174813_aQ();
            for (final AxisAlignedBB axisalignedbb2 : list1) {
                y = axisalignedbb2.func_72323_b(this.func_174813_aQ(), y);
            }
            this.func_174826_a(this.func_174813_aQ().func_72317_d(0.0, y, 0.0));
            final boolean flag2 = this.field_70122_E || (d5 != y && d5 < 0.0);
            for (final AxisAlignedBB axisalignedbb3 : list1) {
                x = axisalignedbb3.func_72316_a(this.func_174813_aQ(), x);
            }
            this.func_174826_a(this.func_174813_aQ().func_72317_d(x, 0.0, 0.0));
            for (final AxisAlignedBB axisalignedbb4 : list1) {
                z = axisalignedbb4.func_72322_c(this.func_174813_aQ(), z);
            }
            this.func_174826_a(this.func_174813_aQ().func_72317_d(0.0, 0.0, z));
            final EventStep es = new EventStep(true, this.field_70138_W);
            EventManager.call((Event)es);
            if (this.field_70138_W > 0.0f && flag2 && (d4 != x || d6 != z) && !es.isCancelled() && es.getStepHeight() > 0.0) {
                final double d8 = x;
                final double d9 = y;
                final double d10 = z;
                final AxisAlignedBB axisalignedbb5 = this.func_174813_aQ();
                this.func_174826_a(axisalignedbb);
                y = es.getStepHeight();
                final List<AxisAlignedBB> list2 = (List<AxisAlignedBB>)this.field_70170_p.func_72945_a((Entity)this, this.func_174813_aQ().func_72321_a(d4, y, d6));
                AxisAlignedBB axisalignedbb6 = this.func_174813_aQ();
                final AxisAlignedBB axisalignedbb7 = axisalignedbb6.func_72321_a(d4, 0.0, d6);
                double d11 = y;
                for (final AxisAlignedBB axisalignedbb8 : list2) {
                    d11 = axisalignedbb8.func_72323_b(axisalignedbb7, d11);
                }
                axisalignedbb6 = axisalignedbb6.func_72317_d(0.0, d11, 0.0);
                double d12 = d4;
                for (final AxisAlignedBB axisalignedbb9 : list2) {
                    d12 = axisalignedbb9.func_72316_a(axisalignedbb6, d12);
                }
                axisalignedbb6 = axisalignedbb6.func_72317_d(d12, 0.0, 0.0);
                double d13 = d6;
                for (final AxisAlignedBB axisalignedbb10 : list2) {
                    d13 = axisalignedbb10.func_72322_c(axisalignedbb6, d13);
                }
                axisalignedbb6 = axisalignedbb6.func_72317_d(0.0, 0.0, d13);
                AxisAlignedBB axisalignedbb11 = this.func_174813_aQ();
                double d14 = y;
                for (final AxisAlignedBB axisalignedbb12 : list2) {
                    d14 = axisalignedbb12.func_72323_b(axisalignedbb11, d14);
                }
                axisalignedbb11 = axisalignedbb11.func_72317_d(0.0, d14, 0.0);
                double d15 = d4;
                for (final AxisAlignedBB axisalignedbb13 : list2) {
                    d15 = axisalignedbb13.func_72316_a(axisalignedbb11, d15);
                }
                axisalignedbb11 = axisalignedbb11.func_72317_d(d15, 0.0, 0.0);
                double d16 = d6;
                for (final AxisAlignedBB axisalignedbb14 : list2) {
                    d16 = axisalignedbb14.func_72322_c(axisalignedbb11, d16);
                }
                axisalignedbb11 = axisalignedbb11.func_72317_d(0.0, 0.0, d16);
                final double d17 = d12 * d12 + d13 * d13;
                final double d18 = d15 * d15 + d16 * d16;
                if (d17 > d18) {
                    x = d12;
                    z = d13;
                    y = -d11;
                    this.func_174826_a(axisalignedbb6);
                }
                else {
                    x = d15;
                    z = d16;
                    y = -d14;
                    this.func_174826_a(axisalignedbb11);
                }
                y = -es.getStepHeight();
                for (final AxisAlignedBB axisalignedbb15 : list2) {
                    y = axisalignedbb15.func_72323_b(this.func_174813_aQ(), y);
                }
                this.func_174826_a(this.func_174813_aQ().func_72317_d(0.0, y, 0.0));
                if (d8 * d8 + d10 * d10 >= x * x + z * z) {
                    x = d8;
                    y = d9;
                    z = d10;
                    this.func_174826_a(axisalignedbb5);
                }
                else {
                    final EventStep es2 = new EventStep(false, this.field_70138_W, 1.0 + y);
                    EventManager.call((Event)es2);
                }
            }
            this.field_70170_p.field_72984_F.func_76319_b();
            this.field_70170_p.field_72984_F.func_76320_a("rest");
            this.field_70165_t = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
            this.field_70163_u = this.func_174813_aQ().field_72338_b;
            this.field_70161_v = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
            this.field_70123_F = (d4 != x || d6 != z);
            this.field_70124_G = (d5 != y);
            this.field_70122_E = (this.field_70124_G && d5 < 0.0);
            this.field_70132_H = (this.field_70123_F || this.field_70124_G);
            final int i = MathHelper.func_76128_c(this.field_70165_t);
            final int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224);
            final int k = MathHelper.func_76128_c(this.field_70161_v);
            BlockPos blockpos = new BlockPos(i, j, k);
            Block block1 = this.field_70170_p.func_180495_p(blockpos).func_177230_c();
            if (block1.func_149688_o() == Material.field_151579_a) {
                final Block block2 = this.field_70170_p.func_180495_p(blockpos.func_177977_b()).func_177230_c();
                if (block2 instanceof BlockFence || block2 instanceof BlockWall || block2 instanceof BlockFenceGate) {
                    block1 = block2;
                    blockpos = blockpos.func_177977_b();
                }
            }
            this.func_180433_a(y, this.field_70122_E, block1, blockpos);
            if (d4 != x) {
                this.field_70159_w = 0.0;
            }
            if (d6 != z) {
                this.field_70179_y = 0.0;
            }
            if (d5 != y) {
                block1.func_176216_a(this.field_70170_p, (Entity)this);
            }
            if (this.func_70041_e_() && !flag && this.field_70154_o == null) {
                final double d19 = this.field_70165_t - d0;
                double d20 = this.field_70163_u - d2;
                final double d21 = this.field_70161_v - d3;
                if (block1 != Blocks.field_150468_ap) {
                    d20 = 0.0;
                }
                if (block1 != null && this.field_70122_E) {
                    block1.func_176199_a(this.field_70170_p, blockpos, (Entity)this);
                }
                this.field_70140_Q += MathHelper.func_76133_a(d19 * d19 + d21 * d21) * 0.6;
                this.field_82151_R += MathHelper.func_76133_a(d19 * d19 + d20 * d20 + d21 * d21) * 0.6;
                if (this.field_82151_R > ((IEntity)this).getNextStepDistance() && block1.func_149688_o() != Material.field_151579_a) {
                    ((IEntity)this).setNextStepDistance((int)this.field_82151_R + 1);
                    if (this.func_70090_H()) {
                        float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224 + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224) * 0.35f;
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        this.func_85030_a(this.func_145776_H(), f, 1.0f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                    }
                    this.func_180429_a(blockpos, block1);
                }
            }
            try {
                this.func_145775_I();
            }
            catch (Throwable throwable) {
                final CrashReport crashreport = CrashReport.func_85055_a(throwable, "Checking entity block collision");
                final CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being checked for collision");
                this.func_85029_a(crashreportcategory);
                throw new ReportedException(crashreport);
            }
            final boolean flag3 = this.func_70026_G();
            final IEntity ent = (IEntity)this;
            if (this.field_70170_p.func_147470_e(this.func_174813_aQ().func_72331_e(0.001, 0.001, 0.001))) {
                this.func_70081_e(1);
                if (!flag3) {
                    ent.setFire(ent.getFire() + 1);
                    if (ent.getFire() == 0) {
                        this.func_70015_d(8);
                    }
                }
            }
            else if (ent.getFire() <= 0) {
                ent.setFire(-this.field_70174_ab);
            }
            if (flag3 && ent.getFire() > 0) {
                this.func_85030_a("random.fizz", 0.7f, 1.6f + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4f);
                ent.setFire(-this.field_70174_ab);
            }
            this.field_70170_p.field_72984_F.func_76319_b();
        }
    }
    
    public void func_70664_aZ() {
        this.field_70181_x = this.func_175134_bD();
        if (this.func_70644_a(Potion.field_76430_j)) {
            this.field_70181_x += (this.func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1f;
        }
        if (this.func_70051_ag()) {
            final float f = this.field_70177_z * 0.017453292f;
            this.field_70159_w -= MathHelper.func_76126_a(f) * 0.2f;
            this.field_70179_y += MathHelper.func_76134_b(f) * 0.2f;
        }
        this.field_70160_al = true;
        this.func_71029_a(StatList.field_75953_u);
    }
    
    public boolean moving() {
        return this.field_70701_bs > 0.0 | this.field_70702_br > 0.0;
    }
    
    public float getSpeed() {
        final float vel = (float)Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        return vel;
    }
    
    public void setSpeed(final double speed) {
        this.field_70159_w = -MathHelper.func_76126_a(this.getDirection()) * speed;
        this.field_70179_y = MathHelper.func_76134_b(this.getDirection()) * speed;
    }
    
    public float getDirection() {
        float yaw = this.field_70177_z;
        final float forward = this.field_70701_bs;
        final float strafe = this.field_70702_br;
        yaw += ((forward < 0.0f) ? 180 : 0);
        if (strafe < 0.0f) {
            yaw += ((forward < 0.0f) ? -45.0f : ((forward == 0.0f) ? 90.0f : 45.0f));
        }
        if (strafe > 0.0f) {
            yaw -= ((forward < 0.0f) ? -45.0f : ((forward == 0.0f) ? 90.0f : 45.0f));
        }
        return yaw * 0.017453292f;
    }
    
    public void setMoveSpeed(final double speed) {
        double forward = (double)this.field_71158_b.field_78900_b;
        double strafe = (double)this.field_71158_b.field_78902_a;
        float yaw = this.field_70177_z;
        if (forward == 0.0 && strafe == 0.0) {
            this.field_70159_w = 0.0;
            this.field_70179_y = 0.0;
        }
        else {
            if (forward != 0.0) {
                if (strafe > 0.0) {
                    yaw += ((forward > 0.0) ? -45 : 45);
                }
                else if (strafe < 0.0) {
                    yaw += ((forward > 0.0) ? 45 : -45);
                }
                strafe = 0.0;
                if (forward > 0.0) {
                    forward = 1.0;
                }
                else if (forward < 0.0) {
                    forward = -1.0;
                }
            }
            this.field_70159_w = forward * speed * Math.cos(Math.toRadians((double)(yaw + 90.0f))) + strafe * speed * Math.sin(Math.toRadians((double)(yaw + 90.0f)));
            this.field_70179_y = forward * speed * Math.sin(Math.toRadians((double)(yaw + 90.0f))) - strafe * speed * Math.cos(Math.toRadians((double)(yaw + 90.0f)));
        }
    }
    
    public void setYaw(final double yaw) {
        this.field_70177_z = (float)yaw;
    }
    
    public void setPitch(final double pitch) {
        this.field_70125_A = (float)pitch;
    }
    
    public void setMoveSpeed(final EventMove event, final double speed) {
        double forward = (double)this.field_71158_b.field_78900_b;
        double strafe = (double)this.field_71158_b.field_78902_a;
        float yaw = this.field_70177_z;
        if (forward == 0.0 && strafe == 0.0) {
            event.setX(0.0);
            event.setZ(0.0);
        }
        else {
            if (forward != 0.0) {
                if (strafe > 0.0) {
                    yaw += ((forward > 0.0) ? -45 : 45);
                }
                else if (strafe < 0.0) {
                    yaw += ((forward > 0.0) ? 45 : -45);
                }
                strafe = 0.0;
                if (forward > 0.0) {
                    forward = 1.0;
                }
                else if (forward < 0.0) {
                    forward = -1.0;
                }
            }
            event.setX(forward * speed * Math.cos(Math.toRadians((double)(yaw + 90.0f))) + strafe * speed * Math.sin(Math.toRadians((double)(yaw + 90.0f))));
            event.setZ(forward * speed * Math.sin(Math.toRadians((double)(yaw + 90.0f))) - strafe * speed * Math.cos(Math.toRadians((double)(yaw + 90.0f))));
        }
    }
    
    public void setLastReportedPosY(final double f) {
        this.field_175166_bJ = f;
    }
}
