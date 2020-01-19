package ClassSub;

public class Class183 extends Class280<Float>
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class183(final Float n, final Float n2) {
        super(n, n2);
    }
    
    public Class183 setYaw(final Float x) {
        ((Class225<Float>)this).setX(x);
        return this;
    }
    
    public Class183 setPitch(final Float y) {
        ((Class225<Float>)this).setY(y);
        return this;
    }
    
    public Float getYaw() {
        return this.getX().floatValue();
    }
    
    public Float getPitch() {
        return this.getY().floatValue();
    }
    
    public Class183 constrantAngle() {
        this.setYaw((float)this.getYaw() % 360.0f);
        this.setPitch((float)this.getPitch() % 360.0f);
        while (this.getYaw() <= -180.0f) {
            this.setYaw((float)this.getYaw() + 360.0f);
        }
        while (this.getPitch() <= -180.0f) {
            this.setPitch((float)this.getPitch() + 360.0f);
        }
        while (this.getYaw() > 180.0f) {
            this.setYaw((float)this.getYaw() - 360.0f);
        }
        while (this.getPitch() > 180.0f) {
            this.setPitch((float)this.getPitch() - 360.0f);
        }
        return this;
    }
}
