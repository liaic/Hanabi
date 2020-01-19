package ClassSub;

import net.minecraft.client.multiplayer.*;
import java.net.*;
import java.util.*;
import java.io.*;
import net.minecraft.client.*;
import cn.Hanabi.modules.*;

public class Class69
{
    public static boolean isMod;
    public static boolean isDebugMode;
    public static String username;
    public static String password;
    public static boolean active;
    static WorldClient worldChange;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class69() {
        super();
    }
    
    public static void prepare() {
        try {
            final Socket socket = new Socket("127.0.0.1", 34234);
            final OutputStream outputStream = socket.getOutputStream();
            socket.getOutputStream().write("GET".getBytes("UTF-8"));
            socket.shutdownOutput();
            final InputStream inputStream = socket.getInputStream();
            final byte[] array = new byte[1024];
            final StringBuilder sb = new StringBuilder();
            int read;
            while ((read = inputStream.read(array)) != -1) {
                sb.append(new String(array, 0, read, "UTF-8"));
            }
            Class69.username = ((String[])sb.toString().split("\\|"))[0];
            Class69.password = ((String[])sb.toString().split("\\|"))[1].substring(0, 32);
            Mod.fuck = ((String[])sb.toString().split("\\|"))[0];
            Mod.me = ((String[])sb.toString().split("\\|"))[1].substring(0, 32);
            inputStream.close();
            outputStream.close();
            socket.close();
            if (Mod.fuck.equals("Margele") || Mod.fuck.equals("Loyisa")) {
                Class69.isMod = true;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        if (!new InetSocketAddress("hanabi.alphaantileak.cn", 893).getAddress().getHostAddress().equals("183.136.132.173")) {
            Class21.abuses = -new Random().nextInt(50);
        }
        Class233.ready();
        int n = 0;
        while (!Class296.c4n && "ooufwugwijednw".length() > 2) {
            if (++n > 3) {
                Class213.showMessageBox("更新HWID失败，可能因为HWID上限！");
                System.exit(0);
                while (true) {}
            }
            else {
                Class296.sendGet("https://alphaantileak.cn/hanabi/FUCKYOU/addhwid.php?user=" + Class69.username + "&pass=" + Class69.password + "&hwid=" + Class296.crackme());
                try {
                    Thread.sleep(5000L);
                }
                catch (InterruptedException ex2) {
                    ex2.printStackTrace();
                }
                Class296.c4n = Class296.fuckyou("https://alphaantileak.cn/asfdsfht.txt", "https://alphaantileak.cn/asdwget4e3gr.txt", "https://alphaantileak.cn/crackmeifyoucan.txt", "https://alphaantileak.cn/jrytdfv.txt").contains(Class296.crackme());
                Class296.cr4ckm3 = Class296.fuckyou("https://alphaantileak.cn/asfdsfht.txt", "https://alphaantileak.cn/asdwget4e3gr.txt", "https://alphaantileak.cn/crackmeifyoucan.txt", "https://alphaantileak.cn/jrytdfv.txt").contains(Class296.crackme());
                Class296.If = Class296.fuckyou("https://alphaantileak.cn/asfdsfht.txt", "https://alphaantileak.cn/asdwget4e3gr.txt", "https://alphaantileak.cn/crackmeifyoucan.txt", "https://alphaantileak.cn/jrytdfv.txt").contains(Class296.crackme());
                Class296.y0u = Class296.fuckyou("https://alphaantileak.cn/asfdsfht.txt", "https://alphaantileak.cn/asdwget4e3gr.txt", "https://alphaantileak.cn/crackmeifyoucan.txt", "https://alphaantileak.cn/jrytdfv.txt").contains(Class296.crackme());
            }
        }
    }
    
    public static void onGameLoop() {
        final class Class294 extends Thread
        {
            final Class218 val$hud;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class294(final Class218 val$hud) {
                this.val$hud = val$hud;
                super();
            }
            
            @Override
            public void run() {
                this.val$hud.set(false);
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                this.val$hud.set(true);
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: invokestatic    net/minecraft/client/Minecraft.func_71410_x:()Lnet/minecraft/client/Minecraft;
        //     7: getfield        net/minecraft/client/Minecraft.field_71441_e:Lnet/minecraft/client/multiplayer/WorldClient;
        //    10: astore_0       
        //    11: getstatic       ClassSub/Class69.worldChange:Lnet/minecraft/client/multiplayer/WorldClient;
        //    14: ifnonnull       26
        //    17: aload_0        
        //    18: putstatic       ClassSub/Class69.worldChange:Lnet/minecraft/client/multiplayer/WorldClient;
        //    21: return         
        //    22: nop            
        //    23: nop            
        //    24: nop            
        //    25: athrow         
        //    26: aload_0        
        //    27: ifnonnull       39
        //    30: aconst_null    
        //    31: putstatic       ClassSub/Class69.worldChange:Lnet/minecraft/client/multiplayer/WorldClient;
        //    34: return         
        //    35: nop            
        //    36: nop            
        //    37: nop            
        //    38: athrow         
        //    39: getstatic       ClassSub/Class69.worldChange:Lnet/minecraft/client/multiplayer/WorldClient;
        //    42: ifnull          88
        //    45: aload_0        
        //    46: ifnull          88
        //    49: getstatic       ClassSub/Class69.worldChange:Lnet/minecraft/client/multiplayer/WorldClient;
        //    52: aload_0        
        //    53: if_acmpeq       88
        //    56: aload_0        
        //    57: putstatic       ClassSub/Class69.worldChange:Lnet/minecraft/client/multiplayer/WorldClient;
        //    60: ldc_w           "HUD"
        //    63: invokestatic    cn/Hanabi/modules/ModManager.getModule:(Ljava/lang/String;)Lcn/Hanabi/modules/Mod;
        //    66: checkcast       LClassSub/Class218;
        //    69: astore_1       
        //    70: aload_1        
        //    71: invokevirtual   ClassSub/Class218.getState:()Z
        //    74: ifeq            88
        //    77: new             LClassSub/Class294;
        //    80: dup            
        //    81: aload_1        
        //    82: invokespecial   ClassSub/Class294.<init>:(LClassSub/Class218;)V
        //    85: invokevirtual   ClassSub/Class294.start:()V
        //    88: return         
        //    89: nop            
        //    90: nop            
        //    91: nop            
        //    92: athrow         
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
    
    static {
        Class69.isMod = false;
        Class69.isDebugMode = false;
        Class69.active = true;
    }
}
