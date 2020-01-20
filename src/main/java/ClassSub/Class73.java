package ClassSub;

import java.awt.event.*;
import net.minecraftforge.fml.common.*;

class Class73 implements ActionListener
{
    final String val$notice;
    final Class98 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class73(final Class98 this$0, final String val$notice) {
        this.this$0 = this$0;
        this.val$notice = val$notice;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.val$notice.contains("你妈" + "JAVA.SYSTEM".replaceAll("...........", "�?") + "TEST".replaceAll("....", "�?")) || this.val$notice.contains("失败")) {
            FMLCommonHandler.instance().exitJava(0, true);
        }
        else {
            this.this$0.setVisible(false);
        }
    }
}
