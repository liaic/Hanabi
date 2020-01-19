package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.network.play.server.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ S12PacketEntityVelocity.class })
public class MixinS12PacketEntityVelocity implements IS12PacketEntityVelocity
{
    @Shadow
    private int field_149415_b;
    @Shadow
    private int field_149416_c;
    @Shadow
    private int field_149414_d;
    
    public MixinS12PacketEntityVelocity() {
        super();
    }
    
    @Override
    public void setX(final int f) {
        this.field_149415_b = f;
    }
    
    @Override
    public void setY(final int f) {
        this.field_149416_c = f;
    }
    
    @Override
    public void setZ(final int f) {
        this.field_149414_d = f;
    }
}
