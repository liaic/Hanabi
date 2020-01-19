package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.client.renderer.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import java.awt.*;
import cn.Hanabi.utils.fontmanager.*;
import ClassSub.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.*;
import org.lwjgl.*;
import org.lwjgl.util.glu.*;
import org.lwjgl.opengl.*;
import java.nio.*;
import java.util.*;

public class Nametags_ extends Mod
{
    public static Map<EntityLivingBase, double[]> entityPositions;
    public Value<Boolean> invis;
    public Value<Boolean> armor;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Nametags_() {
        super("Nametags", Category.RENDER);
        this.invis = new Value<Boolean>("Nametags_Invisible", false);
        this.armor = new Value<Boolean>("Nametags_Armor", false);
    }
    
    @EventTarget
    public void update(final EventRender eventRender) {
        try {
            this.updatePositions();
        }
        catch (Exception ex) {}
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D eventRender2D) {
        GlStateManager.func_179094_E();
        final ScaledResolution scaledResolution = new ScaledResolution(Nametags_.mc);
        for (final Entity entity : Nametags_.entityPositions.keySet()) {
            if (entity != Nametags_.mc.field_71439_g && (this.invis.getValueState() || !entity.func_82150_aj())) {
                GlStateManager.func_179094_E();
                if (entity instanceof EntityPlayer) {
                    final double[] array = (double[])Nametags_.entityPositions.get(entity);
                    if (array[3] < 0.0 || array[3] >= 1.0) {
                        GlStateManager.func_179121_F();
                        continue;
                    }
                    final UnicodeFontRenderer wqy18 = Hanabi.INSTANCE.fontManager.wqy18;
                    GlStateManager.func_179137_b(array[0] / (double)scaledResolution.func_78325_e(), array[1] / (double)scaledResolution.func_78325_e(), 0.0);
                    this.scale();
                    GlStateManager.func_179137_b(0.0, -2.5, 0.0);
                    final String string = "Health: " + String.valueOf(Math.round(((EntityLivingBase)entity).func_110143_aJ() * 10.0f) / 10);
                    final String string2 = (AntiBot.isBot(entity) ? "§9[BOT]" : "") + (Teams.isOnSameTeam(entity) ? "§b[TEAM]" : "") + "§r" + entity.func_145748_c_().func_150260_c();
                    String string3 = "";
                    for (final String s : IRC.UserMap.keySet()) {
                        if (entity.func_70005_c_().equalsIgnoreCase(s)) {
                            string3 = "§e[" + IRC.UserMap.get(s) + "]";
                        }
                    }
                    final String string4 = string2 + string3;
                    final float n = (float)wqy18.func_78256_a(string4.replaceAll("§.", ""));
                    final float n2 = (float)Hanabi.INSTANCE.fontManager.comfortaa12.func_78256_a(string);
                    final float n3 = ((n > n2) ? n : n2) + 8.0f;
                    Class284.drawRect(-n3 / 2.0f, -25.0f, n3 / 2.0f, 0.0f, Class59.getColor(0, 130));
                    final int n4 = (int)(array[0] + -n3 / 2.0f - 3.0) / 2 - 26;
                    final int n5 = (int)(array[0] + n3 / 2.0f + 3.0) / 2 + 20;
                    final int n6 = (int)(array[1] - 30.0) / 2;
                    final int n7 = (int)(array[1] + 11.0) / 2;
                    final int n8 = scaledResolution.func_78328_b() / 2;
                    final int n9 = scaledResolution.func_78326_a() / 2;
                    wqy18.drawStringWithColor(string4, -n3 / 2.0f + 4.0f, -22.0f, Class59.WHITE.c);
                    Hanabi.INSTANCE.fontManager.comfortaa12.drawString(string, -n3 / 2.0f + 4.0f, -10.0f, Class59.WHITE.c);
                    final EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
                    Class284.drawRect(-n3 / 2.0f, -1.0f, n3 / 2.0f - n3 / 2.0f * (1.0f - (float)Math.ceil(entityLivingBase.func_110143_aJ() + entityLivingBase.func_110139_bj()) / (entityLivingBase.func_110138_aP() + entityLivingBase.func_110139_bj())) * 2.0f, 0.0f, Class59.RED.c);
                    if ((boolean)this.armor.getValueState()) {
                        final ArrayList<ItemStack> list = new ArrayList<ItemStack>();
                        for (int i = 0; i < 5; ++i) {
                            final ItemStack func_71124_b = ((EntityPlayer)entity).func_71124_b(i);
                            if (func_71124_b != null) {
                                list.add(func_71124_b);
                            }
                        }
                        int n10 = -(list.size() * 9);
                        for (final ItemStack itemStack : list) {
                            RenderHelper.func_74520_c();
                            Nametags_.mc.func_175599_af().func_175042_a(itemStack, n10 + 6, -42);
                            Nametags_.mc.func_175599_af().func_175030_a(Nametags_.mc.field_71466_p, itemStack, n10, -42);
                            n10 += 3;
                            RenderHelper.func_74518_a();
                            if (itemStack != null) {
                                int n11 = 21;
                                final int func_77506_a = EnchantmentHelper.func_77506_a(Enchantment.field_180314_l.field_77352_x, itemStack);
                                final int func_77506_a2 = EnchantmentHelper.func_77506_a(Enchantment.field_77334_n.field_77352_x, itemStack);
                                final int func_77506_a3 = EnchantmentHelper.func_77506_a(Enchantment.field_180313_o.field_77352_x, itemStack);
                                if (func_77506_a > 0) {
                                    this.drawEnchantTag("Sh" + this.getColor(func_77506_a) + func_77506_a, n10, n11);
                                    n11 += 6;
                                }
                                if (func_77506_a2 > 0) {
                                    this.drawEnchantTag("Fir" + this.getColor(func_77506_a2) + func_77506_a2, n10, n11);
                                    n11 += 6;
                                }
                                if (func_77506_a3 > 0) {
                                    this.drawEnchantTag("Kb" + this.getColor(func_77506_a3) + func_77506_a3, n10, n11);
                                }
                                else if (itemStack.func_77973_b() instanceof ItemArmor) {
                                    final int func_77506_a4 = EnchantmentHelper.func_77506_a(Enchantment.field_180310_c.field_77352_x, itemStack);
                                    final int func_77506_a5 = EnchantmentHelper.func_77506_a(Enchantment.field_92091_k.field_77352_x, itemStack);
                                    final int func_77506_a6 = EnchantmentHelper.func_77506_a(Enchantment.field_77347_r.field_77352_x, itemStack);
                                    if (func_77506_a4 > 0) {
                                        this.drawEnchantTag("P" + this.getColor(func_77506_a4) + func_77506_a4, n10, n11);
                                        n11 += 6;
                                    }
                                    if (func_77506_a5 > 0) {
                                        this.drawEnchantTag("Th" + this.getColor(func_77506_a5) + func_77506_a5, n10, n11);
                                        n11 += 6;
                                    }
                                    if (func_77506_a6 > 0) {
                                        this.drawEnchantTag("Unb" + this.getColor(func_77506_a6) + func_77506_a6, n10, n11);
                                    }
                                }
                                else if (itemStack.func_77973_b() instanceof ItemBow) {
                                    final int func_77506_a7 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, itemStack);
                                    final int func_77506_a8 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, itemStack);
                                    final int func_77506_a9 = EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, itemStack);
                                    if (func_77506_a7 > 0) {
                                        this.drawEnchantTag("Pow" + this.getColor(func_77506_a7) + func_77506_a7, n10, n11);
                                        n11 += 6;
                                    }
                                    if (func_77506_a8 > 0) {
                                        this.drawEnchantTag("Pun" + this.getColor(func_77506_a8) + func_77506_a8, n10, n11);
                                        n11 += 6;
                                    }
                                    if (func_77506_a9 > 0) {
                                        this.drawEnchantTag("Fir" + this.getColor(func_77506_a9) + func_77506_a9, n10, n11);
                                    }
                                }
                                else if (itemStack.func_77953_t() == EnumRarity.EPIC) {
                                    this.drawEnchantTag("§6§lGod", n10 - 2, n11);
                                }
                                final int n12 = (int)Math.round(255.0 - itemStack.func_77952_i() * 255.0 / itemStack.func_77958_k());
                                new Color(255 - n12 << 16 | n12 << 8).brighter();
                                final float n13 = (float)(n10 * 1.05) - 2.0f;
                                if (itemStack.func_77958_k() - itemStack.func_77952_i() > 0) {
                                    GlStateManager.func_179094_E();
                                    GlStateManager.func_179097_i();
                                    GlStateManager.func_179126_j();
                                    GlStateManager.func_179121_F();
                                }
                                n10 += 12;
                            }
                        }
                    }
                }
                GlStateManager.func_179121_F();
            }
        }
        GlStateManager.func_179121_F();
    }
    
    private void drawEnchantTag(final String text, int n, int n2) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179097_i();
        n *= 1.05;
        n2 -= 6;
        Hanabi.INSTANCE.fontManager.comfortaa10.drawStringWithColor(text, n + 9, -30 - n2, Class59.getColor(255));
        GlStateManager.func_179126_j();
        GlStateManager.func_179121_F();
    }
    
    private String getColor(final int n) {
        if (n != 1) {
            if (n == 2) {
                return "§a";
            }
            if (n == 3) {
                return "§3";
            }
            if (n == 4) {
                return "§4";
            }
            if (n >= 5) {
                return "§6";
            }
        }
        return "§f";
    }
    
    private void scale() {
        final float n = 1.0f * (Nametags_.mc.field_71474_y.field_74326_T ? 2.0f : 1.0f);
        GlStateManager.func_179152_a(n, n, n);
    }
    
    private void updatePositions() {
        Nametags_.entityPositions.clear();
        final float field_74281_c = Class296.getTimer().field_74281_c;
        for (final Entity entity : Nametags_.mc.field_71441_e.field_72996_f) {
            if (entity != Nametags_.mc.field_71439_g && entity instanceof EntityPlayer && (!entity.func_82150_aj() || !(boolean)this.invis.getValueState())) {
                final double n = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * field_74281_c - Nametags_.mc.func_175598_ae().field_78730_l;
                final double n2 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * field_74281_c - Nametags_.mc.func_175598_ae().field_78731_m;
                final double n3 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * field_74281_c - Nametags_.mc.func_175598_ae().field_78728_n;
                final double n4 = n2 + (entity.field_70131_O + 0.2);
                if (((double[])this.convertTo2D(n, n4, n3))[2] < 0.0 || ((double[])this.convertTo2D(n, n4, n3))[2] >= 1.0) {
                    continue;
                }
                Nametags_.entityPositions.put((EntityLivingBase)(EntityPlayer)entity, new double[] { ((double[])this.convertTo2D(n, n4, n3))[0], ((double[])this.convertTo2D(n, n4, n3))[1], Math.abs(((double[])this.convertTo2D(n, n4 + 1.0, n3, entity))[1] - ((double[])this.convertTo2D(n, n4, n3, entity))[1]), ((double[])this.convertTo2D(n, n4, n3))[2] });
            }
        }
    }
    
    private double[] convertTo2D(final double n, final double n2, final double n3, final Entity entity) {
        final float field_74281_c = Class296.getTimer().field_74281_c;
        final float field_70177_z = Nametags_.mc.field_71439_g.field_70177_z;
        final float field_70126_B = Nametags_.mc.field_71439_g.field_70126_B;
        final float[] array = (float[])Class198.getRotationFromPosition(entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * field_74281_c, entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * field_74281_c, entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * field_74281_c - 1.6);
        final Entity func_175606_aa = Nametags_.mc.func_175606_aa();
        final Entity func_175606_aa2 = Nametags_.mc.func_175606_aa();
        final float n4 = array[0];
        func_175606_aa2.field_70126_B = n4;
        func_175606_aa.field_70177_z = n4;
        final Minecraft mc = Nametags_.mc;
        ((IEntityRenderer)Minecraft.func_71410_x().field_71460_t).runSetupCameraTransform(field_74281_c, 0);
        final double[] array2 = (double[])this.convertTo2D(n, n2, n3);
        Nametags_.mc.func_175606_aa().field_70177_z = field_70177_z;
        Nametags_.mc.func_175606_aa().field_70126_B = field_70126_B;
        final Minecraft mc2 = Nametags_.mc;
        ((IEntityRenderer)Minecraft.func_71410_x().field_71460_t).runSetupCameraTransform(field_74281_c, 0);
        return array2;
    }
    
    private double[] convertTo2D(final double n, final double n2, final double n3) {
        final FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(3);
        final IntBuffer intBuffer = BufferUtils.createIntBuffer(16);
        final FloatBuffer floatBuffer2 = BufferUtils.createFloatBuffer(16);
        final FloatBuffer floatBuffer3 = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(2982, floatBuffer2);
        GL11.glGetFloat(2983, floatBuffer3);
        GL11.glGetInteger(2978, intBuffer);
        if (GLU.gluProject((float)n, (float)n2, (float)n3, floatBuffer2, floatBuffer3, intBuffer, floatBuffer)) {
            return new double[] { (double)floatBuffer.get(0), (double)(Display.getHeight() - floatBuffer.get(1)), (double)floatBuffer.get(2) };
        }
        return null;
    }
    
    static {
        Nametags_.entityPositions = new HashMap<EntityLivingBase, double[]>();
    }
}
