package ClassSub;

import net.minecraft.client.gui.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.util.*;
import cn.Hanabi.modules.*;
import java.util.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.*;
import java.io.*;

public class Class89 extends GuiScreen
{
    Class309 sideBar;
    List<Class79> windows;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class89() {
        super();
        this.windows = new ArrayList<Class79>();
        try {
            this.sideBar = new Class309();
            for (int i = 0; i < ((Category[])Category.values()).length; ++i) {
                this.windows.add(new Class79(((Category[])Category.values())[i]));
            }
        }
        catch (Throwable t) {}
    }
    
    public void func_73866_w_() {
        try {
            if (this.field_146297_k.field_71441_e != null) {
                ((IEntityRenderer)this.field_146297_k.field_71460_t).loadShader2(new ResourceLocation("shaders/post/blur.json"));
            }
            final Iterator<Mod> iterator = ModManager.getModList().iterator();
            while (iterator.hasNext()) {
                ((Mod)iterator.next()).modButton = null;
            }
            final Iterator<Class79> iterator2 = this.windows.iterator();
            while (iterator2.hasNext()) {
                ((Class79)iterator2.next()).createModUI();
            }
            Class79.booleanValueMap.clear();
        }
        catch (Throwable t) {
            Class295.tellPlayer("§b[Hanabi]§a加载Blur出现异常，建议关闭快速渲染。");
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        if (ModManager.getModule("StaffAnalyzer").isEnabled() && StaffAnalyzer.ui != null) {
            StaffAnalyzer.ui.mouseListener(n, n2);
        }
        if (Hanabi.INSTANCE.sbm != null) {
            Hanabi.INSTANCE.sbm.moveWindow(n, n2);
        }
        try {
            this.sideBar.draw();
            for (final Class120 class120 : this.sideBar.button) {
                if ((boolean)class120.active) {
                    for (final Class79 class121 : this.windows) {
                        if (class121.category.toString().equals(class120.title)) {
                            class121.draw(n, n2);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        catch (Throwable t) {}
    }
    
    protected void func_146286_b(final int n, final int n2, final int n3) {
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) throws IOException {
        try {
            this.sideBar.onMouseClick(n, n2);
            for (final Class120 class120 : this.sideBar.button) {
                if ((boolean)class120.active) {
                    for (final Class79 class121 : this.windows) {
                        if (class121.category.toString().equals(class120.title)) {
                            class121.onMouseClick(n, n2);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        catch (Throwable t) {}
    }
    
    private boolean isHovering(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
    
    public void func_146281_b() {
        try {
            this.field_146297_k.field_71460_t.func_181022_b();
        }
        catch (Throwable t) {
            Class295.tellPlayer("§b[Hanabi]§a加载Blur出现异常，建议关闭快速渲染。");
        }
    }
}
