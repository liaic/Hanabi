package ClassSub;

import org.lwjgl.input.*;

public class Class38
{
    public boolean clicked;
    private int button;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class38(final int button) {
        super();
        this.button = button;
    }
    
    public boolean canExcecute() {
        if (Mouse.isButtonDown(this.button)) {
            if (!this.clicked) {
                return this.clicked = true;
            }
        }
        else {
            this.clicked = false;
        }
        return false;
    }
}
