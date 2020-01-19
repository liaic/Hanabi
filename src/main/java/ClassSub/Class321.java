package ClassSub;

import java.awt.image.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class Class321
{
    private static BufferedImage scratchImage;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class321() {
        super();
    }
    
    public static BufferedImage getScratchImage() {
        final Graphics2D graphics2D = (Graphics2D)Class321.scratchImage.getGraphics();
        graphics2D.setComposite(AlphaComposite.Clear);
        graphics2D.fillRect(0, 0, 256, 256);
        graphics2D.setComposite(AlphaComposite.SrcOver);
        graphics2D.setColor(Color.white);
        return Class321.scratchImage;
    }
    
    public static Class208.Class4 colorValue(final String s, final Color color) {
        final class Class154 extends Class266
        {
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class154(final String s, final String s2) {
                super(s, s2);
            }
            
            @Override
            public void showDialog() {
                final Color showDialog = JColorChooser.showDialog(null, "Choose a color", Class321.fromString(this.value));
                if (showDialog != null) {
                    this.value = Class321.toString(showDialog);
                }
            }
            
            @Override
            public Object getObject() {
                return Class321.fromString(this.value);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: new             LClassSub/Class154;
        //     8: dup            
        //     9: aload_0        
        //    10: aload_1        
        //    11: invokestatic    ClassSub/Class321.toString:(Ljava/awt/Color;)Ljava/lang/String;
        //    14: invokespecial   ClassSub/Class154.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    17: areturn        
        //    18: nop            
        //    19: nop            
        //    20: nop            
        //    21: athrow         
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
    
    public static Class208.Class4 intValue(final String s, final int n, final String s2) {
        final class Class144 extends Class266
        {
            final int val$currentValue;
            final String val$description;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class144(final String s, final String s2, final int val$currentValue, final String val$description) {
                this.val$currentValue = val$currentValue;
                this.val$description = val$description;
                super(s, s2);
            }
            
            @Override
            public void showDialog() {
                final JSpinner spinner = new JSpinner(new SpinnerNumberModel(this.val$currentValue, -32768, 32767, 1));
                if (this.showValueDialog(spinner, this.val$description)) {
                    this.value = String.valueOf(spinner.getValue());
                }
            }
            
            @Override
            public Object getObject() {
                return Integer.valueOf(this.value);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: new             LClassSub/Class144;
        //     8: dup            
        //     9: aload_0        
        //    10: iload_1        
        //    11: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //    14: iload_1        
        //    15: aload_2        
        //    16: invokespecial   ClassSub/Class144.<init>:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
        //    19: areturn        
        //    20: nop            
        //    21: nop            
        //    22: nop            
        //    23: athrow         
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
    
    public static Class208.Class4 floatValue(final String s, final float n, final float n2, final float n3, final String s2) {
        final class Class151 extends Class266
        {
            final float val$currentValue;
            final float val$min;
            final float val$max;
            final String val$description;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class151(final String s, final String s2, final float val$currentValue, final float val$min, final float val$max, final String val$description) {
                this.val$currentValue = val$currentValue;
                this.val$min = val$min;
                this.val$max = val$max;
                this.val$description = val$description;
                super(s, s2);
            }
            
            @Override
            public void showDialog() {
                final JSpinner spinner = new JSpinner(new SpinnerNumberModel(this.val$currentValue, this.val$min, this.val$max, 0.10000000149011612));
                if (this.showValueDialog(spinner, this.val$description)) {
                    this.value = String.valueOf((float)(Object)spinner.getValue());
                }
            }
            
            @Override
            public Object getObject() {
                return Float.valueOf(this.value);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: new             LClassSub/Class151;
        //     8: dup            
        //     9: aload_0        
        //    10: fload_1        
        //    11: invokestatic    java/lang/String.valueOf:(F)Ljava/lang/String;
        //    14: fload_1        
        //    15: fload_2        
        //    16: fload_3        
        //    17: aload           4
        //    19: invokespecial   ClassSub/Class151.<init>:(Ljava/lang/String;Ljava/lang/String;FFFLjava/lang/String;)V
        //    22: areturn        
        //    23: nop            
        //    24: nop            
        //    25: nop            
        //    26: nop            
        //    27: athrow         
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
    
    public static Class208.Class4 booleanValue(final String s, final boolean b, final String s2) {
        final class Class299 extends Class266
        {
            final boolean val$currentValue;
            final String val$description;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class299(final String s, final String s2, final boolean val$currentValue, final String val$description) {
                this.val$currentValue = val$currentValue;
                this.val$description = val$description;
                super(s, s2);
            }
            
            @Override
            public void showDialog() {
                final JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected(this.val$currentValue);
                if (this.showValueDialog(checkBox, this.val$description)) {
                    this.value = String.valueOf(checkBox.isSelected());
                }
            }
            
            @Override
            public Object getObject() {
                return Boolean.valueOf(this.value);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: new             LClassSub/Class299;
        //     8: dup            
        //     9: aload_0        
        //    10: iload_1        
        //    11: invokestatic    java/lang/String.valueOf:(Z)Ljava/lang/String;
        //    14: iload_1        
        //    15: aload_2        
        //    16: invokespecial   ClassSub/Class299.<init>:(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
        //    19: areturn        
        //    20: nop            
        //    21: nop            
        //    22: nop            
        //    23: athrow         
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
    
    public static Class208.Class4 optionValue(final String s, final String s2, final String[][] array, final String s3) {
        final class Class95 extends Class266
        {
            final String[][] val$options;
            final String val$currentValue;
            final String val$description;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class95(final String s, final String s2, final String[][] val$options, final String val$currentValue, final String val$description) {
                this.val$options = val$options;
                this.val$currentValue = val$currentValue;
                this.val$description = val$description;
                super(s, s2);
            }
            
            @Override
            public void showDialog() {
                int selectedIndex = -1;
                final DefaultComboBoxModel<Object> defaultComboBoxModel = new DefaultComboBoxModel<Object>();
                for (int i = 0; i < this.val$options.length; ++i) {
                    defaultComboBoxModel.addElement(this.val$options[i][0]);
                    if (this.getValue(i).equals(this.val$currentValue)) {
                        selectedIndex = i;
                    }
                }
                final JComboBox comboBox = new JComboBox(defaultComboBoxModel);
                comboBox.setSelectedIndex(selectedIndex);
                if (this.showValueDialog(comboBox, this.val$description)) {
                    this.value = this.getValue(comboBox.getSelectedIndex());
                }
            }
            
            private String getValue(final int n) {
                if (this.val$options[n].length == 1) {
                    return this.val$options[n][0];
                }
                return this.val$options[n][1];
            }
            
            @Override
            public String toString() {
                for (int i = 0; i < this.val$options.length; ++i) {
                    if (this.getValue(i).equals(this.value)) {
                        return this.val$options[i][0].toString();
                    }
                }
                return "";
            }
            
            @Override
            public Object getObject() {
                return this.value;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: new             LClassSub/Class95;
        //     8: dup            
        //     9: aload_0        
        //    10: aload_1        
        //    11: invokevirtual   java/lang/String.toString:()Ljava/lang/String;
        //    14: aload_2        
        //    15: aload_1        
        //    16: aload_3        
        //    17: invokespecial   ClassSub/Class95.<init>:(Ljava/lang/String;Ljava/lang/String;[[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    20: areturn        
        //    21: nop            
        //    22: nop            
        //    23: nop            
        //    24: nop            
        //    25: athrow         
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
    
    public static String toString(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("color cannot be null.");
        }
        String s = Integer.toHexString(color.getRed());
        if (s.length() == 1) {
            s = "0" + s;
        }
        String s2 = Integer.toHexString(color.getGreen());
        if (s2.length() == 1) {
            s2 = "0" + s2;
        }
        String s3 = Integer.toHexString(color.getBlue());
        if (s3.length() == 1) {
            s3 = "0" + s3;
        }
        return s + s2 + s3;
    }
    
    public static Color fromString(final String s) {
        if (s == null || s.length() != 6) {
            return Color.white;
        }
        return new Color(Integer.parseInt(s.substring(0, 2), 16), Integer.parseInt(s.substring(2, 4), 16), Integer.parseInt(s.substring(4, 6), 16));
    }
    
    static {
        Class321.scratchImage = new BufferedImage(256, 256, 2);
    }
}
