package cn.Hanabi.injection.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiNewChat.class })
public class MixinGuiNewChat
{
    public MixinGuiNewChat() {
        super();
    }
    
    @Inject(method = { "printChatMessageWithOptionalDeletion" }, at = { @At("HEAD") }, cancellable = true)
    private void eventchat(final IChatComponent p_146234_1_, final int p_146234_2_, final CallbackInfo ci) {
        final EventChat event = new EventChat(p_146234_1_.func_150260_c());
        EventManager.call((Event)event);
        if (event.cancelled) {
            ci.cancel();
        }
    }
}
