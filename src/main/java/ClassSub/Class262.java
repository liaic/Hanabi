package ClassSub;

import org.lwjgl.opengl.*;

public abstract class Class262
{
    private static Class27 lastUsed;
    private static boolean inSafe;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class262() {
        super();
    }
    
    public static void enterSafeBlock() {
        if (Class262.inSafe) {
            return;
        }
        Class83.get().flush();
        Class262.lastUsed = Class85.getLastBind();
        Class85.bindNone();
        GL11.glPushAttrib(1048575);
        GL11.glPushClientAttrib(-1);
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5888);
        Class262.inSafe = true;
    }
    
    public static void leaveSafeBlock() {
        if (!Class262.inSafe) {
            return;
        }
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GL11.glPopClientAttrib();
        GL11.glPopAttrib();
        if (Class262.lastUsed != null) {
            Class262.lastUsed.bind();
        }
        else {
            Class85.bindNone();
        }
        Class262.inSafe = false;
    }
    
    public final void call() throws Class186 {
        enterSafeBlock();
        this.performGLOperations();
        leaveSafeBlock();
    }
    
    protected abstract void performGLOperations() throws Class186;
    
    static {
        Class262.inSafe = false;
    }
}
