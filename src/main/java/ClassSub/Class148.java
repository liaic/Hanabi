package ClassSub;

import cn.Hanabi.*;
import java.util.*;
import java.awt.*;
import cn.Hanabi.utils.fontmanager.*;
import javafx.scene.media.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.input.*;
import java.io.*;
import net.minecraft.client.gui.*;

public class Class148 extends GuiScreen
{
    public ArrayList<Class146> allTracks;
    public int x;
    public int y;
    public int x2;
    public int y2;
    public int windowWidth;
    public int windowHeight;
    public boolean drag;
    public Class118 songListID;
    public Class118 trackSearch;
    private Class38 handler;
    public ArrayList<Class9> trackSlots;
    public int wheelStateTrack;
    public static double wheelSmoothTrack;
    public static double wheelSmoothValue;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class148(final int x, final int y, final int windowWidth, final int windowHeight) {
        super();
        this.drag = false;
        this.handler = new Class38(0);
        this.trackSlots = new ArrayList<Class9>();
        this.x = x;
        this.y = y;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }
    
    public void func_73866_w_() {
        this.allTracks = Hanabi.INSTANCE.musicMgr.allTracks;
        if (!this.trackSlots.isEmpty()) {
            this.trackSlots.clear();
        }
        if (!this.allTracks.isEmpty()) {
            final Iterator<Class146> iterator = this.allTracks.iterator();
            while (iterator.hasNext()) {
                this.trackSlots.add(new Class9((Class146)iterator.next(), this.windowWidth, this.windowHeight));
            }
        }
        this.songListID = new Class118(0, this.field_146289_q, 2, 2, this.windowWidth - 8, 10);
        this.trackSearch = new Class118(1, this.field_146289_q, 2, 2, this.windowWidth - 8, 10);
        super.func_73866_w_();
    }
    
    public void func_73863_a(final int n, final int n2, final float n3) {
        Class284.drawRoundedRect(this.x - 1, this.y - 15, this.x + this.windowWidth + 1, this.y + this.windowHeight + 1, 6.0f, new Color(-14848033).brighter().getRGB());
        Class284.drawRoundedRect(this.x, this.y, this.x + this.windowWidth, this.y + this.windowHeight, 6.0f, -15000805);
        Class284.drawRoundedRect(this.x + 2, this.y + 50, this.x + this.windowWidth - 2, this.y + this.windowHeight - 2, 6.0f, Class59.BLACK.c);
        Hanabi.INSTANCE.fontManager.comfortaa15.drawString("Netease Music Player", this.x + 5.0f, this.y - 12, Class59.WHITE.c);
        Class284.circle(this.x + this.windowWidth - 10, this.y - 7, 3.0f, Class59.RED.c);
        if (this.isHovering(n, n2, this.x + this.windowWidth - 14, this.y - 11, this.x + this.windowWidth - 6, this.y - 3) && this.handler.canExcecute()) {
            this.field_146297_k.func_147108_a((GuiScreen)null);
        }
        Class284.drawRoundedRect(this.x + 140, this.y + 30, this.x + 157, this.y + 46, 2.0f, Class59.GREY.c);
        Hanabi.INSTANCE.fontManager.icon25.drawString(HanabiFonts.ICON_PLAYER_REPEAT, this.x + 142.0f, this.y + 32, -1);
        Class284.circle(this.x + 152, this.y + 42, 2.0f, Class108.getInstance().isLoop ? Class59.GREEN.c : Class59.RED.c);
        if (this.isHovering(n, n2, this.x + 140, this.y + 30, this.x + 157, this.y + 46) && this.handler.canExcecute()) {
            Class108.getInstance().isLoop = !Class108.getInstance().isLoop;
            Class295.tellPlayer(EnumChatFormatting.GOLD + "[MusicPlayer] " + EnumChatFormatting.GRAY + "重新播放歌曲后生效.");
        }
        if (this.isHovering(n, n2, this.x + 58, this.y + 29, this.x + 75, this.y + 46) && this.handler.canExcecute()) {
            if (Class108.getInstance().getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                Class108.getInstance().getMediaPlayer().pause();
            }
            else {
                Class108.getInstance().getMediaPlayer().play();
            }
        }
        Class284.circle(this.x + 170, this.y + 38, 8.0f, Class59.GREY.c);
        Hanabi.INSTANCE.fontManager.comfortaa16.drawString(Class108.lyricCoding ? "G" : "U", this.x + 166.5f, this.y + 34, -1);
        if (this.isHovering(n, n2, this.x + 162, this.y + 29, this.x + 178, this.y + 46) && this.handler.canExcecute()) {
            Class108.lyricCoding = !Class108.lyricCoding;
            Class295.tellPlayer(EnumChatFormatting.GOLD + "[MusicPlayer] " + EnumChatFormatting.GRAY + "当前编码为 " + (Class108.lyricCoding ? "GBK" : "UTF-8") + ", 请重新播放歌曲以生效.");
        }
        this.songListID.xPosition = this.x + 4;
        this.songListID.yPosition = this.y + 52;
        this.songListID.width = 90;
        this.songListID.drawTextBox();
        if (this.songListID.getText().isEmpty()) {
            Hanabi.INSTANCE.fontManager.wqy18.drawString("歌单ID", this.x + 8.0f, this.y + 52, Class59.WHITE.c);
        }
        this.trackSearch.xPosition = this.x + 106;
        this.trackSearch.yPosition = this.y + 52;
        this.trackSearch.width = 90;
        this.trackSearch.drawTextBox();
        if (this.trackSearch.getText().isEmpty()) {
            Hanabi.INSTANCE.fontManager.wqy18.drawString("歌单内搜索", this.x + 108.0f, this.y + 52, Class59.WHITE.c);
        }
        if (Hanabi.INSTANCE.musicMgr.getCurrentTrack() != null && Class108.getInstance().getMediaPlayer() != null) {
            final Class146 currentTrack = Hanabi.INSTANCE.musicMgr.getCurrentTrack();
            Class284.drawRoundedRect(this.x + 100, this.y + 30, this.x + 115, this.y + 46, 2.0f, Class59.GREY.c);
            Hanabi.INSTANCE.fontManager.comfortaa20.drawString("-", this.x + 105.0f, this.y + 33, -1);
            if (this.isHovering(n, n2, this.x + 100, this.y + 30, this.x + 115, this.y + 46) && this.handler.canExcecute()) {
                Class108.getInstance().getMediaPlayer().setVolume(Math.max(0.1, Class108.getInstance().getMediaPlayer().getVolume() - 0.1));
                Class108.getInstance().setVolume(Class108.getInstance().getMediaPlayer().getVolume());
            }
            Class284.drawRoundedRect(this.x + 120, this.y + 30, this.x + 135, this.y + 46, 2.0f, Class59.GREY.c);
            Hanabi.INSTANCE.fontManager.comfortaa20.drawString("+", this.x + 125.0f, this.y + 33, -1);
            if (this.isHovering(n, n2, this.x + 120, this.y + 30, this.x + 135, this.y + 46) && this.handler.canExcecute()) {
                Class108.getInstance().getMediaPlayer().setVolume(Math.max(0.1, Class108.getInstance().getMediaPlayer().getVolume() + 0.1));
                Class108.getInstance().setVolume(Class108.getInstance().getMediaPlayer().getVolume());
            }
            Class284.circle(this.x + 67, this.y + 38, 8.0f, Class59.GREY.c);
            if (Class108.getInstance().getMediaPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                Hanabi.INSTANCE.fontManager.icon40.drawString(HanabiFonts.ICON_PLAYER_PAUSE, this.x + 57.0f, this.y + 28, -1);
            }
            else {
                Hanabi.INSTANCE.fontManager.icon40.drawString(HanabiFonts.ICON_PLAYER_PLAY, this.x + 57.0f, this.y + 28, -1);
            }
            Class284.circle(this.x + 87, this.y + 38, 8.0f, Class59.GREY.c);
            Hanabi.INSTANCE.fontManager.icon20.drawString(HanabiFonts.ICON_PLAYER_NEXT, this.x + 82.0f, this.y + 33, -1);
            if (this.isHovering(n, n2, this.x + 78, this.y + 29, this.x + 95, this.y + 46) && this.handler.canExcecute()) {
                Class108.getInstance().next();
            }
            if (Class108.getInstance().circleLocations.containsKey(Hanabi.INSTANCE.musicMgr.getCurrentTrack().getId())) {
                GL11.glPushMatrix();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                Minecraft.func_71410_x().func_175598_ae().field_78724_e.func_110577_a((ResourceLocation)Hanabi.INSTANCE.musicMgr.circleLocations.get(Hanabi.INSTANCE.musicMgr.getCurrentTrack().getId()));
                this.drawScaledTexturedModalRect(this.x + 9, this.y + 4, 0.0, 0.0, 42.0, 42.0, 6.1f);
                GL11.glPopMatrix();
            }
            else {
                Class108.getInstance().getCircle(Hanabi.INSTANCE.musicMgr.getCurrentTrack());
            }
            Class284.drawArc(this.x + 30, this.y + 25, 21.0, Class59.WHITE.c, 0, 360.0, 4);
            try {
                Class284.drawArc(this.x + 30, this.y + 25, 21.0, Class59.BLUE.c, 180, 180.0f + (float)(Class108.getInstance().getMediaPlayer().getCurrentTime().toSeconds() / Math.max(1.0, Class108.getInstance().getMediaPlayer().getStopTime().toSeconds())) * 100.0f * 3.6f, 4);
            }
            catch (Exception ex) {}
            GL11.glPushMatrix();
            GL11.glEnable(3089);
            Class284.doGlScissor(this.x + 60, this.y + 6, this.windowWidth - 64, 25);
            Hanabi.INSTANCE.fontManager.wqy18.drawString(currentTrack.getName(), this.x + 60.0f, this.y + 6, Class59.WHITE.c);
            Hanabi.INSTANCE.fontManager.wqy18.drawString(currentTrack.getArtists(), this.x + 60.0f, this.y + 17, Class59.WHITE.c);
            GL11.glDisable(3089);
            GL11.glPopMatrix();
        }
        else {
            Class284.circle(this.x + 30, this.y + 25, 20.0f, -1);
            Hanabi.INSTANCE.fontManager.wqy18.drawString("未播放任何歌曲", this.x + 55.0f, this.y + 6, Class59.WHITE.c);
        }
        if (Class108.getInstance().loadingThread != null) {
            if (Class287.INSTANCE.downloadProgress != "") {
                Class284.drawArc(this.x + 30, this.y + 25, 21.0, Class59.AQUA.c, 180, 180.0f + Integer.valueOf(Class287.INSTANCE.downloadProgress) * 3.6f, 4);
            }
            else {
                Class284.drawArc(this.x + 30, this.y + 25, 21.0, Class59.AQUA.c, 180, 180.0, 4);
            }
        }
        Class148.wheelSmoothTrack = Class284.getAnimationState(Class148.wheelSmoothTrack, this.wheelStateTrack * 30, 1000.0);
        int n4 = (int)(this.y + Class148.wheelSmoothTrack) + 40 + 25;
        int n5 = 1;
        GL11.glPushMatrix();
        Class284.doGlScissor(this.x + 4, this.y + 65, this.windowWidth - 8, this.windowHeight - 68);
        GL11.glEnable(3089);
        if (!this.trackSlots.isEmpty() && this.trackSlots != null) {
            for (int i = 0; i < this.trackSlots.size(); ++i) {
                final Class9 class9 = (Class9)this.trackSlots.get(i);
                if (this.trackSearch.getText().isEmpty() || class9.thisTrack.getName().toLowerCase().indexOf(this.trackSearch.getText().toLowerCase()) != -1) {
                    if (n4 < this.y + this.windowHeight - 10 && n4 > this.y + 50) {
                        class9.draw(this.x + 4, n4);
                        Hanabi.INSTANCE.fontManager.comfortaa18.drawString(String.valueOf(n5), this.x + 8.0f, n4 + 3, -1);
                        if (this.isHovering(n, n2, this.x + 2, this.y + 65, this.x + this.windowWidth - 2, this.y + 65 + this.windowHeight - 68)) {
                            class9.onClick(n, n2, this.x, n4);
                        }
                    }
                    ++n5;
                    n4 += 16;
                }
            }
        }
        GL11.glDisable(3089);
        GL11.glPopMatrix();
        this.processScroll(n, n2);
        this.moveWindow(n, n2);
        super.func_73863_a(n, n2, n3);
    }
    
    public void drawScaledTexturedModalRect(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final float n7) {
        final float n8 = 0.00390625f * n7;
        final float n9 = 0.00390625f * n7;
        final Tessellator func_178181_a = Tessellator.func_178181_a();
        final WorldRenderer func_178180_c = func_178181_a.func_178180_c();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        func_178180_c.func_181662_b(n + 0.0, n2 + n6, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + 0.0) * n8), (double)((float)(n4 + n6) * n9)).func_181675_d();
        func_178180_c.func_181662_b(n + n5, n2 + n6, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + n5) * n8), (double)((float)(n4 + n6) * n9)).func_181675_d();
        func_178180_c.func_181662_b(n + n5, n2 + 0.0, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + n5) * n8), (double)((float)(n4 + 0.0) * n9)).func_181675_d();
        func_178180_c.func_181662_b(n + 0.0, n2 + 0.0, (double)this.field_73735_i).func_181673_a((double)((float)(n3 + 0.0) * n8), (double)((float)(n4 + 0.0) * n9)).func_181675_d();
        func_178181_a.func_78381_a();
    }
    
    public void processScroll(final int n, final int n2) {
        final int dWheel = Mouse.getDWheel();
        if (this.isHovering(n, n2, this.x + 2, this.y + 65, this.x + this.windowWidth - 2, this.y + 65 + this.windowHeight - 68)) {
            if (dWheel > 0) {
                if (this.wheelStateTrack < 0) {
                    ++this.wheelStateTrack;
                }
            }
            else if (dWheel < 0 && this.wheelStateTrack * 30 > this.trackSlots.size() * -15.8f) {
                --this.wheelStateTrack;
            }
        }
    }
    
    public void moveWindow(final int n, final int n2) {
        if (this.isHoveringWindow(n, n2) && this.handler.canExcecute()) {
            this.drag = true;
            this.x2 = n - this.x;
            this.y2 = n2 - this.y;
        }
        if (this.drag) {
            this.x = n - this.x2;
            this.y = n2 - this.y2;
        }
        if (!Mouse.isButtonDown(0)) {
            this.drag = false;
        }
    }
    
    private boolean isHoveringWindow(final int n, final int n2) {
        return n >= this.x && n <= this.x + this.windowWidth && n2 >= this.y - 10 && n2 <= this.y - 1;
    }
    
    private boolean isHovering(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
    
    protected void func_73864_a(final int n, final int n2, final int n3) throws IOException {
        this.songListID.mouseClicked(n, n2, n3);
        this.trackSearch.mouseClicked(n, n2, n3);
        super.func_73864_a(n, n2, n3);
    }
    
    protected void func_73869_a(final char c, final int n) throws IOException {
        switch (n) {
            case 28: {
                if (this.songListID.isFocused && !this.songListID.getText().isEmpty()) {
                    Hanabi.INSTANCE.musicMgr.allTracks = Class194.INSTANCE.getSongs(this.songListID.getText());
                    this.allTracks = Hanabi.INSTANCE.musicMgr.allTracks;
                    if (!this.trackSlots.isEmpty()) {
                        this.trackSlots.clear();
                    }
                    if (!this.allTracks.isEmpty()) {
                        final Iterator<Class146> iterator = this.allTracks.iterator();
                        while (iterator.hasNext()) {
                            this.trackSlots.add(new Class9((Class146)iterator.next(), this.windowWidth, this.windowHeight));
                        }
                    }
                    this.wheelStateTrack = 0;
                    this.songListID.setText("");
                    break;
                }
                break;
            }
        }
        this.songListID.textboxKeyTyped(c, n);
        this.trackSearch.textboxKeyTyped(c, n);
        super.func_73869_a(c, n);
    }
    
    protected void func_146284_a(final GuiButton guiButton) throws IOException {
        super.func_146284_a(guiButton);
    }
    
    public void func_73876_c() {
        super.func_73876_c();
    }
    
    public void func_146281_b() {
        super.func_146281_b();
    }
    
    public boolean func_73868_f() {
        return false;
    }
}
