package ClassSub;

import net.minecraft.client.*;
import net.minecraft.potion.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.events.*;

public class Class318
{
    Minecraft mc;
    private double nextMotionSpeed;
    private double xMotionSpeed;
    private double zDist;
    private double moveSpeed;
    int stage;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class318() {
        super();
        this.mc = Minecraft.func_71410_x();
        this.stage = 0;
    }
    
    public void onMove(final EventMove eventMove) {
        this.moveSpeed = Class295.getBaseMoveSpeed();
        if (this.stage < 1) {
            ++this.stage;
            this.nextMotionSpeed = 0.0;
        }
        if (this.stage == 2 && (this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f) && this.mc.field_71439_g.field_70124_G && this.mc.field_71439_g.field_70122_E) {
            this.xMotionSpeed = 0.4200123123131243;
            if (this.mc.field_71439_g.func_70644_a(Potion.field_76430_j)) {
                this.xMotionSpeed += (this.mc.field_71439_g.func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1f;
            }
            eventMove.setY(this.mc.field_71439_g.field_70181_x = this.xMotionSpeed);
            this.moveSpeed *= 2.1498624684;
        }
        else if (this.stage == 3) {
            this.xMotionSpeed = ((this.stage % 3 == 0) ? 0.678994565156 : 0.719499495154) * (this.nextMotionSpeed - Class295.getBaseMoveSpeed());
            this.moveSpeed = this.nextMotionSpeed - this.xMotionSpeed;
        }
        else {
            if ((this.mc.field_71441_e.func_72945_a((Entity)this.mc.field_71439_g, ((IEntity)this.mc.field_71439_g).getBoundingBox().func_72317_d(0.0, this.mc.field_71439_g.field_70181_x, 0.0)).size() > 0 || this.mc.field_71439_g.field_70124_G) && this.stage > 0) {
                this.stage = ((this.mc.field_71439_g.field_70701_bs != 0.0f || this.mc.field_71439_g.field_70702_br != 0.0f) ? 1 : 0);
            }
            this.moveSpeed = this.nextMotionSpeed - this.nextMotionSpeed / 159.0;
        }
        this.moveSpeed = Math.max(this.moveSpeed, Class295.getBaseMoveSpeed());
        this.xMotionSpeed = this.mc.field_71439_g.field_71158_b.field_78900_b;
        this.zDist = this.mc.field_71439_g.field_71158_b.field_78902_a;
        float field_70177_z = this.mc.field_71439_g.field_70177_z;
        if (this.xMotionSpeed == 0.0 && this.zDist == 0.0) {
            this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t + 1.0, this.mc.field_71439_g.field_70163_u, this.mc.field_71439_g.field_70161_v + 1.0);
            this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70169_q, this.mc.field_71439_g.field_70163_u, this.mc.field_71439_g.field_70166_s);
            eventMove.setX(0.0);
            eventMove.setZ(0.0);
        }
        else if (this.xMotionSpeed != 0.0) {
            if (this.zDist >= 1.0) {
                field_70177_z += ((this.xMotionSpeed > 0.0) ? -45.0f : 45.0f);
                this.zDist = 0.0;
            }
            else if (this.zDist <= -1.0) {
                field_70177_z += ((this.xMotionSpeed > 0.0) ? 45.0f : -45.0f);
                this.zDist = 0.0;
            }
            if (this.xMotionSpeed > 0.0) {
                this.xMotionSpeed = 1.0;
            }
            else if (this.xMotionSpeed < 0.0) {
                this.xMotionSpeed = -1.0;
            }
        }
        final double cos = Math.cos(Math.toRadians((double)(field_70177_z + 90.0f)));
        final double sin = Math.sin(Math.toRadians((double)(field_70177_z + 90.0f)));
        final double x = (this.xMotionSpeed * this.moveSpeed * cos + this.zDist * this.moveSpeed * sin) * 0.987;
        final double z = (this.xMotionSpeed * this.moveSpeed * sin - this.zDist * this.moveSpeed * cos) * 0.987;
        if (Math.abs(x) < 1.0 && Math.abs(z) < 1.0) {
            eventMove.setX(x);
            eventMove.setZ(z);
        }
        this.mc.field_71439_g.field_70138_W = 0.6f;
        if (this.xMotionSpeed == 0.0 && this.zDist == 0.0) {
            eventMove.setX(0.0);
            eventMove.setZ(0.0);
            this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70165_t + 1.0, this.mc.field_71439_g.field_70163_u, this.mc.field_71439_g.field_70161_v + 1.0);
            this.mc.field_71439_g.func_70107_b(this.mc.field_71439_g.field_70169_q, this.mc.field_71439_g.field_70163_u, this.mc.field_71439_g.field_70166_s);
        }
        else if (this.xMotionSpeed != 0.0) {
            if (this.zDist >= 1.0) {
                final float n = field_70177_z + ((this.xMotionSpeed > 0.0) ? -45.0f : 45.0f);
                this.zDist = 0.0;
            }
            else if (this.zDist <= -1.0) {
                final float n2 = field_70177_z + ((this.xMotionSpeed > 0.0) ? 45.0f : -45.0f);
                this.zDist = 0.0;
            }
            if (this.xMotionSpeed > 0.0) {
                this.xMotionSpeed = 1.0;
            }
            else if (this.xMotionSpeed < 0.0) {
                this.xMotionSpeed = -1.0;
            }
        }
        ++this.stage;
    }
    
    public void onEnable() {
        final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
        field_71439_g.field_70159_w *= 0.0;
        final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
        field_71439_g2.field_70179_y *= 0.0;
        if (this.mc.field_71439_g != null) {
            this.moveSpeed = Class295.getBaseMoveSpeed();
        }
        this.nextMotionSpeed = 0.0;
        this.stage = 2;
        Class296.getTimer().field_74278_d = 1.0f;
    }
    
    public void onPre(final EventPreMotion eventPreMotion) {
        this.xMotionSpeed = this.mc.field_71439_g.field_70165_t - this.mc.field_71439_g.field_70169_q;
        this.zDist = this.mc.field_71439_g.field_70161_v - this.mc.field_71439_g.field_70166_s;
        this.nextMotionSpeed = Math.sqrt(this.xMotionSpeed * this.xMotionSpeed + this.zDist * this.zDist);
    }
}
