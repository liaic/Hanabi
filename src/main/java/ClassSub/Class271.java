package ClassSub;

import java.io.*;

public strictfp class Class271 implements Serializable
{
    private static final long serialVersionUID = 1339934L;
    public float x;
    public float y;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class271() {
        super();
    }
    
    public Class271(final float[] array) {
        super();
        this.x = array[0];
        this.y = array[1];
    }
    
    public Class271(final double theta) {
        super();
        this.x = 1.0f;
        this.y = 0.0f;
        this.setTheta(theta);
    }
    
    public strictfp void setTheta(double n) {
        if (n < -360.0 || n > 360.0) {
            n %= 360.0;
        }
        if (n < 0.0) {
            n += 360.0;
        }
        double theta = this.getTheta();
        if (n < -360.0 || n > 360.0) {
            theta %= 360.0;
        }
        if (n < 0.0) {}
        final float length = this.length();
        this.x = length * (float)Class165.cos(StrictMath.toRadians(n));
        this.y = length * (float)Class165.sin(StrictMath.toRadians(n));
    }
    
    public strictfp Class271 add(final double n) {
        this.setTheta(this.getTheta() + n);
        return this;
    }
    
    public strictfp Class271 sub(final double n) {
        this.setTheta(this.getTheta() - n);
        return this;
    }
    
    public strictfp double getTheta() {
        double degrees = StrictMath.toDegrees(StrictMath.atan2((double)this.y, (double)this.x));
        if (degrees < -360.0 || degrees > 360.0) {
            degrees %= 360.0;
        }
        if (degrees < 0.0) {
            degrees += 360.0;
        }
        return degrees;
    }
    
    public strictfp float getX() {
        return this.x;
    }
    
    public strictfp float getY() {
        return this.y;
    }
    
    public Class271(final Class271 class271) {
        this(class271.getX(), class271.getY());
    }
    
    public Class271(final float x, final float y) {
        super();
        this.x = x;
        this.y = y;
    }
    
    public strictfp void set(final Class271 class271) {
        this.set(class271.getX(), class271.getY());
    }
    
    public strictfp float dot(final Class271 class271) {
        return this.x * class271.getX() + this.y * class271.getY();
    }
    
    public strictfp Class271 set(final float x, final float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    
    public strictfp Class271 getPerpendicular() {
        return new Class271(-this.y, this.x);
    }
    
    public strictfp Class271 set(final float[] array) {
        return this.set(array[0], array[1]);
    }
    
    public strictfp Class271 negate() {
        return new Class271(-this.x, -this.y);
    }
    
    public strictfp Class271 negateLocal() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }
    
    public strictfp Class271 add(final Class271 class271) {
        this.x += class271.getX();
        this.y += class271.getY();
        return this;
    }
    
    public strictfp Class271 sub(final Class271 class271) {
        this.x -= class271.getX();
        this.y -= class271.getY();
        return this;
    }
    
    public strictfp Class271 scale(final float n) {
        this.x *= n;
        this.y *= n;
        return this;
    }
    
    public strictfp Class271 normalise() {
        final float length = this.length();
        if (length == 0.0f) {
            return this;
        }
        this.x /= length;
        this.y /= length;
        return this;
    }
    
    public strictfp Class271 getNormal() {
        final Class271 copy = this.copy();
        copy.normalise();
        return copy;
    }
    
    public strictfp float lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }
    
    public strictfp float length() {
        return (float)Math.sqrt(this.lengthSquared());
    }
    
    public strictfp void projectOntoUnit(final Class271 class271, final Class271 class272) {
        final float dot = class271.dot(this);
        class272.x = dot * class271.getX();
        class272.y = dot * class271.getY();
    }
    
    public strictfp Class271 copy() {
        return new Class271(this.x, this.y);
    }
    
    @Override
    public strictfp String toString() {
        return "[Vector2f " + this.x + "," + this.y + " (" + this.length() + ")]";
    }
    
    public strictfp float distance(final Class271 class271) {
        return (float)Math.sqrt(this.distanceSquared(class271));
    }
    
    public strictfp float distanceSquared(final Class271 class271) {
        final float n = class271.getX() - this.getX();
        final float n2 = class271.getY() - this.getY();
        return n * n + n2 * n2;
    }
    
    @Override
    public strictfp int hashCode() {
        return 997 * (int)this.x ^ 991 * (int)this.y;
    }
    
    @Override
    public strictfp boolean equals(final Object o) {
        if (o instanceof Class271) {
            final Class271 class271 = (Class271)o;
            return class271.x == this.x && class271.y == this.y;
        }
        return false;
    }
}
