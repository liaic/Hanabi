package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.gui.*;
import com.google.common.collect.*;
import net.minecraft.client.network.*;
import cn.Hanabi.modules.Player.*;
import net.minecraft.scoreboard.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ GuiPlayerTabOverlay.class })
public class MixinGuiPlayerTabOverlay implements IGuiPlayerTabOverlay
{
    @Shadow
    @Final
    private static Ordering<NetworkPlayerInfo> field_175252_a;
    
    public MixinGuiPlayerTabOverlay() {
        super();
    }
    
    @Override
    public Ordering<NetworkPlayerInfo> getField() {
        return MixinGuiPlayerTabOverlay.field_175252_a;
    }
    
    @Overwrite
    public String func_175243_a(final NetworkPlayerInfo networkPlayerInfoIn) {
        if (Teams.isClientFriend(networkPlayerInfoIn.func_178845_a().getName())) {
            return (networkPlayerInfoIn.func_178854_k() != null) ? ("§a[ClientFriend]§r" + networkPlayerInfoIn.func_178854_k().func_150254_d()) : ScorePlayerTeam.func_96667_a((Team)networkPlayerInfoIn.func_178850_i(), "§a[ClientFriend]§r" + networkPlayerInfoIn.func_178845_a().getName());
        }
        if (Teams.isMod(networkPlayerInfoIn.func_178845_a().getName())) {
            return (networkPlayerInfoIn.func_178854_k() != null) ? ("§b[MOD]§r" + networkPlayerInfoIn.func_178854_k().func_150254_d()) : ScorePlayerTeam.func_96667_a((Team)networkPlayerInfoIn.func_178850_i(), "§d[MOD]§r" + networkPlayerInfoIn.func_178845_a().getName());
        }
        if (Teams.isDev(networkPlayerInfoIn.func_178845_a().getName())) {
            return (networkPlayerInfoIn.func_178854_k() != null) ? ("§b[DEV]§r" + networkPlayerInfoIn.func_178854_k().func_150254_d()) : ScorePlayerTeam.func_96667_a((Team)networkPlayerInfoIn.func_178850_i(), "§d[DEV]§r" + networkPlayerInfoIn.func_178845_a().getName());
        }
        return (networkPlayerInfoIn.func_178854_k() != null) ? networkPlayerInfoIn.func_178854_k().func_150254_d() : ScorePlayerTeam.func_96667_a((Team)networkPlayerInfoIn.func_178850_i(), networkPlayerInfoIn.func_178845_a().getName());
    }
}
