package ClassSub;

import java.io.*;

public abstract static class Class77
{
    private final File file;
    private final String name;
    private boolean load;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class77(final String name, final boolean b, final boolean load) {
        super();
        this.name = name;
        this.load = load;
        this.file = new File(Class220.access$100(), String.valueOf((Object)name) + ".txt");
        if (!this.file.exists()) {
            try {
                this.saveFile();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public final File getFile() {
        return this.file;
    }
    
    private boolean loadOnStart() {
        return this.load;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public abstract void loadFile() throws IOException;
    
    public abstract void saveFile() throws IOException;
    
    static boolean access$000(final Class77 class77) {
        return class77.loadOnStart();
    }
}
