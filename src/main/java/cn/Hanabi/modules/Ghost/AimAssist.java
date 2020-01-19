package cn.Hanabi.modules.Ghost;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.item.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.Player.*;
import java.util.*;

public class AimAssist extends Mod
{
    public Value<Double> rotateSpeed;
    public Value<Double> range;
    public Value<Double> fov;
    public Value<Boolean> onlyPlayers;
    public Value<Boolean> clickAim;
    public Value<Boolean> weapon;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public AimAssist() {
        super("AimAssist", Category.GHOST);
        this.rotateSpeed = new Value<Double>("AimAssist_RotateSpeed", 35.0, 1.0, 75.0, 1.0);
        this.range = new Value<Double>("AimAssist_Range", 3.8, 3.0, 10.0, 0.1);
        this.fov = new Value<Double>("AimAssist_Fov", 360.0, 1.0, 360.0, 1.0);
        this.onlyPlayers = new Value<Boolean>("AimAssist_PlayersOnly", true);
        this.clickAim = new Value<Boolean>("AimAssist_ClickAim", true);
        this.weapon = new Value<Boolean>("AimAssist_Weapon", false);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (AimAssist.mc.field_71441_e != null) {
            if ((boolean)this.weapon.getValueState()) {
                if (AimAssist.mc.field_71439_g.func_71045_bC() == null) {
                    return;
                }
                if (!(AimAssist.mc.field_71439_g.func_71045_bC().func_77973_b() instanceof ItemSword)) {
                    return;
                }
            }
            if (this.clickAim.getValueState() && !((IKeyBinding)AimAssist.mc.field_71474_y.field_74312_F).getPress()) {
                return;
            }
            final EntityLivingBase nearestTarget = this.getNearestTarget();
            if (nearestTarget != null && (this.fov(nearestTarget) > 1.0 || this.fov(nearestTarget) < -1.0)) {
                final boolean b = this.fov(nearestTarget) > 0.0;
                final EntityPlayerSP field_71439_g = AimAssist.mc.field_71439_g;
                field_71439_g.field_70177_z += (float)(b ? (-(Math.abs(this.fov(nearestTarget)) / (int)(Object)this.rotateSpeed.getValueState())) : (Math.abs(this.fov(nearestTarget)) / (int)(Object)this.rotateSpeed.getValueState()));
            }
        }
    }
    
    public double fov(final EntityLivingBase entityLivingBase) {
        return ((AimAssist.mc.field_71439_g.field_70177_z - this.faceTarget(entityLivingBase)) % 360.0 + 540.0) % 360.0 - 180.0;
    }
    
    public EntityLivingBase getNearestTarget() {
        Object o = null;
        for (final EntityPlayer next : AimAssist.mc.field_71441_e.field_72996_f) {
            if (next instanceof EntityPlayer && this.onlyPlayers.getValueState()) {
                final EntityPlayer entityPlayer = (EntityPlayer)next;
                if (entityPlayer == AimAssist.mc.field_71439_g || !entityPlayer.func_70089_S() || entityPlayer.func_82150_aj() || AimAssist.mc.field_71439_g.func_70032_d((Entity)entityPlayer) >= this.range.getValueState() || AntiBot.isBot((Entity)entityPlayer) || Teams.isOnSameTeam((Entity)entityPlayer) || !AimAssist.mc.field_71439_g.func_70685_l((Entity)entityPlayer) || !this.inFov(entityPlayer, (float)(int)(Object)this.fov.getValueState())) {
                    continue;
                }
                o = entityPlayer;
            }
            else {
                if (!(next instanceof EntityLivingBase) || this.onlyPlayers.getValueState()) {
                    continue;
                }
                final EntityLivingBase entityLivingBase = (EntityLivingBase)next;
                if (entityLivingBase == AimAssist.mc.field_71439_g || !entityLivingBase.func_70089_S() || entityLivingBase.func_82150_aj() || AimAssist.mc.field_71439_g.func_70032_d((Entity)entityLivingBase) >= this.range.getValueState() || AntiBot.isBot((Entity)entityLivingBase) || Teams.isOnSameTeam((Entity)entityLivingBase) || !AimAssist.mc.field_71439_g.func_70685_l((Entity)entityLivingBase) || !this.inFov(entityLivingBase, (float)(Object)this.fov.getValueState())) {
                    continue;
                }
                o = entityLivingBase;
            }
        }
        return (EntityLivingBase)o;
    }
    
    public boolean inFov(final EntityLivingBase entityLivingBase, float n) {
        n *= 0.5;
        final double n2 = ((AimAssist.mc.field_71439_g.field_70177_z - this.faceTarget(entityLivingBase)) % 360.0 + 540.0) % 360.0 - 180.0;
        return (n2 > 0.0 && n2 < n) || (-n < n2 && n2 < 0.0);
    }
    
    public float faceTarget(final EntityLivingBase entityLivingBase) {
        final double n = entityLivingBase.field_70165_t - AimAssist.mc.field_71439_g.field_70165_t;
        final double n2 = entityLivingBase.field_70163_u - AimAssist.mc.field_71439_g.field_70163_u;
        final double n3 = entityLivingBase.field_70161_v - AimAssist.mc.field_71439_g.field_70161_v;
        final double n4 = -(Math.atan2(n, n3) * 57.29577951308232);
        final double n5 = -(Math.asin(n2 / Math.sqrt(n * n + n2 * n2 + n3 * n3)) * 57.29577951308232);
        return (float)n4;
    }
}
