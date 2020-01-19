package ClassSub;

import java.security.*;

public final class Class121
{
    private static boolean verbose;
    private static boolean forcedVerbose;
    private static final String forceVerboseProperty = "org.newdawn.slick.forceVerboseLog";
    private static final String forceVerbosePropertyOnValue = "true";
    private static Class111 logSystem;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    private Class121() {
        super();
    }
    
    public static void setLogSystem(final Class111 logSystem) {
        Class121.logSystem = logSystem;
    }
    
    public static void setVerbose(final boolean verbose) {
        if (Class121.forcedVerbose) {
            return;
        }
        Class121.verbose = verbose;
    }
    
    public static void checkVerboseLogSetting() {
        final class Class185 implements PrivilegedAction
        {
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class185() {
                super();
            }
            
            @Override
            public Object run() {
                final String property = System.getProperty("org.newdawn.slick.forceVerboseLog");
                if (property != null && property.equalsIgnoreCase("true")) {
                    Class121.setForcedVerboseOn();
                }
                return null;
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: new             LClassSub/Class185;
        //     7: dup            
        //     8: invokespecial   ClassSub/Class185.<init>:()V
        //    11: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
        //    14: pop            
        //    15: goto            21
        //    18: nop            
        //    19: athrow         
        //    20: astore_0       
        //    21: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      15     20     21     Ljava/lang/Throwable;
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
    
    public static void setForcedVerboseOn() {
        Class121.forcedVerbose = true;
        Class121.verbose = true;
    }
    
    public static void error(final String s, final Throwable t) {
        Class121.logSystem.error(s, t);
    }
    
    public static void error(final Throwable t) {
        Class121.logSystem.error(t);
    }
    
    public static void error(final String s) {
        Class121.logSystem.error(s);
    }
    
    public static void warn(final String s) {
        Class121.logSystem.warn(s);
    }
    
    public static void warn(final String s, final Throwable t) {
        Class121.logSystem.warn(s, t);
    }
    
    public static void info(final String s) {
        if (Class121.verbose || Class121.forcedVerbose) {
            Class121.logSystem.info(s);
        }
    }
    
    public static void debug(final String s) {
        if (Class121.verbose || Class121.forcedVerbose) {
            Class121.logSystem.debug(s);
        }
    }
    
    static {
        Class121.verbose = true;
        Class121.forcedVerbose = false;
        Class121.logSystem = new Class187();
    }
}
