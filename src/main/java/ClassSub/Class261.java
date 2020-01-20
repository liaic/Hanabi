package ClassSub;

import java.io.*;
import java.util.*;

public class Class261 extends IOException
{
    private ArrayList exceptions;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class261() {
        this.exceptions = new ArrayList();
    }
    
    public void addException(final Exception ex) {
        this.exceptions.add(ex);
    }
    
    @Override
    public String getMessage() {
        String string = "Composite Exception: \n";
        for (int i = 0; i < this.exceptions.size(); ++i) {
            string = string + "\t" + ((IOException)this.exceptions.get(i)).getMessage() + "\n";
        }
        return string;
    }
}
