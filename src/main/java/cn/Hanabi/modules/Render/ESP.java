package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import java.util.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import java.awt.*;
import ClassSub.*;

public class ESP extends Mod
{
    private Value<String> mode;
    private Value<Boolean> invisible;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public ESP() {
        super("ESP", Category.RENDER);
        this.mode = new Value<String>("ESP", "Mode", 0);
        this.invisible = new Value<Boolean>("ESP_Invisible", false);
        this.mode.addValue("Box");
        this.mode.addValue("2D");
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        if (this.mode.isCurrentMode("Box")) {
            this.setDisplayName("Box");
            for (final EntityPlayer next : ESP.mc.field_71441_e.field_72996_f) {
                if (next instanceof EntityPlayer) {
                    final EntityPlayer entityPlayer = (EntityPlayer)next;
                    if (entityPlayer == ESP.mc.field_71439_g || entityPlayer.field_70128_L) {
                        continue;
                    }
                    this.renderBox((Entity)entityPlayer, 0.0, 1.0, 0.0);
                }
            }
        }
        if (this.mode.isCurrentMode("2D")) {
            this.setDisplayName("2D");
            this.doOther2DESP();
        }
    }
    
    private boolean isValid(final EntityLivingBase entityLivingBase) {
        return entityLivingBase != ESP.mc.field_71439_g && entityLivingBase.func_110143_aJ() > 0.0f && entityLivingBase instanceof EntityPlayer;
    }
    
    public void renderBox(final Entity entity, final double n, final double n2, final double n3) {
        if ((entity.func_82150_aj() && !(boolean)this.invisible.getValueState()) || (KillAura.targets.contains(entity) && ((KillAura)ModManager.getModule("Killaura")).esp.getValueState())) {
            return;
        }
        ESP.mc.func_175598_ae();
        final double n4 = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * Class296.getTimer().field_74281_c - ((IRenderManager)ESP.mc.func_175598_ae()).getRenderPosX();
        ESP.mc.func_175598_ae();
        final double n5 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * Class296.getTimer().field_74281_c - ((IRenderManager)ESP.mc.func_175598_ae()).getRenderPosY();
        ESP.mc.func_175598_ae();
        Class284.drawEntityESP(n4, n5, entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * Class296.getTimer().field_74281_c - ((IRenderManager)ESP.mc.func_175598_ae()).getRenderPosZ(), entity.func_174813_aQ().field_72336_d - entity.func_174813_aQ().field_72340_a - 0.1, entity.func_174813_aQ().field_72337_e - entity.func_174813_aQ().field_72338_b + 0.25, 1.0f, 1.0f, 1.0f, 0.2f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f);
    }
    
    public static void func_181561_a(final AxisAlignedBB axisAlignedBB) {
        final Tessellator func_178181_a = Tessellator.func_178181_a();
        final WorldRenderer func_178180_c = func_178181_a.func_178180_c();
        func_178180_c.func_181668_a(3, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(3, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(1, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178181_a.func_78381_a();
    }
    
    private void doOther2DESP() {
        for (final EntityPlayer entityPlayer : ESP.mc.field_71441_e.field_73010_i) {
            if ((entityPlayer.func_82150_aj() && !(boolean)this.invisible.getValueState()) || (KillAura.targets.contains(entityPlayer) && ((KillAura)ModManager.getModule("Killaura")).esp.getValueState())) {
                return;
            }
            if (!this.isValid((EntityLivingBase)entityPlayer)) {
                continue;
            }
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glDisable(2929);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.func_179147_l();
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3553);
            final float field_74281_c = Class296.getTimer().field_74281_c;
            ESP.mc.func_175598_ae();
            final double n = entityPlayer.field_70142_S + (entityPlayer.field_70165_t - entityPlayer.field_70142_S) * field_74281_c - ((IRenderManager)ESP.mc.func_175598_ae()).getRenderPosX();
            ESP.mc.func_175598_ae();
            final double n2 = entityPlayer.field_70137_T + (entityPlayer.field_70163_u - entityPlayer.field_70137_T) * field_74281_c - ((IRenderManager)ESP.mc.func_175598_ae()).getRenderPosY();
            ESP.mc.func_175598_ae();
            final double n3 = entityPlayer.field_70136_U + (entityPlayer.field_70161_v - entityPlayer.field_70136_U) * field_74281_c - ((IRenderManager)ESP.mc.func_175598_ae()).getRenderPosZ();
            final float func_70032_d = ESP.mc.field_71439_g.func_70032_d((Entity)entityPlayer);
            Math.min(func_70032_d * 0.15f, 0.15f);
            final float n4 = 0.035f / 2.0f;
            final float n5 = (float)n;
            final float n6 = (float)n2 + entityPlayer.field_70131_O + 0.5f - (entityPlayer.func_70631_g_() ? (entityPlayer.field_70131_O / 2.0f) : 0.0f);
            final float n7 = (float)n3;
            GlStateManager.func_179109_b((float)n, (float)n2 + entityPlayer.field_70131_O + 0.5f - (entityPlayer.func_70631_g_() ? (entityPlayer.field_70131_O / 2.0f) : 0.0f), (float)n3);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.func_179114_b(-ESP.mc.func_175598_ae().field_78735_i, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(-n4, -n4, -n4);
            Tessellator.func_178181_a().func_178180_c();
            final float func_110143_aJ = entityPlayer.func_110143_aJ();
            if (func_110143_aJ <= 20.0) {
                if (func_110143_aJ < 10.0) {
                    if (func_110143_aJ >= 3.0) {}
                }
            }
            final Color color = new Color(0, 0, 0);
            final double n8 = (double)(1.5f + func_70032_d * 0.01f);
            Class284.drawRect(-30.0f, 15.0f, 30.0f, 140.0f, Class128.reAlpha(new Color(255, 255, 255).getRGB(), 0.2f));
            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GlStateManager.func_179084_k();
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glNormal3f(1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
        }
    }
    
    public static void drawBorderedRect(final float n, final float n2, final float n3, final float n4, final float n5, final int n6, final int n7) {
        drawRect(n, n2, n3, n4, n7);
        final float n8 = (n6 >> 24 & 0xFF) / 255.0f;
        final float n9 = (n6 >> 16 & 0xFF) / 255.0f;
        final float n10 = (n6 >> 8 & 0xFF) / 255.0f;
        final float n11 = (n6 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n9, n10, n11, n8);
        GL11.glLineWidth(n5);
        GL11.glBegin(1);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n, (double)n4);
        GL11.glVertex2d((double)n3, (double)n4);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n4);
        GL11.glVertex2d((double)n3, (double)n4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public static void drawRect(final float n, final float n2, final float n3, final float n4, final int n5) {
        final float n6 = (n5 >> 24 & 0xFF) / 255.0f;
        final float n7 = (n5 >> 16 & 0xFF) / 255.0f;
        final float n8 = (n5 >> 8 & 0xFF) / 255.0f;
        final float n9 = (n5 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n7, n8, n9, n6);
        GL11.glBegin(7);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n, (double)n4);
        GL11.glVertex2d((double)n3, (double)n4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
}
