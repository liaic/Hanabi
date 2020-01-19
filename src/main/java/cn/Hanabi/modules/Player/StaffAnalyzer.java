package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import java.util.*;
import net.minecraft.client.gui.*;
import com.darkmagician6.eventapi.*;
import ClassSub.*;
import cn.Hanabi.events.*;

public class StaffAnalyzer extends Mod
{
    public static String[] modlist;
    private String modname;
    public List<String> offlinemod;
    public List<String> onlinemod;
    private Value<Boolean> showOffline;
    private Value<Boolean> showOnline;
    private int counter;
    private boolean isFinished;
    public static Class99 ui;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public StaffAnalyzer() {
        super("StaffAnalyzer", Category.PLAYER);
        this.offlinemod = new ArrayList<String>();
        this.onlinemod = new ArrayList<String>();
        this.showOffline = new Value<Boolean>("StaffAnalyzer_ShowOffline", true);
        this.showOnline = new Value<Boolean>("StaffAnalyzer_ShowOnline", true);
        this.isFinished = false;
        StaffAnalyzer.ui = new Class99(StaffAnalyzer.mc, new ScaledResolution(StaffAnalyzer.mc));
    }
    
    @EventTarget
    public void onRender(final EventRender2D eventRender2D) {
    }
    
    @EventTarget
    public void onChat(final EventChat eventChat) {
        if (eventChat.getMessage().contains("分钟的聊天")) {
            StaffAnalyzer.mc.field_71439_g.func_71165_d("/chat a");
        }
        if (eventChat.getMessage().contains("这名玩家不在线！") || eventChat.getMessage().contains("That player is not online!")) {
            eventChat.setCancelled(true);
            if (this.onlinemod.contains(this.modname)) {
                Class295.tellPlayer("§b[Hanabi]§c" + this.modname + "§a已下线！");
                this.onlinemod.remove(this.modname);
                this.offlinemod.add(this.modname);
                return;
            }
            if (!this.offlinemod.contains(this.modname)) {
                Class295.tellPlayer("§b[Hanabi]§c" + this.modname + "§a不在线！");
                this.offlinemod.add(this.modname);
            }
        }
        if (eventChat.getMessage().contains("You cannot message this player.") || eventChat.getMessage().contains("分钟的聊天")) {
            eventChat.setCancelled(true);
            if (this.offlinemod.contains(this.modname)) {
                Class295.tellPlayer("§b[Hanabi]§c" + this.modname + "§a已上线！");
                this.offlinemod.remove(this.modname);
                this.onlinemod.add(this.modname);
                return;
            }
            if (!this.onlinemod.contains(this.modname)) {
                Class295.tellPlayer("§b[Hanabi]§c" + this.modname + "§a在线！");
                this.onlinemod.add(this.modname);
            }
        }
        if (eventChat.getMessage().contains("找不到名为 \"" + this.modname + "\" 的玩家")) {
            System.out.println(this.modname + "不存在！");
            eventChat.setCancelled(true);
        }
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotion eventPreMotion) {
        if (StaffAnalyzer.mc.field_71439_g.field_70173_aa % 120 == 0) {
            if (this.counter >= StaffAnalyzer.modlist.length) {
                this.counter = -1;
                if (!this.isFinished) {
                    this.isFinished = true;
                }
            }
            ++this.counter;
            this.modname = StaffAnalyzer.modlist[this.counter];
            StaffAnalyzer.mc.field_71439_g.func_71165_d("/msg " + this.modname);
        }
    }
    
    static {
        StaffAnalyzer.modlist = new String[] { "startover_", "小阿狸", "chen_xixi", "tanker_01", "SnowDay", "造化钟神秀", "Owenkill", "chen_duxiu", "绅士龙", "mxu" };
    }
}
