package ClassSub;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

public class Class80 extends Class116
{
    private Pbuffer pbuffer;
    private Class140 image;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class80(final Class140 image) throws Class186 {
        super(image.getTexture().getTextureWidth(), image.getTexture().getTextureHeight());
        this.image = image;
        Class121.debug("Creating pbuffer(rtt) " + image.getWidth() + "x" + image.getHeight());
        if ((Pbuffer.getCapabilities() & 0x1) == 0x0) {
            throw new Class186("Your OpenGL card does not support PBuffers and hence can't handle the dynamic images required for this application.");
        }
        if ((Pbuffer.getCapabilities() & 0x2) == 0x0) {
            throw new Class186("Your OpenGL card does not support Render-To-Texture and hence can't handle the dynamic images required for this application.");
        }
        this.init();
    }
    
    private void init() throws Class186 {
        try {
            final Class27 texture = Class6.get().createTexture(this.image.getWidth(), this.image.getHeight(), this.image.getFilter());
            (this.pbuffer = new Pbuffer(this.screenWidth, this.screenHeight, new PixelFormat(8, 0, 0), new RenderTexture(false, true, false, false, 8314, 0), (Drawable)null)).makeCurrent();
            this.initGL();
            Class80.GL.glBindTexture(3553, texture.getTextureID());
            this.pbuffer.releaseTexImage(8323);
            this.image.draw(0.0f, 0.0f);
            this.image.setTexture(texture);
            Display.makeCurrent();
        }
        catch (Exception ex) {
            Class121.error(ex);
            throw new Class186("Failed to create PBuffer for dynamic image. OpenGL driver failure?");
        }
    }
    
    @Override
    protected void disable() {
        Class80.GL.flush();
        Class80.GL.glBindTexture(3553, this.image.getTexture().getTextureID());
        this.pbuffer.bindTexImage(8323);
        try {
            Display.makeCurrent();
        }
        catch (LWJGLException ex) {
            Class121.error((Throwable)ex);
        }
        Class262.leaveSafeBlock();
    }
    
    @Override
    protected void enable() {
        Class262.enterSafeBlock();
        try {
            if (this.pbuffer.isBufferLost()) {
                this.pbuffer.destroy();
                this.init();
            }
            this.pbuffer.makeCurrent();
        }
        catch (Exception ex) {
            Class121.error("Failed to recreate the PBuffer");
            throw new RuntimeException(ex);
        }
        Class80.GL.glBindTexture(3553, this.image.getTexture().getTextureID());
        this.pbuffer.releaseTexImage(8323);
        Class85.unbind();
        this.initGL();
    }
    
    protected void initGL() {
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glViewport(0, 0, this.screenWidth, this.screenHeight);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        this.enterOrtho();
    }
    
    protected void enterOrtho() {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, (double)this.screenWidth, 0.0, (double)this.screenHeight, 1.0, -1.0);
        GL11.glMatrixMode(5888);
    }
    
    @Override
    public void destroy() {
        super.destroy();
        this.pbuffer.destroy();
    }
    
    @Override
    public void flush() {
        super.flush();
        this.image.flushPixelData();
    }
}
