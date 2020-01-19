package cn.Hanabi.modules.World;

import java.io.*;

class Class145 extends Thread
{
    final IRC this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class145(final IRC this$0) {
        ((Class145)this).this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this.setName("ReadMessage");
        try {
            while (cn.Hanabi.modules.World.IRC.access$000(((Class145)this).this$0)) {
                final String line;
                if ((line = ((Class145)this).this$0.br.readLine()) != null) {
                    cn.Hanabi.modules.World.IRC.processMessage(line);
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
