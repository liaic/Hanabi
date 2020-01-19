package ClassSub;

import java.util.*;
import javax.vecmath.*;

class Class211
{
    private boolean aac;
    private float smooth;
    private Random random;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class211(final boolean aac, final float smooth) {
        super();
        this.aac = aac;
        this.smooth = smooth;
        this.random = new Random();
    }
    
    public Class310 calculateAngle(final Vector3d vector3d, final Vector3d vector3d2) {
        final Class310 class310 = new Class310();
        vector3d.x += (this.aac ? this.randomFloat(-0.75f, 0.75f) : 0.0f) - vector3d2.x;
        vector3d.y += (this.aac ? this.randomFloat(-0.25f, 0.5f) : 0.0f) - vector3d2.y;
        vector3d.z += (this.aac ? this.randomFloat(-0.75f, 0.75f) : 0.0f) - vector3d2.z;
        final double hypot = Math.hypot(vector3d.x, vector3d.z);
        class310.setYaw((float)(Math.atan2(vector3d.z, vector3d.x) * 57.29577951308232) - 90.0f);
        class310.setPitch(-(float)(Math.atan2(vector3d.y, hypot) * 57.29577951308232));
        return class310.constrantAngle();
    }
    
    public Class310 smoothAngle(final Class310 class310, final Class310 class311) {
        final Class310 constrantAngle = new Class310(class311.getYaw() - class310.getYaw(), class311.getPitch() - class310.getPitch()).constrantAngle();
        constrantAngle.setYaw(class311.getYaw() - constrantAngle.getYaw() / 100.0f * this.smooth);
        constrantAngle.setPitch(class311.getPitch() - constrantAngle.getPitch() / 100.0f * this.smooth);
        return constrantAngle.constrantAngle();
    }
    
    public float randomFloat(final float n, final float n2) {
        return n + this.random.nextFloat() * (n2 - n);
    }
}
