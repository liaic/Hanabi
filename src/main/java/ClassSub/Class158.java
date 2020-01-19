package ClassSub;

import java.util.*;

public class Class158 implements Class42
{
    private static final float EPSILON = 1.0E-10f;
    private Class76 poly;
    private Class76 tris;
    private boolean tried;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class158() {
        super();
        this.poly = new Class76();
        this.tris = new Class76();
    }
    
    @Override
    public void addPolyPoint(final float n, final float n2) {
        final Class279 class279 = new Class279(n, n2);
        if (!this.poly.contains(class279)) {
            this.poly.add(class279);
        }
    }
    
    public int getPolyPointCount() {
        return this.poly.size();
    }
    
    public float[] getPolyPoint(final int n) {
        return new float[] { Class279.access$000(this.poly.get(n)), Class279.access$100(this.poly.get(n)) };
    }
    
    @Override
    public boolean triangulate() {
        this.tried = true;
        return this.process(this.poly, this.tris);
    }
    
    @Override
    public int getTriangleCount() {
        if (!this.tried) {
            throw new RuntimeException("Call triangulate() before accessing triangles");
        }
        return this.tris.size() / 3;
    }
    
    @Override
    public float[] getTrianglePoint(final int n, final int n2) {
        if (!this.tried) {
            throw new RuntimeException("Call triangulate() before accessing triangles");
        }
        return this.tris.get(n * 3 + n2).toArray();
    }
    
    private float area(final Class76 class76) {
        final int size = class76.size();
        float n = 0.0f;
        int n2 = size - 1;
        for (int i = 0; i < size; n2 = i++) {
            final Class279 value = class76.get(n2);
            final Class279 value2 = class76.get(i);
            n += value.getX() * value2.getY() - value2.getX() * value.getY();
        }
        return n * 0.5f;
    }
    
    private boolean insideTriangle(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        final float n9 = n5 - n3;
        final float n10 = n6 - n4;
        final float n11 = n - n5;
        final float n12 = n2 - n6;
        final float n13 = n3 - n;
        final float n14 = n4 - n2;
        final float n15 = n7 - n;
        final float n16 = n8 - n2;
        final float n17 = n7 - n3;
        final float n18 = n8 - n4;
        final float n19 = n7 - n5;
        final float n20 = n8 - n6;
        final float n21 = n9 * n18 - n10 * n17;
        final float n22 = n13 * n16 - n14 * n15;
        final float n23 = n11 * n20 - n12 * n19;
        return n21 >= 0.0f && n23 >= 0.0f && n22 >= 0.0f;
    }
    
    private boolean snip(final Class76 class76, final int n, final int n2, final int n3, final int n4, final int[] array) {
        final float x = class76.get(array[n]).getX();
        final float y = class76.get(array[n]).getY();
        final float x2 = class76.get(array[n2]).getX();
        final float y2 = class76.get(array[n2]).getY();
        final float x3 = class76.get(array[n3]).getX();
        final float y3 = class76.get(array[n3]).getY();
        if (1.0E-10f > (x2 - x) * (y3 - y) - (y2 - y) * (x3 - x)) {
            return false;
        }
        for (int i = 0; i < n4; ++i) {
            if (i != n && i != n2) {
                if (i != n3) {
                    if (this.insideTriangle(x, y, x2, y2, x3, y3, class76.get(array[i]).getX(), class76.get(array[i]).getY())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean process(final Class76 class76, final Class76 class77) {
        class77.clear();
        final int size = class76.size();
        if (size < 3) {
            return false;
        }
        final int[] array = new int[size];
        if (0.0f < this.area(class76)) {
            for (int i = 0; i < size; ++i) {
                array[i] = i;
            }
        }
        else {
            for (int j = 0; j < size; ++j) {
                array[j] = size - 1 - j;
            }
        }
        int k = size;
        int n = 2 * k;
        int n2 = 0;
        int n3 = k - 1;
        while (k > 2) {
            if (0 >= n--) {
                return false;
            }
            int n4 = n3;
            if (k <= n4) {
                n4 = 0;
            }
            n3 = n4 + 1;
            if (k <= n3) {
                n3 = 0;
            }
            int n5 = n3 + 1;
            if (k <= n5) {
                n5 = 0;
            }
            if (!this.snip(class76, n4, n3, n5, k, array)) {
                continue;
            }
            final int n6 = array[n4];
            final int n7 = array[n3];
            final int n8 = array[n5];
            class77.add(class76.get(n6));
            class77.add(class76.get(n7));
            class77.add(class76.get(n8));
            ++n2;
            int n9 = n3;
            for (int l = n3 + 1; l < k; ++l) {
                array[n9] = array[l];
                ++n9;
            }
            --k;
            n = 2 * k;
        }
        return true;
    }
    
    @Override
    public void startHole() {
    }
}
