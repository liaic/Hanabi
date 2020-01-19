package ClassSub;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import cn.Hanabi.modules.*;
import java.awt.*;
import cn.Hanabi.*;
import java.util.*;
import cn.Hanabi.utils.fontmanager.*;

public class Class309
{
    Minecraft mc;
    ScaledResolution sr;
    int length;
    public float animationY;
    public List<Class120> button;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class309() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: invokespecial   java/lang/Object.<init>:()V
        //     8: aload_0        
        //     9: invokestatic    net/minecraft/client/Minecraft.func_71410_x:()Lnet/minecraft/client/Minecraft;
        //    12: putfield        ClassSub/Class309.mc:Lnet/minecraft/client/Minecraft;
        //    15: aload_0        
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: putfield        ClassSub/Class309.button:Ljava/util/List;
        //    26: aload_0        
        //    27: new             Lnet/minecraft/client/gui/ScaledResolution;
        //    30: dup            
        //    31: aload_0        
        //    32: getfield        ClassSub/Class309.mc:Lnet/minecraft/client/Minecraft;
        //    35: invokespecial   net/minecraft/client/gui/ScaledResolution.<init>:(Lnet/minecraft/client/Minecraft;)V
        //    38: putfield        ClassSub/Class309.sr:Lnet/minecraft/client/gui/ScaledResolution;
        //    41: aload_0        
        //    42: aload_0        
        //    43: getfield        ClassSub/Class309.sr:Lnet/minecraft/client/gui/ScaledResolution;
        //    46: invokevirtual   net/minecraft/client/gui/ScaledResolution.func_78326_a:()I
        //    49: i2d            
        //    50: ldc2_w          0.155
        //    53: dmul           
        //    54: d2i            
        //    55: putfield        ClassSub/Class309.length:I
        //    58: ldc             0
        //    60: istore_1       
        //    61: iload_1        
        //    62: invokestatic    cn/Hanabi/modules/Category.values:()[Lcn/Hanabi/modules/Category;
        //    65: checkcast       [Lcn/Hanabi/modules/Category;
        //    68: arraylength    
        //    69: if_icmpge       171
        //    72: new             LClassSub/Class92;
        //    75: dup            
        //    76: aload_0        
        //    77: aload_0        
        //    78: getfield        ClassSub/Class309.length:I
        //    81: ldc             2
        //    83: idiv           
        //    84: i2f            
        //    85: aload_0        
        //    86: getfield        ClassSub/Class309.sr:Lnet/minecraft/client/gui/ScaledResolution;
        //    89: invokevirtual   net/minecraft/client/gui/ScaledResolution.func_78328_b:()I
        //    92: i2f            
        //    93: ldc             0.342
        //    95: fmul           
        //    96: iload_1        
        //    97: ldc             1
        //    99: iadd           
        //   100: aload_0        
        //   101: getfield        ClassSub/Class309.sr:Lnet/minecraft/client/gui/ScaledResolution;
        //   104: invokevirtual   net/minecraft/client/gui/ScaledResolution.func_78328_b:()I
        //   107: imul           
        //   108: i2f            
        //   109: ldc             0.078
        //   111: fmul           
        //   112: fadd           
        //   113: aload_0        
        //   114: getfield        ClassSub/Class309.length:I
        //   117: ldc             2
        //   119: idiv           
        //   120: i2f            
        //   121: invokestatic    cn/Hanabi/modules/Category.values:()[Lcn/Hanabi/modules/Category;
        //   124: checkcast       [Lcn/Hanabi/modules/Category;
        //   127: iload_1        
        //   128: aaload         
        //   129: invokevirtual   cn/Hanabi/modules/Category.toString:()Ljava/lang/String;
        //   132: aload_0        
        //   133: getfield        ClassSub/Class309.sr:Lnet/minecraft/client/gui/ScaledResolution;
        //   136: aload_0        
        //   137: invokespecial   ClassSub/Class92.<init>:(LClassSub/Class309;FFFLjava/lang/String;Lnet/minecraft/client/gui/ScaledResolution;LClassSub/Class309;)V
        //   140: astore_2       
        //   141: aload_2        
        //   142: ldc             0
        //   144: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   147: putfield        ClassSub/Class120.active:Ljava/lang/Boolean;
        //   150: aload_0        
        //   151: getfield        ClassSub/Class309.button:Ljava/util/List;
        //   154: aload_2        
        //   155: invokevirtual   java/util/List.add:(Ljava/lang/Object;)Z
        //   158: pop            
        //   159: iinc            1, 1
        //   162: goto            61
        //   165: nop            
        //   166: nop            
        //   167: nop            
        //   168: nop            
        //   169: nop            
        //   170: athrow         
        //   171: aload_0        
        //   172: getfield        ClassSub/Class309.button:Ljava/util/List;
        //   175: ldc             0
        //   177: invokevirtual   java/util/List.get:(I)Ljava/lang/Object;
        //   180: checkcast       LClassSub/Class120;
        //   183: ldc             1
        //   185: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   188: putfield        ClassSub/Class120.active:Ljava/lang/Boolean;
        //   191: return         
        //   192: nop            
        //   193: nop            
        //   194: nop            
        //   195: athrow         
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
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:425)
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
    
    public void draw() {
        this.sr = new ScaledResolution(this.mc);
        Class284.drawRect(0.0f, 0.0f, this.length, this.sr.func_78328_b(), Class61.theme.isCurrentMode("Light") ? -1118482 : new Color(22, 22, 22).getRGB());
        Class284.drawRect(this.length, 0.0f, this.length + 2, this.sr.func_78328_b(), Class61.theme.isCurrentMode("Light") ? new Color(-14848033).brighter().getRGB() : new Color(47, 116, 253).getRGB());
        Class120 class120 = null;
        this.length = (int)(this.sr.func_78326_a() * 0.155);
        int n = 0;
        for (final Class120 class121 : this.button) {
            class121.x = this.length / 2;
            class121.y = this.sr.func_78328_b() * 0.342f + (n + 1) * this.sr.func_78328_b() * 0.078f - 40.0f;
            class121.radius = this.length / 2;
            ++n;
            if ((boolean)class121.active) {
                class120 = class121;
            }
        }
        this.animationY = (float)Class284.getAnimationState(this.animationY, class120.y, Math.max(10.0, (double)(Math.abs(this.animationY - class120.y) * 50.0f) * 0.3));
        Class284.drawRoundedRect((int)class120.x - 50, (int)this.animationY - 15, (int)class120.x + 50, (int)this.animationY + 18, 15.0f, Class61.theme.isCurrentMode("Light") ? new Color(-14848033).brighter().getRGB() : new Color(47, 116, 253).getRGB());
        final Iterator<Class120> iterator2 = this.button.iterator();
        while (iterator2.hasNext()) {
            ((Class120)iterator2.next()).drawOther();
        }
        UnicodeFontRenderer unicodeFontRenderer = Hanabi.INSTANCE.fontManager.icon50;
        if (this.sr.func_78328_b() < 330) {
            unicodeFontRenderer = Hanabi.INSTANCE.fontManager.icon50;
        }
        else if (this.sr.func_78328_b() < 370) {
            unicodeFontRenderer = Hanabi.INSTANCE.fontManager.icon70;
        }
        else if (this.sr.func_78328_b() < 450) {
            unicodeFontRenderer = Hanabi.INSTANCE.fontManager.icon100;
        }
        else if (this.sr.func_78328_b() < 550) {
            unicodeFontRenderer = Hanabi.INSTANCE.fontManager.icon130;
        }
        unicodeFontRenderer.drawCenteredString(HanabiFonts.ICON_HANABI_LOGO, this.length / 2.1, (float)(int)(this.sr.func_78328_b() * 0.11), Class61.theme.isCurrentMode("Light") ? new Color(-14848033).brighter().getRGB() : new Color(47, 116, 253).getRGB());
    }
    
    public void onMouseClick(final int n, final int n2) {
        for (final Class120 class120 : this.button) {
            if (class120.isPressed(n, n2)) {
                class120.onPress();
                Class79.wheelStateMod = 0;
            }
        }
    }
}
