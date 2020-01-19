package ClassSub;

final class Class1 implements Class163.Class50
{
    final Class90 val$fill;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class1(final Class90 val$fill) {
        this.val$fill = val$fill;
        super();
    }
    
    @Override
    public float[] preRenderPoint(final Class68 class68, final float n, final float n2) {
        this.val$fill.colorAt(class68, n, n2).bind();
        final Class271 offset = this.val$fill.getOffsetAt(class68, n, n2);
        return new float[] { offset.x + n, offset.y + n2 };
    }
}
