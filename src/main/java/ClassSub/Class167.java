package ClassSub;

import java.awt.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.util.*;

public class Class167
{
    private static Map<Integer, Boolean> glCapMap;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class167() {
        super();
    }
    
    public static void setColor(final Color color) {
        GL11.glColor4f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
    }
    
    public static void setGLCap(final int n, final boolean b) {
        Class167.glCapMap.put(n, GL11.glGetBoolean(n));
        if (b) {
            GL11.glEnable(n);
        }
        else {
            GL11.glDisable(n);
        }
    }
    
    public static void revertGLCap(final int n) {
        final Boolean b = (Boolean)Class167.glCapMap.get(n);
        if (b != null) {
            if ((boolean)b) {
                GL11.glEnable(n);
            }
            else {
                GL11.glDisable(n);
            }
        }
    }
    
    public static void glEnable(final int n) {
        setGLCap(n, true);
    }
    
    public static void glDisable(final int n) {
        setGLCap(n, false);
    }
    
    public static void revertAllCaps() {
        final Iterator<Integer> iterator = Class167.glCapMap.keySet().iterator();
        while (iterator.hasNext()) {
            revertGLCap(iterator.next());
        }
    }
    
    public static void setColor(final int n) {
        GL11.glColor4b((byte)(n & 0xFF), (byte)(n >> 8 & 0xFF), (byte)(n >> 16 & 0xFF), (byte)(n >> 24 & 0xFF));
    }
    
    public static int toRGBA(final Color color) {
        return color.getRed() | color.getGreen() << 8 | color.getBlue() << 16 | color.getAlpha() << 24;
    }
    
    public static void drawRect(final int n, int n2, int n3, int n4, int n5, final int n6) {
        if (n2 < n4) {
            final int n7 = n2;
            n2 = n4;
            n4 = n7;
        }
        if (n3 < n5) {
            final int n8 = n3;
            n3 = n5;
            n5 = n8;
        }
        final float n9 = (n6 >> 24 & 0xFF) / 255.0f;
        final float n10 = (n6 >> 16 & 0xFF) / 255.0f;
        final float n11 = (n6 >> 8 & 0xFF) / 255.0f;
        final float n12 = (n6 & 0xFF) / 255.0f;
        final Tessellator func_178181_a = Tessellator.func_178181_a();
        final WorldRenderer func_178180_c = func_178181_a.func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(n10, n11, n12, n9);
        func_178180_c.func_181668_a(n, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n2, (double)n5, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n4, (double)n5, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n4, (double)n3, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n2, (double)n3, 0.0).func_181675_d();
        func_178181_a.func_78381_a();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    static {
        Class167.glCapMap = new HashMap<Integer, Boolean>();
    }
}
