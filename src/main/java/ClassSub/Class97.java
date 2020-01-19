package ClassSub;

import java.nio.*;

private class Class97
{
    private int srcPixelFormat;
    private int componentCount;
    private int minFilter;
    private int magFilter;
    private ByteBuffer textureBuffer;
    final Class85 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    private Class97(final Class85 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public int reload() {
        Class121.error("Reloading texture: " + Class85.access$600(this.this$0));
        return Class6.get().reload(this.this$0, this.srcPixelFormat, this.componentCount, this.minFilter, this.magFilter, this.textureBuffer);
    }
    
    Class97(final Class85 class85, final Class71 class86) {
        this(class85);
    }
    
    static int access$102(final Class97 class97, final int srcPixelFormat) {
        return class97.srcPixelFormat = srcPixelFormat;
    }
    
    static int access$202(final Class97 class97, final int componentCount) {
        return class97.componentCount = componentCount;
    }
    
    static int access$302(final Class97 class97, final int minFilter) {
        return class97.minFilter = minFilter;
    }
    
    static int access$402(final Class97 class97, final int magFilter) {
        return class97.magFilter = magFilter;
    }
    
    static ByteBuffer access$502(final Class97 class97, final ByteBuffer textureBuffer) {
        return class97.textureBuffer = textureBuffer;
    }
}
