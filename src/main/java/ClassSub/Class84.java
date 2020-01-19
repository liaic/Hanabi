package ClassSub;

import cn.Hanabi.modules.*;
import java.util.*;

class Class84 extends Class125
{
    final Mod val$selectedMod;
    final Class79 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class84(final Class79 this$0, final String s, final boolean b, final Mod val$selectedMod) {
        this.this$0 = this$0;
        this.val$selectedMod = val$selectedMod;
        super(s, b);
    }
    
    @Override
    public void onPress() {
        this.val$selectedMod.set(!this.val$selectedMod.isEnabled());
        for (final Class0 class0 : this.this$0.mods) {
            if (class0.mod == this.val$selectedMod) {
                class0.button.toggle();
                break;
            }
        }
        super.onPress();
    }
}
