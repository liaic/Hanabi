package ClassSub;

public class Class269 extends Class68
{
    private Class271 start;
    private Class271 end;
    private Class271 vec;
    private float lenSquared;
    private Class271 loc;
    private Class271 v;
    private Class271 v2;
    private Class271 proj;
    private Class271 closest;
    private Class271 other;
    private boolean outerEdge;
    private boolean innerEdge;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class269(final float n, final float n2, final boolean b, final boolean b2) {
        this(0.0f, 0.0f, n, n2);
    }
    
    public Class269(final float n, final float n2) {
        this(n, n2, true, true);
    }
    
    public Class269(final float n, final float n2, final float n3, final float n4) {
        this(new Class271(n, n2), new Class271(n3, n4));
    }
    
    public Class269(final float n, final float n2, final float n3, final float n4, final boolean b) {
        this(new Class271(n, n2), new Class271(n + n3, n2 + n4));
    }
    
    public Class269(final float[] array, final float[] array2) {
        super();
        this.loc = new Class271(0.0f, 0.0f);
        this.v = new Class271(0.0f, 0.0f);
        this.v2 = new Class271(0.0f, 0.0f);
        this.proj = new Class271(0.0f, 0.0f);
        this.closest = new Class271(0.0f, 0.0f);
        this.other = new Class271(0.0f, 0.0f);
        this.outerEdge = true;
        this.innerEdge = true;
        this.set(array, array2);
    }
    
    public Class269(final Class271 class271, final Class271 class272) {
        super();
        this.loc = new Class271(0.0f, 0.0f);
        this.v = new Class271(0.0f, 0.0f);
        this.v2 = new Class271(0.0f, 0.0f);
        this.proj = new Class271(0.0f, 0.0f);
        this.closest = new Class271(0.0f, 0.0f);
        this.other = new Class271(0.0f, 0.0f);
        this.outerEdge = true;
        this.innerEdge = true;
        this.set(class271, class272);
    }
    
    public void set(final float[] array, final float[] array2) {
        this.set(array[0], array[1], array2[0], array2[1]);
    }
    
    public Class271 getStart() {
        return this.start;
    }
    
    public Class271 getEnd() {
        return this.end;
    }
    
    public float length() {
        return this.vec.length();
    }
    
    public float lengthSquared() {
        return this.vec.lengthSquared();
    }
    
    public void set(final Class271 class271, final Class271 class272) {
        super.pointsDirty = true;
        if (this.start == null) {
            this.start = new Class271();
        }
        this.start.set(class271);
        if (this.end == null) {
            this.end = new Class271();
        }
        this.end.set(class272);
        (this.vec = new Class271(class272)).sub(class271);
        this.lenSquared = this.vec.lengthSquared();
    }
    
    public void set(final float n, final float n2, final float n3, final float n4) {
        super.pointsDirty = true;
        this.start.set(n, n2);
        this.end.set(n3, n4);
        final float n5 = n3 - n;
        final float n6 = n4 - n2;
        this.vec.set(n5, n6);
        this.lenSquared = n5 * n5 + n6 * n6;
    }
    
    public float getDX() {
        return this.end.getX() - this.start.getX();
    }
    
    public float getDY() {
        return this.end.getY() - this.start.getY();
    }
    
    @Override
    public float getX() {
        return this.getX1();
    }
    
    @Override
    public float getY() {
        return this.getY1();
    }
    
    public float getX1() {
        return this.start.getX();
    }
    
    public float getY1() {
        return this.start.getY();
    }
    
    public float getX2() {
        return this.end.getX();
    }
    
    public float getY2() {
        return this.end.getY();
    }
    
    public float distance(final Class271 class271) {
        return (float)Math.sqrt(this.distanceSquared(class271));
    }
    
    public boolean on(final Class271 class271) {
        this.getClosestPoint(class271, this.closest);
        return class271.equals(this.closest);
    }
    
    public float distanceSquared(final Class271 class271) {
        this.getClosestPoint(class271, this.closest);
        this.closest.sub(class271);
        return this.closest.lengthSquared();
    }
    
    public void getClosestPoint(final Class271 class271, final Class271 class272) {
        this.loc.set(class271);
        this.loc.sub(this.start);
        final float n = this.vec.dot(this.loc) / this.vec.lengthSquared();
        if (n < 0.0f) {
            class272.set(this.start);
            return;
        }
        if (n > 1.0f) {
            class272.set(this.end);
            return;
        }
        class272.x = this.start.getX() + n * this.vec.getX();
        class272.y = this.start.getY() + n * this.vec.getY();
    }
    
    @Override
    public String toString() {
        return "[Line " + this.start + "," + this.end + "]";
    }
    
    public Class271 intersect(final Class269 class269) {
        return this.intersect(class269, false);
    }
    
    public Class271 intersect(final Class269 class269, final boolean b) {
        final Class271 class270 = new Class271();
        if (!this.intersect(class269, b, class270)) {
            return null;
        }
        return class270;
    }
    
    public boolean intersect(final Class269 class269, final boolean b, final Class271 class270) {
        final float n = this.end.getX() - this.start.getX();
        final float n2 = class269.end.getX() - class269.start.getX();
        final float n3 = this.end.getY() - this.start.getY();
        final float n4 = class269.end.getY() - class269.start.getY();
        final float n5 = n4 * n - n2 * n3;
        if (n5 == 0.0f) {
            return false;
        }
        final float n6 = (n2 * (this.start.getY() - class269.start.getY()) - n4 * (this.start.getX() - class269.start.getX())) / n5;
        final float n7 = (n * (this.start.getY() - class269.start.getY()) - n3 * (this.start.getX() - class269.start.getX())) / n5;
        if (b && (n6 < 0.0f || n6 > 1.0f || n7 < 0.0f || n7 > 1.0f)) {
            return false;
        }
        final float n8 = n6;
        class270.set(this.start.getX() + n8 * (this.end.getX() - this.start.getX()), this.start.getY() + n8 * (this.end.getY() - this.start.getY()));
        return true;
    }
    
    @Override
    protected void createPoints() {
        (this.points = new float[4])[0] = this.getX1();
        this.points[1] = this.getY1();
        this.points[2] = this.getX2();
        this.points[3] = this.getY2();
    }
    
    @Override
    public Class68 transform(final Class300 class300) {
        final float[] array = new float[4];
        this.createPoints();
        class300.transform(this.points, 0, array, 0, 2);
        return new Class269(array[0], array[1], array[2], array[3]);
    }
    
    @Override
    public boolean closed() {
        return false;
    }
    
    @Override
    public boolean intersects(final Class68 class68) {
        if (class68 instanceof Class292) {
            return class68.intersects(this);
        }
        return super.intersects(class68);
    }
}
