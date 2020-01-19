package ClassSub;

import java.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public enum Class128
{
    INSTANCE;
    
    public static ArrayList<Class67> notifications;
    public static double addY;
    private static final Class128[] $VALUES;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Class128[] values() {
        return Class128.$VALUES.clone();
    }
    
    public static Class128 valueOf(final String s) {
        return Enum.valueOf(Class128.class, s);
    }
    
    public void drawNotifications() {
        try {
            final double n2;
            double n = n2 = new ScaledResolution(Minecraft.func_71410_x()).func_78328_b() - 25;
            for (int i = 0; i < Class128.notifications.size(); ++i) {
                final Class67 class67 = (Class67)Class128.notifications.get(i);
                if (class67.shouldDelete()) {
                    Class128.notifications.remove(i);
                }
                class67.draw(n, n2);
                n -= class67.getHeight() + 1.0;
            }
        }
        catch (Throwable t) {}
    }
    
    public static void sendClientMessage(final String s, final Class67.Class124 class124) {
        if (Class128.notifications.size() > 8) {
            Class128.notifications.remove(0);
        }
        Class128.notifications.add(new Class67(s, class124));
    }
    
    public static int reAlpha(final int n, final float n2) {
        final Color color = new Color(n);
        return new Color(0.003921569f * color.getRed(), 0.003921569f * color.getGreen(), 0.003921569f * color.getBlue(), n2).getRGB();
    }
    
    public static boolean isBlockBetween(final BlockPos blockPos, final BlockPos blockPos2) {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final int func_177958_n = blockPos.func_177958_n();
        final int func_177956_o = blockPos.func_177956_o();
        final int func_177952_p = blockPos.func_177952_p();
        final int func_177958_n2 = blockPos2.func_177958_n();
        final int func_177956_o2 = blockPos2.func_177956_o();
        final int func_177952_p2 = blockPos2.func_177952_p();
        final double n = (double)(func_177958_n2 - func_177958_n);
        final double n2 = (double)(func_177956_o2 - func_177956_o);
        final double n3 = (double)(func_177952_p2 - func_177952_p);
        double n4 = (double)func_177958_n;
        double n5 = (double)func_177956_o;
        double n6 = (double)func_177952_p;
        for (int n7 = (int)Math.max(Math.abs(n), Math.max(Math.abs(n2), Math.abs(n3))) * 4, i = 0; i < n7 - 1; ++i) {
            n4 += n / n7;
            n5 += n2 / n7;
            n6 += n3 / n7;
            if (n4 != func_177958_n2 || n5 != func_177956_o2 || n6 != func_177952_p2) {
                final Block func_177230_c = func_71410_x.field_71441_e.func_180495_p(new BlockPos(n4, n5, n6)).func_177230_c();
                if (func_177230_c.func_149688_o() != Material.field_151579_a && func_177230_c.func_149688_o() != Material.field_151586_h && !(func_177230_c instanceof BlockVine) && !(func_177230_c instanceof BlockLadder)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static String removeColorCode(final String s) {
        return s.replaceAll("§.", "");
    }
    
    static {
        $VALUES = new Class128[] { Class128.INSTANCE };
        Class128.notifications = new ArrayList<Class67>();
    }
}
