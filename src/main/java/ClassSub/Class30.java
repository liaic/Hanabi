package ClassSub;

public class Class30 extends Class68
{
    private Class271 p1;
    private Class271 c1;
    private Class271 c2;
    private Class271 p2;
    private int segments;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class30(final Class271 class271, final Class271 class272, final Class271 class273, final Class271 class274) {
        this(class271, class272, class273, class274, 20);
    }
    
    public Class30(final Class271 class271, final Class271 class272, final Class271 class273, final Class271 class274, final int segments) {
        super();
        this.p1 = new Class271(class271);
        this.c1 = new Class271(class272);
        this.c2 = new Class271(class273);
        this.p2 = new Class271(class274);
        this.segments = segments;
        this.pointsDirty = true;
    }
    
    public Class271 pointAt(final float n) {
        final float n2 = 1.0f - n;
        final float n3 = n2 * n2 * n2;
        final float n4 = 3.0f * n2 * n2 * n;
        final float n5 = 3.0f * n2 * n * n;
        final float n6 = n * n * n;
        return new Class271(this.p1.x * n3 + this.c1.x * n4 + this.c2.x * n5 + this.p2.x * n6, this.p1.y * n3 + this.c1.y * n4 + this.c2.y * n5 + this.p2.y * n6);
    }
    
    @Override
    protected void createPoints() {
        final float n = 1.0f / this.segments;
        this.points = new float[(this.segments + 1) * 2];
        for (int i = 0; i < this.segments + 1; ++i) {
            final Class271 point = this.pointAt((float)i * n);
            this.points[i * 2] = point.x;
            this.points[i * 2 + 1] = point.y;
        }
    }
    
    @Override
    public Class68 transform(final Class300 class300) {
        final float[] array = new float[8];
        final float[] array2 = new float[8];
        array[0] = this.p1.x;
        array[1] = this.p1.y;
        array[2] = this.c1.x;
        array[3] = this.c1.y;
        array[4] = this.c2.x;
        array[5] = this.c2.y;
        array[6] = this.p2.x;
        array[7] = this.p2.y;
        class300.transform(array, 0, array2, 0, 4);
        return new Class30(new Class271(array2[0], array2[1]), new Class271(array2[2], array2[3]), new Class271(array2[4], array2[5]), new Class271(array2[6], array2[7]));
    }
    
    @Override
    public boolean closed() {
        return false;
    }
}
