package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.*;
import net.minecraft.client.shader.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.*;
import java.io.*;
import com.google.gson.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.lwjgl.opengl.*;
import org.spongepowered.asm.mixin.injection.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Combat.*;
import com.google.common.base.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ EntityRenderer.class })
public abstract class MixinEntityRenderer implements IEntityRenderer
{
    @Shadow
    private Minecraft field_78531_r;
    @Shadow
    private Entity field_78528_u;
    @Shadow
    private int field_147713_ae;
    @Shadow
    private boolean field_175083_ad;
    @Shadow
    private ShaderGroup field_147707_d;
    @Shadow
    private IResourceManager field_147711_ac;
    @Shadow
    private static Logger field_147710_q;
    @Shadow
    public static int field_147708_e;
    
    public MixinEntityRenderer() {
        super();
    }
    
    @Shadow
    protected abstract void func_78479_a(final float p0, final int p1);
    
    @Override
    public void runSetupCameraTransform(final float partialTicks, final int pass) {
        this.func_78479_a(partialTicks, pass);
    }
    
    @Override
    public void loadShader2(final ResourceLocation resourceLocationIn) {
        if (OpenGlHelper.func_148822_b()) {
            try {
                (this.field_147707_d = new ShaderGroup(this.field_78531_r.func_110434_K(), this.field_147711_ac, this.field_78531_r.func_147110_a(), resourceLocationIn)).func_148026_a(this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
                this.field_175083_ad = true;
            }
            catch (IOException ioexception) {
                MixinEntityRenderer.field_147710_q.warn("Failed to load shader: " + resourceLocationIn, (Throwable)ioexception);
                this.field_147713_ae = MixinEntityRenderer.field_147708_e;
                this.field_175083_ad = false;
            }
            catch (JsonSyntaxException jsonsyntaxexception) {
                MixinEntityRenderer.field_147710_q.warn("Failed to load shader: " + resourceLocationIn, (Throwable)jsonsyntaxexception);
                this.field_147713_ae = MixinEntityRenderer.field_147708_e;
                this.field_175083_ad = false;
            }
        }
    }
    
    @Inject(method = { "renderWorldPass" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableFog()V", shift = At.Shift.AFTER) })
    private void eventRender3D(final int pass, final float partialTicks, final long finishTimeNano, final CallbackInfo callbackInfo) {
        final EventRender eventRender = new EventRender(pass, partialTicks, finishTimeNano);
        EventManager.call((Event)eventRender);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    @Overwrite
    public void func_78473_a(final float p_getMouseOver_1_) {
        final Entity entity = this.field_78531_r.func_175606_aa();
        if (entity != null && this.field_78531_r.field_71441_e != null) {
            this.field_78531_r.field_71424_I.func_76320_a("pick");
            this.field_78531_r.field_147125_j = null;
            double d0 = ModManager.getModule("Reach").getState() ? Reach.getReach() : ((double)this.field_78531_r.field_71442_b.func_78757_d());
            this.field_78531_r.field_71476_x = entity.func_174822_a(ModManager.getModule("Reach").getState() ? Reach.getReach() : d0, p_getMouseOver_1_);
            double d2 = d0;
            final Vec3 vec3 = entity.func_174824_e(p_getMouseOver_1_);
            boolean flag = false;
            if (this.field_78531_r.field_71442_b.func_78749_i()) {
                d0 = 6.0;
                d2 = 6.0;
            }
            else if (d0 > 3.0) {
                flag = true;
            }
            if (this.field_78531_r.field_71476_x != null) {
                d2 = this.field_78531_r.field_71476_x.field_72307_f.func_72438_d(vec3);
            }
            if (ModManager.getModule("Reach").getState()) {
                d2 = Reach.getReach();
                final MovingObjectPosition vec4 = entity.func_174822_a(d2, p_getMouseOver_1_);
                if (vec4 != null) {
                    d2 = vec4.field_72307_f.func_72438_d(vec3);
                }
            }
            final Vec3 var24 = entity.func_70676_i(p_getMouseOver_1_);
            final Vec3 vec5 = vec3.func_72441_c(var24.field_72450_a * d0, var24.field_72448_b * d0, var24.field_72449_c * d0);
            this.field_78528_u = null;
            Vec3 vec6 = null;
            final float f = 1.0f;
            final List list = this.field_78531_r.field_71441_e.func_175674_a(entity, entity.func_174813_aQ().func_72321_a(var24.field_72450_a * d0, var24.field_72448_b * d0, var24.field_72449_c * d0).func_72314_b((double)f, (double)f, (double)f), Predicates.and(EntitySelectors.field_180132_d, MixinEntityRenderer::lambda$getMouseOver$0));
            double d3 = d2;
            for (int j = 0; j < list.size(); ++j) {
                final Entity entity2 = (Entity)list.get(j);
                final float f2 = entity2.func_70111_Y();
                final AxisAlignedBB axisalignedbb = entity2.func_174813_aQ().func_72314_b((double)f2, (double)f2, (double)f2);
                final MovingObjectPosition movingobjectposition = axisalignedbb.func_72327_a(vec3, vec5);
                if (axisalignedbb.func_72318_a(vec3)) {
                    if (d3 >= 0.0) {
                        this.field_78528_u = entity2;
                        vec6 = ((movingobjectposition == null) ? vec3 : movingobjectposition.field_72307_f);
                        d3 = 0.0;
                    }
                }
                else if (movingobjectposition != null) {
                    final double d4 = vec3.func_72438_d(movingobjectposition.field_72307_f);
                    if (d4 < d3 || d3 == 0.0) {
                        if (entity2 == entity.field_70154_o) {
                            if (d3 == 0.0) {
                                this.field_78528_u = entity2;
                                vec6 = movingobjectposition.field_72307_f;
                            }
                        }
                        else {
                            this.field_78528_u = entity2;
                            vec6 = movingobjectposition.field_72307_f;
                            d3 = d4;
                        }
                    }
                }
            }
            if (this.field_78528_u != null && flag && vec3.func_72438_d(vec6) > (ModManager.getModule("Reach").getState() ? Reach.getReach() : 3.0)) {
                this.field_78528_u = null;
                this.field_78531_r.field_71476_x = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, vec6, (EnumFacing)null, new BlockPos(vec6));
            }
            if (this.field_78528_u != null && (d3 < d2 || this.field_78531_r.field_71476_x == null)) {
                this.field_78531_r.field_71476_x = new MovingObjectPosition(this.field_78528_u, vec6);
                if (this.field_78528_u instanceof EntityLivingBase || this.field_78528_u instanceof EntityItemFrame) {
                    this.field_78531_r.field_147125_j = this.field_78528_u;
                }
            }
            this.field_78531_r.field_71424_I.func_76319_b();
        }
    }
    
    private static boolean lambda$getMouseOver$0(final Entity p_apply_1_) {
        return p_apply_1_.func_70067_L();
    }
}
