package ClassSub;

import javax.swing.*;

final class Class144 extends Class321.Class266
{
    final int val$currentValue;
    final String val$description;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class144(final String s, final String s2, final int val$currentValue, final String val$description) {
        this.val$currentValue = val$currentValue;
        this.val$description = val$description;
        super(s, s2);
    }
    
    @Override
    public void showDialog() {
        final JSpinner spinner = new JSpinner(new SpinnerNumberModel(this.val$currentValue, -32768, 32767, 1));
        if (this.showValueDialog(spinner, this.val$description)) {
            this.value = String.valueOf(spinner.getValue());
        }
    }
    
    @Override
    public Object getObject() {
        return Integer.valueOf(this.value);
    }
}
