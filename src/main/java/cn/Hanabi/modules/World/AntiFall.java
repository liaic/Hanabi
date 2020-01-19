package cn.Hanabi.modules.World;

import net.minecraft.util.*;
import cn.Hanabi.value.*;
import ClassSub.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.block.*;
import cn.Hanabi.events.*;
import cn.Hanabi.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.entity.*;

public class AntiFall extends Mod
{
    BlockPos lastGroundPos;
    Class191 timer;
    Class191 timer2;
    Class191 spacetimer;
    public Value<Double> falldistance;
    public Value<Boolean> onlyvoid;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public AntiFall() {
        super("AntiFall", Category.WORLD);
        this.timer = new Class191();
        this.timer2 = new Class191();
        this.spacetimer = new Class191();
        this.falldistance = new Value<Double>("AntiFall_FallDistance", 10.0, 5.0, 30.0, 0.1);
        this.onlyvoid = new Value<Boolean>("AntiFall_OnlyVoid", true);
    }
    
    @EventTarget
    public void onKey(final EventKey eventKey) {
        if (Class69.username.length() < 1) {
            System.exit(0);
        }
        if (eventKey.getKey() == 57) {
            this.spacetimer.reset();
        }
    }
    
    private boolean isBlockUnder() {
        for (int i = (int)(AntiFall.mc.field_71439_g.field_70163_u - 1.0); i > 0; --i) {
            if (!(AntiFall.mc.field_71441_e.func_180495_p(new BlockPos(AntiFall.mc.field_71439_g.field_70165_t, (double)i, AntiFall.mc.field_71439_g.field_70161_v)).func_177230_c() instanceof BlockAir)) {
                return true;
            }
        }
        return false;
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (Class69.username.length() < 1) {
            System.exit(0);
        }
        boolean b = true;
        if (AntiFall.mc.field_71439_g.field_70143_R > this.falldistance.getValueState() && (!(boolean)this.onlyvoid.getValueState() || !this.isBlockUnder())) {
            b = false;
        }
        if (Hanabi.flag > 0) {
            if (AntiFall.mc.field_71439_g.field_70122_E && this.timer.isDelayComplete(1000L)) {
                this.lastGroundPos = AntiFall.mc.field_71439_g.func_180425_c();
                this.timer.reset();
            }
            if (!b && this.spacetimer.isDelayComplete(800L) && !ModManager.getModule("Fly").isEnabled()) {
                AntiFall.mc.field_71439_g.func_70107_b((double)this.lastGroundPos.func_177958_n(), (double)this.lastGroundPos.func_177956_o(), (double)this.lastGroundPos.func_177952_p());
            }
        }
        else if (AntiFall.mc.field_71439_g.field_70181_x < 0.0) {
            final EntityPlayerSP field_71439_g = AntiFall.mc.field_71439_g;
            field_71439_g.field_70181_x *= 1.2;
        }
    }
}
