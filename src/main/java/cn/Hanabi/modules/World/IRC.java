package cn.Hanabi.modules.World;

import java.net.*;
import cn.Hanabi.events.*;
import net.minecraft.client.gui.*;
import com.darkmagician6.eventapi.*;
import net.minecraftforge.fml.common.*;
import net.minecraft.client.*;
import ClassSub.*;
import net.minecraft.util.*;
import cn.Hanabi.modules.*;
import java.util.*;
import java.io.*;

public class IRC extends Mod
{
    private String lastmessage;
    private boolean first;
    private static String[] IRC;
    static PrintWriter pw;
    BufferedReader br;
    Socket socket;
    public static List<String> FriendList;
    public static List<String> ModList;
    public static Map<String, String> UserMap;
    private boolean messageThread;
    private Class191 timer;
    private static Class191 irctimer;
    public static String DevName;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public IRC() {
        super("IRC", Category.WORLD);
        this.first = false;
        this.timer = new Class191();
        new Class17().start();
    }
    
    @EventTarget
    public void onKey(final EventKey eventKey) {
        if (eventKey.getKey() == 52) {
            cn.Hanabi.modules.World.IRC.mc.func_147108_a((GuiScreen)new GuiChat());
        }
    }
    
    public static void processMessage(final String replace) {
        final class Class66 extends Thread
        {
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class66() {
                super();
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                    FMLCommonHandler.instance().exitJava(0, true);
                }
                catch (InterruptedException ex) {}
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: invokestatic    net/minecraft/client/Minecraft.func_71410_x:()Lnet/minecraft/client/Minecraft;
        //     7: astore_1       
        //     8: aload_0        
        //     9: ldc             "\ufffd"
        //    11: ldc             ""
        //    13: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    16: astore_0       
        //    17: aload_0        
        //    18: ifnull          35
        //    21: aload_1        
        //    22: getfield        net/minecraft/client/Minecraft.field_71441_e:Lnet/minecraft/client/multiplayer/WorldClient;
        //    25: ifnull          35
        //    28: aload_1        
        //    29: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //    32: ifnonnull       41
        //    35: return         
        //    36: nop            
        //    37: nop            
        //    38: nop            
        //    39: nop            
        //    40: athrow         
        //    41: aload_0        
        //    42: ldc             "\\|"
        //    44: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    47: checkcast       [Ljava/lang/String;
        //    50: astore_2       
        //    51: aload_2        
        //    52: ldc             3
        //    54: aaload         
        //    55: ldc             "USER"
        //    57: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    60: ifeq            124
        //    63: getstatic       ClassSub/Class69.isDebugMode:Z
        //    66: ifne            75
        //    69: getstatic       ClassSub/Class69.isMod:Z
        //    72: ifeq            118
        //    75: new             Ljava/lang/StringBuilder;
        //    78: dup            
        //    79: invokespecial   java/lang/StringBuilder.<init>:()V
        //    82: ldc             "§d[Margele-IRC]§a\u6e38\u620f\u540d\uff1a"
        //    84: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    87: aload_2        
        //    88: aload_2        
        //    89: arraylength    
        //    90: ldc             2
        //    92: isub           
        //    93: aaload         
        //    94: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    97: ldc             " \u6ce8\u518c\u540d\uff1a"
        //    99: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: aload_2        
        //   103: aload_2        
        //   104: arraylength    
        //   105: ldc             1
        //   107: isub           
        //   108: aaload         
        //   109: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   115: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   118: return         
        //   119: nop            
        //   120: nop            
        //   121: nop            
        //   122: nop            
        //   123: athrow         
        //   124: aload_0        
        //   125: ldc             "COMMAND|GETUSER"
        //   127: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   130: ifeq            187
        //   133: aload_1        
        //   134: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   137: ifnull          187
        //   140: new             Ljava/lang/StringBuilder;
        //   143: dup            
        //   144: invokespecial   java/lang/StringBuilder.<init>:()V
        //   147: ldc             "USER|"
        //   149: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: aload_1        
        //   153: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   156: invokevirtual   net/minecraft/client/entity/EntityPlayerSP.func_70005_c_:()Ljava/lang/String;
        //   159: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   162: ldc             "|"
        //   164: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   167: getstatic       cn/Hanabi/modules/World/IRC.fuck:Ljava/lang/String;
        //   170: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   176: ldc             0
        //   178: invokestatic    cn/Hanabi/modules/World/IRC.sendIRCMessage:(Ljava/lang/String;Z)V
        //   181: return         
        //   182: nop            
        //   183: nop            
        //   184: nop            
        //   185: nop            
        //   186: athrow         
        //   187: aload_1        
        //   188: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   191: ifnull          257
        //   194: aload_0        
        //   195: ldc             "COMMAND|FORCECOMMAND"
        //   197: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   200: ifeq            257
        //   203: aload_2        
        //   204: ldc             2
        //   206: aaload         
        //   207: astore_3       
        //   208: aload_3        
        //   209: aload_1        
        //   210: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   213: invokevirtual   net/minecraft/client/entity/EntityPlayerSP.func_70005_c_:()Ljava/lang/String;
        //   216: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   219: ifne            232
        //   222: aload_3        
        //   223: getstatic       cn/Hanabi/modules/World/IRC.fuck:Ljava/lang/String;
        //   226: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   229: ifeq            251
        //   232: ldc             "§c\u4f60\u88ab\u7ba1\u7406\u5458\u5f3a\u5236\u6267\u884c\u547d\u4ee4\uff01"
        //   234: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   237: aload_1        
        //   238: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   241: aload_2        
        //   242: aload_2        
        //   243: arraylength    
        //   244: ldc             1
        //   246: isub           
        //   247: aaload         
        //   248: invokevirtual   net/minecraft/client/entity/EntityPlayerSP.func_71165_d:(Ljava/lang/String;)V
        //   251: return         
        //   252: nop            
        //   253: nop            
        //   254: nop            
        //   255: nop            
        //   256: athrow         
        //   257: aload_1        
        //   258: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   261: ifnull          323
        //   264: aload_0        
        //   265: ldc             "|CrashCrashCrashCrashCrash"
        //   267: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   270: ifeq            323
        //   273: aload_2        
        //   274: ldc             3
        //   276: aaload         
        //   277: astore_3       
        //   278: aload_3        
        //   279: aload_1        
        //   280: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   283: invokevirtual   net/minecraft/client/entity/EntityPlayerSP.func_70005_c_:()Ljava/lang/String;
        //   286: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   289: ifne            302
        //   292: aload_3        
        //   293: getstatic       cn/Hanabi/modules/World/IRC.fuck:Ljava/lang/String;
        //   296: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   299: ifeq            317
        //   302: ldc             "§c\u8b66\u544a\uff0c\u4f60\u88ab\u7ba1\u7406\u5458\u5f3a\u5236\u9000\u51fa\u6e38\u620f\uff01\u6e38\u620f\u5c06\u5728\u4e09\u79d2\u540e\u81ea\u52a8\u7ed3\u675f\uff01"
        //   304: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   307: new             LClassSub/Class66;
        //   310: dup            
        //   311: invokespecial   ClassSub/Class66.<init>:()V
        //   314: invokevirtual   ClassSub/Class66.start:()V
        //   317: return         
        //   318: nop            
        //   319: nop            
        //   320: nop            
        //   321: nop            
        //   322: athrow         
        //   323: aload_0        
        //   324: ldc             "CLIENTFRIEND"
        //   326: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   329: ifne            359
        //   332: aload_0        
        //   333: ldc             "|DEV"
        //   335: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   338: ifne            359
        //   341: aload_0        
        //   342: ldc             "|MOD"
        //   344: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   347: ifne            359
        //   350: aload_0        
        //   351: ldc             "|WDR"
        //   353: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   356: ifeq            653
        //   359: aload_2        
        //   360: aload_2        
        //   361: arraylength    
        //   362: ldc             2
        //   364: isub           
        //   365: aaload         
        //   366: astore_3       
        //   367: aload_0        
        //   368: ldc             "|WDR"
        //   370: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   373: ifne            438
        //   376: getstatic       cn/Hanabi/modules/World/IRC.UserMap:Ljava/util/Map;
        //   379: aload_3        
        //   380: invokevirtual   java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   383: ifne            438
        //   386: getstatic       cn/Hanabi/modules/World/IRC.UserMap:Ljava/util/Map;
        //   389: aload_3        
        //   390: aload_2        
        //   391: ldc             2
        //   393: aaload         
        //   394: invokevirtual   java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   397: pop            
        //   398: getstatic       ClassSub/Class69.isMod:Z
        //   401: ifeq            438
        //   404: new             Ljava/lang/StringBuilder;
        //   407: dup            
        //   408: invokespecial   java/lang/StringBuilder.<init>:()V
        //   411: ldc             "§b[Hanabi]§a\u6dfb\u52a0\u7528\u6237! IGN:"
        //   413: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   416: aload_3        
        //   417: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   420: ldc             " \u7528\u6237\u540d:"
        //   422: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   425: aload_2        
        //   426: ldc             2
        //   428: aaload         
        //   429: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   432: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   435: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   438: aload_0        
        //   439: ldc             "|CLIENTFRIEND"
        //   441: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   444: ifne            456
        //   447: aload_0        
        //   448: ldc             "|MOD"
        //   450: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   453: ifeq            474
        //   456: getstatic       cn/Hanabi/modules/World/IRC.FriendList:Ljava/util/List;
        //   459: aload_3        
        //   460: invokevirtual   java/util/List.contains:(Ljava/lang/Object;)Z
        //   463: ifne            474
        //   466: getstatic       cn/Hanabi/modules/World/IRC.FriendList:Ljava/util/List;
        //   469: aload_3        
        //   470: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   473: pop            
        //   474: aload_0        
        //   475: ldc             "|NOCLIENTFRIEND"
        //   477: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   480: ifeq            501
        //   483: getstatic       cn/Hanabi/modules/World/IRC.FriendList:Ljava/util/List;
        //   486: aload_3        
        //   487: invokevirtual   java/util/List.contains:(Ljava/lang/Object;)Z
        //   490: ifeq            501
        //   493: getstatic       cn/Hanabi/modules/World/IRC.FriendList:Ljava/util/List;
        //   496: aload_3        
        //   497: invokevirtual   java/util/List.remove:(Ljava/lang/Object;)Z
        //   500: pop            
        //   501: aload_0        
        //   502: ldc             "|MOD"
        //   504: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   507: ifeq            528
        //   510: getstatic       cn/Hanabi/modules/World/IRC.ModList:Ljava/util/List;
        //   513: aload_3        
        //   514: invokevirtual   java/util/List.contains:(Ljava/lang/Object;)Z
        //   517: ifne            528
        //   520: getstatic       cn/Hanabi/modules/World/IRC.ModList:Ljava/util/List;
        //   523: aload_3        
        //   524: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   527: pop            
        //   528: aload_0        
        //   529: ldc             "|DEV"
        //   531: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   534: ifeq            541
        //   537: aload_3        
        //   538: putstatic       cn/Hanabi/modules/World/IRC.DevName:Ljava/lang/String;
        //   541: aload_0        
        //   542: ldc             "|WDR"
        //   544: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   547: ifeq            647
        //   550: aload_1        
        //   551: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   554: ifnull          647
        //   557: getstatic       cn/Hanabi/modules/World/AutoL.wdred:Ljava/util/List;
        //   560: aload_3        
        //   561: invokevirtual   java/util/List.contains:(Ljava/lang/Object;)Z
        //   564: ifne            647
        //   567: new             Ljava/lang/StringBuilder;
        //   570: dup            
        //   571: invokespecial   java/lang/StringBuilder.<init>:()V
        //   574: ldc             "§d[Margele-IRC]§a"
        //   576: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   579: aload_2        
        //   580: ldc             2
        //   582: aaload         
        //   583: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   586: ldc             " \u5bf9\u73a9\u5bb6 "
        //   588: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   591: aload_3        
        //   592: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   595: ldc             " \u8fdb\u884c\u96c6\u7fa4\u4e3e\u62a5\uff01"
        //   597: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   600: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   603: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   606: getstatic       cn/Hanabi/modules/World/AutoL.wdred:Ljava/util/List;
        //   609: aload_3        
        //   610: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   613: pop            
        //   614: invokestatic    net/minecraft/client/Minecraft.func_71410_x:()Lnet/minecraft/client/Minecraft;
        //   617: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   620: new             Ljava/lang/StringBuilder;
        //   623: dup            
        //   624: invokespecial   java/lang/StringBuilder.<init>:()V
        //   627: ldc             "/wdr "
        //   629: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   632: aload_3        
        //   633: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   636: ldc             " ka fly reach nokb jesus ac"
        //   638: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   641: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   644: invokevirtual   net/minecraft/client/entity/EntityPlayerSP.func_71165_d:(Ljava/lang/String;)V
        //   647: return         
        //   648: nop            
        //   649: nop            
        //   650: nop            
        //   651: nop            
        //   652: athrow         
        //   653: aload_1        
        //   654: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   657: ifnull          769
        //   660: ldc             "IRC"
        //   662: invokestatic    cn/Hanabi/modules/ModManager.getModule:(Ljava/lang/String;)Lcn/Hanabi/modules/Mod;
        //   665: invokevirtual   cn/Hanabi/modules/Mod.isEnabled:()Z
        //   668: ifeq            763
        //   671: aload_2        
        //   672: arraylength    
        //   673: ldc_w           4
        //   676: if_icmpne       763
        //   679: aload_0        
        //   680: ldc_w           "CHAT|"
        //   683: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   686: ifeq            763
        //   689: invokestatic    net/minecraft/client/Minecraft.func_71410_x:()Lnet/minecraft/client/Minecraft;
        //   692: getfield        net/minecraft/client/Minecraft.field_71439_g:Lnet/minecraft/client/entity/EntityPlayerSP;
        //   695: new             Lnet/minecraft/util/ChatComponentText;
        //   698: dup            
        //   699: new             Ljava/lang/StringBuilder;
        //   702: dup            
        //   703: invokespecial   java/lang/StringBuilder.<init>:()V
        //   706: ldc_w           "§d[Margele-IRC]"
        //   709: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   712: aload_2        
        //   713: aload_2        
        //   714: arraylength    
        //   715: ldc             3
        //   717: isub           
        //   718: aaload         
        //   719: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   722: ldc_w           "§e"
        //   725: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   728: aload_2        
        //   729: aload_2        
        //   730: arraylength    
        //   731: ldc             2
        //   733: isub           
        //   734: aaload         
        //   735: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   738: ldc_w           "§f:"
        //   741: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   744: aload_2        
        //   745: aload_2        
        //   746: arraylength    
        //   747: ldc             1
        //   749: isub           
        //   750: aaload         
        //   751: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   754: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   757: invokespecial   net/minecraft/util/ChatComponentText.<init>:(Ljava/lang/String;)V
        //   760: invokevirtual   net/minecraft/client/entity/EntityPlayerSP.func_146105_b:(Lnet/minecraft/util/IChatComponent;)V
        //   763: return         
        //   764: nop            
        //   765: nop            
        //   766: nop            
        //   767: nop            
        //   768: athrow         
        //   769: goto            775
        //   772: nop            
        //   773: athrow         
        //   774: astore_1       
        //   775: return         
        //   776: nop            
        //   777: nop            
        //   778: nop            
        //   779: nop            
        //   780: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      35     774    775    Ljava/lang/Throwable;
        //  41     118    774    775    Ljava/lang/Throwable;
        //  124    181    774    775    Ljava/lang/Throwable;
        //  187    251    774    775    Ljava/lang/Throwable;
        //  257    317    774    775    Ljava/lang/Throwable;
        //  323    647    774    775    Ljava/lang/Throwable;
        //  653    763    774    775    Ljava/lang/Throwable;
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
    
    public static void sendIRCMessage(final String s, final boolean b) {
        if (!cn.Hanabi.modules.World.IRC.irctimer.isDelayComplete(1500L) && !Class69.isDebugMode && !Class69.isMod && !s.contains("CLIENTFRIEND")) {
            Minecraft.func_71410_x().field_71439_g.func_146105_b((IChatComponent)new ChatComponentText("§d[Margele-IRC]§c请勿刷屏！"));
            return;
        }
        if (b) {
            if (!ModManager.getModule("IRC").isEnabled()) {
                return;
            }
            cn.Hanabi.modules.World.IRC.pw.println(s);
            cn.Hanabi.modules.World.IRC.irctimer.reset();
        }
        else {
            cn.Hanabi.modules.World.IRC.pw.println(s);
        }
    }
    
    public void onEnable() {
        Minecraft.func_71410_x().field_71439_g.func_146105_b((IChatComponent)new ChatComponentText("§d[Margele-IRC]§cIRC已开启，使用-irc指令发送消息！"));
        super.onEnable();
    }
    
    static boolean access$002(final IRC irc, final boolean messageThread) {
        return irc.messageThread = messageThread;
    }
    
    static Class191 access$100(final IRC irc) {
        return irc.timer;
    }
    
    static boolean access$000(final IRC irc) {
        return irc.messageThread;
    }
    
    static {
        cn.Hanabi.modules.World.IRC.FriendList = new ArrayList<String>();
        cn.Hanabi.modules.World.IRC.ModList = new ArrayList<String>();
        cn.Hanabi.modules.World.IRC.UserMap = new HashMap<String, String>();
        cn.Hanabi.modules.World.IRC.irctimer = new Class191();
        cn.Hanabi.modules.World.IRC.DevName = ".";
    }
}
