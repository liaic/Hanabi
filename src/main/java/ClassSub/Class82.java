package ClassSub;

import java.nio.*;
import org.lwjgl.*;

public class Class82 implements Class106
{
    private int width;
    private int height;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class82(final int width, final int height) {
        super();
        this.width = width;
        this.height = height;
    }
    
    @Override
    public int getDepth() {
        return 32;
    }
    
    @Override
    public int getHeight() {
        return this.height;
    }
    
    @Override
    public ByteBuffer getImageBufferData() {
        return BufferUtils.createByteBuffer(this.getTexWidth() * this.getTexHeight() * 4);
    }
    
    @Override
    public int getTexHeight() {
        return Class6.get2Fold(this.height);
    }
    
    @Override
    public int getTexWidth() {
        return Class6.get2Fold(this.width);
    }
    
    @Override
    public int getWidth() {
        return this.width;
    }
}
