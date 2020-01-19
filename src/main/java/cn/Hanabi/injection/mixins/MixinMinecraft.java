package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraftforge.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import net.minecraft.client.main.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.*;
import org.spongepowered.asm.mixin.injection.*;
import ClassSub.*;
import java.io.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.lwjgl.input.*;
import cn.Hanabi.events.*;

@SideOnly(Side.CLIENT)
@Mixin({ Minecraft.class })
public abstract class MixinMinecraft implements IMinecraft
{
    @Shadow
    public int field_71467_ac;
    long lastFrame;
    @Shadow
    public GuiScreen field_71462_r;
    @Shadow
    @Mutable
    @Final
    private Session field_71449_j;
    @Shadow
    private LanguageManager field_135017_as;
    @Shadow
    private Timer field_71428_T;
    @Shadow
    private int field_71429_W;
    
    public MixinMinecraft() {
        super();
    }
    
    @Shadow
    protected abstract void func_147116_af();
    
    @Override
    public void runCrinkMouse() {
        this.func_147116_af();
    }
    
    @Override
    public void setClickCounter(final int a) {
        this.field_71429_W = a;
    }
    
    @Inject(method = { "<init>" }, at = { @At("RETURN") })
    private void minecraftConstructor(final GameConfiguration gameConfig, final CallbackInfo ci) {
        if (Integer.valueOf(System.getProperty("java.version").split("_")[1]) >= 180) {
            Class69.username = "";
            Class69.password = "";
            Class69.prepare();
            if (Class296.c4n && Class296.cr4ckm3 && Class296.If && Class296.y0u) {
                new Hanabi();
            }
            return;
        }
        Class213.showMessageBox("启动失败。请更新Java。");
        while (true) {}
    }
    
    @Inject(method = { "startGame" }, at = { @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;", shift = At.Shift.AFTER) })
    private void startGame(final CallbackInfo ci) {
        if (Class296.c4n && Class296.cr4ckm3 && Class296.If && Class296.y0u) {
            Hanabi.INSTANCE.startClient();
        }
    }
    
    @Inject(method = { "runGameLoop" }, at = { @At("HEAD") })
    private void runGameLoop(final CallbackInfo ci) throws IOException {
        final long i = System.nanoTime();
        final long thisFrame = System.currentTimeMillis();
        Class284.delta = (thisFrame - this.lastFrame) / 1000.0f;
        this.lastFrame = thisFrame;
        Class69.onGameLoop();
    }
    
    @Inject(method = { "clickMouse" }, at = { @At("HEAD") })
    private void clickMouse(final CallbackInfo ci) {
        EventManager.call((Event)new EventClickMouse());
    }
    
    @Inject(method = { "runTick" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift = At.Shift.AFTER) })
    private void onKey(final CallbackInfo ci) {
        if (Keyboard.getEventKeyState() && this.field_71462_r == null) {
            EventManager.call((Event)new EventKey((Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + 'Ā') : Keyboard.getEventKey()));
        }
    }
    
    @Inject(method = { "shutdown" }, at = { @At("HEAD") })
    private void onShutdown(final CallbackInfo ci) {
        Hanabi.INSTANCE.stopClient();
    }
    
    @Override
    public Session getSession() {
        return this.field_71449_j;
    }
    
    @Override
    public void setSession(final Session session) {
        this.field_71449_j = session;
    }
    
    @Override
    public Timer getTimer() {
        return this.field_71428_T;
    }
    
    @Override
    public LanguageManager getLanguageManager() {
        return this.field_135017_as;
    }
    
    @Override
    public void setRightClickDelayTimer(final int i) {
        this.field_71467_ac = i;
    }
}
