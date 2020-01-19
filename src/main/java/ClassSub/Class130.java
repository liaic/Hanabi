package ClassSub;

import java.util.*;

class Class130 extends LinkedHashMap
{
    final Class36 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class130(final Class36 this$0, final int n, final float n2, final boolean b) {
        this.this$0 = this$0;
        super(n, n2, b);
    }
    
    @Override
    protected boolean removeEldestEntry(final Map.Entry entry) {
        Class36.access$002(this.this$0, entry.getValue());
        Class36.access$102(this.this$0, Class36.access$000(this.this$0).id);
        return false;
    }
}
