package ClassSub;

import cn.Hanabi.modules.Combat.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

class Class62 extends Thread
{
    final TPHit this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class62(final TPHit this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(1430L);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        TPHit.access$4300().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$4000().field_71439_g.field_70165_t + 0.08, TPHit.access$4100().field_71439_g.field_70163_u, TPHit.access$4200().field_71439_g.field_70161_v, false));
    }
}
