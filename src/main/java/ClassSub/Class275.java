package ClassSub;

import java.util.*;

class Class275 implements Iterator
{
    final ListIterator val$iter;
    final Class132 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class275(final Class132 this$0, final ListIterator val$iter) {
        this.this$0 = this$0;
        this.val$iter = val$iter;
        super();
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iter.hasPrevious();
    }
    
    @Override
    public Object next() {
        return this.val$iter.previous();
    }
    
    @Override
    public void remove() {
        this.val$iter.remove();
    }
}
