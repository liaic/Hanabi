package ClassSub;

import cn.Hanabi.value.*;
import java.awt.*;
import cn.Hanabi.*;
import cn.Hanabi.utils.fontmanager.*;
import org.lwjgl.input.*;

public class Class291
{
    Value<String> value;
    int x;
    int y;
    private boolean readySelect;
    private boolean isSelectingMode;
    double ani;
    public static Value<String> renderingValue;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class291(final Value value) {
        super();
        this.value = (Value<String>)value;
    }
    
    public void draw(final int n, final int n2, final int n3, final int n4) {
        class Class224 extends Thread
        {
            final Class291 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class224(final Class291 this$0) {
                this.this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(50L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Class291.renderingValue = null;
            }
        }
        class Class256 extends Thread
        {
            final Class291 val$selector;
            final Class291 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class256(final Class291 this$0, final Class291 val$selector) {
                this.this$0 = this$0;
                this.val$selector = val$selector;
                super();
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(50L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Class291.access$002(this.val$selector, false);
                Class291.access$102(this.val$selector, false);
                Class291.renderingValue = null;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: getfield        ClassSub/Class291.isSelectingMode:Z
        //     8: ifeq            18
        //    11: aload_0        
        //    12: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //    15: putstatic       ClassSub/Class291.renderingValue:Lcn/Hanabi/value/Value;
        //    18: getstatic       ClassSub/Class291.renderingValue:Lcn/Hanabi/value/Value;
        //    21: ifnull          40
        //    24: getstatic       ClassSub/Class291.renderingValue:Lcn/Hanabi/value/Value;
        //    27: aload_0        
        //    28: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //    31: if_acmpeq       40
        //    34: return         
        //    35: nop            
        //    36: nop            
        //    37: nop            
        //    38: nop            
        //    39: athrow         
        //    40: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //    43: ldc             "Light"
        //    45: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //    48: istore          5
        //    50: iload_2        
        //    51: ldc             5
        //    53: isub           
        //    54: i2f            
        //    55: fstore          6
        //    57: fload           6
        //    59: ldc             7.0
        //    61: fadd           
        //    62: fstore          7
        //    64: aload_0        
        //    65: aload_0        
        //    66: getfield        ClassSub/Class291.ani:D
        //    69: aload_0        
        //    70: getfield        ClassSub/Class291.isSelectingMode:Z
        //    73: ifeq            94
        //    76: ldc             20
        //    78: aload_0        
        //    79: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //    82: getfield        cn/Hanabi/value/Value.mode:Ljava/util/ArrayList;
        //    85: invokevirtual   java/util/ArrayList.size:()I
        //    88: imul           
        //    89: goto            96
        //    92: nop            
        //    93: athrow         
        //    94: ldc             20
        //    96: i2d            
        //    97: ldc2_w          400.0
        //   100: invokestatic    ClassSub/Class284.getAnimationState:(DDD)D
        //   103: putfield        ClassSub/Class291.ani:D
        //   106: iload_1        
        //   107: ldc             80
        //   109: isub           
        //   110: i2f            
        //   111: fload           6
        //   113: iload_1        
        //   114: ldc             20
        //   116: isub           
        //   117: i2f            
        //   118: fload           6
        //   120: f2d            
        //   121: aload_0        
        //   122: getfield        ClassSub/Class291.ani:D
        //   125: dadd           
        //   126: d2f            
        //   127: fconst_2       
        //   128: iload           5
        //   130: ifeq            157
        //   133: new             Ljava/awt/Color;
        //   136: dup            
        //   137: getstatic       ClassSub/Class59.GREY:LClassSub/Class59;
        //   140: getfield        ClassSub/Class59.c:I
        //   143: invokespecial   java/awt/Color.<init>:(I)V
        //   146: invokevirtual   java/awt/Color.brighter:()Ljava/awt/Color;
        //   149: invokevirtual   java/awt/Color.getRGB:()I
        //   152: goto            173
        //   155: nop            
        //   156: athrow         
        //   157: new             Ljava/awt/Color;
        //   160: dup            
        //   161: ldc             15
        //   163: ldc             15
        //   165: ldc             15
        //   167: invokespecial   java/awt/Color.<init>:(III)V
        //   170: invokevirtual   java/awt/Color.getRGB:()I
        //   173: invokestatic    ClassSub/Class284.drawRoundedRect:(FFFFFI)V
        //   176: iload_1        
        //   177: ldc             80
        //   179: isub           
        //   180: i2f            
        //   181: fload           6
        //   183: iload_1        
        //   184: ldc             20
        //   186: isub           
        //   187: i2f            
        //   188: fload           6
        //   190: ldc             20.0
        //   192: fadd           
        //   193: fconst_2       
        //   194: iload           5
        //   196: ifeq            223
        //   199: new             Ljava/awt/Color;
        //   202: dup            
        //   203: getstatic       ClassSub/Class59.GREY:LClassSub/Class59;
        //   206: getfield        ClassSub/Class59.c:I
        //   209: invokespecial   java/awt/Color.<init>:(I)V
        //   212: invokevirtual   java/awt/Color.brighter:()Ljava/awt/Color;
        //   215: invokevirtual   java/awt/Color.getRGB:()I
        //   218: goto            239
        //   221: nop            
        //   222: athrow         
        //   223: new             Ljava/awt/Color;
        //   226: dup            
        //   227: ldc             21
        //   229: ldc             21
        //   231: ldc             21
        //   233: invokespecial   java/awt/Color.<init>:(III)V
        //   236: invokevirtual   java/awt/Color.getRGB:()I
        //   239: invokestatic    ClassSub/Class284.drawRoundedRect:(FFFFFI)V
        //   242: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   245: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   248: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans15:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   251: aload_0        
        //   252: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //   255: getfield        cn/Hanabi/value/Value.mode:Ljava/util/ArrayList;
        //   258: aload_0        
        //   259: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //   262: invokevirtual   cn/Hanabi/value/Value.getCurrentMode:()I
        //   265: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   268: checkcast       Ljava/lang/String;
        //   271: iload_1        
        //   272: ldc             75
        //   274: isub           
        //   275: i2f            
        //   276: fload           7
        //   278: ldc             -1
        //   280: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.drawString:(Ljava/lang/String;FFI)I
        //   283: pop            
        //   284: aload_0        
        //   285: getfield        ClassSub/Class291.isSelectingMode:Z
        //   288: ifne            393
        //   291: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   294: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   297: getfield        cn/Hanabi/utils/fontmanager/FontManager.icon15:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   300: getstatic       cn/Hanabi/utils/fontmanager/HanabiFonts.ICON_CLICKGUI_ARROW_UP:Ljava/lang/String;
        //   303: iload_1        
        //   304: ldc             32
        //   306: isub           
        //   307: iload_2        
        //   308: ldc             1
        //   310: iadd           
        //   311: ldc             -1
        //   313: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.func_78276_b:(Ljava/lang/String;III)I
        //   316: pop            
        //   317: ldc             0
        //   319: invokestatic    org/lwjgl/input/Mouse.isButtonDown:(I)Z
        //   322: ifeq            367
        //   325: aload_0        
        //   326: iload_3        
        //   327: iload           4
        //   329: iload_1        
        //   330: ldc             80
        //   332: isub           
        //   333: i2d            
        //   334: fload           6
        //   336: f2d            
        //   337: iload_1        
        //   338: ldc             20
        //   340: isub           
        //   341: i2d            
        //   342: fload           6
        //   344: ldc             20.0
        //   346: fadd           
        //   347: f2d            
        //   348: invokespecial   ClassSub/Class291.isHovering:(IIDDDD)Z
        //   351: ifeq            367
        //   354: aload_0        
        //   355: getfield        ClassSub/Class291.readySelect:Z
        //   358: ifne            367
        //   361: aload_0        
        //   362: ldc             1
        //   364: putfield        ClassSub/Class291.readySelect:Z
        //   367: ldc             0
        //   369: invokestatic    org/lwjgl/input/Mouse.isButtonDown:(I)Z
        //   372: ifne            670
        //   375: aload_0        
        //   376: getfield        ClassSub/Class291.readySelect:Z
        //   379: ifeq            670
        //   382: aload_0        
        //   383: ldc             1
        //   385: putfield        ClassSub/Class291.isSelectingMode:Z
        //   388: goto            670
        //   391: nop            
        //   392: athrow         
        //   393: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   396: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   399: getfield        cn/Hanabi/utils/fontmanager/FontManager.icon15:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   402: getstatic       cn/Hanabi/utils/fontmanager/HanabiFonts.ICON_CLICKGUI_ARROW_DOWN:Ljava/lang/String;
        //   405: iload_1        
        //   406: ldc             32
        //   408: isub           
        //   409: iload_2        
        //   410: ldc             1
        //   412: iadd           
        //   413: ldc             -1
        //   415: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.func_78276_b:(Ljava/lang/String;III)I
        //   418: pop            
        //   419: aload_0        
        //   420: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //   423: getfield        cn/Hanabi/value/Value.mode:Ljava/util/ArrayList;
        //   426: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //   429: astore          8
        //   431: aload           8
        //   433: invokevirtual   java/util/Iterator.hasNext:()Z
        //   436: ifeq            670
        //   439: aload           8
        //   441: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   444: checkcast       Ljava/lang/String;
        //   447: astore          9
        //   449: aload           9
        //   451: aload_0        
        //   452: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //   455: getfield        cn/Hanabi/value/Value.mode:Ljava/util/ArrayList;
        //   458: aload_0        
        //   459: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //   462: invokevirtual   cn/Hanabi/value/Value.getCurrentMode:()I
        //   465: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   468: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   471: ifeq            479
        //   474: goto            431
        //   477: nop            
        //   478: athrow         
        //   479: fload           7
        //   481: ldc             20.0
        //   483: fadd           
        //   484: fstore          7
        //   486: fload           6
        //   488: ldc             20.0
        //   490: fadd           
        //   491: fstore          6
        //   493: aload_0        
        //   494: getfield        ClassSub/Class291.ani:D
        //   497: fload           6
        //   499: iload_2        
        //   500: i2f            
        //   501: fsub           
        //   502: ldc             30.0
        //   504: fsub           
        //   505: f2d            
        //   506: dcmpl          
        //   507: ifle            665
        //   510: ldc             0
        //   512: invokestatic    org/lwjgl/input/Mouse.isButtonDown:(I)Z
        //   515: ifeq            641
        //   518: aload_0        
        //   519: iload_3        
        //   520: iload           4
        //   522: iload_1        
        //   523: ldc             80
        //   525: isub           
        //   526: i2d            
        //   527: fload           6
        //   529: f2d            
        //   530: iload_1        
        //   531: ldc             20
        //   533: isub           
        //   534: i2d            
        //   535: fload           6
        //   537: ldc             20.0
        //   539: fadd           
        //   540: f2d            
        //   541: invokespecial   ClassSub/Class291.isHovering:(IIDDDD)Z
        //   544: ifeq            594
        //   547: aload_0        
        //   548: ldc             0
        //   550: putfield        ClassSub/Class291.isSelectingMode:Z
        //   553: aload_0        
        //   554: ldc             0
        //   556: putfield        ClassSub/Class291.readySelect:Z
        //   559: new             LClassSub/Class224;
        //   562: dup            
        //   563: aload_0        
        //   564: invokespecial   ClassSub/Class224.<init>:(LClassSub/Class291;)V
        //   567: invokevirtual   ClassSub/Class224.start:()V
        //   570: aload_0        
        //   571: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //   574: aload_0        
        //   575: getfield        ClassSub/Class291.value:Lcn/Hanabi/value/Value;
        //   578: getfield        cn/Hanabi/value/Value.mode:Ljava/util/ArrayList;
        //   581: aload           9
        //   583: invokevirtual   java/util/ArrayList.indexOf:(Ljava/lang/Object;)I
        //   586: invokevirtual   cn/Hanabi/value/Value.setCurrentMode:(I)V
        //   589: goto            641
        //   592: nop            
        //   593: athrow         
        //   594: getstatic       ClassSub/Class79.modeValueMap:Ljava/util/Map;
        //   597: invokevirtual   java/util/Map.values:()Ljava/util/Collection;
        //   600: invokevirtual   java/util/Collection.iterator:()Ljava/util/Iterator;
        //   603: astore          10
        //   605: aload           10
        //   607: invokevirtual   java/util/Iterator.hasNext:()Z
        //   610: ifeq            641
        //   613: aload           10
        //   615: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   618: checkcast       LClassSub/Class291;
        //   621: astore          11
        //   623: new             LClassSub/Class256;
        //   626: dup            
        //   627: aload_0        
        //   628: aload           11
        //   630: invokespecial   ClassSub/Class256.<init>:(LClassSub/Class291;LClassSub/Class291;)V
        //   633: invokevirtual   ClassSub/Class256.start:()V
        //   636: goto            605
        //   639: nop            
        //   640: athrow         
        //   641: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   644: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   647: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans15:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   650: aload           9
        //   652: iload_1        
        //   653: ldc             75
        //   655: isub           
        //   656: i2f            
        //   657: fload           7
        //   659: ldc             -1
        //   661: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.drawString:(Ljava/lang/String;FFI)I
        //   664: pop            
        //   665: goto            431
        //   668: nop            
        //   669: athrow         
        //   670: return         
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
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:437)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:425)
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
    
    private boolean isHovering(final int n, final int n2, final double n3, final double n4, final double n5, final double n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
    
    static boolean access$002(final Class291 class291, final boolean isSelectingMode) {
        return class291.isSelectingMode = isSelectingMode;
    }
    
    static boolean access$102(final Class291 class291, final boolean readySelect) {
        return class291.readySelect = readySelect;
    }
}
