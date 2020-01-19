package cn.Hanabi.injection.mixins;

import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import java.nio.*;

@Mixin({ WorldRenderer.class })
public abstract class MixinWorldRenderer
{
    @Shadow
    private boolean field_78939_q;
    @Shadow
    private IntBuffer field_178999_b;
    
    public MixinWorldRenderer() {
        super();
    }
    
    @Shadow
    public abstract int func_78909_a(final int p0);
}
