package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.events.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public class Class282
{
    public boolean shouldslow;
    Minecraft mc;
    boolean collided;
    boolean lessSlow;
    private int stage;
    private int stageOG;
    private double moveSpeed;
    private double lastDist;
    double less;
    double stair;
    private double speed;
    private double speedvalue;
    Class191 timer;
    Class191 lastCheck;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class282() {
        super();
        this.shouldslow = false;
        this.mc = Minecraft.func_71410_x();
        this.stage = 1;
        this.stageOG = 1;
        this.speed = 0.07999999821186066;
        this.timer = new Class191();
        this.lastCheck = new Class191();
    }
    
    public void onPullback(final EventPullback eventPullback) {
        this.stage = -4;
    }
    
    public void onUpdate(final EventUpdate eventUpdate) {
        this.lastDist = Math.sqrt((this.mc.field_71439_g.field_70165_t - this.mc.field_71439_g.field_70169_q) * (this.mc.field_71439_g.field_70165_t - this.mc.field_71439_g.field_70169_q) + (this.mc.field_71439_g.field_70161_v - this.mc.field_71439_g.field_70166_s) * (this.mc.field_71439_g.field_70161_v - this.mc.field_71439_g.field_70166_s));
    }
    
    private double getHypixelSpeed(final int n) {
        double n2 = defaultSpeed() + 0.028 * this.getSpeedEffect() + this.getSpeedEffect() / 15.0;
        final double n3 = 0.4145 + this.getSpeedEffect() / 12.5;
        final double n4 = 0.4045 + this.getSpeedEffect() / 12.5;
        final double n5 = n / 500.0 * 3.0;
        if (n == 0) {
            if (this.timer.isDelayComplete(300L)) {
                this.timer.reset();
            }
            if (!this.lastCheck.isDelayComplete(500L)) {
                if (!this.shouldslow) {
                    this.shouldslow = true;
                }
            }
            else if (this.shouldslow) {
                this.shouldslow = false;
            }
            n2 = 0.64 + (this.getSpeedEffect() + 0.028 * this.getSpeedEffect()) * 0.134;
        }
        else if (n == 1) {
            n2 = n3;
        }
        else if (n == 2) {
            if (Class296.getTimer().field_74278_d == 1.354f) {}
            n2 = n4;
        }
        else if (n >= 3) {
            if (Class296.getTimer().field_74278_d == 1.254f) {}
            n2 = n4 - n5;
        }
        if (this.shouldslow || !this.lastCheck.isDelayComplete(500L) || this.collided) {
            n2 = 0.2;
            if (n == 0) {
                n2 = 0.0;
            }
        }
        return Math.max(n2, this.shouldslow ? n2 : (defaultSpeed() + 0.028 * this.getSpeedEffect()));
    }
    
    public void onMove(final EventMove eventMove) {
        if (this.mc.field_71439_g.field_70123_F) {
            this.collided = true;
        }
        if (this.collided) {
            Class296.getTimer().field_74278_d = 1.0f;
            this.stage = -1;
        }
        if (this.stair > 0.0) {
            this.stair -= 0.25;
        }
        this.less -= ((this.less > 1.0) ? 0.12 : 0.11);
        if (this.less < 0.0) {
            this.less = 0.0;
        }
        if (!this.isInLiquid() && this.isOnGround(0.01) && this.isMoving2()) {
            this.collided = this.mc.field_71439_g.field_70123_F;
            if (this.stage >= 0 || this.collided) {
                this.stage = 0;
                final double field_70181_x = 0.4086666 + this.getJumpEffect() * 0.1;
                if (this.stair == 0.0) {
                    this.mc.field_71439_g.func_70664_aZ();
                    eventMove.setY(this.mc.field_71439_g.field_70181_x = field_70181_x);
                }
                ++this.less;
                if (this.less > 1.0 && !this.lessSlow) {
                    this.lessSlow = true;
                }
                else {
                    this.lessSlow = false;
                }
                if (this.less > 1.12) {
                    this.less = 1.12;
                }
            }
        }
        this.speed = this.getHypixelSpeed(this.stage) + 0.0331;
        this.speed *= 0.91;
        if (this.stair > 0.0) {
            this.speed *= 0.7 - this.getSpeedEffect() * 0.1;
        }
        if (this.stage < 0) {
            this.speed = defaultSpeed();
        }
        if (this.lessSlow) {
            this.speed *= 0.96;
        }
        if (this.lessSlow) {
            this.speed *= 0.95;
        }
        if (this.isInLiquid()) {
            this.speed = 0.12;
        }
        if (this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f) {
            if (!ModManager.getModule("Scaffold").getState() || !Scaffold.mode.isCurrentMode("HypixelGlobal")) {
                this.setMotion(eventMove, this.speed);
            }
            ++this.stage;
        }
    }
    
    private void setMotion(final EventMove eventMove, final double n) {
        double n2 = (double)this.mc.field_71439_g.field_71158_b.field_78900_b;
        double n3 = (double)this.mc.field_71439_g.field_71158_b.field_78902_a;
        float field_70177_z = this.mc.field_71439_g.field_70177_z;
        if (n2 == 0.0 && n3 == 0.0) {
            eventMove.setX(0.0);
            eventMove.setZ(0.0);
        }
        else {
            if (n2 != 0.0) {
                if (n3 > 0.0) {
                    field_70177_z += ((n2 > 0.0) ? -45 : 45);
                }
                else if (n3 < 0.0) {
                    field_70177_z += ((n2 > 0.0) ? 45 : -45);
                }
                n3 = 0.0;
                if (n2 > 0.0) {
                    n2 = 1.0;
                }
                else if (n2 < 0.0) {
                    n2 = -1.0;
                }
            }
            eventMove.setX(this.mc.field_71439_g.field_70159_w = n2 * n * Math.cos(Math.toRadians((double)field_70177_z + 88.0)) + n3 * n * Math.sin(Math.toRadians((double)field_70177_z + 87.9000015258789)));
            eventMove.setZ(this.mc.field_71439_g.field_70179_y = n2 * n * Math.sin(Math.toRadians((double)field_70177_z + 88.0)) - n3 * n * Math.cos(Math.toRadians((double)field_70177_z + 87.9000015258789)));
        }
    }
    
    public boolean isMoving2() {
        return this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f;
    }
    
    public boolean isOnGround(final double n) {
        return !this.mc.field_71441_e.func_72945_a((Entity)this.mc.field_71439_g, this.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, -n, 0.0)).isEmpty();
    }
    
    public int getJumpEffect() {
        if (this.mc.field_71439_g.func_70644_a(Potion.field_76430_j)) {
            return this.mc.field_71439_g.func_70660_b(Potion.field_76430_j).func_76458_c() + 1;
        }
        return 0;
    }
    
    public int getSpeedEffect() {
        if (this.mc.field_71439_g.func_70644_a(Potion.field_76424_c)) {
            return this.mc.field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1;
        }
        return 0;
    }
    
    public boolean isInLiquid() {
        if (this.mc.field_71439_g.func_70090_H()) {
            return true;
        }
        boolean b = false;
        final int n = (int)this.mc.field_71439_g.func_174813_aQ().field_72338_b;
        for (int i = MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72340_a); i < MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72336_d) + 1; ++i) {
            for (int j = MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72339_c); j < MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72334_f) + 1; ++j) {
                final Block func_177230_c = this.mc.field_71441_e.func_180495_p(new BlockPos(i, n, j)).func_177230_c();
                if (func_177230_c != null && func_177230_c.func_149688_o() != Material.field_151579_a) {
                    if (!(func_177230_c instanceof BlockLiquid)) {
                        return false;
                    }
                    b = true;
                }
            }
        }
        return b;
    }
    
    public void onEnable() {
        this.lessSlow = false;
        this.moveSpeed = defaultSpeed();
        this.less = 0.0;
        this.lastDist = 0.0;
        this.stage = 2;
        this.stage = 1;
        this.stage = 2;
        Class296.getTimer().field_74278_d = 1.0f;
        this.lessSlow = this.mc.field_71439_g.field_71071_by.field_70459_e;
    }
    
    public static double defaultSpeed() {
        double n = 0.2873;
        if (Minecraft.func_71410_x().field_71439_g.func_70644_a(Potion.field_76424_c)) {
            n *= 1.0 + 0.2 * (Minecraft.func_71410_x().field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1);
        }
        return n;
    }
    
    public void onDisable() {
        Class296.getTimer().field_74278_d = 1.0f;
    }
}
