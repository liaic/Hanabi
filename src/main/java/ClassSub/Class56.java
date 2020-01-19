package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.events.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;

public class Class56
{
    Minecraft mc;
    Class191 lastFall;
    int stage;
    int aacCount;
    double speed;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class56() {
        super();
        this.mc = Minecraft.func_71410_x();
        this.lastFall = new Class191();
        this.stage = 0;
    }
    
    public void onMove(final EventMove eventMove) {
        if (ModManager.getModule("Scaffold").isEnabled()) {
            if (this.mc.field_71439_g.field_70122_E) {
                this.mc.field_71439_g.func_70664_aZ();
                eventMove.setY(this.mc.field_71439_g.field_70181_x);
            }
            return;
        }
        if (this.mc.field_71439_g.field_70143_R > 1.2) {
            this.lastFall.reset();
        }
        if (!this.isInLiquid() && this.mc.field_71439_g.field_70124_G && Class206.isOnGround(0.01) && (this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f)) {
            this.stage = 0;
            this.mc.field_71439_g.func_70664_aZ();
            eventMove.setY(this.mc.field_71439_g.field_70181_x = 0.41999998688698 + Class206.getJumpEffect());
            if (this.aacCount < 4) {
                ++this.aacCount;
            }
        }
        this.speed = this.getAACSpeed(this.stage, this.aacCount);
        if (this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f) {
            if (this.isInLiquid()) {
                this.speed = 0.075;
            }
            ((IEntityPlayerSP)this.mc.field_71439_g).setMoveSpeed(eventMove, this.speed);
        }
        if (this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f) {
            ++this.stage;
        }
    }
    
    public void onDisable() {
        this.aacCount = 0;
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
    
    private double getAACSpeed(final int n, final int n2) {
        double n3 = 0.29;
        final double n4 = 0.3019;
        final double n5 = 0.0286 - n / 1000.0;
        if (n == 0) {
            n3 = 0.497;
            if (n2 >= 2) {
                n3 += 0.1069;
            }
            if (n2 >= 3) {
                n3 += 0.046;
            }
            final Block blockUnderPlayer = Class206.getBlockUnderPlayer((EntityPlayer)this.mc.field_71439_g, 0.01);
            if (blockUnderPlayer instanceof BlockIce || blockUnderPlayer instanceof BlockPackedIce) {
                n3 = 0.59;
            }
        }
        else if (n == 1) {
            n3 = 0.3031;
            if (n2 >= 2) {
                n3 += 0.0642;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 2) {
            n3 = 0.302;
            if (n2 >= 2) {
                n3 += 0.0629;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 3) {
            n3 = n4;
            if (n2 >= 2) {
                n3 += 0.0607;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 4) {
            n3 = n4;
            if (n2 >= 2) {
                n3 += 0.0584;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 5) {
            n3 = n4;
            if (n2 >= 2) {
                n3 += 0.0561;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 6) {
            n3 = n4;
            if (n2 >= 2) {
                n3 += 0.0539;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 7) {
            n3 = n4;
            if (n2 >= 2) {
                n3 += 0.0517;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 8) {
            n3 = n4;
            if (Class206.isOnGround(0.05)) {
                n3 -= 0.002;
            }
            if (n2 >= 2) {
                n3 += 0.0496;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 9) {
            n3 = n4;
            if (n2 >= 2) {
                n3 += 0.0475;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 10) {
            n3 = n4;
            if (n2 >= 2) {
                n3 += 0.0455;
            }
            if (n2 >= 3) {
                n3 += n5;
            }
        }
        else if (n == 11) {
            n3 = 0.3;
            if (n2 >= 2) {
                n3 += 0.045;
            }
            if (n2 >= 3) {
                n3 += 0.018;
            }
        }
        else if (n == 12) {
            n3 = 0.301;
            if (n2 <= 2) {
                this.aacCount = 0;
            }
            if (n2 >= 2) {
                n3 += 0.042;
            }
            if (n2 >= 3) {
                n3 += n5 + 0.001;
            }
        }
        else if (n == 13) {
            n3 = 0.298;
            if (n2 >= 2) {
                n3 += 0.042;
            }
            if (n2 >= 3) {
                n3 += n5 + 0.001;
            }
        }
        else if (n == 14) {
            n3 = 0.297;
            if (n2 >= 2) {
                n3 += 0.042;
            }
            if (n2 >= 3) {
                n3 += n5 + 0.001;
            }
        }
        if (this.mc.field_71439_g.field_70701_bs <= 0.0f) {
            n3 -= 0.06;
        }
        if (this.mc.field_71439_g.field_70123_F) {
            n3 -= 0.1;
            this.aacCount = 0;
        }
        return n3;
    }
}
