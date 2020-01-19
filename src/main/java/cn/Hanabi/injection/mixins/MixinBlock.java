package cn.Hanabi.injection.mixins;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ Block.class })
public abstract class MixinBlock
{
    @Shadow
    protected double field_149759_B;
    @Shadow
    protected double field_149760_C;
    @Shadow
    protected double field_149754_D;
    @Shadow
    protected double field_149755_E;
    @Shadow
    protected double field_149756_F;
    @Shadow
    protected double field_149757_G;
    int blockID;
    
    public MixinBlock() {
        super();
        this.blockID = 0;
    }
    
    @Shadow
    public abstract boolean func_149637_q();
}
