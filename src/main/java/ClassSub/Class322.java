package ClassSub;

import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.awt.image.*;

class Class322 implements IImageBuffer
{
    final Class146 val$track;
    final ResourceLocation val$rl2;
    final Class108 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class322(final Class108 this$0, final Class146 val$track, final ResourceLocation val$rl2) {
        this.this$0 = this$0;
        this.val$track = val$track;
        this.val$rl2 = val$rl2;
        super();
    }
    
    public BufferedImage func_78432_a(final BufferedImage bufferedImage) {
        return bufferedImage;
    }
    
    public void func_152634_a() {
        this.this$0.circleLocations.put(this.val$track.getId(), this.val$rl2);
    }
}
