package ClassSub;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.network.play.client.*;
import cn.Hanabi.injection.interfaces.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import java.util.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;

public final class Class5
{
    private static Minecraft mc;
    public static boolean l;
    public static float ll;
    public static float l1;
    private static int l11;
    public static boolean lll;
    public static float[] ll1;
    private static double llll;
    private static double lll1;
    private static double lmc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class5() {
        super();
    }
    
    public static double ll(final Entity entity) {
        final float[] array = (float[])l(entity);
        if (array == null) {
            return 0.0;
        }
        return l(array[0], array[1]);
    }
    
    public static double l(final float n, final float n2) {
        return Math.sqrt(Math.pow(Math.abs(l((double)(Class5.ll1[0] % 360.0f), (double)n)), 2.0) + Math.pow(Math.abs(l((double)Class5.ll1[1], (double)n2)), 2.0));
    }
    
    public static void l1() {
        Class5.l = false;
        Class5.l11 = 0;
        Class5.ll = 0.0f;
        Class5.l1 = 0.0f;
    }
    
    @EventTarget
    public static void l(final EventPacket eventPacket) {
        if (eventPacket.getPacket() instanceof C03PacketPlayer) {
            final C03PacketPlayer c03PacketPlayer = (C03PacketPlayer)eventPacket.getPacket();
            if (Class5.l && !Class5.lll && (Class5.ll != Class5.ll1[0] || Class5.l1 != Class5.ll1[1])) {
                ((IC03PacketPlayer)c03PacketPlayer).setYaw(Class5.ll);
                ((IC03PacketPlayer)c03PacketPlayer).setPitch(Class5.l1);
                ((IC03PacketPlayer)c03PacketPlayer).setRotate(true);
            }
            if (((IC03PacketPlayer)c03PacketPlayer).getRotate()) {
                Class5.ll1 = new float[] { ((IC03PacketPlayer)c03PacketPlayer).getYaw(), ((IC03PacketPlayer)c03PacketPlayer).getPitch() };
            }
        }
    }
    
    @EventTarget
    public static void update(final EventUpdate eventUpdate) {
        if (Class5.l && ++Class5.l11 > 15) {
            l1();
        }
        final Random random = new Random();
        if (random.nextGaussian() * 100.0 > 80.0) {
            Class5.llll = Math.random() / 3.0;
        }
        if (random.nextGaussian() * 100.0 > 80.0) {
            Class5.lll1 = Math.random() / 3.0;
        }
        if (random.nextGaussian() * 100.0 > 80.0) {
            Class5.lmc = Math.random() / 3.0;
        }
    }
    
    public static Vec3 l(final AxisAlignedBB axisAlignedBB) {
        return new Vec3(axisAlignedBB.field_72340_a + (axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * 0.5, axisAlignedBB.field_72338_b + (axisAlignedBB.field_72337_e - axisAlignedBB.field_72338_b) * 0.5, axisAlignedBB.field_72339_c + (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * 0.5);
    }
    
    public static float[] l(final float[] array, final float[] array2, final float n) {
        final double l = l(array2[0], (double)array[0]);
        final double i = l(array2[1], (double)array[1]);
        array[0] += ((l > n) ? ((double)n) : ((l < -n) ? ((double)(-n)) : l));
        array[1] += ((i > n) ? ((double)n) : ((i < -n) ? ((double)(-n)) : i));
        return array;
    }
    
    public static Vec3 ll() {
        return new Vec3(Class5.mc.field_71439_g.field_70165_t, Class5.mc.field_71439_g.func_174813_aQ().field_72338_b + Class5.mc.field_71439_g.func_70047_e(), Class5.mc.field_71439_g.field_70161_v);
    }
    
    private static double l(final double n, final double n2) {
        return ((n - n2) % 360.0 + 540.0) % 360.0 - 180.0;
    }
    
    public static Vec3 l(final AxisAlignedBB axisAlignedBB, final boolean b) {
        if (b) {
            return new Vec3(axisAlignedBB.field_72340_a + (axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * (Class5.llll * 0.3 + 1.0), axisAlignedBB.field_72338_b + (axisAlignedBB.field_72337_e - axisAlignedBB.field_72338_b) * (Class5.lll1 * 0.3 + 1.0), axisAlignedBB.field_72339_c + (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * (Class5.lmc * 0.3 + 1.0));
        }
        return new Vec3(axisAlignedBB.field_72340_a + (axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * Class5.llll * 0.8, axisAlignedBB.field_72338_b + (axisAlignedBB.field_72337_e - axisAlignedBB.field_72338_b) * Class5.lll1 * 0.8, axisAlignedBB.field_72339_c + (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * Class5.lmc * 0.8);
    }
    
    public boolean l() {
        return true;
    }
    
    public static Vec3 ll(final float n, final float n2) {
        final float func_76134_b = MathHelper.func_76134_b(-n2 * 0.017453292f - 3.1415927f);
        final float func_76126_a = MathHelper.func_76126_a(-n2 * 0.017453292f - 3.1415927f);
        final float n3 = -MathHelper.func_76134_b(-n * 0.017453292f);
        return new Vec3((double)(func_76126_a * n3), (double)MathHelper.func_76126_a(-n * 0.017453292f), (double)(func_76134_b * n3));
    }
    
    public static void l(final Entity entity, final boolean b, final boolean b2, final float n) {
        final EntityPlayerSP field_71439_g = Class5.mc.field_71439_g;
        final double n2 = entity.field_70165_t + (b2 ? ((entity.field_70165_t - entity.field_70169_q) * n) : 0.0) - (field_71439_g.field_70165_t + (b2 ? (field_71439_g.field_70165_t - field_71439_g.field_70169_q) : 0.0));
        final double n3 = entity.func_174813_aQ().field_72338_b + (b2 ? ((entity.func_174813_aQ().field_72338_b - entity.field_70167_r) * n) : 0.0) + entity.func_70047_e() - 0.15 - (field_71439_g.func_174813_aQ().field_72338_b + (b2 ? (field_71439_g.field_70163_u - field_71439_g.field_70167_r) : 0.0)) - field_71439_g.func_70047_e();
        final double n4 = entity.field_70161_v + (b2 ? ((entity.field_70161_v - entity.field_70166_s) * n) : 0.0) - (field_71439_g.field_70161_v + (b2 ? (field_71439_g.field_70161_v - field_71439_g.field_70166_s) : 0.0));
        final double n5 = n2;
        final double n6 = n4;
        final double sqrt = Math.sqrt(n5 * n5 + n6 * n6);
        final float n7 = field_71439_g.func_71052_bv() / 20.0f;
        float n8;
        if ((n8 = (n7 * n7 + n7 * 2.0f) / 3.0f) > 1.0f) {
            n8 = 1.0f;
        }
        float n9 = (float)(Math.atan2(n4, n2) * 180.0 / 3.141592653589793) - 90.0f;
        final float n10 = n8;
        final float n11 = n8;
        final double n12 = sqrt;
        final float n13 = n8;
        float n14 = (float)(-Math.toDegrees(Math.atan((n10 * n10 - Math.sqrt((double)(n11 * n11 * n8 * n8) - 0.006000000052154064 * (0.006000000052154064 * (n12 * n12) + n3 * 2.0 * (n13 * n13)))) / (sqrt * 0.006000000052154064))));
        if (n8 < 0.1f) {
            final float[] array = (float[])l(l(entity.func_174813_aQ()), true);
            n9 = array[0];
            n14 = array[1];
        }
        if (b) {
            l1(n9, n14);
            return;
        }
        final float[] array2 = (float[])l(new float[] { field_71439_g.field_70177_z, field_71439_g.field_70125_A }, new float[] { n9, n14 }, 10 + new Random().nextInt(6));
        if (array2 == null) {
            return;
        }
        field_71439_g.field_70177_z = array2[0];
        field_71439_g.field_70125_A = array2[1];
    }
    
    public static void l1(final float ll, final float l1) {
        if (Double.isNaN(ll) || Double.isNaN(l1)) {
            return;
        }
        Class5.ll = ll;
        Class5.l1 = l1;
        Class5.l = true;
        Class5.l11 = 0;
    }
    
    public static float[] l(final Entity entity) {
        if (entity == null || Class5.mc.field_71439_g == null) {
            return null;
        }
        return l(l(entity.func_174813_aQ(), false), true);
    }
    
    public static float[] l(final Vec3 vec3, final boolean b) {
        final Vec3 ll = ll();
        if (b) {
            ll.func_72441_c(Class5.mc.field_71439_g.field_70159_w, Class5.mc.field_71439_g.field_70181_x, Class5.mc.field_71439_g.field_70179_y);
        }
        final double n = vec3.field_72450_a - ll.field_72450_a;
        final double n2 = vec3.field_72448_b - ll.field_72448_b;
        final double n3 = vec3.field_72449_c - ll.field_72449_c;
        final double n4 = n;
        final double n5 = n3;
        return new float[] { MathHelper.func_76142_g((float)Math.toDegrees(Math.atan2(n3, n)) - 90.0f), MathHelper.func_76142_g((float)(-Math.toDegrees(Math.atan2(n2, Math.sqrt(n4 * n4 + n5 * n5))))) };
    }
    
    public static void l(final BlockPos blockPos) {
        if (blockPos == null) {
            return;
        }
        final double n = blockPos.func_177958_n() + 0.5 - Class5.mc.field_71439_g.field_70165_t;
        final double n2 = blockPos.func_177956_o() + 0.5 - (Class5.mc.field_71439_g.func_174813_aQ().field_72338_b + Class5.mc.field_71439_g.func_70047_e());
        final double n3 = blockPos.func_177952_p() + 0.5 - Class5.mc.field_71439_g.field_70161_v;
        final double n4 = n;
        final double n5 = n3;
        l1(Class5.mc.field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f - Class5.mc.field_71439_g.field_70177_z), Class5.mc.field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-Math.atan2(n2, Math.sqrt(n4 * n4 + n5 * n5)) * 180.0 / 3.141592653589793) - Class5.mc.field_71439_g.field_70125_A));
    }
    
    static {
        Class5.mc = Minecraft.func_71410_x();
        Class5.lll = false;
        Class5.ll1 = new float[] { 0.0f, 0.0f };
        Class5.llll = Math.random() / 3.0;
        Class5.lll1 = Math.random() / 3.0;
        Class5.lmc = Math.random() / 3.0;
    }
}
