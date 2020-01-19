package ClassSub;

import java.io.*;
import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.font.*;
import java.lang.reflect.*;

public class Class135 implements Class51
{
    private static final int DISPLAY_LIST_CACHE_SIZE = 200;
    private static final int MAX_GLYPH_CODE = 1114111;
    private static final int PAGE_SIZE = 512;
    private static final int PAGES = 2175;
    private static final Class12 GL;
    private static final Class24 EMPTY_DISPLAY_LIST;
    private static final Comparator heightComparator;
    private Font font;
    private String ttfFileRef;
    private int ascent;
    private int descent;
    private int leading;
    private int spaceWidth;
    private final Class182[][] glyphs;
    private final List glyphPages;
    private final List queuedGlyphs;
    private final List effects;
    private int paddingTop;
    private int paddingLeft;
    private int paddingBottom;
    private int paddingRight;
    private int paddingAdvanceX;
    private int paddingAdvanceY;
    private Class182 missingGlyph;
    private int glyphPageWidth;
    private int glyphPageHeight;
    private boolean displayListCaching;
    private int baseDisplayListID;
    private int eldestDisplayListID;
    private Class24 eldestDisplayList;
    private final LinkedHashMap displayLists;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    private static Font createFont(final String s) throws Class186 {
        try {
            return Font.createFont(0, Class160.getResourceAsStream(s));
        }
        catch (FontFormatException ex) {
            throw new Class186("Invalid font: " + s, ex);
        }
        catch (IOException ex2) {
            throw new Class186("Error reading font: " + s, ex2);
        }
    }
    
    public Class135(final String s, final String s2) throws Class186 {
        this(s, new Class243(s2));
    }
    
    public Class135(final String ttfFileRef, final Class243 class243) throws Class186 {
        super();
        this.glyphs = new Class182[2175][];
        this.glyphPages = new ArrayList();
        this.queuedGlyphs = new ArrayList(256);
        this.effects = new ArrayList();
        this.glyphPageWidth = 512;
        this.glyphPageHeight = 512;
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class33(this, 200, 1.0f, true);
        this.ttfFileRef = ttfFileRef;
        this.initializeFont(createFont(ttfFileRef), class243.getFontSize(), class243.isBold(), class243.isItalic());
        this.loadSettings(class243);
    }
    
    public Class135(final String ttfFileRef, final int n, final boolean b, final boolean b2) throws Class186 {
        super();
        this.glyphs = new Class182[2175][];
        this.glyphPages = new ArrayList();
        this.queuedGlyphs = new ArrayList(256);
        this.effects = new ArrayList();
        this.glyphPageWidth = 512;
        this.glyphPageHeight = 512;
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class33(this, 200, 1.0f, true);
        this.ttfFileRef = ttfFileRef;
        this.initializeFont(createFont(ttfFileRef), n, b, b2);
    }
    
    public Class135(final Font font, final String s) throws Class186 {
        this(font, new Class243(s));
    }
    
    public Class135(final Font font, final Class243 class243) {
        super();
        this.glyphs = new Class182[2175][];
        this.glyphPages = new ArrayList();
        this.queuedGlyphs = new ArrayList(256);
        this.effects = new ArrayList();
        this.glyphPageWidth = 512;
        this.glyphPageHeight = 512;
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class33(this, 200, 1.0f, true);
        this.initializeFont(font, class243.getFontSize(), class243.isBold(), class243.isItalic());
        this.loadSettings(class243);
    }
    
    public Class135(final Font font) {
        super();
        this.glyphs = new Class182[2175][];
        this.glyphPages = new ArrayList();
        this.queuedGlyphs = new ArrayList(256);
        this.effects = new ArrayList();
        this.glyphPageWidth = 512;
        this.glyphPageHeight = 512;
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class33(this, 200, 1.0f, true);
        this.initializeFont(font, font.getSize(), font.isBold(), font.isItalic());
    }
    
    public Class135(final Font font, final int n, final boolean b, final boolean b2) {
        super();
        this.glyphs = new Class182[2175][];
        this.glyphPages = new ArrayList();
        this.queuedGlyphs = new ArrayList(256);
        this.effects = new ArrayList();
        this.glyphPageWidth = 512;
        this.glyphPageHeight = 512;
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class33(this, 200, 1.0f, true);
        this.initializeFont(font, n, b, b2);
    }
    
    private void initializeFont(final Font font, final int n, final boolean b, final boolean b2) {
        final Map<TextAttribute, ?> attributes = font.getAttributes();
        attributes.put(TextAttribute.SIZE, new Float(n));
        attributes.put(TextAttribute.WEIGHT, b ? TextAttribute.WEIGHT_BOLD : TextAttribute.WEIGHT_REGULAR);
        attributes.put(TextAttribute.POSTURE, b2 ? TextAttribute.POSTURE_OBLIQUE : TextAttribute.POSTURE_REGULAR);
        try {
            attributes.put(TextAttribute.class.getDeclaredField("KERNING").get(null), (Object)TextAttribute.class.getDeclaredField("KERNING_ON").get(null));
        }
        catch (Exception ex) {}
        this.font = font.deriveFont(attributes);
        final FontMetrics fontMetrics = Class132.getScratchGraphics().getFontMetrics(this.font);
        this.ascent = fontMetrics.getAscent();
        this.descent = fontMetrics.getDescent();
        this.leading = fontMetrics.getLeading();
        final char[] array = (char[])" ".toCharArray();
        this.spaceWidth = this.font.layoutGlyphVector(Class132.renderContext, array, 0, array.length, 0).getGlyphLogicalBounds(0).getBounds().width;
    }
    
    private void loadSettings(final Class243 class243) {
        this.paddingTop = class243.getPaddingTop();
        this.paddingLeft = class243.getPaddingLeft();
        this.paddingBottom = class243.getPaddingBottom();
        this.paddingRight = class243.getPaddingRight();
        this.paddingAdvanceX = class243.getPaddingAdvanceX();
        this.paddingAdvanceY = class243.getPaddingAdvanceY();
        this.glyphPageWidth = class243.getGlyphPageWidth();
        this.glyphPageHeight = class243.getGlyphPageHeight();
        this.effects.addAll(class243.getEffects());
    }
    
    public void addGlyphs(final int n, final int n2) {
        for (int i = n; i <= n2; ++i) {
            this.addGlyphs(new String((char[])Character.toChars(i)));
        }
    }
    
    public void addGlyphs(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        final char[] array = (char[])s.toCharArray();
        final GlyphVector layoutGlyphVector = this.font.layoutGlyphVector(Class132.renderContext, array, 0, array.length, 0);
        for (int i = 0; i < layoutGlyphVector.getNumGlyphs(); ++i) {
            final int codePoint = s.codePointAt(layoutGlyphVector.getGlyphCharIndex(i));
            this.getGlyph(layoutGlyphVector.getGlyphCode(i), codePoint, this.getGlyphBounds(layoutGlyphVector, i, codePoint), layoutGlyphVector, i);
        }
    }
    
    public void addAsciiGlyphs() {
        this.addGlyphs(32, 255);
    }
    
    public void addNeheGlyphs() {
        this.addGlyphs(32, 128);
    }
    
    public boolean loadGlyphs() throws Class186 {
        return this.loadGlyphs(-1);
    }
    
    public boolean loadGlyphs(int n) throws Class186 {
        if (this.queuedGlyphs.isEmpty()) {
            return false;
        }
        if (this.effects.isEmpty()) {
            throw new IllegalStateException("The UnicodeFont must have at least one effect before any glyphs can be loaded.");
        }
        final Iterator<Class182> iterator = (Iterator<Class182>)this.queuedGlyphs.iterator();
        while (iterator.hasNext()) {
            final Class182 missingGlyph = (Class182)iterator.next();
            final int codePoint = missingGlyph.getCodePoint();
            if (missingGlyph.getWidth() == 0 || codePoint == 32) {
                iterator.remove();
            }
            else {
                if (!missingGlyph.isMissing()) {
                    continue;
                }
                if (this.missingGlyph != null) {
                    if (missingGlyph == this.missingGlyph) {
                        continue;
                    }
                    iterator.remove();
                }
                else {
                    this.missingGlyph = missingGlyph;
                }
            }
        }
        Collections.sort(this.queuedGlyphs, Class135.heightComparator);
        final Iterator<Class132> iterator2 = this.glyphPages.iterator();
        while (iterator2.hasNext()) {
            n -= ((Class132)iterator2.next()).loadGlyphs(this.queuedGlyphs, n);
            if (n == 0 || this.queuedGlyphs.isEmpty()) {
                return true;
            }
        }
        while (!this.queuedGlyphs.isEmpty()) {
            final Class132 class132 = new Class132(this, this.glyphPageWidth, this.glyphPageHeight);
            this.glyphPages.add(class132);
            n -= class132.loadGlyphs(this.queuedGlyphs, n);
            if (n == 0) {
                return true;
            }
        }
        return true;
    }
    
    public void clearGlyphs() {
        for (int i = 0; i < 2175; ++i) {
            this.glyphs[i] = null;
        }
        for (final Class132 class132 : this.glyphPages) {
            try {
                class132.getImage().destroy();
            }
            catch (Class186 class133) {}
        }
        this.glyphPages.clear();
        if (this.baseDisplayListID != -1) {
            Class135.GL.glDeleteLists(this.baseDisplayListID, this.displayLists.size());
            this.baseDisplayListID = -1;
        }
        this.queuedGlyphs.clear();
        this.missingGlyph = null;
    }
    
    public void destroy() {
        this.clearGlyphs();
    }
    
    public Class24 drawDisplayList(float n, float n2, final String s, final Class278 class278, final int n3, final int n4) {
        if (s == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        if (s.length() == 0) {
            return Class135.EMPTY_DISPLAY_LIST;
        }
        if (class278 == null) {
            throw new IllegalArgumentException("color cannot be null.");
        }
        n -= this.paddingLeft;
        n2 -= this.paddingTop;
        final String substring = s.substring(n3, n4);
        class278.bind();
        Class85.bindNone();
        Class24 class279 = null;
        if (this.displayListCaching && this.queuedGlyphs.isEmpty()) {
            if (this.baseDisplayListID == -1) {
                this.baseDisplayListID = Class135.GL.glGenLists(200);
                if (this.baseDisplayListID == 0) {
                    this.baseDisplayListID = -1;
                    this.displayListCaching = false;
                    return new Class24();
                }
            }
            class279 = this.displayLists.get(substring);
            if (class279 != null) {
                if (!class279.invalid) {
                    Class135.GL.glTranslatef(n, n2, 0.0f);
                    Class135.GL.glCallList(class279.id);
                    Class135.GL.glTranslatef(-n, -n2, 0.0f);
                    return class279;
                }
                class279.invalid = false;
            }
            else if (class279 == null) {
                class279 = new Class24();
                final int size = this.displayLists.size();
                this.displayLists.put(substring, class279);
                if (size < 200) {
                    class279.id = this.baseDisplayListID + size;
                }
                else {
                    class279.id = this.eldestDisplayListID;
                }
            }
            this.displayLists.put(substring, class279);
        }
        Class135.GL.glTranslatef(n, n2, 0.0f);
        if (class279 != null) {
            Class135.GL.glNewList(class279.id, 4865);
        }
        final char[] array = (char[])s.substring(0, n4).toCharArray();
        final GlyphVector layoutGlyphVector = this.font.layoutGlyphVector(Class132.renderContext, array, 0, array.length, 0);
        int max = 0;
        int max2 = 0;
        int n5 = 0;
        int n6 = 0;
        int ascent = this.ascent;
        int n7 = 0;
        Class27 class280 = null;
        for (int i = 0; i < layoutGlyphVector.getNumGlyphs(); ++i) {
            final int glyphCharIndex = layoutGlyphVector.getGlyphCharIndex(i);
            if (glyphCharIndex >= n3) {
                if (glyphCharIndex > n4) {
                    break;
                }
                final int codePoint = s.codePointAt(glyphCharIndex);
                final Rectangle glyphBounds = this.getGlyphBounds(layoutGlyphVector, i, codePoint);
                final Class182 glyph = this.getGlyph(layoutGlyphVector.getGlyphCode(i), codePoint, glyphBounds, layoutGlyphVector, i);
                if (n7 != 0 && codePoint != 10) {
                    n6 = -glyphBounds.x;
                    n7 = 0;
                }
                Class140 class281 = glyph.getImage();
                if (class281 == null && this.missingGlyph != null && glyph.isMissing()) {
                    class281 = this.missingGlyph.getImage();
                }
                if (class281 != null) {
                    final Class27 texture = class281.getTexture();
                    if (class280 != null && class280 != texture) {
                        Class135.GL.glEnd();
                        class280 = null;
                    }
                    if (class280 == null) {
                        texture.bind();
                        Class135.GL.glBegin(7);
                        class280 = texture;
                    }
                    class281.drawEmbedded(glyphBounds.x + n6, glyphBounds.y + ascent, class281.getWidth(), class281.getHeight());
                }
                if (i >= 0) {
                    n6 += this.paddingRight + this.paddingLeft + this.paddingAdvanceX;
                }
                max = Math.max(max, glyphBounds.x + n6 + glyphBounds.width);
                max2 = Math.max(max2, this.ascent + glyphBounds.y + glyphBounds.height);
                if (codePoint == 10) {
                    n7 = 1;
                    ascent += this.getLineHeight();
                    ++n5;
                    max2 = 0;
                }
            }
        }
        if (class280 != null) {
            Class135.GL.glEnd();
        }
        if (class279 != null) {
            Class135.GL.glEndList();
            if (!this.queuedGlyphs.isEmpty()) {
                class279.invalid = true;
            }
        }
        Class135.GL.glTranslatef(-n, -n2, 0.0f);
        if (class279 == null) {
            class279 = new Class24();
        }
        class279.width = (short)max;
        class279.height = (short)(n5 * this.getLineHeight() + max2);
        return class279;
    }
    
    @Override
    public void drawString(final float n, final float n2, final String s, final Class278 class278, final int n3, final int n4) {
        this.drawDisplayList(n, n2, s, class278, n3, n4);
    }
    
    @Override
    public void drawString(final float n, final float n2, final String s) {
        this.drawString(n, n2, s, Class278.white);
    }
    
    @Override
    public void drawString(final float n, final float n2, final String s, final Class278 class278) {
        this.drawString(n, n2, s, class278, 0, s.length());
    }
    
    private Class182 getGlyph(final int n, final int n2, final Rectangle rectangle, final GlyphVector glyphVector, final int n3) {
        class Class168 extends Class182
        {
            final Class135 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class168(final Class135 this$0, final int n, final Rectangle rectangle, final GlyphVector glyphVector, final int n2, final Class135 class135) {
                this.this$0 = this$0;
                super(n, rectangle, glyphVector, n2, class135);
            }
            
            @Override
            public boolean isMissing() {
                return true;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: iload_1        
        //     6: iflt            15
        //     9: iload_1        
        //    10: ldc             1114111
        //    12: if_icmplt       36
        //    15: new             LClassSub/Class168;
        //    18: dup            
        //    19: aload_0        
        //    20: iload_2        
        //    21: aload_3        
        //    22: aload           4
        //    24: iload           5
        //    26: aload_0        
        //    27: invokespecial   ClassSub/Class168.<init>:(LClassSub/Class135;ILjava/awt/Rectangle;Ljava/awt/font/GlyphVector;ILClassSub/Class135;)V
        //    30: areturn        
        //    31: nop            
        //    32: nop            
        //    33: nop            
        //    34: nop            
        //    35: athrow         
        //    36: iload_1        
        //    37: ldc             512
        //    39: idiv           
        //    40: istore          6
        //    42: iload_1        
        //    43: ldc_w           511
        //    46: iand           
        //    47: istore          7
        //    49: aconst_null    
        //    50: astore          8
        //    52: aload_0        
        //    53: getfield        ClassSub/Class135.glyphs:[[LClassSub/Class182;
        //    56: iload           6
        //    58: aaload         
        //    59: astore          9
        //    61: aload           9
        //    63: ifnull          86
        //    66: aload           9
        //    68: iload           7
        //    70: aaload         
        //    71: astore          8
        //    73: aload           8
        //    75: ifnull          101
        //    78: aload           8
        //    80: areturn        
        //    81: nop            
        //    82: nop            
        //    83: nop            
        //    84: nop            
        //    85: athrow         
        //    86: aload_0        
        //    87: getfield        ClassSub/Class135.glyphs:[[LClassSub/Class182;
        //    90: iload           6
        //    92: ldc             512
        //    94: anewarray       LClassSub/Class182;
        //    97: dup_x2         
        //    98: aastore        
        //    99: astore          9
        //   101: aload           9
        //   103: iload           7
        //   105: new             LClassSub/Class182;
        //   108: dup            
        //   109: iload_2        
        //   110: aload_3        
        //   111: aload           4
        //   113: iload           5
        //   115: aload_0        
        //   116: invokespecial   ClassSub/Class182.<init>:(ILjava/awt/Rectangle;Ljava/awt/font/GlyphVector;ILClassSub/Class135;)V
        //   119: dup_x2         
        //   120: aastore        
        //   121: astore          8
        //   123: aload_0        
        //   124: getfield        ClassSub/Class135.queuedGlyphs:Ljava/util/List;
        //   127: aload           8
        //   129: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   132: pop            
        //   133: aload           8
        //   135: areturn        
        //   136: nop            
        //   137: nop            
        //   138: nop            
        //   139: nop            
        //   140: athrow         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:324)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.convertType(AstBuilder.java:153)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1120)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:437)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private Rectangle getGlyphBounds(final GlyphVector glyphVector, final int n, final int n2) {
        final Rectangle glyphPixelBounds = glyphVector.getGlyphPixelBounds(n, Class132.renderContext, 0.0f, 0.0f);
        if (n2 == 32) {
            glyphPixelBounds.width = this.spaceWidth;
        }
        return glyphPixelBounds;
    }
    
    public int getSpaceWidth() {
        return this.spaceWidth;
    }
    
    @Override
    public int getWidth(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        if (s.length() == 0) {
            return 0;
        }
        if (this.displayListCaching) {
            final Class24 class24 = (Class24)this.displayLists.get(s);
            if (class24 != null) {
                return class24.width;
            }
        }
        final char[] array = (char[])s.toCharArray();
        final GlyphVector layoutGlyphVector = this.font.layoutGlyphVector(Class132.renderContext, array, 0, array.length, 0);
        int max = 0;
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < layoutGlyphVector.getNumGlyphs(); ++i) {
            final int codePoint = s.codePointAt(layoutGlyphVector.getGlyphCharIndex(i));
            final Rectangle glyphBounds = this.getGlyphBounds(layoutGlyphVector, i, codePoint);
            if (n2 != 0 && codePoint != 10) {
                n = -glyphBounds.x;
            }
            if (i > 0) {
                n += this.paddingLeft + this.paddingRight + this.paddingAdvanceX;
            }
            max = Math.max(max, glyphBounds.x + n + glyphBounds.width);
            if (codePoint == 10) {
                n2 = 1;
            }
        }
        return max;
    }
    
    @Override
    public int getHeight(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        if (s.length() == 0) {
            return 0;
        }
        if (this.displayListCaching) {
            final Class24 class24 = (Class24)this.displayLists.get(s);
            if (class24 != null) {
                return class24.height;
            }
        }
        final char[] array = (char[])s.toCharArray();
        final GlyphVector layoutGlyphVector = this.font.layoutGlyphVector(Class132.renderContext, array, 0, array.length, 0);
        int n = 0;
        int max = 0;
        for (int i = 0; i < layoutGlyphVector.getNumGlyphs(); ++i) {
            final int codePoint = s.codePointAt(layoutGlyphVector.getGlyphCharIndex(i));
            if (codePoint != 32) {
                final Rectangle glyphBounds = this.getGlyphBounds(layoutGlyphVector, i, codePoint);
                max = Math.max(max, this.ascent + glyphBounds.y + glyphBounds.height);
                if (codePoint == 10) {
                    ++n;
                    max = 0;
                }
            }
        }
        return n * this.getLineHeight() + max;
    }
    
    public int getYOffset(String substring) {
        if (substring == null) {
            throw new IllegalArgumentException("text cannot be null.");
        }
        Class24 class24 = null;
        if (this.displayListCaching) {
            class24 = this.displayLists.get(substring);
            if (class24 != null && class24.yOffset != null) {
                return class24.yOffset;
            }
        }
        final int index = substring.indexOf(10);
        if (index != -1) {
            substring = substring.substring(0, index);
        }
        final char[] array = (char[])substring.toCharArray();
        final int n = this.ascent + this.font.layoutGlyphVector(Class132.renderContext, array, 0, array.length, 0).getPixelBounds(null, 0.0f, 0.0f).y;
        if (class24 != null) {
            class24.yOffset = new Short((short)n);
        }
        return n;
    }
    
    public Font getFont() {
        return this.font;
    }
    
    public int getPaddingTop() {
        return this.paddingTop;
    }
    
    public void setPaddingTop(final int paddingTop) {
        this.paddingTop = paddingTop;
    }
    
    public int getPaddingLeft() {
        return this.paddingLeft;
    }
    
    public void setPaddingLeft(final int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }
    
    public int getPaddingBottom() {
        return this.paddingBottom;
    }
    
    public void setPaddingBottom(final int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }
    
    public int getPaddingRight() {
        return this.paddingRight;
    }
    
    public void setPaddingRight(final int paddingRight) {
        this.paddingRight = paddingRight;
    }
    
    public int getPaddingAdvanceX() {
        return this.paddingAdvanceX;
    }
    
    public void setPaddingAdvanceX(final int paddingAdvanceX) {
        this.paddingAdvanceX = paddingAdvanceX;
    }
    
    public int getPaddingAdvanceY() {
        return this.paddingAdvanceY;
    }
    
    public void setPaddingAdvanceY(final int paddingAdvanceY) {
        this.paddingAdvanceY = paddingAdvanceY;
    }
    
    @Override
    public int getLineHeight() {
        return this.descent + this.ascent + this.leading + this.paddingTop + this.paddingBottom + this.paddingAdvanceY;
    }
    
    public int getAscent() {
        return this.ascent;
    }
    
    public int getDescent() {
        return this.descent;
    }
    
    public int getLeading() {
        return this.leading;
    }
    
    public int getGlyphPageWidth() {
        return this.glyphPageWidth;
    }
    
    public void setGlyphPageWidth(final int glyphPageWidth) {
        this.glyphPageWidth = glyphPageWidth;
    }
    
    public int getGlyphPageHeight() {
        return this.glyphPageHeight;
    }
    
    public void setGlyphPageHeight(final int glyphPageHeight) {
        this.glyphPageHeight = glyphPageHeight;
    }
    
    public List getGlyphPages() {
        return this.glyphPages;
    }
    
    public List getEffects() {
        return this.effects;
    }
    
    public boolean isCaching() {
        return this.displayListCaching;
    }
    
    public void setDisplayListCaching(final boolean displayListCaching) {
        this.displayListCaching = displayListCaching;
    }
    
    public String getFontFile() {
        if (this.ttfFileRef == null) {
            try {
                final Object invoke = Class.forName("sun.font.FontManager").getDeclaredMethod("getFont2D", Font.class).invoke(null, this.font);
                final Field declaredField = Class.forName("sun.font.PhysicalFont").getDeclaredField("platName");
                declaredField.setAccessible(true);
                this.ttfFileRef = (String)declaredField.get(invoke);
            }
            catch (Throwable t) {}
            if (this.ttfFileRef == null) {
                this.ttfFileRef = "";
            }
        }
        if (this.ttfFileRef.length() == 0) {
            return null;
        }
        return this.ttfFileRef;
    }
    
    static int access$002(final Class135 class135, final int eldestDisplayListID) {
        return class135.eldestDisplayListID = eldestDisplayListID;
    }
    
    static {
        GL = Class83.get();
        EMPTY_DISPLAY_LIST = new Class24();
        heightComparator = new Class196();
    }
}
