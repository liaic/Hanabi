package cn.Hanabi.modules.Combat;

import cn.Hanabi.value.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import cn.Hanabi.*;
import net.minecraft.client.renderer.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.entity.*;
import cn.Hanabi.modules.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import javax.vecmath.*;
import ClassSub.*;
import net.minecraft.item.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import net.minecraft.entity.player.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.network.play.server.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.network.play.client.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.entity.item.*;
import cn.Hanabi.modules.Player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import java.lang.management.*;
import javax.swing.*;
import java.awt.*;

public class KillAura extends Mod
{
    public static Value<Boolean> autoBlock;
    public Value<Double> hurttime;
    public Value<Double> mistake;
    public static Value<Double> reach;
    public Value<Double> blockReach;
    public Value<Double> cps;
    public Value<Double> turn;
    public Value<String> rotMode;
    public static Value<Double> switchsize;
    public Value<Double> switchDelay;
    public Value<Double> yawDiff;
    public Value<Boolean> attackPlayers;
    public Value<Boolean> attackAnimals;
    public Value<Boolean> attackMobs;
    public Value<Boolean> throughblock;
    public Value<Boolean> rotations;
    public Value<Boolean> autodisable;
    public Value<Boolean> invisible;
    public Value<Boolean> targetHUD;
    public Value<Boolean> esp;
    public Value<Boolean> aac;
    public Value<String> priority;
    public static boolean isBlocking;
    public static ArrayList<EntityLivingBase> targets;
    public Random random;
    public static ArrayList<EntityLivingBase> attacked;
    public boolean needBlock;
    public boolean needUnBlock;
    public int index;
    public static EntityLivingBase target;
    public static EntityLivingBase needHitBot;
    public Class191 switchTimer;
    public Class191 attacktimer;
    public Vector2f lastAngles;
    private Class10 angleUtility;
    AxisAlignedBB axisAlignedBB;
    float shouldAddYaw;
    float[] lastRotation;
    private float rotationYawHead;
    private float[] lastRotations;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public KillAura() {
        super("KillAura", Category.COMBAT);
        this.hurttime = new Value<Double>("KillAura_HurtTime", 10.0, 1.0, 10.0, 1.0);
        this.mistake = new Value<Double>("KillAura_Mistakes", 0.0, 0.0, 20.0, 1.0);
        this.blockReach = new Value<Double>("KillAura_BlockRange", 0.5, 0.0, 3.0, 0.1);
        this.cps = new Value<Double>("KillAura_CPS", 10.0, 1.0, 20.0, 1.0);
        this.turn = new Value<Double>("KillAura_TurnHeadSpeed", 15.0, 5.0, 120.0, 1.0);
        this.rotMode = new Value<String>("KillAura", "RotationMode", 0);
        this.switchDelay = new Value<Double>("KillAura_SwitchDelay", 50.0, 0.0, 2000.0, 10.0);
        this.yawDiff = new Value<Double>("KillAura_YawDifference", 15.0, 5.0, 90.0, 1.0);
        this.attackPlayers = new Value<Boolean>("KillAura_Players", true);
        this.attackAnimals = new Value<Boolean>("KillAura_Animals", false);
        this.attackMobs = new Value<Boolean>("KillAura_Mobs", false);
        this.throughblock = new Value<Boolean>("KillAura_ThroughBlock", true);
        this.rotations = new Value<Boolean>("KillAura_HeadRotations", true);
        this.autodisable = new Value<Boolean>("KillAura_AutoDisable", true);
        this.invisible = new Value<Boolean>("KillAura_Invisibles", false);
        this.targetHUD = new Value<Boolean>("KillAura_ShowTarget", true);
        this.esp = new Value<Boolean>("KillAura_ESP", true);
        this.aac = new Value<Boolean>("KillAura_AAC", false);
        this.priority = new Value<String>("KillAura", "Priority", 1);
        this.random = new Random();
        this.needBlock = false;
        this.needUnBlock = false;
        this.switchTimer = new Class191();
        this.attacktimer = new Class191();
        this.lastAngles = new Vector2f(0.0f, 0.0f);
        this.angleUtility = new Class10(110.0f, 120.0f, 30.0f, 40.0f);
        this.lastRotation = new float[] { 0.0f, 0.0f };
        this.setState(true);
        this.priority.mode.add("Angle");
        this.priority.mode.add("Range");
        this.priority.mode.add("Fov");
        this.rotMode.mode.add("Simple");
        this.rotMode.mode.add("Smooth");
        this.rotMode.mode.add("Instant");
        KillAura.attacked = new ArrayList<EntityLivingBase>();
    }
    
    @EventTarget
    public void targetHud(final EventRender2D eventRender2D) {
        if ((boolean)this.targetHUD.getValueState()) {
            final ScaledResolution scaledResolution = new ScaledResolution(KillAura.mc);
            if (KillAura.target != null) {
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                final UnicodeFontRenderer wqy18 = Hanabi.INSTANCE.fontManager.wqy18;
                wqy18.func_175063_a(KillAura.target.func_70005_c_(), scaledResolution.func_78326_a() / 2.0f - wqy18.func_78256_a(KillAura.target.func_70005_c_()) / 2.0f, scaledResolution.func_78328_b() / 2.0f - 33.0f, 16777215);
                RenderHelper.func_74520_c();
                KillAura.mc.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/icons.png"));
                GL11.glDisable(2929);
                GL11.glEnable(3042);
                GL11.glDepthMask(false);
                OpenGlHelper.func_148821_a(770, 771, 1, 0);
                for (int n = 0; n < KillAura.target.func_110138_aP() / 2.0f; ++n) {
                    KillAura.mc.field_71456_v.func_175174_a(scaledResolution.func_78326_a() / 2 - KillAura.target.func_110138_aP() / 2.0f * 10.0f / 2.0f + (float)(n * 10), (float)(scaledResolution.func_78328_b() / 2 - 20), 16, 0, 9, 9);
                }
                for (int n2 = 0; n2 < KillAura.target.func_110143_aJ() / 2.0f; ++n2) {
                    KillAura.mc.field_71456_v.func_175174_a(scaledResolution.func_78326_a() / 2 - KillAura.target.func_110138_aP() / 2.0f * 10.0f / 2.0f + (float)(n2 * 10), (float)(scaledResolution.func_78328_b() / 2 - 20), 52, 0, 9, 9);
                }
                GL11.glDepthMask(true);
                GL11.glDisable(3042);
                GL11.glEnable(2929);
                GlStateManager.func_179084_k();
                GlStateManager.func_179124_c(1.0f, 1.0f, 1.0f);
                RenderHelper.func_74518_a();
            }
        }
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        if (KillAura.target == null || !(boolean)this.esp.getValueState()) {
            return;
        }
        for (final EntityLivingBase entityLivingBase : KillAura.targets) {
            KillAura.mc.func_175598_ae();
            final double n = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * Class296.getTimer().field_74281_c - ((IRenderManager)KillAura.mc.func_175598_ae()).getRenderPosX();
            KillAura.mc.func_175598_ae();
            final double n2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * Class296.getTimer().field_74281_c - ((IRenderManager)KillAura.mc.func_175598_ae()).getRenderPosY();
            KillAura.mc.func_175598_ae();
            Class284.drawEntityESP(n, n2, entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * Class296.getTimer().field_74281_c - ((IRenderManager)KillAura.mc.func_175598_ae()).getRenderPosZ(), entityLivingBase.func_174813_aQ().field_72336_d - entityLivingBase.func_174813_aQ().field_72340_a, entityLivingBase.func_174813_aQ().field_72337_e - entityLivingBase.func_174813_aQ().field_72338_b + 0.25, (entityLivingBase.field_70737_aN > 1) ? 1.0f : 0.0f, (entityLivingBase.field_70737_aN > 1) ? 0.0f : 1.0f, 0.0f, 0.2f, (entityLivingBase.field_70737_aN > 1) ? 1.0f : 0.0f, (entityLivingBase.field_70737_aN > 1) ? 0.0f : 1.0f, 0.0f, 1.0f, 2.0f);
        }
    }
    
    public static double getRandomDoubleInRange(final double n, final double n2) {
        return (n >= n2) ? n : (new Random().nextDouble() * (n2 - n) + n);
    }
    
    @EventTarget
    public void onPre(final EventPreMotion eventPreMotion) {
        this.rotationYawHead = KillAura.mc.field_71439_g.field_70759_as;
        this.needBlock = false;
        KillAura.needHitBot = null;
        if (!KillAura.targets.isEmpty() && this.index >= KillAura.targets.size()) {
            this.index = 0;
        }
        for (final EntityLivingBase entityLivingBase : KillAura.targets) {
            if (this.isValidEntity((Entity)entityLivingBase)) {
                continue;
            }
            KillAura.targets.remove(entityLivingBase);
        }
        this.getTarget(eventPreMotion);
        if (KillAura.targets.size() == 0) {
            KillAura.target = null;
        }
        else {
            KillAura.target = KillAura.targets.get(this.index);
            this.axisAlignedBB = null;
            if (KillAura.mc.field_71439_g.func_70032_d((Entity)KillAura.target) > KillAura.reach.getValueState()) {
                KillAura.target = KillAura.targets.get(0);
            }
        }
        if (KillAura.target != null) {
            if (KillAura.target.field_70737_aN == 10 && this.switchTimer.isDelayComplete(this.switchDelay.getValueState()) && KillAura.targets.size() > 1) {
                this.switchTimer.reset();
                ++this.index;
            }
            Math.abs(Math.abs(MathHelper.func_76142_g(this.rotationYawHead)) - Math.abs(MathHelper.func_76142_g(((float[])Class198.getRotations((Entity)KillAura.target))[0])));
            if (KillAura.target.field_70737_aN == 10 && Class21.abuses < 0) {
                KillAura.mc.field_71441_e.func_72900_e((Entity)KillAura.target);
            }
            if (this.rotations.getValueState() && Class21.abuses > 0) {
                if (this.rotMode.isCurrentMode("Simple")) {
                    if (!(boolean)this.aac.getValueState()) {
                        final float[] array = (float[])getEntityRotations(KillAura.target, this.lastRotations, this.aac.getValueState(), (int)(Object)this.turn.getValueState());
                        this.lastRotations = new float[] { array[0], array[1] };
                        eventPreMotion.setYaw(array[0] + (float)this.randomNumber(-3, 3));
                        eventPreMotion.setPitch(array[1] + (float)this.randomNumber(-3, 3));
                        this.rotationYawHead = eventPreMotion.getYaw();
                    }
                    if ((boolean)this.aac.getValueState()) {
                        final boolean b = false;
                        final boolean b2 = true;
                        final double n = 0.2;
                        final double n2 = 0.25;
                        if (this.axisAlignedBB == null) {
                            this.axisAlignedBB = new AxisAlignedBB(KillAura.target.field_70165_t, KillAura.target.field_70163_u, KillAura.target.field_70161_v, KillAura.target.field_70165_t + 1.0, KillAura.target.field_70163_u + 1.0, KillAura.target.field_70161_v + 1.0);
                        }
                        this.axisAlignedBB = this.axisAlignedBB.func_72317_d((KillAura.target.field_70165_t - KillAura.target.field_70169_q) * getRandomDoubleInRange(n, n2), (KillAura.target.field_70163_u - KillAura.target.field_70167_r) * getRandomDoubleInRange(n, n2), (KillAura.target.field_70161_v - KillAura.target.field_70166_s) * getRandomDoubleInRange(n, n2));
                        final float[] array2 = (float[])Class5.l(new float[] { Class5.ll1[0], Class5.ll1[1] }, Class5.l(Class5.l(this.axisAlignedBB, b && !this.attacktimer.isDelayComplete((long)(this.cps.getValueState() / 2.0))), b2), (float)(Math.random() * (this.turn.getValueState() / 3.0 * 1.2 - this.turn.getValueState() / 3.0 * 0.8) + this.turn.getValueState() / 3.0 * 0.8));
                        if (!ModManager.getModule("Scaffold").isEnabled()) {
                            eventPreMotion.setYaw(array2[0]);
                            this.rotationYawHead = eventPreMotion.getYaw();
                            eventPreMotion.setPitch(array2[1]);
                        }
                    }
                }
                else if (this.rotMode.isCurrentMode("Smooth")) {
                    final Class183 smoothAngle = this.angleUtility.smoothAngle(this.angleUtility.calculateAngle(new Class81<Double>(KillAura.target.func_174813_aQ().field_72340_a + (KillAura.target.func_174813_aQ().field_72336_d - KillAura.target.func_174813_aQ().field_72340_a) / 2.0, ((KillAura.target instanceof EntityPig || KillAura.target instanceof EntitySpider) ? (KillAura.target.func_174813_aQ().field_72338_b - KillAura.target.func_70047_e() * 1.2) : KillAura.target.field_70163_u) - ((Math.abs(KillAura.target.field_70163_u - KillAura.mc.field_71439_g.field_70163_u) > 1.8) ? (Math.abs(KillAura.target.field_70163_u - KillAura.mc.field_71439_g.field_70163_u) / Math.abs(KillAura.target.field_70163_u - KillAura.mc.field_71439_g.field_70163_u) / 2.0) : Math.abs(KillAura.target.field_70163_u - KillAura.mc.field_71439_g.field_70163_u)), KillAura.target.func_174813_aQ().field_72339_c + (KillAura.target.func_174813_aQ().field_72334_f - KillAura.target.func_174813_aQ().field_72339_c) / 2.0), new Class81<Double>(KillAura.mc.field_71439_g.func_174813_aQ().field_72340_a + (KillAura.mc.field_71439_g.func_174813_aQ().field_72336_d - KillAura.mc.field_71439_g.func_174813_aQ().field_72340_a) / 2.0, KillAura.mc.field_71439_g.field_70163_u, KillAura.mc.field_71439_g.func_174813_aQ().field_72339_c + (KillAura.mc.field_71439_g.func_174813_aQ().field_72334_f - KillAura.mc.field_71439_g.func_174813_aQ().field_72339_c) / 2.0)), new Class183(Float.valueOf(this.lastRotation[0]), Float.valueOf(this.lastRotation[1])), (float)(Object)this.turn.getValueState() * 10.0f, (float)(Object)this.turn.getValueState() * 10.0f);
                    final Random random = new Random();
                    eventPreMotion.setYaw(smoothAngle.getYaw() + random.nextInt(10) - 5.0f);
                    eventPreMotion.setPitch(smoothAngle.getPitch() + random.nextInt(3) - 2.0f);
                    this.lastRotation[0] = eventPreMotion.getYaw();
                    this.lastRotation[1] = eventPreMotion.getPitch();
                    this.rotationYawHead = eventPreMotion.getYaw();
                }
                else if (this.rotMode.isCurrentMode("Instant")) {
                    final float[] array3 = (float[])Class198.getRotations((Entity)KillAura.target);
                    final Random random2 = new Random();
                    eventPreMotion.setYaw(array3[0] + random2.nextInt(10) - 5.0f);
                    eventPreMotion.setPitch(array3[1] + random2.nextInt(3) - 2.0f);
                    this.rotationYawHead = eventPreMotion.getYaw();
                }
            }
            if (KillAura.target != null && this.aac.getValueState()) {
                this.doAttack();
            }
        }
        else {
            this.lastRotation[0] = KillAura.mc.field_71439_g.field_70177_z;
            this.lastAngles.x = KillAura.mc.field_71439_g.field_70177_z;
            KillAura.targets.clear();
            if (this.needUnBlock) {
                KillAura.mc.func_147114_u().func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
                ((IEntityPlayer)KillAura.mc.field_71439_g).setItemInUseCount(0);
                this.needUnBlock = false;
            }
        }
    }
    
    public static float[] getEntityRotations(final EntityLivingBase entityLivingBase, final float[] array, final boolean b, final int n) {
        final Class57 class57 = new Class57(b, n);
        final Class261 smoothAngle = class57.smoothAngle(class57.calculateAngle(new Vector3d(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + entityLivingBase.func_70047_e(), entityLivingBase.field_70161_v), new Vector3d(KillAura.mc.field_71439_g.field_70165_t, KillAura.mc.field_71439_g.field_70163_u + KillAura.mc.field_71439_g.func_70047_e(), KillAura.mc.field_71439_g.field_70161_v)), new Class261(array[0], array[1]));
        return new float[] { KillAura.mc.field_71439_g.field_70177_z + MathHelper.func_76142_g(smoothAngle.getYaw() - KillAura.mc.field_71439_g.field_70177_z), smoothAngle.getPitch() };
    }
    
    private int randomNumber(final int n, final int n2) {
        return (int)(Math.random() * (n - n2)) + n2;
    }
    
    private void doAttack() {
        if (this.attacktimer.isDelayComplete(1000 / (int)(Object)this.cps.getValueState() + this.random.nextInt(50) - 30 - 20 + this.random.nextInt(50))) {
            boolean b = Hanabi.flag < 0;
            final boolean b2 = KillAura.mc.field_71439_g.func_70032_d((Entity)KillAura.target) <= KillAura.reach.getValueState() && Hanabi.flag > 0;
            if (b2) {
                this.attacktimer.reset();
                if (KillAura.target.field_70737_aN > this.hurttime.getValueState() || this.random.nextInt(100) < (int)(Object)this.mistake.getValueState()) {
                    b = true;
                }
                if (Math.abs(Math.abs(MathHelper.func_76142_g(this.rotationYawHead)) - Math.abs(MathHelper.func_76142_g(((float[])Class198.getRotations((Entity)KillAura.target))[0]))) > this.yawDiff.getValueState() && !ModManager.getModule("Scaffold").isEnabled()) {
                    b = true;
                }
            }
            if (KillAura.mc.field_71439_g.func_70632_aY() || (KillAura.mc.field_71439_g.func_70694_bm() != null && KillAura.mc.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemSword && KillAura.autoBlock.getValueState())) {
                KillAura.mc.func_147114_u().func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
                this.needUnBlock = false;
            }
            if (!KillAura.mc.field_71439_g.func_70632_aY() && !(boolean)KillAura.autoBlock.getValueState() && KillAura.mc.field_71439_g.func_71052_bv() > 0) {
                ((IEntityPlayer)KillAura.mc.field_71439_g).setItemInUseCount(0);
            }
            if (b2) {
                this.attack(b);
            }
            this.needBlock = true;
        }
    }
    
    @EventTarget
    public void onPost(final EventPostMotion eventPostMotion) {
        if (KillAura.target != null && !(boolean)this.aac.getValueState()) {
            this.doAttack();
        }
        if (KillAura.target != null && ((KillAura.mc.field_71439_g.func_70694_bm() != null && KillAura.mc.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemSword && KillAura.autoBlock.getValueState()) || KillAura.mc.field_71439_g.func_70632_aY()) && this.needBlock) {
            ((IEntityPlayer)KillAura.mc.field_71439_g).setItemInUseCount(KillAura.mc.field_71439_g.func_70694_bm().func_77988_m());
            KillAura.mc.func_147114_u().func_147297_a((Packet)new C08PacketPlayerBlockPlacement(KillAura.mc.field_71439_g.field_71071_by.func_70448_g()));
            this.needUnBlock = true;
        }
    }
    
    @EventTarget
    public void onBlockPacket(final EventPacket eventPacket) {
        final Packet packet = eventPacket.getPacket();
        if (packet instanceof C08PacketPlayerBlockPlacement && !KillAura.isBlocking) {
            KillAura.isBlocking = true;
        }
        if (packet instanceof C07PacketPlayerDigging && KillAura.isBlocking) {
            KillAura.isBlocking = false;
        }
    }
    
    private void attack(final boolean b) {
        KillAura.mc.field_71439_g.func_71038_i();
        if (!b) {
            this.needBlock = true;
            KillAura.mc.field_71439_g.func_71009_b((Entity)KillAura.target);
            KillAura.mc.field_71439_g.func_71047_c((Entity)KillAura.target);
            final ArrayList<EntityLivingBase> list = new ArrayList<EntityLivingBase>();
            for (final Entity entity : KillAura.mc.field_71441_e.field_72996_f) {
                final float abs = Math.abs(Math.abs(MathHelper.func_76142_g(this.rotationYawHead)) - Math.abs(MathHelper.func_76142_g(((float[])Class198.getRotations(entity))[0])));
                if (entity instanceof EntityZombie && entity.func_82150_aj() && (abs < this.yawDiff.getValueState() || KillAura.mc.field_71439_g.func_70032_d((Entity)KillAura.target) < 1.0f) && KillAura.mc.field_71439_g.func_70032_d(entity) < KillAura.reach.getValueState() && entity != KillAura.mc.field_71439_g) {
                    list.add((EntityLivingBase)entity);
                }
            }
            if (list.size() == 0) {
                list.add(KillAura.target);
            }
            KillAura.needHitBot = list.get(this.random.nextInt(list.size()));
            EventManager.call((Event)new EventAttack((Entity)KillAura.target));
            if (Class21.abuses > 0) {
                KillAura.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C02PacketUseEntity((Entity)(((boolean)this.aac.getValueState()) ? KillAura.needHitBot : KillAura.target), C02PacketUseEntity.Action.ATTACK));
            }
            if (!KillAura.attacked.contains(KillAura.target) && KillAura.target instanceof EntityPlayer) {
                KillAura.attacked.add(KillAura.target);
            }
            KillAura.needHitBot = null;
        }
    }
    
    private void getTarget(final EventPreMotion eventPreMotion) {
        final int intValue = (int)(Object)KillAura.switchsize.getValueState();
        if (intValue > 1) {
            this.setDisplayName("Switch");
        }
        else {
            this.setDisplayName("Single");
        }
        for (final Entity entity : KillAura.mc.field_71441_e.field_72996_f) {
            final EntityLivingBase entityLivingBase;
            if (entity instanceof EntityLivingBase && this.isValidEntity((Entity)(entityLivingBase = (EntityLivingBase)entity)) && !KillAura.targets.contains(entityLivingBase)) {
                KillAura.targets.add(entityLivingBase);
            }
            if (KillAura.targets.size() >= intValue) {
                break;
            }
        }
        if (this.priority.isCurrentMode("Range")) {
            KillAura.targets.sort(KillAura::lambda$getTarget$0);
        }
        if (this.priority.isCurrentMode("Fov")) {
            KillAura.targets.sort(Comparator.comparingDouble((ToDoubleFunction<? super EntityLivingBase>)KillAura::lambda$getTarget$1));
        }
        if (this.priority.isCurrentMode("Angle")) {
            KillAura.targets.sort(KillAura::lambda$getTarget$2);
        }
    }
    
    @EventTarget
    private void onPacket(final EventPacket eventPacket) {
        if (eventPacket.getPacket() instanceof S08PacketPlayerPosLook) {
            final IS08PacketPlayerPosLook is08PacketPlayerPosLook = (IS08PacketPlayerPosLook)eventPacket.getPacket();
            is08PacketPlayerPosLook.setYaw(KillAura.mc.field_71439_g.field_70177_z);
            is08PacketPlayerPosLook.setPitch(KillAura.mc.field_71439_g.field_70125_A);
        }
        if (!(eventPacket.getPacket() instanceof C03PacketPlayer)) {}
    }
    
    private boolean isValidEntity(final Entity entity) {
        if (entity != null && entity instanceof EntityLivingBase) {
            if (entity.field_70128_L || ((EntityLivingBase)entity).func_110143_aJ() <= 0.0f) {
                if (ModManager.getModule("AutoL").isEnabled() && KillAura.attacked.contains(entity)) {
                    KillAura.attacked.remove(entity);
                    final String sb = AutoL.getSB();
                    if (AutoL.wdr.getValueState() && !AutoL.wdred.contains(KillAura.target.func_70005_c_())) {
                        AutoL.wdred.add(KillAura.target.func_70005_c_());
                        KillAura.mc.field_71439_g.func_71165_d("/wdr " + KillAura.target.func_70005_c_() + " ka fly reach nokb jesus ac");
                    }
                    KillAura.mc.field_71439_g.func_71165_d(AutoAbuse.prefix + entity.func_70005_c_() + " L" + (((boolean)AutoL.abuse.getValueState()) ? (" " + sb) : "") + (((boolean)AutoL.ad.getValueState()) ? " Buy Hanabi at mcheika.com" : ""));
                }
                return false;
            }
            if (KillAura.mc.field_71439_g.func_70032_d(entity) < KillAura.reach.getValueState() + this.blockReach.getValueState() && entity != KillAura.mc.field_71439_g && !KillAura.mc.field_71439_g.field_70128_L && !(entity instanceof EntityArmorStand) && !(entity instanceof EntitySnowman)) {
                if (entity instanceof EntityPlayer && this.attackPlayers.getValueState()) {
                    return entity.field_70173_aa >= 30 && (KillAura.mc.field_71439_g.func_70685_l(entity) || this.throughblock.getValueState()) && (!entity.func_82150_aj() || this.invisible.getValueState()) && !AntiBot.isBot(entity) && !Teams.isOnSameTeam(entity);
                }
                if (entity instanceof EntityMob && this.attackMobs.getValueState()) {
                    return !AntiBot.isBot(entity);
                }
                if ((entity instanceof EntityAnimal || entity instanceof EntityVillager) && this.attackAnimals.getValueState()) {
                    return !AntiBot.isBot(entity);
                }
            }
        }
        return false;
    }
    
    public void onEnable() {
        if (((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            this.shouldAddYaw = 0.0f;
            KillAura.attacked = new ArrayList<EntityLivingBase>();
            this.axisAlignedBB = null;
            if (KillAura.mc.field_71439_g != null) {
                this.lastRotation[0] = KillAura.mc.field_71439_g.field_70177_z;
                this.lastAngles.x = KillAura.mc.field_71439_g.field_70177_z;
                this.lastRotations = new float[] { KillAura.mc.field_71439_g.field_70177_z, KillAura.mc.field_71439_g.field_70125_A };
            }
            this.index = 0;
            super.onEnable();
            return;
        }
        JOptionPane.showMessageDialog(null, "你上你婊子妈的补丁啊", "操你妈啊5555555", 0);
        Runtime.getRuntime().exit(new Random().nextInt(123123));
    Label_0062_Outer:
        while (true) {
            while (true) {
                try {
                    while (true) {
                        JOptionPane.showMessageDialog(null, "退都不让老子退啊", "操你妈啊5555555", 0);
                        Thread.currentThread();
                        Thread.sleep(10000000L);
                        Thread.sleep(10000000L);
                    }
                }
                catch (InterruptedException ex) {
                    continue Label_0062_Outer;
                }
                continue;
            }
        }
    }
    
    public void onDisable() {
        this.axisAlignedBB = null;
        if (KillAura.mc.field_71439_g != null) {
            this.lastRotation[0] = KillAura.mc.field_71439_g.field_70177_z;
            this.lastAngles.x = KillAura.mc.field_71439_g.field_70177_z;
        }
        KillAura.targets.clear();
        KillAura.target = null;
        ((IEntityPlayer)KillAura.mc.field_71439_g).setItemInUseCount(0);
        KillAura.mc.func_147114_u().func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
        super.onDisable();
    }
    
    private static int lambda$getTarget$2(final EntityLivingBase entityLivingBase, final EntityLivingBase entityLivingBase2) {
        return (int)(KillAura.mc.field_71439_g.field_70177_z - ((float[])Class198.getRotations((Entity)entityLivingBase))[0] - (KillAura.mc.field_71439_g.field_70177_z - ((float[])Class198.getRotations((Entity)entityLivingBase2))[0]));
    }
    
    private static double lambda$getTarget$1(final EntityLivingBase entityLivingBase) {
        return Class198.getDistanceBetweenAngles(KillAura.mc.field_71439_g.field_70125_A, ((float[])Class198.getRotations((Entity)entityLivingBase))[0]);
    }
    
    private static int lambda$getTarget$0(final EntityLivingBase entityLivingBase, final EntityLivingBase entityLivingBase2) {
        return (int)(entityLivingBase.func_70032_d((Entity)KillAura.mc.field_71439_g) - entityLivingBase2.func_70032_d((Entity)KillAura.mc.field_71439_g));
    }
    
    static {
        KillAura.autoBlock = new Value<Boolean>("KillAura_AutoBlock", true);
        KillAura.reach = new Value<Double>("KillAura_Range", 4.2, 3.0, 6.0, 0.1);
        KillAura.switchsize = new Value<Double>("KillAura_MaxTargets", 1.0, 1.0, 5.0, 1.0);
        KillAura.isBlocking = false;
        KillAura.targets = new ArrayList<EntityLivingBase>();
        KillAura.attacked = new ArrayList<EntityLivingBase>();
        KillAura.target = null;
        KillAura.needHitBot = null;
    }
}
