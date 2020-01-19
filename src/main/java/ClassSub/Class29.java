package ClassSub;

import java.awt.image.*;
import java.awt.*;
import java.util.*;

public class Class29 implements Class208
{
    private Color color;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class29() {
        super();
        this.color = Color.white;
    }
    
    public Class29(final Color color) {
        super();
        this.color = Color.white;
        this.color = color;
    }
    
    @Override
    public void draw(final BufferedImage bufferedImage, final Graphics2D graphics2D, final Class135 class135, final Class182 class136) {
        graphics2D.setColor(this.color);
        graphics2D.fill(class136.getShape());
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("color cannot be null.");
        }
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Color";
    }
    
    @Override
    public List getValues() {
        final ArrayList<Class4> list = new ArrayList<Class4>();
        list.add(Class321.colorValue("Color", this.color));
        return list;
    }
    
    @Override
    public void setValues(final List list) {
        for (final Class4 class4 : list) {
            if (class4.getName().equals("Color")) {
                this.setColor((Color)class4.getObject());
            }
        }
    }
}
