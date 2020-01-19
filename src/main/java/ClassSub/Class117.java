package ClassSub;

import com.google.common.base.*;
import net.minecraft.scoreboard.*;

class Class117 implements Predicate<Score>
{
    final Class78 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class117(final Class78 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public boolean apply(final Score score) {
        return score.func_96653_e() != null && !score.func_96653_e().startsWith("#");
    }
    
    public boolean apply(final Object o) {
        return this.apply((Score)o);
    }
}
