package ClassSub;

import java.applet.*;

public abstract class Class184
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    protected Class184() {
        super();
    }
    
    public abstract Object call(final String p0, final Object... p1) throws Class35;
    
    public abstract Object eval(final String p0) throws Class35;
    
    public abstract Object getMember(final String p0) throws Class35;
    
    public abstract void setMember(final String p0, final Object p1) throws Class35;
    
    public abstract void removeMember(final String p0) throws Class35;
    
    public abstract Object getSlot(final int p0) throws Class35;
    
    public abstract void setSlot(final int p0, final Object p1) throws Class35;
    
    public static Class184 getWindow(final Applet applet) throws Class35 {
        throw new Class35("Unexpected error: This method should not be used unless loaded from plugin.jar");
    }
}
