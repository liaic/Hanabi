package ClassSub;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class Class61 extends Mod
{
    public static final Class89 clickGui;
    ScaledResolution sr;
    public static Value<String> theme;
    int lastWidth;
    public static Class89 hanabi;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class61() {
        super("ClickGUI", Category.RENDER, true, true, 54);
        this.lastWidth = 0;
        Class61.theme.addValue("Dark");
        Class61.theme.addValue("Light");
        this.setState(false);
    }
    
    @Override
    protected void onEnable() {
        if (Class61.mc.field_71439_g == null) {
            return;
        }
        this.sr = new ScaledResolution(Minecraft.func_71410_x());
        if (Class61.hanabi == null || this.lastWidth != this.sr.func_78326_a()) {
            this.lastWidth = this.sr.func_78326_a();
            Class61.hanabi = new Class89();
        }
        if (Class61.mc.field_71462_r instanceof Class89) {
            this.setState(false);
            return;
        }
        Class61.mc.func_147108_a((GuiScreen)Class61.hanabi);
        this.setState(false);
    }
    
    static {
        clickGui = new Class89();
        Class61.theme = new Value<String>("ClickGUI", "Theme", 0);
    }
}
