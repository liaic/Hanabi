package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import ClassSub.*;
import cn.Hanabi.modules.World.*;
import java.util.*;

public class Checkuser extends Command
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Checkuser() {
        super("checkuser", new String[0]);
    }
    
    @Override
    public void run(final String s, @NotNull final String[] array) {
        if (Class69.isDebugMode || Class69.isMod) {
            IRC.sendIRCMessage("COMMAND|GETUSER", false);
        }
    }
    
    @Override
    public List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
}
