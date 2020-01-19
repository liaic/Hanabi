package ClassSub;

import java.util.*;
import org.lwjgl.opengl.*;

public class Class129
{
    private static HashMap graphics;
    private static boolean pbuffer;
    private static boolean pbufferRT;
    private static boolean fbo;
    private static boolean init;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class129() {
        super();
    }
    
    private static void init() throws Class186 {
        Class129.init = true;
        if (Class129.fbo) {
            Class129.fbo = GLContext.getCapabilities().GL_EXT_framebuffer_object;
        }
        Class129.pbuffer = ((Pbuffer.getCapabilities() & 0x1) != 0x0);
        Class129.pbufferRT = ((Pbuffer.getCapabilities() & 0x2) != 0x0);
        if (!Class129.fbo && !Class129.pbuffer && !Class129.pbufferRT) {
            throw new Class186("Your OpenGL card does not support offscreen buffers and hence can't handle the dynamic images required for this application.");
        }
        Class121.info("Offscreen Buffers FBO=" + Class129.fbo + " PBUFFER=" + Class129.pbuffer + " PBUFFERRT=" + Class129.pbufferRT);
    }
    
    public static void setUseFBO(final boolean fbo) {
        Class129.fbo = fbo;
    }
    
    public static boolean usingFBO() {
        return Class129.fbo;
    }
    
    public static boolean usingPBuffer() {
        return !Class129.fbo && Class129.pbuffer;
    }
    
    public static Class116 getGraphicsForImage(final Class140 class140) throws Class186 {
        Class116 graphics = (Class116)Class129.graphics.get(class140.getTexture());
        if (graphics == null) {
            graphics = createGraphics(class140);
            Class129.graphics.put(class140.getTexture(), graphics);
        }
        return graphics;
    }
    
    public static void releaseGraphicsForImage(final Class140 class140) throws Class186 {
        final Class116 class141 = (Class116)Class129.graphics.remove(class140.getTexture());
        if (class141 != null) {
            class141.destroy();
        }
    }
    
    private static Class116 createGraphics(final Class140 class140) throws Class186 {
        init();
        if (Class129.fbo) {
            try {
                return new Class253(class140);
            }
            catch (Exception ex) {
                Class129.fbo = false;
                Class121.warn("FBO failed in use, falling back to PBuffer");
            }
        }
        if (!Class129.pbuffer) {
            throw new Class186("Failed to create offscreen buffer even though the card reports it's possible");
        }
        if (Class129.pbufferRT) {
            return new Class80(class140);
        }
        return new Class306(class140);
    }
    
    static {
        Class129.graphics = new HashMap();
        Class129.pbuffer = true;
        Class129.pbufferRT = true;
        Class129.fbo = true;
        Class129.init = false;
    }
}
