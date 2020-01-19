package ClassSub;

import java.awt.*;

public enum Class59
{
    BLACK(-16711423), 
    BLUE(-12028161), 
    DARKBLUE(-12621684), 
    GREEN(-9830551), 
    DARKGREEN(-9320847), 
    WHITE(-65794), 
    AQUA(-7820064), 
    DARKAQUA(-12621684), 
    GREY(-9868951), 
    DARKGREY(-14342875), 
    RED(-65536), 
    DARKRED(-8388608), 
    ORANGE(-29696), 
    DARKORANGE(-2263808), 
    YELLOW(-256), 
    DARKYELLOW(-2702025), 
    MAGENTA(-18751), 
    DARKMAGENTA(-2252579);
    
    public int c;
    private static final Class59[] $VALUES;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Class59[] values() {
        return Class59.$VALUES.clone();
    }
    
    public static Class59 valueOf(final String s) {
        return Enum.valueOf(Class59.class, s);
    }
    
    private Class59(final int c) {
        this.c = c;
    }
    
    public static int getColor(final Color color) {
        return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
    
    public static int getColor(final int n) {
        return getColor(n, n, n, 255);
    }
    
    public static int getColor(final int n, final int n2) {
        return getColor(n, n, n, n2);
    }
    
    public static int getColor(final int n, final int n2, final int n3) {
        return getColor(n, n2, n3, 255);
    }
    
    public static int getColor(final int n, final int n2, final int n3, final int n4) {
        return 0x0 | n4 << 24 | n << 16 | n2 << 8 | n3;
    }
    
    static {
        $VALUES = new Class59[] { Class59.BLACK, Class59.BLUE, Class59.DARKBLUE, Class59.GREEN, Class59.DARKGREEN, Class59.WHITE, Class59.AQUA, Class59.DARKAQUA, Class59.GREY, Class59.DARKGREY, Class59.RED, Class59.DARKRED, Class59.ORANGE, Class59.DARKORANGE, Class59.YELLOW, Class59.DARKYELLOW, Class59.MAGENTA, Class59.DARKMAGENTA };
    }
}
