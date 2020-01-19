package ClassSub;

import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import cn.Hanabi.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class Class118 extends Gui
{
    protected final int id;
    protected final FontRenderer fontRendererInstance;
    public int xPosition;
    public int yPosition;
    protected int width;
    protected final int height;
    protected String text;
    protected int maxStringLength;
    protected int cursorCounter;
    protected boolean enableBackgroundDrawing;
    protected boolean canLoseFocus;
    protected boolean isFocused;
    protected boolean isEnabled;
    protected int lineScrollOffset;
    protected int cursorPosition;
    protected int selectionEnd;
    protected int enabledColor;
    protected int disabledColor;
    protected boolean visible;
    private GuiPageButtonList.GuiResponder field_175210_x;
    private Predicate<String> field_175209_y;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class118(final int id, final FontRenderer fontRendererInstance, final int xPosition, final int yPosition, final int width, final int height) {
        super();
        this.text = "";
        this.maxStringLength = 32;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isEnabled = true;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.visible = true;
        this.field_175209_y = (Predicate<String>)Predicates.alwaysTrue();
        this.id = id;
        this.fontRendererInstance = fontRendererInstance;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
    }
    
    public void func_175207_a(final GuiPageButtonList.GuiResponder field_175210_x) {
        this.field_175210_x = field_175210_x;
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void setText(final String text) {
        if (this.field_175209_y.apply((Object)text)) {
            if (text.length() > this.maxStringLength) {
                this.text = text.substring(0, this.maxStringLength);
            }
            else {
                this.text = text;
            }
            this.setCursorPositionEnd();
        }
    }
    
    public String getText() {
        return this.text;
    }
    
    public String getSelectedText() {
        return this.text.substring((this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd, (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition);
    }
    
    public void func_175205_a(final Predicate<String> field_175209_y) {
        this.field_175209_y = field_175209_y;
    }
    
    public void writeText(final String s) {
        String string = "";
        final String func_71565_a = ChatAllowedCharacters.func_71565_a(s);
        final int n = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int n2 = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int n3 = this.maxStringLength - this.text.length() - (n - n2);
        if (this.text.length() > 0) {
            string += this.text.substring(0, n);
        }
        String text;
        int length;
        if (n3 < func_71565_a.length()) {
            text = string + func_71565_a.substring(0, n3);
            length = n3;
        }
        else {
            text = string + func_71565_a;
            length = func_71565_a.length();
        }
        if (this.text.length() > 0 && n2 < this.text.length()) {
            text += this.text.substring(n2);
        }
        if (this.field_175209_y.apply((Object)text)) {
            this.text = text;
            this.moveCursorBy(n - this.selectionEnd + length);
            if (this.field_175210_x != null) {
                this.field_175210_x.func_175319_a(this.id, this.text);
            }
        }
    }
    
    public void deleteWords(final int n) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(n) - this.cursorPosition);
            }
        }
    }
    
    public void deleteFromCursor(final int n) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean b = n < 0;
                final int n2 = b ? (this.cursorPosition + n) : this.cursorPosition;
                final int n3 = b ? this.cursorPosition : (this.cursorPosition + n);
                String text = "";
                if (n2 >= 0) {
                    text = this.text.substring(0, n2);
                }
                if (n3 < this.text.length()) {
                    text += this.text.substring(n3);
                }
                if (this.field_175209_y.apply((Object)text)) {
                    this.text = text;
                    if (b) {
                        this.moveCursorBy(n);
                    }
                    if (this.field_175210_x != null) {
                        this.field_175210_x.func_175319_a(this.id, this.text);
                    }
                }
            }
        }
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getNthWordFromCursor(final int n) {
        return this.getNthWordFromPos(n, this.getCursorPosition());
    }
    
    public int getNthWordFromPos(final int n, final int n2) {
        return this.func_146197_a(n, n2, true);
    }
    
    public int func_146197_a(final int n, final int n2, final boolean b) {
        int index = n2;
        final boolean b2 = n < 0;
        for (int abs = Math.abs(n), i = 0; i < abs; ++i) {
            if (!b2) {
                final int length = this.text.length();
                index = this.text.indexOf(32, index);
                if (index == -1) {
                    index = length;
                }
                else {
                    while (b && index < length && this.text.charAt(index) == ' ') {
                        ++index;
                    }
                }
            }
            else {
                while (b && index > 0 && this.text.charAt(index - 1) == ' ') {
                    --index;
                }
                while (index > 0 && this.text.charAt(index - 1) != ' ') {
                    --index;
                }
            }
        }
        return index;
    }
    
    public void moveCursorBy(final int n) {
        this.setCursorPosition(this.selectionEnd + n);
    }
    
    public void setCursorPosition(final int cursorPosition) {
        this.cursorPosition = cursorPosition;
        this.setSelectionPos(this.cursorPosition = MathHelper.func_76125_a(this.cursorPosition, 0, this.text.length()));
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public boolean textboxKeyTyped(final char c, final int n) {
        if (!this.isFocused) {
            return false;
        }
        if (GuiScreen.func_175278_g(n)) {
            this.setCursorPositionEnd();
            this.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.func_175280_f(n)) {
            GuiScreen.func_146275_d(this.getSelectedText());
            return true;
        }
        if (GuiScreen.func_175279_e(n)) {
            if (this.isEnabled) {
                this.writeText(GuiScreen.func_146277_j());
            }
            return true;
        }
        if (GuiScreen.func_175277_d(n)) {
            GuiScreen.func_146275_d(this.getSelectedText());
            if (this.isEnabled) {
                this.writeText("");
            }
            return true;
        }
        switch (n) {
            case 14: {
                if (GuiScreen.func_146271_m()) {
                    if (this.isEnabled) {
                        this.deleteWords(-1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.func_146272_n()) {
                    this.setSelectionPos(0);
                }
                else {
                    this.setCursorPositionZero();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.func_146272_n()) {
                    if (GuiScreen.func_146271_m()) {
                        this.setSelectionPos(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() - 1);
                    }
                }
                else if (GuiScreen.func_146271_m()) {
                    this.setCursorPosition(this.getNthWordFromCursor(-1));
                }
                else {
                    this.moveCursorBy(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.func_146272_n()) {
                    if (GuiScreen.func_146271_m()) {
                        this.setSelectionPos(this.getNthWordFromPos(1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() + 1);
                    }
                }
                else if (GuiScreen.func_146271_m()) {
                    this.setCursorPosition(this.getNthWordFromCursor(1));
                }
                else {
                    this.moveCursorBy(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.func_146272_n()) {
                    this.setSelectionPos(this.text.length());
                }
                else {
                    this.setCursorPositionEnd();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.func_146271_m()) {
                    if (this.isEnabled) {
                        this.deleteWords(1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(1);
                }
                return true;
            }
            default: {
                if (ChatAllowedCharacters.func_71566_a(c)) {
                    if (this.isEnabled) {
                        this.writeText(Character.toString(c));
                    }
                    return true;
                }
                return false;
            }
        }
    }
    
    public void mouseClicked(final int n, final int n2, final int n3) {
        final boolean focused = n >= this.xPosition && n < this.xPosition + this.width && n2 >= this.yPosition && n2 < this.yPosition + this.height;
        if (this.canLoseFocus) {
            this.setFocused(focused);
        }
        if (this.isFocused && focused && n3 == 0) {
            int n4 = n - this.xPosition;
            if (this.enableBackgroundDrawing) {
                n4 -= 4;
            }
            this.setCursorPosition(this.fontRendererInstance.func_78269_a(this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), this.getWidth()), n4).length() + this.lineScrollOffset);
        }
    }
    
    public void drawTextBox() {
        if (this.getVisible()) {
            if (this.getEnableBackgroundDrawing()) {
                Class284.drawRoundedRect(this.xPosition - 1, this.yPosition - 1, this.xPosition + this.width + 1, this.yPosition + this.height + 1, 5.0f, new Color(Class59.WHITE.c).darker().getRGB());
            }
            final int color = this.isEnabled ? this.enabledColor : this.disabledColor;
            final int n = this.cursorPosition - this.lineScrollOffset;
            int length = this.selectionEnd - this.lineScrollOffset;
            final String func_78269_a = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), this.getWidth());
            final boolean b = n >= 0 && n <= func_78269_a.length();
            final boolean b2 = this.isFocused && this.cursorCounter / 6 % 2 == 0 && b;
            final int n2 = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
            final int n3 = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
            int func_175063_a = n2;
            if (length > func_78269_a.length()) {
                length = func_78269_a.length();
            }
            if (func_78269_a.length() > 0) {
                func_175063_a = this.fontRendererInstance.func_175063_a(b ? func_78269_a.substring(0, n) : func_78269_a, (float)n2, (float)n3, color);
            }
            final boolean b3 = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int n4 = func_175063_a;
            if (!b) {
                n4 = ((n > 0) ? (n2 + this.width) : n2);
            }
            else if (b3) {
                n4 = func_175063_a - 1;
                --func_175063_a;
            }
            if (func_78269_a.length() > 0 && b && n < func_78269_a.length()) {
                this.fontRendererInstance.func_175063_a(func_78269_a.substring(n), (float)func_175063_a, (float)n3, color);
            }
            if (b2) {
                if (b3) {
                    Gui.func_73734_a(n4, n3 - 1, n4 + 1, n3 + 1 + this.fontRendererInstance.field_78288_b, -3092272);
                }
                else {
                    Hanabi.INSTANCE.fontManager.comfortaa15.func_175063_a("_", n4, n3, color);
                }
            }
            if (length != n) {
                this.drawCursorVertical(n4, n3 - 1, n2 + this.fontRendererInstance.func_78256_a(func_78269_a.substring(0, length)) - 1, n3 + 1 + this.fontRendererInstance.field_78288_b);
            }
        }
    }
    
    public void drawCursorVertical(int n, int n2, int n3, int n4) {
        if (n < n3) {
            final int n5 = n;
            n = n3;
            n3 = n5;
        }
        if (n2 < n4) {
            final int n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        if (n3 > this.xPosition + this.width) {
            n3 = this.xPosition + this.width;
        }
        if (n > this.xPosition + this.width) {
            n = this.xPosition + this.width;
        }
        final Tessellator func_178181_a = Tessellator.func_178181_a();
        final WorldRenderer func_178180_c = func_178181_a.func_178180_c();
        GlStateManager.func_179131_c(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.func_179090_x();
        GlStateManager.func_179115_u();
        GlStateManager.func_179116_f(5387);
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n, (double)n4, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n3, (double)n4, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n3, (double)n2, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n, (double)n2, 0.0).func_181675_d();
        func_178181_a.func_78381_a();
        GlStateManager.func_179134_v();
        GlStateManager.func_179098_w();
    }
    
    public void setMaxStringLength(final int maxStringLength) {
        this.maxStringLength = maxStringLength;
        if (this.text.length() > maxStringLength) {
            this.text = this.text.substring(0, maxStringLength);
        }
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public void setEnableBackgroundDrawing(final boolean enableBackgroundDrawing) {
        this.enableBackgroundDrawing = enableBackgroundDrawing;
    }
    
    public void setTextColor(final int enabledColor) {
        this.enabledColor = enabledColor;
    }
    
    public void setDisabledTextColour(final int disabledColor) {
        this.disabledColor = disabledColor;
    }
    
    public void setFocused(final boolean isFocused) {
        if (isFocused && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = isFocused;
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public void setEnabled(final boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public void setSelectionPos(int selectionEnd) {
        final int length = this.text.length();
        if (selectionEnd > length) {
            selectionEnd = length;
        }
        if (selectionEnd < 0) {
            selectionEnd = 0;
        }
        this.selectionEnd = selectionEnd;
        if (this.fontRendererInstance != null) {
            if (this.lineScrollOffset > length) {
                this.lineScrollOffset = length;
            }
            final int width = this.getWidth();
            final int n = this.fontRendererInstance.func_78269_a(this.text.substring(this.lineScrollOffset), width).length() + this.lineScrollOffset;
            if (selectionEnd == this.lineScrollOffset) {
                this.lineScrollOffset -= this.fontRendererInstance.func_78262_a(this.text, width, true).length();
            }
            if (selectionEnd > n) {
                this.lineScrollOffset += selectionEnd - n;
            }
            else if (selectionEnd <= this.lineScrollOffset) {
                this.lineScrollOffset -= this.lineScrollOffset - selectionEnd;
            }
            this.lineScrollOffset = MathHelper.func_76125_a(this.lineScrollOffset, 0, length);
        }
    }
    
    public void setCanLoseFocus(final boolean canLoseFocus) {
        this.canLoseFocus = canLoseFocus;
    }
    
    public boolean getVisible() {
        return this.visible;
    }
    
    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
}
