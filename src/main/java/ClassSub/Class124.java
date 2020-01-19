package ClassSub;

public enum Class124
{
    SUCCESS, 
    INFO, 
    WARNING, 
    ERROR;
    
    private static final Class124[] $VALUES;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Class124[] values() {
        return Class124.$VALUES.clone();
    }
    
    public static Class124 valueOf(final String s) {
        return Enum.valueOf(Class124.class, s);
    }
    
    static {
        $VALUES = new Class124[] { Class124.SUCCESS, Class124.INFO, Class124.WARNING, Class124.ERROR };
    }
}
