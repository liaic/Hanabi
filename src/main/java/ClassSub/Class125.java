package ClassSub;

import java.awt.*;

public class Class125
{
    public String parent;
    public float x;
    public float y;
    public boolean state;
    double aniState;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class125(final String parent, final boolean state) {
        super();
        this.parent = parent;
        this.state = state;
        this.aniState = 8.0;
    }
    
    public void draw(final float x, final float y) {
        this.x = x;
        this.y = y;
        this.aniState = Class284.getAnimationState(this.aniState, 8.0, 100.0);
        Class284.drawRoundedRect(x - 8.0f, y - 3.0f, x + 8.0f, y + 3.0f, 2.0f, Class61.theme.isCurrentMode("Light") ? new Color(Class59.GREY.c).brighter().getRGB() : new Color(40, 40, 40).getRGB());
        if (Class61.theme.isCurrentMode("Light")) {
            Class284.circle(this.state ? ((float)(x - 4.0f + this.aniState)) : ((float)(x + 4.0f - this.aniState)), y, 4.0f, this.state ? new Color(-14848033).brighter().getRGB() : new Color(Class59.WHITE.c).darker().getRGB());
        }
        else {
            Class284.circle(this.state ? ((float)(x - 4.0f + this.aniState)) : ((float)(x + 4.0f - this.aniState)), y, 4.0f, this.state ? -14848033 : -12369085);
        }
    }
    
    public void toggle() {
        this.state = !this.state;
        this.aniState = 0.0;
    }
    
    public void isPressed(final int n, final int n2) {
        if (this.isHovering(n, n2, this.x - 12.0f, this.y - 5.0f, this.x + 12.0f, this.y + 5.0f)) {
            this.onPress();
        }
    }
    
    private boolean isHovering(final int n, final int n2, final double n3, final double n4, final double n5, final double n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
    
    public void onPress() {
        this.toggle();
    }
}
