package ClassSub;

import java.util.*;

class Class33 extends LinkedHashMap
{
    final Class135 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class33(final Class135 this$0, final int n, final float n2, final boolean b) {
        this.this$0 = this$0;
        super(n, n2, b);
    }
    
    @Override
    protected boolean removeEldestEntry(final Map.Entry entry) {
        final Class135.Class24 class24 = (Class135.Class24)entry.getValue();
        if (class24 != null) {
            Class135.access$002(this.this$0, class24.id);
        }
        return this.size() > 200;
    }
}
