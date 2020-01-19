package ClassSub;

private class Class234
{
    public Class140 image;
    public int duration;
    public int x;
    public int y;
    final Class173 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class234(final Class173 this$0, final Class140 image, final int duration) {
        this.this$0 = this$0;
        super();
        this.x = -1;
        this.y = -1;
        this.image = image;
        this.duration = duration;
    }
    
    public Class234(final Class173 this$0, final int duration, final int x, final int y) {
        this.this$0 = this$0;
        super();
        this.x = -1;
        this.y = -1;
        this.image = Class173.access$000(this$0).getSubImage(x, y);
        this.duration = duration;
        this.x = x;
        this.y = y;
    }
}
