package ClassSub;

import net.minecraft.client.*;
import com.google.common.base.*;
import net.minecraft.scoreboard.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class Class78
{
    public float x;
    public float y;
    public int x2;
    public int y2;
    public float xSize;
    public boolean isDragging;
    public boolean isExtended;
    public boolean showNumber;
    private Class38 handler;
    public Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class78(final float x, final float y) {
        super();
        this.xSize = 65.0f;
        this.isDragging = false;
        this.isExtended = true;
        this.showNumber = true;
        this.handler = new Class38(0);
        this.mc = Minecraft.func_71410_x();
        this.x = x;
        this.y = y;
        this.isExtended = true;
    }
    
    public void passValue() {
        final Scoreboard func_96441_U = this.mc.field_71441_e.func_96441_U();
        ScoreObjective func_96539_a = null;
        final ScorePlayerTeam func_96509_i = func_96441_U.func_96509_i(this.mc.field_71439_g.func_70005_c_());
        if (func_96509_i != null) {
            final int func_175746_b = func_96509_i.func_178775_l().func_175746_b();
            if (func_175746_b >= 0) {
                func_96539_a = func_96441_U.func_96539_a(3 + func_175746_b);
            }
        }
        final ScoreObjective scoreObjective = (func_96539_a != null) ? func_96539_a : func_96441_U.func_96539_a(1);
        if (scoreObjective != null) {
            this.draw(scoreObjective);
        }
    }
    
    public void draw(final ScoreObjective scoreObjective) {
        class Class117 implements Predicate<Score>
        {
            final Class78 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class117(final Class78 this$0) {
                this.this$0 = this$0;
                super();
            }
            
            public boolean apply(final Score score) {
                return score.func_96653_e() != null && !score.func_96653_e().startsWith("#");
            }
            
            public boolean apply(final Object o) {
                return this.apply((Score)o);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: getfield        ClassSub/Class78.isExtended:Z
        //     8: ifeq            673
        //    11: aload_1        
        //    12: invokevirtual   net/minecraft/scoreboard/ScoreObjective.func_96682_a:()Lnet/minecraft/scoreboard/Scoreboard;
        //    15: astore_2       
        //    16: aload_2        
        //    17: aload_1        
        //    18: invokevirtual   net/minecraft/scoreboard/Scoreboard.func_96534_i:(Lnet/minecraft/scoreboard/ScoreObjective;)Ljava/util/Collection;
        //    21: astore_3       
        //    22: aload_3        
        //    23: new             LClassSub/Class117;
        //    26: dup            
        //    27: aload_0        
        //    28: invokespecial   ClassSub/Class117.<init>:(LClassSub/Class78;)V
        //    31: invokestatic    com/google/common/collect/Iterables.filter:(Ljava/lang/Iterable;Lcom/google/common/base/Predicate;)Ljava/lang/Iterable;
        //    34: invokestatic    com/google/common/collect/Lists.newArrayList:(Ljava/lang/Iterable;)Ljava/util/ArrayList;
        //    37: astore          4
        //    39: aload           4
        //    41: invokestatic    java/util/Collections.reverse:(Ljava/util/List;)V
        //    44: aload           4
        //    46: invokevirtual   java/util/List.size:()I
        //    49: ldc             15
        //    51: if_icmple       80
        //    54: aload           4
        //    56: aload_3        
        //    57: invokevirtual   java/util/Collection.size:()I
        //    60: ldc             15
        //    62: isub           
        //    63: invokestatic    com/google/common/collect/Iterables.skip:(Ljava/lang/Iterable;I)Ljava/lang/Iterable;
        //    66: invokestatic    com/google/common/collect/Lists.newArrayList:(Ljava/lang/Iterable;)Ljava/util/ArrayList;
        //    69: astore_3       
        //    70: goto            83
        //    73: nop            
        //    74: nop            
        //    75: nop            
        //    76: nop            
        //    77: nop            
        //    78: nop            
        //    79: athrow         
        //    80: aload           4
        //    82: astore_3       
        //    83: aload_0        
        //    84: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //    87: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //    90: aload_1        
        //    91: invokevirtual   net/minecraft/scoreboard/ScoreObjective.func_96678_d:()Ljava/lang/String;
        //    94: invokevirtual   net/minecraft/client/gui/FontRenderer.func_78256_a:(Ljava/lang/String;)I
        //    97: istore          5
        //    99: aload_3        
        //   100: invokevirtual   java/util/Collection.iterator:()Ljava/util/Iterator;
        //   103: astore          6
        //   105: aload           6
        //   107: invokevirtual   java/util/Iterator.hasNext:()Z
        //   110: ifeq            207
        //   113: aload           6
        //   115: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   118: checkcast       Lnet/minecraft/scoreboard/Score;
        //   121: astore          7
        //   123: aload_2        
        //   124: aload           7
        //   126: invokevirtual   net/minecraft/scoreboard/Score.func_96653_e:()Ljava/lang/String;
        //   129: invokevirtual   net/minecraft/scoreboard/Scoreboard.func_96509_i:(Ljava/lang/String;)Lnet/minecraft/scoreboard/ScorePlayerTeam;
        //   132: astore          8
        //   134: new             Ljava/lang/StringBuilder;
        //   137: dup            
        //   138: invokespecial   java/lang/StringBuilder.<init>:()V
        //   141: aload           8
        //   143: aload           7
        //   145: invokevirtual   net/minecraft/scoreboard/Score.func_96653_e:()Ljava/lang/String;
        //   148: invokestatic    net/minecraft/scoreboard/ScorePlayerTeam.func_96667_a:(Lnet/minecraft/scoreboard/Team;Ljava/lang/String;)Ljava/lang/String;
        //   151: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   154: ldc             ": "
        //   156: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   159: getstatic       net/minecraft/util/EnumChatFormatting.RED:Lnet/minecraft/util/EnumChatFormatting;
        //   162: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   165: aload           7
        //   167: invokevirtual   net/minecraft/scoreboard/Score.func_96652_c:()I
        //   170: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   173: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   176: astore          9
        //   178: iload           5
        //   180: aload_0        
        //   181: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   184: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   187: aload           9
        //   189: invokevirtual   net/minecraft/client/gui/FontRenderer.func_78256_a:(Ljava/lang/String;)I
        //   192: invokestatic    java/lang/Math.max:(II)I
        //   195: istore          5
        //   197: goto            105
        //   200: nop            
        //   201: nop            
        //   202: nop            
        //   203: nop            
        //   204: nop            
        //   205: nop            
        //   206: athrow         
        //   207: ldc             3
        //   209: istore          6
        //   211: aload_0        
        //   212: iload           5
        //   214: iload           6
        //   216: iadd           
        //   217: i2f            
        //   218: putfield        ClassSub/Class78.xSize:F
        //   221: ldc             0
        //   223: istore          7
        //   225: aload_3        
        //   226: invokevirtual   java/util/Collection.iterator:()Ljava/util/Iterator;
        //   229: astore          8
        //   231: aload           8
        //   233: invokevirtual   java/util/Iterator.hasNext:()Z
        //   236: ifeq            262
        //   239: aload           8
        //   241: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   244: checkcast       Lnet/minecraft/scoreboard/Score;
        //   247: astore          9
        //   249: iinc            7, 1
        //   252: goto            231
        //   255: nop            
        //   256: nop            
        //   257: nop            
        //   258: nop            
        //   259: nop            
        //   260: nop            
        //   261: athrow         
        //   262: aload_0        
        //   263: getfield        ClassSub/Class78.x:F
        //   266: fconst_2       
        //   267: fsub           
        //   268: aload_0        
        //   269: getfield        ClassSub/Class78.y:F
        //   272: fconst_2       
        //   273: fsub           
        //   274: aload_0        
        //   275: getfield        ClassSub/Class78.x:F
        //   278: aload_0        
        //   279: getfield        ClassSub/Class78.xSize:F
        //   282: fadd           
        //   283: ldc             5.0
        //   285: fadd           
        //   286: aload_0        
        //   287: getfield        ClassSub/Class78.y:F
        //   290: aload_0        
        //   291: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   294: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   297: getfield        net/minecraft/client/gui/FontRenderer.field_78288_b:I
        //   300: i2f            
        //   301: fadd           
        //   302: getstatic       ClassSub/Class128.INSTANCE:LClassSub/Class128;
        //   305: pop            
        //   306: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //   309: getfield        ClassSub/Class59.c:I
        //   312: ldc             0.65
        //   314: invokestatic    ClassSub/Class128.reAlpha:(IF)I
        //   317: invokestatic    ClassSub/Class78.drawRect:(FFFFI)V
        //   320: aload_0        
        //   321: getfield        ClassSub/Class78.x:F
        //   324: fconst_2       
        //   325: fsub           
        //   326: aload_0        
        //   327: getfield        ClassSub/Class78.y:F
        //   330: aload_0        
        //   331: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   334: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   337: getfield        net/minecraft/client/gui/FontRenderer.field_78288_b:I
        //   340: i2f            
        //   341: fadd           
        //   342: aload_0        
        //   343: getfield        ClassSub/Class78.x:F
        //   346: aload_0        
        //   347: getfield        ClassSub/Class78.xSize:F
        //   350: fadd           
        //   351: ldc             5.0
        //   353: fadd           
        //   354: aload_0        
        //   355: getfield        ClassSub/Class78.y:F
        //   358: aload_0        
        //   359: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   362: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   365: getfield        net/minecraft/client/gui/FontRenderer.field_78288_b:I
        //   368: iload           7
        //   370: ldc             1
        //   372: iadd           
        //   373: imul           
        //   374: i2f            
        //   375: fadd           
        //   376: fconst_2       
        //   377: fadd           
        //   378: getstatic       ClassSub/Class128.INSTANCE:LClassSub/Class128;
        //   381: pop            
        //   382: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //   385: getfield        ClassSub/Class59.c:I
        //   388: ldc             0.45
        //   390: invokestatic    ClassSub/Class128.reAlpha:(IF)I
        //   393: invokestatic    ClassSub/Class78.drawRect:(FFFFI)V
        //   396: fconst_0       
        //   397: fstore          8
        //   399: aload_3        
        //   400: invokevirtual   java/util/Collection.iterator:()Ljava/util/Iterator;
        //   403: astore          9
        //   405: aload           9
        //   407: invokevirtual   java/util/Iterator.hasNext:()Z
        //   410: ifeq            673
        //   413: aload           9
        //   415: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   418: checkcast       Lnet/minecraft/scoreboard/Score;
        //   421: astore          10
        //   423: aload_2        
        //   424: aload           10
        //   426: invokevirtual   net/minecraft/scoreboard/Score.func_96653_e:()Ljava/lang/String;
        //   429: invokevirtual   net/minecraft/scoreboard/Scoreboard.func_96509_i:(Ljava/lang/String;)Lnet/minecraft/scoreboard/ScorePlayerTeam;
        //   432: astore          11
        //   434: aload           11
        //   436: aload           10
        //   438: invokevirtual   net/minecraft/scoreboard/Score.func_96653_e:()Ljava/lang/String;
        //   441: invokestatic    net/minecraft/scoreboard/ScorePlayerTeam.func_96667_a:(Lnet/minecraft/scoreboard/Team;Ljava/lang/String;)Ljava/lang/String;
        //   444: astore          12
        //   446: new             Ljava/lang/StringBuilder;
        //   449: dup            
        //   450: invokespecial   java/lang/StringBuilder.<init>:()V
        //   453: getstatic       net/minecraft/util/EnumChatFormatting.RED:Lnet/minecraft/util/EnumChatFormatting;
        //   456: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   459: ldc             ""
        //   461: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   464: aload           10
        //   466: invokevirtual   net/minecraft/scoreboard/Score.func_96652_c:()I
        //   469: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   472: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   475: astore          13
        //   477: aload_0        
        //   478: getfield        ClassSub/Class78.showNumber:Z
        //   481: ifeq            541
        //   484: aload_0        
        //   485: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   488: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   491: aload           13
        //   493: aload_0        
        //   494: getfield        ClassSub/Class78.x:F
        //   497: aload_0        
        //   498: getfield        ClassSub/Class78.xSize:F
        //   501: fadd           
        //   502: aload_0        
        //   503: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   506: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   509: aload           13
        //   511: invokevirtual   net/minecraft/client/gui/FontRenderer.func_78256_a:(Ljava/lang/String;)I
        //   514: i2f            
        //   515: fsub           
        //   516: ldc             4.0
        //   518: fadd           
        //   519: aload_0        
        //   520: getfield        ClassSub/Class78.y:F
        //   523: ldc             10.0
        //   525: fadd           
        //   526: fload           8
        //   528: fadd           
        //   529: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   532: getfield        ClassSub/Class59.c:I
        //   535: ldc             0
        //   537: invokevirtual   net/minecraft/client/gui/FontRenderer.func_175065_a:(Ljava/lang/String;FFIZ)I
        //   540: pop            
        //   541: aload_0        
        //   542: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   545: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   548: aload           12
        //   550: aload_0        
        //   551: getfield        ClassSub/Class78.x:F
        //   554: aload_0        
        //   555: getfield        ClassSub/Class78.y:F
        //   558: ldc             10.0
        //   560: fadd           
        //   561: fload           8
        //   563: fadd           
        //   564: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   567: getfield        ClassSub/Class59.c:I
        //   570: ldc             0
        //   572: invokevirtual   net/minecraft/client/gui/FontRenderer.func_175065_a:(Ljava/lang/String;FFIZ)I
        //   575: pop            
        //   576: iload           7
        //   578: aload_3        
        //   579: invokevirtual   java/util/Collection.size:()I
        //   582: if_icmpne       652
        //   585: aload_0        
        //   586: aload_1        
        //   587: invokevirtual   net/minecraft/scoreboard/ScoreObjective.func_96678_d:()Ljava/lang/String;
        //   590: aload_0        
        //   591: getfield        ClassSub/Class78.x:F
        //   594: aload_0        
        //   595: getfield        ClassSub/Class78.xSize:F
        //   598: fconst_2       
        //   599: fdiv           
        //   600: fadd           
        //   601: aload_0        
        //   602: getfield        ClassSub/Class78.y:F
        //   605: aload_0        
        //   606: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   609: getfield        net/minecraft/client/Minecraft.field_71462_r:Lnet/minecraft/client/gui/GuiScreen;
        //   612: instanceof      Lnet/minecraft/client/gui/GuiChat;
        //   615: ifne            631
        //   618: aload_0        
        //   619: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   622: getfield        net/minecraft/client/Minecraft.field_71462_r:Lnet/minecraft/client/gui/GuiScreen;
        //   625: instanceof      LClassSub/Class89;
        //   628: ifeq            639
        //   631: ldc_w           0.5
        //   634: goto            642
        //   637: nop            
        //   638: athrow         
        //   639: ldc_w           -0.5
        //   642: fadd           
        //   643: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   646: getfield        ClassSub/Class59.c:I
        //   649: invokevirtual   ClassSub/Class78.drawCenteredString:(Ljava/lang/String;FFI)V
        //   652: fload           8
        //   654: aload_0        
        //   655: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   658: getfield        net/minecraft/client/Minecraft.field_71466_p:Lnet/minecraft/client/gui/FontRenderer;
        //   661: getfield        net/minecraft/client/gui/FontRenderer.field_78288_b:I
        //   664: i2f            
        //   665: fadd           
        //   666: fstore          8
        //   668: goto            405
        //   671: nop            
        //   672: athrow         
        //   673: aload_0        
        //   674: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   677: getfield        net/minecraft/client/Minecraft.field_71462_r:Lnet/minecraft/client/gui/GuiScreen;
        //   680: instanceof      Lnet/minecraft/client/gui/GuiChat;
        //   683: ifne            699
        //   686: aload_0        
        //   687: getfield        ClassSub/Class78.mc:Lnet/minecraft/client/Minecraft;
        //   690: getfield        net/minecraft/client/Minecraft.field_71462_r:Lnet/minecraft/client/gui/GuiScreen;
        //   693: instanceof      LClassSub/Class89;
        //   696: ifeq            938
        //   699: new             Ljava/awt/Color;
        //   702: dup            
        //   703: ldc_w           -14848033
        //   706: invokespecial   java/awt/Color.<init>:(I)V
        //   709: invokevirtual   java/awt/Color.brighter:()Ljava/awt/Color;
        //   712: invokevirtual   java/awt/Color.getRGB:()I
        //   715: istore_2       
        //   716: aload_0        
        //   717: aload_0        
        //   718: getfield        ClassSub/Class78.x:F
        //   721: fconst_2       
        //   722: fsub           
        //   723: aload_0        
        //   724: getfield        ClassSub/Class78.y:F
        //   727: ldc_w           12.0
        //   730: fsub           
        //   731: aload_0        
        //   732: getfield        ClassSub/Class78.x:F
        //   735: aload_0        
        //   736: getfield        ClassSub/Class78.xSize:F
        //   739: fadd           
        //   740: ldc             5.0
        //   742: fadd           
        //   743: aload_0        
        //   744: getfield        ClassSub/Class78.y:F
        //   747: iload_2        
        //   748: iload_2        
        //   749: invokevirtual   ClassSub/Class78.drawRoundedRect:(FFFFII)V
        //   752: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   755: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   758: getfield        cn/Hanabi/utils/fontmanager/FontManager.wqy18:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   761: ldc_w           "\u8ba1\u5206\u677f"
        //   764: aload_0        
        //   765: getfield        ClassSub/Class78.x:F
        //   768: aload_0        
        //   769: getfield        ClassSub/Class78.y:F
        //   772: ldc_w           11.0
        //   775: fsub           
        //   776: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   779: getfield        ClassSub/Class59.c:I
        //   782: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.drawString:(Ljava/lang/String;FFI)I
        //   785: pop            
        //   786: aload_0        
        //   787: getfield        ClassSub/Class78.x:F
        //   790: aload_0        
        //   791: getfield        ClassSub/Class78.xSize:F
        //   794: fadd           
        //   795: fconst_2       
        //   796: fsub           
        //   797: aload_0        
        //   798: getfield        ClassSub/Class78.y:F
        //   801: ldc_w           6.0
        //   804: fsub           
        //   805: ldc2_w          3.0
        //   808: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   811: getfield        ClassSub/Class59.c:I
        //   814: ldc             0
        //   816: ldc2_w          360.0
        //   819: ldc             1
        //   821: invokestatic    ClassSub/Class284.drawArc:(FFDIIDI)V
        //   824: aload_0        
        //   825: getfield        ClassSub/Class78.x:F
        //   828: aload_0        
        //   829: getfield        ClassSub/Class78.xSize:F
        //   832: fadd           
        //   833: ldc_w           12.0
        //   836: fsub           
        //   837: aload_0        
        //   838: getfield        ClassSub/Class78.y:F
        //   841: ldc_w           6.0
        //   844: fsub           
        //   845: ldc2_w          3.0
        //   848: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   851: getfield        ClassSub/Class59.c:I
        //   854: ldc             0
        //   856: ldc2_w          360.0
        //   859: ldc             1
        //   861: invokestatic    ClassSub/Class284.drawArc:(FFDIIDI)V
        //   864: aload_0        
        //   865: getfield        ClassSub/Class78.showNumber:Z
        //   868: ifeq            902
        //   871: aload_0        
        //   872: getfield        ClassSub/Class78.x:F
        //   875: aload_0        
        //   876: getfield        ClassSub/Class78.xSize:F
        //   879: fadd           
        //   880: ldc_w           12.0
        //   883: fsub           
        //   884: aload_0        
        //   885: getfield        ClassSub/Class78.y:F
        //   888: ldc_w           6.0
        //   891: fsub           
        //   892: fconst_1       
        //   893: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   896: getfield        ClassSub/Class59.c:I
        //   899: invokestatic    ClassSub/Class284.circle:(FFFI)V
        //   902: aload_0        
        //   903: getfield        ClassSub/Class78.isExtended:Z
        //   906: ifeq            938
        //   909: aload_0        
        //   910: getfield        ClassSub/Class78.x:F
        //   913: aload_0        
        //   914: getfield        ClassSub/Class78.xSize:F
        //   917: fadd           
        //   918: fconst_2       
        //   919: fsub           
        //   920: aload_0        
        //   921: getfield        ClassSub/Class78.y:F
        //   924: ldc_w           6.0
        //   927: fsub           
        //   928: fconst_1       
        //   929: getstatic       ClassSub/Class59.WHITE:LClassSub/Class59;
        //   932: getfield        ClassSub/Class59.c:I
        //   935: invokestatic    ClassSub/Class284.circle:(FFFI)V
        //   938: fconst_1       
        //   939: fconst_1       
        //   940: fconst_1       
        //   941: fconst_1       
        //   942: invokestatic    org/lwjgl/opengl/GL11.glColor4f:(FFFF)V
        //   945: return         
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
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
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
    
    public void drawCenteredString(final String s, final float n, final float n2, final int n3) {
        Minecraft.func_71410_x().field_71466_p.func_175065_a(s, n - (float)(Minecraft.func_71410_x().field_71466_p.func_78256_a(s) / 2), n2, n3, false);
    }
    
    public void moveWindow(final int n, final int n2) {
        if (this.isHovering(n, n2, this.x + this.xSize - 6.0f, this.y - 10.0f, this.x + this.xSize + 2.0f, this.y - 2.0f)) {
            if (this.handler.canExcecute()) {
                this.isExtended = !this.isExtended;
            }
            return;
        }
        if (this.isHovering(n, n2, this.x + this.xSize - 16.0f, this.y - 10.0f, this.x + this.xSize - 8.0f, this.y - 2.0f)) {
            if (this.handler.canExcecute()) {
                this.showNumber = !this.showNumber;
            }
            return;
        }
        if (this.isHoveringWindow(n, n2) && this.handler.canExcecute()) {
            this.isDragging = true;
            this.x2 = (int)(n - this.x);
            this.y2 = (int)(n2 - this.y);
        }
        if (this.isDragging) {
            this.x = n - this.x2;
            this.y = n2 - this.y2;
        }
        if (!Mouse.isButtonDown(0) && this.isDragging) {
            this.isDragging = false;
        }
    }
    
    public void drawRoundedRect(float n, float n2, float n3, float n4, final int n5, final int n6) {
        this.enableGL2D();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        this.drawVLine(n *= 2.0f, (n2 *= 2.0f) + 1.0f, (n4 *= 2.0f) - 2.0f, n5);
        this.drawVLine((n3 *= 2.0f) - 1.0f, n2 + 1.0f, n4 - 2.0f, n5);
        this.drawHLine(n + 2.0f, n3 - 3.0f, n2, n5);
        this.drawHLine(n + 2.0f, n3 - 3.0f, n4 - 1.0f, n5);
        this.drawHLine(n + 1.0f, n + 1.0f, n2 + 1.0f, n5);
        this.drawHLine(n3 - 2.0f, n3 - 2.0f, n2 + 1.0f, n5);
        this.drawHLine(n3 - 2.0f, n3 - 2.0f, n4 - 2.0f, n5);
        this.drawHLine(n + 1.0f, n + 1.0f, n4 - 2.0f, n5);
        drawRect(n + 1.0f, n2 + 1.0f, n3 - 1.0f, n4 - 1.0f, n6);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        this.disableGL2D();
    }
    
    public static void drawRect(float n, float n2, float n3, float n4, final int n5) {
        if (n < n3) {
            final float n6 = n;
            n = n3;
            n3 = n6;
        }
        if (n2 < n4) {
            final float n7 = n2;
            n2 = n4;
            n4 = n7;
        }
        final float n8 = (n5 >> 24 & 0xFF) / 255.0f;
        final float n9 = (n5 >> 16 & 0xFF) / 255.0f;
        final float n10 = (n5 >> 8 & 0xFF) / 255.0f;
        final float n11 = (n5 & 0xFF) / 255.0f;
        final WorldRenderer func_178180_c = Tessellator.func_178181_a().func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(n9, n10, n11, n8);
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n, (double)n4, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n3, (double)n4, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n3, (double)n2, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n, (double)n2, 0.0).func_181675_d();
        Tessellator.func_178181_a().func_78381_a();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public void drawHLine(float n, float n2, final float n3, final int n4) {
        if (n2 < n) {
            final float n5 = n;
            n = n2;
            n2 = n5;
        }
        drawRect(n, n3, n2 + 1.0f, n3 + 1.0f, n4);
    }
    
    public void drawVLine(final float n, float n2, float n3, final int n4) {
        if (n3 < n2) {
            final float n5 = n2;
            n2 = n3;
            n3 = n5;
        }
        drawRect(n, n2 + 1.0f, n + 1.0f, n3, n4);
    }
    
    public void color(final int n) {
        GL11.glColor4f((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, (float)(n >> 24 & 0xFF) / 255.0f);
    }
    
    public void enableGL2D() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public void disableGL2D() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    private boolean isHovering(final int n, final int n2, final float n3, final float n4, final float n5, final float n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
    
    private boolean isHoveringWindow(final int n, final int n2) {
        return n >= this.x - 2.0f && n <= this.x + this.xSize + 5.0f && n2 >= this.y - 10.0f && n2 <= this.y;
    }
}
