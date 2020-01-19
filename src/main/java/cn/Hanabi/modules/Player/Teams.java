package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import java.util.*;
import cn.Hanabi.events.*;
import net.minecraft.client.*;
import ClassSub.*;
import cn.Hanabi.modules.World.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.modules.*;

public class Teams extends Mod
{
    public static Value<Boolean> clientfriend;
    public static Value<Boolean> hyt4v4;
    Class191 delayt;
    Class191 delayt2;
    public static ArrayList<EntityPlayer> teammates;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Teams() {
        super("Teams", Category.PLAYER);
        this.delayt = new Class191();
        this.delayt2 = new Class191();
    }
    
    public void onDisable() {
    }
    
    public ArrayList<EntityPlayer> team() {
        final ArrayList<EntityPlayer> list = new ArrayList<EntityPlayer>();
        try {
            for (final Entity entity : Teams.mc.field_71441_e.field_72996_f) {
                if (entity instanceof EntityPlayer) {
                    final EntityPlayer entityPlayer = (EntityPlayer)entity;
                    if (entityPlayer == Teams.mc.field_71439_g) {
                        continue;
                    }
                    if (entityPlayer.field_71071_by.field_70460_b[2] == null) {
                        continue;
                    }
                    final String string = entityPlayer.field_71071_by.field_70460_b[2].func_77978_p().func_74781_a("display").toString();
                    if (Teams.mc.field_71439_g.field_71071_by.field_70460_b[2] == null || !Teams.mc.field_71439_g.field_71071_by.field_70460_b[2].func_77978_p().func_74781_a("display").toString().contains(string)) {
                        continue;
                    }
                    list.add(entityPlayer);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if ((boolean)Teams.hyt4v4.getValueState()) {
            Teams.teammates = this.team();
        }
        if (this.delayt.isDelayComplete(15000L)) {
            if ((boolean)Teams.clientfriend.getValueState()) {
                IRC.sendIRCMessage(Minecraft.func_71410_x().field_71439_g.func_70005_c_() + "|" + (Class69.isMod ? "MOD" : "CLIENTFRIEND"), false);
            }
            else {
                IRC.sendIRCMessage(Minecraft.func_71410_x().field_71439_g.func_70005_c_() + "|" + (Class69.isMod ? "MOD" : "NOCLIENTFRIEND"), false);
            }
            this.delayt.reset();
        }
    }
    
    public static boolean isDev(final String s) {
        return s.equals(IRC.DevName);
    }
    
    public static boolean isMod(final String s) {
        final Iterator<String> iterator = IRC.ModList.iterator();
        while (iterator.hasNext()) {
            if (s.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isOnSameTeam(final Entity entity) {
        if (Teams.hyt4v4.getValueState() && Teams.teammates.contains(entity)) {
            return true;
        }
        if (isDev(entity.func_70005_c_())) {
            return true;
        }
        if (isMod(entity.func_70005_c_()) && !Class69.isDebugMode) {
            return true;
        }
        if (Teams.clientfriend.getValueState() && isClientFriend(entity)) {
            return true;
        }
        if (ModManager.getModule("Teams").isEnabled() && Minecraft.func_71410_x().field_71439_g.func_145748_c_().func_150260_c().startsWith("§")) {
            if (Minecraft.func_71410_x().field_71439_g.func_145748_c_().func_150260_c().length() <= 2 || entity.func_145748_c_().func_150260_c().length() <= 2) {
                return false;
            }
            if (Minecraft.func_71410_x().field_71439_g.func_145748_c_().func_150260_c().substring(0, 2).equals(entity.func_145748_c_().func_150260_c().substring(0, 2))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isClientFriend(final Entity entity) {
        if (!(boolean)Teams.clientfriend.getValueState()) {
            return false;
        }
        final Iterator<String> iterator = IRC.FriendList.iterator();
        while (iterator.hasNext()) {
            if (entity.func_70005_c_().equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isClientFriend(final String s) {
        if (!(boolean)Teams.clientfriend.getValueState()) {
            return false;
        }
        final Iterator<String> iterator = IRC.FriendList.iterator();
        while (iterator.hasNext()) {
            if (s.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    static {
        Teams.clientfriend = new Value<Boolean>("Teams_ClientFriends", true);
        Teams.hyt4v4 = new Value<Boolean>("Teams_HuaYuTing4V4", true);
    }
}
