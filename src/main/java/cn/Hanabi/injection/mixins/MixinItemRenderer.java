package cn.Hanabi.injection.mixins;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.entity.*;
import org.spongepowered.asm.mixin.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Render.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

@Mixin({ ItemRenderer.class })
public abstract class MixinItemRenderer
{
    @Shadow
    private Minecraft field_78455_a;
    @Shadow
    private float field_78454_c;
    @Shadow
    private float field_78451_d;
    @Shadow
    private ItemStack field_78453_b;
    @Shadow
    private RenderManager field_178111_g;
    
    public MixinItemRenderer() {
        super();
    }
    
    @Overwrite
    public void func_78440_a(final float partialTicks) {
        final float f = 1.0f - (this.field_78451_d + (this.field_78454_c - this.field_78451_d) * partialTicks);
        final AbstractClientPlayer entityplayersp = (AbstractClientPlayer)this.field_78455_a.field_71439_g;
        final float f2 = entityplayersp.func_70678_g(partialTicks);
        final float f3 = entityplayersp.field_70127_C + (entityplayersp.field_70125_A - entityplayersp.field_70127_C) * partialTicks;
        final float f4 = entityplayersp.field_70126_B + (entityplayersp.field_70177_z - entityplayersp.field_70126_B) * partialTicks;
        this.func_178101_a(f3, f4);
        this.func_178109_a(entityplayersp);
        this.func_178110_a((EntityPlayerSP)entityplayersp, partialTicks);
        GlStateManager.func_179091_B();
        GlStateManager.func_179094_E();
        if (this.field_78453_b != null) {
            if (this.field_78453_b.func_77973_b() == Items.field_151098_aY) {
                this.func_178097_a(entityplayersp, f3, f, f2);
            }
            else if (entityplayersp.func_71052_bv() > 0) {
                final EnumAction enumaction = this.field_78453_b.func_77975_n();
                switch (enumaction) {
                    case NONE: {
                        this.func_178096_b(f, 0.0f);
                        break;
                    }
                    case EAT:
                    case DRINK: {
                        this.func_178104_a(entityplayersp, partialTicks);
                        this.func_178096_b(f, 0.0f);
                        break;
                    }
                    case BLOCK: {
                        this.renderblock(f, f2);
                        break;
                    }
                    case BOW: {
                        this.func_178096_b(f, 0.0f);
                        this.func_178098_a(partialTicks, entityplayersp);
                        break;
                    }
                }
            }
            else {
                this.func_178105_d(f2);
                this.func_178096_b(f, f2);
            }
            this.func_178099_a((EntityLivingBase)entityplayersp, this.field_78453_b, ItemCameraTransforms.TransformType.FIRST_PERSON);
        }
        else if (!entityplayersp.func_82150_aj()) {
            this.func_178095_a(entityplayersp, f, f2);
        }
        GlStateManager.func_179121_F();
        GlStateManager.func_179101_C();
        RenderHelper.func_74518_a();
    }
    
    private void renderblock(final float f, final float f1) {
        if (!ModManager.getModule("HitAnimation").isEnabled()) {
            this.func_178096_b(f, 0.0f);
            this.func_178103_d();
            return;
        }
        if (HitAnimation.mode.isCurrentMode("Sigma")) {
            this.func_178096_b(f, 0.0f);
            this.func_178103_d();
            final float var14 = MathHelper.func_76126_a(f1 * f1 * 3.1415927f);
            final float var15 = MathHelper.func_76126_a(MathHelper.func_76129_c(f1) * 3.1415927f);
            GlStateManager.func_179109_b(-0.0f, 0.4f, 1.0f);
            GlStateManager.func_179114_b(-var15 * 22.5f, -9.0f, -0.0f, 9.0f);
            GlStateManager.func_179114_b(-var15 * 10.0f, 1.0f, -0.4f, -0.5f);
        }
        else if (HitAnimation.mode.isCurrentMode("Debug")) {
            this.func_178096_b(0.2f, f1);
            this.func_178103_d();
            GlStateManager.func_179137_b(-0.5, 0.2, 0.0);
        }
        else if (HitAnimation.mode.isCurrentMode("Vanilla")) {
            this.func_178096_b(f, 0.0f);
            this.func_178103_d();
        }
        else if (HitAnimation.mode.isCurrentMode("Luna")) {
            this.func_178096_b(f, 0.0f);
            this.func_178103_d();
            final float sin = MathHelper.func_76126_a(f1 * f1 * 3.1415927f);
            final float sin2 = MathHelper.func_76126_a(MathHelper.func_76129_c(f1) * 3.1415927f);
            GlStateManager.func_179152_a(1.0f, 1.0f, 1.0f);
            GlStateManager.func_179109_b(-0.2f, 0.45f, 0.25f);
            GlStateManager.func_179114_b(-sin2 * 20.0f, -5.0f, -5.0f, 9.0f);
        }
        else if (HitAnimation.mode.isCurrentMode("1.7")) {
            this.genCustom(f, f1);
            this.func_178103_d();
        }
        else if (HitAnimation.mode.isCurrentMode("ExhibitionSwang")) {
            this.func_178096_b(f / 2.0f, f1);
            final float var16 = MathHelper.func_76126_a(MathHelper.func_76129_c(f1) * 3.1415927f);
            GlStateManager.func_179114_b(var16 * 30.0f / 2.0f, -var16, -0.0f, 9.0f);
            GlStateManager.func_179114_b(var16 * 40.0f, 1.0f, -var16 / 2.0f, -0.0f);
            this.func_178103_d();
        }
        else if (HitAnimation.mode.isCurrentMode("ExhibitionSwank")) {
            this.func_178096_b(f / 2.0f, f1);
            final float var16 = MathHelper.func_76126_a(MathHelper.func_76129_c(f) * 3.1415927f);
            GlStateManager.func_179114_b(var16 * 30.0f, -var16, -0.0f, 9.0f);
            GlStateManager.func_179114_b(var16 * 40.0f, 1.0f, -var16, -0.0f);
            this.func_178103_d();
        }
        else if (HitAnimation.mode.isCurrentMode("ExhibitionSwong")) {
            this.func_178096_b(f / 2.0f, 0.0f);
            final float var16 = MathHelper.func_76126_a(f1 * f1 * 3.1415927f);
            final float var17 = MathHelper.func_76126_a(MathHelper.func_76129_c(f1) * 3.1415927f);
            GlStateManager.func_179114_b(-var17 * 40.0f / 2.0f, var17 / 2.0f, -0.0f, 9.0f);
            GlStateManager.func_179114_b(-var17 * 30.0f, 1.0f, var17 / 2.0f, -0.0f);
            this.func_178103_d();
        }
        else if (HitAnimation.mode.isCurrentMode("Jigsaw")) {
            this.func_178096_b(0.1f, f1);
            this.func_178103_d();
            GlStateManager.func_179137_b(-0.5, 0.0, 0.0);
        }
        else if (HitAnimation.mode.isCurrentMode("Hanabi")) {
            final float var16 = MathHelper.func_76126_a(MathHelper.func_76129_c(f1) * 3.1415927f);
            GlStateManager.func_179109_b(-0.0f, -0.3f, 0.4f);
            GlStateManager.func_179114_b(-var16 * 22.5f, -9.0f, -0.0f, 9.0f);
            GlStateManager.func_179114_b(-var16 * 10.0f, 1.0f, -0.4f, -0.5f);
        }
    }
    
    private void genCustom(final float p_178096_1_, final float p_178096_2_) {
        GlStateManager.func_179109_b(0.56f, -0.52f, -0.71999997f);
        GlStateManager.func_179109_b(0.0f, p_178096_1_ * -0.6f, 0.0f);
        GlStateManager.func_179114_b(45.0f, 0.0f, 1.0f, 0.0f);
        final float var3 = MathHelper.func_76126_a(p_178096_2_ * p_178096_2_ * 3.1415927f);
        final float var4 = MathHelper.func_76126_a(MathHelper.func_76129_c(p_178096_2_) * 3.1415927f);
        GlStateManager.func_179114_b(var3 * -34.0f, 0.0f, 1.0f, 0.2f);
        GlStateManager.func_179114_b(var4 * -20.7f, 0.2f, 0.1f, 1.0f);
        GlStateManager.func_179114_b(var4 * -68.6f, 1.3f, 0.1f, 0.2f);
        GlStateManager.func_179152_a(0.4f, 0.4f, 0.4f);
    }
    
    private boolean canBlockItem() {
        try {
            return this.field_78455_a.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemSword;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Shadow
    protected abstract void func_178103_d();
    
    @Shadow
    protected abstract void func_178095_a(final AbstractClientPlayer p0, final float p1, final float p2);
    
    @Shadow
    public abstract void func_178099_a(final EntityLivingBase p0, final ItemStack p1, final ItemCameraTransforms.TransformType p2);
    
    @Shadow
    protected abstract void func_178101_a(final float p0, final float p1);
    
    @Shadow
    public abstract void func_178097_a(final AbstractClientPlayer p0, final float p1, final float p2, final float p3);
    
    @Shadow
    protected abstract void func_178096_b(final float p0, final float p1);
    
    @Shadow
    protected abstract void func_178109_a(final AbstractClientPlayer p0);
    
    @Shadow
    protected abstract void func_178105_d(final float p0);
    
    @Shadow
    protected abstract void func_178098_a(final float p0, final AbstractClientPlayer p1);
    
    @Shadow
    protected abstract void func_178110_a(final EntityPlayerSP p0, final float p1);
    
    @Shadow
    protected abstract void func_178104_a(final AbstractClientPlayer p0, final float p1);
}
