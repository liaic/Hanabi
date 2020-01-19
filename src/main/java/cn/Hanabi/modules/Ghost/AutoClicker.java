package cn.Hanabi.modules.Ghost;

import ClassSub.*;
import java.util.*;
import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.injection.interfaces.*;
import cn.Hanabi.events.*;
import net.minecraft.item.*;
import net.minecraft.client.entity.*;

public class AutoClicker extends Mod
{
    private Class191 left;
    private Class191 right;
    Random random;
    public static boolean isClicking;
    public boolean isDone;
    public int timer;
    public Value<Double> maxCps;
    public Value<Double> minCps;
    public Value<Boolean> blockHit;
    public Value<Boolean> jitter;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public AutoClicker() {
        super("AutoClicker", Category.GHOST);
        this.left = new Class191();
        this.right = new Class191();
        this.random = new Random();
        this.isDone = true;
        this.maxCps = new Value<Double>("AutoClicker_MaxCPS", 12.0, 1.0, 20.0, 1.0);
        this.minCps = new Value<Double>("AutoClicker_MinCPS", 8.0, 1.0, 20.0, 1.0);
        this.blockHit = new Value<Boolean>("AutoClicker_BlockHit", false);
        this.jitter = new Value<Boolean>("AutoClicker_Jitter", false);
    }
    
    public void onEnable() {
        this.isDone = true;
        this.timer = 0;
        super.onEnable();
    }
    
    public void onDisable() {
        this.isDone = true;
        super.onDisable();
    }
    
    private long getDelay() {
        return (long)((int)(Object)this.maxCps.getValueState() + this.random.nextDouble() * ((int)(Object)this.minCps.getValueState() - (int)(Object)this.maxCps.getValueState()));
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (AutoClicker.mc.field_71439_g != null) {
            AutoClicker.isClicking = false;
            if ((int)(Object)this.minCps.getValueState() > (int)(Object)this.maxCps.getValueState()) {
                this.minCps.setValueState((double)(Double)this.maxCps.getValueState());
            }
            if (((IKeyBinding)AutoClicker.mc.field_71474_y.field_74312_F).getPress() && AutoClicker.mc.field_71439_g.func_71039_bw()) {
                this.swingItemNoPacket();
            }
            if (((IKeyBinding)AutoClicker.mc.field_71474_y.field_74312_F).getPress() && !AutoClicker.mc.field_71439_g.func_71039_bw() && this.left.isDelayComplete(Double.valueOf(1000.0 / (double)this.getDelay()))) {
                if ((boolean)this.jitter.getValueState()) {
                    this.jitter(this.random);
                }
                ((IMinecraft)AutoClicker.mc).setClickCounter(0);
                ((IMinecraft)AutoClicker.mc).runCrinkMouse();
                AutoClicker.isClicking = true;
                this.left.reset();
            }
        }
        if (!this.isDone) {
            switch (this.timer) {
                case 0: {
                    ((IKeyBinding)AutoClicker.mc.field_71474_y.field_74313_G).setPress(false);
                    break;
                }
                case 1:
                case 2: {
                    ((IKeyBinding)AutoClicker.mc.field_71474_y.field_74313_G).setPress(true);
                    break;
                }
                case 3: {
                    ((IKeyBinding)AutoClicker.mc.field_71474_y.field_74313_G).setPress(false);
                    this.isDone = true;
                    this.timer = -1;
                    break;
                }
            }
            ++this.timer;
        }
    }
    
    public void swingItemNoPacket() {
        if (!AutoClicker.mc.field_71439_g.field_82175_bq || AutoClicker.mc.field_71439_g.field_110158_av >= ((IEntityLivingBase)AutoClicker.mc.field_71439_g).runGetArmSwingAnimationEnd() / 2 || AutoClicker.mc.field_71439_g.field_110158_av < 0) {
            AutoClicker.mc.field_71439_g.field_110158_av = -1;
            AutoClicker.mc.field_71439_g.field_82175_bq = true;
        }
    }
    
    @EventTarget
    public void onCrink(final EventClickMouse eventClickMouse) {
        final ItemStack func_71045_bC = AutoClicker.mc.field_71439_g.func_71045_bC();
        if (func_71045_bC != null && this.blockHit.getValueState() && func_71045_bC.func_77973_b() instanceof ItemSword && !AutoClicker.mc.field_71439_g.func_71039_bw()) {
            if (!this.isDone || this.timer > 0) {
                return;
            }
            this.isDone = false;
        }
    }
    
    public void jitter(final Random random) {
        if (random.nextBoolean()) {
            if (random.nextBoolean()) {
                final EntityPlayerSP field_71439_g = AutoClicker.mc.field_71439_g;
                field_71439_g.field_70125_A -= (float)(random.nextFloat() * 0.6);
            }
            else {
                final EntityPlayerSP field_71439_g2 = AutoClicker.mc.field_71439_g;
                field_71439_g2.field_70125_A += (float)(random.nextFloat() * 0.6);
            }
        }
        else if (random.nextBoolean()) {
            final EntityPlayerSP field_71439_g3 = AutoClicker.mc.field_71439_g;
            field_71439_g3.field_70177_z -= (float)(random.nextFloat() * 0.6);
        }
        else {
            final EntityPlayerSP field_71439_g4 = AutoClicker.mc.field_71439_g;
            field_71439_g4.field_70177_z += (float)(random.nextFloat() * 0.6);
        }
    }
    
    static {
        AutoClicker.isClicking = false;
    }
}
