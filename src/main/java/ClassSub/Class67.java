package ClassSub;

import cn.Hanabi.*;
import java.awt.*;
import net.minecraft.client.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;

public class Class67
{
    private String message;
    private Class191 timer;
    private double lastY;
    private double posY;
    private double width;
    private double height;
    private double animationX;
    private int color;
    private int imageWidth;
    private Class124 t;
    private long stayTime;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class67(final String s, final Class124 t) {
        super();
        this.message = s;
        (this.timer = new Class191()).reset();
        this.width = Hanabi.INSTANCE.fontManager.comfortaa16.func_78256_a(s) + 35;
        this.height = 20.0;
        this.animationX = this.width;
        this.stayTime = 1500L;
        this.imageWidth = 16;
        this.posY = -1.0;
        this.t = t;
        if (t.equals(Class124.INFO)) {
            this.color = Class59.DARKGREY.c;
        }
        else if (t.equals(Class124.ERROR)) {
            this.color = new Color(36, 36, 36).getRGB();
        }
        else if (t.equals(Class124.SUCCESS)) {
            this.color = new Color(36, 36, 36).getRGB();
        }
        else if (t.equals(Class124.WARNING)) {
            this.color = Class59.DARKGREY.c;
        }
    }
    
    public void draw(final double posY, final double lastY) {
        this.width = Hanabi.INSTANCE.fontManager.comfortaa15.func_78256_a(this.message) + 45;
        this.height = 22.0;
        this.imageWidth = 11;
        this.lastY = lastY;
        this.animationX = this.getAnimationState(this.animationX, this.isFinished() ? this.width : 0.0, Math.max(this.isFinished() ? 200.0 : 30.0, Math.abs(this.animationX - (this.isFinished() ? this.width : 0.0)) * 20.0) * 0.3);
        if (this.posY == -1.0) {
            this.posY = posY;
        }
        else {
            this.posY = this.getAnimationState(this.posY, posY, 200.0);
        }
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
        final int n = (int)(scaledResolution.func_78326_a() - this.width + this.animationX);
        final int n2 = (int)(scaledResolution.func_78326_a() + this.animationX);
        int n3 = (int)this.posY - 22;
        Class284.drawRect(n, n3, n2, (float)(n3 + this.height), Class128.reAlpha(this.color, 0.85f));
        switch (Class112.$SwitchMap$cn$Hanabi$gui$notifications$Notification$Type[this.t.ordinal()]) {
            case 1: {
                Hanabi.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_ERROR, n + 3, n3 + 4, Class59.WHITE.c);
                break;
            }
            case 2: {
                Hanabi.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_INFO, n + 3, n3 + 4, Class59.WHITE.c);
                break;
            }
            case 3: {
                Hanabi.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_SUCCESS, n + 3, n3 + 4, Class59.WHITE.c);
                break;
            }
            case 4: {
                Hanabi.INSTANCE.fontManager.icon25.func_78276_b(HanabiFonts.ICON_NOTIFY_WARN, n + 3, n3 + 4, Class59.WHITE.c);
                break;
            }
        }
        ++n3;
        if (this.message.contains(" Enabled")) {
            Hanabi.INSTANCE.fontManager.comfortaa15.drawString(this.message.replace(" Enabled", ""), n + 19, (float)(n3 + this.height / 4.0), -1);
            Hanabi.INSTANCE.fontManager.comfortaa15.drawString(" Enabled", n + 20 + Hanabi.INSTANCE.fontManager.comfortaa15.func_78256_a(this.message.replace((CharSequence)" Enabled", (CharSequence)"")), (float)(n3 + this.height / 4.0), Class59.GREY.c);
        }
        else if (this.message.contains(" Disabled")) {
            Hanabi.INSTANCE.fontManager.comfortaa15.drawString(this.message.replace(" Disabled", ""), n + 19, (float)(n3 + this.height / 4.0), -1);
            Hanabi.INSTANCE.fontManager.comfortaa15.drawString(" Disabled", n + 20 + Hanabi.INSTANCE.fontManager.comfortaa15.func_78256_a(this.message.replace((CharSequence)" Disabled", (CharSequence)"")), (float)(n3 + this.height / 4.0), Class59.GREY.c);
        }
        else {
            Hanabi.INSTANCE.fontManager.comfortaa15.drawString(this.message, n + 20, (float)(n3 + this.height / 4.0), -1);
        }
    }
    
    public boolean shouldDelete() {
        return this.isFinished() && this.animationX >= this.width;
    }
    
    private boolean isFinished() {
        return this.timer.isDelayComplete(this.stayTime) && this.posY == this.lastY;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public double getAnimationState(double n, final double n2, final double n3) {
        final float n4 = (float)(Class284.delta * n3);
        if (n < n2) {
            if (n + n4 < n2) {
                n += n4;
            }
            else {
                n = n2;
            }
        }
        else if (n - n4 > n2) {
            n -= n4;
        }
        else {
            n = n2;
        }
        return n;
    }
    
    public void drawImage(final ResourceLocation resourceLocation, final int n, final int n2, final int n3, final int n4) {
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.func_148821_a(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.func_71410_x().func_110434_K().func_110577_a(resourceLocation);
        Gui.func_146110_a(n, n2, 0.0f, 0.0f, n3, n4, (float)n3, (float)n4);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
}
