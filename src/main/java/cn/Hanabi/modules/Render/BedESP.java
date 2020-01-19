package cn.Hanabi.modules.Render;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.util.*;
import cn.Hanabi.injection.interfaces.*;
import ClassSub.*;
import java.util.*;
import com.darkmagician6.eventapi.*;

public class BedESP extends Mod
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public BedESP() {
        super("BedESP", Category.RENDER);
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        for (final BlockPos blockPos : Class34.list) {
            Class284.drawSolidBlockESP((double)blockPos.func_177958_n() - ((IRenderManager)BedESP.mc.func_175598_ae()).getRenderPosX(), (double)blockPos.func_177956_o() - ((IRenderManager)BedESP.mc.func_175598_ae()).getRenderPosY(), (double)blockPos.func_177952_p() - ((IRenderManager)BedESP.mc.func_175598_ae()).getRenderPosZ(), 1.0f, 1.0f, 1.0f, 0.2f);
        }
    }
}
