package ClassSub;

public class Class83
{
    public static final int IMMEDIATE_RENDERER = 1;
    public static final int VERTEX_ARRAY_RENDERER = 2;
    public static final int DEFAULT_LINE_STRIP_RENDERER = 3;
    public static final int QUAD_BASED_LINE_STRIP_RENDERER = 4;
    private static Class12 renderer;
    private static Class247 lineStripRenderer;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class83() {
        super();
    }
    
    public static void setRenderer(final int n) {
        switch (n) {
            case 1: {
                setRenderer(new Class103());
            }
            case 2: {
                setRenderer(new Class19());
            }
            default: {
                throw new RuntimeException("Unknown renderer type: " + n);
            }
        }
    }
    
    public static void setLineStripRenderer(final int n) {
        switch (n) {
            case 3: {
                setLineStripRenderer(new Class63());
            }
            case 4: {
                setLineStripRenderer(new Class239());
            }
            default: {
                throw new RuntimeException("Unknown line strip renderer type: " + n);
            }
        }
    }
    
    public static void setLineStripRenderer(final Class247 lineStripRenderer) {
        Class83.lineStripRenderer = lineStripRenderer;
    }
    
    public static void setRenderer(final Class12 renderer) {
        Class83.renderer = renderer;
    }
    
    public static Class12 get() {
        return Class83.renderer;
    }
    
    public static Class247 getLineStripRenderer() {
        return Class83.lineStripRenderer;
    }
    
    static {
        Class83.renderer = new Class103();
        Class83.lineStripRenderer = new Class63();
    }
}
