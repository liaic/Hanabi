package ClassSub;

import net.minecraft.client.*;
import net.minecraft.potion.*;
import net.minecraft.block.material.*;
import net.minecraft.client.entity.*;
import net.minecraft.block.*;
import org.lwjgl.util.vector.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.attributes.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class Class295
{
    private static Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class295() {
        super();
    }
    
    public void portMove(final float n, final float n2, final float n3) {
        Class295.mc.field_71439_g.func_70107_b(-Math.sin(Math.toRadians((double)n)) * n2 + Class295.mc.field_71439_g.field_70165_t, (double)n3 + Class295.mc.field_71439_g.field_70163_u, Math.cos(Math.toRadians((double)n)) * n2 + Class295.mc.field_71439_g.field_70161_v);
    }
    
    public static double getBaseMoveSpeed() {
        if (Class69.password.length() < 32) {
            System.exit(0);
        }
        double n = 0.2873;
        if (Minecraft.func_71410_x().field_71439_g.func_70644_a(Potion.field_76424_c)) {
            n *= 1.0 + 0.2 * (Minecraft.func_71410_x().field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1);
        }
        return n;
    }
    
    public static float getDirection() {
        float field_70177_z = Class295.mc.field_71439_g.field_70177_z;
        if (Class295.mc.field_71439_g.field_70701_bs < 0.0f) {
            field_70177_z += 180.0f;
        }
        float n = 1.0f;
        if (Class295.mc.field_71439_g.field_70701_bs < 0.0f) {
            n = -0.5f;
        }
        else if (Class295.mc.field_71439_g.field_70701_bs > 0.0f) {
            n = 0.5f;
        }
        if (Class295.mc.field_71439_g.field_70702_br > 0.0f) {
            field_70177_z -= 90.0f * n;
        }
        if (Class295.mc.field_71439_g.field_70702_br < 0.0f) {
            field_70177_z += 90.0f * n;
        }
        return field_70177_z * 0.017453292f;
    }
    
    public static boolean isInWater() {
        return Class295.mc.field_71441_e.func_180495_p(new BlockPos(Class295.mc.field_71439_g.field_70165_t, Class295.mc.field_71439_g.field_70163_u, Class295.mc.field_71439_g.field_70161_v)).func_177230_c().func_149688_o() == Material.field_151586_h;
    }
    
    public static void toFwd(final double n) {
        final float n2 = Class295.mc.field_71439_g.field_70177_z * 0.017453292f;
        final EntityPlayerSP field_71439_g = Class295.mc.field_71439_g;
        field_71439_g.field_70159_w -= MathHelper.func_76126_a(n2) * n;
        final EntityPlayerSP field_71439_g2 = Class295.mc.field_71439_g;
        field_71439_g2.field_70179_y += MathHelper.func_76134_b(n2) * n;
    }
    
    public static void setSpeed(final double n) {
        Class295.mc.field_71439_g.field_70159_w = -(Math.sin(getDirection()) * n);
        Class295.mc.field_71439_g.field_70179_y = Math.cos(getDirection()) * n;
    }
    
    public static double getSpeed() {
        if (Class69.password.length() < 32) {
            System.exit(0);
        }
        return Math.sqrt(Minecraft.func_71410_x().field_71439_g.field_70159_w * Minecraft.func_71410_x().field_71439_g.field_70159_w + Minecraft.func_71410_x().field_71439_g.field_70179_y * Minecraft.func_71410_x().field_71439_g.field_70179_y);
    }
    
    public static Block getBlockUnderPlayer(final EntityPlayer entityPlayer) {
        return getBlock(new BlockPos(entityPlayer.field_70165_t, entityPlayer.field_70163_u - 1.0, entityPlayer.field_70161_v));
    }
    
    public static Block getBlock(final BlockPos blockPos) {
        return Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    public static Block getBlockAtPosC(final EntityPlayer entityPlayer, final double n, final double n2, final double n3) {
        return getBlock(new BlockPos(entityPlayer.field_70165_t - n, entityPlayer.field_70163_u - n2, entityPlayer.field_70161_v - n3));
    }
    
    public static ArrayList<Vector3f> vanillaTeleportPositions(final double n, final double n2, final double n3, final double n4) {
        final ArrayList<Vector3f> list = new ArrayList<Vector3f>();
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final double n5 = n - func_71410_x.field_71439_g.field_70165_t;
        final double n6 = n2 - (func_71410_x.field_71439_g.field_70163_u + func_71410_x.field_71439_g.func_70047_e() + 1.1);
        final double n7 = n3 - func_71410_x.field_71439_g.field_70161_v;
        final float n8 = (float)(Math.atan2(n7, n5) * 180.0 / 3.141592653589793 - 90.0);
        final float n9 = (float)(-Math.atan2(n6, Math.sqrt(n5 * n5 + n7 * n7)) * 180.0 / 3.141592653589793);
        final double field_70165_t = func_71410_x.field_71439_g.field_70165_t;
        double field_70163_u = func_71410_x.field_71439_g.field_70163_u;
        final double field_70161_v = func_71410_x.field_71439_g.field_70161_v;
        double n10 = 1.0;
        for (double n11 = n4; n11 < getDistance(func_71410_x.field_71439_g.field_70165_t, func_71410_x.field_71439_g.field_70163_u, func_71410_x.field_71439_g.field_70161_v, n, n2, n3); n11 += n4) {
            ++n10;
        }
        for (double n12 = n4; n12 < getDistance(func_71410_x.field_71439_g.field_70165_t, func_71410_x.field_71439_g.field_70163_u, func_71410_x.field_71439_g.field_70161_v, n, n2, n3); n12 += n4) {
            final double n13 = func_71410_x.field_71439_g.field_70165_t - Math.sin(getDirection(n8)) * n12;
            final double n14 = func_71410_x.field_71439_g.field_70161_v + Math.cos(getDirection(n8)) * n12;
            field_70163_u -= (func_71410_x.field_71439_g.field_70163_u - n2) / n10;
            list.add(new Vector3f((float)n13, (float)field_70163_u, (float)n14));
        }
        list.add(new Vector3f((float)n, (float)n2, (float)n3));
        return list;
    }
    
    public static float getDirection(float n) {
        if (Minecraft.func_71410_x().field_71439_g.field_70701_bs < 0.0f) {
            n += 180.0f;
        }
        float n2 = 1.0f;
        if (Minecraft.func_71410_x().field_71439_g.field_70701_bs < 0.0f) {
            n2 = -0.5f;
        }
        else if (Minecraft.func_71410_x().field_71439_g.field_70701_bs > 0.0f) {
            n2 = 0.5f;
        }
        if (Minecraft.func_71410_x().field_71439_g.field_70702_br > 0.0f) {
            n -= 90.0f * n2;
        }
        if (Minecraft.func_71410_x().field_71439_g.field_70702_br < 0.0f) {
            n += 90.0f * n2;
        }
        n *= 0.017453292f;
        return n;
    }
    
    public static double getDistance(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n - n4;
        final double n8 = n2 - n5;
        final double n9 = n3 - n6;
        return MathHelper.func_76133_a(n7 * n7 + n8 * n8 + n9 * n9);
    }
    
    public static boolean MovementInput() {
        return ((IKeyBinding)Class295.mc.field_71474_y.field_74351_w).getPress() || ((IKeyBinding)Class295.mc.field_71474_y.field_74370_x).getPress() || ((IKeyBinding)Class295.mc.field_71474_y.field_74366_z).getPress() || ((IKeyBinding)Class295.mc.field_71474_y.field_74368_y).getPress();
    }
    
    public static void blockHit(final Entity entity, final boolean b) {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final ItemStack func_71045_bC = func_71410_x.field_71439_g.func_71045_bC();
        if (func_71410_x.field_71439_g.func_71045_bC() != null && entity != null && b && func_71045_bC.func_77973_b() instanceof ItemSword && func_71410_x.field_71439_g.field_70733_aJ > 0.2) {
            func_71410_x.field_71439_g.func_71045_bC().func_77957_a((World)func_71410_x.field_71441_e, (EntityPlayer)func_71410_x.field_71439_g);
        }
    }
    
    public static float getItemAtkDamage(final ItemStack itemStack) {
        final Multimap func_111283_C = itemStack.func_111283_C();
        if (!func_111283_C.isEmpty()) {
            final Iterator iterator = func_111283_C.entries().iterator();
            if (iterator.hasNext()) {
                final AttributeModifier attributeModifier = (AttributeModifier)((Map.Entry<K, AttributeModifier>)iterator.next()).getValue();
                final double n = (attributeModifier.func_111169_c() != 1 && attributeModifier.func_111169_c() != 2) ? attributeModifier.func_111164_d() : (attributeModifier.func_111164_d() * 100.0);
                if (attributeModifier.func_111164_d() > 1.0) {
                    return 1.0f + (float)n;
                }
                return 1.0f;
            }
        }
        return 1.0f;
    }
    
    public static int bestWeapon(final Entity entity) {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final InventoryPlayer field_71071_by = func_71410_x.field_71439_g.field_71071_by;
        final boolean field_70461_c = false;
        field_71071_by.field_70461_c = (field_70461_c ? 1 : 0);
        final boolean b = field_70461_c;
        int n = -1;
        int n2 = 1;
        for (int i = 0; i < 9; i = (byte)(i + 1)) {
            func_71410_x.field_71439_g.field_71071_by.field_70461_c = i;
            final ItemStack func_70694_bm = func_71410_x.field_71439_g.func_70694_bm();
            if (func_70694_bm != null) {
                final int n3 = (int)((int)getItemAtkDamage(func_70694_bm) + EnchantmentHelper.func_152377_a(func_70694_bm, EnumCreatureAttribute.UNDEFINED));
                if (n3 > n2) {
                    n2 = n3;
                    n = i;
                }
            }
        }
        if (n != -1) {
            return n;
        }
        return b ? 1 : 0;
    }
    
    public static void shiftClick(final Item item) {
        for (int i = 9; i < 37; ++i) {
            final ItemStack func_75211_c = Class295.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
            if (func_75211_c != null && func_75211_c.func_77973_b() == item) {
                Class295.mc.field_71442_b.func_78753_a(0, i, 0, 1, (EntityPlayer)Class295.mc.field_71439_g);
                break;
            }
        }
    }
    
    public static boolean hotbarIsFull() {
        for (int i = 0; i <= 36; ++i) {
            if (Class295.mc.field_71439_g.field_71071_by.func_70301_a(i) == null) {
                return false;
            }
        }
        return true;
    }
    
    public static void tellPlayer(final String s) {
        if (s != null && Class295.mc.field_71439_g != null) {
            Class295.mc.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(s));
        }
    }
    
    public static boolean isMoving() {
        return !Class295.mc.field_71439_g.field_70123_F && !Class295.mc.field_71439_g.func_70093_af() && (Class295.mc.field_71439_g.field_71158_b.field_78900_b != 0.0f || Class295.mc.field_71439_g.field_71158_b.field_78902_a != 0.0f);
    }
    
    public static boolean isMoving2() {
        return Class295.mc.field_71439_g.field_70701_bs != 0.0f || Class295.mc.field_71439_g.field_70702_br != 0.0f;
    }
    
    public static void blinkToPos(final double[] array, final BlockPos blockPos, final double n, final double[] array2) {
        double n2 = array[0];
        double n3 = array[1];
        double n4 = array[2];
        final double n5 = blockPos.func_177958_n() + 0.5;
        final double n6 = blockPos.func_177956_o() + 1.0;
        final double n7 = blockPos.func_177952_p() + 0.5;
        double n8 = Math.abs(n2 - n5) + Math.abs(n3 - n6) + Math.abs(n4 - n7);
        int n9 = 0;
        while (n8 > n) {
            n8 = Math.abs(n2 - n5) + Math.abs(n3 - n6) + Math.abs(n4 - n7);
            if (n9 > 120) {
                break;
            }
            final double n10 = n2 - n5;
            final double n11 = n3 - n6;
            final double n12 = n4 - n7;
            final double n13 = ((n9 & 0x1) == 0x0) ? array2[0] : array2[1];
            if (n10 < 0.0) {
                if (Math.abs(n10) > n13) {
                    n2 += n13;
                }
                else {
                    n2 += Math.abs(n10);
                }
            }
            if (n10 > 0.0) {
                if (Math.abs(n10) > n13) {
                    n2 -= n13;
                }
                else {
                    n2 -= Math.abs(n10);
                }
            }
            if (n11 < 0.0) {
                if (Math.abs(n11) > 0.25) {
                    n3 += 0.25;
                }
                else {
                    n3 += Math.abs(n11);
                }
            }
            if (n11 > 0.0) {
                if (Math.abs(n11) > 0.25) {
                    n3 -= 0.25;
                }
                else {
                    n3 -= Math.abs(n11);
                }
            }
            if (n12 < 0.0) {
                if (Math.abs(n12) > n13) {
                    n4 += n13;
                }
                else {
                    n4 += Math.abs(n12);
                }
            }
            if (n12 > 0.0) {
                if (Math.abs(n12) > n13) {
                    n4 -= n13;
                }
                else {
                    n4 -= Math.abs(n12);
                }
            }
            Minecraft.func_71410_x().func_147114_u().func_147297_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(n2, n3, n4, true));
            ++n9;
        }
    }
    
    static {
        Class295.mc = Minecraft.func_71410_x();
    }
}
