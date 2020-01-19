package cn.Hanabi.injection.mixins;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import ClassSub.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiMainMenu.class })
public class MixinGuiMainMenu
{
    public MixinGuiMainMenu() {
        super();
    }
    
    @Inject(method = { "initGui" }, at = { @At("HEAD") }, cancellable = true)
    public void onInit(final CallbackInfo ci) {
        Minecraft.func_71410_x().func_147108_a((GuiScreen)new Class141());
        ci.cancel();
    }
}
