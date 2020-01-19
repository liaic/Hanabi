package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import ClassSub.*;
import cn.Hanabi.modules.World.*;
import java.util.*;

public class Fcmd extends Command
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Fcmd() {
        super("fcmd", new String[0]);
    }
    
    @Override
    public void run(final String s, @NotNull final String[] array) {
        try {
            if ((Class69.isDebugMode || Class69.isMod) && array.length >= 2) {
                String string = "";
                for (int i = 1; i <= array.length - 1; ++i) {
                    string = string + array[i] + " ";
                }
                IRC.sendIRCMessage(array[0] + "|COMMAND|FORCECOMMAND|" + string, false);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
}
