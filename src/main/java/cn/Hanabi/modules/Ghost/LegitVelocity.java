package cn.Hanabi.modules.Ghost;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.client.entity.*;
import com.darkmagician6.eventapi.*;

public class LegitVelocity extends Mod
{
    public Value<Double> chance;
    public Value<Double> verti;
    public Value<Double> hori;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public LegitVelocity() {
        super("LegitVelocity", Category.GHOST);
        this.chance = new Value<Double>("LegitVelocity_Chance", 100.0, 0.0, 100.0, 1.0);
        this.verti = new Value<Double>("LegitVelocity_Vertical", 100.0, 0.0, 100.0, 1.0);
        this.hori = new Value<Double>("LegitVelocity_Horizontal", 100.0, 0.0, 100.0, 1.0);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (LegitVelocity.mc.field_71439_g.field_70771_an != LegitVelocity.mc.field_71439_g.field_70172_ad || LegitVelocity.mc.field_71439_g.field_70771_an == 0) {
            return;
        }
        if (Double.valueOf((double)Double.valueOf(Math.random()) * 100.0) < (int)(Object)this.chance.getValueState()) {
            final float n = (float)(Object)this.hori.getValueState() / 100.0f;
            final float n2 = (float)(Object)this.verti.getValueState() / 100.0f;
            final EntityPlayerSP field_71439_g = LegitVelocity.mc.field_71439_g;
            field_71439_g.field_70159_w *= n;
            final EntityPlayerSP field_71439_g2 = LegitVelocity.mc.field_71439_g;
            field_71439_g2.field_70179_y *= n;
            final EntityPlayerSP field_71439_g3 = LegitVelocity.mc.field_71439_g;
            field_71439_g3.field_70181_x *= n2;
        }
        else {
            final EntityPlayerSP field_71439_g4 = LegitVelocity.mc.field_71439_g;
            field_71439_g4.field_70159_w *= 1.0;
            final EntityPlayerSP field_71439_g5 = LegitVelocity.mc.field_71439_g;
            field_71439_g5.field_70181_x *= 1.0;
            final EntityPlayerSP field_71439_g6 = LegitVelocity.mc.field_71439_g;
            field_71439_g6.field_70179_y *= 1.0;
        }
    }
}
