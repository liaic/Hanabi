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
        if (MusicPlayer.mc.field_71462_r instanceof Class148) {
            this.setState(false);
            return;
        }
        MusicPlayer.mc.func_147108_a((GuiScreen)new Class148(100, 100, 200, 300));
        this.setState(false);
    }
}
