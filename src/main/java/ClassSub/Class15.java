package ClassSub;

import java.io.*;

public class Class15
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class15() {
        super();
    }
    
    public static Class27 getTexture(final String s, final InputStream inputStream) throws IOException {
        return getTexture(s, inputStream, false, 9729);
    }
    
    public static Class27 getTexture(final String s, final InputStream inputStream, final boolean b) throws IOException {
        return getTexture(s, inputStream, b, 9729);
    }
    
    public static Class27 getTexture(final String s, final InputStream inputStream, final int n) throws IOException {
        return getTexture(s, inputStream, false, n);
    }
    
    public static Class27 getTexture(final String s, final InputStream inputStream, final boolean b, final int n) throws IOException {
        return Class6.get().getTexture(inputStream, inputStream.toString() + "." + s, b, n);
    }
}
