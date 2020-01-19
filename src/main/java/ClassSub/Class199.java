package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.value.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.block.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.network.*;
import java.math.*;
import java.util.*;

public class Class199
{
    Minecraft mc;
    int level;
    double moveSpeed;
    double lastDist;
    private boolean b2;
    public int stage;
    private boolean decreasing2;
    private boolean hypixelboost;
    private boolean canboost;
    private boolean keepy;
    private double starty;
    public static double hypixel;
    private float timervalue;
    public static int fastFlew;
    double count;
    Class191 timer;
    Value<String> mode;
    Value<Boolean> uhc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class199() {
        super();
        this.mc = Minecraft.func_71410_x();
        this.level = 1;
        this.timer = new Class191();
        this.mode = new Value<String>("Fly", "HypixelMode", 0);
        this.uhc = new Value<Boolean>("Fly_UHCZoom", false);
        this.mode.addValue("Normal");
        this.mode.addValue("Boost");
        this.mode.addValue("Zoom");
    }
    
    public void onLagback(final EventPullback eventPullback) {
        Class199.hypixel = 0.0;
    }
    
    public static Block getBlockUnderPlayer(final EntityPlayer entityPlayer, final double n) {
        return Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(entityPlayer.field_70165_t, entityPlayer.field_70163_u - n, entityPlayer.field_70161_v)).func_177230_c();
    }
    
    public void onPacket(final EventPacket eventPacket) {
        final Block blockUnderPlayer = getBlockUnderPlayer((EntityPlayer)this.mc.field_71439_g, 0.2);
        if (eventPacket.packet instanceof C03PacketPlayer && !this.isOnGround(1.0E-7) && !blockUnderPlayer.func_149730_j() && !(blockUnderPlayer instanceof BlockGlass)) {
            ((IC03PacketPlayer)eventPacket.packet).setOnGround(false);
        }
    }
    
    public void onPre(final EventPreMotion eventPreMotion) {
        if (this.mode.isCurrentMode("Normal")) {
            if (this.mc.field_71439_g.field_70122_E) {
                this.mc.field_71439_g.func_70664_aZ();
            }
            else {
                this.mc.field_71439_g.field_70181_x = 0.0;
                switch (++this.stage) {
                    case 1: {
                        this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 1.0E-12, this.mc.field_71439_g.field_70161_v);
                        break;
                    }
                    case 2: {
                        this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u - 1.0E-12, this.mc.field_71439_g.field_70161_v);
                        break;
                    }
                    case 3: {
                        this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 1.0E-12, this.mc.field_71439_g.field_70161_v);
                        this.stage = 0;
                        break;
                    }
                }
            }
            Class295.setSpeed(Class295.getSpeed());
        }
        if (this.mode.isCurrentMode("Boost")) {
            final double n = this.mc.field_71439_g.field_70165_t - this.mc.field_71439_g.field_70169_q;
            final double n2 = this.mc.field_71439_g.field_70161_v - this.mc.field_71439_g.field_70166_s;
            this.lastDist = Math.sqrt(n * n + n2 * n2);
            if (this.canboost && this.hypixelboost) {
                this.timervalue += (this.decreasing2 ? -0.01 : 0.05);
                if (this.timervalue >= 1.4) {
                    this.decreasing2 = true;
                }
                if (this.timervalue <= 0.9) {
                    this.decreasing2 = false;
                }
                if (this.timer.isDelayComplete(4000L)) {
                    this.canboost = false;
                }
            }
            if (this.mc.field_71474_y.field_74314_A.func_151470_d()) {
                this.mc.field_71439_g.func_70634_a(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 0.4, this.mc.field_71439_g.field_70161_v);
                this.mc.field_71439_g.field_70181_x = 0.8;
                final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
                field_71439_g.field_70159_w *= 0.1;
                final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
                field_71439_g2.field_70179_y *= 0.1;
            }
            if (this.mc.field_71439_g.field_70173_aa % 2 == 0) {
                this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + getRandomInRange(1.2354235325235235E-14, 1.2354235325235233E-13), this.mc.field_71439_g.field_70161_v);
            }
            this.mc.field_71439_g.field_70181_x = 0.0;
        }
        else if (this.mode.isCurrentMode("Zoom")) {
            ++Class199.fastFlew;
            final Block blockUnderPlayer = getBlockUnderPlayer((EntityPlayer)this.mc.field_71439_g, 0.2);
            if (!this.isOnGround(1.0E-7) && !blockUnderPlayer.func_149730_j() && !(blockUnderPlayer instanceof BlockGlass)) {
                this.mc.field_71439_g.field_70181_x = 0.0;
                this.mc.field_71439_g.field_70159_w = 0.0;
                this.mc.field_71439_g.field_70179_y = 0.0;
                float n3 = 0.29f + this.getSpeedEffect() * 0.06f;
                if (Class199.hypixel > 0.0) {
                    if ((this.mc.field_71439_g.field_70701_bs == 0.0f && this.mc.field_71439_g.field_70702_br == 0.0f) || this.mc.field_71439_g.field_70123_F) {
                        Class199.hypixel = 0.0;
                    }
                    n3 += Class199.hypixel / 18.0;
                    Class199.hypixel -= round(0.155, 2) + this.getSpeedEffect() * 0.006;
                }
                Class206.setMotion(n3);
                this.mc.field_71439_g.field_70747_aH = 0.0f;
                this.mc.field_71439_g.field_70122_E = false;
                ++this.count;
                ((IEntityPlayerSP)this.mc.field_71439_g).setLastReportedPosY(0.0);
                if (this.count <= 2.0) {
                    this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 8.3467347E-12, this.mc.field_71439_g.field_70161_v);
                }
                else if (this.count == 4.0) {
                    this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 3.575474E-12, this.mc.field_71439_g.field_70161_v);
                }
                else if (this.count >= 5.0) {
                    this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 7.57457457E-12, this.mc.field_71439_g.field_70161_v);
                    this.count = 0.0;
                }
            }
        }
    }
    
    public void onMove(final EventMove eventMove) {
        if (this.mode.isCurrentMode("Boost")) {
            final float field_70177_z = this.mc.field_71439_g.field_70177_z;
            double n = (double)this.mc.field_71439_g.field_71158_b.field_78902_a;
            double n2 = (double)this.mc.field_71439_g.field_71158_b.field_78900_b;
            final double n3 = -Math.sin(Math.toRadians((double)field_70177_z));
            final double cos = Math.cos(Math.toRadians((double)field_70177_z));
            if (n2 == 0.0 && n == 0.0) {
                eventMove.setX(0.0);
                eventMove.setZ(0.0);
            }
            if (n2 != 0.0 && n != 0.0) {
                n2 *= Math.sin(0.7853981633974483);
                n *= Math.cos(0.7853981633974483);
            }
            if (this.hypixelboost) {
                if (this.level != 1 || (this.mc.field_71439_g.field_70701_bs == 0.0f && this.mc.field_71439_g.field_70702_br == 0.0f)) {
                    if (this.level == 2) {
                        this.level = 3;
                        this.moveSpeed *= 2.1499999;
                    }
                    else if (this.level == 3) {
                        this.level = 4;
                        this.moveSpeed = this.lastDist - 0.73 * (this.lastDist - getBaseMoveSpeed());
                    }
                    else {
                        if (this.mc.field_71441_e.func_72945_a((Entity)this.mc.field_71439_g, this.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, this.mc.field_71439_g.field_70181_x, 0.0)).size() > 0 || this.mc.field_71439_g.field_70124_G) {
                            this.level = 1;
                        }
                        this.moveSpeed = this.lastDist - this.lastDist / 159.0;
                    }
                }
                else {
                    this.level = 2;
                    this.moveSpeed = (this.mc.field_71439_g.func_70644_a(Potion.field_76424_c) ? 1.706 : 2.034) * getBaseMoveSpeed() - 0.01;
                }
                this.moveSpeed = Math.max(this.moveSpeed, getBaseMoveSpeed());
                eventMove.setX(n2 * this.moveSpeed * n3 + n * this.moveSpeed * cos);
                eventMove.setZ(n2 * this.moveSpeed * cos - n * this.moveSpeed * n3);
                if (n2 == 0.0 && n == 0.0) {
                    eventMove.setX(0.0);
                    eventMove.setZ(0.0);
                }
            }
        }
        else if (this.mode.isCurrentMode("Zoom")) {}
    }
    
    public void onEnable() {
        this.stage = 0;
        this.level = 1;
        this.moveSpeed = 0.1;
        this.lastDist = 0.0;
        Class199.hypixel = 0.0;
        this.count = 0.0;
        Class199.fastFlew = 100;
        if (this.mode.isCurrentMode("Boost")) {
            this.canboost = true;
            double field_70181_x = 0.40123128;
            this.timervalue = 1.0f;
            if (this.mc.field_71439_g.field_70122_E) {
                if ((this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f) && this.mc.field_71439_g.field_70124_G) {
                    if (this.mc.field_71439_g.func_70644_a(Potion.field_76430_j)) {
                        field_70181_x += (this.mc.field_71439_g.func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1f;
                    }
                    this.mc.field_71439_g.field_70181_x = field_70181_x;
                }
                this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u - 1.28E-10, this.mc.field_71439_g.field_70161_v);
                this.level = 1;
                this.moveSpeed = 0.1;
                this.hypixelboost = true;
                this.lastDist = 0.0;
            }
            else {
                this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u - 1.26E-10, this.mc.field_71439_g.field_70161_v);
            }
            this.timer.reset();
        }
        if (this.mode.isCurrentMode("Zoom")) {
            for (int i = 0; i <= (((boolean)this.uhc.getValueState()) ? 95 : 67); ++i) {
                this.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 2.535E-9, this.mc.field_71439_g.field_70161_v, false));
                this.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 1.05E-10, this.mc.field_71439_g.field_70161_v, false));
                this.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u + 0.0448865, this.mc.field_71439_g.field_70161_v, false));
            }
            this.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.field_71439_g.field_70165_t, this.mc.field_71439_g.field_70163_u, this.mc.field_71439_g.field_70161_v, true));
            Class206.setMotion(0.3 + (double)(this.getSpeedEffect() * 0.05f));
            this.mc.field_71439_g.field_70181_x = 0.42;
            Class199.fastFlew = 25;
            Class199.hypixel = 18.4;
        }
    }
    
    public void onDisable() {
        this.level = 1;
        this.moveSpeed = 0.1;
        this.b2 = false;
        this.lastDist = 0.0;
        this.count = 0.0;
        Class199.fastFlew = 100;
        final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
        field_71439_g.field_70159_w *= 0.0;
        final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
        field_71439_g2.field_70179_y *= 0.0;
        this.mc.field_71439_g.field_70747_aH = 0.1f;
        Class206.setMotion(0.2);
    }
    
    public static double round(final double n, final int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(n).setScale(n2, RoundingMode.HALF_UP).doubleValue();
    }
    
    public boolean isOnGround(final double n) {
        return !this.mc.field_71441_e.func_72945_a((Entity)this.mc.field_71439_g, this.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, -n, 0.0)).isEmpty();
    }
    
    public int getSpeedEffect() {
        if (this.mc.field_71439_g.func_70644_a(Potion.field_76424_c)) {
            return this.mc.field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1;
        }
        return 0;
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
            eventMove.setX(n2 * n * Math.cos(Math.toRadians((double)(field_70177_z + 90.0f))) + n3 * n * Math.sin(Math.toRadians((double)(field_70177_z + 90.0f))));
            eventMove.setZ(n2 * n * Math.sin(Math.toRadians((double)(field_70177_z + 90.0f))) - n3 * n * Math.cos(Math.toRadians((double)(field_70177_z + 90.0f))));
        }
    }
    
    public static double getRandomInRange(final double n, final double n2) {
        double n3 = new Random().nextDouble() * (n2 - n);
        if (n3 > n2) {
            n3 = n2;
        }
        double n4 = n3 + n;
        if (n4 > n2) {
            n4 = n2;
        }
        return n4;
    }
    
    public static double getBaseMoveSpeed() {
        double n = 0.2873;
        if (Minecraft.func_71410_x().field_71439_g.func_70644_a(Potion.field_76424_c)) {
            n *= 1.0 + 0.2 * (Minecraft.func_71410_x().field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1);
        }
        return n;
    }
    
    static {
        Class199.hypixel = 0.0;
    }
}
