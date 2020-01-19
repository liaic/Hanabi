package ClassSub;

private class Class279
{
    private float x;
    private float y;
    private float[] array;
    final Class158 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class279(final Class158 this$0, final float x, final float y) {
        this.this$0 = this$0;
        super();
        this.x = x;
        this.y = y;
        this.array = new float[] { x, y };
    }
    
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }
    
    public float[] toArray() {
        return this.array;
    }
    
    @Override
    public int hashCode() {
        return (int)(this.x * this.y * 31.0f);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof Class279) {
            final Class279 class279 = (Class279)o;
            return class279.x == this.x && class279.y == this.y;
        }
        return false;
    }
    
    static float access$000(final Class279 class279) {
        return class279.x;
    }
    
    static float access$100(final Class279 class279) {
        return class279.y;
    }
}
