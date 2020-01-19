package ClassSub;

import org.jetbrains.annotations.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.util.*;

public class Class75<T>
{
    @NotNull
    private List<Class40<T>> subTabs;
    private String text;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class75(final String text) {
        super();
        this.subTabs = new ArrayList<Class40<T>>();
        this.text = text;
    }
    
    public void addSubTab(final Class40<T> class40) {
        this.subTabs.add(class40);
    }
    
    @NotNull
    public List<Class40<T>> getSubTabs() {
        return this.subTabs;
    }
    
    public void renderSubTabs(final int n, final int n2, final int n3) {
        GL11.glTranslated((double)n, (double)n2, 0.0);
        final FontRenderer field_71466_p = Minecraft.func_71410_x().field_71466_p;
        final int n4 = (field_71466_p.field_78288_b + 3) * this.subTabs.size();
        int func_78256_a = 0;
        for (final Class40<T> class40 : this.subTabs) {
            if (field_71466_p.func_78256_a(class40.getText()) > func_78256_a) {
                func_78256_a = field_71466_p.func_78256_a(class40.getText());
            }
        }
        func_78256_a += 4;
        Class250.drawRect(7, 0, 0, func_78256_a, n4, Class250.BACKGROUND.getRGB());
        GL11.glLineWidth(1.0f);
        Class250.drawRect(2, 0, 0, func_78256_a, n4, Class250.BORDER.getRGB());
        int n5 = 2;
        int n6 = 0;
        for (final Class40<T> class41 : this.subTabs) {
            if (n3 == n6) {
                Class250.drawRect(7, 0, n5 - 2, func_78256_a, n5 + field_71466_p.field_78288_b + 3 - 1, Class250.SELECTED.getRGB());
            }
            field_71466_p.func_78276_b(class41.getText(), 2, n5, Class250.FOREGROUND.getRGB());
            n5 += field_71466_p.field_78288_b + 3;
            ++n6;
        }
        GL11.glTranslated((double)(-n), (double)(-n2), 0.0);
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        this.text = text;
    }
}
