package ClassSub;

final class Class28 implements Class236.Class2
{
    final Class173 val$fill;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class28(final Class173 val$fill) {
        this.val$fill = val$fill;
    }
    
    @Override
    public float[] preRenderPoint(final Class186 class186, final float n, final float n2) {
        this.val$fill.colorAt(class186, n, n2).bind();
        final Class224 offset = this.val$fill.getOffsetAt(class186, n, n2);
        return new float[] { offset.x + n, offset.y + n2 };
    }
}
