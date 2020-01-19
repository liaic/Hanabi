package ClassSub;

import cn.Hanabi.command.*;
import org.jetbrains.annotations.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.World.*;
import java.util.*;

public class Class16 extends Command
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class16() {
        super("irc", new String[] { "i" });
    }
    
    @Override
    public void run(final String s, @NotNull final String[] array) {
        if (array.length < 1) {
            throw new Class58("Usage: ." + s + " message");
        }
        String string = "";
        for (int i = 0; i < array.length; ++i) {
            string = string + array[i] + " ";
        }
        if (ModManager.getModule("IRC").isEnabled()) {
            IRC.sendIRCMessage(string, true);
        }
        else {
            Class128.sendClientMessage("Open your IRC first then you can send message!", Class67.Class124.ERROR);
        }
    }
    
    @Override
    public List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
}
