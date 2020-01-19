package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import org.spongepowered.asm.mixin.*;
import java.util.*;
import io.netty.channel.*;
import net.minecraft.network.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.darkmagician6.eventapi.types.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;
import io.netty.util.concurrent.*;

@Mixin({ NetworkManager.class })
public abstract class MixinNetworkManager implements INetworkManager
{
    @Shadow
    private Channel field_150746_k;
    @Shadow
    private Queue field_150745_j;
    
    public MixinNetworkManager() {
        super();
    }
    
    @Inject(method = { "channelRead0" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/network/Packet;processPacket(Lnet/minecraft/network/INetHandler;)V", shift = At.Shift.BEFORE) }, cancellable = true)
    private void packetReceived(final ChannelHandlerContext p_channelRead0_1_, final Packet packet, final CallbackInfo ci) {
        final EventPacket event = new EventPacket(EventType.RECIEVE, packet);
        EventManager.call((Event)event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }
    
    @Inject(method = { "sendPacket(Lnet/minecraft/network/Packet;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void sendPacket(final Packet packetIn, final CallbackInfo ci) {
        final EventPacket event = new EventPacket(EventType.SEND, packetIn);
        EventManager.call((Event)event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }
    
    @Override
    public void sendPacketNoEvent(final Packet a) {
        if (this.field_150746_k != null && this.field_150746_k.isOpen()) {
            final GenericFutureListener[] a2 = null;
            this.func_150733_h();
            this.func_150732_b(a, a2);
            return;
        }
        this.field_150745_j.add(new InboundHandlerTuplePacketListener(a, (GenericFutureListener<? extends Future<? super Void>>[])null));
    }
    
    @Shadow
    protected abstract void func_150732_b(final Packet p0, final GenericFutureListener[] p1);
    
    @Shadow
    protected abstract void func_150733_h();
}
