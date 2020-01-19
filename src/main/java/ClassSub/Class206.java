package ClassSub;

import net.minecraft.client.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.entity.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class Class206
{
    private static Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class206() {
        super();
    }
    
    public static double defaultSpeed() {
        double n = 0.2873;
        if (Minecraft.func_71410_x().field_71439_g.func_70644_a(Potion.field_76424_c)) {
            n *= 1.0 + 0.2 * (Minecraft.func_71410_x().field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1);
        }
        return n;
    }
    
    public static void setMotion(final double n) {
        double n2 = (double)Class206.mc.field_71439_g.field_71158_b.field_78900_b;
        double n3 = (double)Class206.mc.field_71439_g.field_71158_b.field_78902_a;
        float field_70177_z = Class206.mc.field_71439_g.field_70177_z;
        if (n2 == 0.0 && n3 == 0.0) {
            Class206.mc.field_71439_g.field_70159_w = 0.0;
            Class206.mc.field_71439_g.field_70179_y = 0.0;
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
            Class206.mc.field_71439_g.field_70159_w = n2 * n * Math.cos(Math.toRadians((double)(field_70177_z + 90.0f))) + n3 * n * Math.sin(Math.toRadians((double)(field_70177_z + 90.0f)));
            Class206.mc.field_71439_g.field_70179_y = n2 * n * Math.sin(Math.toRadians((double)(field_70177_z + 90.0f))) - n3 * n * Math.cos(Math.toRadians((double)(field_70177_z + 90.0f)));
        }
    }
    
    public static boolean checkTeleport(final double n, final double n2, final double n3, final double n4) {
        final double n5 = Class206.mc.field_71439_g.field_70165_t - n;
        final double n6 = Class206.mc.field_71439_g.field_70163_u - n2;
        final double n7 = Class206.mc.field_71439_g.field_70161_v - n3;
        final double n8 = (double)(Math.round(Math.sqrt(Class206.mc.field_71439_g.func_70092_e(n, n2, n3)) / n4 + 0.49999999999) - 1L);
        double field_70165_t = Class206.mc.field_71439_g.field_70165_t;
        double field_70163_u = Class206.mc.field_71439_g.field_70163_u;
        double field_70161_v = Class206.mc.field_71439_g.field_70161_v;
        for (int n9 = 1; n9 < n8; ++n9) {
            field_70165_t += (n - Class206.mc.field_71439_g.field_70165_t) / n8;
            field_70161_v += (n3 - Class206.mc.field_71439_g.field_70161_v) / n8;
            field_70163_u += (n2 - Class206.mc.field_71439_g.field_70163_u) / n8;
            if (!Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, new AxisAlignedBB(field_70165_t - 0.3, field_70163_u, field_70161_v - 0.3, field_70165_t + 0.3, field_70163_u + 1.8, field_70161_v + 0.3)).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isOnGround(final double n) {
        return !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, Class206.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, -n, 0.0)).isEmpty();
    }
    
    public static boolean isOnGround(final Entity entity, final double n) {
        return !Class206.mc.field_71441_e.func_72945_a(entity, entity.func_174813_aQ().func_72317_d(0.0, -n, 0.0)).isEmpty();
    }
    
    public static int getJumpEffect() {
        if (Class206.mc.field_71439_g.func_70644_a(Potion.field_76430_j)) {
            return Class206.mc.field_71439_g.func_70660_b(Potion.field_76430_j).func_76458_c() + 1;
        }
        return 0;
    }
    
    public static int getSpeedEffect() {
        if (Class206.mc.field_71439_g.func_70644_a(Potion.field_76424_c)) {
            return Class206.mc.field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1;
        }
        return 0;
    }
    
    public static Block getBlockUnderPlayer(final EntityPlayer entityPlayer, final double n) {
        return Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(entityPlayer.field_70165_t, entityPlayer.field_70163_u - n, entityPlayer.field_70161_v)).func_177230_c();
    }
    
    public static Block getBlockAtPosC(final double n, final double n2, final double n3) {
        final EntityPlayerSP field_71439_g = Minecraft.func_71410_x().field_71439_g;
        return Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(((EntityPlayer)field_71439_g).field_70165_t + n, ((EntityPlayer)field_71439_g).field_70163_u + n2, ((EntityPlayer)field_71439_g).field_70161_v + n3)).func_177230_c();
    }
    
    public static float getDistanceToGround(final Entity entity) {
        if (Class206.mc.field_71439_g.field_70124_G && Class206.mc.field_71439_g.field_70122_E) {
            return 0.0f;
        }
        float n = (float)entity.field_70163_u;
        while (n > 0.0f) {
            final int[] array = { 53, 67, 108, 109, 114, 128, 134, 135, 136, 156, 163, 164, 180 };
            final int[] array2 = { 6, 27, 28, 30, 31, 32, 37, 38, 39, 40, 50, 51, 55, 59, 63, 65, 66, 68, 69, 70, 72, 75, 76, 77, 83, 92, 93, 94, 104, 105, 106, 115, 119, 131, 132, 143, 147, 148, 149, 150, 157, 171, 175, 176, 177 };
            final Block func_177230_c = Class206.mc.field_71441_e.func_180495_p(new BlockPos(entity.field_70165_t, (double)(n - 1.0f), entity.field_70161_v)).func_177230_c();
            if (!(func_177230_c instanceof BlockAir)) {
                if (Block.func_149682_b(func_177230_c) == 44 || Block.func_149682_b(func_177230_c) == 126) {
                    return ((float)(entity.field_70163_u - n - 0.5) < 0.0f) ? 0.0f : ((float)(entity.field_70163_u - n - 0.5));
                }
                int[] array3;
                for (int length = (array3 = array).length, i = 0; i < length; ++i) {
                    if (Block.func_149682_b(func_177230_c) == array3[i]) {
                        return ((float)(entity.field_70163_u - n - 1.0) < 0.0f) ? 0.0f : ((float)(entity.field_70163_u - n - 1.0));
                    }
                }
                int[] array4;
                for (int length2 = (array4 = array2).length, j = 0; j < length2; ++j) {
                    if (Block.func_149682_b(func_177230_c) == array4[j]) {
                        return ((float)(entity.field_70163_u - n) < 0.0f) ? 0.0f : ((float)(entity.field_70163_u - n));
                    }
                }
                return (float)(entity.field_70163_u - n + func_177230_c.func_149669_A() - 1.0);
            }
            else {
                --n;
            }
        }
        return 0.0f;
    }
    
    public static float[] getRotationsBlock(final BlockPos blockPos, final EnumFacing enumFacing) {
        final double n = blockPos.func_177958_n() + 0.5 - Class206.mc.field_71439_g.field_70165_t + enumFacing.func_82601_c() / 2.0;
        final double n2 = blockPos.func_177952_p() + 0.5 - Class206.mc.field_71439_g.field_70161_v + enumFacing.func_82599_e() / 2.0;
        final double n3 = Class206.mc.field_71439_g.field_70163_u + Class206.mc.field_71439_g.func_70047_e() - (blockPos.func_177956_o() + 0.5);
        final double n4 = (double)MathHelper.func_76133_a(n * n + n2 * n2);
        float n5 = (float)(Math.atan2(n2, n) * 180.0 / 3.141592653589793) - 90.0f;
        final float n6 = (float)(Math.atan2(n3, n4) * 180.0 / 3.141592653589793);
        if (n5 < 0.0f) {
            n5 += 360.0f;
        }
        return new float[] { n5, n6 };
    }
    
    public static boolean isBlockAboveHead() {
        return !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, new AxisAlignedBB(Class206.mc.field_71439_g.field_70165_t - 0.3, Class206.mc.field_71439_g.field_70163_u + Class206.mc.field_71439_g.func_70047_e(), Class206.mc.field_71439_g.field_70161_v + 0.3, Class206.mc.field_71439_g.field_70165_t + 0.3, Class206.mc.field_71439_g.field_70163_u + 2.5, Class206.mc.field_71439_g.field_70161_v - 0.3)).isEmpty();
    }
    
    public static boolean isCollidedH(final double n) {
        final AxisAlignedBB axisAlignedBB = new AxisAlignedBB(Class206.mc.field_71439_g.field_70165_t - 0.3, Class206.mc.field_71439_g.field_70163_u + 2.0, Class206.mc.field_71439_g.field_70161_v + 0.3, Class206.mc.field_71439_g.field_70165_t + 0.3, Class206.mc.field_71439_g.field_70163_u + 3.0, Class206.mc.field_71439_g.field_70161_v - 0.3);
        return !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(0.3 + n, 0.0, 0.0)).isEmpty() || !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(-0.3 - n, 0.0, 0.0)).isEmpty() || !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(0.0, 0.0, 0.3 + n)).isEmpty() || !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(0.0, 0.0, -0.3 - n)).isEmpty();
    }
    
    public static boolean isRealCollidedH(final double n) {
        final AxisAlignedBB axisAlignedBB = new AxisAlignedBB(Class206.mc.field_71439_g.field_70165_t - 0.3, Class206.mc.field_71439_g.field_70163_u + 0.5, Class206.mc.field_71439_g.field_70161_v + 0.3, Class206.mc.field_71439_g.field_70165_t + 0.3, Class206.mc.field_71439_g.field_70163_u + 1.9, Class206.mc.field_71439_g.field_70161_v - 0.3);
        return !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(0.3 + n, 0.0, 0.0)).isEmpty() || !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(-0.3 - n, 0.0, 0.0)).isEmpty() || !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(0.0, 0.0, 0.3 + n)).isEmpty() || !Class206.mc.field_71441_e.func_72945_a((Entity)Class206.mc.field_71439_g, axisAlignedBB.func_72317_d(0.0, 0.0, -0.3 - n)).isEmpty();
    }
    
    static {
        Class206.mc = Minecraft.func_71410_x();
    }
}
