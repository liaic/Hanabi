package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.client.gui.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.settings.*;
import ClassSub.*;
import org.lwjgl.input.*;
import com.darkmagician6.eventapi.*;

public class InvMove extends Mod
{
    private boolean isWalking;
    private Value mode;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public InvMove() {
        super("InvMove", Category.PLAYER);
        (this.mode = new Value("InvMove", "Mode", 0)).addValue("Vanilla");
        this.mode.addValue("Hypixel");
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (InvMove.mc.field_71462_r != null && !(InvMove.mc.field_71462_r instanceof GuiChat)) {
            this.isWalking = true;
            if (this.mode.isCurrentMode("Hypixel")) {
                InvMove.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(6));
                this.setDisplayName("Hypixel");
            }
            else {
                this.setDisplayName("Vanilla");
            }
            if (Class69.username.length() < 1) {
                System.exit(0);
            }
            KeyBinding[] array;
            for (int length = (array = new KeyBinding[] { InvMove.mc.field_71474_y.field_74351_w, InvMove.mc.field_71474_y.field_74368_y, InvMove.mc.field_71474_y.field_74370_x, InvMove.mc.field_71474_y.field_74366_z, InvMove.mc.field_71474_y.field_151444_V, InvMove.mc.field_71474_y.field_74314_A }).length, i = 0; i < length; ++i) {
                if (Class21.abuses < 0) {
                    InvMove.mc.field_71439_g.field_70181_x = 0.3;
                }
                final KeyBinding keyBinding = array[i];
                KeyBinding.func_74510_a(keyBinding.func_151463_i(), Keyboard.isKeyDown(keyBinding.func_151463_i()));
            }
        }
        else if (this.isWalking) {
            if (this.mode.isCurrentMode("Hypixel")) {
                InvMove.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(InvMove.mc.field_71439_g.field_71071_by.field_70461_c));
                this.setDisplayName("Hypixel");
            }
            else {
                this.setDisplayName("Vanilla");
            }
            this.isWalking = false;
        }
    }
}
