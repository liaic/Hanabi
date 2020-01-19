package ClassSub;

import net.minecraft.client.gui.*;
import cn.Hanabi.*;
import net.minecraft.client.*;

public class Class159
{
    public GuiScreen screen;
    public String text;
    public int animatedY;
    public boolean init;
    public String icon;
    public Class38 handler;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class159(final String text, final String icon, final GuiScreen screen) {
        super();
        this.animatedY = 0;
        this.init = false;
        this.handler = new Class38(0);
        this.screen = screen;
        this.text = text;
        this.icon = icon;
    }
    
    public void draw(final int n, final int n2, final int n3, final int animatedY) {
        if (!this.init) {
            this.animatedY = animatedY;
            this.init = true;
        }
        if (this.isHovering(n, n2, n3 - 32, animatedY - 32, n3 + 32, animatedY + 32)) {
            this.animatedY = (int)Class284.getAnimationState(this.animatedY, animatedY - 10, 200.0);
        }
        else {
            this.animatedY = (int)Class284.getAnimationState(this.animatedY, animatedY, 200.0);
        }
        Class284.circle(n3, this.animatedY, 30.0f, Class59.WHITE.c);
        if (this.isHovering(n, n2, n3 - 32, animatedY - 32, n3 + 32, animatedY + 32)) {
            Hanabi.INSTANCE.fontManager.wqy18.drawString(this.text, n3 - 18.0f, animatedY + 40, Class59.WHITE.c);
        }
        final String icon = this.icon;
        int n4 = -1;
        switch (icon.hashCode()) {
            case 59658: {
                if (icon.equals("")) {
                    n4 = 0;
                    break;
                }
                break;
            }
            case 59660: {
                if (icon.equals("")) {
                    n4 = 1;
                    break;
                }
                break;
            }
            case 59666: {
                if (icon.equals("")) {
                    n4 = 2;
                    break;
                }
                break;
            }
            case 59661: {
                if (icon.equals("")) {
                    n4 = 3;
                    break;
                }
                break;
            }
            case 59664: {
                if (icon.equals("")) {
                    n4 = 4;
                    break;
                }
                break;
            }
        }
        switch (n4) {
            case 0: {
                Hanabi.INSTANCE.fontManager.icon70.drawString(this.icon, n3 - 17.0f, this.animatedY - 19, Class59.GREY.c);
                break;
            }
            case 1: {
                Hanabi.INSTANCE.fontManager.icon100.drawString(this.icon, n3 - 24.0f, this.animatedY - 28, Class59.GREY.c);
                break;
            }
            case 2: {
                Hanabi.INSTANCE.fontManager.icon70.drawString(this.icon, n3 - 17.0f, this.animatedY - 20, Class59.GREY.c);
                break;
            }
            case 3: {
                Hanabi.INSTANCE.fontManager.icon70.drawString(this.icon, n3 - 17.0f, this.animatedY - 19, Class59.GREY.c);
                break;
            }
            case 4: {
                Hanabi.INSTANCE.fontManager.icon70.drawString(this.icon, n3 - 17.0f, this.animatedY - 19, Class59.GREY.c);
                break;
            }
        }
    }
    
    public void onClick(final int n, final int n2, final int n3, final int n4) {
        if (this.isHovering(n, n2, n3 - 32, n4 - 32, n3 + 32, n4 + 32) && this.handler.canExcecute()) {
            if (this.screen != null) {
                Minecraft.func_71410_x().func_147108_a(this.screen);
            }
            else {
                Minecraft.func_71410_x().func_71400_g();
            }
        }
    }
    
    private boolean isHovering(final int n, final int n2, final float n3, final float n4, final float n5, final float n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
}
