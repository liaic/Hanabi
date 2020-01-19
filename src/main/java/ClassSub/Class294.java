package ClassSub;

final class Class294 extends Thread
{
    final Class218 val$hud;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class294(final Class218 val$hud) {
        this.val$hud = val$hud;
        super();
    }
    
    @Override
    public void run() {
        this.val$hud.set(false);
        try {
            Thread.sleep(500L);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.val$hud.set(true);
    }
}
