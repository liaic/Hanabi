package ClassSub;

import java.io.*;
import java.util.*;

public class Class169 extends Class220.Class77
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class169(final String s, final boolean b, final boolean b2) {
        super(s, b, b2);
    }
    
    @Override
    public void loadFile() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] array = (String[])line.split(":");
            for (int i = 0; i < 2; ++i) {
                array[i].replace(" ", "");
            }
            if (array.length > 2) {
                Class91.registry.add(new Class98(array[0], array[1], array[2]));
            }
            else {
                Class91.registry.add(new Class98(array[0], array[1]));
            }
        }
        bufferedReader.close();
        System.out.println("Loaded " + this.getName() + " File!");
    }
    
    @Override
    public void saveFile() throws IOException {
        final PrintWriter printWriter = new PrintWriter(new FileWriter(this.getFile()));
        for (final Class98 class98 : Class91.registry) {
            if (class98.getMask().equals("")) {
                printWriter.println(String.valueOf((Object)class98.getUsername()) + ":" + class98.getPassword());
            }
            else {
                printWriter.println(String.valueOf((Object)class98.getUsername()) + ":" + class98.getPassword() + ":" + class98.getMask());
            }
        }
        printWriter.close();
    }
}
