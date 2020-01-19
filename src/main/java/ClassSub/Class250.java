package ClassSub;

import java.awt.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.util.*;

public class Class250<T>
{
    static final int OFFSET = 3;
    @NotNull
    static Color BACKGROUND;
    @NotNull
    static Color BORDER;
    @NotNull
    static Color SELECTED;
    static Color FOREGROUND;
    @NotNull
    private List<Class75<T>> tabs;
    private int selectedTab;
    private int selectedSubTab;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class250() {
        super();
        this.tabs = new ArrayList<Class75<T>>();
        this.selectedTab = 0;
        this.selectedSubTab = -1;
    }
    
    public static void drawRect(final int n, int n2, int n3, int n4, int n5, final int n6) {
        if (n2 < n4) {
            final int n7 = n2;
            n2 = n4;
            n4 = n7;
        }
        if (n3 < n5) {
            final int n8 = n3;
            n3 = n5;
            n5 = n8;
        }
        final float n9 = (n6 >> 24 & 0xFF) / 255.0f;
        final float n10 = (n6 >> 16 & 0xFF) / 255.0f;
        final float n11 = (n6 >> 8 & 0xFF) / 255.0f;
        final float n12 = (n6 & 0xFF) / 255.0f;
        final Tessellator func_178181_a = Tessellator.func_178181_a();
        final WorldRenderer func_178180_c = func_178181_a.func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(n10, n11, n12, n9);
        func_178180_c.func_181668_a(n, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n2, (double)n5, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n4, (double)n5, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n4, (double)n3, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n2, (double)n3, 0.0).func_181675_d();
        func_178181_a.func_78381_a();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    public void addTab(final Class75<T> class75) {
        this.tabs.add(class75);
    }
    
    public void render(final int n, final int n2) {
        GL11.glTranslated((double)n, (double)n2, 0.0);
        final FontRenderer field_71466_p = Minecraft.func_71410_x().field_71466_p;
        final int n3 = (field_71466_p.field_78288_b + 3) * this.tabs.size();
        int func_78256_a = 0;
        for (final Class75<T> class75 : this.tabs) {
            if (field_71466_p.func_78256_a(class75.getText()) > func_78256_a) {
                func_78256_a = field_71466_p.func_78256_a(class75.getText());
            }
        }
        func_78256_a += 4;
        drawRect(7, 0, 0, func_78256_a, n3, Class250.BACKGROUND.getRGB());
        int n4 = 2;
        int n5 = 0;
        for (final Class75<T> class76 : this.tabs) {
            if (this.selectedTab == n5) {
                drawRect(7, 0, n4 - 2, func_78256_a, n4 + field_71466_p.field_78288_b + 3 - 2, Class250.SELECTED.getRGB());
                if (this.selectedSubTab != -1) {
                    class76.renderSubTabs(func_78256_a, n4 - 2, this.selectedSubTab);
                }
            }
            field_71466_p.func_78276_b(class76.getText(), 2, n4, Class250.FOREGROUND.getRGB());
            n4 += field_71466_p.field_78288_b + 3;
            ++n5;
        }
        GL11.glLineWidth(1.0f);
        drawRect(2, 0, 0, func_78256_a, n3, Class250.BORDER.getRGB());
        GL11.glTranslated((double)(-n), (double)(-n2), 0.0);
    }
    
    public void handleKey(final int n) {
        if (n == 208) {
            if (this.selectedSubTab == -1) {
                ++this.selectedTab;
                if (this.selectedTab >= this.tabs.size()) {
                    this.selectedTab = 0;
                }
            }
            else {
                ++this.selectedSubTab;
                if (this.selectedSubTab >= ((Class75<T>)this.tabs.get(this.selectedTab)).getSubTabs().size()) {
                    this.selectedSubTab = 0;
                }
            }
        }
        else if (n == 200) {
            if (this.selectedSubTab == -1) {
                --this.selectedTab;
                if (this.selectedTab < 0) {
                    this.selectedTab = this.tabs.size() - 1;
                }
            }
            else {
                --this.selectedSubTab;
                if (this.selectedSubTab < 0) {
                    this.selectedSubTab = ((Class75<T>)this.tabs.get(this.selectedTab)).getSubTabs().size() - 1;
                }
            }
        }
        else if (n == 203) {
            this.selectedSubTab = -1;
        }
        else if (this.selectedSubTab == -1 && (n == 28 || n == 205)) {
            this.selectedSubTab = 0;
        }
        else if (n == 28 || n == 205) {
            ((Class40<T>)((Class75<T>)this.tabs.get(this.selectedTab)).getSubTabs().get(this.selectedSubTab)).press();
        }
    }
    
    static {
        Class250.BACKGROUND = new Color(0, 0, 0, 175);
        Class250.BORDER = new Color(0, 0, 0, 255);
        Class250.SELECTED = new Color(38, 164, 78, 200);
        Class250.FOREGROUND = Color.white;
    }
}
