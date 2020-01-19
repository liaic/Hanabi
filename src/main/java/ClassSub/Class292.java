package ClassSub;

public strictfp class Class292 extends Class70
{
    public float radius;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class292(final float n, final float n2, final float n3) {
        this(n, n2, n3, 50);
    }
    
    public Class292(final float n, final float n2, final float n3, final int n4) {
        super(n, n2, n3, n3, n4);
        this.x = n - n3;
        this.y = n2 - n3;
        this.radius = n3;
        this.boundingCircleRadius = n3;
    }
    
    @Override
    public strictfp float getCenterX() {
        return this.getX() + this.radius;
    }
    
    @Override
    public strictfp float getCenterY() {
        return this.getY() + this.radius;
    }
    
    public strictfp void setRadius(final float radius) {
        if (radius != this.radius) {
            this.pointsDirty = true;
            this.setRadii(this.radius = radius, radius);
        }
    }
    
    public strictfp float getRadius() {
        return this.radius;
    }
    
    @Override
    public strictfp boolean intersects(final Class68 class68) {
        if (class68 instanceof Class292) {
            final Class292 class69 = (Class292)class68;
            final float n = this.getRadius() + class69.getRadius();
            if (Math.abs(class69.getCenterX() - this.getCenterX()) > n) {
                return false;
            }
            if (Math.abs(class69.getCenterY() - this.getCenterY()) > n) {
                return false;
            }
            final float n2 = n * n;
            final float abs = Math.abs(class69.getCenterX() - this.getCenterX());
            final float abs2 = Math.abs(class69.getCenterY() - this.getCenterY());
            return n2 >= abs * abs + abs2 * abs2;
        }
        else {
            if (class68 instanceof Class115) {
                return this.intersects((Class115)class68);
            }
            return super.intersects(class68);
        }
    }
    
    @Override
    public strictfp boolean contains(final float n, final float n2) {
        return (n - this.getX()) * (n - this.getX()) + (n2 - this.getY()) * (n2 - this.getY()) < this.getRadius() * this.getRadius();
    }
    
    private strictfp boolean contains(final Class269 class269) {
        return this.contains(class269.getX1(), class269.getY1()) && this.contains(class269.getX2(), class269.getY2());
    }
    
    @Override
    protected strictfp void findCenter() {
        (this.center = new float[2])[0] = this.x + this.radius;
        this.center[1] = this.y + this.radius;
    }
    
    @Override
    protected strictfp void calculateRadius() {
        this.boundingCircleRadius = this.radius;
    }
    
    private strictfp boolean intersects(final Class115 class115) {
        if (class115.contains(this.x + this.radius, this.y + this.radius)) {
            return true;
        }
        final float x = class115.getX();
        final float y = class115.getY();
        final float n = class115.getX() + class115.getWidth();
        final float n2 = class115.getY() + class115.getHeight();
        final Class269[] array = { new Class269(x, y, n, y), new Class269(n, y, n, n2), new Class269(n, n2, x, n2), new Class269(x, n2, x, y) };
        final float n3 = this.getRadius() * this.getRadius();
        final Class271 class116 = new Class271(this.getCenterX(), this.getCenterY());
        for (int i = 0; i < 4; ++i) {
            if (array[i].distanceSquared(class116) < n3) {
                return true;
            }
        }
        return false;
    }
    
    private strictfp boolean intersects(final Class269 class269) {
        final Class271 class270 = new Class271(class269.getX1(), class269.getY1());
        final Class271 class271 = new Class271(class269.getX2(), class269.getY2());
        final Class271 class272 = new Class271(this.getCenterX(), this.getCenterY());
        final Class271 sub = class271.copy().sub(class270);
        final Class271 sub2 = class272.copy().sub(class270);
        final float length = sub.length();
        final float n = sub2.dot(sub) / length;
        Class271 add;
        if (n < 0.0f) {
            add = class270;
        }
        else if (n > length) {
            add = class271;
        }
        else {
            add = class270.copy().add(sub.copy().scale(n / length));
        }
        return class272.copy().sub(add).lengthSquared() <= this.getRadius() * this.getRadius();
    }
}
