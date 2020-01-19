package ClassSub;

import java.io.*;

private static class Class25 implements Serializable
{
    protected Class271 pt;
    protected Class25 prev;
    protected Class25 next;
    protected double nx;
    protected double ny;
    protected double angle;
    protected double dist;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class25(final Class271 pt) {
        super();
        this.pt = pt;
    }
    
    public void unlink() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.next = null;
        this.prev = null;
    }
    
    public void insertBefore(final Class25 class25) {
        this.prev.next = class25;
        class25.prev = this.prev;
        class25.next = this;
        this.prev = class25;
    }
    
    public void insertAfter(final Class25 class25) {
        this.next.prev = class25;
        class25.prev = this;
        class25.next = this.next;
        this.next = class25;
    }
    
    private double hypot(final double n, final double n2) {
        return Math.sqrt(n * n + n2 * n2);
    }
    
    public void computeAngle() {
        if (this.prev.pt.equals(this.pt)) {
            final Class271 pt = this.pt;
            pt.x += 0.01f;
        }
        final double n = (double)(this.pt.x - this.prev.pt.x);
        final double n2 = (double)(this.pt.y - this.prev.pt.y);
        final double hypot = this.hypot(n, n2);
        final double nx = n / hypot;
        final double n3 = n2 / hypot;
        if (this.next.pt.equals(this.pt)) {
            final Class271 pt2 = this.pt;
            pt2.y += 0.01f;
        }
        final double n4 = (double)(this.next.pt.x - this.pt.x);
        final double n5 = (double)(this.next.pt.y - this.pt.y);
        final double hypot2 = this.hypot(n4, n5);
        final double n6 = n4 / hypot2;
        final double ny = n5 / hypot2;
        final double n7 = -n3;
        final double n8 = nx;
        this.nx = (n7 - ny) * 0.5;
        this.ny = (n8 + n6) * 0.5;
        if (this.nx * this.nx + this.ny * this.ny < 1.0E-5) {
            this.nx = nx;
            this.ny = ny;
            this.angle = 1.0;
            if (nx * n6 + n3 * ny > 0.0) {
                this.nx = -nx;
                this.ny = -n3;
            }
        }
        else {
            this.angle = this.nx * n6 + this.ny * ny;
        }
    }
    
    public double getAngle(final Class25 class25) {
        final double n = (double)(class25.pt.x - this.pt.x);
        final double n2 = (double)(class25.pt.y - this.pt.y);
        return (this.nx * n + this.ny * n2) / this.hypot(n, n2);
    }
    
    public boolean isConcave() {
        return this.angle < 0.0;
    }
    
    public boolean isInfront(final double n, final double n2) {
        final boolean b = (this.prev.pt.y - this.pt.y) * n + (this.pt.x - this.prev.pt.x) * n2 >= 0.0;
        final boolean b2 = (this.pt.y - this.next.pt.y) * n + (this.next.pt.x - this.pt.x) * n2 >= 0.0;
        return (this.angle < 0.0) ? (b | b2) : (b & b2);
    }
    
    public boolean isInfront(final Class25 class25) {
        return this.isInfront(class25.pt.x - this.pt.x, class25.pt.y - this.pt.y);
    }
}
