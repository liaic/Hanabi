package cn.Hanabi.modules.Movement;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.*;
import com.darkmagician6.eventapi.*;
import ClassSub.*;
import cn.Hanabi.events.*;

public class Speed extends Mod
{
    public static Value mode;
    public Value<Boolean> lagback;
    Class282 GlobalHypixel;
    Class318 Hypixel;
    Class297 GudHop;
    Class56 AAC;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Speed() {
        super("Speed", Category.MOVEMENT);
        this.lagback = new Value<Boolean>("Speed_LagBackChecks", true);
        this.GlobalHypixel = new Class282();
        this.Hypixel = new Class318();
        this.GudHop = new Class297();
        this.AAC = new Class56();
        Speed.mode.addValue("AAC");
        Speed.mode.addValue("GudHop");
        Speed.mode.addValue("Hypixel");
        Speed.mode.addValue("HypixelGlobal");
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotion eventPreMotion) {
        if (Speed.mode.isCurrentMode("GudHop") || Hanabi.flag < 0) {
            this.setDisplayName("GudHop");
            this.GudHop.onPre(eventPreMotion);
            return;
        }
        if (Speed.mode.isCurrentMode("Hypixel")) {
            this.Hypixel.onPre(eventPreMotion);
        }
    }
    
    @EventTarget
    public void onPullback(final EventPullback eventPullback) {
        if ((boolean)this.lagback.getValueState()) {
            Class128.sendClientMessage("(LagBackCheck) Speed Disabled", Class67.Class124.WARNING);
            this.set(false);
        }
        if (Speed.mode.isCurrentMode("HypixelGlobal")) {
            this.GlobalHypixel.onPullback(eventPullback);
        }
    }
    
    @EventTarget
    public void onMove(final EventMove eventMove) {
        if (Speed.mode.isCurrentMode("HypixelGlobal")) {
            this.setDisplayName("HypixelGlobal");
            this.GlobalHypixel.onMove(eventMove);
            return;
        }
        if (Speed.mode.isCurrentMode("Hypixel")) {
            this.setDisplayName("Hypixel");
            this.Hypixel.onMove(eventMove);
            return;
        }
        if (Speed.mode.isCurrentMode("AAC")) {
            this.setDisplayName("AAC");
            this.AAC.onMove(eventMove);
        }
    }
    
    public void onDisable() {
        if (Speed.mode.isCurrentMode("HypixelGlobal")) {
            this.GlobalHypixel.onDisable();
            return;
        }
        if (Speed.mode.isCurrentMode("AAC")) {
            this.AAC.onDisable();
        }
    }
    
    public void onEnable() {
        if (Speed.mode.isCurrentMode("HypixelGlobal")) {
            this.GlobalHypixel.onEnable();
            return;
        }
        if (Speed.mode.isCurrentMode("Hypixel")) {
            this.Hypixel.onEnable();
        }
    }
    
    static {
        Speed.mode = new Value("Speed", "Mode", 5);
    }
}
