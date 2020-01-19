package ClassSub;

import javax.swing.*;
import java.awt.*;

class Class44 extends JFrame
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class44(final String s) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: invokespecial   javax/swing/JFrame.<init>:()V
        //     8: new             Ljavax/swing/JLabel;
        //    11: dup            
        //    12: aload_1        
        //    13: invokespecial   javax/swing/JLabel.<init>:(Ljava/lang/String;)V
        //    16: astore_2       
        //    17: new             Ljava/awt/Button;
        //    20: dup            
        //    21: new             Ljava/lang/StringBuilder;
        //    24: dup            
        //    25: invokespecial   java/lang/StringBuilder.<init>:()V
        //    28: aload_1        
        //    29: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    32: ldc             "\u786e\u5b9a"
        //    34: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    37: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    40: invokespecial   java/awt/Button.<init>:(Ljava/lang/String;)V
        //    43: astore_3       
        //    44: aload_3        
        //    45: new             LClassSub/Class298;
        //    48: dup            
        //    49: aload_0        
        //    50: aload_1        
        //    51: invokespecial   ClassSub/Class298.<init>:(LClassSub/Class44;Ljava/lang/String;)V
        //    54: invokevirtual   java/awt/Button.addActionListener:(Ljava/awt/event/ActionListener;)V
        //    57: aload_0        
        //    58: aload_2        
        //    59: invokevirtual   ClassSub/Class44.add:(Ljava/awt/Component;)Ljava/awt/Component;
        //    62: pop            
        //    63: aload_0        
        //    64: aload_3        
        //    65: invokevirtual   ClassSub/Class44.add:(Ljava/awt/Component;)Ljava/awt/Component;
        //    68: pop            
        //    69: aload_0        
        //    70: new             Ljava/awt/FlowLayout;
        //    73: dup            
        //    74: invokespecial   java/awt/FlowLayout.<init>:()V
        //    77: invokevirtual   ClassSub/Class44.setLayout:(Ljava/awt/LayoutManager;)V
        //    80: aload_0        
        //    81: ldc             "\u63d0\u793a"
        //    83: invokevirtual   ClassSub/Class44.setTitle:(Ljava/lang/String;)V
        //    86: aload_0        
        //    87: ldc             300
        //    89: ldc             80
        //    91: invokevirtual   ClassSub/Class44.setSize:(II)V
        //    94: aload_0        
        //    95: aconst_null    
        //    96: invokevirtual   ClassSub/Class44.setLocationRelativeTo:(Ljava/awt/Component;)V
        //    99: aload_0        
        //   100: ldc             1
        //   102: invokevirtual   ClassSub/Class44.setAlwaysOnTop:(Z)V
        //   105: aload_0        
        //   106: ldc             0
        //   108: invokevirtual   ClassSub/Class44.setResizable:(Z)V
        //   111: aload_0        
        //   112: ldc             1
        //   114: invokevirtual   ClassSub/Class44.setVisible:(Z)V
        //   117: return         
        //   118: nop            
        //   119: nop            
        //   120: nop            
        //   121: nop            
        //   122: athrow         
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:692)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:529)
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
}
