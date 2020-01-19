package cn.Hanabi.modules.Render;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import ClassSub.*;
import org.lwjgl.opengl.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import net.minecraft.item.*;
import java.util.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class Projectiles extends Mod
{
    private EntityLivingBase entity;
    private MovingObjectPosition blockCollision;
    private MovingObjectPosition entityCollision;
    private static AxisAlignedBB aim;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Projectiles() {
        super("Projectiles", Category.RENDER);
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        if (Projectiles.mc.field_71439_g.field_71071_by.func_70448_g() != null) {
            final EntityPlayerSP field_71439_g = Projectiles.mc.field_71439_g;
            final ItemStack func_70448_g = field_71439_g.field_71071_by.func_70448_g();
            final int func_150891_b = Item.func_150891_b(Projectiles.mc.field_71439_g.func_70694_bm().func_77973_b());
            if (func_150891_b == 261 || func_150891_b == 368 || func_150891_b == 332 || func_150891_b == 344) {
                double n = field_71439_g.field_70142_S + (field_71439_g.field_70165_t - field_71439_g.field_70142_S) * Class296.getTimer().field_74281_c - Math.cos(Math.toRadians((double)field_71439_g.field_70177_z)) * 0.1599999964237213;
                double n2 = field_71439_g.field_70137_T + (field_71439_g.field_70163_u - field_71439_g.field_70137_T) * Class296.getTimer().field_74281_c + field_71439_g.func_70047_e() - 0.1;
                double n3 = field_71439_g.field_70136_U + (field_71439_g.field_70161_v - field_71439_g.field_70136_U) * Class296.getTimer().field_74281_c - Math.sin(Math.toRadians((double)field_71439_g.field_70177_z)) * 0.1599999964237213;
                final double n4 = (func_70448_g.func_77973_b() instanceof ItemBow) ? 1.0 : 0.4000000059604645;
                final double radians = Math.toRadians(field_71439_g.field_70177_z);
                final double radians2 = Math.toRadians(field_71439_g.field_70125_A);
                final double n5 = -Math.sin(radians) * Math.cos(radians2) * n4;
                final double n6 = -Math.sin(radians2) * n4;
                final double n7 = Math.cos(radians) * Math.cos(radians2) * n4;
                final double sqrt = Math.sqrt(n5 * n5 + n6 * n6 + n7 * n7);
                final double n8 = n5 / sqrt;
                final double n9 = n6 / sqrt;
                final double n10 = n7 / sqrt;
                double n14;
                double n15;
                double n16;
                if (func_70448_g.func_77973_b() instanceof ItemBow) {
                    final float n11 = (72000 - field_71439_g.func_71052_bv()) / 20.0f;
                    float n12 = (n11 * n11 + n11 * 2.0f) / 3.0f;
                    if (n12 > 1.0f) {
                        n12 = 1.0f;
                    }
                    final float n13 = n12 * 3.0f;
                    n14 = n8 * n13;
                    n15 = n9 * n13;
                    n16 = n10 * n13;
                }
                else {
                    n14 = n8 * 1.5;
                    n15 = n9 * 1.5;
                    n16 = n10 * 1.5;
                }
                GL11.glPushMatrix();
                GL11.glDisable(3553);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDisable(2929);
                GL11.glDepthMask(false);
                GL11.glEnable(2848);
                GL11.glLineWidth(2.0f);
                final double n17 = (func_70448_g.func_77973_b() instanceof ItemBow) ? 0.05 : 0.03;
                GL11.glColor4f(0.0f, 1.0f, 0.2f, 0.5f);
                GL11.glBegin(3);
                for (int i = 0; i < 2000; ++i) {
                    GL11.glVertex3d(n - ((IRenderManager)Projectiles.mc.func_175598_ae()).getRenderPosX(), n2 - ((IRenderManager)Projectiles.mc.func_175598_ae()).getRenderPosY(), n3 - ((IRenderManager)Projectiles.mc.func_175598_ae()).getRenderPosZ());
                    n += n14 * 0.1;
                    n2 += n15 * 0.1;
                    n3 += n16 * 0.1;
                    n14 *= 0.999;
                    final double n18 = n15 * 0.999;
                    n16 *= 0.999;
                    n15 = n18 - n17 * 0.1;
                    final Vec3 vec3 = new Vec3(field_71439_g.field_70165_t, field_71439_g.field_70163_u + field_71439_g.func_70047_e(), field_71439_g.field_70161_v);
                    this.blockCollision = Projectiles.mc.field_71441_e.func_72933_a(vec3, new Vec3(n, n2, n3));
                    for (final Entity entity : Projectiles.mc.field_71441_e.func_72910_y()) {
                        if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayerSP)) {
                            this.entity = (EntityLivingBase)entity;
                            this.entityCollision = this.entity.func_174813_aQ().func_72314_b(0.3, 0.3, 0.3).func_72327_a(vec3, new Vec3(n, n2, n3));
                            if (this.entityCollision != null) {
                                this.blockCollision = this.entityCollision;
                            }
                            if (this.entityCollision != null) {
                                GL11.glColor4f(1.0f, 0.0f, 0.2f, 0.5f);
                            }
                            if (this.entityCollision == null) {
                                continue;
                            }
                            this.blockCollision = this.entityCollision;
                        }
                    }
                    if (this.blockCollision != null) {
                        break;
                    }
                }
                GL11.glEnd();
                final double n19 = n - ((IRenderManager)Projectiles.mc.func_175598_ae()).getRenderPosX();
                final double n20 = n2 - ((IRenderManager)Projectiles.mc.func_175598_ae()).getRenderPosY();
                final double n21 = n3 - ((IRenderManager)Projectiles.mc.func_175598_ae()).getRenderPosZ();
                GL11.glPushMatrix();
                GL11.glTranslated(n19 - 0.5, n20 - 0.5, n21 - 0.5);
                switch (this.blockCollision.field_178784_b.func_176745_a()) {
                    case 2:
                    case 3: {
                        GlStateManager.func_179114_b(90.0f, 1.0f, 0.0f, 0.0f);
                        Projectiles.aim = new AxisAlignedBB(0.0, 0.5, -1.0, 1.0, 0.45, 0.0);
                        break;
                    }
                    case 4:
                    case 5: {
                        GlStateManager.func_179114_b(90.0f, 0.0f, 0.0f, 1.0f);
                        Projectiles.aim = new AxisAlignedBB(0.0, -0.5, 0.0, 1.0, -0.45, 1.0);
                        break;
                    }
                    default: {
                        Projectiles.aim = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 0.45, 1.0);
                        break;
                    }
                }
                drawBox(Projectiles.aim);
                func_181561_a(Projectiles.aim);
                GL11.glPopMatrix();
                GL11.glDisable(3042);
                GL11.glEnable(3553);
                GL11.glEnable(2929);
                GL11.glDepthMask(true);
                GL11.glDisable(2848);
                GL11.glPopMatrix();
            }
        }
    }
    
    public static void drawBox(final AxisAlignedBB axisAlignedBB) {
        GL11.glBegin(7);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glEnd();
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
}
