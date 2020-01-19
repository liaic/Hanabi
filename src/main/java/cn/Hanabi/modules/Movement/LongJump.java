package cn.Hanabi.modules.Movement;

import cn.Hanabi.value.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.injection.interfaces.*;
import cn.Hanabi.events.*;
import ClassSub.*;

public class LongJump extends Mod
{
    private Value<String> mode;
    private Value<Boolean> lagback;
    private Class191 timer;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    @EventTarget
    public void onPullback(final EventPullback eventPullback) {
        if ((boolean)this.lagback.getValueState()) {
            Class128.sendClientMessage("LongJump Lagback Checked", Class67.Class124.WARNING);
            this.set(false);
        }
    }
    
    public LongJump() {
        super("LongJump", Category.MOVEMENT);
        this.mode = new Value<String>("LongJump", "Mode", 0);
        this.lagback = new Value<Boolean>("LongJump_LagBackChecks", false);
        this.timer = new Class191();
        this.mode.mode.add("Hypixel");
    }
    
    public void onEnable() {
        this.timer.reset();
        ((IKeyBinding)LongJump.mc.field_71474_y.field_74314_A).setPress(true);
        super.onEnable();
    }
    
    public void onDisable() {
        ((IKeyBinding)LongJump.mc.field_71474_y.field_74314_A).setPress(false);
        super.onDisable();
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotion eventPreMotion) {
        if ((this.timer.isDelayComplete(200L) && LongJump.mc.field_71439_g.field_70122_E) || this.timer.isDelayComplete(2000L)) {
            this.set(false);
        }
        if (this.mode.isCurrentMode("Hypixel") && Class295.MovementInput() && LongJump.mc.field_71439_g.field_70143_R < 1.0f) {
            final float field_70177_z = LongJump.mc.field_71439_g.field_70177_z;
            final float n = (float)Math.cos((field_70177_z + 90.0f) * 3.141592653589793 / 180.0);
            final float n2 = (float)Math.sin((field_70177_z + 90.0f) * 3.141592653589793 / 180.0);
            if (LongJump.mc.field_71439_g.field_70124_G && Class295.MovementInput() && ((IKeyBinding)LongJump.mc.field_71474_y.field_74314_A).getPress()) {
                LongJump.mc.field_71439_g.field_70159_w = n * 0.29f;
                LongJump.mc.field_71439_g.field_70179_y = n2 * 0.29f;
            }
            if (LongJump.mc.field_71439_g.field_70181_x == 0.33319999363422365 && Class295.MovementInput()) {
                LongJump.mc.field_71439_g.field_70159_w = n * 1.161;
                LongJump.mc.field_71439_g.field_70179_y = n2 * 1.161;
            }
        }
    }
}
