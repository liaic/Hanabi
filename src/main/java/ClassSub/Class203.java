package ClassSub;

private class Class203
{
    public short id;
    public short x;
    public short y;
    public short width;
    public short height;
    public short xoffset;
    public short yoffset;
    public short xadvance;
    public Class140 image;
    public short dlIndex;
    public short[] kerning;
    final Class36 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    private Class203(final Class36 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public void init() {
        this.image = Class36.access$400(this.this$0).getSubImage(this.x, this.y, this.width, this.height);
    }
    
    @Override
    public String toString() {
        return "[CharDef id=" + this.id + " x=" + this.x + " y=" + this.y + "]";
    }
    
    public void draw(final float n, final float n2) {
        this.image.drawEmbedded(n + this.xoffset, n2 + this.yoffset, this.width, this.height);
    }
    
    public int getKerning(final int n) {
        if (this.kerning == null) {
            return 0;
        }
        int i = 0;
        int n2 = this.kerning.length - 1;
        while (i <= n2) {
            final int n3 = i + n2 >>> 1;
            final short n4 = this.kerning[n3];
            final short n5 = (short)(n4 & 0xFF);
            if (n5 < n) {
                i = n3 + 1;
            }
            else {
                if (n5 <= n) {
                    return n4 >> 8;
                }
                n2 = n3 - 1;
            }
        }
        return 0;
    }
    
    Class203(final Class36 class36, final Class130 class37) {
        this(class36);
    }
}
