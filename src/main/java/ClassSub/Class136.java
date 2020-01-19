package ClassSub;

import org.lwjgl.input.*;
import org.lwjgl.*;
import java.io.*;
import java.nio.*;

public class Class136
{
    private static Class136 single;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Class136 get() {
        return Class136.single;
    }
    
    private Class136() {
        super();
    }
    
    public Cursor getCursor(final String s, final int n, final int n2) throws IOException, LWJGLException {
        final Class232 imageData = Class164.getImageDataFor(s);
        imageData.configureEdging(false);
        final ByteBuffer loadImage = imageData.loadImage(Class160.getResourceAsStream(s), true, true, null);
        for (int i = 0; i < loadImage.limit(); i += 4) {
            final byte value = loadImage.get(i);
            final byte value2 = loadImage.get(i + 1);
            final byte value3 = loadImage.get(i + 2);
            final byte value4 = loadImage.get(i + 3);
            loadImage.put(i + 2, value);
            loadImage.put(i + 1, value2);
            loadImage.put(i, value3);
            loadImage.put(i + 3, value4);
        }
        try {
            int n3 = imageData.getHeight() - n2 - 1;
            if (n3 < 0) {
                n3 = 0;
            }
            return new Cursor(imageData.getTexWidth(), imageData.getTexHeight(), n, n3, 1, loadImage.asIntBuffer(), (IntBuffer)null);
        }
        catch (Throwable t) {
            Class121.info("Chances are you cursor is too small for this platform");
            throw new LWJGLException(t);
        }
    }
    
    public Cursor getCursor(final ByteBuffer byteBuffer, final int n, final int n2, final int n3, final int n4) throws IOException, LWJGLException {
        for (int i = 0; i < byteBuffer.limit(); i += 4) {
            final byte value = byteBuffer.get(i);
            final byte value2 = byteBuffer.get(i + 1);
            final byte value3 = byteBuffer.get(i + 2);
            final byte value4 = byteBuffer.get(i + 3);
            byteBuffer.put(i + 2, value);
            byteBuffer.put(i + 1, value2);
            byteBuffer.put(i, value3);
            byteBuffer.put(i + 3, value4);
        }
        try {
            int n5 = n4 - n2 - 1;
            if (n5 < 0) {
                n5 = 0;
            }
            return new Cursor(n3, n4, n, n5, 1, byteBuffer.asIntBuffer(), (IntBuffer)null);
        }
        catch (Throwable t) {
            Class121.info("Chances are you cursor is too small for this platform");
            throw new LWJGLException(t);
        }
    }
    
    public Cursor getCursor(final Class106 class106, final int n, final int n2) throws IOException, LWJGLException {
        final ByteBuffer imageBufferData = class106.getImageBufferData();
        for (int i = 0; i < imageBufferData.limit(); i += 4) {
            final byte value = imageBufferData.get(i);
            final byte value2 = imageBufferData.get(i + 1);
            final byte value3 = imageBufferData.get(i + 2);
            final byte value4 = imageBufferData.get(i + 3);
            imageBufferData.put(i + 2, value);
            imageBufferData.put(i + 1, value2);
            imageBufferData.put(i, value3);
            imageBufferData.put(i + 3, value4);
        }
        try {
            int n3 = class106.getHeight() - n2 - 1;
            if (n3 < 0) {
                n3 = 0;
            }
            return new Cursor(class106.getTexWidth(), class106.getTexHeight(), n, n3, 1, imageBufferData.asIntBuffer(), (IntBuffer)null);
        }
        catch (Throwable t) {
            Class121.info("Chances are you cursor is too small for this platform");
            throw new LWJGLException(t);
        }
    }
    
    public Cursor getAnimatedCursor(final String s, final int n, final int n2, final int n3, final int n4, final int[] array) throws IOException, LWJGLException {
        final IntBuffer intBuffer = ByteBuffer.allocateDirect(array.length * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
        for (int i = 0; i < array.length; ++i) {
            intBuffer.put(array[i]);
        }
        intBuffer.flip();
        return new Cursor(n3, n4, n, n2, array.length, new Class7().loadImage(Class160.getResourceAsStream(s), false, null).asIntBuffer(), intBuffer);
    }
    
    static {
        Class136.single = new Class136();
    }
}
