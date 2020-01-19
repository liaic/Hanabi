package ClassSub;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.*;
import cn.Hanabi.*;
import java.awt.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import java.util.*;

public class Class79
{
    public static int x;
    public static int y;
    public static int windowWidth;
    public static int windowHeight;
    public static int wheelStateMod;
    public static int wheelStateValue;
    public int tX;
    public int tY;
    public int dragX;
    public int dragY;
    public static double wheelSmoothMod;
    public static double wheelSmoothValue;
    public static boolean isDraging;
    public boolean clickNotDraging;
    public Category category;
    public List<Class0> mods;
    public static Map<Value, Class125> booleanValueMap;
    public static Map<Value, Class41> doubleValueMap;
    public static Map<Value, Class291> modeValueMap;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class79(final Category category) {
        super();
        this.clickNotDraging = false;
        this.mods = new ArrayList<Class0>();
        this.category = category;
        Class79.x = -1;
        Class79.y = -1;
    }
    
    public void createModUI() {
        this.mods.clear();
        for (final Mod mod : ModManager.getModList()) {
            if (mod.getCategory() == this.category) {
                this.mods.add(new Class0(mod));
            }
        }
    }
    
    public void draw(final int n, final int n2) {
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
        Class79.windowWidth = (int)(scaledResolution.func_78326_a() * 0.5);
        Class79.windowHeight = (int)(scaledResolution.func_78328_b() * 0.6);
        if (Class79.windowWidth < 370) {
            Class79.windowWidth = 370;
        }
        if (Class79.windowHeight < 240) {
            Class79.windowHeight = 240;
        }
        if (Class79.x == -1 || Class79.y == -1) {
            Class79.x = scaledResolution.func_78326_a() / 2 - Class79.windowWidth / 2;
            Class79.y = scaledResolution.func_78328_b() / 2 - Class79.windowHeight / 2;
        }
        this.processDrag(n, n2);
        this.processWheel(n, n2);
        this.drawBackground();
        this.drawModList();
        this.drawValueList(n, n2);
    }
    
    private void drawValueList(final int n, final int n2) {
        class Class84 extends Class125
        {
            final Mod val$selectedMod;
            final Class79 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class84(final Class79 this$0, final String s, final boolean b, final Mod val$selectedMod) {
                this.this$0 = this$0;
                this.val$selectedMod = val$selectedMod;
                super(s, b);
            }
            
            @Override
            public void onPress() {
                this.val$selectedMod.set(!this.val$selectedMod.isEnabled());
                for (final Class0 class0 : this.this$0.mods) {
                    if (class0.mod == this.val$selectedMod) {
                        class0.button.toggle();
                        break;
                    }
                }
                super.onPress();
            }
        }
        class Class60 extends Class125
        {
            final Value val$value;
            final Class79 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class60(final Class79 this$0, final String s, final boolean b, final Value val$value) {
                this.this$0 = this$0;
                this.val$value = val$value;
                super(s, b);
            }
            
            @Override
            public void onPress() {
                if (!this.parent.equals(Class0.selectedMod.getName())) {
                    return;
                }
                this.val$value.setValueState(!(boolean)this.val$value.getValueState());
                super.onPress();
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: getstatic       ClassSub/Class0.selectedMod:Lcn/Hanabi/modules/Mod;
        //     7: ifnull          1124
        //    10: getstatic       ClassSub/Class0.selectedMod:Lcn/Hanabi/modules/Mod;
        //    13: astore_3       
        //    14: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //    17: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //    20: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans18:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //    23: aload_3        
        //    24: invokevirtual   cn/Hanabi/modules/Mod.getName:()Ljava/lang/String;
        //    27: getstatic       ClassSub/Class79.x:I
        //    30: ldc             120
        //    32: iadd           
        //    33: getstatic       ClassSub/Class79.y:I
        //    36: ldc             30
        //    38: iadd           
        //    39: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //    42: ldc             "Light"
        //    44: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //    47: ifeq            61
        //    50: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //    53: getfield        ClassSub/Class59.c:I
        //    56: goto            77
        //    59: nop            
        //    60: athrow         
        //    61: new             Ljava/awt/Color;
        //    64: dup            
        //    65: ldc             167
        //    67: ldc             167
        //    69: ldc             167
        //    71: invokespecial   java/awt/Color.<init>:(III)V
        //    74: invokevirtual   java/awt/Color.getRGB:()I
        //    77: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.func_78276_b:(Ljava/lang/String;III)I
        //    80: pop            
        //    81: aload_3        
        //    82: getfield        cn/Hanabi/modules/Mod.modButton:LClassSub/Class125;
        //    85: ifnonnull       109
        //    88: aload_3        
        //    89: new             LClassSub/Class84;
        //    92: dup            
        //    93: aload_0        
        //    94: aload_3        
        //    95: invokevirtual   cn/Hanabi/modules/Mod.getName:()Ljava/lang/String;
        //    98: aload_3        
        //    99: invokevirtual   cn/Hanabi/modules/Mod.isEnabled:()Z
        //   102: aload_3        
        //   103: invokespecial   ClassSub/Class84.<init>:(LClassSub/Class79;Ljava/lang/String;ZLcn/Hanabi/modules/Mod;)V
        //   106: putfield        cn/Hanabi/modules/Mod.modButton:LClassSub/Class125;
        //   109: aload_3        
        //   110: getfield        cn/Hanabi/modules/Mod.modButton:LClassSub/Class125;
        //   113: getstatic       ClassSub/Class79.x:I
        //   116: getstatic       ClassSub/Class79.windowWidth:I
        //   119: iadd           
        //   120: ldc             35
        //   122: isub           
        //   123: i2f            
        //   124: getstatic       ClassSub/Class79.y:I
        //   127: ldc             36
        //   129: iadd           
        //   130: i2f            
        //   131: invokevirtual   ClassSub/Class125.draw:(FF)V
        //   134: aload_3        
        //   135: getfield        cn/Hanabi/modules/Mod.modButton:LClassSub/Class125;
        //   138: aload_3        
        //   139: invokevirtual   cn/Hanabi/modules/Mod.isEnabled:()Z
        //   142: putfield        ClassSub/Class125.state:Z
        //   145: getstatic       ClassSub/Class79.x:I
        //   148: ldc             115
        //   150: iadd           
        //   151: i2f            
        //   152: getstatic       ClassSub/Class79.y:I
        //   155: ldc             45
        //   157: iadd           
        //   158: i2f            
        //   159: getstatic       ClassSub/Class79.x:I
        //   162: getstatic       ClassSub/Class79.windowWidth:I
        //   165: iadd           
        //   166: ldc             15
        //   168: isub           
        //   169: i2f            
        //   170: getstatic       ClassSub/Class79.y:I
        //   173: i2f            
        //   174: ldc             45.3
        //   176: fadd           
        //   177: new             Ljava/awt/Color;
        //   180: dup            
        //   181: ldc             40
        //   183: ldc             40
        //   185: ldc             40
        //   187: invokespecial   java/awt/Color.<init>:(III)V
        //   190: invokevirtual   java/awt/Color.getRGB:()I
        //   193: invokestatic    ClassSub/Class284.drawRect:(FFFFI)V
        //   196: new             Ljava/util/ArrayList;
        //   199: dup            
        //   200: invokespecial   java/util/ArrayList.<init>:()V
        //   203: astore          4
        //   205: new             Ljava/util/ArrayList;
        //   208: dup            
        //   209: invokespecial   java/util/ArrayList.<init>:()V
        //   212: astore          5
        //   214: new             Ljava/util/ArrayList;
        //   217: dup            
        //   218: invokespecial   java/util/ArrayList.<init>:()V
        //   221: astore          6
        //   223: aload           4
        //   225: invokevirtual   java/util/List.clear:()V
        //   228: aload           5
        //   230: invokevirtual   java/util/List.clear:()V
        //   233: aload           6
        //   235: invokevirtual   java/util/List.clear:()V
        //   238: aload_3        
        //   239: ldc             0
        //   241: putfield        cn/Hanabi/modules/Mod.valueSize:I
        //   244: getstatic       cn/Hanabi/value/Value.list:Ljava/util/List;
        //   247: invokevirtual   java/util/List.iterator:()Ljava/util/Iterator;
        //   250: astore          7
        //   252: aload           7
        //   254: invokevirtual   java/util/Iterator.hasNext:()Z
        //   257: ifeq            366
        //   260: aload           7
        //   262: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   265: checkcast       Lcn/Hanabi/value/Value;
        //   268: astore          8
        //   270: aload           8
        //   272: invokevirtual   cn/Hanabi/value/Value.getValueName:()Ljava/lang/String;
        //   275: ldc_w           "_"
        //   278: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   281: checkcast       [Ljava/lang/String;
        //   284: ldc             0
        //   286: aaload         
        //   287: astore          9
        //   289: aload           9
        //   291: aload_3        
        //   292: invokevirtual   cn/Hanabi/modules/Mod.getName:()Ljava/lang/String;
        //   295: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   298: ifeq            361
        //   301: aload_3        
        //   302: dup            
        //   303: getfield        cn/Hanabi/modules/Mod.valueSize:I
        //   306: ldc_w           1
        //   309: iadd           
        //   310: putfield        cn/Hanabi/modules/Mod.valueSize:I
        //   313: aload           8
        //   315: getfield        cn/Hanabi/value/Value.isValueDouble:Z
        //   318: ifeq            329
        //   321: aload           6
        //   323: aload           8
        //   325: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   328: pop            
        //   329: aload           8
        //   331: getfield        cn/Hanabi/value/Value.isValueMode:Z
        //   334: ifeq            345
        //   337: aload           5
        //   339: aload           8
        //   341: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   344: pop            
        //   345: aload           8
        //   347: getfield        cn/Hanabi/value/Value.isValueBoolean:Z
        //   350: ifeq            361
        //   353: aload           4
        //   355: aload           8
        //   357: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   360: pop            
        //   361: goto            252
        //   364: nop            
        //   365: athrow         
        //   366: invokestatic    org/lwjgl/opengl/GL11.glPushMatrix:()V
        //   369: ldc_w           3089
        //   372: invokestatic    org/lwjgl/opengl/GL11.glEnable:(I)V
        //   375: getstatic       ClassSub/Class79.x:I
        //   378: ldc_w           110
        //   381: iadd           
        //   382: getstatic       ClassSub/Class79.y:I
        //   385: ldc             45
        //   387: iadd           
        //   388: getstatic       ClassSub/Class79.windowWidth:I
        //   391: getstatic       ClassSub/Class79.windowHeight:I
        //   394: ldc_w           55
        //   397: isub           
        //   398: invokestatic    ClassSub/Class284.doGlScissor:(IIII)V
        //   401: getstatic       ClassSub/Class79.wheelSmoothValue:D
        //   404: getstatic       ClassSub/Class79.wheelStateValue:I
        //   407: ldc             30
        //   409: imul           
        //   410: i2d            
        //   411: ldc2_w          400.0
        //   414: invokestatic    ClassSub/Class284.getAnimationState:(DDD)D
        //   417: putstatic       ClassSub/Class79.wheelSmoothValue:D
        //   420: getstatic       ClassSub/Class79.y:I
        //   423: i2d            
        //   424: getstatic       ClassSub/Class79.wheelSmoothValue:D
        //   427: dadd           
        //   428: d2i            
        //   429: istore          7
        //   431: iload           7
        //   433: ldc_w           60
        //   436: iadd           
        //   437: istore          8
        //   439: aload           4
        //   441: invokevirtual   java/util/List.iterator:()Ljava/util/Iterator;
        //   444: astore          9
        //   446: aload           9
        //   448: invokevirtual   java/util/Iterator.hasNext:()Z
        //   451: ifeq            663
        //   454: aload           9
        //   456: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   459: checkcast       Lcn/Hanabi/value/Value;
        //   462: astore          10
        //   464: aload           10
        //   466: invokevirtual   cn/Hanabi/value/Value.getValueName:()Ljava/lang/String;
        //   469: ldc_w           "_"
        //   472: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   475: checkcast       [Ljava/lang/String;
        //   478: ldc             0
        //   480: aaload         
        //   481: astore          11
        //   483: aload           10
        //   485: invokevirtual   cn/Hanabi/value/Value.getValueName:()Ljava/lang/String;
        //   488: ldc_w           "_"
        //   491: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   494: checkcast       [Ljava/lang/String;
        //   497: ldc_w           1
        //   500: aaload         
        //   501: astore          12
        //   503: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   506: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   509: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans16:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   512: aload           12
        //   514: getstatic       ClassSub/Class79.x:I
        //   517: ldc             120
        //   519: iadd           
        //   520: iload           8
        //   522: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //   525: ldc             "Light"
        //   527: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //   530: ifeq            544
        //   533: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //   536: getfield        ClassSub/Class59.c:I
        //   539: goto            560
        //   542: nop            
        //   543: athrow         
        //   544: new             Ljava/awt/Color;
        //   547: dup            
        //   548: ldc             167
        //   550: ldc             167
        //   552: ldc             167
        //   554: invokespecial   java/awt/Color.<init>:(III)V
        //   557: invokevirtual   java/awt/Color.getRGB:()I
        //   560: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.func_78276_b:(Ljava/lang/String;III)I
        //   563: pop            
        //   564: aconst_null    
        //   565: astore          13
        //   567: getstatic       ClassSub/Class79.booleanValueMap:Ljava/util/Map;
        //   570: aload           10
        //   572: invokevirtual   java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   575: ifeq            596
        //   578: getstatic       ClassSub/Class79.booleanValueMap:Ljava/util/Map;
        //   581: aload           10
        //   583: invokevirtual   java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   586: checkcast       LClassSub/Class125;
        //   589: astore          13
        //   591: goto            632
        //   594: nop            
        //   595: athrow         
        //   596: new             LClassSub/Class60;
        //   599: dup            
        //   600: aload_0        
        //   601: aload           11
        //   603: aload           10
        //   605: invokevirtual   cn/Hanabi/value/Value.getValueState:()Ljava/lang/Object;
        //   608: checkcast       Ljava/lang/Boolean;
        //   611: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   614: aload           10
        //   616: invokespecial   ClassSub/Class60.<init>:(LClassSub/Class79;Ljava/lang/String;ZLcn/Hanabi/value/Value;)V
        //   619: astore          13
        //   621: getstatic       ClassSub/Class79.booleanValueMap:Ljava/util/Map;
        //   624: aload           10
        //   626: aload           13
        //   628: invokevirtual   java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   631: pop            
        //   632: aload           13
        //   634: getstatic       ClassSub/Class79.x:I
        //   637: getstatic       ClassSub/Class79.windowWidth:I
        //   640: iadd           
        //   641: ldc             35
        //   643: isub           
        //   644: i2f            
        //   645: iload           8
        //   647: i2f            
        //   648: ldc_w           5.5
        //   651: fadd           
        //   652: invokevirtual   ClassSub/Class125.draw:(FF)V
        //   655: iinc            8, 30
        //   658: goto            446
        //   661: nop            
        //   662: athrow         
        //   663: aload           6
        //   665: invokevirtual   java/util/List.iterator:()Ljava/util/Iterator;
        //   668: astore          9
        //   670: aload           9
        //   672: invokevirtual   java/util/Iterator.hasNext:()Z
        //   675: ifeq            854
        //   678: aload           9
        //   680: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   683: checkcast       Lcn/Hanabi/value/Value;
        //   686: astore          10
        //   688: aload           10
        //   690: invokevirtual   cn/Hanabi/value/Value.getValueName:()Ljava/lang/String;
        //   693: ldc_w           "_"
        //   696: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   699: checkcast       [Ljava/lang/String;
        //   702: ldc_w           1
        //   705: aaload         
        //   706: astore          11
        //   708: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   711: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   714: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans16:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   717: aload           11
        //   719: getstatic       ClassSub/Class79.x:I
        //   722: ldc             120
        //   724: iadd           
        //   725: iload           8
        //   727: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //   730: ldc             "Light"
        //   732: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //   735: ifeq            749
        //   738: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //   741: getfield        ClassSub/Class59.c:I
        //   744: goto            765
        //   747: nop            
        //   748: athrow         
        //   749: new             Ljava/awt/Color;
        //   752: dup            
        //   753: ldc             167
        //   755: ldc             167
        //   757: ldc             167
        //   759: invokespecial   java/awt/Color.<init>:(III)V
        //   762: invokevirtual   java/awt/Color.getRGB:()I
        //   765: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.func_78276_b:(Ljava/lang/String;III)I
        //   768: pop            
        //   769: aconst_null    
        //   770: astore          12
        //   772: getstatic       ClassSub/Class79.doubleValueMap:Ljava/util/Map;
        //   775: aload           10
        //   777: invokevirtual   java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   780: ifeq            801
        //   783: getstatic       ClassSub/Class79.doubleValueMap:Ljava/util/Map;
        //   786: aload           10
        //   788: invokevirtual   java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   791: checkcast       LClassSub/Class41;
        //   794: astore          12
        //   796: goto            823
        //   799: nop            
        //   800: athrow         
        //   801: new             LClassSub/Class41;
        //   804: dup            
        //   805: aload           10
        //   807: invokespecial   ClassSub/Class41.<init>:(Lcn/Hanabi/value/Value;)V
        //   810: astore          12
        //   812: getstatic       ClassSub/Class79.doubleValueMap:Ljava/util/Map;
        //   815: aload           10
        //   817: aload           12
        //   819: invokevirtual   java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   822: pop            
        //   823: aload           12
        //   825: getstatic       ClassSub/Class79.x:I
        //   828: getstatic       ClassSub/Class79.windowWidth:I
        //   831: iadd           
        //   832: i2f            
        //   833: iload           8
        //   835: i2f            
        //   836: invokevirtual   ClassSub/Class41.draw:(FF)V
        //   839: aload           12
        //   841: iload_1        
        //   842: iload_2        
        //   843: invokevirtual   ClassSub/Class41.onPress:(II)V
        //   846: iinc            8, 30
        //   849: goto            670
        //   852: nop            
        //   853: athrow         
        //   854: aload           5
        //   856: invokevirtual   java/util/List.iterator:()Ljava/util/Iterator;
        //   859: astore          9
        //   861: aload           9
        //   863: invokevirtual   java/util/Iterator.hasNext:()Z
        //   866: ifeq            1025
        //   869: aload           9
        //   871: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   874: checkcast       Lcn/Hanabi/value/Value;
        //   877: astore          10
        //   879: aload           10
        //   881: invokevirtual   cn/Hanabi/value/Value.getDisplayTitle:()Ljava/lang/String;
        //   884: astore          11
        //   886: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //   889: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //   892: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans16:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //   895: aload           11
        //   897: getstatic       ClassSub/Class79.x:I
        //   900: ldc             120
        //   902: iadd           
        //   903: iload           8
        //   905: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //   908: ldc             "Light"
        //   910: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //   913: ifeq            927
        //   916: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //   919: getfield        ClassSub/Class59.c:I
        //   922: goto            943
        //   925: nop            
        //   926: athrow         
        //   927: new             Ljava/awt/Color;
        //   930: dup            
        //   931: ldc             167
        //   933: ldc             167
        //   935: ldc             167
        //   937: invokespecial   java/awt/Color.<init>:(III)V
        //   940: invokevirtual   java/awt/Color.getRGB:()I
        //   943: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.func_78276_b:(Ljava/lang/String;III)I
        //   946: pop            
        //   947: aconst_null    
        //   948: astore          12
        //   950: getstatic       ClassSub/Class79.modeValueMap:Ljava/util/Map;
        //   953: aload           10
        //   955: invokevirtual   java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   958: ifeq            979
        //   961: getstatic       ClassSub/Class79.modeValueMap:Ljava/util/Map;
        //   964: aload           10
        //   966: invokevirtual   java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   969: checkcast       LClassSub/Class291;
        //   972: astore          12
        //   974: goto            1001
        //   977: nop            
        //   978: athrow         
        //   979: new             LClassSub/Class291;
        //   982: dup            
        //   983: aload           10
        //   985: invokespecial   ClassSub/Class291.<init>:(Lcn/Hanabi/value/Value;)V
        //   988: astore          12
        //   990: getstatic       ClassSub/Class79.modeValueMap:Ljava/util/Map;
        //   993: aload           10
        //   995: aload           12
        //   997: invokevirtual   java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1000: pop            
        //  1001: aload           12
        //  1003: getstatic       ClassSub/Class79.x:I
        //  1006: getstatic       ClassSub/Class79.windowWidth:I
        //  1009: iadd           
        //  1010: iload           8
        //  1012: iload_1        
        //  1013: iload_2        
        //  1014: invokevirtual   ClassSub/Class291.draw:(IIII)V
        //  1017: iinc            8, 30
        //  1020: goto            861
        //  1023: nop            
        //  1024: athrow         
        //  1025: aload_3        
        //  1026: getfield        cn/Hanabi/modules/Mod.valueSize:I
        //  1029: ifne            1115
        //  1032: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //  1035: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //  1038: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans16:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //  1041: ldc_w           "No setting here."
        //  1044: getstatic       ClassSub/Class79.x:I
        //  1047: ldc             120
        //  1049: iadd           
        //  1050: getstatic       ClassSub/Class79.y:I
        //  1053: ldc_w           60
        //  1056: iadd           
        //  1057: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //  1060: ldc             "Light"
        //  1062: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //  1065: ifeq            1095
        //  1068: new             Ljava/awt/Color;
        //  1071: dup            
        //  1072: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //  1075: getfield        ClassSub/Class59.c:I
        //  1078: invokespecial   java/awt/Color.<init>:(I)V
        //  1081: invokevirtual   java/awt/Color.brighter:()Ljava/awt/Color;
        //  1084: invokevirtual   java/awt/Color.brighter:()Ljava/awt/Color;
        //  1087: invokevirtual   java/awt/Color.getRGB:()I
        //  1090: goto            1111
        //  1093: nop            
        //  1094: athrow         
        //  1095: new             Ljava/awt/Color;
        //  1098: dup            
        //  1099: ldc             167
        //  1101: ldc             167
        //  1103: ldc             167
        //  1105: invokespecial   java/awt/Color.<init>:(III)V
        //  1108: invokevirtual   java/awt/Color.getRGB:()I
        //  1111: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.func_78276_b:(Ljava/lang/String;III)I
        //  1114: pop            
        //  1115: ldc_w           3089
        //  1118: invokestatic    org/lwjgl/opengl/GL11.glDisable:(I)V
        //  1121: invokestatic    org/lwjgl/opengl/GL11.glPopMatrix:()V
        //  1124: return         
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
    
    private void drawModList() {
        GL11.glPushMatrix();
        GL11.glEnable(3089);
        Class284.doGlScissor(Class79.x + 10, Class79.y + 25, 100, Class79.windowHeight - 35);
        Class79.wheelSmoothMod = Class284.getAnimationState(Class79.wheelSmoothMod, Class79.wheelStateMod * 30, 400.0);
        int n = (int)(Class79.y + Class79.wheelSmoothMod) + 25;
        final Iterator<Class0> iterator = this.mods.iterator();
        while (iterator.hasNext()) {
            ((Class0)iterator.next()).draw(Class79.x + 10, n);
            n += 35;
        }
        GL11.glDisable(3089);
        GL11.glPopMatrix();
    }
    
    private void drawBackground() {
        final int n = Class61.theme.isCurrentMode("Light") ? -921615 : new Color(27, 27, 27).getRGB();
        final int n2 = Class61.theme.isCurrentMode("Light") ? Class59.RED.c : new Color(47, 116, 253).getRGB();
        if (!Class61.theme.isCurrentMode("Light")) {
            Class284.drawRoundedRect((float)Class79.x - 0.5f, (float)Class79.y - 0.5f, (float)(Class79.x + Class79.windowWidth) + 0.5f, (float)(Class79.y + Class79.windowHeight) + 0.5f, 6.0f, new Color(16, 76, 182).getRGB());
        }
        else {
            Class284.drawRoundedRect((float)Class79.x - 1.0f, (float)Class79.y - 1.0f, (float)(Class79.x + Class79.windowWidth) + 1.0f, (float)(Class79.y + Class79.windowHeight) + 1.0f, 6.0f, n);
        }
        Class284.drawRoundedRect(Class79.x, Class79.y, Class79.x + Class79.windowWidth, Class79.y + Class79.windowHeight, 6.0f, n);
        Class284.drawRoundedRect(Class79.x + 2, Class79.y + 14, Class79.x + Class79.windowWidth - 2, Class79.y + Class79.windowHeight - 2, 6.0f, Class61.theme.isCurrentMode("Light") ? new Color(Class59.GREY.c).brighter().brighter().getRGB() : new Color(13, 13, 13).getRGB());
        Class284.circle(Class79.x + Class79.windowWidth - 10, Class79.y + 8, 2.5f, n2);
        Hanabi.INSTANCE.fontManager.raleway16.func_78276_b(this.category.toString(), Class79.x + 8, Class79.y + 3, Class61.theme.isCurrentMode("Light") ? Class59.BLACK.c : new Color(167, 167, 167).getRGB());
    }
    
    private void processWheel(final int n, final int n2) {
        final int dWheel = Mouse.getDWheel();
        if (this.isHover(Class79.x + 10, Class79.y + 25, 100, Class79.windowHeight - 35, n, n2)) {
            if (dWheel > 0) {
                if (Class79.wheelStateMod < 0) {
                    ++Class79.wheelStateMod;
                }
            }
            else if (dWheel < 0 && Class79.wheelStateMod * 30 > this.mods.size() * -30) {
                --Class79.wheelStateMod;
            }
        }
        else if (this.isHover(Class79.x + 110, Class79.y + 25, Class79.windowWidth, Class79.windowHeight - 35, n, n2)) {
            if (dWheel > 0) {
                if (Class79.wheelStateValue < 0) {
                    ++Class79.wheelStateValue;
                }
            }
            else if (dWheel < 0 && Class0.selectedMod != null && Class79.wheelStateValue * 50 > Class0.selectedMod.valueSize * -40) {
                --Class79.wheelStateValue;
            }
        }
    }
    
    private void processDrag(final int tx, final int ty) {
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
        if (Mouse.isButtonDown(0)) {
            if (this.isHover(Class79.x + Class79.windowWidth - 17, Class79.y, 10, 10, tx, ty)) {
                Minecraft.func_71410_x().func_147108_a((GuiScreen)null);
                return;
            }
            if (this.isHover(Class79.x, Class79.y, Class79.windowWidth, 15, tx, ty) || Class79.isDraging) {
                Class79.isDraging = true;
            }
            else {
                this.clickNotDraging = true;
            }
            if (Class79.isDraging && !this.clickNotDraging) {
                this.dragX = tx - this.tX;
                this.dragY = ty - this.tY;
                if (Class79.x < scaledResolution.func_78326_a() * 0.155) {
                    Class79.x = (int)(scaledResolution.func_78326_a() * 0.155) + 1;
                }
                else if (Class79.x > scaledResolution.func_78326_a() - Class79.windowWidth) {
                    Class79.x = scaledResolution.func_78326_a() - Class79.windowWidth - 1;
                }
                else {
                    Class79.x += this.dragX;
                }
                if (Class79.y < 0) {
                    Class79.y = 1;
                }
                else if (Class79.y > scaledResolution.func_78328_b() - Class79.windowHeight) {
                    Class79.y = scaledResolution.func_78328_b() - Class79.windowHeight - 1;
                }
                else {
                    Class79.y += this.dragY;
                }
            }
        }
        else {
            Class79.isDraging = false;
            this.clickNotDraging = false;
        }
        this.tX = tx;
        this.tY = ty;
    }
    
    public boolean isHover(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return n5 >= n && n5 <= n + n3 && n6 >= n2 && n6 <= n2 + n4;
    }
    
    public void onMouseClick(final int n, final int n2) {
        for (final Class0 class0 : this.mods) {
            if (this.isHover(Class79.x + 10, Class79.y + 25, 100, Class79.windowHeight - 35, n, n2) && class0.isPressed(n, n2)) {
                final Iterator<Class0> iterator2 = this.mods.iterator();
                while (iterator2.hasNext()) {
                    ((Class0)iterator2.next()).selected = false;
                }
                class0.selected = true;
                Class79.wheelStateValue = 0;
                break;
            }
        }
        final Iterator<Class125> iterator3 = Class79.booleanValueMap.values().iterator();
        while (iterator3.hasNext()) {
            ((Class125)iterator3.next()).isPressed(n, n2);
        }
        if (Class0.selectedMod != null && Class0.selectedMod.modButton != null) {
            Class0.selectedMod.modButton.isPressed(n, n2);
        }
    }
    
    static {
        Class79.isDraging = false;
        Class79.booleanValueMap = new HashMap<Value, Class125>();
        Class79.doubleValueMap = new HashMap<Value, Class41>();
        Class79.modeValueMap = new HashMap<Value, Class291>();
    }
}
