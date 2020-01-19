package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.injection.interfaces.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.modules.World.*;
import java.util.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import ClassSub.*;
import net.minecraft.item.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;

public class Nametags extends Mod
{
    private Value<Boolean> invisible;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Nametags() {
        super("Nametags", Category.RENDER);
        this.invisible = new Value<Boolean>("Nametags_Invisible", false);
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        for (final EntityPlayer entityPlayer : Nametags.mc.field_71441_e.field_73010_i) {
            if (entityPlayer != Nametags.mc.field_71439_g) {
                this.renderNameTag(entityPlayer, entityPlayer.func_70005_c_(), entityPlayer.field_70142_S + (entityPlayer.field_70165_t - entityPlayer.field_70142_S) * Class296.getTimer().field_74281_c - ((IRenderManager)Nametags.mc.func_175598_ae()).getRenderPosX(), entityPlayer.field_70137_T + (entityPlayer.field_70163_u - entityPlayer.field_70137_T) * Class296.getTimer().field_74281_c - ((IRenderManager)Nametags.mc.func_175598_ae()).getRenderPosY(), entityPlayer.field_70136_U + (entityPlayer.field_70161_v - entityPlayer.field_70136_U) * Class296.getTimer().field_74281_c - ((IRenderManager)Nametags.mc.func_175598_ae()).getRenderPosZ());
            }
        }
    }
    
    private void renderNameTag(final EntityPlayer entityPlayer, String func_150260_c, final double n, double n2, final double n3) {
        if (entityPlayer.func_82150_aj() && !(boolean)this.invisible.getValueState()) {
            return;
        }
        final FontRenderer field_71466_p = Nametags.mc.field_71466_p;
        float n4 = Nametags.mc.field_71439_g.func_70032_d((Entity)entityPlayer) / 6.0f;
        if (n4 < 0.8f) {
            n4 = 0.8f;
        }
        n2 += (entityPlayer.func_70093_af() ? 0.5 : 0.7);
        final float n5 = n4 * 2.0f / 100.0f;
        func_150260_c = entityPlayer.func_145748_c_().func_150260_c();
        String s;
        if (AntiBot.isBot((Entity)entityPlayer)) {
            s = "§9[BOT]";
        }
        else {
            s = "";
        }
        String s2;
        if (Teams.isOnSameTeam((Entity)entityPlayer)) {
            s2 = "§b[TEAM]";
        }
        else {
            s2 = "";
        }
        if (Teams.isClientFriend((Entity)entityPlayer)) {
            s2 = "§e[Friend]";
        }
        String string = "";
        for (final String s3 : new ArrayList<Object>(IRC.UserMap.keySet())) {
            Class295.tellPlayer(s3);
            if (func_150260_c.contains(s3)) {
                string = "§e[" + s3 + "]";
            }
        }
        if ((s2 + s).equals("")) {
            s2 = "§a";
        }
        final String string2 = s2 + s + func_150260_c + string;
        final String string3 = "§7HP:" + (int)entityPlayer.func_110143_aJ();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 1.4f, (float)n3);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-Nametags.mc.func_175598_ae().field_78735_i, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(Nametags.mc.func_175598_ae().field_78732_j, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(-n5, -n5, n5);
        Class167.setGLCap(2896, false);
        Class167.setGLCap(2929, false);
        final int n6 = Nametags.mc.field_71466_p.func_78256_a(string2) / 2;
        Class167.setGLCap(3042, true);
        GL11.glBlendFunc(770, 771);
        this.drawBorderedRectNameTag(-n6 - 2, -(Nametags.mc.field_71466_p.field_78288_b + 9), n6 + 2, 2.0f, 1.0f, Class128.reAlpha(Color.BLACK.getRGB(), 0.3f), Class128.reAlpha(Color.BLACK.getRGB(), 0.3f));
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        field_71466_p.func_78276_b(string2, -n6, -(Nametags.mc.field_71466_p.field_78288_b + 8), -1);
        field_71466_p.func_78276_b(string3, -Nametags.mc.field_71466_p.func_78256_a(string3) / 2, -(Nametags.mc.field_71466_p.field_78288_b - 2), -1);
        int rgb = new Color(188, 0, 0).getRGB();
        if (entityPlayer.func_110143_aJ() > 20.0f) {
            rgb = -65292;
        }
        Class284.drawRect(n6 + (float)Math.ceil(entityPlayer.func_110143_aJ() + entityPlayer.func_110139_bj()) / (entityPlayer.func_110138_aP() + entityPlayer.func_110139_bj()) * n6 * 2.0f - n6 * 2 + 2.0f, 2.0f, -n6 - 2, 0.9f, rgb);
        GL11.glPushMatrix();
        int n7 = 0;
        final ItemStack[] field_70460_b = entityPlayer.field_71071_by.field_70460_b;
        for (int length = field_70460_b.length, i = 0; i < length; ++i) {
            if (field_70460_b[i] != null) {
                n7 -= 11;
            }
        }
        if (entityPlayer.func_70694_bm() != null) {
            n7 -= 8;
            final ItemStack func_77946_l = entityPlayer.func_70694_bm().func_77946_l();
            if (((ItemStack)func_77946_l).func_77962_s() && (((ItemStack)func_77946_l).func_77973_b() instanceof ItemTool || ((ItemStack)func_77946_l).func_77973_b() instanceof ItemArmor)) {
                ((ItemStack)func_77946_l).field_77994_a = 1;
            }
            this.renderItemStack(func_77946_l, n7, -35);
            n7 += 20;
        }
        for (final ItemStack itemStack : entityPlayer.field_71071_by.field_70460_b) {
            if (itemStack != null) {
                final ItemStack func_77946_l2 = itemStack.func_77946_l();
                if (func_77946_l2.func_77962_s() && (func_77946_l2.func_77973_b() instanceof ItemTool || func_77946_l2.func_77973_b() instanceof ItemArmor)) {
                    func_77946_l2.field_77994_a = 1;
                }
                this.renderItemStack(func_77946_l2, n7, -35);
                n7 += 20;
            }
        }
        GL11.glPopMatrix();
        Class167.revertAllCaps();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
    public void renderItemStack(final ItemStack itemStack, final int n, final int n2) {
        GL11.glPushMatrix();
        GL11.glDepthMask(true);
        GlStateManager.func_179086_m(256);
        RenderHelper.func_74519_b();
        Nametags.mc.func_175599_af().field_77023_b = -150.0f;
        this.whatTheFuckOpenGLThisFixesItemGlint();
        Nametags.mc.func_175599_af().func_180450_b(itemStack, n, n2);
        Nametags.mc.func_175599_af().func_175030_a(Nametags.mc.field_71466_p, itemStack, n, n2);
        Nametags.mc.func_175599_af().field_77023_b = 0.0f;
        RenderHelper.func_74518_a();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        GlStateManager.func_179084_k();
        GlStateManager.func_179140_f();
        GlStateManager.func_179139_a(0.5, 0.5, 0.5);
        GlStateManager.func_179097_i();
        GlStateManager.func_179126_j();
        GlStateManager.func_179152_a(2.0f, 2.0f, 2.0f);
        GL11.glPopMatrix();
    }
    
    private void whatTheFuckOpenGLThisFixesItemGlint() {
        GlStateManager.func_179140_f();
        GlStateManager.func_179097_i();
        GlStateManager.func_179084_k();
        GlStateManager.func_179145_e();
        GlStateManager.func_179126_j();
        GlStateManager.func_179140_f();
        GlStateManager.func_179097_i();
        GlStateManager.func_179090_x();
        GlStateManager.func_179118_c();
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179141_d();
        GlStateManager.func_179098_w();
        GlStateManager.func_179145_e();
        GlStateManager.func_179126_j();
    }
    
    public void drawBorderedRectNameTag(final float n, final float n2, final float n3, final float n4, final float n5, final int n6, final int n7) {
        Class284.drawRect(n, n2, n3, n4, n7);
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
}
