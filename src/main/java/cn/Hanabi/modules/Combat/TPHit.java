package cn.Hanabi.modules.Combat;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.injection.interfaces.*;
import ClassSub.*;
import java.util.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.events.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.client.*;

public class TPHit extends Mod
{
    int count;
    int aacCount;
    int aacPackets;
    int aacState;
    EntityLivingBase entity;
    Value<Boolean> cancelPackets;
    Value<Boolean> aac;
    List<Class55> posList;
    Value<Double> packets;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public TPHit() {
        super("TPHit", Category.COMBAT);
        this.cancelPackets = new Value<Boolean>("TPHit_CancelPackets", false);
        this.aac = new Value<Boolean>("TPHit_AAC", true);
        this.posList = new ArrayList<Class55>();
        this.packets = new Value<Double>("TPHit_Packets", 8.0, 1.0, 40.0, 1.0);
    }
    
    public void onEnable() {
        if ((boolean)this.aac.getValueState()) {
            this.aacCount = 30;
            this.aacPackets = 2;
        }
        this.count = 0;
        this.entity = null;
        this.posList.clear();
        if (!ModManager.getModule("Reach").isEnabled()) {
            ModManager.getModule("Reach").set(true);
            Class295.tellPlayer("§b[Hanabi]§a要使用TPHit，必须先启用Reach。");
        }
    }
    
    public void onDisable() {
        Class296.getTimer().field_74278_d = 1.0f;
    }
    
    @EventTarget
    public void onPacket(final EventPacket eventPacket) {
        final Packet packet = eventPacket.getPacket();
        if (packet instanceof C03PacketPlayer && (this.count < (int)(Object)this.packets.getValueState() * 2 || this.entity == null)) {
            ++this.count;
            if ((boolean)this.cancelPackets.getValueState()) {
                eventPacket.setCancelled(true);
            }
        }
        else if ((this.entity == null || this.count < (int)(Object)this.packets.getValueState() * 2) && packet instanceof C02PacketUseEntity) {
            eventPacket.setCancelled(true);
        }
    }
    
    @EventTarget
    public void onMove(final EventMove eventMove) {
        if (this.count < (int)(Object)this.packets.getValueState() * 2 || this.entity == null) {}
    }
    
    @EventTarget
    public void onRender(final EventRender eventRender) {
        if (this.posList.size() > 0) {
            for (final Class55 class55 : this.posList) {
                Class284.drawEntityESP(class55.x - ((IRenderManager)TPHit.mc.func_175598_ae()).getRenderPosX(), class55.y - ((IRenderManager)TPHit.mc.func_175598_ae()).getRenderPosY(), class55.z - ((IRenderManager)TPHit.mc.func_175598_ae()).getRenderPosZ(), 0.25, 1.25, 0.0f, 1.0f, 0.0f, 0.2f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
            }
        }
    }
    
    @EventTarget
    public void onAttack(final EventAttack eventAttack) {
        class Class215 extends Thread
        {
            final EventAttack val$e;
            final TPHit this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class215(final TPHit this$0, final EventAttack val$e) {
                this.this$0 = this$0;
                this.val$e = val$e;
                super();
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(10L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                final int func_177958_n = this.val$e.getEntity().func_180425_c().func_177958_n();
                final int func_177956_o = this.val$e.getEntity().func_180425_c().func_177956_o();
                final int func_177952_p = this.val$e.getEntity().func_180425_c().func_177952_p();
                final double n = func_177958_n - TPHit.access$000().field_71439_g.field_70165_t + 0.5;
                final double n2 = func_177956_o - TPHit.access$100().field_71439_g.field_70163_u + 0.08;
                final double n3 = func_177952_p - TPHit.access$200().field_71439_g.field_70161_v + 0.5;
                final double ceil = Math.ceil(Math.sqrt(Math.pow(n, 2.0) + Math.pow(n2, 2.0) + Math.pow(n3, 2.0)) / 9.8);
                TPHit.access$600().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$300().field_71439_g.field_70165_t, TPHit.access$400().field_71439_g.field_70163_u - 0.32, TPHit.access$500().field_71439_g.field_70161_v, false));
                TPHit.access$1000().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$700().field_71439_g.field_70165_t, TPHit.access$800().field_71439_g.field_70163_u - 0.32, TPHit.access$900().field_71439_g.field_70161_v, false));
                TPHit.access$1400().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$1100().field_71439_g.field_70165_t, TPHit.access$1200().field_71439_g.field_70163_u, TPHit.access$1300().field_71439_g.field_70161_v, false));
                TPHit.access$1800().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$1500().field_71439_g.field_70165_t, TPHit.access$1600().field_71439_g.field_70163_u, TPHit.access$1700().field_71439_g.field_70161_v, false));
                TPHit.access$2200().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$1900().field_71439_g.field_70165_t, TPHit.access$2000().field_71439_g.field_70163_u + 1.1, TPHit.access$2100().field_71439_g.field_70161_v, false));
                TPHit.access$2600().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$2300().field_71439_g.field_70165_t, TPHit.access$2400().field_71439_g.field_70163_u + 1.1, TPHit.access$2500().field_71439_g.field_70161_v, false));
                for (int n4 = 1; n4 <= ceil; ++n4) {
                    TPHit.access$3000().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$2700().field_71439_g.field_70165_t + n / ceil * n4, TPHit.access$2800().field_71439_g.field_70163_u + n2 / ceil * n4, TPHit.access$2900().field_71439_g.field_70161_v + n3 / ceil * n4, false));
                }
                TPHit.access$3200().field_71442_b.func_78764_a((EntityPlayer)TPHit.access$3100().field_71439_g, this.val$e.getEntity());
                TPHit.access$3300().field_71439_g.func_71038_i();
            }
        }
        class Class221 extends Thread
        {
            final EventAttack val$e;
            final TPHit this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class221(final TPHit this$0, final EventAttack val$e) {
                this.this$0 = this$0;
                this.val$e = val$e;
                super();
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(175L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                this.this$0.aacState = 2;
                TPHit.access$3500().field_71442_b.func_78764_a((EntityPlayer)TPHit.access$3400().field_71439_g, this.val$e.getEntity());
                TPHit.access$3600().field_71439_g.func_71038_i();
            }
        }
        class Class258 extends Thread
        {
            final EventAttack val$e;
            final TPHit this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class258(final TPHit this$0, final EventAttack val$e) {
                this.this$0 = this$0;
                this.val$e = val$e;
                super();
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                this.this$0.aacCount = 0;
                TPHit.access$3800().field_71442_b.func_78764_a((EntityPlayer)TPHit.access$3700().field_71439_g, this.val$e.getEntity());
                TPHit.access$3900().field_71439_g.func_71038_i();
            }
        }
        class Class62 extends Thread
        {
            final TPHit this$0;
            public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
            
            Class62(final TPHit this$0) {
                this.this$0 = this$0;
                super();
            }
            
            @Override
            public void run() {
                try {
                    Thread.sleep(1430L);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                TPHit.access$4300().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(TPHit.access$4000().field_71439_g.field_70165_t + 0.08, TPHit.access$4100().field_71439_g.field_70163_u, TPHit.access$4200().field_71439_g.field_70161_v, false));
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: athrow         
        //     4: aload_0        
        //     5: getfield        cn/Hanabi/modules/Combat/TPHit.aac:Lcn/Hanabi/value/Value;
        //     8: invokevirtual   cn/Hanabi/value/Value.getValueState:()Ljava/lang/Object;
        //    11: checkcast       Ljava/lang/Boolean;
        //    14: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //    17: ifeq            238
        //    20: aload_0        
        //    21: getfield        cn/Hanabi/modules/Combat/TPHit.aacState:I
        //    24: ldc             2
        //    26: if_icmpne       47
        //    29: aload_0        
        //    30: ldc             0
        //    32: putfield        cn/Hanabi/modules/Combat/TPHit.aacState:I
        //    35: new             LClassSub/Class215;
        //    38: dup            
        //    39: aload_0        
        //    40: aload_1        
        //    41: invokespecial   ClassSub/Class215.<init>:(Lcn/Hanabi/modules/Combat/TPHit;Lcn/Hanabi/events/EventAttack;)V
        //    44: invokevirtual   ClassSub/Class215.start:()V
        //    47: aload_0        
        //    48: getfield        cn/Hanabi/modules/Combat/TPHit.aacState:I
        //    51: ldc             1
        //    53: if_icmpne       75
        //    56: invokestatic    ClassSub/Class296.getTimer:()Lnet/minecraft/util/Timer;
        //    59: fconst_1       
        //    60: putfield        net/minecraft/util/Timer.field_74278_d:F
        //    63: new             LClassSub/Class221;
        //    66: dup            
        //    67: aload_0        
        //    68: aload_1        
        //    69: invokespecial   ClassSub/Class221.<init>:(Lcn/Hanabi/modules/Combat/TPHit;Lcn/Hanabi/events/EventAttack;)V
        //    72: invokevirtual   ClassSub/Class221.start:()V
        //    75: aload_0        
        //    76: getfield        cn/Hanabi/modules/Combat/TPHit.aacCount:I
        //    79: ldc             30
        //    81: if_icmple       160
        //    84: aload_0        
        //    85: getfield        cn/Hanabi/modules/Combat/TPHit.aacState:I
        //    88: ifne            288
        //    91: getstatic       cn/Hanabi/modules/Combat/TPHit.mc:Lnet/minecraft/client/Minecraft;
        //    94: getfield        net/minecraft/client/Minecraft.field_71474_y:Lnet/minecraft/client/settings/GameSettings;
        //    97: getfield        net/minecraft/client/settings/GameSettings.field_74312_F:Lnet/minecraft/client/settings/KeyBinding;
        //   100: invokevirtual   net/minecraft/client/settings/KeyBinding.func_151470_d:()Z
        //   103: ifeq            288
        //   106: invokestatic    ClassSub/Class296.getTimer:()Lnet/minecraft/util/Timer;
        //   109: ldc_w           0.01
        //   112: putfield        net/minecraft/util/Timer.field_74278_d:F
        //   115: ldc_w           "§7§l[§c§lTPHit§7§l]§7 Trying to hit entity..."
        //   118: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   121: aload_0        
        //   122: ldc             1
        //   124: putfield        cn/Hanabi/modules/Combat/TPHit.aacState:I
        //   127: new             LClassSub/Class258;
        //   130: dup            
        //   131: aload_0        
        //   132: aload_1        
        //   133: invokespecial   ClassSub/Class258.<init>:(Lcn/Hanabi/modules/Combat/TPHit;Lcn/Hanabi/events/EventAttack;)V
        //   136: invokevirtual   ClassSub/Class258.start:()V
        //   139: new             LClassSub/Class62;
        //   142: dup            
        //   143: aload_0        
        //   144: invokespecial   ClassSub/Class62.<init>:(Lcn/Hanabi/modules/Combat/TPHit;)V
        //   147: invokevirtual   ClassSub/Class62.start:()V
        //   150: goto            288
        //   153: nop            
        //   154: nop            
        //   155: nop            
        //   156: nop            
        //   157: nop            
        //   158: nop            
        //   159: athrow         
        //   160: aload_0        
        //   161: getfield        cn/Hanabi/modules/Combat/TPHit.aacState:I
        //   164: ifne            288
        //   167: getstatic       cn/Hanabi/modules/Combat/TPHit.mc:Lnet/minecraft/client/Minecraft;
        //   170: getfield        net/minecraft/client/Minecraft.field_71474_y:Lnet/minecraft/client/settings/GameSettings;
        //   173: getfield        net/minecraft/client/settings/GameSettings.field_74312_F:Lnet/minecraft/client/settings/KeyBinding;
        //   176: invokevirtual   net/minecraft/client/settings/KeyBinding.func_151470_d:()Z
        //   179: ifeq            288
        //   182: ldc2_w          1.5
        //   185: aload_0        
        //   186: getfield        cn/Hanabi/modules/Combat/TPHit.aacCount:I
        //   189: ldc             1
        //   191: isub           
        //   192: i2d            
        //   193: ldc2_w          0.05
        //   196: dmul           
        //   197: dsub           
        //   198: dstore_2       
        //   199: new             Ljava/lang/StringBuilder;
        //   202: dup            
        //   203: invokespecial   java/lang/StringBuilder.<init>:()V
        //   206: ldc_w           "§7§l[§c§lTPHit§7§l]§7 Wait §a "
        //   209: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: dload_2        
        //   213: invokevirtual   java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
        //   216: ldc_w           " §7 seconds before hitting again!"
        //   219: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   222: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   225: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   228: goto            288
        //   231: nop            
        //   232: nop            
        //   233: nop            
        //   234: nop            
        //   235: nop            
        //   236: nop            
        //   237: athrow         
        //   238: aload_1        
        //   239: invokevirtual   cn/Hanabi/events/EventAttack.getEntity:()Lnet/minecraft/entity/Entity;
        //   242: instanceof      Lnet/minecraft/entity/EntityLivingBase;
        //   245: ifeq            288
        //   248: aload_0        
        //   249: aload_1        
        //   250: invokevirtual   cn/Hanabi/events/EventAttack.getEntity:()Lnet/minecraft/entity/Entity;
        //   253: checkcast       Lnet/minecraft/entity/EntityLivingBase;
        //   256: putfield        cn/Hanabi/modules/Combat/TPHit.entity:Lnet/minecraft/entity/EntityLivingBase;
        //   259: new             Ljava/lang/StringBuilder;
        //   262: dup            
        //   263: invokespecial   java/lang/StringBuilder.<init>:()V
        //   266: ldc_w           "§b[Hanabi]§a\u5df2\u6210\u529f\u9009\u5b9a\u5b9e\u4f53\uff1a"
        //   269: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   272: aload_0        
        //   273: getfield        cn/Hanabi/modules/Combat/TPHit.entity:Lnet/minecraft/entity/EntityLivingBase;
        //   276: invokevirtual   net/minecraft/entity/EntityLivingBase.func_70005_c_:()Ljava/lang/String;
        //   279: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   282: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   285: invokestatic    ClassSub/Class295.tellPlayer:(Ljava/lang/String;)V
        //   288: return         
        //   289: nop            
        //   290: nop            
        //   291: nop            
        //   292: nop            
        //   293: athrow         
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
    
    @EventTarget
    public void onPullback(final EventPullback eventPullback) {
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if ((boolean)this.aac.getValueState()) {
            ++this.aacCount;
        }
        else {
            this.setDisplayName("Canceled:" + this.count);
            if (this.entity != null && (this.entity.field_70128_L || this.entity.func_110143_aJ() <= 0.0f)) {
                this.set(false);
            }
            if ((this.count >= (int)(Object)this.packets.getValueState() * 2 || this.cancelPackets.getValueState()) && this.entity != null && this.entity.field_70737_aN == 0) {
                final double n = this.entity.field_70165_t - TPHit.mc.field_71439_g.field_70165_t;
                final double n2 = this.entity.field_70163_u - TPHit.mc.field_71439_g.field_70163_u;
                final double n3 = this.entity.field_70161_v - TPHit.mc.field_71439_g.field_70161_v;
                TPHit.mc.field_71439_g.field_70143_R = 5.0f;
                this.posList.clear();
                try {
                    for (int i = 1; i <= (int)(Object)this.packets.getValueState(); ++i) {
                        final Class55 class55 = new Class55(TPHit.mc.field_71439_g.field_70165_t + n / (int)(Object)this.packets.getValueState() * i, TPHit.mc.field_71439_g.field_70163_u + n2 / (int)(Object)this.packets.getValueState() * i, TPHit.mc.field_71439_g.field_70161_v + n3 / (int)(Object)this.packets.getValueState() * i);
                        final Block func_177230_c = TPHit.mc.field_71441_e.func_180495_p(new BlockPos(class55.x, class55.y, class55.z)).func_177230_c();
                        if (func_177230_c instanceof BlockAir || func_177230_c instanceof BlockLiquid) {
                            this.posList.add(class55);
                            TPHit.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(class55.getX(), class55.getY() + 0.1 * i + 0.5, class55.getZ(), false));
                        }
                    }
                    TPHit.mc.field_71439_g.func_71038_i();
                    TPHit.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C02PacketUseEntity((Entity)this.entity, C02PacketUseEntity.Action.ATTACK));
                    for (int j = this.posList.size() - 1; j >= 0; --j) {
                        final Class55 class56 = (Class55)this.posList.get(j);
                        TPHit.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(class56.getX(), class56.getY() + 0.1 * j + 0.5, class56.getZ(), false));
                    }
                }
                catch (Throwable t) {
                    Class295.tellPlayer("§b[Hanabi]§a出现异常:" + t.getMessage());
                }
                TPHit.mc.field_71439_g.field_70143_R = 1.0f;
            }
        }
    }
    
    static Minecraft access$000() {
        return TPHit.mc;
    }
    
    static Minecraft access$100() {
        return TPHit.mc;
    }
    
    static Minecraft access$200() {
        return TPHit.mc;
    }
    
    static Minecraft access$300() {
        return TPHit.mc;
    }
    
    static Minecraft access$400() {
        return TPHit.mc;
    }
    
    static Minecraft access$500() {
        return TPHit.mc;
    }
    
    static Minecraft access$600() {
        return TPHit.mc;
    }
    
    static Minecraft access$700() {
        return TPHit.mc;
    }
    
    static Minecraft access$800() {
        return TPHit.mc;
    }
    
    static Minecraft access$900() {
        return TPHit.mc;
    }
    
    static Minecraft access$1000() {
        return TPHit.mc;
    }
    
    static Minecraft access$1100() {
        return TPHit.mc;
    }
    
    static Minecraft access$1200() {
        return TPHit.mc;
    }
    
    static Minecraft access$1300() {
        return TPHit.mc;
    }
    
    static Minecraft access$1400() {
        return TPHit.mc;
    }
    
    static Minecraft access$1500() {
        return TPHit.mc;
    }
    
    static Minecraft access$1600() {
        return TPHit.mc;
    }
    
    static Minecraft access$1700() {
        return TPHit.mc;
    }
    
    static Minecraft access$1800() {
        return TPHit.mc;
    }
    
    static Minecraft access$1900() {
        return TPHit.mc;
    }
    
    static Minecraft access$2000() {
        return TPHit.mc;
    }
    
    static Minecraft access$2100() {
        return TPHit.mc;
    }
    
    static Minecraft access$2200() {
        return TPHit.mc;
    }
    
    static Minecraft access$2300() {
        return TPHit.mc;
    }
    
    static Minecraft access$2400() {
        return TPHit.mc;
    }
    
    static Minecraft access$2500() {
        return TPHit.mc;
    }
    
    static Minecraft access$2600() {
        return TPHit.mc;
    }
    
    static Minecraft access$2700() {
        return TPHit.mc;
    }
    
    static Minecraft access$2800() {
        return TPHit.mc;
    }
    
    static Minecraft access$2900() {
        return TPHit.mc;
    }
    
    static Minecraft access$3000() {
        return TPHit.mc;
    }
    
    static Minecraft access$3100() {
        return TPHit.mc;
    }
    
    static Minecraft access$3200() {
        return TPHit.mc;
    }
    
    static Minecraft access$3300() {
        return TPHit.mc;
    }
    
    static Minecraft access$3400() {
        return TPHit.mc;
    }
    
    static Minecraft access$3500() {
        return TPHit.mc;
    }
    
    static Minecraft access$3600() {
        return TPHit.mc;
    }
    
    static Minecraft access$3700() {
        return TPHit.mc;
    }
    
    static Minecraft access$3800() {
        return TPHit.mc;
    }
    
    static Minecraft access$3900() {
        return TPHit.mc;
    }
    
    static Minecraft access$4000() {
        return TPHit.mc;
    }
    
    static Minecraft access$4100() {
        return TPHit.mc;
    }
    
    static Minecraft access$4200() {
        return TPHit.mc;
    }
    
    static Minecraft access$4300() {
        return TPHit.mc;
    }
}
