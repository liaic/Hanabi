package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import java.awt.*;
import cn.Hanabi.injection.interfaces.*;
import ClassSub.*;
import net.minecraft.client.renderer.entity.*;

public class Chams extends Mod
{
    public Class320 hue;
    public Value<Boolean> rainbow;
    public Value<Boolean> flat;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Chams() {
        super("Chams", Category.RENDER);
        this.hue = new Class320(0);
        this.rainbow = new Value<Boolean>("Chams_Rainbow", false);
        this.flat = new Value<Boolean>("Chams_Flat", false);
    }
    
    @EventTarget
    public void onRender3D(final EventRender eventRender) {
        this.hue.interp(255.0f, 1);
        if (this.hue.getOpacity() >= 255.0f) {
            this.hue.setOpacity(0.0f);
        }
    }
    
    @EventTarget(1)
    public void onRenderEntity(final EventRenderLivingEntity eventRenderLivingEntity) {
        final boolean booleanValue = (boolean)this.rainbow.getValueState();
        if (eventRenderLivingEntity.getEntity() instanceof EntityPlayer && eventRenderLivingEntity.getEntity() != Chams.mc.field_71439_g && eventRenderLivingEntity.isPre()) {
            if (booleanValue) {
                eventRenderLivingEntity.setCancelled(true);
                try {
                    final Render func_78713_a = Chams.mc.func_175598_ae().func_78713_a((Entity)eventRenderLivingEntity.getEntity());
                    if (func_78713_a != null && Chams.mc.func_175598_ae().field_78724_e != null && func_78713_a instanceof RendererLivingEntity) {
                        GL11.glPushMatrix();
                        GL11.glDisable(2929);
                        GL11.glBlendFunc(770, 771);
                        GL11.glDisable(3553);
                        GL11.glEnable(3042);
                        if ((boolean)this.flat.getValueState()) {
                            GlStateManager.func_179140_f();
                        }
                        final Color hsbColor = Color.getHSBColor(this.hue.getOpacity() / 255.0f, 0.8f, 1.0f);
                        this.glColor(1.0f, hsbColor.getRed(), hsbColor.getGreen(), hsbColor.getBlue());
                        ((IRendererLivingEntity)func_78713_a).doRenderModel(eventRenderLivingEntity.getEntity(), eventRenderLivingEntity.getLimbSwing(), eventRenderLivingEntity.getLimbSwingAmount(), eventRenderLivingEntity.getAgeInTicks(), eventRenderLivingEntity.getRotationYawHead(), eventRenderLivingEntity.getRotationPitch(), eventRenderLivingEntity.getOffset());
                        GL11.glEnable(2929);
                        float n = 255.0f - this.hue.getOpacity();
                        if (n > 255.0f) {
                            n = 1.0f;
                        }
                        if (n < 0.0f) {
                            n = 255.0f;
                        }
                        final Color hsbColor2 = Color.getHSBColor(n / 255.0f, 0.8f, 1.0f);
                        this.glColor(1.0f, hsbColor2.getRed(), hsbColor2.getGreen(), hsbColor2.getBlue());
                        ((IRendererLivingEntity)func_78713_a).doRenderModel(eventRenderLivingEntity.getEntity(), eventRenderLivingEntity.getLimbSwing(), eventRenderLivingEntity.getLimbSwingAmount(), eventRenderLivingEntity.getAgeInTicks(), eventRenderLivingEntity.getRotationYawHead(), eventRenderLivingEntity.getRotationPitch(), eventRenderLivingEntity.getOffset());
                        GL11.glEnable(3553);
                        GL11.glDisable(3042);
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                        if ((boolean)this.flat.getValueState()) {
                            GlStateManager.func_179145_e();
                        }
                        GL11.glPopMatrix();
                        ((IRendererLivingEntity)func_78713_a).doRenderLayers(eventRenderLivingEntity.getEntity(), eventRenderLivingEntity.getLimbSwing(), eventRenderLivingEntity.getLimbSwingAmount(), Class296.getTimer().field_74281_c, eventRenderLivingEntity.getAgeInTicks(), eventRenderLivingEntity.getRotationYawHead(), eventRenderLivingEntity.getRotationPitch(), eventRenderLivingEntity.getOffset());
                        GL11.glPopMatrix();
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else {
                GL11.glEnable(32823);
                GL11.glPolygonOffset(1.0f, -1100000.0f);
            }
        }
        else if (!booleanValue && eventRenderLivingEntity.getEntity() instanceof EntityPlayer && eventRenderLivingEntity.isPost()) {
            GL11.glDisable(32823);
            GL11.glPolygonOffset(1.0f, 1100000.0f);
        }
    }
    
    public void glColor(final float n, final int n2, final int n3, final int n4) {
        GL11.glColor4f(0.003921569f * (float)n2, 0.003921569f * (float)n3, 0.003921569f * (float)n4, n);
    }
}
