package ClassSub;

import java.security.*;

public class Class164
{
    private static boolean usePngLoader;
    private static boolean pngLoaderPropertyChecked;
    private static final String PNG_LOADER = "org.newdawn.slick.pngloader";
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class164() {
        super();
    }
    
    private static void checkProperty() {
        final class Class142 implements PrivilegedAction
        {
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class142() {
                super();
            }
            
            @Override
            public Object run() {
                if ("false".equalsIgnoreCase(System.getProperty("org.newdawn.slick.pngloader"))) {
                    Class164.access$002(false);
                }
                Class121.info("Use Java PNG Loader = " + Class164.access$000());
                return null;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: getstatic       ClassSub/Class164.pngLoaderPropertyChecked:Z
        //     7: ifne            32
        //    10: ldc             1
        //    12: putstatic       ClassSub/Class164.pngLoaderPropertyChecked:Z
        //    15: new             LClassSub/Class142;
        //    18: dup            
        //    19: invokespecial   ClassSub/Class142.<init>:()V
        //    22: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //    25: pop            
        //    26: goto            32
        //    29: nop            
        //    30: athrow         
        //    31: astore_0       
        //    32: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  15     26     31     32     Ljava/lang/Throwable;
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
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:494)
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
    
    public static Class232 getImageDataFor(String lowerCase) {
        checkProperty();
        lowerCase = lowerCase.toLowerCase();
        if (lowerCase.endsWith(".tga")) {
            return new Class7();
        }
        if (lowerCase.endsWith(".png")) {
            final Class189 class189 = new Class189();
            if (Class164.usePngLoader) {
                class189.add(new Class104());
            }
            class189.add(new Class31());
            return class189;
        }
        return new Class31();
    }
    
    static boolean access$002(final boolean usePngLoader) {
        return Class164.usePngLoader = usePngLoader;
    }
    
    static boolean access$000() {
        return Class164.usePngLoader;
    }
    
    static {
        Class164.usePngLoader = true;
        Class164.pngLoaderPropertyChecked = false;
    }
}
