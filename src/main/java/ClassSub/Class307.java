package ClassSub;

import java.util.*;

public class Class307 extends Class68
{
    private ArrayList localPoints;
    private float cx;
    private float cy;
    private boolean closed;
    private ArrayList holes;
    private ArrayList hole;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class307(final float cx, final float cy) {
        super();
        this.localPoints = new ArrayList();
        this.holes = new ArrayList();
        this.localPoints.add(new float[] { cx, cy });
        this.cx = cx;
        this.cy = cy;
        this.pointsDirty = true;
    }
    
    public void startHole(final float n, final float n2) {
        this.hole = new ArrayList();
        this.holes.add(this.hole);
    }
    
    public void lineTo(final float cx, final float cy) {
        if (this.hole != null) {
            this.hole.add(new float[] { cx, cy });
        }
        else {
            this.localPoints.add(new float[] { cx, cy });
        }
        this.cx = cx;
        this.cy = cy;
        this.pointsDirty = true;
    }
    
    public void close() {
        this.closed = true;
    }
    
    public void curveTo(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        this.curveTo(n, n2, n3, n4, n5, n6, 10);
    }
    
    public void curveTo(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final int n7) {
        if (this.cx == n && this.cy == n2) {
            return;
        }
        final Class30 class30 = new Class30(new Class271(this.cx, this.cy), new Class271(n3, n4), new Class271(n5, n6), new Class271(n, n2));
        final float n8 = 1.0f / n7;
        for (int i = 1; i < n7 + 1; ++i) {
            final Class271 point = class30.pointAt((float)i * n8);
            if (this.hole != null) {
                this.hole.add(new float[] { point.x, point.y });
            }
            else {
                this.localPoints.add(new float[] { point.x, point.y });
            }
            this.cx = point.x;
            this.cy = point.y;
        }
        this.pointsDirty = true;
    }
    
    @Override
    protected void createPoints() {
        this.points = new float[this.localPoints.size() * 2];
        for (int i = 0; i < this.localPoints.size(); ++i) {
            final float[] array = (float[])this.localPoints.get(i);
            this.points[i * 2] = array[0];
            this.points[i * 2 + 1] = array[1];
        }
    }
    
    @Override
    public Class68 transform(final Class300 class300) {
        final Class307 class301 = new Class307(this.cx, this.cy);
        class301.localPoints = this.transform(this.localPoints, class300);
        for (int i = 0; i < this.holes.size(); ++i) {
            class301.holes.add(this.transform((ArrayList)this.holes.get(i), class300));
        }
        class301.closed = this.closed;
        return class301;
    }
    
    private ArrayList transform(final ArrayList list, final Class300 class300) {
        final float[] array = new float[list.size() * 2];
        final float[] array2 = new float[list.size() * 2];
        for (int i = 0; i < list.size(); ++i) {
            array[i * 2] = ((float[])list.get(i))[0];
            array[i * 2 + 1] = ((float[])list.get(i))[1];
        }
        class300.transform(array, 0, array2, 0, list.size());
        final ArrayList<float[]> list2 = new ArrayList<float[]>();
        for (int j = 0; j < list.size(); ++j) {
            list2.add(new float[] { array2[j * 2], array2[j * 2 + 1] });
        }
        return list2;
    }
    
    @Override
    public boolean closed() {
        return this.closed;
    }
}
