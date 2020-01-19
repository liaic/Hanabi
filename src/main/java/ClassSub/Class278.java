package ClassSub;

import java.io.*;
import java.nio.*;

public class Class278 implements Serializable
{
    private static final long serialVersionUID = 1393939L;
    protected transient Class12 GL;
    public static final Class278 transparent;
    public static final Class278 white;
    public static final Class278 yellow;
    public static final Class278 red;
    public static final Class278 blue;
    public static final Class278 green;
    public static final Class278 black;
    public static final Class278 gray;
    public static final Class278 cyan;
    public static final Class278 darkGray;
    public static final Class278 lightGray;
    public static final Class278 pink;
    public static final Class278 orange;
    public static final Class278 magenta;
    public float r;
    public float g;
    public float b;
    public float a;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class278(final Class278 class278) {
        super();
        this.GL = Class83.get();
        this.a = 1.0f;
        this.r = class278.r;
        this.g = class278.g;
        this.b = class278.b;
        this.a = class278.a;
    }
    
    public Class278(final FloatBuffer floatBuffer) {
        super();
        this.GL = Class83.get();
        this.a = 1.0f;
        this.r = floatBuffer.get();
        this.g = floatBuffer.get();
        this.b = floatBuffer.get();
        this.a = floatBuffer.get();
    }
    
    public Class278(final float r, final float g, final float b) {
        super();
        this.GL = Class83.get();
        this.a = 1.0f;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 1.0f;
    }
    
    public Class278(final float n, final float n2, final float n3, final float n4) {
        super();
        this.GL = Class83.get();
        this.a = 1.0f;
        this.r = Math.min(n, 1.0f);
        this.g = Math.min(n2, 1.0f);
        this.b = Math.min(n3, 1.0f);
        this.a = Math.min(n4, 1.0f);
    }
    
    public Class278(final int n, final int n2, final int n3) {
        super();
        this.GL = Class83.get();
        this.a = 1.0f;
        this.r = n / 255.0f;
        this.g = n2 / 255.0f;
        this.b = n3 / 255.0f;
        this.a = 1.0f;
    }
    
    public Class278(final int n, final int n2, final int n3, final int n4) {
        super();
        this.GL = Class83.get();
        this.a = 1.0f;
        this.r = n / 255.0f;
        this.g = n2 / 255.0f;
        this.b = n3 / 255.0f;
        this.a = n4 / 255.0f;
    }
    
    public Class278(final int n) {
        super();
        this.GL = Class83.get();
        this.a = 1.0f;
        final int n2 = (n & 0xFF0000) >> 16;
        final int n3 = (n & 0xFF00) >> 8;
        final int n4 = n & 0xFF;
        int n5 = (n & 0xFF000000) >> 24;
        if (n5 < 0) {
            n5 += 256;
        }
        if (n5 == 0) {
            n5 = 255;
        }
        this.r = n2 / 255.0f;
        this.g = n3 / 255.0f;
        this.b = n4 / 255.0f;
        this.a = n5 / 255.0f;
    }
    
    public static Class278 decode(final String s) {
        return new Class278(Integer.decode(s));
    }
    
    public void bind() {
        this.GL.glColor4f(this.r, this.g, this.b, this.a);
    }
    
    @Override
    public int hashCode() {
        return (int)(this.r + this.g + this.b + this.a) * 255;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof Class278) {
            final Class278 class278 = (Class278)o;
            return class278.r == this.r && class278.g == this.g && class278.b == this.b && class278.a == this.a;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Color (" + this.r + "," + this.g + "," + this.b + "," + this.a + ")";
    }
    
    public Class278 darker() {
        return this.darker(0.5f);
    }
    
    public Class278 darker(float n) {
        n = 1.0f - n;
        return new Class278(this.r * n, this.g * n, this.b * n, this.a);
    }
    
    public Class278 brighter() {
        return this.brighter(0.2f);
    }
    
    public int getRed() {
        return (int)(this.r * 255.0f);
    }
    
    public int getGreen() {
        return (int)(this.g * 255.0f);
    }
    
    public int getBlue() {
        return (int)(this.b * 255.0f);
    }
    
    public int getAlpha() {
        return (int)(this.a * 255.0f);
    }
    
    public int getRedByte() {
        return (int)(this.r * 255.0f);
    }
    
    public int getGreenByte() {
        return (int)(this.g * 255.0f);
    }
    
    public int getBlueByte() {
        return (int)(this.b * 255.0f);
    }
    
    public int getAlphaByte() {
        return (int)(this.a * 255.0f);
    }
    
    public Class278 brighter(float n) {
        ++n;
        return new Class278(this.r * n, this.g * n, this.b * n, this.a);
    }
    
    public Class278 multiply(final Class278 class278) {
        return new Class278(this.r * class278.r, this.g * class278.g, this.b * class278.b, this.a * class278.a);
    }
    
    public void add(final Class278 class278) {
        this.r += class278.r;
        this.g += class278.g;
        this.b += class278.b;
        this.a += class278.a;
    }
    
    public void scale(final float n) {
        this.r *= n;
        this.g *= n;
        this.b *= n;
        this.a *= n;
    }
    
    public Class278 addToCopy(final Class278 class278) {
        final Class278 class280;
        final Class278 class279 = class280 = new Class278(this.r, this.g, this.b, this.a);
        class280.r += class278.r;
        final Class278 class281 = class279;
        class281.g += class278.g;
        final Class278 class282 = class279;
        class282.b += class278.b;
        final Class278 class283 = class279;
        class283.a += class278.a;
        return class279;
    }
    
    public Class278 scaleCopy(final float n) {
        final Class278 class279;
        final Class278 class278 = class279 = new Class278(this.r, this.g, this.b, this.a);
        class279.r *= n;
        final Class278 class280 = class278;
        class280.g *= n;
        final Class278 class281 = class278;
        class281.b *= n;
        final Class278 class282 = class278;
        class282.a *= n;
        return class278;
    }
    
    static {
        transparent = new Class278(0.0f, 0.0f, 0.0f, 0.0f);
        white = new Class278(1.0f, 1.0f, 1.0f, 1.0f);
        yellow = new Class278(1.0f, 1.0f, 0.0f, 1.0f);
        red = new Class278(1.0f, 0.0f, 0.0f, 1.0f);
        blue = new Class278(0.0f, 0.0f, 1.0f, 1.0f);
        green = new Class278(0.0f, 1.0f, 0.0f, 1.0f);
        black = new Class278(0.0f, 0.0f, 0.0f, 1.0f);
        gray = new Class278(0.5f, 0.5f, 0.5f, 1.0f);
        cyan = new Class278(0.0f, 1.0f, 1.0f, 1.0f);
        darkGray = new Class278(0.3f, 0.3f, 0.3f, 1.0f);
        lightGray = new Class278(0.7f, 0.7f, 0.7f, 1.0f);
        pink = new Class278(255, 175, 175, 255);
        orange = new Class278(255, 200, 0, 255);
        magenta = new Class278(255, 0, 255, 255);
    }
}
