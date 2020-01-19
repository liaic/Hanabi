package cn.Hanabi.modules.World;

import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import java.awt.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.boss.*;
import ClassSub.*;
import java.util.*;

public class HideAndSeek extends Mod
{
    public static List<EntityLivingBase> kids;
    public Class191 timer;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public HideAndSeek() {
        super("HideAndSeek", Category.WORLD);
        this.timer = new Class191();
    }
    
    public void onEnable() {
        HideAndSeek.kids.clear();
    }
    
    public void onDisable() {
        HideAndSeek.kids.clear();
    }
    
    @EventTarget
    public void onChat(final EventChat eventChat) {
        if (eventChat.getMessage().contains("躲猫猫")) {
            this.timer.reset();
        }
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        for (final EntityLivingBase entityLivingBase : HideAndSeek.kids) {
            if (entityLivingBase == null) {
                return;
            }
            final Color color = new Color(Class59.DARKRED.c);
            HideAndSeek.mc.func_175598_ae();
            final double n = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * Class296.getTimer().field_74281_c - ((IRenderManager)HideAndSeek.mc.func_175598_ae()).getRenderPosX();
            HideAndSeek.mc.func_175598_ae();
            final double n2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * Class296.getTimer().field_74281_c - ((IRenderManager)HideAndSeek.mc.func_175598_ae()).getRenderPosY();
            HideAndSeek.mc.func_175598_ae();
            final double n3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * Class296.getTimer().field_74281_c - ((IRenderManager)HideAndSeek.mc.func_175598_ae()).getRenderPosZ();
            if (entityLivingBase instanceof EntityPlayer) {
                final double n4 = entityLivingBase.func_70093_af() ? 0.25 : 0.0;
                GL11.glPushMatrix();
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glTranslated(0.0, -0.25 * (double)(Math.abs(entityLivingBase.field_70125_A) / 90.0f), 0.0);
                final double n5;
                final double n6;
                final double n7;
                GL11.glTranslated((n5 = n - 0.275) + 0.275, (n6 = n2 + (entityLivingBase.func_70047_e() - 0.225 - n4)) + 0.275, (n7 = n3 - 0.275) + 0.275);
                GL11.glRotated((double)(-entityLivingBase.field_70177_z % 360.0f), 0.0, 1.0, 0.0);
                GL11.glTranslated(-(n5 + 0.275), -(n6 + 0.275), -(n7 + 0.275));
                GL11.glTranslated(n5 + 0.275, n6 + 0.275, n7 + 0.275);
                GL11.glRotated((double)entityLivingBase.field_70125_A, 1.0, 0.0, 0.0);
                GL11.glTranslated(-(n5 + 0.275), -(n6 + 0.275), -(n7 + 0.275));
                GL11.glDisable(3553);
                GL11.glEnable(2848);
                GL11.glDisable(2929);
                GL11.glDepthMask(false);
                GL11.glColor4f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, 1.0f);
                GL11.glLineWidth(1.0f);
                Class284.drawOutlinedBoundingBox(new AxisAlignedBB(n5 - 0.0025, n6 - 0.0025, n7 - 0.0025, n5 + 0.55 + 0.0025, n6 + 0.55 + 0.0025, n7 + 0.55 + 0.0025));
                GL11.glColor4f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, 0.5f);
                Class284.drawBoundingBox(new AxisAlignedBB(n5 - 0.0025, n6 - 0.0025, n7 - 0.0025, n5 + 0.55 + 0.0025, n6 + 0.55 + 0.0025, n7 + 0.55 + 0.0025));
                GL11.glDisable(2848);
                GL11.glEnable(3553);
                GL11.glEnable(2929);
                GL11.glDepthMask(true);
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            else {
                Class284.drawEntityESP(n, n2, n3, entityLivingBase.func_174813_aQ().field_72336_d - entityLivingBase.func_174813_aQ().field_72340_a, entityLivingBase.func_174813_aQ().field_72337_e - entityLivingBase.func_174813_aQ().field_72338_b + 0.25, 1.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.5f, 1.0f, 1.0f, 2.0f);
            }
        }
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        for (final Entity entity : HideAndSeek.mc.field_71441_e.field_72996_f) {
            if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArmorStand) && !(entity instanceof EntityWither) && !HideAndSeek.kids.contains(entity) && !entity.func_70005_c_().contains("§c§l") && this.timer.isDelayComplete(5000L)) {
                final double n = entity.field_70163_u - (int)entity.field_70163_u;
                if (n <= 0.1 || (n + "").length() <= 8) {
                    continue;
                }
                HideAndSeek.kids.add((EntityLivingBase)entity);
                Class295.tellPlayer("§b[Hanabi]§a检测到一个异常动物:" + entity.func_70005_c_());
            }
        }
        for (final EntityLivingBase entityLivingBase : HideAndSeek.kids) {
            if (entityLivingBase.field_70128_L || entityLivingBase.func_110143_aJ() < 0.0f) {
                HideAndSeek.kids.remove(entityLivingBase);
            }
        }
    }
    
    static {
        HideAndSeek.kids = new ArrayList<EntityLivingBase>();
    }
}
