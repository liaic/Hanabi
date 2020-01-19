package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ EntityLivingBase.class })
public abstract class MixinEntityLivingBase implements IEntityLivingBase
{
    public MixinEntityLivingBase() {
        super();
    }
    
    @Shadow
    protected abstract int func_82166_i();
    
    @Override
    public int runGetArmSwingAnimationEnd() {
        return this.func_82166_i();
    }
}
