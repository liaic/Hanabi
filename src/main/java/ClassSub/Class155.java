package ClassSub;

import cn.Hanabi.value.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import java.awt.*;

public class Class155 extends Class179<Value>
{
    private boolean isValueChanging;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class155(final Value value) {
        super(0, 0, 0, 0, value);
        this.isValueChanging = false;
    }
    
    @Override
    public void draw() {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)this.x, (float)this.y, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        final Rectangle rectangle = new Rectangle(this.x, this.y, this.getWidth(), this.getHeight());
        GL11.glTranslatef(2.0f, 2.0f, 0.0f);
        final int field_78288_b = this.fontRenderer.field_78288_b;
        Class167.setColor(Color.white);
        this.fontRenderer.func_78276_b(((String[])((Value)this.getValue()).getValueName().split("_"))[1], 0, 0, Class167.toRGBA(Color.white));
        String s = null;
        if (((Value)this.getValue()).getValueState() instanceof Integer || ((Value)this.getValue()).getValueState() instanceof Long) {
            s = ((Value<Object>)((Class179<Value<Object>>)this).getValue()).getValueState().toString();
        }
        else if (((Value)this.getValue()).getValueState() instanceof Float || ((Value)this.getValue()).getValueState() instanceof Double) {
            s = String.format("%.2f", (Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueState());
        }
        if (s != null) {
            Class167.setColor(Color.white);
            this.fontRenderer.func_78276_b(s, this.getWidth() - this.fontRenderer.func_78256_a(s) - 3, 0, Class167.toRGBA(Color.white));
        }
        Class167.setColor(Class8.PANEL_MAIN_COLOR);
        GL11.glLineWidth(0.9f);
        final double n = (((Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueState()).doubleValue() - ((Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueMin()).doubleValue()) / (((Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueMax()).doubleValue() - ((Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueMin()).doubleValue());
        Class167.setColor(Class8.PANEL_SECONDARY_COLOR);
        Gui.func_73734_a(0, field_78288_b + 2, (int)(rectangle.width * n) - 2, rectangle.height - 4, Class8.PANEL_SECONDARY_COLOR.getRGB());
        Class167.drawRect(2, 0, field_78288_b + 2, (int)(rectangle.width * n) - 2, rectangle.height - 4, Class8.PANEL_MAIN_COLOR.getRGB());
        GL11.glPopMatrix();
    }
    
    @Override
    public boolean onMouseClick(final int n, final int n2, final int n3) {
        if (new Rectangle(this.getX(), this.fontRenderer.field_78288_b + 2 + this.getY(), this.getWidth(), this.getHeight() - this.fontRenderer.field_78288_b).contains(n, n2) && n3 == 0) {
            if (Mouse.isButtonDown(0) && !this.isValueChanging) {
                this.isValueChanging = true;
            }
            else if (!Mouse.isButtonDown(0) && this.isValueChanging) {
                this.isValueChanging = false;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void update() {
        if (this.isValueChanging) {
            final Point calculateMouseLocation = Class251.calculateMouseLocation();
            if (!Mouse.isButtonDown(0) || !new Rectangle(this.getX(), 0, this.getWidth(), Integer.MAX_VALUE).contains(calculateMouseLocation)) {
                this.isValueChanging = false;
                return;
            }
            calculateMouseLocation.translate(-this.getX(), -this.getY());
            final double n = Math.round((((Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueMin()).doubleValue() - calculateMouseLocation.x / this.getWidth() * (((Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueMin()).doubleValue() - ((Number)((Value<Number>)((Class179<Value<Number>>)this).getValue()).getValueMax()).doubleValue())) * (1.0 / ((Value)this.getValue()).getSteps())) / (1.0 / ((Value)this.getValue()).getSteps());
            if (((Value)this.getValue()).getValueState() instanceof Integer) {
                ((Value<Integer>)((Class179<Value<Integer>>)this).getValue()).setValueState((int)Math.round(n));
            }
            if (((Value)this.getValue()).getValueState() instanceof Float) {
                ((Value<Float>)((Class179<Value<Float>>)this).getValue()).setValueState((float)n);
            }
            if (((Value)this.getValue()).getValueState() instanceof Double) {
                ((Value<Double>)((Class179<Value<Double>>)this).getValue()).setValueState(n);
            }
            if (((Value)this.getValue()).getValueState() instanceof Long) {
                ((Value<Long>)((Class179<Value<Long>>)this).getValue()).setValueState((long)n);
            }
        }
        this.width = Math.max(100, this.fontRenderer.func_78256_a(((String[])((Value)this.value).getValueName().split("_"))[1]) + 25);
        this.height = 12 + this.fontRenderer.field_78288_b;
    }
}
