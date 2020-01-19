package ClassSub;

final class Class304 implements Class163.Class50
{
    final Class193 val$gen;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class304(final Class193 val$gen) {
        this.val$gen = val$gen;
        super();
    }
    
    @Override
    public float[] preRenderPoint(final Class68 class68, final float n, final float n2) {
        final Class271 coord = this.val$gen.getCoordFor(n, n2);
        Class163.access$000().glTexCoord2f(coord.x, coord.y);
        return new float[] { n, n2 };
    }
}
