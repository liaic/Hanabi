package cn.Hanabi.modules.World;

import java.io.*;

class Class17 extends Thread
{
    final IRC this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class17(final IRC this$0) {
        ((Class17)this).this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this.setName("Reconnect");
        new IRC.Class73(((Class17)this).this$0).start();
    Label_0024_Outer:
        while (true) {
            while (true) {
                try {
                    while (true) {
                        Thread.sleep(1000L);
                        ((Class17)this).this$0.socket.sendUrgentData(255);
                    }
                }
                catch (IOException ex3) {
                    if (cn.Hanabi.modules.World.IRC.access$100(((Class17)this).this$0).isDelayComplete(2000L)) {
                        cn.Hanabi.modules.World.IRC.access$100(((Class17)this).this$0).reset();
                        new IRC.Class73(((Class17)this).this$0).start();
                    }
                    continue Label_0024_Outer;
                }
                catch (NullPointerException ex) {
                    ex.printStackTrace();
                    continue Label_0024_Outer;
                }
                catch (InterruptedException ex2) {
                    ex2.printStackTrace();
                    continue Label_0024_Outer;
                }
                continue;
            }
        }
    }
}
