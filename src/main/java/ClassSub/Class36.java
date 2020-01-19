package ClassSub;

import java.io.*;
import java.util.*;

public class Class36 implements Class51
{
    private static Class12 GL;
    private static final int DISPLAY_LIST_CACHE_SIZE = 200;
    private static final int MAX_CHAR = 255;
    private boolean displayListCaching;
    private Class140 fontImage;
    private Class203[] chars;
    private int lineHeight;
    private int baseDisplayListID;
    private int eldestDisplayListID;
    private Class260 eldestDisplayList;
    private final LinkedHashMap displayLists;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class36(final String s, final Class140 fontImage) throws Class186 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class130(this, 200, 1.0f, true);
        this.fontImage = fontImage;
        this.parseFnt(Class160.getResourceAsStream(s));
    }
    
    public Class36(final String s, final String s2) throws Class186 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class130(this, 200, 1.0f, true);
        this.fontImage = new Class140(s2);
        this.parseFnt(Class160.getResourceAsStream(s));
    }
    
    public Class36(final String s, final Class140 fontImage, final boolean displayListCaching) throws Class186 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class130(this, 200, 1.0f, true);
        this.fontImage = fontImage;
        this.displayListCaching = displayListCaching;
        this.parseFnt(Class160.getResourceAsStream(s));
    }
    
    public Class36(final String s, final String s2, final boolean displayListCaching) throws Class186 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class130(this, 200, 1.0f, true);
        this.fontImage = new Class140(s2);
        this.displayListCaching = displayListCaching;
        this.parseFnt(Class160.getResourceAsStream(s));
    }
    
    public Class36(final String s, final InputStream inputStream, final InputStream inputStream2) throws Class186 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class130(this, 200, 1.0f, true);
        this.fontImage = new Class140(inputStream2, s, false);
        this.parseFnt(inputStream);
    }
    
    public Class36(final String s, final InputStream inputStream, final InputStream inputStream2, final boolean displayListCaching) throws Class186 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class130(this, 200, 1.0f, true);
        this.fontImage = new Class140(inputStream2, s, false);
        this.displayListCaching = displayListCaching;
        this.parseFnt(inputStream);
    }
    
    private void parseFnt(final InputStream inputStream) throws Class186 {
        if (this.displayListCaching) {
            this.baseDisplayListID = Class36.GL.glGenLists(200);
            if (this.baseDisplayListID == 0) {
                this.displayListCaching = false;
            }
        }
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            final HashMap<Object, Object> hashMap = new HashMap<Object, Object>(64);
            final ArrayList<Class203> list = new ArrayList<Class203>(255);
            int max = 0;
            int i = 0;
            while (i == 0) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    i = 1;
                }
                else {
                    if (!line.startsWith("chars c")) {
                        if (line.startsWith("char")) {
                            final Class203 char1 = this.parseChar(line);
                            if (char1 != null) {
                                max = Math.max(max, char1.id);
                                list.add(char1);
                            }
                        }
                    }
                    if (line.startsWith("kernings c")) {
                        continue;
                    }
                    if (!line.startsWith("kerning")) {
                        continue;
                    }
                    final StringTokenizer stringTokenizer = new StringTokenizer(line, " =");
                    stringTokenizer.nextToken();
                    stringTokenizer.nextToken();
                    final short short1 = Short.parseShort(stringTokenizer.nextToken());
                    stringTokenizer.nextToken();
                    final int int1 = Integer.parseInt(stringTokenizer.nextToken());
                    stringTokenizer.nextToken();
                    final int int2 = Integer.parseInt(stringTokenizer.nextToken());
                    List<?> list2 = (List<?>)hashMap.get(new Short(short1));
                    if (list2 == null) {
                        list2 = new ArrayList<Object>();
                        hashMap.put(new Short(short1), list2);
                    }
                    list2.add(new Short((short)(int2 << 8 | int1)));
                }
            }
            this.chars = new Class203[max + 1];
            for (final Class203 class203 : list) {
                this.chars[class203.id] = class203;
            }
            for (final Map.Entry<Short, List<Short>> entry : hashMap.entrySet()) {
                final short shortValue = (short)entry.getKey();
                final List<Short> list3 = (List<Short>)entry.getValue();
                final short[] kerning = new short[list3.size()];
                int n = 0;
                final Iterator<Short> iterator3 = list3.iterator();
                while (iterator3.hasNext()) {
                    kerning[n] = iterator3.next();
                    ++n;
                }
                this.chars[shortValue].kerning = kerning;
            }
        }
        catch (IOException ex) {
            Class121.error(ex);
            throw new Class186("Failed to parse font file: " + inputStream);
        }
    }
    
    private Class203 parseChar(final String s) throws Class186 {
        final Class203 class203 = new Class203((Class130)null);
        final StringTokenizer stringTokenizer = new StringTokenizer(s, " =");
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        class203.id = Short.parseShort(stringTokenizer.nextToken());
        if (class203.id < 0) {
            return null;
        }
        if (class203.id > 255) {
            throw new Class186("Invalid character '" + class203.id + "': AngelCodeFont does not support characters above " + 255);
        }
        stringTokenizer.nextToken();
        class203.x = Short.parseShort(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        class203.y = Short.parseShort(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        class203.width = Short.parseShort(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        class203.height = Short.parseShort(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        class203.xoffset = Short.parseShort(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        class203.yoffset = Short.parseShort(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        class203.xadvance = Short.parseShort(stringTokenizer.nextToken());
        class203.init();
        if (class203.id != 32) {
            this.lineHeight = Math.max(class203.height + class203.yoffset, this.lineHeight);
        }
        return class203;
    }
    
    @Override
    public void drawString(final float n, final float n2, final String s) {
        this.drawString(n, n2, s, Class278.white);
    }
    
    @Override
    public void drawString(final float n, final float n2, final String s, final Class278 class278) {
        this.drawString(n, n2, s, class278, 0, s.length() - 1);
    }
    
    @Override
    public void drawString(final float n, final float n2, final String text, final Class278 class278, final int n3, final int n4) {
        this.fontImage.bind();
        class278.bind();
        Class36.GL.glTranslatef(n, n2, 0.0f);
        if (this.displayListCaching && n3 == 0 && n4 == text.length() - 1) {
            final Class260 class279 = (Class260)this.displayLists.get(text);
            if (class279 != null) {
                Class36.GL.glCallList(class279.id);
            }
            else {
                final Class260 class280 = new Class260(null);
                class280.text = text;
                final int size = this.displayLists.size();
                if (size < 200) {
                    class280.id = this.baseDisplayListID + size;
                }
                else {
                    class280.id = this.eldestDisplayListID;
                    this.displayLists.remove(this.eldestDisplayList.text);
                }
                this.displayLists.put(text, class280);
                Class36.GL.glNewList(class280.id, 4865);
                this.render(text, n3, n4);
                Class36.GL.glEndList();
            }
        }
        else {
            this.render(text, n3, n4);
        }
        Class36.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    private void render(final String s, final int n, final int n2) {
        Class36.GL.glBegin(7);
        int n3 = 0;
        int n4 = 0;
        Class203 class203 = null;
        final char[] array = (char[])s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            final char c = array[i];
            if (c == '\n') {
                n3 = 0;
                n4 += this.getLineHeight();
            }
            else if (c < this.chars.length) {
                final Class203 class204 = this.chars[c];
                if (class204 != null) {
                    if (class203 != null) {
                        n3 += class203.getKerning(c);
                    }
                    class203 = class204;
                    if (i >= n && i <= n2) {
                        class204.draw(n3, n4);
                    }
                    n3 += class204.xadvance;
                }
            }
        }
        Class36.GL.glEnd();
    }
    
    public int getYOffset(final String s) {
        Class260 class260 = null;
        if (this.displayListCaching) {
            class260 = this.displayLists.get(s);
            if (class260 != null && class260.yOffset != null) {
                return class260.yOffset;
            }
        }
        int n = s.indexOf(10);
        if (n == -1) {
            n = s.length();
        }
        int min = 10000;
        for (int i = 0; i < n; ++i) {
            final Class203 class261 = this.chars[s.charAt(i)];
            if (class261 != null) {
                min = Math.min(class261.yoffset, min);
            }
        }
        if (class260 != null) {
            class260.yOffset = new Short((short)min);
        }
        return min;
    }
    
    @Override
    public int getHeight(final String s) {
        Class260 class260 = null;
        if (this.displayListCaching) {
            class260 = this.displayLists.get(s);
            if (class260 != null && class260.height != null) {
                return class260.height;
            }
        }
        int n = 0;
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '\n') {
                ++n;
                max = 0;
            }
            else if (char1 != ' ') {
                final Class203 class261 = this.chars[char1];
                if (class261 != null) {
                    max = Math.max(class261.height + class261.yoffset, max);
                }
            }
        }
        final int n2 = max + n * this.getLineHeight();
        if (class260 != null) {
            class260.height = new Short((short)n2);
        }
        return n2;
    }
    
    @Override
    public int getWidth(final String s) {
        Class260 class260 = null;
        if (this.displayListCaching) {
            class260 = this.displayLists.get(s);
            if (class260 != null && class260.width != null) {
                return class260.width;
            }
        }
        int max = 0;
        int n = 0;
        Class203 class261 = null;
        for (int i = 0, length = s.length(); i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '\n') {
                n = 0;
            }
            else if (char1 < this.chars.length) {
                final Class203 class262 = this.chars[char1];
                if (class262 != null) {
                    if (class261 != null) {
                        n += class261.getKerning(char1);
                    }
                    class261 = class262;
                    if (i < length - 1) {
                        n += class262.xadvance;
                    }
                    else {
                        n += class262.width;
                    }
                    max = Math.max(max, n);
                }
            }
        }
        if (class260 != null) {
            class260.width = new Short((short)max);
        }
        return max;
    }
    
    @Override
    public int getLineHeight() {
        return this.lineHeight;
    }
    
    static Class260 access$002(final Class36 class36, final Class260 eldestDisplayList) {
        return class36.eldestDisplayList = eldestDisplayList;
    }
    
    static int access$102(final Class36 class36, final int eldestDisplayListID) {
        return class36.eldestDisplayListID = eldestDisplayListID;
    }
    
    static Class260 access$000(final Class36 class36) {
        return class36.eldestDisplayList;
    }
    
    static Class140 access$400(final Class36 class36) {
        return class36.fontImage;
    }
    
    static {
        Class36.GL = Class83.get();
    }
}
