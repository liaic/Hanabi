package cn.Hanabi.modules.Combat;

import cn.Hanabi.value.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.*;
import java.util.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.network.*;

public class AntiBot extends Mod
{
    private static Value mode;
    public int count;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public AntiBot() {
        super("AntiBot", Category.COMBAT);
        this.count = 0;
        AntiBot.mode.addValue("Hypixel");
        AntiBot.mode.addValue("Mineplex");
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (AntiBot.mode.isCurrentMode("Hypixel")) {
            for (final EntityPlayer entityPlayer : AntiBot.mc.field_71441_e.field_73010_i) {
                if (entityPlayer != AntiBot.mc.field_71439_g && entityPlayer != null && !getTabPlayerList().contains(entityPlayer) && !entityPlayer.func_145748_c_().func_150254_d().toLowerCase().contains("[npc") && entityPlayer.func_145748_c_().func_150254_d().startsWith("§") && entityPlayer.func_70089_S() && !isHypixelNPC(entityPlayer)) {
                    AntiBot.mc.field_71441_e.func_72900_e((Entity)entityPlayer);
                    ++this.count;
                }
            }
            this.setDisplayName("Hypixel");
        }
        if (AntiBot.mode.isCurrentMode("Mineplex")) {
            this.setDisplayName("Mineplex");
        }
    }
    
    public static boolean isBot(final Entity entity) {
        if (!(entity instanceof EntityPlayer) || !ModManager.getModule("AntiBot").isEnabled()) {
            return false;
        }
        final EntityPlayer entityPlayer = (EntityPlayer)entity;
        if (AntiBot.mode.isCurrentMode("Hypixel")) {
            return !getTabPlayerList().contains(entityPlayer) || isHypixelNPC(entityPlayer);
        }
        return AntiBot.mode.isCurrentMode("Mineplex") && !Float.isNaN(entityPlayer.func_110143_aJ());
    }
    
    public static List<EntityPlayer> getTabPlayerList() {
        final NetHandlerPlayClient field_71174_a = Minecraft.func_71410_x().field_71439_g.field_71174_a;
        final ArrayList<EntityPlayer> list = new ArrayList<EntityPlayer>();
        for (final NetworkPlayerInfo networkPlayerInfo : ((IGuiPlayerTabOverlay)new GuiPlayerTabOverlay(Minecraft.func_71410_x(), Minecraft.func_71410_x().field_71456_v)).getField().sortedCopy((Iterable)field_71174_a.func_175106_d())) {
            if (networkPlayerInfo == null) {
                continue;
            }
            list.add(Minecraft.func_71410_x().field_71441_e.func_72924_a(networkPlayerInfo.func_178845_a().getName()));
        }
        return list;
    }
    
    public static boolean isHypixelNPC(final EntityPlayer entityPlayer) {
        final String substring = entityPlayer.func_145748_c_().func_150254_d().substring(2);
        entityPlayer.func_95999_t();
        return (!substring.startsWith("§") && substring.endsWith("§r")) || substring.contains("[NPC]");
    }
    
    static {
        AntiBot.mode = new Value("AntiBot", "Mode", 0);
    }
}
