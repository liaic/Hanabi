package cn.Hanabi.modules.Render;

import net.minecraft.util.*;
import cn.Hanabi.modules.*;
import net.minecraft.block.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.block.material.*;
import ClassSub.*;
import java.util.*;
import net.minecraft.block.state.*;

public class CaveFinder extends Mod
{
    ArrayList<BlockPos> list;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public CaveFinder() {
        super("CaveFinder", Category.RENDER);
        this.list = new ArrayList<BlockPos>();
    }
    
    public void onEnable() {
        CaveFinder.mc.field_71438_f.func_72712_a();
        this.list.clear();
    }
    
    @EventTarget
    public void onRenderBlock(final EventRenderBlock eventRenderBlock) {
        final BlockPos blockPos = new BlockPos(eventRenderBlock.x, eventRenderBlock.y, eventRenderBlock.z);
        if (!this.list.contains(blockPos) && eventRenderBlock.block instanceof BlockLiquid && eventRenderBlock.y <= 40) {
            this.list.add(blockPos);
        }
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        for (final BlockPos blockPos : this.list) {
            final IBlockState func_180495_p = CaveFinder.mc.field_71441_e.func_180495_p(blockPos);
            if (!(func_180495_p.func_177230_c() instanceof BlockLiquid)) {
                this.list.remove(blockPos);
            }
            Class284.drawSolidBlockESP((double)blockPos.func_177958_n() - ((IRenderManager)CaveFinder.mc.func_175598_ae()).getRenderPosX(), (double)blockPos.func_177956_o() - ((IRenderManager)CaveFinder.mc.func_175598_ae()).getRenderPosY(), (double)blockPos.func_177952_p() - ((IRenderManager)CaveFinder.mc.func_175598_ae()).getRenderPosZ(), (func_180495_p.func_177230_c().func_149688_o() == Material.field_151587_i) ? 1.0f : 0.0f, 0.0f, (func_180495_p.func_177230_c().func_149688_o() == Material.field_151586_h) ? 1.0f : 0.0f, 0.2f);
        }
    }
}
