package cn.Hanabi.modules.Player;

import ClassSub.*;
import net.minecraft.network.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.types.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.play.server.*;
import javax.vecmath.*;
import cn.Hanabi.injection.interfaces.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;

public class Blink extends Mod
{
    Class191 time;
    ArrayList<Packet> packets;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Blink() {
        super("Blink", Category.PLAYER);
        this.time = new Class191();
        this.packets = new ArrayList<Packet>();
        this.setState(false);
    }
    
    @EventTarget
    public void onPacket(final EventPacket eventPacket) {
        if (eventPacket.getEventType() == EventType.SEND) {
            if (eventPacket.getPacket() instanceof C03PacketPlayer) {
                this.packets.add(eventPacket.getPacket());
                eventPacket.setCancelled(true);
            }
            else if (eventPacket.getPacket() instanceof C08PacketPlayerBlockPlacement || eventPacket.getPacket() instanceof C07PacketPlayerDigging || eventPacket.getPacket() instanceof C09PacketHeldItemChange || eventPacket.getPacket() instanceof C02PacketUseEntity) {
                this.packets.add(eventPacket.getPacket());
                eventPacket.setCancelled(true);
            }
        }
        if (eventPacket.getEventType() == EventType.RECIEVE && eventPacket.getPacket() instanceof S08PacketPlayerPosLook) {
            eventPacket.setCancelled(true);
        }
    }
    
    private void addPosition() {
        final Vector3f vector3f = new Vector3f((float)Blink.mc.field_71439_g.field_70165_t, (float)Blink.mc.field_71439_g.field_70163_u, (float)Blink.mc.field_71439_g.field_70161_v);
        if (Blink.mc.field_71439_g.field_71158_b.field_78900_b != 0.0f || ((IKeyBinding)Blink.mc.field_71474_y.field_74314_A).getPress() || Blink.mc.field_71439_g.field_71158_b.field_78902_a != 0.0f) {}
    }
    
    public void onEnable() {
        EventManager.register((Object)this);
        if (Blink.mc.field_71439_g != null && Blink.mc.field_71441_e != null) {
            final double field_70165_t = Blink.mc.field_71439_g.field_70165_t;
            final double field_70163_u = Blink.mc.field_71439_g.field_70163_u;
            final double field_70161_v = Blink.mc.field_71439_g.field_70161_v;
            final float field_70177_z = Blink.mc.field_71439_g.field_70177_z;
            final float field_70125_A = Blink.mc.field_71439_g.field_70125_A;
            final EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP((World)Blink.mc.field_71441_e, Blink.mc.field_71439_g.func_146103_bH());
            entityOtherPlayerMP.field_71071_by = Blink.mc.field_71439_g.field_71071_by;
            entityOtherPlayerMP.field_71069_bz = Blink.mc.field_71439_g.field_71069_bz;
            entityOtherPlayerMP.func_70080_a(field_70165_t, field_70163_u, field_70161_v, field_70177_z, field_70125_A);
            entityOtherPlayerMP.field_70759_as = Blink.mc.field_71439_g.field_70759_as;
            Blink.mc.field_71441_e.func_73027_a(-1, (Entity)entityOtherPlayerMP);
        }
        this.packets.clear();
    }
    
    public void onDisable() {
        EventManager.unregister((Object)this);
        Blink.mc.field_71441_e.func_73028_b(-1);
        final Iterator<Packet> iterator = this.packets.iterator();
        while (iterator.hasNext()) {
            Blink.mc.field_71439_g.field_71174_a.func_147297_a((Packet)iterator.next());
            this.time.reset();
        }
        this.packets.clear();
    }
}
