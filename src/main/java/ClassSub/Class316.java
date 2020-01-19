package ClassSub;

final class Class316 implements Class163.Class50
{
    final float val$scaleX;
    final float val$scaleY;
    final Class140 val$image;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class316(final float val$scaleX, final float val$scaleY, final Class140 val$image) {
        this.val$scaleX = val$scaleX;
        this.val$scaleY = val$scaleY;
        this.val$image = val$image;
        super();
    }
    
    @Override
    public float[] preRenderPoint(final Class68 class68, float n, float n2) {
        n -= class68.getMinX();
        n2 -= class68.getMinY();
        n /= class68.getMaxX() - class68.getMinX();
        n2 /= class68.getMaxY() - class68.getMinY();
        Class163.access$000().glTexCoord2f(this.val$image.getTextureOffsetX() + this.val$image.getTextureWidth() * (n * this.val$scaleX), this.val$image.getTextureOffsetY() + this.val$image.getTextureHeight() * (n2 * this.val$scaleY));
        return null;
    }
}
