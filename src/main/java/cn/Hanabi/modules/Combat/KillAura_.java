package cn.Hanabi.modules.Combat;

import cn.Hanabi.value.*;
import net.minecraft.entity.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import cn.Hanabi.*;
import net.minecraft.client.renderer.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.network.play.server.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import cn.Hanabi.injection.interfaces.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import net.minecraft.network.play.client.*;
import cn.Hanabi.modules.*;
import java.util.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.modules.Player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import javax.vecmath.*;
import net.minecraft.util.*;
import ClassSub.*;

public class KillAura_ extends Mod
{
    public Value<Boolean> aac;
    public Value<Boolean> targetHUD;
    public Value<Boolean> esp;
    public Value<Boolean> autoblock;
    public Value<Boolean> attackPlayers;
    public Value<Boolean> attackAnimals;
    public Value<Boolean> attackMobs;
    public Value<Boolean> throughblock;
    public Value<Boolean> invisible;
    public Value<Double> range;
    public Value<Double> blockRange;
    public Value<Double> cps;
    public Value<Double> maxTarget;
    public Value<Double> switchDelay;
    public Value<Double> switchHurttime;
    public Value<Double> turnspeed;
    public static EntityLivingBase attackingEntity;
    public int targetIndex;
    public Class191 attackTimer;
    public Class191 switchTimer;
    public float[] lastRotations;
    public boolean isBlocking;
    public static ArrayList<EntityLivingBase> attackingEntityList;
    public ArrayList<EntityLivingBase> attackedEntity;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public KillAura_() {
        super("KillAura", Category.COMBAT);
        this.aac = new Value<Boolean>("KillAura_AAC", false);
        this.targetHUD = new Value<Boolean>("KillAura_ShowTarget", true);
        this.esp = new Value<Boolean>("KillAura_ESP", true);
        this.autoblock = new Value<Boolean>("KillAura_AutoBlock", true);
        this.attackPlayers = new Value<Boolean>("KillAura_Players", true);
        this.attackAnimals = new Value<Boolean>("KillAura_Animals", false);
        this.attackMobs = new Value<Boolean>("KillAura_Mobs", false);
        this.throughblock = new Value<Boolean>("KillAura_ThroughBlock", true);
        this.invisible = new Value<Boolean>("KillAura_Invisibles", false);
        this.range = new Value<Double>("KillAura_Range", 4.2, 3.0, 6.0, 0.1);
        this.blockRange = new Value<Double>("KillAura_BlockRange", 0.5, 0.0, 3.0, 0.1);
        this.cps = new Value<Double>("KillAura_CPS", 10.0, 1.0, 20.0, 0.1);
        this.maxTarget = new Value<Double>("KillAura_MaxTarget", 3.0, 1.0, 8.0, 1.0);
        this.switchDelay = new Value<Double>("KillAura_SwitchDelay", 350.0, 10.0, 1000.0, 10.0);
        this.switchHurttime = new Value<Double>("KillAura_SwitchHurttime", 10.0, 1.0, 10.0, 1.0);
        this.turnspeed = new Value<Double>("KillAura_TurnHeadSpeed", 90.0, 60.0, 120.0, 1.0);
        this.attackTimer = new Class191();
        this.switchTimer = new Class191();
        this.isBlocking = false;
        this.attackedEntity = new ArrayList<EntityLivingBase>();
    }
    
    @Override
    protected void onEnable() {
        KillAura_.attackingEntity = null;
        this.targetIndex = 0;
        this.isBlocking = false;
        this.lastRotations = new float[] { KillAura_.mc.field_71439_g.field_70177_z, KillAura_.mc.field_71439_g.field_70125_A };
        this.attackedEntity = new ArrayList<EntityLivingBase>();
        super.onEnable();
    }
    
    @Override
    protected void onDisable() {
        this.unBlock();
        super.onDisable();
    }
    
    @EventTarget
    public void targetHud(final EventRender2D eventRender2D) {
        if (this.targetHUD.getValueState() && this.isValidEntity((Entity)KillAura_.attackingEntity)) {
            final ScaledResolution scaledResolution = new ScaledResolution(KillAura_.mc);
            if (KillAura_.attackingEntity != null) {
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                final UnicodeFontRenderer wqy18 = Hanabi.INSTANCE.fontManager.wqy18;
                wqy18.func_175063_a(KillAura_.attackingEntity.func_70005_c_(), scaledResolution.func_78326_a() / 2.0f - wqy18.func_78256_a(KillAura_.attackingEntity.func_70005_c_()) / 2.0f, scaledResolution.func_78328_b() / 2.0f - 33.0f, 16777215);
                RenderHelper.func_74520_c();
                KillAura_.mc.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/icons.png"));
                GL11.glDisable(2929);
                GL11.glEnable(3042);
                GL11.glDepthMask(false);
                OpenGlHelper.func_148821_a(770, 771, 1, 0);
                for (int n = 0; n < KillAura_.attackingEntity.func_110138_aP() / 2.0f; ++n) {
                    KillAura_.mc.field_71456_v.func_175174_a(scaledResolution.func_78326_a() / 2 - KillAura_.attackingEntity.func_110138_aP() / 2.0f * 10.0f / 2.0f + (float)(n * 10), (float)(scaledResolution.func_78328_b() / 2 - 20), 16, 0, 9, 9);
                }
                for (int n2 = 0; n2 < KillAura_.attackingEntity.func_110143_aJ() / 2.0f; ++n2) {
                    KillAura_.mc.field_71456_v.func_175174_a(scaledResolution.func_78326_a() / 2 - KillAura_.attackingEntity.func_110138_aP() / 2.0f * 10.0f / 2.0f + (float)(n2 * 10), (float)(scaledResolution.func_78328_b() / 2 - 20), 52, 0, 9, 9);
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
        if ((boolean)this.esp.getValueState()) {
            for (final EntityLivingBase entityLivingBase : KillAura_.attackingEntityList) {
                KillAura_.mc.func_175598_ae();
                final double n = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * Class296.getTimer().field_74281_c - ((IRenderManager)KillAura_.mc.func_175598_ae()).getRenderPosX();
                KillAura_.mc.func_175598_ae();
                final double n2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * Class296.getTimer().field_74281_c - ((IRenderManager)KillAura_.mc.func_175598_ae()).getRenderPosY();
                KillAura_.mc.func_175598_ae();
                Class284.drawEntityESP(n, n2, entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * Class296.getTimer().field_74281_c - ((IRenderManager)KillAura_.mc.func_175598_ae()).getRenderPosZ(), entityLivingBase.func_174813_aQ().field_72336_d - entityLivingBase.func_174813_aQ().field_72340_a, entityLivingBase.func_174813_aQ().field_72337_e - entityLivingBase.func_174813_aQ().field_72338_b + 0.25, (entityLivingBase.field_70737_aN > 1) ? 1.0f : 0.0f, (entityLivingBase.field_70737_aN > 1) ? 0.0f : 1.0f, 0.0f, 0.2f, (entityLivingBase.field_70737_aN > 1) ? 1.0f : 0.0f, (entityLivingBase.field_70737_aN > 1) ? 0.0f : 1.0f, 0.0f, 1.0f, 2.0f);
            }
        }
    }
    
    @EventTarget
    public void onPre(final EventPreMotion eventPreMotion) {
        while (this.canSwitch(this.getTarget())) {
            ++this.targetIndex;
        }
        KillAura_.attackingEntity = this.getTarget();
        if (KillAura_.attackingEntity != null) {
            if ((boolean)this.autoblock.getValueState()) {
                this.doBlock();
            }
            final float[] array = (float[])getEntityRotations(KillAura_.attackingEntity, this.lastRotations, this.aac.getValueState(), (int)(Object)this.turnspeed.getValueState());
            this.lastRotations = new float[] { array[0], array[1] };
            eventPreMotion.setYaw(array[0]);
            eventPreMotion.setPitch(array[1]);
            KillAura_.mc.field_71439_g.field_70759_as = eventPreMotion.getYaw();
        }
        else {
            this.unBlock();
        }
        if ((boolean)this.aac.getValueState()) {
            this.attackEntity();
        }
    }
    
    @EventTarget
    public void onPost(final EventPostMotion eventPostMotion) {
        if (!(boolean)this.aac.getValueState()) {
            this.attackEntity();
        }
    }
    
    @EventTarget
    private void onPacket(final EventPacket eventPacket) {
        if (eventPacket.getPacket() instanceof S08PacketPlayerPosLook) {
            final IS08PacketPlayerPosLook is08PacketPlayerPosLook = (IS08PacketPlayerPosLook)eventPacket.getPacket();
            is08PacketPlayerPosLook.setYaw(KillAura_.mc.field_71439_g.field_70177_z);
            is08PacketPlayerPosLook.setPitch(KillAura_.mc.field_71439_g.field_70125_A);
        }
    }
    
    public void doBlock() {
        if (KillAura_.mc.field_71439_g.func_70632_aY() || (KillAura_.mc.field_71439_g.func_70694_bm() != null && KillAura_.mc.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemSword && !this.isBlocking)) {
            KillAura_.mc.func_147114_u().func_147297_a((Packet)new C08PacketPlayerBlockPlacement(new BlockPos(0, 0, 0), 255, KillAura_.mc.field_71439_g.field_71071_by.func_70448_g(), 0.0f, 0.0f, 0.0f));
            ((IEntityPlayer)KillAura_.mc.field_71439_g).setItemInUseCount(KillAura_.mc.field_71439_g.func_70694_bm().func_77988_m());
            this.isBlocking = true;
        }
    }
    
    public void unBlock() {
        if (((KillAura_.mc.field_71439_g.func_70694_bm() != null && KillAura_.mc.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemSword) || KillAura_.mc.field_71439_g.func_70632_aY()) && this.isBlocking) {
            ((IEntityPlayer)KillAura_.mc.field_71439_g).setItemInUseCount(0);
            KillAura_.mc.func_147114_u().func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
            this.isBlocking = false;
        }
    }
    
    public void attackEntity() {
        if (KillAura_.attackingEntity != null && this.isValidEntity((Entity)KillAura_.attackingEntity) && KillAura_.mc.field_71439_g.func_70032_d((Entity)KillAura_.attackingEntity) < this.range.getValueState() && this.attackTimer.isDelayComplete(Double.valueOf(this.cpsToDelay((double)this.cps.getValueState())))) {
            if ((boolean)this.autoblock.getValueState()) {
                this.unBlock();
            }
            KillAura_.mc.field_71439_g.func_71009_b((Entity)KillAura_.attackingEntity);
            KillAura_.mc.field_71439_g.func_71047_c((Entity)KillAura_.attackingEntity);
            KillAura_.mc.field_71439_g.func_71038_i();
            EventManager.call((Event)new EventAttack((Entity)KillAura_.attackingEntity));
            KillAura_.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C02PacketUseEntity((Entity)KillAura_.attackingEntity, C02PacketUseEntity.Action.ATTACK));
            if (!this.attackedEntity.contains(KillAura_.attackingEntity)) {
                this.attackedEntity.add(KillAura_.attackingEntity);
            }
            if ((boolean)this.autoblock.getValueState()) {
                this.doBlock();
            }
            this.attackTimer.reset();
        }
    }
    
    public boolean canSwitch(final EntityLivingBase entityLivingBase) {
        if (KillAura_.attackingEntityList.size() <= 1 || this.maxTarget.getValueState() <= 1.0) {
            return false;
        }
        if (entityLivingBase.field_70737_aN <= this.switchHurttime.getValueState() && this.switchTimer.isDelayComplete(this.switchDelay.getValueState()) && KillAura_.attackingEntityList.size() > this.targetIndex) {
            this.switchTimer.reset();
            return true;
        }
        return false;
    }
    
    public double cpsToDelay(final double n) {
        return 1000.0 / n;
    }
    
    public EntityLivingBase getTarget() {
        try {
            final ArrayList<EntityLivingBase> validEntityList = this.getValidEntityList();
            if (validEntityList.size() <= 0) {
                return null;
            }
            if (this.targetIndex > validEntityList.size() - 1) {
                this.targetIndex = 0;
            }
            return this.getValidEntityList().get(this.targetIndex);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<EntityLivingBase> getValidEntityList() {
        final ArrayList<EntityLivingBase> attackingEntityList = new ArrayList<EntityLivingBase>();
        final ArrayList<Entity> list = new ArrayList<Entity>(KillAura_.mc.field_71441_e.field_72996_f);
        list.sort(KillAura_::lambda$getValidEntityList$0);
        for (final Entity entity : list) {
            if (this.isValidEntity(entity) && attackingEntityList.size() < this.maxTarget.getValueState()) {
                attackingEntityList.add((EntityLivingBase)entity);
            }
        }
        return KillAura_.attackingEntityList = attackingEntityList;
    }
    
    private boolean isValidEntity(final Entity entity) {
        if (entity != null && entity instanceof EntityLivingBase) {
            if (entity.field_70128_L || ((EntityLivingBase)entity).func_110143_aJ() <= 0.0f) {
                if (ModManager.getModule("AutoL").isEnabled() && this.attackedEntity.contains(entity)) {
                    this.attackedEntity.remove(entity);
                    String s = "";
                    final int nextInt = new Random().nextInt(6);
                    if (nextInt == 0) {
                        s = "我四川广安白治军当场屠杀绿色玩家婊子亲妈";
                    }
                    else if (nextInt == 1) {
                        s = "我在四川广安，四川广安特产Power Client屠杀绿色玩家！";
                    }
                    else if (nextInt == 2) {
                        s = "你好！我叫白治军四川特产Power杀绿色玩家亲妈昂。";
                    }
                    else if (nextInt == 3) {
                        s = "对不起我叫白治军来自四川广安我今年当兵兵检没过我只能上完初中回家辍学写端圈钱求求你们可怜可怜我吧";
                    }
                    else if (nextInt == 4) {
                        s = "电话预定购买四川广安特产Power客户端请拨打15397699681。";
                    }
                    else if (nextInt == 5) {
                        s = "我叫白治军我在四川广安用邻水脐橙给你妈妈洗B呢购买Power拨打热线15397699681";
                    }
                    if (AutoL.wdr.getValueState() && !AutoL.wdred.contains(KillAura_.attackingEntity.func_70005_c_())) {
                        AutoL.wdred.add(KillAura_.attackingEntity.func_70005_c_());
                        KillAura_.mc.field_71439_g.func_71165_d("/wdr " + KillAura_.attackingEntity.func_70005_c_() + " ka fly reach nokb jesus ac");
                    }
                    KillAura_.mc.field_71439_g.func_71165_d(AutoAbuse.prefix + entity.func_70005_c_() + " L" + (((boolean)AutoL.abuse.getValueState()) ? (" " + s) : "") + (((boolean)AutoL.ad.getValueState()) ? " Buy Hanabi at mcheika.com" : ""));
                }
                return false;
            }
            if (KillAura_.mc.field_71439_g.func_70032_d(entity) < this.range.getValueState() + this.blockRange.getValueState() && entity != KillAura_.mc.field_71439_g && !KillAura_.mc.field_71439_g.field_70128_L && !(entity instanceof EntityArmorStand) && !(entity instanceof EntitySnowman)) {
                if (entity instanceof EntityPlayer && this.attackPlayers.getValueState()) {
                    return entity.field_70173_aa >= 30 && (KillAura_.mc.field_71439_g.func_70685_l(entity) || this.throughblock.getValueState()) && (!entity.func_82150_aj() || this.invisible.getValueState()) && !AntiBot.isBot(entity) && !Teams.isOnSameTeam(entity);
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
    
    public static float[] getEntityRotations(final EntityLivingBase entityLivingBase, final float[] array, final boolean b, final int n) {
        final Class211 class211 = new Class211(b, n);
        final Class310 smoothAngle = class211.smoothAngle(class211.calculateAngle(new Vector3d(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + entityLivingBase.func_70047_e(), entityLivingBase.field_70161_v), new Vector3d(KillAura_.mc.field_71439_g.field_70165_t, KillAura_.mc.field_71439_g.field_70163_u + KillAura_.mc.field_71439_g.func_70047_e(), KillAura_.mc.field_71439_g.field_70161_v)), new Class310(array[0], array[1]));
        return new float[] { KillAura_.mc.field_71439_g.field_70177_z + MathHelper.func_76142_g(smoothAngle.getYaw() - KillAura_.mc.field_71439_g.field_70177_z), smoothAngle.getPitch() };
    }
    
    private static int lambda$getValidEntityList$0(final Entity entity, final Entity entity2) {
        return (int)(KillAura_.mc.field_71439_g.field_70177_z - ((float[])Class198.getRotations(entity))[0] - (KillAura_.mc.field_71439_g.field_70177_z - ((float[])Class198.getRotations(entity2))[0]));
    }
}
