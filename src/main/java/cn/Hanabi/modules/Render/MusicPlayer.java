package cn.Hanabi.modules.Render;

import cn.Hanabi.modules.*;
import ClassSub.*;
import net.minecraft.client.gui.*;

public class MusicPlayer extends Mod
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public MusicPlayer() {
        super("MusicPlayer", Category.RENDER);
    }
    
    public void onEnable() {
        if (MusicPlayer.mc.currentScreen instanceof Class333) {
            this.setState(false);
            return;
        }
        MusicPlayer.mc.displayGuiScreen((GuiScreen)new Class333(100, 100, 200, 300));
        this.setState(false);
    }
}
