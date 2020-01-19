package ClassSub;

import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.entity.player.*;

public class Class198
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class198() {
        super();
    }
    
    public static float[] getNeededRotationsToEntity(final Entity entity) {
        Minecraft.func_71410_x();
        final EntityPlayerSP field_71439_g = Minecraft.func_71410_x().field_71439_g;
        final double n = entity.field_70165_t - field_71439_g.field_70165_t;
        final double n2 = entity.field_70163_u - field_71439_g.field_70163_u;
        final double n3 = -Math.atan2(n, entity.field_70161_v - field_71439_g.field_70161_v) * 57.0;
        final double n4 = -(Math.asin(n2 / (double)field_71439_g.func_70032_d(entity)) * 57.0 - 20.0);
        return new float[] { (float)n3, (float)((n4 > 90.0) ? 90.0 : ((n4 < -90.0) ? -90.0 : n4)) };
    }
    
    public static float[] getRotations(final Entity entity) {
        return getRotationFromPosition(entity.field_70165_t, entity.field_70161_v, entity.field_70163_u + (double)(entity.func_70047_e() / 2.0f));
    }
    
    public static float[] getAverageRotations(final List<Entity> list) {
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        for (final Entity entity : list) {
            n += entity.field_70165_t;
            n2 += ((IEntity)entity).getBoundingBox().field_72337_e - 2.0;
            n3 += entity.field_70161_v;
        }
        final float[] array = new float[2];
        final int n4 = 0;
        final double n5 = n / list.size();
        final double n6 = n3 / list.size();
        final double n7;
        array[n4] = ((float[])getRotationFromPosition(n5, n6, n7 = n2 / list.size()))[0];
        array[1] = ((float[])getRotationFromPosition(n5, n6, n7))[1];
        return array;
    }
    
    public static float[] getBowAngles(final Entity entity) {
        final double n = entity.field_70165_t - entity.field_70142_S;
        final double n2 = entity.field_70161_v - entity.field_70136_U;
        final double n3 = (double)Minecraft.func_71410_x().field_71439_g.func_70032_d(entity);
        final double n4 = n3 - n3 % 0.8;
        final boolean func_70051_ag = entity.func_70051_ag();
        return new float[] { (float)Math.toDegrees(Math.atan2(entity.field_70161_v + n4 / 0.8 * n2 * (func_70051_ag ? 1.25 : 1.0) - Minecraft.func_71410_x().field_71439_g.field_70161_v, entity.field_70165_t + n4 / 0.8 * n * (func_70051_ag ? 1.25 : 1.0) - Minecraft.func_71410_x().field_71439_g.field_70165_t)) - 90.0f, (float)Math.toDegrees(Math.atan2(Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e() - (entity.field_70163_u + entity.func_70047_e()), (double)Minecraft.func_71410_x().field_71439_g.func_70032_d(entity))) };
    }
    
    public static float[] getRotationFromPosition(final double n, final double n2, final double n3) {
        final double n4 = n - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n5 = n2 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return new float[] { (float)(Math.atan2(n5, n4) * 180.0 / 3.141592653589793) - 90.0f, (float)(-Math.atan2(n3 - Minecraft.func_71410_x().field_71439_g.field_70163_u - 1.2, MathHelper.func_76133_a(n4 * n4 + n5 * n5)) * 180.0 / 3.141592653589793) };
    }
    
    public static float getTrajAngleSolutionLow(final float n, final float n2, final float n3) {
        final float n4 = 0.006f;
        return (float)Math.toDegrees(Math.atan((n3 * n3 - Math.sqrt(n3 * n3 * n3 * n3 - n4 * (n4 * (n * n) + 2.0f * n2 * (n3 * n3)))) / (double)(n4 * n)));
    }
    
    public static float getYawChange(final double n, final double n2) {
        final double n3 = n - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n4 = n2 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return MathHelper.func_76142_g(-Minecraft.func_71410_x().field_71439_g.field_70177_z - (float)((n4 < 0.0 && n3 < 0.0) ? (90.0 + Math.toDegrees(Math.atan(n4 / n3))) : ((n4 < 0.0 && n3 > 0.0) ? (-90.0 + Math.toDegrees(Math.atan(n4 / n3))) : Math.toDegrees(-Math.atan(n3 / n4)))));
    }
    
    public static float getYawChangeByHead(final double n, final double n2) {
        final double n3 = n - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n4 = n2 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return MathHelper.func_76142_g(-Minecraft.func_71410_x().field_71439_g.field_70759_as - (float)((n4 < 0.0 && n3 < 0.0) ? (90.0 + Math.toDegrees(Math.atan(n4 / n3))) : ((n4 < 0.0 && n3 > 0.0) ? (-90.0 + Math.toDegrees(Math.atan(n4 / n3))) : Math.toDegrees(-Math.atan(n3 / n4)))));
    }
    
    public static float getPitchChange(final Entity entity, final double n) {
        final double n2 = entity.field_70165_t - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n3 = entity.field_70161_v - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return -MathHelper.func_76142_g(Minecraft.func_71410_x().field_71439_g.field_70125_A - (float)(-Math.toDegrees(Math.atan((n - 2.2 + entity.func_70047_e() - Minecraft.func_71410_x().field_71439_g.field_70163_u) / (double)MathHelper.func_76133_a(n2 * n2 + n3 * n3))))) - 2.5f;
    }
    
    public static float getNewAngle(float n) {
        if ((n %= 360.0f) >= 180.0f) {
            n -= 360.0f;
        }
        if (n < -180.0f) {
            n += 360.0f;
        }
        return n;
    }
    
    public static float getDistanceBetweenAngles(final float n, final float n2) {
        float n3 = Math.abs(n - n2) % 360.0f;
        if (n3 > 180.0f) {
            n3 = 360.0f - n3;
        }
        return n3;
    }
    
    public static float[] grabBlockRotations(final BlockPos blockPos) {
        return getVecRotation(Minecraft.func_71410_x().field_71439_g.func_174791_d().func_72441_c(0.0, (double)Minecraft.func_71410_x().field_71439_g.func_70047_e(), 0.0), new Vec3(blockPos.func_177958_n() + 0.5, blockPos.func_177956_o() + 0.5, blockPos.func_177952_p() + 0.5));
    }
    
    public static float[] getVecRotation(final Vec3 vec3) {
        return getVecRotation(Minecraft.func_71410_x().field_71439_g.func_174791_d().func_72441_c(0.0, (double)Minecraft.func_71410_x().field_71439_g.func_70047_e(), 0.0), vec3);
    }
    
    public static float[] getVecRotation(final Vec3 vec3, final Vec3 vec4) {
        final Vec3 func_178788_d = vec4.func_178788_d(vec3);
        return new float[] { (float)Math.toDegrees(Math.atan2(func_178788_d.field_72449_c, func_178788_d.field_72450_a)) - 90.0f, (float)(-Math.toDegrees(Math.atan2(func_178788_d.field_72448_b, new Vec3(func_178788_d.field_72450_a, 0.0, func_178788_d.field_72449_c).func_72433_c()))) };
    }
    
    public static float[] faceTarget(final Entity entity, final float n, final float n2, final boolean b) {
        final double n3 = entity.field_70165_t - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n4 = entity.field_70161_v - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        double n5;
        if (entity instanceof EntityLivingBase) {
            final EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            n5 = entityLivingBase.field_70163_u + entityLivingBase.func_70047_e() - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        }
        else {
            n5 = (entity.func_174813_aQ().field_72338_b + entity.func_174813_aQ().field_72337_e) / 2.0 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        }
        final Random random = new Random();
        return new float[] { changeRotation(Minecraft.func_71410_x().field_71439_g.field_70177_z, (float)(Math.atan2(n4, n3) * 180.0 / 3.141592653589793) - 90.0f, n), changeRotation(Minecraft.func_71410_x().field_71439_g.field_70125_A, (float)(-Math.atan2(n5 - ((entity instanceof EntityPlayer) ? 0.25 : 0.0), MathHelper.func_76133_a(n3 * n3 + n4 * n4)) * 180.0 / 3.141592653589793), n2) };
    }
    
    public static float changeRotation(final float n, final float n2, final float n3) {
        float func_76142_g = MathHelper.func_76142_g(n2 - n);
        if (func_76142_g > n3) {
            func_76142_g = n3;
        }
        if (func_76142_g < -n3) {
            func_76142_g = -n3;
        }
        return n + func_76142_g;
    }
    
    public static float getYawChangeGiven(final double n, final double n2, final float n3) {
        final double n4 = n - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n5 = n2 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        double degrees;
        if (n5 < 0.0 && n4 < 0.0) {
            degrees = 90.0 + Math.toDegrees(Math.atan(n5 / n4));
        }
        else if (n5 < 0.0 && n4 > 0.0) {
            degrees = -90.0 + Math.toDegrees(Math.atan(n5 / n4));
        }
        else {
            degrees = Math.toDegrees(-Math.atan(n4 / n5));
        }
        return MathHelper.func_76142_g(-(n3 - (float)degrees));
    }
    
    public static float[] getRotationsNeededBlock(final double n, final double n2, final double n3) {
        final double n4 = n + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n5 = n3 + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return new float[] { Minecraft.func_71410_x().field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n5, n4) * 180.0 / 3.141592653589793) - 90.0f - Minecraft.func_71410_x().field_71439_g.field_70177_z), Minecraft.func_71410_x().field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-Math.atan2(n2 + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e()), MathHelper.func_76133_a(n4 * n4 + n5 * n5)) * 180.0 / 3.141592653589793) - Minecraft.func_71410_x().field_71439_g.field_70125_A) };
    }
    
    public static float[] getRotationsNeededBlock(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n4 + 0.5 - n;
        final double n8 = n6 + 0.5 - n3;
        return new float[] { (float)(Math.atan2(n8, n7) * 180.0 / 3.141592653589793) - 90.0f, (float)(-Math.atan2(n5 + 0.5 - (n2 + Minecraft.func_71410_x().field_71439_g.func_70047_e()), MathHelper.func_76133_a(n7 * n7 + n8 * n8)) * 180.0 / 3.141592653589793) };
    }
}
