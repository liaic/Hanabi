package ClassSub;

import java.nio.*;
import java.io.*;
import org.lwjgl.*;

public class Class104 implements Class232
{
    private int width;
    private int height;
    private int texHeight;
    private int texWidth;
    private Class255 decoder;
    private int bitDepth;
    private ByteBuffer scratch;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class104() {
        super();
    }
    
    @Override
    public int getDepth() {
        return this.bitDepth;
    }
    
    @Override
    public ByteBuffer getImageBufferData() {
        return this.scratch;
    }
    
    @Override
    public int getTexHeight() {
        return this.texHeight;
    }
    
    @Override
    public int getTexWidth() {
        return this.texWidth;
    }
    
    @Override
    public ByteBuffer loadImage(final InputStream inputStream) throws IOException {
        return this.loadImage(inputStream, false, null);
    }
    
    @Override
    public ByteBuffer loadImage(final InputStream inputStream, final boolean b, final int[] array) throws IOException {
        return this.loadImage(inputStream, b, false, array);
    }
    
    @Override
    public ByteBuffer loadImage(final InputStream inputStream, final boolean b, final boolean b2, final int[] array) throws IOException {
        if (array != null) {
            throw new IOException("Transparent color not support in custom PNG Decoder");
        }
        final Class255 class255 = new Class255(inputStream);
        if (!class255.isRGB()) {
            throw new IOException("Only RGB formatted images are supported by the PNGLoader");
        }
        this.width = class255.getWidth();
        this.height = class255.getHeight();
        this.texWidth = this.get2Fold(this.width);
        this.texHeight = this.get2Fold(this.height);
        final int n = class255.hasAlpha() ? 4 : 3;
        this.bitDepth = (class255.hasAlpha() ? 32 : 24);
        class255.decode(this.scratch = BufferUtils.createByteBuffer(this.texWidth * this.texHeight * n), this.texWidth * n, (n == 4) ? Class255.RGBA : Class255.RGB);
        if (this.height < this.texHeight - 1) {
            final int n2 = (this.texHeight - 1) * (this.texWidth * n);
            final int n3 = (this.height - 1) * (this.texWidth * n);
            for (int i = 0; i < this.texWidth; ++i) {
                for (int j = 0; j < n; ++j) {
                    this.scratch.put(n2 + i + j, this.scratch.get(i + j));
                    this.scratch.put(n3 + this.texWidth * n + i + j, this.scratch.get(n3 + i + j));
                }
            }
        }
        if (this.width < this.texWidth - 1) {
            for (int k = 0; k < this.texHeight; ++k) {
                for (int l = 0; l < n; ++l) {
                    this.scratch.put((k + 1) * (this.texWidth * n) - n + l, this.scratch.get(k * (this.texWidth * n) + l));
                    this.scratch.put(k * (this.texWidth * n) + this.width * n + l, this.scratch.get(k * (this.texWidth * n) + (this.width - 1) * n + l));
                }
            }
        }
        if (!class255.hasAlpha() && b2) {
            final ByteBuffer byteBuffer = BufferUtils.createByteBuffer(this.texWidth * this.texHeight * 4);
            for (int n4 = 0; n4 < this.texWidth; ++n4) {
                for (int n5 = 0; n5 < this.texHeight; ++n5) {
                    final int n6 = n5 * 3 + n4 * this.texHeight * 3;
                    final int n7 = n5 * 4 + n4 * this.texHeight * 4;
                    byteBuffer.put(n7, this.scratch.get(n6));
                    byteBuffer.put(n7 + 1, this.scratch.get(n6 + 1));
                    byteBuffer.put(n7 + 2, this.scratch.get(n6 + 2));
                    if (n4 < this.getHeight() && n5 < this.getWidth()) {
                        byteBuffer.put(n7 + 3, (byte)(-1));
                    }
                    else {
                        byteBuffer.put(n7 + 3, (byte)0);
                    }
                }
            }
            this.bitDepth = 32;
            this.scratch = byteBuffer;
        }
        this.scratch.position(0);
        return this.scratch;
    }
    
    private int toInt(final byte b) {
        if (b < 0) {
            return 256 + b;
        }
        return b;
    }
    
    private int get2Fold(final int n) {
        int i;
        for (i = 2; i < n; i *= 2) {}
        return i;
    }
    
    @Override
    public void configureEdging(final boolean b) {
    }
    
    @Override
    public int getWidth() {
        return this.width;
    }
    
    @Override
    public int getHeight() {
        return this.height;
    }
}
