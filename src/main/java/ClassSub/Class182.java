package ClassSub;

import java.awt.*;
import java.awt.font.*;

public class Class182
{
    private int codePoint;
    private short width;
    private short height;
    private short yOffset;
    private boolean isMissing;
    private Shape shape;
    private Class140 image;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class182(final int codePoint, final Rectangle rectangle, final GlyphVector glyphVector, final int n, final Class135 class135) {
        super();
        this.codePoint = codePoint;
        final GlyphMetrics glyphMetrics = glyphVector.getGlyphMetrics(n);
        int n2 = (int)glyphMetrics.getLSB();
        if (n2 > 0) {
            n2 = 0;
        }
        int n3 = (int)glyphMetrics.getRSB();
        if (n3 > 0) {
            n3 = 0;
        }
        final int n4 = rectangle.width - n2 - n3;
        final int height = rectangle.height;
        if (n4 > 0 && height > 0) {
            final int paddingTop = class135.getPaddingTop();
            final int paddingRight = class135.getPaddingRight();
            final int paddingBottom = class135.getPaddingBottom();
            final int paddingLeft = class135.getPaddingLeft();
            final int n5 = 1;
            this.width = (short)(n4 + paddingLeft + paddingRight + n5);
            this.height = (short)(height + paddingTop + paddingBottom + n5);
            this.yOffset = (short)(class135.getAscent() + rectangle.y - paddingTop);
        }
        this.shape = glyphVector.getGlyphOutline(n, -rectangle.x + class135.getPaddingLeft(), -rectangle.y + class135.getPaddingTop());
        this.isMissing = !class135.getFont().canDisplay((char)codePoint);
    }
    
    public int getCodePoint() {
        return this.codePoint;
    }
    
    public boolean isMissing() {
        return this.isMissing;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public Shape getShape() {
        return this.shape;
    }
    
    public void setShape(final Shape shape) {
        this.shape = shape;
    }
    
    public Class140 getImage() {
        return this.image;
    }
    
    public void setImage(final Class140 image) {
        this.image = image;
    }
    
    public int getYOffset() {
        return this.yOffset;
    }
}
