package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.settings.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ KeyBinding.class })
public class MixinKeyBinding implements IKeyBinding
{
    @Shadow
    private boolean field_74513_e;
    
    public MixinKeyBinding() {
        super();
    }
    
    @Override
    public boolean getPress() {
        return this.field_74513_e;
    }
    
    @Override
    public void setPress(final Boolean b) {
        this.field_74513_e = b;
    }
}
