package ClassSub;

import cn.Hanabi.events.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.entity.player.*;

class Class258 extends Thread
{
    final EventAttack val$e;
    final TPHit this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class258(final TPHit this$0, final EventAttack val$e) {
        this.this$0 = this$0;
        this.val$e = val$e;
        super();
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.this$0.aacCount = 0;
        TPHit.access$3800().field_71442_b.func_78764_a((EntityPlayer)TPHit.access$3700().field_71439_g, this.val$e.getEntity());
        TPHit.access$3900().field_71439_g.func_71038_i();
    }
}
