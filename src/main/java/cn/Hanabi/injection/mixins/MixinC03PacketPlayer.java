package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.network.play.client.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ C03PacketPlayer.class })
public class MixinC03PacketPlayer implements IC03PacketPlayer
{
    @Shadow
    protected boolean field_149474_g;
    @Shadow
    protected double field_149477_b;
    @Shadow
    protected float field_149476_e;
    @Shadow
    protected float field_149473_f;
    @Shadow
    protected boolean field_149481_i;
    
    public MixinC03PacketPlayer() {
        super();
    }
    
    @Override
    public boolean isOnGround() {
        return this.field_149474_g;
    }
    
    @Override
    public void setOnGround(final boolean b) {
        this.field_149474_g = b;
    }
    
    @Override
    public void setPosY(final double y2) {
        this.field_149477_b = y2;
    }
    
    @Override
    public void setYaw(final float f) {
        this.field_149476_e = f;
    }
    
    @Override
    public float getYaw() {
        return this.field_149476_e;
    }
    
    @Override
    public void setPitch(final float f) {
        this.field_149473_f = f;
    }
    
    @Override
    public float getPitch() {
        return this.field_149473_f;
    }
    
    @Override
    public void setRotate(final boolean b) {
        this.field_149481_i = b;
    }
    
    @Override
    public boolean getRotate() {
        return this.field_149481_i;
    }
}
