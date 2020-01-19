package ClassSub;

import java.awt.*;
import org.jetbrains.annotations.*;
import cn.Hanabi.*;
import java.util.function.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import cn.Hanabi.utils.fontmanager.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import java.io.*;
import cn.Hanabi.modules.*;

public class Class8 extends GuiScreen
{
    @NotNull
    public static Color PANEL_MAIN_COLOR;
    @NotNull
    public static Color PANEL_SECONDARY_COLOR;
    @NotNull
    private List<Class86> panels;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class8() {
        super();
        this.panels = new ArrayList<Class86>();
    }
    
    public void init() {
        int n = 0;
        final int n2 = 100;
        for (final Category category : (Category[])Category.values()) {
            final Class86 class86 = new Class86(category.toString(), n, 50, n2);
            Hanabi.INSTANCE.moduleManager.getModules().stream().filter(Class8::lambda$init$0).forEach((Consumer<? super Object>)Class8::lambda$init$1);
            if (class86.getButtons().size() > 0) {
                this.panels.add(class86);
                n += n2 * 1.2;
            }
        }
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        final UnicodeFontRenderer comfortaa16 = Hanabi.INSTANCE.fontManager.comfortaa16;
        for (final Class86 class86 : this.panels) {
            Gui.func_73734_a(class86.getX() - 2, class86.getY() - 2, class86.getX() + class86.getWidth() + 2, class86.getY() + 20, Class218.rainbow(0));
            GL11.glLineWidth(class86.isDrag() ? 2.0f : 1.0f);
            Class167.drawRect(2, class86.getX() - 2, class86.getY() - 2, class86.getX() + class86.getWidth() + 2, class86.getY() + 20, Class8.PANEL_MAIN_COLOR.hashCode());
            comfortaa16.func_175063_a(class86.getPanelName(), (float)class86.getX() + 2.0f, (float)class86.getY() + 5.0f, 16777215);
            for (int i = 0; i < class86.getButtons().size(); ++i) {
                final Class212 class87 = (Class212)class86.getButtons().get(i);
                Gui.func_73734_a(class86.getX(), class86.getY() + 20 + 20 * i, class86.getX() + class86.getWidth(), class86.getY() + 20 * i + 40, Class8.PANEL_MAIN_COLOR.getRGB());
                comfortaa16.func_175063_a(class87.getModule().getName(), class86.getX() + 5.0f, class86.getY() + 20 + 20 * i + 7, class87.getModule().isEnabled() ? 65280 : 16777215);
                class87.renderExtended(class86.getX() + class86.getWidth(), class86.getY() + 20 + 20 * i + 7);
            }
            if (class86.isDrag()) {
                class86.setX(n + class86.getDragX());
                class86.setY(n2 + class86.getDragY());
            }
        }
        super.func_73863_a(n, n2, n3);
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) throws IOException {
        if (n3 != 0 && n3 != 1) {
            return;
        }
    Label_0386:
        for (int i = this.panels.size() - 1; i >= 0; --i) {
            final Class86 class86 = (Class86)this.panels.get(i);
            if (class86.isHoverHead(n, n2) && n3 == 0) {
                class86.setDrag(true);
                class86.setDragX(class86.getX() - n);
                class86.setDragY(class86.getY() - n2);
                this.panels.remove(class86);
                this.panels.add(class86);
                break;
            }
            for (int j = 0; j < class86.getButtons().size(); ++j) {
                final Class212 class87 = (Class212)class86.getButtons().get(j);
                if (class87.isHover(class86.getX(), class86.getY() + 20 + 20 * j, class86.getWidth(), 20, n, n2) && n3 == 0) {
                    class87.getModule().setState(!class87.getModule().getState());
                    this.field_146297_k.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("random.bow"), 1.0f));
                    break Label_0386;
                }
                if (class87.isHover(class86.getX(), class86.getY() + 20 + 20 * j, class86.getWidth(), 20, n, n2) && n3 == 1) {
                    class87.setExtended(!class87.isExtended());
                    this.field_146297_k.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("random.bow"), 1.0f));
                    break Label_0386;
                }
                if (class87.onMouseClick(n, n2, n3)) {
                    break Label_0386;
                }
            }
        }
        super.func_73864_a(n, n2, n3);
    }
    
    protected void func_146286_b(final int n, final int n2, final int n3) {
        final Iterator<Class86> iterator = this.panels.iterator();
        while (iterator.hasNext()) {
            ((Class86)iterator.next()).setDrag(false);
        }
        super.func_146286_b(n, n2, n3);
    }
    
    public void func_146281_b() {
        this.field_146297_k.field_71460_t.func_181022_b();
    }
    
    private static void lambda$init$1(final Class86 class86, final Mod mod) {
        class86.addButton(new Class212(class86, mod));
    }
    
    private static boolean lambda$init$0(final Category category, final Mod mod) {
        return mod.getCategory() == category;
    }
    
    static {
        Class8.PANEL_MAIN_COLOR = new Color(0, 0, 0, 200);
        Class8.PANEL_SECONDARY_COLOR = new Color(4359924);
    }
}
