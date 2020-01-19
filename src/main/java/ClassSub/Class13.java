package ClassSub;

import java.net.*;
import java.io.*;

public class Class13 extends Class140
{
    private int tw;
    private int th;
    private int margin;
    private Class140[][] subImages;
    private int spacing;
    private Class140 target;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class13(final URL url, final int n, final int n2) throws Class186, IOException {
        this(new Class140(url.openStream(), url.toString(), false), n, n2);
    }
    
    public Class13(final Class140 target, final int tw, final int th) {
        super(target);
        this.margin = 0;
        this.target = target;
        this.tw = tw;
        this.th = th;
        this.initImpl();
    }
    
    public Class13(final Class140 target, final int tw, final int th, final int spacing, final int margin) {
        super(target);
        this.margin = 0;
        this.target = target;
        this.tw = tw;
        this.th = th;
        this.spacing = spacing;
        this.margin = margin;
        this.initImpl();
    }
    
    public Class13(final Class140 class140, final int n, final int n2, final int n3) {
        this(class140, n, n2, n3, 0);
    }
    
    public Class13(final String s, final int n, final int n2, final int n3) throws Class186 {
        this(s, n, n2, null, n3);
    }
    
    public Class13(final String s, final int n, final int n2) throws Class186 {
        this(s, n, n2, null);
    }
    
    public Class13(final String s, final int n, final int n2, final Class278 class278) throws Class186 {
        this(s, n, n2, class278, 0);
    }
    
    public Class13(final String s, final int tw, final int th, final Class278 class278, final int spacing) throws Class186 {
        super(s, false, 2, class278);
        this.margin = 0;
        this.target = this;
        this.tw = tw;
        this.th = th;
        this.spacing = spacing;
    }
    
    public Class13(final String s, final InputStream inputStream, final int tw, final int th) throws Class186 {
        super(inputStream, s, false);
        this.margin = 0;
        this.target = this;
        this.tw = tw;
        this.th = th;
    }
    
    @Override
    protected void initImpl() {
        if (this.subImages != null) {
            return;
        }
        final int n = (this.getWidth() - this.margin * 2 - this.tw) / (this.tw + this.spacing) + 1;
        int n2 = (this.getHeight() - this.margin * 2 - this.th) / (this.th + this.spacing) + 1;
        if ((this.getHeight() - this.th) % (this.th + this.spacing) != 0) {
            ++n2;
        }
        this.subImages = new Class140[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                this.subImages[i][j] = this.getSprite(i, j);
            }
        }
    }
    
    public Class140 getSubImage(final int n, final int n2) {
        this.init();
        if (n < 0 || n >= this.subImages.length) {
            throw new RuntimeException("SubImage out of sheet bounds: " + n + "," + n2);
        }
        if (n2 < 0 || n2 >= this.subImages[0].length) {
            throw new RuntimeException("SubImage out of sheet bounds: " + n + "," + n2);
        }
        return this.subImages[n][n2];
    }
    
    public Class140 getSprite(final int n, final int n2) {
        this.target.init();
        this.initImpl();
        if (n < 0 || n >= this.subImages.length) {
            throw new RuntimeException("SubImage out of sheet bounds: " + n + "," + n2);
        }
        if (n2 < 0 || n2 >= this.subImages[0].length) {
            throw new RuntimeException("SubImage out of sheet bounds: " + n + "," + n2);
        }
        return this.target.getSubImage(n * (this.tw + this.spacing) + this.margin, n2 * (this.th + this.spacing) + this.margin, this.tw, this.th);
    }
    
    public int getHorizontalCount() {
        this.target.init();
        this.initImpl();
        return this.subImages.length;
    }
    
    public int getVerticalCount() {
        this.target.init();
        this.initImpl();
        return this.subImages[0].length;
    }
    
    public void renderInUse(final int n, final int n2, final int n3, final int n4) {
        this.subImages[n3][n4].drawEmbedded(n, n2, this.tw, this.th);
    }
    
    @Override
    public void endUse() {
        if (this.target == this) {
            super.endUse();
            return;
        }
        this.target.endUse();
    }
    
    @Override
    public void startUse() {
        if (this.target == this) {
            super.startUse();
            return;
        }
        this.target.startUse();
    }
    
    @Override
    public void setTexture(final Class27 class27) {
        if (this.target == this) {
            super.setTexture(class27);
            return;
        }
        this.target.setTexture(class27);
    }
}
