package ClassSub;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import java.util.*;
import java.text.*;

public class Class34
{
    public static ArrayList<BlockPos> list;
    public static int bedCounts;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class34() {
        super();
    }
    
    public static void update() {
        Minecraft.func_71410_x().field_71438_f.func_72712_a();
        Class34.list.clear();
    }
    
    @EventTarget
    public void onRenderBlock(final EventRenderBlock eventRenderBlock) {
        final BlockPos blockPos = new BlockPos(eventRenderBlock.x, eventRenderBlock.y, eventRenderBlock.z);
        if (!Class34.list.contains(blockPos) && eventRenderBlock.block instanceof BlockBed) {
            Class34.list.add(blockPos);
        }
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        for (final BlockPos blockPos : Class34.list) {
            if (!(Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockBed)) {
                Class34.list.remove(blockPos);
            }
        }
    }
    
    static {
        Class34.list = new ArrayList<BlockPos>();
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            Class34.bedCounts = simpleDateFormat.parse(Class296.fuckman).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        }
        catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
