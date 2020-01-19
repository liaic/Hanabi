package ClassSub;

import java.awt.font.*;
import java.awt.image.*;
import java.util.*;
import java.nio.*;
import java.awt.*;

public class Class132
{
    private static final Class12 GL;
    public static final int MAX_GLYPH_SIZE = 256;
    private static ByteBuffer scratchByteBuffer;
    private static IntBuffer scratchIntBuffer;
    private static BufferedImage scratchImage;
    private static Graphics2D scratchGraphics;
    public static FontRenderContext renderContext;
    private final Class135 unicodeFont;
    private final int pageWidth;
    private final int pageHeight;
    private final Class140 pageImage;
    private int pageX;
    private int pageY;
    private int rowHeight;
    private boolean orderAscending;
    private final List pageGlyphs;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public static Graphics2D getScratchGraphics() {
        return Class132.scratchGraphics;
    }
    
    public Class132(final Class135 unicodeFont, final int pageWidth, final int pageHeight) throws Class186 {
        super();
        this.pageGlyphs = new ArrayList(32);
        this.unicodeFont = unicodeFont;
        this.pageWidth = pageWidth;
        this.pageHeight = pageHeight;
        this.pageImage = new Class140(pageWidth, pageHeight);
    }
    
    public int loadGlyphs(final List list, final int n) throws Class186 {
        if (this.rowHeight != 0 && n == -1) {
            int pageX = this.pageX;
            int pageY = this.pageY;
            int rowHeight = this.rowHeight;
            final Iterator iterator = this.getIterator(list);
            while (iterator.hasNext()) {
                final Class182 class182 = (Class182)iterator.next();
                final int width = class182.getWidth();
                final int height = class182.getHeight();
                if (pageX + width >= this.pageWidth) {
                    pageX = 0;
                    pageY += rowHeight;
                    rowHeight = height;
                }
                else if (height > rowHeight) {
                    rowHeight = height;
                }
                if (pageY + rowHeight >= this.pageWidth) {
                    return 0;
                }
                pageX += width;
            }
        }
        Class278.white.bind();
        this.pageImage.bind();
        int n2 = 0;
        final Iterator iterator2 = this.getIterator(list);
        while (iterator2.hasNext()) {
            final Class182 class183 = (Class182)iterator2.next();
            final int min = Math.min(256, class183.getWidth());
            final int min2 = Math.min(256, class183.getHeight());
            if (this.rowHeight == 0) {
                this.rowHeight = min2;
            }
            else if (this.pageX + min >= this.pageWidth) {
                if (this.pageY + this.rowHeight + min2 >= this.pageHeight) {
                    break;
                }
                this.pageX = 0;
                this.pageY += this.rowHeight;
                this.rowHeight = min2;
            }
            else if (min2 > this.rowHeight) {
                if (this.pageY + min2 >= this.pageHeight) {
                    break;
                }
                this.rowHeight = min2;
            }
            this.renderGlyph(class183, min, min2);
            this.pageGlyphs.add(class183);
            this.pageX += min;
            iterator2.remove();
            if (++n2 == n) {
                this.orderAscending = !this.orderAscending;
                break;
            }
        }
        Class85.bindNone();
        this.orderAscending = !this.orderAscending;
        return n2;
    }
    
    private void renderGlyph(final Class182 class182, final int n, final int n2) throws Class186 {
        Class132.scratchGraphics.setComposite(AlphaComposite.Clear);
        Class132.scratchGraphics.fillRect(0, 0, 256, 256);
        Class132.scratchGraphics.setComposite(AlphaComposite.SrcOver);
        Class132.scratchGraphics.setColor(Color.white);
        final Iterator<Class74> iterator = (Iterator<Class74>)this.unicodeFont.getEffects().iterator();
        while (iterator.hasNext()) {
            ((Class74)iterator.next()).draw(Class132.scratchImage, Class132.scratchGraphics, this.unicodeFont, class182);
        }
        class182.setShape(null);
        final WritableRaster raster = Class132.scratchImage.getRaster();
        final int[] array = new int[n];
        for (int i = 0; i < n2; ++i) {
            raster.getDataElements(0, i, n, 1, array);
            Class132.scratchIntBuffer.put(array);
        }
        Class132.GL.glTexSubImage2D(3553, 0, this.pageX, this.pageY, n, n2, 32993, 5121, Class132.scratchByteBuffer);
        Class132.scratchIntBuffer.clear();
        class182.setImage(this.pageImage.getSubImage(this.pageX, this.pageY, n, n2));
    }
    
    private Iterator getIterator(final List list) {
        class Class275 implements Iterator
        {
            final ListIterator val$iter;
            final Class132 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class275(final Class132 this$0, final ListIterator val$iter) {
                this.this$0 = this$0;
                this.val$iter = val$iter;
                super();
            }
            
            @Override
            public boolean hasNext() {
                return this.val$iter.hasPrevious();
            }
            
            @Override
            public Object next() {
                return this.val$iter.previous();
            }
            
            @Override
            public void remove() {
                this.val$iter.remove();
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: aload_0        
        //     6: getfield        ClassSub/Class132.orderAscending:Z
        //     9: ifeq            21
        //    12: aload_1        
        //    13: invokevirtual   java/util/List.iterator:()Ljava/util/Iterator;
        //    16: areturn        
        //    17: nop            
        //    18: nop            
        //    19: nop            
        //    20: athrow         
        //    21: aload_1        
        //    22: aload_1        
        //    23: invokevirtual   java/util/List.size:()I
        //    26: invokevirtual   java/util/List.listIterator:(I)Ljava/util/ListIterator;
        //    29: astore_2       
        //    30: new             LClassSub/Class275;
        //    33: dup            
        //    34: aload_0        
        //    35: aload_2        
        //    36: invokespecial   ClassSub/Class275.<init>:(LClassSub/Class132;Ljava/util/ListIterator;)V
        //    39: areturn        
        //    40: nop            
        //    41: nop            
        //    42: nop            
        //    43: athrow         
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
    
    public List getGlyphs() {
        return this.pageGlyphs;
    }
    
    public Class140 getImage() {
        return this.pageImage;
    }
    
    static {
        GL = Class83.get();
        (Class132.scratchByteBuffer = ByteBuffer.allocateDirect(262144)).order(ByteOrder.LITTLE_ENDIAN);
        Class132.scratchIntBuffer = Class132.scratchByteBuffer.asIntBuffer();
        Class132.scratchImage = new BufferedImage(256, 256, 2);
        (Class132.scratchGraphics = (Graphics2D)Class132.scratchImage.getGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Class132.scratchGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Class132.scratchGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        Class132.renderContext = Class132.scratchGraphics.getFontRenderContext();
    }
}
