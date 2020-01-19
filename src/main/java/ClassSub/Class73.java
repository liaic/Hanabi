package cn.Hanabi.modules.World;

import java.net.*;
import ClassSub.*;
import java.io.*;

class Class73 extends Thread
{
    final IRC this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class73(final IRC this$0) {
        ((Class73)this).this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        this.setName("Connect");
        try {
            cn.Hanabi.modules.World.IRC.access$002(((Class73)this).this$0, false);
            ((Class73)this).this$0.socket = new Socket("47.244.128.222", 8687);
            (cn.Hanabi.modules.World.IRC.pw = new PrintWriter(((Class73)this).this$0.socket.getOutputStream(), true)).println(Class69.username + "|" + Class69.password + "|Hanabi");
            ((Class73)this).this$0.br = new BufferedReader(new InputStreamReader(((Class73)this).this$0.socket.getInputStream(), "UTF-8"));
            Thread.sleep(3000L);
            cn.Hanabi.modules.World.IRC.access$002(((Class73)this).this$0, true);
            ((Class73)this).this$0.new Class145().start();
            if (Class69.password.length() < 32) {
                System.exit(0);
            }
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
