package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import org.apache.logging.log4j.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.modules.*;
import net.minecraft.entity.player.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.util.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ RendererLivingEntity.class })
public abstract class MixinRendererLivingEntity<T extends EntityLivingBase> extends MixinRender implements IRendererLivingEntity
{
    @Shadow
    protected boolean field_177098_i;
    @Shadow
    protected ModelBase field_77045_g;
    @Shadow
    @Final
    private static Logger field_147923_a;
    
    public MixinRendererLivingEntity() {
        super();
        this.field_177098_i = false;
    }
    
    @Inject(method = { "renderName(Lnet/minecraft/entity/EntityLivingBase;DDD)V" }, at = { @At("HEAD") }, cancellable = true)
    public void onChat(final EntityLivingBase entity, final double x, final double y, final double z, final CallbackInfo ci) {
        if (ModManager.getModule("Nametags").isEnabled() && entity instanceof EntityPlayer) {
            ci.cancel();
        }
    }
    
    @Shadow
    protected abstract float func_77034_a(final float p0, final float p1, final float p2);
    
    @Shadow
    protected abstract float func_77040_d(final T p0, final float p1);
    
    @Shadow
    protected abstract void func_77039_a(final T p0, final double p1, final double p2, final double p3);
    
    @Shadow
    protected abstract void func_77043_a(final T p0, final float p1, final float p2, final float p3);
    
    @Shadow
    protected abstract float func_77044_a(final T p0, final float p1);
    
    @Shadow
    protected abstract void func_77041_b(final T p0, final float p1);
    
    @Shadow
    protected abstract boolean func_177088_c(final EntityLivingBase p0);
    
    @Shadow
    protected abstract void func_180565_e();
    
    @Shadow
    protected abstract void func_77036_a(final T p0, final float p1, final float p2, final float p3, final float p4, final float p5, final float p6);
    
    @Shadow
    protected abstract void func_177093_a(final T p0, final float p1, final float p2, final float p3, final float p4, final float p5, final float p6, final float p7);
    
    @Shadow
    protected abstract boolean func_177090_c(final T p0, final float p1);
    
    @Shadow
    protected abstract void func_177091_f();
    
    @Override
    public void doRenderModel(final Object entitylivingbaseIn, final float a, final float b, final float c, final float d, final float e, final float scaleFactor) {
        this.func_77036_a((EntityLivingBase)entitylivingbaseIn, a, b, c, d, e, scaleFactor);
    }
    
    @Override
    public void doRenderLayers(final Object entitylivingbaseIn, final float a, final float b, final float partialTicks, final float d, final float e, final float f, final float g) {
        this.func_177093_a((EntityLivingBase)entitylivingbaseIn, a, b, partialTicks, d, e, f, g);
    }
    
    @Overwrite
    public void func_76986_a(final T entity, final double x, final double y, final double z, final float entityYaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179129_p();
        this.field_77045_g.field_78095_p = this.func_77040_d(entity, partialTicks);
        this.field_77045_g.field_78093_q = entity.func_70115_ae();
        this.field_77045_g.field_78091_s = entity.func_70631_g_();
        try {
            float f = this.func_77034_a(entity.field_70760_ar, entity.field_70761_aq, partialTicks);
            final float f2 = this.func_77034_a(entity.field_70758_at, entity.field_70759_as, partialTicks);
            float f3 = f2 - f;
            if (this.field_77045_g.field_78093_q && entity.field_70154_o instanceof EntityLivingBase) {
                final EntityLivingBase entitylivingbase = (EntityLivingBase)entity.field_70154_o;
                f = this.func_77034_a(entitylivingbase.field_70760_ar, entitylivingbase.field_70761_aq, partialTicks);
                f3 = f2 - f;
                float f4 = MathHelper.func_76142_g(f3);
                if (f4 < -85.0f) {
                    f4 = -85.0f;
                }
                if (f4 >= 85.0f) {
                    f4 = 85.0f;
                }
                f = f2 - f4;
                if (f4 * f4 > 2500.0f) {
                    f += f4 * 0.2f;
                }
            }
            final float f5 = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * partialTicks;
            this.func_77039_a(entity, x, y, z);
            final float f6 = this.func_77044_a(entity, partialTicks);
            this.func_77043_a(entity, f6, f, partialTicks);
            GlStateManager.func_179091_B();
            GlStateManager.func_179152_a(-1.0f, -1.0f, 1.0f);
            this.func_77041_b(entity, partialTicks);
            final float f7 = 0.0625f;
            GlStateManager.func_179109_b(0.0f, -1.5078125f, 0.0f);
            float f8 = entity.field_70722_aY + (entity.field_70721_aZ - entity.field_70722_aY) * partialTicks;
            float f9 = entity.field_70754_ba - entity.field_70721_aZ * (1.0f - partialTicks);
            if (entity instanceof EntityPlayer) {
                final EventRenderLivingEntity pre = new EventRenderLivingEntity(entity, true, f9, f8, f6, f3, f5, f, f7);
                EventManager.call((Event)pre);
                if (pre.isCancelled()) {
                    return;
                }
            }
            if (entity.func_70631_g_()) {
                f9 *= 3.0f;
            }
            if (f8 > 1.0f) {
                f8 = 1.0f;
            }
            GlStateManager.func_179141_d();
            this.field_77045_g.func_78086_a((EntityLivingBase)entity, f9, f8, partialTicks);
            this.field_77045_g.func_78087_a(f9, f8, f6, f3, f5, 0.0625f, (Entity)entity);
            if (this.field_177098_i) {
                final boolean flag1 = this.func_177088_c(entity);
                this.func_77036_a(entity, f9, f8, f6, f3, f5, 0.0625f);
                if (flag1) {
                    this.func_180565_e();
                }
            }
            else {
                final boolean flag2 = this.func_177090_c(entity, partialTicks);
                this.func_77036_a(entity, f9, f8, f6, f3, f5, 0.0625f);
                if (flag2) {
                    this.func_177091_f();
                }
                GlStateManager.func_179132_a(true);
                if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).func_175149_v()) {
                    this.func_177093_a(entity, f9, f8, partialTicks, f6, f3, f5, 0.0625f);
                }
            }
            GlStateManager.func_179101_C();
        }
        catch (Exception exception) {
            MixinRendererLivingEntity.field_147923_a.error("Couldn't render entity", (Throwable)exception);
        }
        GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
        GlStateManager.func_179098_w();
        GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
        GlStateManager.func_179089_o();
        GlStateManager.func_179121_F();
        if (!this.field_177098_i) {
            super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
        }
        final EventRenderLivingEntity post = new EventRenderLivingEntity(entity, false);
        EventManager.call((Event)post);
    }
}
