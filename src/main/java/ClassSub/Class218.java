package ClassSub;

import java.time.format.*;
import cn.Hanabi.value.*;
import java.text.*;
import cn.Hanabi.*;
import java.util.function.*;
import java.awt.*;
import org.lwjgl.opengl.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.utils.fontmanager.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.boss.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.item.*;
import net.minecraft.client.gui.*;
import net.minecraft.potion.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.util.*;

public class Class218 extends Mod
{
    private static final DateTimeFormatter dateFormat;
    private static final DateTimeFormatter timeFormat;
    public Value<Boolean> arraylist;
    public Value<Boolean> logo;
    public static Value<Boolean> hotbar;
    public Value<Boolean> music;
    public Value<Boolean> potion;
    public Value<Boolean> noti;
    public static Value<Double> musicPosX;
    public static Value<Double> musicPosY;
    public static Value<Double> musicPosYlyr;
    SimpleDateFormat f;
    SimpleDateFormat f2;
    private float animationY2;
    Map<Potion, Double> timerMap;
    private int x;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class218() {
        super("HUD", Category.RENDER, false, true, 0);
        this.arraylist = new Value<Boolean>("HUD_ArrayList", true);
        this.logo = new Value<Boolean>("HUD_Logo", true);
        this.music = new Value<Boolean>("HUD_MusicPlayer", true);
        this.potion = new Value<Boolean>("HUD_Potion", true);
        this.noti = new Value<Boolean>("HUD_Notification", true);
        this.f = new SimpleDateFormat("HH:mm");
        this.f2 = new SimpleDateFormat("YYYY/MM/dd");
        this.timerMap = new HashMap<Potion, Double>();
        this.setState(true);
        final HashMap<Category, ArrayList<Mod>> hashMap = new HashMap<Category, ArrayList<Mod>>();
        for (final Mod mod : Hanabi.INSTANCE.moduleManager.getModules()) {
            if (!hashMap.containsKey(mod.getCategory())) {
                hashMap.put(mod.getCategory(), new ArrayList<Mod>());
            }
            ((ArrayList<Mod>)hashMap.get(mod.getCategory())).add(mod);
        }
        hashMap.entrySet().stream().sorted(Comparator.comparingInt((ToIntFunction<? super Object>)Class218::lambda$new$0)).forEach((Consumer<? super Object>)Class218::lambda$new$2);
    }
    
    public static int rainbow(final int n) {
        return Color.getHSBColor((float)(Math.ceil((double)(System.currentTimeMillis() + n) / 20.0) % 360.0 / 360.0), 0.8f, 0.7f).getRGB();
    }
    
    public void drawRoundedRect(float n, float n2, float n3, float n4, final int n5, final int n6) {
        enableGL2D();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawVLine(n *= 2.0f, (n2 *= 2.0f) + 1.0f, (n4 *= 2.0f) - 2.0f, n5);
        drawVLine((n3 *= 2.0f) - 1.0f, n2 + 1.0f, n4 - 2.0f, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n2, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n4 - 1.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n4 - 2.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n4 - 2.0f, n5);
        Class284.drawRect(n + 1.0f, n2 + 1.0f, n3 - 1.0f, n4 - 1.0f, n6);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        disableGL2D();
    }
    
    public void color(final int n) {
        GL11.glColor4f((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, (float)(n >> 24 & 0xFF) / 255.0f);
    }
    
    public static void enableGL2D() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public static void disableGL2D() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    @EventTarget
    private void render2D(final EventRender2D eventRender2D) {
        final ScaledResolution scaledResolution = new ScaledResolution(Class218.mc);
        final float n = (float)scaledResolution.func_78326_a();
        final float n2 = (float)scaledResolution.func_78328_b();
        if ((boolean)this.potion.getValueState()) {
            this.renderPotionStatus((int)n, (int)n2);
        }
        if ((boolean)this.arraylist.getValueState()) {
            this.renderArray(scaledResolution);
        }
        if ((boolean)this.noti.getValueState()) {
            Class128.INSTANCE.drawNotifications();
        }
        if ((boolean)this.music.getValueState()) {
            Class287.INSTANCE.renderOverlay();
        }
        if ((boolean)this.logo.getValueState()) {
            Hanabi.INSTANCE.fontManager.icon130.func_175063_a(HanabiFonts.ICON_HANABI_LOGO, 2.0f, 2.0f, new Color(47, 116, 253).getRGB());
        }
        if (Class218.hotbar.getValueState() && Class218.mc.func_175606_aa() instanceof EntityPlayer && !Class218.mc.field_71474_y.field_74319_N) {
            final float n3 = 0.0f;
            final float n4 = n2 - 20.0f;
            final float n5 = n;
            final float n6 = n2;
            final Class128 instance = Class128.INSTANCE;
            Class284.drawRect(n3, n4, n5, n6, Class128.reAlpha(Class59.BLACK.c, 0.5f));
            final UnicodeFontRenderer comfortaa17 = Hanabi.INSTANCE.fontManager.comfortaa17;
            if (Class218.mc.func_71356_B()) {
                Class284.drawFilledCircle(10.0f, n2 - 10.0f, 3.0f, Class59.AQUA.c);
                comfortaa17.drawString("PING:N/Ams     FPS:" + Minecraft.func_175610_ah(), 16.0f, n2 - 14.5f, -1);
            }
            else {
                try {
                    final int func_178853_c = Class218.mc.func_147114_u().func_175104_a(Class218.mc.func_110432_I().func_111285_a()).func_178853_c();
                    Class284.drawFilledCircle(10.0f, n2 - 10.0f, 3.0f, (func_178853_c <= 100) ? new Color(3110141).getRGB() : ((func_178853_c <= 250) ? new Color(Class59.ORANGE.c).darker().getRGB() : new Color(Class59.RED.c).getRGB()));
                    comfortaa17.drawString("PING:" + func_178853_c + "ms     FPS:" + Minecraft.func_175610_ah(), 16.0f, n2 - 14.5f, -1);
                }
                catch (Exception ex) {
                    Class284.drawFilledCircle(10.0f, n2 - 10.0f, 3.0f, Class59.AQUA.c);
                    comfortaa17.drawString("PING:N/Ams     FPS:" + Minecraft.func_175610_ah(), 16.0f, n2 - 14.5f, -1);
                }
            }
            final Date date = new Date();
            this.f2.format(date);
            this.f.format(date);
            final String string = "Hanabi Build 1.4.2 - " + Class218.fuck;
            Hanabi.INSTANCE.fontManager.wqy18.func_78276_b(string, scaledResolution.func_78326_a() - comfortaa17.func_78256_a(string), scaledResolution.func_78328_b() - 16, -1);
            if (Class218.mc.field_71439_g.field_71071_by.field_70461_c == 0) {
                final float n7 = n / 2.0f - 91.0f;
                final float n8 = n2 - 20.0f;
                final float n9 = n / 2.0f + 90.0f - 160.0f;
                final float n10 = n2;
                final Class128 instance2 = Class128.INSTANCE;
                Class284.drawRect(n7, n8, n9, n10, Class128.reAlpha(Class59.WHITE.c, 0.5f));
            }
            else {
                final float n11 = n / 2.0f - 91.0f + Class218.mc.field_71439_g.field_71071_by.field_70461_c * 20;
                final float n12 = n2 - 20.0f;
                final float n13 = n / 2.0f + 90.0f - 20 * (8 - Class218.mc.field_71439_g.field_71071_by.field_70461_c);
                final float n14 = n2;
                final Class128 instance3 = Class128.INSTANCE;
                Class284.drawRect(n11, n12, n13, n14, Class128.reAlpha(Class59.WHITE.c, 0.5f));
            }
            RenderHelper.func_74520_c();
            for (int i = 0; i < 9; ++i) {
                this.customRenderHotbarItem(i, (int)(n / 2.0f - 90.0f + i * 20 + 2.0f), (int)(n2 - 16.0f - 2.0f), eventRender2D.partialTicks, (EntityPlayer)Class218.mc.field_71439_g);
            }
            GlStateManager.func_179084_k();
            GlStateManager.func_179124_c(1.0f, 1.0f, 1.0f);
            RenderHelper.func_74518_a();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            if (ModManager.getModule("StaffAnalyzer").isEnabled() && StaffAnalyzer.ui != null) {
                StaffAnalyzer.ui.draw();
            }
            this.renderScaffold();
        }
    }
    
    private void renderScaffold() {
        final int func_78326_a = new ScaledResolution(Class218.mc).func_78326_a();
        if (ModManager.getModule("Scaffold").getState()) {
            final int reAlpha = Class128.reAlpha(Class59.WHITE.c, 0.8f);
            if (BossStatus.field_82827_c != null && BossStatus.field_82826_b > 0 && Class218.mc.field_71439_g.func_110143_aJ() <= 6.0f) {
                this.animationY2 = (float)Class284.getAnimationState(this.animationY2, 50.0, (double)Math.max(10.0f, Math.abs(this.animationY2 - 50.0f) * 25.0f) * 0.3);
            }
            else if (BossStatus.field_82827_c != null && BossStatus.field_82826_b > 0) {
                this.animationY2 = (float)Class284.getAnimationState(this.animationY2, 20.0, (double)Math.max(10.0f, Math.abs(this.animationY2 - 20.0f) * 25.0f) * 0.3);
            }
            else if (Class218.mc.field_71439_g.func_110143_aJ() <= 6.0f) {
                this.animationY2 = (float)Class284.getAnimationState(this.animationY2, 30.0, (double)Math.max(10.0f, Math.abs(this.animationY2 - 30.0f) * 25.0f) * 0.3);
            }
            else {
                this.animationY2 = (float)Class284.getAnimationState(this.animationY2, 2.0, (double)Math.max(10.0f, Math.abs(this.animationY2 - 2.0f) * 25.0f) * 0.3);
            }
            drawRoundedRect2(func_78326_a / 2 - 90, this.animationY2, func_78326_a / 2 + 90, this.animationY2 + 20.0f, reAlpha, reAlpha);
            if (Scaffold.currentlyHolding != null) {
                GL11.glPushMatrix();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                if (Class218.mc.field_71441_e != null) {
                    RenderHelper.func_74520_c();
                }
                GlStateManager.func_179094_E();
                GlStateManager.func_179118_c();
                GlStateManager.func_179086_m(256);
                Class218.mc.func_175599_af().field_77023_b = -150.0f;
                Class218.mc.func_175599_af().func_180450_b(Scaffold.currentlyHolding, func_78326_a / 2 - 90 + 2, (int)(this.animationY2 + 2.0f));
                Class218.mc.func_175599_af().field_77023_b = 0.0f;
                GlStateManager.func_179084_k();
                GlStateManager.func_179139_a(0.5, 0.5, 0.5);
                GlStateManager.func_179097_i();
                GlStateManager.func_179140_f();
                GlStateManager.func_179126_j();
                GlStateManager.func_179152_a(2.0f, 2.0f, 2.0f);
                GlStateManager.func_179141_d();
                GlStateManager.func_179121_F();
                GL11.glPopMatrix();
            }
            else {
                Hanabi.INSTANCE.fontManager.icon30.drawString("c", func_78326_a / 2 - 88, this.animationY2 + 2.5f, Class59.GREY.c);
            }
            Hanabi.INSTANCE.fontManager.usans18.drawCenteredString(this.getBlockCount() + " blocks left", func_78326_a / 2 - 2, this.animationY2 + 5.5f, Class59.GREY.c);
        }
        else {
            this.animationY2 += 65.0f;
            final int reAlpha2 = Class128.reAlpha(Class59.WHITE.c, 0.8f);
            this.animationY2 = (float)Class284.getAnimationState(this.animationY2, -25.0, (double)Math.max(10.0f, Math.abs(this.animationY2 + 25.0f) * 15.0f) * 0.3);
            this.animationY2 -= 65.0f;
            drawRoundedRect2(func_78326_a / 2 - 90, this.animationY2, func_78326_a / 2 + 90, this.animationY2 + 20.0f, reAlpha2, reAlpha2);
            Hanabi.INSTANCE.fontManager.usans18.drawCenteredString("Scaffold Disabled", func_78326_a / 2 - 2, this.animationY2 + 5.5f, Class59.GREY.c);
        }
        if (BossStatus.field_82827_c != null && BossStatus.field_82826_b > 0) {
            this.animationY2 = (float)Class284.getAnimationState(this.animationY2, 20.0, (double)Math.max(10.0f, Math.abs(this.animationY2 - 20.0f) * 25.0f) * 0.3);
        }
        else {
            this.animationY2 = (float)Class284.getAnimationState(this.animationY2, 2.0, (double)Math.max(10.0f, Math.abs(this.animationY2 - 2.0f) * 25.0f) * 0.3);
        }
    }
    
    public static void drawRoundedRect2(float n, float n2, float n3, float n4, final int n5, final int n6) {
        enableGL2D();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawVLine(n *= 2.0f, (n2 *= 2.0f) + 1.0f, (n4 *= 2.0f) - 2.0f, n5);
        drawVLine((n3 *= 2.0f) - 1.0f, n2 + 1.0f, n4 - 2.0f, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n2, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n4 - 1.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n4 - 2.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n4 - 2.0f, n5);
        Class284.drawRect(n + 1.0f, n2 + 1.0f, n3 - 1.0f, n4 - 1.0f, n6);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        disableGL2D();
    }
    
    public static void drawHLine(float n, float n2, final float n3, final int n4) {
        if (n2 < n) {
            final float n5 = n;
            n = n2;
            n2 = n5;
        }
        Class284.drawRect(n, n3, n2 + 1.0f, n3 + 1.0f, n4);
    }
    
    public static void drawVLine(final float n, float n2, float n3, final int n4) {
        if (n3 < n2) {
            final float n5 = n2;
            n2 = n3;
            n3 = n5;
        }
        Class284.drawRect(n, n2 + 1.0f, n + 1.0f, n3, n4);
    }
    
    public int getBlockCount() {
        int n = 0;
        for (int i = 36; i < 45; ++i) {
            if (Class218.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                final ItemStack func_75211_c = Class218.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                final Item func_77973_b = func_75211_c.func_77973_b();
                if (func_75211_c.func_77973_b() instanceof ItemBlock && this.isValid(func_77973_b)) {
                    n += func_75211_c.field_77994_a;
                }
            }
        }
        return n;
    }
    
    private boolean isValid(final Item item) {
        return item instanceof ItemBlock && !Scaffold.blacklistedBlocks.contains(((ItemBlock)item).func_179223_d());
    }
    
    private void customRenderHotbarItem(final int n, final int n2, final int n3, final float n4, final EntityPlayer entityPlayer) {
        GlStateManager.func_179084_k();
        final ItemStack itemStack = entityPlayer.field_71071_by.field_70462_a[n];
        if (itemStack != null) {
            final float n5 = itemStack.field_77992_b - n4;
            if (n5 > 0.0f) {
                GlStateManager.func_179094_E();
                final float n6 = 1.0f + n5 / 5.0f;
                GlStateManager.func_179109_b((float)(n2 + 8), (float)(n3 + 12), 0.0f);
                GlStateManager.func_179152_a(1.0f / n6, (n6 + 1.0f) / 2.0f, 1.0f);
                GlStateManager.func_179109_b((float)(-(n2 + 8)), (float)(-(n3 + 12)), 0.0f);
            }
            Class218.mc.func_175599_af().func_180450_b(itemStack, n2, n3);
            if (n5 > 0.0f) {
                GlStateManager.func_179121_F();
            }
            Class218.mc.func_175599_af().func_175030_a((FontRenderer)Hanabi.INSTANCE.fontManager.comfortaa16, itemStack, n2 - 1, n3);
        }
    }
    
    private void renderArray(final ScaledResolution scaledResolution) {
        final ArrayList<Mod> list = new ArrayList<Mod>(ModManager.getEnabledModListHUD());
        float posY = 3.0f;
        final UnicodeFontRenderer raleway17 = Hanabi.INSTANCE.fontManager.raleway17;
        for (final Mod mod : list) {
            mod.onRenderArray();
            if (!mod.isEnabled() && mod.posX == 0.0f) {
                continue;
            }
            final String name = mod.getName();
            final String displayName = mod.getDisplayName();
            final float posX = mod.posX;
            mod.lastY = mod.posY;
            mod.posY = posY;
            Class284.drawRect(scaledResolution.func_78326_a() - posX - 7.0f, posY + mod.posYRend - 3.5f, scaledResolution.func_78326_a(), posY + mod.posYRend + 10.5f, Class128.reAlpha(Class59.BLACK.c, 0.55f));
            Class284.drawRect(scaledResolution.func_78326_a() - posX - 7.0f, posY + mod.posYRend - 3.5f, scaledResolution.func_78326_a() - posX - 5.0f, posY + mod.posYRend + 10.5f, new Color(47, 116, 253).getRGB());
            raleway17.drawString(name, scaledResolution.func_78326_a() - posX - 2.0f, posY + mod.posYRend - 1.5f, new Color(47, 116, 253).getRGB());
            if (displayName != null) {
                raleway17.drawString(displayName, scaledResolution.func_78326_a() - posX + (float)raleway17.func_78256_a(name), posY + mod.posYRend - 1.5f, new Color(159, 159, 159).getRGB());
            }
            posY += 14.0f;
        }
    }
    
    public void renderPotionStatus(final int n, final int n2) {
        this.x = 0;
        for (final PotionEffect potionEffect : Class218.mc.field_71439_g.func_70651_bq()) {
            final Potion potion = Potion.field_76425_a[potionEffect.func_76456_a()];
            String s = I18n.func_135052_a(potion.func_76393_a(), new Object[0]);
            int int1;
            int int2;
            try {
                int1 = Integer.parseInt(((String[])Potion.func_76389_a(potionEffect).split(":"))[0]);
                int2 = Integer.parseInt(((String[])Potion.func_76389_a(potionEffect).split(":"))[1]);
            }
            catch (Exception ex) {
                int1 = 0;
                int2 = 0;
            }
            final double n3 = (double)(int1 * 60 + int2);
            if (!this.timerMap.containsKey(potion)) {
                this.timerMap.put(potion, n3);
            }
            if (this.timerMap.get(potion) == 0.0 || n3 > this.timerMap.get(potion)) {
                this.timerMap.replace(potion, n3);
            }
            switch (potionEffect.func_76458_c()) {
                case 1: {
                    s += " II";
                    break;
                }
                case 2: {
                    s += " III";
                    break;
                }
                case 3: {
                    s += " IV";
                    break;
                }
            }
            final int c = Class59.WHITE.c;
            if (potionEffect.func_76459_b() < 600 && potionEffect.func_76459_b() > 300) {
                final int c2 = Class59.YELLOW.c;
            }
            else if (potionEffect.func_76459_b() < 300) {
                final int c3 = Class59.RED.c;
            }
            else if (potionEffect.func_76459_b() > 600) {
                final int c4 = Class59.WHITE.c;
            }
            final int n4 = (int)((n - 6) * 1.33f);
            final int n5 = (int)((n2 - 52 - Class218.mc.field_71466_p.field_78288_b + this.x + 5) * 1.33f);
            final float n6 = (float)(n - 120);
            final float n7 = (float)(n2 - 60 + this.x);
            final float n8 = (float)(n - 10);
            final float n9 = (float)(n2 - 30 + this.x);
            final Class128 instance = Class128.INSTANCE;
            Class284.drawRect(n6, n7, n8, n9, Class128.reAlpha(Class59.BLACK.c, 0.41f));
            if (potion.func_76400_d()) {
                GlStateManager.func_179094_E();
                GL11.glDisable(2929);
                GL11.glEnable(3042);
                GL11.glDepthMask(false);
                OpenGlHelper.func_148821_a(770, 771, 1, 0);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                final int func_76392_e = potion.func_76392_e();
                Class218.mc.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/container/inventory.png"));
                GlStateManager.func_179139_a(0.75, 0.75, 0.75);
                Class218.mc.field_71456_v.func_73729_b(n4 - 138, n5 + 8, 0 + func_76392_e % 8 * 18, 198 + func_76392_e / 8 * 18, 18, 18);
                GL11.glDepthMask(true);
                GL11.glDisable(3042);
                GL11.glEnable(2929);
                GlStateManager.func_179121_F();
            }
            final int n10 = n2 - Class218.mc.field_71466_p.field_78288_b + this.x - 38;
            Hanabi.INSTANCE.fontManager.wqy18.drawString(s.replaceAll("§.", ""), n - 91.0f, n10 - Class218.mc.field_71466_p.field_78288_b + 1, new Color(47, 116, 253).getRGB());
            Hanabi.INSTANCE.fontManager.comfortaa16.drawString(Potion.func_76389_a(potionEffect).replaceAll("§.", ""), n - 91.0f, n10 + 4, Class128.reAlpha(-1, 0.8f));
            this.x -= 35;
        }
    }
    
    private static void lambda$new$2(final Map.Entry entry) {
        final Class75<Object> class75 = new Class75<Object>(((Category)entry.getKey()).toString());
        for (final Mod mod : (List)entry.getValue()) {
            class75.addSubTab(new Class40<Object>(mod.getName(), Class218::lambda$null$1, (Object)mod));
        }
    }
    
    private static void lambda$null$1(final Class40 class40) {
        ((Mod)class40.getObject()).setState(!((Mod)class40.getObject()).getState());
    }
    
    private static int lambda$new$0(final Map.Entry entry) {
        return ((Category)entry.getKey()).toString().hashCode();
    }
    
    static {
        dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        Class218.hotbar = new Value<Boolean>("HUD_Hotbar", true);
        Class218.musicPosX = new Value<Double>("HUD_MusicPlayerX", 70.0, 0.0, 400.0, 1.0);
        Class218.musicPosY = new Value<Double>("HUD_MusicPlayerY", 5.0, 0.0, 200.0, 1.0);
        Class218.musicPosYlyr = new Value<Double>("HUD_MusicPlayerLyricY", 120.0, 0.0, 200.0, 1.0);
    }
}
