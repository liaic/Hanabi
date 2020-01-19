package ClassSub;

class Class261
{
    private float yaw;
    private float pitch;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class261(final float yaw, final float pitch) {
        super();
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    public Class261() {
        this(0.0f, 0.0f);
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public void setYaw(final float yaw) {
        this.yaw = yaw;
    }
    
    public void setPitch(final float pitch) {
        this.pitch = pitch;
    }
    
    public Class261 constrantAngle() {
        this.setYaw(this.getYaw() % 360.0f);
        this.setPitch(this.getPitch() % 360.0f);
        while (this.getYaw() <= -180.0f) {
            this.setYaw(this.getYaw() + 360.0f);
        }
        while (this.getPitch() <= -180.0f) {
            this.setPitch(this.getPitch() + 360.0f);
        }
        while (this.getYaw() > 180.0f) {
            this.setYaw(this.getYaw() - 360.0f);
        }
        while (this.getPitch() > 180.0f) {
            this.setPitch(this.getPitch() - 360.0f);
        }
        return this;
    }
}
