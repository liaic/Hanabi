package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ RenderManager.class })
public class MixinRenderManager implements IRenderManager
{
    @Shadow
    private double field_78725_b;
    @Shadow
    private double field_78726_c;
    @Shadow
    private double field_78723_d;
    
    public MixinRenderManager() {
        super();
    }
    
    @Override
    public double getRenderPosX() {
        return this.field_78725_b;
    }
    
    @Override
    public double getRenderPosY() {
        return this.field_78726_c;
    }
    
    @Override
    public double getRenderPosZ() {
        return this.field_78723_d;
    }
}
