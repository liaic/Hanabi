package ClassSub;

import java.io.*;

protected class Class308 implements Serializable
{
    protected Class25 first;
    protected Class308 next;
    final Class190 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    protected Class308(final Class190 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public void clear() {
        if (this.first != null) {
            Class190.access$000(this.this$0, this.first);
            this.first = null;
        }
    }
    
    public void add(final Class25 prev) {
        if (this.first != null) {
            this.first.insertBefore(prev);
        }
        else {
            this.first = prev;
            prev.next = prev;
            prev.prev = prev;
        }
    }
    
    public void computeAngles() {
        if (this.first == null) {
            return;
        }
        Class25 class25 = this.first;
        do {
            class25.computeAngle();
        } while ((class25 = class25.next) != this.first);
    }
    
    public boolean doesIntersectSegment(final Class271 class271, final Class271 class272) {
        final double n = (double)(class272.x - class271.x);
        final double n2 = (double)(class272.y - class271.y);
        Class25 first = this.first;
        while (true) {
            final Class25 next = first.next;
            if (first.pt != class271 && next.pt != class271 && first.pt != class272 && next.pt != class272) {
                final double n3 = (double)(next.pt.x - first.pt.x);
                final double n4 = (double)(next.pt.y - first.pt.y);
                final double n5 = n * n4 - n2 * n3;
                if (Math.abs(n5) > 1.0E-5) {
                    final double n6 = (double)(first.pt.x - class271.x);
                    final double n7 = (double)(first.pt.y - class271.y);
                    final double n8 = (n4 * n6 - n3 * n7) / n5;
                    final double n9 = (n2 * n6 - n * n7) / n5;
                    if (n8 >= 0.0 && n8 <= 1.0 && n9 >= 0.0 && n9 <= 1.0) {
                        return true;
                    }
                }
            }
            if (next == this.first) {
                return false;
            }
            first = next;
        }
    }
    
    public int countPoints() {
        if (this.first == null) {
            return 0;
        }
        int n = 0;
        Class25 class25 = this.first;
        do {
            ++n;
        } while ((class25 = class25.next) != this.first);
        return n;
    }
    
    public boolean contains(final Class271 class271) {
        return this.first != null && (this.first.prev.pt.equals(class271) || this.first.pt.equals(class271));
    }
}
