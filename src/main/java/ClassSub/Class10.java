package ClassSub;

import java.util.*;

public class Class10
{
    private float minYawSmoothing;
    private float maxYawSmoothing;
    private float minPitchSmoothing;
    private float maxPitchSmoothing;
    private Class81<Float> delta;
    private Class183 smoothedAngle;
    private final Random random;
    private float height;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class10(final float minYawSmoothing, final float maxYawSmoothing, final float minPitchSmoothing, final float maxPitchSmoothing) {
        super();
        this.height = Class20.getRandomInRange(1.1f, 1.8f);
        this.minYawSmoothing = minYawSmoothing;
        this.maxYawSmoothing = maxYawSmoothing;
        this.minPitchSmoothing = minPitchSmoothing;
        this.maxPitchSmoothing = maxPitchSmoothing;
        this.random = new Random();
        this.delta = new Class81<Float>(0.0f, 0.0f, 0.0f);
        this.smoothedAngle = new Class183(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }
    
    public float randomFloat(final float n, final float n2) {
        return n + this.random.nextFloat() * (n2 - n);
    }
    
    public Class183 calculateAngle(final Class81<Double> class81, final Class81<Double> class82) {
        final Class183 class83 = new Class183(Float.valueOf(0.0f), Float.valueOf(0.0f));
        this.delta.setX(class81.getX().floatValue() - class82.getX().floatValue()).setY(class81.getY().floatValue() + this.height - (class82.getY().floatValue() + this.height)).setZ(class81.getZ().floatValue() - class82.getZ().floatValue());
        final double hypot = Math.hypot(this.delta.getX().doubleValue(), this.delta.getZ().doubleValue());
        final float n = (float)Math.atan2(this.delta.getZ().floatValue(), this.delta.getX().floatValue());
        final float n2 = (float)Math.atan2(this.delta.getY().floatValue(), hypot);
        final float n3 = 57.29578f;
        return class83.setYaw(n * n3 - 90.0f).setPitch(-(n2 * n3)).constrantAngle();
    }
    
    public void setHeight(final float height) {
        this.height = height;
    }
    
    public Class183 smoothAngle(final Class183 class183, final Class183 class184, final float n, final float n2) {
        return this.smoothedAngle.setYaw(class184.getYaw() - class183.getYaw() - ((Math.abs((float)class184.getYaw() - (float)class183.getYaw()) > 5.0f) ? (Math.abs((float)class184.getYaw() - (float)class183.getYaw()) / Math.abs((float)class184.getYaw() - (float)class183.getYaw()) * 2.0f / 2.0f) : 0.0f)).setPitch((float)class184.getPitch() - (float)class183.getPitch()).constrantAngle().setYaw((float)class184.getYaw() - this.smoothedAngle.getYaw() / n2 * this.randomFloat(this.minYawSmoothing, this.maxYawSmoothing)).constrantAngle().setPitch((float)class184.getPitch() - this.smoothedAngle.getPitch() / n * this.randomFloat(this.minPitchSmoothing, this.maxPitchSmoothing)).constrantAngle();
    }
}
