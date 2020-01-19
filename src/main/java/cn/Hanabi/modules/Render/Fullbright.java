package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.potion.*;
import com.darkmagician6.eventapi.*;

public class Fullbright extends Mod
{
    private Value<String> mode;
    public float oldGammaSetting;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Fullbright() {
        super("Fullbright", Category.RENDER);
        (this.mode = new Value<String>("Fullbright", "Mode", 0)).addValue("Gamma");
        this.mode.addValue("Potion");
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (this.mode.isCurrentMode("Gamma")) {
            this.oldGammaSetting = Fullbright.mc.field_71474_y.field_74333_Y;
            Fullbright.mc.field_71474_y.field_74333_Y = 1000.0f;
        }
        if (this.mode.isCurrentMode("Potion")) {
            Fullbright.mc.field_71439_g.func_70690_d(new PotionEffect(Potion.field_76439_r.func_76396_c(), 4000, 1));
        }
    }
    
    public void onEnable() {
        super.onEnable();
    }
    
    public void onDisable() {
        Fullbright.mc.field_71474_y.field_74333_Y = this.oldGammaSetting;
        super.onDisable();
    }
}
