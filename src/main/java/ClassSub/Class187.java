package ClassSub;

import java.io.*;
import java.util.*;

public class Class187 implements Class111
{
    public static PrintStream out;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class187() {
        super();
    }
    
    @Override
    public void error(final String s, final Throwable t) {
        this.error(s);
        this.error(t);
    }
    
    @Override
    public void error(final Throwable t) {
        Class187.out.println(new Date() + " ERROR:" + t.getMessage());
        t.printStackTrace(Class187.out);
    }
    
    @Override
    public void error(final String s) {
        Class187.out.println(new Date() + " ERROR:" + s);
    }
    
    @Override
    public void warn(final String s) {
        Class187.out.println(new Date() + " WARN:" + s);
    }
    
    @Override
    public void info(final String s) {
        Class187.out.println(new Date() + " INFO:" + s);
    }
    
    @Override
    public void debug(final String s) {
        Class187.out.println(new Date() + " DEBUG:" + s);
    }
    
    @Override
    public void warn(final String s, final Throwable t) {
        this.warn(s);
        t.printStackTrace(Class187.out);
    }
    
    static {
        Class187.out = System.out;
    }
}
