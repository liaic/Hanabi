package ClassSub;

import net.minecraft.util.*;

public class Class235
{
    private double x;
    private double y;
    private double z;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class235(final double x, final double y, final double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public Class235 addVector(final double n, final double n2, final double n3) {
        return new Class235(this.x + n, this.y + n2, this.z + n3);
    }
    
    public Class235 floor() {
        return new Class235(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }
    
    public double squareDistanceTo(final Class235 class235) {
        return Math.pow(class235.x - this.x, 2.0) + Math.pow(class235.y - this.y, 2.0) + Math.pow(class235.z - this.z, 2.0);
    }
    
    public Class235 add(final Class235 class235) {
        return this.addVector(class235.getX(), class235.getY(), class235.getZ());
    }
    
    public Vec3 mc() {
        return new Vec3(this.x, this.y, this.z);
    }
    
    @Override
    public String toString() {
        return "[" + this.x + ";" + this.y + ";" + this.z + "]";
    }
}
