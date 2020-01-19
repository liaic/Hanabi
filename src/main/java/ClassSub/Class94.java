package ClassSub;

final class Class94 implements Class163.Class50
{
    final Class90 val$fill;
    final float[] val$center;
    final float val$scaleX;
    final float val$scaleY;
    final Class140 val$image;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class94(final Class90 val$fill, final float[] val$center, final float val$scaleX, final float val$scaleY, final Class140 val$image) {
        this.val$fill = val$fill;
        this.val$center = val$center;
        this.val$scaleX = val$scaleX;
        this.val$scaleY = val$scaleY;
        this.val$image = val$image;
        super();
    }
    
    @Override
    public float[] preRenderPoint(final Class68 class68, float n, float n2) {
        this.val$fill.colorAt(class68, n - this.val$center[0], n2 - this.val$center[1]).bind();
        final Class271 offset = this.val$fill.getOffsetAt(class68, n, n2);
        n += offset.x;
        n2 += offset.y;
        Class163.access$000().glTexCoord2f(this.val$image.getTextureOffsetX() + this.val$image.getTextureWidth() * (n * this.val$scaleX), this.val$image.getTextureOffsetY() + this.val$image.getTextureHeight() * (n2 * this.val$scaleY));
        return new float[] { offset.x + n, offset.y + n2 };
    }
}
