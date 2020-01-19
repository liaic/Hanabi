package ClassSub;

import javax.swing.*;

class Class156 implements Runnable
{
    final JComponent val$component;
    final Class321.Class266 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class156(final Class321.Class266 this$0, final JComponent val$component) {
        this.this$0 = this$0;
        this.val$component = val$component;
        super();
    }
    
    @Override
    public void run() {
        JComponent component = this.val$component;
        if (component instanceof JSpinner) {
            component = ((JSpinner.DefaultEditor)((JSpinner)this.val$component).getEditor()).getTextField();
        }
        component.requestFocusInWindow();
    }
}
