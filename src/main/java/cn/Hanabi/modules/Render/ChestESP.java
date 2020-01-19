package cn.Hanabi.modules.Render;

import net.minecraft.util.*;
import cn.Hanabi.modules.*;
import net.minecraft.block.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import cn.Hanabi.injection.interfaces.*;
import ClassSub.*;
import java.util.*;

public class ChestESP extends Mod
{
    ArrayList<BlockPos> list;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public ChestESP() {
        super("ChestESP", Category.RENDER);
        this.list = new ArrayList<BlockPos>();
    }
    
    public void onEnable() {
        ChestESP.mc.field_71438_f.func_72712_a();
        this.list.clear();
    }
    
    @EventTarget
    public void onRenderBlock(final EventRenderBlock eventRenderBlock) {
        final BlockPos blockPos = new BlockPos(eventRenderBlock.x, eventRenderBlock.y, eventRenderBlock.z);
        if (!this.list.contains(blockPos) && (eventRenderBlock.block instanceof BlockChest || eventRenderBlock.block instanceof BlockEnderChest)) {
            this.list.add(blockPos);
        }
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        for (final BlockPos blockPos : this.list) {
            if (!(ChestESP.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockChest) && !(ChestESP.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockEnderChest)) {
                this.list.remove(blockPos);
            }
            Class284.drawSolidBlockESP((double)blockPos.func_177958_n() - ((IRenderManager)ChestESP.mc.func_175598_ae()).getRenderPosX(), (double)blockPos.func_177956_o() - ((IRenderManager)ChestESP.mc.func_175598_ae()).getRenderPosY(), (double)blockPos.func_177952_p() - ((IRenderManager)ChestESP.mc.func_175598_ae()).getRenderPosZ(), 1.0f, 1.0f, 1.0f, 0.2f);
        }
    }
}
