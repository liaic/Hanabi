package ClassSub;

import java.util.*;

public class Class105
{
    private static Class105 single;
    private ArrayList deferred;
    private int total;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Class105 get() {
        return Class105.single;
    }
    
    public static void setDeferredLoading(final boolean deferredLoading) {
        Class105.single = new Class105();
        Class6.get().setDeferredLoading(deferredLoading);
    }
    
    public static boolean isDeferredLoading() {
        return Class6.get().isDeferredLoading();
    }
    
    private Class105() {
        super();
        this.deferred = new ArrayList();
    }
    
    public void add(final Class288 class288) {
        ++this.total;
        this.deferred.add(class288);
    }
    
    public void remove(final Class288 class288) {
        Class121.info("Early loading of deferred resource due to req: " + class288.getDescription());
        --this.total;
        this.deferred.remove(class288);
    }
    
    public int getTotalResources() {
        return this.total;
    }
    
    public int getRemainingResources() {
        return this.deferred.size();
    }
    
    public Class288 getNext() {
        if (this.deferred.size() == 0) {
            return null;
        }
        return this.deferred.remove(0);
    }
    
    static {
        Class105.single = new Class105();
    }
}
