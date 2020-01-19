package ClassSub;

import java.nio.*;
import org.lwjgl.*;

public class Class85 implements Class27
{
    protected static Class12 GL;
    static Class27 lastBind;
    private int target;
    private int textureID;
    private int height;
    private int width;
    private int texWidth;
    private int texHeight;
    private float widthRatio;
    private float heightRatio;
    private boolean alpha;
    private String ref;
    private String cacheName;
    private Class97 reloadData;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Class27 getLastBind() {
        return Class85.lastBind;
    }
    
    protected Class85() {
        super();
    }
    
    public Class85(final String ref, final int target, final int textureID) {
        super();
        this.target = target;
        this.ref = ref;
        this.textureID = textureID;
        Class85.lastBind = this;
    }
    
    public void setCacheName(final String cacheName) {
        this.cacheName = cacheName;
    }
    
    @Override
    public boolean hasAlpha() {
        return this.alpha;
    }
    
    @Override
    public String getTextureRef() {
        return this.ref;
    }
    
    public void setAlpha(final boolean alpha) {
        this.alpha = alpha;
    }
    
    public static void bindNone() {
        Class85.lastBind = null;
        Class85.GL.glDisable(3553);
    }
    
    public static void unbind() {
        Class85.lastBind = null;
    }
    
    @Override
    public void bind() {
        if (Class85.lastBind != this) {
            Class85.lastBind = this;
            Class85.GL.glEnable(3553);
            Class85.GL.glBindTexture(this.target, this.textureID);
        }
    }
    
    public void setHeight(final int height) {
        this.height = height;
        this.setHeight();
    }
    
    public void setWidth(final int width) {
        this.width = width;
        this.setWidth();
    }
    
    @Override
    public int getImageHeight() {
        return this.height;
    }
    
    @Override
    public int getImageWidth() {
        return this.width;
    }
    
    @Override
    public float getHeight() {
        return this.heightRatio;
    }
    
    @Override
    public float getWidth() {
        return this.widthRatio;
    }
    
    @Override
    public int getTextureHeight() {
        return this.texHeight;
    }
    
    @Override
    public int getTextureWidth() {
        return this.texWidth;
    }
    
    public void setTextureHeight(final int texHeight) {
        this.texHeight = texHeight;
        this.setHeight();
    }
    
    public void setTextureWidth(final int texWidth) {
        this.texWidth = texWidth;
        this.setWidth();
    }
    
    private void setHeight() {
        if (this.texHeight != 0) {
            this.heightRatio = this.height / this.texHeight;
        }
    }
    
    private void setWidth() {
        if (this.texWidth != 0) {
            this.widthRatio = this.width / this.texWidth;
        }
    }
    
    @Override
    public void release() {
        final IntBuffer intBuffer = this.createIntBuffer(1);
        intBuffer.put(this.textureID);
        intBuffer.flip();
        Class85.GL.glDeleteTextures(intBuffer);
        if (Class85.lastBind == this) {
            bindNone();
        }
        if (this.cacheName != null) {
            Class6.get().clear(this.cacheName);
        }
        else {
            Class6.get().clear(this.ref);
        }
    }
    
    @Override
    public int getTextureID() {
        return this.textureID;
    }
    
    public void setTextureID(final int textureID) {
        this.textureID = textureID;
    }
    
    protected IntBuffer createIntBuffer(final int n) {
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4 * n);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asIntBuffer();
    }
    
    @Override
    public byte[] getTextureData() {
        final ByteBuffer byteBuffer = BufferUtils.createByteBuffer((this.hasAlpha() ? 4 : 3) * this.texWidth * this.texHeight);
        this.bind();
        Class85.GL.glGetTexImage(3553, 0, this.hasAlpha() ? 6408 : 6407, 5121, byteBuffer);
        final byte[] array = new byte[byteBuffer.limit()];
        byteBuffer.get(array);
        byteBuffer.clear();
        return array;
    }
    
    @Override
    public void setTextureFilter(final int n) {
        this.bind();
        Class85.GL.glTexParameteri(this.target, 10241, n);
        Class85.GL.glTexParameteri(this.target, 10240, n);
    }
    
    public void setTextureData(final int n, final int n2, final int n3, final int n4, final ByteBuffer byteBuffer) {
        Class97.access$102(this.reloadData = new Class97((Class71)null), n);
        Class97.access$202(this.reloadData, n2);
        Class97.access$302(this.reloadData, n3);
        Class97.access$402(this.reloadData, n4);
        Class97.access$502(this.reloadData, byteBuffer);
    }
    
    public void reload() {
        if (this.reloadData != null) {
            this.textureID = this.reloadData.reload();
        }
    }
    
    static String access$600(final Class85 class85) {
        return class85.ref;
    }
    
    static {
        Class85.GL = Class83.get();
    }
}
