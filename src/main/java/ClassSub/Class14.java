package ClassSub;

class Class14 extends Thread
{
    final Class118 val$hud;
    final Class118 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class14(final Class118 this$0, final Class118 val$hud) {
        this.this$0 = this$0;
        this.val$hud = val$hud;
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
