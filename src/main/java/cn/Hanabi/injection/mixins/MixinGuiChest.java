package cn.Hanabi.injection.mixins;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.inventory.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.util.*;
import cn.Hanabi.modules.Player.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiChest.class })
public class MixinGuiChest
{
    @Shadow
    private IInventory field_147015_w;
    
    public MixinGuiChest() {
        super();
    }
    
    @Inject(method = { "drawGuiContainerForegroundLayer" }, at = { @At("HEAD") })
    private void nmsl(final int mouseX, final int mouseY, final CallbackInfo ci) {
        if (StatCollector.func_74838_a("container.chest").equalsIgnoreCase(this.field_147015_w.func_145748_c_().func_150260_c()) || StatCollector.func_74838_a("container.chestDouble").equalsIgnoreCase(this.field_147015_w.func_145748_c_().func_150260_c())) {
            ChestStealer.isChest = true;
        }
        else {
            ChestStealer.isChest = false;
        }
    }
}
