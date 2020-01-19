package ClassSub;

import cn.Hanabi.value.*;

class Class60 extends Class125
{
    final Value val$value;
    final Class79 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class60(final Class79 this$0, final String s, final boolean b, final Value val$value) {
        this.this$0 = this$0;
        this.val$value = val$value;
        super(s, b);
    }
    
    @Override
    public void onPress() {
        if (!this.parent.equals(Class0.selectedMod.getName())) {
            return;
        }
        this.val$value.setValueState(!(boolean)this.val$value.getValueState());
        super.onPress();
    }
}
