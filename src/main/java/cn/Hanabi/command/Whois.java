package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import ClassSub.*;
import cn.Hanabi.modules.World.*;
import java.util.*;

public class Whois extends Command
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Whois() {
        super("whois", new String[0]);
    }
    
    @Override
    public void run(final String s, @NotNull final String[] array) {
        if ((Class69.isDebugMode || Class69.isMod) && array.length == 1) {
            Class295.tellPlayer("§c[Whois]Trying to search §e" + array[0] + "§c...");
            for (final Map.Entry<String, String> entry : IRC.UserMap.entrySet()) {
                if (entry.getKey().toString().contains(array[0]) || entry.getValue().toString().contains(array[0])) {
                    Class295.tellPlayer("§c[Whois]§aIGN:§e" + entry.getKey().toString() + " §aUsername:§e" + (Object)entry.getValue());
                }
            }
        }
    }
    
    @Override
    public List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
}
