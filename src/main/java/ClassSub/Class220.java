package ClassSub;

import java.util.*;
import net.minecraft.client.*;
import java.io.*;

public class Class220
{
    public static ArrayList<Class77> Files;
    private static File directory;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class220() {
        super();
        this.makeDirectories();
        Class220.Files.add(new Class169("alts", false, true));
    }
    
    public void loadFiles() {
        for (final Class77 class77 : Class220.Files) {
            try {
                if (!Class77.access$000(class77)) {
                    continue;
                }
                class77.loadFile();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void saveFiles() {
        for (final Class77 class77 : Class220.Files) {
            try {
                class77.saveFile();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Class77 getFile(final Class<? extends Class77> clazz) {
        for (final Class77 class77 : Class220.Files) {
            if (class77.getClass() != clazz) {
                continue;
            }
            return class77;
        }
        return null;
    }
    
    public void makeDirectories() {
        try {
            if (!Class220.directory.exists()) {
                if (Class220.directory.mkdir()) {
                    System.out.println("Directory is created!");
                }
                else {
                    System.out.println("Failed to create directory!");
                }
            }
        }
        catch (Exception ex) {
            throw new RuntimeException();
        }
    }
    
    static File access$100() {
        return Class220.directory;
    }
    
    static {
        Class220.Files = new ArrayList<Class77>();
        Class220.directory = new File(String.valueOf((Object)Minecraft.func_71410_x().field_71412_D.toString()) + "\\" + "Hanabi");
    }
}
