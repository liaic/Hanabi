package cn.Hanabi.modules.Player;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import cn.Hanabi.injection.interfaces.*;
import com.darkmagician6.eventapi.*;

public class FastPlace extends Mod
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public FastPlace() {
        super("FastPlace", Category.PLAYER);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        ((IMinecraft)FastPlace.mc).setRightClickDelayTimer(0);
    }
}
