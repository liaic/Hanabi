package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Combat.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ PlayerControllerMP.class })
public class MixinPlayerControllerMP implements IPlayerControllerMP
{
    @Shadow
    private WorldSettings.GameType field_78779_k;
    @Shadow
    private float field_78770_f;
    @Shadow
    private int field_78781_i;
    
    public MixinPlayerControllerMP() {
        super();
    }
    
    @Inject(method = { "attackEntity" }, at = { @At("HEAD") })
    public void attack(final EntityPlayer playerIn, final Entity targetEntity, final CallbackInfo info) {
        EventManager.call((Event)new EventAttack(targetEntity));
    }
    
    @Overwrite
    public float func_78757_d() {
        if (ModManager.getModule("Reach").isEnabled() && !ModManager.getModule("TPHit").isEnabled()) {
            return (float)Reach.getReach() + 1.5f;
        }
        return this.field_78779_k.func_77145_d() ? 5.0f : 4.5f;
    }
    
    @Override
    public float getCurBlockDamageMP() {
        return this.field_78770_f;
    }
    
    @Override
    public void setCurBlockDamageMP(final float f) {
        this.field_78770_f = f;
    }
    
    @Override
    public void setBlockHitDelay(final int i) {
        this.field_78781_i = i;
    }
}
