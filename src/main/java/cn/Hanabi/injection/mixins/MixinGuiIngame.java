package cn.Hanabi.injection.mixins;

import net.minecraftforge.fml.relauncher.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import net.minecraft.client.renderer.*;
import cn.Hanabi.modules.*;
import org.spongepowered.asm.mixin.injection.*;
import cn.Hanabi.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import ClassSub.*;
import net.minecraft.scoreboard.*;
import java.util.*;

@SideOnly(Side.CLIENT)
@Mixin({ GuiIngame.class })
public class MixinGuiIngame
{
    public MixinGuiIngame() {
        super();
    }
    
    @Inject(method = { "renderTooltip" }, at = { @At("HEAD") }, cancellable = true)
    private void renderTooltip(final ScaledResolution sr, final float partialTicks, final CallbackInfo ci) {
        EventManager.call((Event)new EventRender2D(partialTicks));
        GlStateManager.func_179124_c(1.0f, 1.0f, 1.0f);
        if (ModManager.getModule("HUD").isEnabled() && Class218.hotbar.getValueState()) {
            ci.cancel();
        }
    }
    
    @Inject(method = { "renderScoreboard" }, at = { @At("HEAD") }, cancellable = true)
    public void customBoard(final ScoreObjective so, final ScaledResolution sr, final CallbackInfo info) {
        if (Hanabi.INSTANCE.sbm == null) {
            final Scoreboard scoreboard = so.func_96682_a();
            Collection<Score> collection = (Collection<Score>)scoreboard.func_96534_i(so);
            final List<Score> list = (List<Score>)Lists.newArrayList(Iterables.filter((Iterable)collection, (Predicate)new Predicate<Score>(this) {
                final MixinGuiIngame this$0;
                
                MixinGuiIngame$1(final MixinGuiIngame this$0) {
                    this.this$0 = this$0;
                    super();
                }
                
                public boolean apply(final Score a) {
                    return a.func_96653_e() != null && !a.func_96653_e().startsWith("#");
                }
                
                public boolean apply(final Object o) {
                    return this.apply((Score)o);
                }
            }));
            if (list.size() > 15) {
                collection = (Collection<Score>)Lists.newArrayList(Iterables.skip((Iterable)list, collection.size() - 15));
            }
            else {
                collection = list;
            }
            int maxLength = Minecraft.func_71410_x().field_71466_p.func_78256_a(so.func_96678_d());
            for (final Score score : collection) {
                final ScorePlayerTeam scoreplayerteam = scoreboard.func_96509_i(score.func_96653_e());
                final String s = ScorePlayerTeam.func_96667_a((Team)scoreplayerteam, score.func_96653_e()) + ": " + EnumChatFormatting.RED + score.func_96652_c();
                maxLength = Math.max(maxLength, Minecraft.func_71410_x().field_71466_p.func_78256_a(s));
            }
            final int i1 = collection.size() * Minecraft.func_71410_x().field_71466_p.field_78288_b;
            final int startY = sr.func_78328_b() / 2 + i1 / 3;
            Hanabi.INSTANCE.sbm = new Class78(sr.func_78326_a() - maxLength - 4, startY);
        }
        if (Hanabi.INSTANCE.sbm != null) {
            Hanabi.INSTANCE.sbm.passValue();
        }
        info.cancel();
    }
}
