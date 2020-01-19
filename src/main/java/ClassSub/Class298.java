package ClassSub;

import java.awt.event.*;
import net.minecraftforge.fml.common.*;

class Class298 implements ActionListener
{
    final String val$notice;
    final Class44 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    Class298(final Class44 this$0, final String val$notice) {
        this.this$0 = this$0;
        this.val$notice = val$notice;
        super();
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.val$notice.contains("你妈" + "JAVA.SYSTEM".replaceAll("...........", "死") + "TEST".replaceAll("....", "了")) || this.val$notice.contains("失败")) {
            FMLCommonHandler.instance().exitJava(0, true);
        }
        else {
            this.this$0.setVisible(false);
        }
    }
}
