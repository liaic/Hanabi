package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Combat.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ Entity.class })
public abstract class MixinEntity implements IEntity
{
    @Shadow
    public double field_70165_t;
    @Shadow
    public double field_70163_u;
    @Shadow
    public double field_70161_v;
    @Shadow
    public float field_70177_z;
    @Shadow
    public float field_70125_A;
    @Shadow
    public boolean field_70122_E;
    @Shadow
    private int field_70150_b;
    @Shadow
    private int field_70151_c;
    @Shadow
    private AxisAlignedBB field_70121_D;
    @Shadow
    public World field_70170_p;
    
    public MixinEntity() {
        super();
    }
    
    @Override
    public int getNextStepDistance() {
        return this.field_70150_b;
    }
    
    @Override
    public void setNextStepDistance(final int distance) {
        this.field_70150_b = distance;
    }
    
    @Override
    public int getFire() {
        return this.field_70151_c;
    }
    
    @Override
    public void setFire(final int i) {
        this.field_70151_c = i;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox() {
        return this.field_70121_D;
    }
    
    @Overwrite
    public float func_70111_Y() {
        if (ModManager.getModule("Hitbox").isEnabled()) {
            return 0.1f + Hitbox.getSize();
        }
        return 0.1f;
    }
}
