package ClassSub;

import javax.swing.*;
import java.awt.*;

final class Class154 extends Class321.Class266
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class154(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    public void showDialog() {
        final Color showDialog = JColorChooser.showDialog(null, "Choose a color", Class321.fromString(this.value));
        if (showDialog != null) {
            this.value = Class321.toString(showDialog);
        }
    }
    
    @Override
    public Object getObject() {
        return Class321.fromString(this.value);
    }
}
