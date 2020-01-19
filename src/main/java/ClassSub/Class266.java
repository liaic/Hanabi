package ClassSub;

import javax.swing.*;
import java.awt.*;

private abstract static class Class266 implements Class208.Class4
{
    String value;
    String name;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class266(final String name, final String value) {
        super();
        this.value = value;
        this.name = name;
    }
    
    @Override
    public void setString(final String value) {
        this.value = value;
    }
    
    @Override
    public String getString() {
        return this.value;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        if (this.value == null) {
            return "";
        }
        return this.value.toString();
    }
    
    public boolean showValueDialog(final JComponent component, final String s) {
        class Class156 implements Runnable
        {
            final JComponent val$component;
            final Class321.Class266 this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class156(final Class321.Class266 this$0, final JComponent val$component) {
                this.this$0 = this$0;
                this.val$component = val$component;
                super();
            }
            
            @Override
            public void run() {
                JComponent component = this.val$component;
                if (component instanceof JSpinner) {
                    component = ((JSpinner.DefaultEditor)((JSpinner)this.val$component).getEditor()).getTextField();
                }
                component.requestFocusInWindow();
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: nop            
        //     6: nop            
        //     7: nop            
        //     8: nop            
        //     9: nop            
        //    10: nop            
        //    11: nop            
        //    12: nop            
        //    13: nop            
        //    14: nop            
        //    15: nop            
        //    16: nop            
        //    17: athrow         
        //    18: new             LClassSub/Class180;
        //    21: dup            
        //    22: aload_1        
        //    23: aload_0        
        //    24: getfield        ClassSub/Class266.name:Ljava/lang/String;
        //    27: aload_2        
        //    28: invokespecial   ClassSub/Class180.<init>:(Ljavax/swing/JComponent;Ljava/lang/String;Ljava/lang/String;)V
        //    31: astore_3       
        //    32: aload_3        
        //    33: aload_0        
        //    34: getfield        ClassSub/Class266.name:Ljava/lang/String;
        //    37: invokevirtual   ClassSub/Class180.setTitle:(Ljava/lang/String;)V
        //    40: aload_3        
        //    41: aconst_null    
        //    42: invokevirtual   ClassSub/Class180.setLocationRelativeTo:(Ljava/awt/Component;)V
        //    45: new             LClassSub/Class156;
        //    48: dup            
        //    49: aload_0        
        //    50: aload_1        
        //    51: invokespecial   ClassSub/Class156.<init>:(LClassSub/Class266;Ljavax/swing/JComponent;)V
        //    54: invokestatic    java/awt/EventQueue.invokeLater:(Ljava/lang/Runnable;)V
        //    57: aload_3        
        //    58: ldc             1
        //    60: invokevirtual   ClassSub/Class180.setVisible:(Z)V
        //    63: aload_3        
        //    64: getfield        ClassSub/Class180.okPressed:Z
        //    67: ireturn        
        //    68: nop            
        //    69: nop            
        //    70: nop            
        //    71: nop            
        //    72: athrow         
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
}
