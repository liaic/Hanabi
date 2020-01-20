package ClassSub;

import com.google.common.base.*;
import net.minecraft.scoreboard.*;

class Class312 implements Predicate<Score>
{
    final Class287 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class312(final Class287 this$0) {
        this.this$0 = this$0;
    }
    
    public boolean apply(final Score score) {
        return score.getPlayerName() != null && !score.getPlayerName().startsWith("#");
    }
    
    public boolean apply(final Object o) {
        return this.apply((Score)o);
    }
}
