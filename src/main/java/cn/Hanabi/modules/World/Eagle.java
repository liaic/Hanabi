package cn.Hanabi.modules.World;

import cn.Hanabi.modules.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.events.*;
import net.minecraft.block.*;
import net.minecraft.client.settings.*;
import com.darkmagician6.eventapi.*;

public class Eagle extends Mod
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Eagle() {
        super("Eagle", Category.WORLD);
    }
    
    public Block getBlock(final BlockPos blockPos) {
        return Eagle.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    public Block getBlockUnderPlayer(final EntityPlayer entityPlayer) {
        return this.getBlock(new BlockPos(entityPlayer.field_70165_t, entityPlayer.field_70163_u - 1.0, entityPlayer.field_70161_v));
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (this.getBlockUnderPlayer((EntityPlayer)Eagle.mc.field_71439_g) instanceof BlockAir) {
            if (Eagle.mc.field_71439_g.field_70122_E) {
                KeyBinding.func_74510_a(Eagle.mc.field_71474_y.field_74311_E.func_151463_i(), true);
            }
        }
        else if (Eagle.mc.field_71439_g.field_70122_E) {
            KeyBinding.func_74510_a(Eagle.mc.field_71474_y.field_74311_E.func_151463_i(), false);
        }
    }
    
    public void onEnable() {
        Eagle.mc.field_71439_g.func_70095_a(false);
        super.onEnable();
    }
    
    public void onDisable() {
        KeyBinding.func_74510_a(Eagle.mc.field_71474_y.field_74311_E.func_151463_i(), false);
        super.onDisable();
    }
}
