package ClassSub;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.*;

public class Class229
{
    public static Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class229() {
        super();
    }
    
    public static float[] getRotations(final Entity entity) {
        final double field_70165_t = Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n = Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e();
        final double field_70161_v = Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double field_70165_t2 = entity.field_70165_t;
        final double n2 = entity.field_70163_u + entity.field_70131_O / 2.0f;
        final double field_70161_v2 = entity.field_70161_v;
        final double n3 = field_70165_t - field_70165_t2;
        final double n4 = n - n2;
        final double n5 = field_70161_v - field_70161_v2;
        return new float[] { (float)(Math.toDegrees(Math.atan2(n5, n3)) + 90.0), (float)(90.0 - Math.toDegrees(Math.atan2(Math.sqrt(Math.pow(n3, 2.0) + Math.pow(n5, 2.0)), n4))) };
    }
    
    private static float[] getDirectionToEntity(final Entity entity) {
        return new float[] { getYaw(entity) + Class229.mc.field_71439_g.field_70177_z, getPitch(entity) + Class229.mc.field_71439_g.field_70125_A };
    }
    
    public static float[] getDirectionToBlock(final double n, final double n2, final double n3, final EnumFacing enumFacing) {
        final EntityEgg entityEgg = new EntityEgg((World)Class229.mc.field_71441_e);
        entityEgg.field_70165_t = n + 0.5;
        entityEgg.field_70163_u = n2 + 0.5;
        entityEgg.field_70161_v = n3 + 0.5;
        final EntityEgg entityEgg2 = entityEgg;
        entityEgg2.field_70165_t += enumFacing.func_176730_m().func_177958_n() * 0.25;
        final EntityEgg entityEgg3 = entityEgg;
        entityEgg3.field_70163_u += enumFacing.func_176730_m().func_177956_o() * 0.25;
        final EntityEgg entityEgg4 = entityEgg;
        entityEgg4.field_70161_v += enumFacing.func_176730_m().func_177952_p() * 0.25;
        return getDirectionToEntity((Entity)entityEgg);
    }
    
    public static float[] getRotationNeededForBlock(final EntityPlayer entityPlayer, final BlockPos blockPos) {
        final double n = blockPos.func_177958_n() - entityPlayer.field_70165_t;
        final double n2 = blockPos.func_177956_o() + 0.5 - (entityPlayer.field_70163_u + entityPlayer.func_70047_e());
        final double n3 = blockPos.func_177952_p() - entityPlayer.field_70161_v;
        return new float[] { (float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f, (float)(-Math.atan2(n2, Math.sqrt(n * n + n3 * n3)) * 180.0 / 3.141592653589793) };
    }
    
    public static float getYaw(final Entity entity) {
        final double n = entity.field_70165_t - Class229.mc.field_71439_g.field_70165_t;
        final double n2 = entity.field_70161_v - Class229.mc.field_71439_g.field_70161_v;
        return MathHelper.func_76142_g(-Class229.mc.field_71439_g.field_70177_z - (float)((n2 < 0.0 && n < 0.0) ? (90.0 + Math.toDegrees(Math.atan(n2 / n))) : ((n2 < 0.0 && n > 0.0) ? (-90.0 + Math.toDegrees(Math.atan(n2 / n))) : Math.toDegrees(-Math.atan(n / n2)))));
    }
    
    public static float getPitch(final Entity entity) {
        final double n = entity.field_70165_t - Class229.mc.field_71439_g.field_70165_t;
        final double n2 = entity.field_70161_v - Class229.mc.field_71439_g.field_70161_v;
        return -MathHelper.func_76142_g(Class229.mc.field_71439_g.field_70125_A - (float)(-Math.toDegrees(Math.atan((entity.field_70163_u - 1.6 + entity.func_70047_e() - Class229.mc.field_71439_g.field_70163_u) / (double)MathHelper.func_76133_a(n * n + n2 * n2)))));
    }
    
    public static float[] getRotationFromPosition(final double n, final double n2, final double n3) {
        final double n4 = n - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n5 = n3 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return new float[] { (float)(Math.atan2(n5, n4) * 180.0 / 3.141592653589793) - 90.0f, (float)(-Math.atan2(n2 - Minecraft.func_71410_x().field_71439_g.field_70163_u - Minecraft.func_71410_x().field_71439_g.func_70047_e(), MathHelper.func_76133_a(n4 * n4 + n5 * n5)) * 180.0 / 3.141592653589793) };
    }
    
    public static float[] getRotationsNeededBlock(final double n, final double n2, final double n3) {
        final double n4 = n + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n5 = n3 + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return new float[] { Minecraft.func_71410_x().field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n5, n4) * 180.0 / 3.141592653589793) - 90.0f - Minecraft.func_71410_x().field_71439_g.field_70177_z), Minecraft.func_71410_x().field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-Math.atan2(n2 + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e()), MathHelper.func_76133_a(n4 * n4 + n5 * n5)) * 180.0 / 3.141592653589793) - Minecraft.func_71410_x().field_71439_g.field_70125_A) };
    }
    
    public static float[] getHypixelRotationsNeededBlock(final double n, final double n2, final double n3) {
        final double n4 = n + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n5 = n3 + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return new float[] { Minecraft.func_71410_x().field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n5, n4) * 180.0 / 3.141592653589793) - 90.0f - (float)(120 + new Random().nextInt(2))), Minecraft.func_71410_x().field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-Math.atan2(n2 + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e()), MathHelper.func_76133_a(n4 * n4 + n5 * n5)) * 180.0 / 3.141592653589793) - Minecraft.func_71410_x().field_71439_g.field_70125_A) };
    }
    
    public static float[] getRotationsNeededBlock(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n4 + 0.5 - n;
        final double n8 = n6 + 0.5 - n3;
        return new float[] { (float)(Math.atan2(n8, n7) * 180.0 / 3.141592653589793) - 90.0f, (float)(-Math.atan2(n5 + 0.5 - (n2 + Minecraft.func_71410_x().field_71439_g.func_70047_e()), MathHelper.func_76133_a(n7 * n7 + n8 * n8)) * 180.0 / 3.141592653589793) };
    }
    
    public static float getTrajAngleSolutionLow(final float n, final float n2, final float n3) {
        final float n4 = 0.006f;
        return (float)Math.toDegrees(Math.atan((n3 * n3 - Math.sqrt(n3 * n3 * n3 * n3 - n4 * (n4 * (n * n) + 2.0f * n2 * (n3 * n3)))) / (double)(n4 * n)));
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
    
    public static Vec3[] getCorners(final AxisAlignedBB axisAlignedBB) {
        return new Vec3[] { new Vec3(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c), new Vec3(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c), new Vec3(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c), new Vec3(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f), new Vec3(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c), new Vec3(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f), new Vec3(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f), new Vec3(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f) };
    }
    
    public static AxisAlignedBB getCloserBox(final AxisAlignedBB axisAlignedBB, final AxisAlignedBB axisAlignedBB2) {
        for (final Vec3 vec3 : (Vec3[])getCorners(axisAlignedBB2)) {
            if (isRotationIn(getRotationFromPosition(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c), axisAlignedBB)) {
                return (getDistanceToBox(axisAlignedBB2) < getDistanceToBox(axisAlignedBB)) ? axisAlignedBB2 : axisAlignedBB;
            }
        }
        return axisAlignedBB2;
    }
    
    public static double getDistanceToBox(final AxisAlignedBB axisAlignedBB) {
        return Minecraft.func_71410_x().field_71439_g.func_70011_f((axisAlignedBB.field_72340_a + axisAlignedBB.field_72336_d) / 2.0, (axisAlignedBB.field_72338_b + axisAlignedBB.field_72337_e) / 2.0, (axisAlignedBB.field_72339_c + axisAlignedBB.field_72334_f) / 2.0);
    }
    
    public static boolean isRotationIn(final float[] array, final AxisAlignedBB axisAlignedBB) {
        final float[] array2 = (float[])getMaxRotations(axisAlignedBB);
        return array2[0] < array[0] && array2[2] < array[1] && array2[1] > array[0] && array2[3] > array[1];
    }
    
    public static float[] getRandomRotationsInBox(final AxisAlignedBB axisAlignedBB) {
        final float[] array = (float[])getMaxRotations(axisAlignedBB);
        return new float[] { (float)MathHelper.func_82716_a(new Random(), (double)array[0], (double)array[1]), (float)MathHelper.func_82716_a(new Random(), (double)array[2], (double)array[3]) };
    }
    
    public static float[] getMaxRotations(final AxisAlignedBB axisAlignedBB) {
        float n = 2.14748365E9f;
        float n2 = -2.14748365E9f;
        float n3 = 2.14748365E9f;
        float n4 = -2.14748365E9f;
        for (final Vec3 vec3 : (Vec3[])getCorners(axisAlignedBB)) {
            final float[] array2 = (float[])getRotationFromPosition(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
            if (array2[0] < n) {
                n = array2[0];
            }
            if (array2[0] > n2) {
                n2 = array2[0];
            }
            if (array2[1] < n3) {
                n3 = array2[1];
            }
            if (array2[1] > n4) {
                n4 = array2[1];
            }
        }
        return new float[] { n, n2, n3, n4 };
    }
    
    public static AxisAlignedBB expandBox(final AxisAlignedBB axisAlignedBB, double n) {
        n = 1.0 - n / 100.0;
        return axisAlignedBB.func_72314_b((axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * n, 0.12, (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * n);
    }
    
    public static AxisAlignedBB contractBox(final AxisAlignedBB axisAlignedBB, double n) {
        n = 1.0 - n / 100.0;
        return axisAlignedBB.func_72331_e((axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * n, 0.12, (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * n);
    }
    
    public static float getYawDifference(final float n, final float n2) {
        final float n3 = (n2 + 180.0f - n) % 360.0f;
        return n3 + ((n3 > 0.0f) ? -180.0f : 180.0f);
    }
    
    public static float getPitchDifference(final float n, final float n2) {
        final float n3 = (n2 + 90.0f - n) % 180.0f;
        return n3 + ((n3 > 0.0f) ? -90.0f : 90.0f);
    }
    
    public static float[] getRotations(final Object o) {
        final Entity entity = (Entity)o;
        final double field_70165_t = Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n = Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e();
        final double field_70161_v = Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double field_70165_t2 = entity.field_70165_t;
        final double n2 = entity.field_70163_u + entity.field_70131_O / 2.0f;
        final double field_70161_v2 = entity.field_70161_v;
        final double n3 = field_70165_t - field_70165_t2;
        final double n4 = n - n2;
        final double n5 = field_70161_v - field_70161_v2;
        return new float[] { (float)(Math.toDegrees(Math.atan2(n5, n3)) + 90.0), (float)(90.0 - Math.toDegrees(Math.atan2(Math.sqrt(Math.pow(n3, 2.0) + Math.pow(n5, 2.0)), n4))) };
    }
    
    static {
        Class229.mc = Minecraft.func_71410_x();
    }
}
