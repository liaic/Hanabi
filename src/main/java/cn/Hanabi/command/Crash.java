package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import cn.Hanabi.modules.World.*;
import ClassSub.*;
import java.util.*;

public class Crash extends Command
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Crash() {
        super("crash", new String[0]);
    }
    
    @Override
    public void run(final String s, @NotNull final String[] array) {
        if (Class69.isDebugMode || Class69.isMod) {
            IRC.sendIRCMessage(array[0] + "|CrashCrashCrashCrashCrash", false);
            Class295.tellPlayer("§cCrashing...");
        }
    }
    
    @Override
    public List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
}
