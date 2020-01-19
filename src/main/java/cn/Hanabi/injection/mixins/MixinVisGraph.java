package cn.Hanabi.injection.mixins;

import net.minecraft.client.renderer.chunk.*;
import org.spongepowered.asm.mixin.*;
import java.util.*;
import net.minecraft.util.*;

@Mixin({ VisGraph.class })
public abstract class MixinVisGraph
{
    @Shadow
    private BitSet field_178612_d;
    @Shadow
    private static int[] field_178613_e;
    @Shadow
    private int field_178611_f;
    
    public MixinVisGraph() {
        super();
    }
    
    private static int getIndex(final BlockPos pos) {
        return getIndex(pos.func_177958_n() & 0xF, pos.func_177956_o() & 0xF, pos.func_177952_p() & 0xF);
    }
    
    private static int getIndex(final int x, final int y, final int z) {
        return x << 0 | y << 8 | z << 4;
    }
    
    @Shadow
    public abstract Set<EnumFacing> func_178604_a(final int p0);
}
