package ClassSub;

public class Class115 extends Class68
{
    protected float width;
    protected float height;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class115(final float x, final float y, final float width, final float height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxX = x + width;
        this.maxY = y + height;
        this.checkPoints();
    }
    
    @Override
    public boolean contains(final float n, final float n2) {
        return n > this.getX() && n2 > this.getY() && n < this.maxX && n2 < this.maxY;
    }
    
    public void setBounds(final Class115 class115) {
        this.setBounds(class115.getX(), class115.getY(), class115.getWidth(), class115.getHeight());
    }
    
    public void setBounds(final float x, final float y, final float n, final float n2) {
        this.setX(x);
        this.setY(y);
        this.setSize(n, n2);
    }
    
    public void setSize(final float width, final float height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    
    @Override
    public float getWidth() {
        return this.width;
    }
    
    @Override
    public float getHeight() {
        return this.height;
    }
    
    public void grow(final float n, final float n2) {
        this.setX(this.getX() - n);
        this.setY(this.getY() - n2);
        this.setWidth(this.getWidth() + n * 2.0f);
        this.setHeight(this.getHeight() + n2 * 2.0f);
    }
    
    public void scaleGrow(final float n, final float n2) {
        this.grow(this.getWidth() * (n - 1.0f), this.getHeight() * (n2 - 1.0f));
    }
    
    public void setWidth(final float width) {
        if (width != this.width) {
            this.pointsDirty = true;
            this.width = width;
            this.maxX = this.x + width;
        }
    }
    
    public void setHeight(final float height) {
        if (height != this.height) {
            this.pointsDirty = true;
            this.height = height;
            this.maxY = this.y + height;
        }
    }
    
    @Override
    public boolean intersects(final Class68 class68) {
        if (class68 instanceof Class115) {
            final Class115 class69 = (Class115)class68;
            return this.x <= class69.x + class69.width && this.x + this.width >= class69.x && this.y <= class69.y + class69.height && this.y + this.height >= class69.y;
        }
        if (class68 instanceof Class292) {
            return this.intersects((Class292)class68);
        }
        return super.intersects(class68);
    }
    
    @Override
    protected void createPoints() {
        final float width = this.width;
        final float height = this.height;
        (this.points = new float[8])[0] = this.x;
        this.points[1] = this.y;
        this.points[2] = this.x + width;
        this.points[3] = this.y;
        this.points[4] = this.x + width;
        this.points[5] = this.y + height;
        this.points[6] = this.x;
        this.points[7] = this.y + height;
        this.maxX = this.points[2];
        this.maxY = this.points[5];
        this.minX = this.points[0];
        this.minY = this.points[1];
        this.findCenter();
        this.calculateRadius();
    }
    
    private boolean intersects(final Class292 class292) {
        return class292.intersects((Class68)this);
    }
    
    @Override
    public String toString() {
        return "[Rectangle " + this.width + "x" + this.height + "]";
    }
    
    public static boolean contains(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        return n >= n3 && n2 >= n4 && n <= n3 + n5 && n2 <= n4 + n6;
    }
    
    @Override
    public Class68 transform(final Class300 class300) {
        this.checkPoints();
        final Class249 class301 = new Class249();
        final float[] points = new float[this.points.length];
        class300.transform(this.points, 0, points, 0, this.points.length / 2);
        class301.points = points;
        class301.findCenter();
        class301.checkPoints();
        return class301;
    }
}
