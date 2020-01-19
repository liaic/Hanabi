package ClassSub;

import java.lang.ref.*;
import java.io.*;
import org.lwjgl.*;
import java.nio.*;
import java.util.*;

public class Class6
{
    protected static Class12 GL;
    private static final Class6 loader;
    private HashMap texturesLinear;
    private HashMap texturesNearest;
    private int dstPixelFormat;
    private boolean deferred;
    private boolean holdTextureData;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Class6 get() {
        return Class6.loader;
    }
    
    private Class6() {
        super();
        this.texturesLinear = new HashMap();
        this.texturesNearest = new HashMap();
        this.dstPixelFormat = 6408;
    }
    
    public void setHoldTextureData(final boolean holdTextureData) {
        this.holdTextureData = holdTextureData;
    }
    
    public void setDeferredLoading(final boolean deferred) {
        this.deferred = deferred;
    }
    
    public boolean isDeferredLoading() {
        return this.deferred;
    }
    
    public void clear(final String s) {
        this.texturesLinear.remove(s);
        this.texturesNearest.remove(s);
    }
    
    public void clear() {
        this.texturesLinear.clear();
        this.texturesNearest.clear();
    }
    
    public void set16BitMode() {
        this.dstPixelFormat = 32859;
    }
    
    public static int createTextureID() {
        final IntBuffer intBuffer = createIntBuffer(1);
        Class6.GL.glGenTextures(intBuffer);
        return intBuffer.get(0);
    }
    
    public Class27 getTexture(final File file, final boolean b, final int n) throws IOException {
        return this.getTexture(new FileInputStream(file), file.getAbsolutePath(), b, n, null);
    }
    
    public Class27 getTexture(final File file, final boolean b, final int n, final int[] array) throws IOException {
        return this.getTexture(new FileInputStream(file), file.getAbsolutePath(), b, n, array);
    }
    
    public Class27 getTexture(final String s, final boolean b, final int n) throws IOException {
        return this.getTexture(Class160.getResourceAsStream(s), s, b, n, null);
    }
    
    public Class27 getTexture(final String s, final boolean b, final int n, final int[] array) throws IOException {
        return this.getTexture(Class160.getResourceAsStream(s), s, b, n, array);
    }
    
    public Class27 getTexture(final InputStream inputStream, final String s, final boolean b, final int n) throws IOException {
        return this.getTexture(inputStream, s, b, n, null);
    }
    
    public Class85 getTexture(final InputStream inputStream, final String s, final boolean b, final int n, final int[] array) throws IOException {
        if (this.deferred) {
            return new Class305(inputStream, s, b, n, array);
        }
        HashMap hashMap = this.texturesLinear;
        if (n == 9728) {
            hashMap = this.texturesNearest;
        }
        String string = s;
        if (array != null) {
            string = string + ":" + array[0] + ":" + array[1] + ":" + array[2];
        }
        final String string2 = string + ":" + b;
        if (this.holdTextureData) {
            final Class85 class85 = (Class85)hashMap.get(string2);
            if (class85 != null) {
                return class85;
            }
        }
        else {
            final SoftReference softReference = (SoftReference)hashMap.get(string2);
            if (softReference != null) {
                final Class85 class86 = (Class85)softReference.get();
                if (class86 != null) {
                    return class86;
                }
                hashMap.remove(string2);
            }
        }
        try {
            Class6.GL.glGetError();
        }
        catch (NullPointerException ex) {
            throw new RuntimeException("Image based resources must be loaded as part of init() or the game loop. They cannot be loaded before initialisation.");
        }
        final Class85 texture = this.getTexture(inputStream, s, 3553, n, n, b, array);
        texture.setCacheName(string2);
        if (this.holdTextureData) {
            hashMap.put(string2, texture);
        }
        else {
            hashMap.put(string2, new SoftReference(texture));
        }
        return texture;
    }
    
    private Class85 getTexture(final InputStream inputStream, final String s, final int n, final int n2, final int n3, final boolean b, final int[] array) throws IOException {
        final Class232 imageData = Class164.getImageDataFor(s);
        final ByteBuffer loadImage = imageData.loadImage(new BufferedInputStream(inputStream), b, array);
        final int textureID = createTextureID();
        final Class85 class85 = new Class85(s, n, textureID);
        Class6.GL.glBindTexture(n, textureID);
        final int width = imageData.getWidth();
        final int height = imageData.getHeight();
        final boolean alpha = imageData.getDepth() == 32;
        class85.setTextureWidth(imageData.getTexWidth());
        class85.setTextureHeight(imageData.getTexHeight());
        final int textureWidth = class85.getTextureWidth();
        final int textureHeight = class85.getTextureHeight();
        final IntBuffer intBuffer = BufferUtils.createIntBuffer(16);
        Class6.GL.glGetInteger(3379, intBuffer);
        final int value = intBuffer.get(0);
        if (textureWidth > value || textureHeight > value) {
            throw new IOException("Attempt to allocate a texture to big for the current hardware");
        }
        final int n4 = alpha ? 6408 : 6407;
        final int n5 = alpha ? 4 : 3;
        class85.setWidth(width);
        class85.setHeight(height);
        class85.setAlpha(alpha);
        if (this.holdTextureData) {
            class85.setTextureData(n4, n5, n3, n2, loadImage);
        }
        final Class12 gl = Class6.GL;
        final Class12 gl2 = Class6.GL;
        gl.glTexParameteri(n, 10241, n3);
        final Class12 gl3 = Class6.GL;
        final Class12 gl4 = Class6.GL;
        gl3.glTexParameteri(n, 10240, n2);
        Class6.GL.glTexImage2D(n, 0, this.dstPixelFormat, get2Fold(width), get2Fold(height), 0, n4, 5121, loadImage);
        return class85;
    }
    
    public Class27 createTexture(final int n, final int n2) throws IOException {
        return this.createTexture(n, n2, 9728);
    }
    
    public Class27 createTexture(final int n, final int n2, final int n3) throws IOException {
        return this.getTexture(new Class82(n, n2), n3);
    }
    
    public Class27 getTexture(final Class106 class106, final int n) throws IOException {
        final int n2 = 3553;
        final ByteBuffer imageBufferData = class106.getImageBufferData();
        final int textureID = createTextureID();
        final Class85 class107 = new Class85("generated:" + class106, n2, textureID);
        Class6.GL.glBindTexture(n2, textureID);
        final int width = class106.getWidth();
        final int height = class106.getHeight();
        final boolean alpha = class106.getDepth() == 32;
        class107.setTextureWidth(class106.getTexWidth());
        class107.setTextureHeight(class106.getTexHeight());
        final int textureWidth = class107.getTextureWidth();
        final int textureHeight = class107.getTextureHeight();
        final int n3 = alpha ? 6408 : 6407;
        final int n4 = alpha ? 4 : 3;
        class107.setWidth(width);
        class107.setHeight(height);
        class107.setAlpha(alpha);
        final IntBuffer intBuffer = BufferUtils.createIntBuffer(16);
        Class6.GL.glGetInteger(3379, intBuffer);
        final int value = intBuffer.get(0);
        if (textureWidth > value || textureHeight > value) {
            throw new IOException("Attempt to allocate a texture to big for the current hardware");
        }
        if (this.holdTextureData) {
            class107.setTextureData(n3, n4, n, n, imageBufferData);
        }
        Class6.GL.glTexParameteri(n2, 10241, n);
        Class6.GL.glTexParameteri(n2, 10240, n);
        Class6.GL.glTexImage2D(n2, 0, this.dstPixelFormat, get2Fold(width), get2Fold(height), 0, n3, 5121, imageBufferData);
        return class107;
    }
    
    public static int get2Fold(final int n) {
        int i;
        for (i = 2; i < n; i *= 2) {}
        return i;
    }
    
    public static IntBuffer createIntBuffer(final int n) {
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4 * n);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asIntBuffer();
    }
    
    public void reload() {
        final Iterator<Class85> iterator = this.texturesLinear.values().iterator();
        while (iterator.hasNext()) {
            ((Class85)iterator.next()).reload();
        }
        final Iterator<Class85> iterator2 = this.texturesNearest.values().iterator();
        while (iterator2.hasNext()) {
            ((Class85)iterator2.next()).reload();
        }
    }
    
    public int reload(final Class85 class85, final int n, final int n2, final int n3, final int n4, final ByteBuffer byteBuffer) {
        final int n5 = 3553;
        final int textureID = createTextureID();
        Class6.GL.glBindTexture(n5, textureID);
        Class6.GL.glTexParameteri(n5, 10241, n3);
        Class6.GL.glTexParameteri(n5, 10240, n4);
        Class6.GL.glTexImage2D(n5, 0, this.dstPixelFormat, class85.getTextureWidth(), class85.getTextureHeight(), 0, n, 5121, byteBuffer);
        return textureID;
    }
    
    static {
        Class6.GL = Class83.get();
        loader = new Class6();
    }
}
