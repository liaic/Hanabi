package ClassSub;

import cn.Hanabi.modules.*;
import cn.Hanabi.*;
import java.awt.*;

public class Class0
{
    public static Mod selectedMod;
    Mod mod;
    boolean selected;
    float x;
    float y;
    Class125 button;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class0(final Mod mod) {
        super();
        this.selected = false;
        this.mod = mod;
    }
    
    public void draw(final int n, final int n2) {
        class Class102 extends Class125
        {
            final Class0 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class102(final Class0 this$0, final String s, final boolean b) {
                this.this$0 = this$0;
                super(s, b);
            }
            
            @Override
            public void onPress() {
                this.this$0.mod.set(!this.this$0.mod.isEnabled());
                this.this$0.mod.modButton.toggle();
                super.onPress();
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: iload_1        
        //     6: i2f            
        //     7: putfield        ClassSub/Class0.x:F
        //    10: aload_0        
        //    11: iload_2        
        //    12: i2f            
        //    13: putfield        ClassSub/Class0.y:F
        //    16: aload_0        
        //    17: getfield        ClassSub/Class0.selected:Z
        //    20: ifeq            69
        //    23: aload_0        
        //    24: getfield        ClassSub/Class0.mod:Lcn/Hanabi/modules/Mod;
        //    27: putstatic       ClassSub/Class0.selectedMod:Lcn/Hanabi/modules/Mod;
        //    30: iload_1        
        //    31: i2f            
        //    32: iload_2        
        //    33: i2f            
        //    34: iload_1        
        //    35: ldc             100
        //    37: iadd           
        //    38: i2f            
        //    39: iload_2        
        //    40: ldc             25
        //    42: iadd           
        //    43: i2f            
        //    44: ldc             6.0
        //    46: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //    49: ldc             "Light"
        //    51: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //    54: ifeq            64
        //    57: ldc             -1118482
        //    59: goto            66
        //    62: nop            
        //    63: athrow         
        //    64: ldc             -15000805
        //    66: invokestatic    ClassSub/Class284.drawRoundedRect:(FFFFFI)V
        //    69: getstatic       cn/Hanabi/Hanabi.INSTANCE:Lcn/Hanabi/Hanabi;
        //    72: getfield        cn/Hanabi/Hanabi.fontManager:Lcn/Hanabi/utils/fontmanager/FontManager;
        //    75: getfield        cn/Hanabi/utils/fontmanager/FontManager.usans16:Lcn/Hanabi/utils/fontmanager/UnicodeFontRenderer;
        //    78: astore_3       
        //    79: aload_3        
        //    80: aload_0        
        //    81: getfield        ClassSub/Class0.mod:Lcn/Hanabi/modules/Mod;
        //    84: invokevirtual   cn/Hanabi/modules/Mod.getName:()Ljava/lang/String;
        //    87: iload_1        
        //    88: ldc             5
        //    90: iadd           
        //    91: i2f            
        //    92: iload_2        
        //    93: i2f            
        //    94: ldc             12.5
        //    96: fadd           
        //    97: aload_3        
        //    98: getfield        cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.field_78288_b:I
        //   101: ldc             2
        //   103: idiv           
        //   104: i2f            
        //   105: fsub           
        //   106: getstatic       ClassSub/Class61.theme:Lcn/Hanabi/value/Value;
        //   109: ldc             "Light"
        //   111: invokevirtual   cn/Hanabi/value/Value.isCurrentMode:(Ljava/lang/String;)Z
        //   114: ifeq            128
        //   117: getstatic       ClassSub/Class59.BLACK:LClassSub/Class59;
        //   120: getfield        ClassSub/Class59.c:I
        //   123: goto            144
        //   126: nop            
        //   127: athrow         
        //   128: new             Ljava/awt/Color;
        //   131: dup            
        //   132: ldc             167
        //   134: ldc             167
        //   136: ldc             167
        //   138: invokespecial   java/awt/Color.<init>:(III)V
        //   141: invokevirtual   java/awt/Color.getRGB:()I
        //   144: invokevirtual   cn/Hanabi/utils/fontmanager/UnicodeFontRenderer.drawString:(Ljava/lang/String;FFI)I
        //   147: pop            
        //   148: aload_0        
        //   149: getfield        ClassSub/Class0.button:LClassSub/Class125;
        //   152: ifnonnull       181
        //   155: aload_0        
        //   156: new             LClassSub/Class102;
        //   159: dup            
        //   160: aload_0        
        //   161: aload_0        
        //   162: getfield        ClassSub/Class0.mod:Lcn/Hanabi/modules/Mod;
        //   165: invokevirtual   cn/Hanabi/modules/Mod.getName:()Ljava/lang/String;
        //   168: aload_0        
        //   169: getfield        ClassSub/Class0.mod:Lcn/Hanabi/modules/Mod;
        //   172: invokevirtual   cn/Hanabi/modules/Mod.isEnabled:()Z
        //   175: invokespecial   ClassSub/Class102.<init>:(LClassSub/Class0;Ljava/lang/String;Z)V
        //   178: putfield        ClassSub/Class0.button:LClassSub/Class125;
        //   181: aload_0        
        //   182: getfield        ClassSub/Class0.button:LClassSub/Class125;
        //   185: iload_1        
        //   186: ldc             85
        //   188: iadd           
        //   189: i2f            
        //   190: iload_2        
        //   191: i2f            
        //   192: ldc             12.5
        //   194: fadd           
        //   195: invokevirtual   ClassSub/Class125.draw:(FF)V
        //   198: aload_0        
        //   199: getfield        ClassSub/Class0.button:LClassSub/Class125;
        //   202: aload_0        
        //   203: getfield        ClassSub/Class0.mod:Lcn/Hanabi/modules/Mod;
        //   206: invokevirtual   cn/Hanabi/modules/Mod.isEnabled:()Z
        //   209: putfield        ClassSub/Class125.state:Z
        //   212: return         
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
    
    public boolean isPressed(final int n, final int n2) {
        if (this.button != null) {
            this.button.isPressed(n, n2);
        }
        return this.isHovering(n, n2, this.x, this.y - 5.0f, this.x + 100.0f, this.y + 30.0f) && !this.selected;
    }
    
    private boolean isHovering(final int n, final int n2, final double n3, final double n4, final double n5, final double n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
}
