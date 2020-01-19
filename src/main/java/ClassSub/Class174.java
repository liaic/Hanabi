package ClassSub;

import java.util.*;

public class Class174
{
    public float EPSILON;
    public float EDGE_SCALE;
    public int MAX_POINTS;
    public Class126 listener;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class174() {
        super();
        this.EPSILON = 1.0E-4f;
        this.EDGE_SCALE = 1.0f;
        this.MAX_POINTS = 10000;
    }
    
    public Class68[] subtract(Class68 transform, Class68 transform2) {
        transform = transform.transform(new Class300());
        transform2 = transform2.transform(new Class300());
        int n = 0;
        for (int i = 0; i < transform.getPointCount(); ++i) {
            if (transform2.contains(((float[])transform.getPoint(i))[0], ((float[])transform.getPoint(i))[1])) {
                ++n;
            }
        }
        if (n == transform.getPointCount()) {
            return new Class68[0];
        }
        if (!transform.intersects(transform2)) {
            return new Class68[] { transform };
        }
        int n2 = 0;
        for (int j = 0; j < transform2.getPointCount(); ++j) {
            if (transform.contains(((float[])transform2.getPoint(j))[0], ((float[])transform2.getPoint(j))[1]) && !this.onPath(transform, ((float[])transform2.getPoint(j))[0], ((float[])transform2.getPoint(j))[1])) {
                ++n2;
            }
        }
        for (int k = 0; k < transform.getPointCount(); ++k) {
            if (transform2.contains(((float[])transform.getPoint(k))[0], ((float[])transform.getPoint(k))[1]) && !this.onPath(transform2, ((float[])transform.getPoint(k))[0], ((float[])transform.getPoint(k))[1])) {
                ++n2;
            }
        }
        if (n2 < 1) {
            return new Class68[] { transform };
        }
        return this.combine(transform, transform2, true);
    }
    
    private boolean onPath(final Class68 class68, final float n, final float n2) {
        for (int i = 0; i < class68.getPointCount() + 1; ++i) {
            if (this.getLine(class68, rationalPoint(class68, i), rationalPoint(class68, i + 1)).distance(new Class271(n, n2)) < this.EPSILON * 100.0f) {
                return true;
            }
        }
        return false;
    }
    
    public void setListener(final Class126 listener) {
        this.listener = listener;
    }
    
    public Class68[] union(Class68 transform, Class68 transform2) {
        transform = transform.transform(new Class300());
        transform2 = transform2.transform(new Class300());
        if (!transform.intersects(transform2)) {
            return new Class68[] { transform, transform2 };
        }
        boolean b = false;
        int n = 0;
        for (int i = 0; i < transform.getPointCount(); ++i) {
            if (transform2.contains(((float[])transform.getPoint(i))[0], ((float[])transform.getPoint(i))[1]) && !transform2.hasVertex(((float[])transform.getPoint(i))[0], ((float[])transform.getPoint(i))[1])) {
                b = true;
                break;
            }
            if (transform2.hasVertex(((float[])transform.getPoint(i))[0], ((float[])transform.getPoint(i))[1])) {
                ++n;
            }
        }
        for (int j = 0; j < transform2.getPointCount(); ++j) {
            if (transform.contains(((float[])transform2.getPoint(j))[0], ((float[])transform2.getPoint(j))[1]) && !transform.hasVertex(((float[])transform2.getPoint(j))[0], ((float[])transform2.getPoint(j))[1])) {
                b = true;
                break;
            }
        }
        if (!b && n < 2) {
            return new Class68[] { transform, transform2 };
        }
        return this.combine(transform, transform2, false);
    }
    
    private Class68[] combine(final Class68 class68, final Class68 class69, final boolean b) {
        if (b) {
            final ArrayList<Class68> list = new ArrayList<Class68>();
            final ArrayList<Class271> list2 = new ArrayList<Class271>();
            for (int i = 0; i < class68.getPointCount(); ++i) {
                final float[] array = (float[])class68.getPoint(i);
                if (class69.contains(array[0], array[1])) {
                    list2.add(new Class271(array[0], array[1]));
                    if (this.listener != null) {
                        this.listener.pointExcluded(array[0], array[1]);
                    }
                }
            }
            for (int j = 0; j < class68.getPointCount(); ++j) {
                final float[] array2 = (float[])class68.getPoint(j);
                if (!list2.contains(new Class271(array2[0], array2[1]))) {
                    final Class68 combineSingle = this.combineSingle(class68, class69, true, j);
                    list.add(combineSingle);
                    for (int k = 0; k < combineSingle.getPointCount(); ++k) {
                        final float[] array3 = (float[])combineSingle.getPoint(k);
                        list2.add(new Class271(array3[0], array3[1]));
                    }
                }
            }
            return list.toArray(new Class68[0]);
        }
        for (int l = 0; l < class68.getPointCount(); ++l) {
            if (!class69.contains(((float[])class68.getPoint(l))[0], ((float[])class68.getPoint(l))[1]) && !class69.hasVertex(((float[])class68.getPoint(l))[0], ((float[])class68.getPoint(l))[1])) {
                return new Class68[] { this.combineSingle(class68, class69, false, l) };
            }
        }
        return new Class68[] { class69 };
    }
    
    private Class68 combineSingle(final Class68 class68, final Class68 class69, final boolean b, final int n) {
        Class68 class70 = class68;
        Class68 class71 = class69;
        int n2 = n;
        int n3 = 1;
        final Class249 class72 = new Class249();
        int n4 = 1;
        int n5 = 0;
        float n6 = ((float[])class70.getPoint(n2))[0];
        float n7 = ((float[])class70.getPoint(n2))[1];
        while (!class72.hasVertex(n6, n7) || n4 != 0 || class70 != class68) {
            n4 = 0;
            if (++n5 > this.MAX_POINTS) {
                break;
            }
            class72.addPoint(n6, n7);
            if (this.listener != null) {
                this.listener.pointUsed(n6, n7);
            }
            final Class264 intersect = this.intersect(class71, this.getLine(class70, n6, n7, rationalPoint(class70, n2 + n3)));
            if (intersect != null) {
                final Class269 line = intersect.line;
                final Class271 pt = intersect.pt;
                n6 = pt.x;
                n7 = pt.y;
                if (this.listener != null) {
                    this.listener.pointIntersected(n6, n7);
                }
                if (class71.hasVertex(n6, n7)) {
                    n2 = class71.indexOf(pt.x, pt.y);
                    n3 = 1;
                    n6 = pt.x;
                    n7 = pt.y;
                    final Class68 class73 = class70;
                    class70 = class71;
                    class71 = class73;
                }
                else {
                    final float n8 = line.getDX() / line.length();
                    final float n9 = line.getDY() / line.length();
                    final float n10 = n8 * this.EDGE_SCALE;
                    final float n11 = n9 * this.EDGE_SCALE;
                    if (class70.contains(pt.x + n10, pt.y + n11)) {
                        if (b) {
                            if (class70 == class69) {
                                n2 = intersect.p2;
                                n3 = -1;
                            }
                            else {
                                n2 = intersect.p1;
                                n3 = 1;
                            }
                        }
                        else if (class70 == class68) {
                            n2 = intersect.p2;
                            n3 = -1;
                        }
                        else {
                            n2 = intersect.p2;
                            n3 = -1;
                        }
                        final Class68 class74 = class70;
                        class70 = class71;
                        class71 = class74;
                    }
                    else if (class70.contains(pt.x - n10, pt.y - n11)) {
                        if (b) {
                            if (class70 == class68) {
                                n2 = intersect.p2;
                                n3 = -1;
                            }
                            else {
                                n2 = intersect.p1;
                                n3 = 1;
                            }
                        }
                        else if (class70 == class69) {
                            n2 = intersect.p1;
                            n3 = 1;
                        }
                        else {
                            n2 = intersect.p1;
                            n3 = 1;
                        }
                        final Class68 class75 = class70;
                        class70 = class71;
                        class71 = class75;
                    }
                    else {
                        if (b) {
                            break;
                        }
                        final int p4 = intersect.p1;
                        n3 = 1;
                        final Class68 class76 = class70;
                        class70 = class71;
                        class71 = class76;
                        n2 = rationalPoint(class70, p4 + n3);
                        n6 = ((float[])class70.getPoint(n2))[0];
                        n7 = ((float[])class70.getPoint(n2))[1];
                    }
                }
            }
            else {
                n2 = rationalPoint(class70, n2 + n3);
                n6 = ((float[])class70.getPoint(n2))[0];
                n7 = ((float[])class70.getPoint(n2))[1];
            }
        }
        class72.addPoint(n6, n7);
        if (this.listener != null) {
            this.listener.pointUsed(n6, n7);
        }
        return class72;
    }
    
    public Class264 intersect(final Class68 class68, final Class269 class69) {
        float n = Float.MAX_VALUE;
        Class264 class70 = null;
        for (int i = 0; i < class68.getPointCount(); ++i) {
            final int rationalPoint = rationalPoint(class68, i + 1);
            final Class269 line = this.getLine(class68, i, rationalPoint);
            final Class271 intersect = class69.intersect(line, true);
            if (intersect != null) {
                final float distance = intersect.distance(class69.getStart());
                if (distance < n && distance > this.EPSILON) {
                    class70 = new Class264();
                    class70.pt = intersect;
                    class70.line = line;
                    class70.p1 = i;
                    class70.p2 = rationalPoint;
                    n = distance;
                }
            }
        }
        return class70;
    }
    
    public static int rationalPoint(final Class68 class68, int i) {
        while (i < 0) {
            i += class68.getPointCount();
        }
        while (i >= class68.getPointCount()) {
            i -= class68.getPointCount();
        }
        return i;
    }
    
    public Class269 getLine(final Class68 class68, final int n, final int n2) {
        final float[] array = (float[])class68.getPoint(n);
        final float[] array2 = (float[])class68.getPoint(n2);
        return new Class269(array[0], array[1], array2[0], array2[1]);
    }
    
    public Class269 getLine(final Class68 class68, final float n, final float n2, final int n3) {
        final float[] array = (float[])class68.getPoint(n3);
        return new Class269(n, n2, array[0], array[1]);
    }
}
