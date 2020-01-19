package ClassSub;

import cn.Hanabi.events.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;

class Class215 extends Thread
{
    final EventAttack val$e;
    final TPHit this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class215(final TPHit this$0, final EventAttack val$e) {
        this.this$0 = this$0;
        this.val$e = val$e;
        super();
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(10L);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        final int func_177958_n = this.val$e.getEntity().func_180425_c().func_177958_n();
        final int func_177956_o = this.val$e.getEntity().func_180425_c().func_177956_o();
        final int func_177952_p = this.val$e.getEntity().func_180425_c().func_177952_p();
        final double n = func_177958_n - TPHit.access$000().field_71439_g.field_70165_t + 0.5;
        final double n2 = func_177956_o - TPHit.access$100().field_71439_g.field_70163_u + 0.08;
        final double n3 = func_177952_p - TPHit.access$200().field_71439_g.field_70161_v + 0.5;
        final double ceil = Math.ceil(Math.sqrt(Math.pow(n, 2.0) + Math.pow(n2, 2.0) + Math.pow(n3, 2.0)) / 9.8);
        TPHit.access$600().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$300().field_71439_g.field_70165_t, TPHit.access$400().field_71439_g.field_70163_u - 0.32, TPHit.access$500().field_71439_g.field_70161_v, false));
        TPHit.access$1000().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$700().field_71439_g.field_70165_t, TPHit.access$800().field_71439_g.field_70163_u - 0.32, TPHit.access$900().field_71439_g.field_70161_v, false));
        TPHit.access$1400().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$1100().field_71439_g.field_70165_t, TPHit.access$1200().field_71439_g.field_70163_u, TPHit.access$1300().field_71439_g.field_70161_v, false));
        TPHit.access$1800().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$1500().field_71439_g.field_70165_t, TPHit.access$1600().field_71439_g.field_70163_u, TPHit.access$1700().field_71439_g.field_70161_v, false));
        TPHit.access$2200().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$1900().field_71439_g.field_70165_t, TPHit.access$2000().field_71439_g.field_70163_u + 1.1, TPHit.access$2100().field_71439_g.field_70161_v, false));
        TPHit.access$2600().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$2300().field_71439_g.field_70165_t, TPHit.access$2400().field_71439_g.field_70163_u + 1.1, TPHit.access$2500().field_71439_g.field_70161_v, false));
        for (int n4 = 1; n4 <= ceil; ++n4) {
            TPHit.access$3000().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$2700().field_71439_g.field_70165_t + n / ceil * n4, TPHit.access$2800().field_71439_g.field_70163_u + n2 / ceil * n4, TPHit.access$2900().field_71439_g.field_70161_v + n3 / ceil * n4, false));
        }
        TPHit.access$3200().field_71442_b.func_78764_a((EntityPlayer)TPHit.access$3100().field_71439_g, this.val$e.getEntity());
        TPHit.access$3300().field_71439_g.func_71038_i();
    }
}
