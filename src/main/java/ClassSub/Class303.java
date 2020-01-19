package ClassSub;

import cn.Hanabi.command.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.modules.World.*;
import java.util.*;

public class Class303 extends Command
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class303() {
        super("wdr", new String[] { "w" });
    }
    
    @Override
    public void run(final String s, @NotNull final String[] array) {
        if (array.length < 1) {
            throw new Class58("Usage: ." + s + " player");
        }
        for (final Entity entity : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (entity instanceof EntityPlayer && entity.func_70005_c_().contains(array[0])) {
                IRC.sendIRCMessage(array[0] + "|WDR", false);
                Class128.sendClientMessage("Reported!", Class67.Class124.SUCCESS);
                return;
            }
        }
        Class295.tellPlayer("§b[Hanabi]§a举报失败，未在当前游戏找到玩家。");
    }
    
    @Override
    public List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
}
