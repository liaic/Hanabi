package ClassSub;

public final class Class276
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class276() {
        super();
    }
    
    public static void checkGLContext() {
        try {
            Class83.get().glGetError();
        }
        catch (NullPointerException ex) {
            throw new RuntimeException("OpenGL based resources (images, fonts, sprites etc) must be loaded as part of init() or the game loop. They cannot be loaded before initialisation.");
        }
    }
}
