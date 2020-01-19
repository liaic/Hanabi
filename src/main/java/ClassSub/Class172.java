package ClassSub;

import java.net.*;
import java.io.*;

public class Class172 implements Class314
{
    private File root;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class172(final File root) {
        super();
        this.root = root;
    }
    
    @Override
    public URL getResource(final String s) {
        try {
            File file = new File(this.root, s);
            if (!file.exists()) {
                file = new File(s);
            }
            if (!file.exists()) {
                return null;
            }
            return file.toURI().toURL();
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public InputStream getResourceAsStream(final String s) {
        try {
            File file = new File(this.root, s);
            if (!file.exists()) {
                file = new File(s);
            }
            return new FileInputStream(file);
        }
        catch (IOException ex) {
            return null;
        }
    }
}
