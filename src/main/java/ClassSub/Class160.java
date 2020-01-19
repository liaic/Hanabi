package ClassSub;

import java.util.*;
import java.net.*;
import java.io.*;

public class Class160
{
    private static ArrayList locations;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class160() {
        super();
    }
    
    public static void addResourceLocation(final Class314 class314) {
        Class160.locations.add(class314);
    }
    
    public static void removeResourceLocation(final Class314 class314) {
        Class160.locations.remove(class314);
    }
    
    public static void removeAllResourceLocations() {
        Class160.locations.clear();
    }
    
    public static InputStream getResourceAsStream(final String s) {
        InputStream resourceAsStream = null;
        for (int i = 0; i < Class160.locations.size(); ++i) {
            resourceAsStream = ((Class314)Class160.locations.get(i)).getResourceAsStream(s);
            if (resourceAsStream != null) {
                break;
            }
        }
        if (resourceAsStream == null) {
            throw new RuntimeException("Resource not found: " + s);
        }
        return new BufferedInputStream(resourceAsStream);
    }
    
    public static boolean resourceExists(final String s) {
        for (int i = 0; i < Class160.locations.size(); ++i) {
            if (((Class314)Class160.locations.get(i)).getResource(s) != null) {
                return true;
            }
        }
        return false;
    }
    
    public static URL getResource(final String s) {
        URL resource = null;
        for (int i = 0; i < Class160.locations.size(); ++i) {
            resource = ((Class314)Class160.locations.get(i)).getResource(s);
            if (resource != null) {
                break;
            }
        }
        if (resource == null) {
            throw new RuntimeException("Resource not found: " + s);
        }
        return resource;
    }
    
    static {
        (Class160.locations = new ArrayList()).add(new Class205());
        Class160.locations.add(new Class172(new File(".")));
    }
}
