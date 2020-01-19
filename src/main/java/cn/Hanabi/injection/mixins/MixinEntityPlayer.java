package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.entity.player.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ EntityPlayer.class })
public class MixinEntityPlayer implements IEntityPlayer
{
    @Shadow
    public int field_71072_f;
    
    public MixinEntityPlayer() {
        super();
    }
    
    @Override
    public void setItemInUseCount(final int i) {
        this.field_71072_f = i;
    }
}
