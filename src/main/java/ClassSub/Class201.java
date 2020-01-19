package ClassSub;

import java.util.*;

public class Class201 implements Comparator<Class325>
{
    final Class101 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class201(final Class101 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public int compare(final Class325 class325, final Class325 class326) {
        return (int)(class325.getSquareDistanceToFromTarget() + class325.getTotalCost() - (class326.getSquareDistanceToFromTarget() + class326.getTotalCost()));
    }
    
    @Override
    public int compare(final Object o, final Object o2) {
        return this.compare((Class325)o, (Class325)o2);
    }
}
