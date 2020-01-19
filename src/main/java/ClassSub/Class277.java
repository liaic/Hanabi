package ClassSub;

import cn.Hanabi.value.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import java.awt.*;

public class Class277 extends Class179<Value>
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class277(final Value value) {
        super(-1, -1, 0, 0, value);
    }
    
    @Override
    public void draw() {
        GL11.glTranslated((double)this.x, (double)this.y, 0.0);
        final Rectangle rectangle = new Rectangle(this.x, this.y, this.width, this.height);
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        Class167.setColor(Class8.PANEL_MAIN_COLOR);
        final int n = rectangle.height - 4;
        if ((boolean)((Value<Boolean>)((Class179<Value<Boolean>>)this).getValue()).getValueState()) {
            Class167.setColor(Class8.PANEL_SECONDARY_COLOR);
            Class167.drawRect(7, 2, 2, n + 2, n + 2, Class8.PANEL_SECONDARY_COLOR.getRGB());
        }
        GL11.glLineWidth(2.0f);
        Class167.drawRect(2, 2, 2, n + 2, n + 2, Class8.PANEL_MAIN_COLOR.getRGB());
        if (rectangle.contains(Class251.calculateMouseLocation())) {
            GL11.glColor4f(0.0f, 0.0f, 0.0f, Mouse.isButtonDown(0) ? 0.5f : 0.3f);
            Gui.func_73734_a(0, 0, rectangle.width, rectangle.height, Class167.toRGBA(new Color(0, 0, 0, Mouse.isButtonDown(0) ? 125 : 70)));
        }
        Class167.setColor(Color.white);
        this.fontRenderer.func_78276_b(((String[])((Value)this.getValue()).getValueName().split("_"))[1], n + 6, rectangle.height / 2 - this.fontRenderer.field_78288_b / 2 + 1, Class167.toRGBA(Color.white));
        GL11.glEnable(2884);
        GL11.glDisable(3042);
        GL11.glTranslated((double)(-this.x), (double)(-this.y), 0.0);
    }
    
    @Override
    public boolean onMouseClick(final int n, final int n2, final int n3) {
        if (new Rectangle(this.getX(), this.getY(), this.width, this.height).contains(new Point(n, n2)) && n3 == 0) {
            ((Value)this.value).setValueState(!(boolean)((Value)this.value).getValueState());
            return true;
        }
        return false;
    }
    
    @Override
    public void update() {
        this.width = this.fontRenderer.func_78256_a(((String[])((Value)this.value).getValueName().split("_"))[1]) + this.fontRenderer.field_78288_b + 8;
        this.height = this.fontRenderer.field_78288_b + 4;
    }
}
