package ClassSub;

import java.util.*;
import java.lang.reflect.*;
import java.io.*;

public class Class190 implements Class42
{
    private static final double EPSILON = 1.0E-5;
    protected Class308 contour;
    protected Class308 holes;
    private Class308 nextFreePointBag;
    private Class25 nextFreePoint;
    private List triangles;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class190() {
        super();
        this.triangles = new ArrayList();
        this.contour = this.getPointBag();
    }
    
    @Override
    public void addPolyPoint(final float n, final float n2) {
        this.addPoint(new Class271(n, n2));
    }
    
    public void reset() {
        while (this.holes != null) {
            this.holes = this.freePointBag(this.holes);
        }
        this.contour.clear();
        this.holes = null;
    }
    
    @Override
    public void startHole() {
        final Class308 pointBag = this.getPointBag();
        pointBag.next = this.holes;
        this.holes = pointBag;
    }
    
    private void addPoint(final Class271 class271) {
        if (this.holes == null) {
            this.contour.add(this.getPoint(class271));
        }
        else {
            this.holes.add(this.getPoint(class271));
        }
    }
    
    private Class271[] triangulate(Class271[] array) {
        this.contour.computeAngles();
        for (Class308 class308 = this.holes; class308 != null; class308 = class308.next) {
            class308.computeAngles();
        }
        while (this.holes != null) {
            Class25 next = this.holes.first;
        Label_0273:
            do {
                if (next.angle <= 0.0) {
                    Class25 prev = this.contour.first;
                    do {
                        if (next.isInfront(prev) && prev.isInfront(next) && !this.contour.doesIntersectSegment(next.pt, prev.pt)) {
                            Class308 class309 = this.holes;
                            while (!class309.doesIntersectSegment(next.pt, prev.pt)) {
                                if ((class309 = class309.next) == null) {
                                    final Class25 point = this.getPoint(prev.pt);
                                    prev.insertAfter(point);
                                    final Class25 point2 = this.getPoint(next.pt);
                                    next.insertBefore(point2);
                                    prev.next = next;
                                    next.prev = prev;
                                    point2.next = point;
                                    point.prev = point2;
                                    prev.computeAngle();
                                    next.computeAngle();
                                    point.computeAngle();
                                    point2.computeAngle();
                                    this.holes.first = null;
                                    break Label_0273;
                                }
                            }
                        }
                    } while ((prev = prev.next) != this.contour.first);
                }
            } while ((next = next.next) != this.holes.first);
            this.holes = this.freePointBag(this.holes);
        }
        final int n = (this.contour.countPoints() - 2) * 3 + 1;
        if (array.length < n) {
            array = (Class271[])Array.newInstance(array.getClass().getComponentType(), n);
        }
        int n2 = 0;
        while (true) {
            Class25 class310 = this.contour.first;
            if (class310 == null) {
                break;
            }
            if (class310.next == class310.prev) {
                break;
            }
            do {
                if (class310.angle > 0.0) {
                    final Class25 prev2 = class310.prev;
                    final Class25 next2 = class310.next;
                    if ((next2.next == prev2 || (prev2.isInfront(next2) && next2.isInfront(prev2))) && !this.contour.doesIntersectSegment(prev2.pt, next2.pt)) {
                        array[n2++] = class310.pt;
                        array[n2++] = next2.pt;
                        array[n2++] = prev2.pt;
                        break;
                    }
                    continue;
                }
            } while ((class310 = class310.next) != this.contour.first);
            final Class25 prev3 = class310.prev;
            final Class25 next3 = class310.next;
            this.contour.first = prev3;
            class310.unlink();
            this.freePoint(class310);
            next3.computeAngle();
            prev3.computeAngle();
        }
        array[n2] = null;
        this.contour.clear();
        return array;
    }
    
    private Class308 getPointBag() {
        final Class308 nextFreePointBag = this.nextFreePointBag;
        if (nextFreePointBag != null) {
            this.nextFreePointBag = nextFreePointBag.next;
            nextFreePointBag.next = null;
            return nextFreePointBag;
        }
        return new Class308();
    }
    
    private Class308 freePointBag(final Class308 nextFreePointBag) {
        final Class308 next = nextFreePointBag.next;
        nextFreePointBag.clear();
        nextFreePointBag.next = this.nextFreePointBag;
        this.nextFreePointBag = nextFreePointBag;
        return next;
    }
    
    private Class25 getPoint(final Class271 pt) {
        final Class25 nextFreePoint = this.nextFreePoint;
        if (nextFreePoint != null) {
            this.nextFreePoint = nextFreePoint.next;
            nextFreePoint.next = null;
            nextFreePoint.prev = null;
            nextFreePoint.pt = pt;
            return nextFreePoint;
        }
        return new Class25(pt);
    }
    
    private void freePoint(final Class25 nextFreePoint) {
        nextFreePoint.next = this.nextFreePoint;
        this.nextFreePoint = nextFreePoint;
    }
    
    private void freePoints(final Class25 nextFreePoint) {
        nextFreePoint.prev.next = this.nextFreePoint;
        nextFreePoint.prev = null;
        this.nextFreePoint = nextFreePoint;
    }
    
    @Override
    public boolean triangulate() {
        final Class271[] array = (Class271[])this.triangulate(new Class271[0]);
        for (int n = 0; n < array.length && array[n] != null; ++n) {
            this.triangles.add(array[n]);
        }
        return true;
    }
    
    @Override
    public int getTriangleCount() {
        return this.triangles.size() / 3;
    }
    
    @Override
    public float[] getTrianglePoint(final int n, final int n2) {
        final Class271 class271 = (Class271)this.triangles.get(n * 3 + n2);
        return new float[] { class271.x, class271.y };
    }
    
    static void access$000(final Class190 class190, final Class25 class191) {
        class190.freePoints(class191);
    }
}
