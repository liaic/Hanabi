package cn.Hanabi;

import org.jetbrains.annotations.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.command.*;
import cn.Hanabi.utils.fontmanager.*;
import cn.Hanabi.hmlProject.*;
import java.text.*;
import java.lang.management.*;
import com.darkmagician6.eventapi.*;
import ClassSub.*;
import org.lwjgl.opengl.*;
import java.util.*;

public class Hanabi
{
    @NotNull
    public static final String CLIENT_NAME = "Hanabi";
    @NotNull
    public static final String CLIENT_AUTHOR = "Margele";
    public static final double CLIENT_VERSION_NUMBER = 1.4;
    @NotNull
    public static final String CLIENT_VERSION = "1.4.2";
    @NotNull
    public static final String CLIENT_INITIALS;
    public static Hanabi INSTANCE;
    public static boolean instance;
    public ModManager moduleManager;
    public CommandManager commandManager;
    public Class28 fileManager;
    public FontManager fontManager;
    public Class5 rotate;
    public boolean loadFont;
    public Class220 altFileMgr;
    public Class108 musicMgr;
    public Class78 sbm;
    public static int flag;
    public HMLManager hmlManager;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Hanabi() {
        super();
        this.loadFont = true;
        Hanabi.INSTANCE = this;
    }
    
    public void startClient() {
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            Hanabi.flag = simpleDateFormat.parse(Class296.fuckman).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        }
        catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (!((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\") || ((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].replace("l", "I").contains("\\lib\\")) {
            Hanabi.flag = -new Random().nextInt(20);
        }
        if (!Class296.c4n || !Class296.cr4ckm3 || !Class296.If || !Class296.y0u || !((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            Hanabi.flag = -new Random().nextInt(20);
        }
        final Iterator<Map.Entry<Object, Object>> iterator = System.getProperties().entrySet().iterator();
        while (iterator.hasNext()) {
            if (((Map.Entry<Object, Object>)iterator.next()).getKey().toString().contains("http.proxy")) {
                Hanabi.flag = -new Random().nextInt(20);
            }
        }
        Hanabi.instance = Class296.sendGet("https://alphaantileak.cn/hanabi/FUCKYOU/checkhwid.php?user=" + Class69.username + "&pass=" + Class69.password + "&hwid=" + Class296.crackme()).contains(Class296.encode(Class296.crackme()));
        (this.hmlManager = new HMLManager()).onClientStarted(this);
        if (!Hanabi.instance || !((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            System.exit(0);
        }
        if (Class296.c4n && ((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            this.fileManager = new Class28();
        }
        if (Class296.cr4ckm3 && ((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            this.commandManager = new CommandManager();
        }
        if (Class296.y0u && ((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            this.moduleManager = new ModManager();
        }
        if (Class296.If && ((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            this.fontManager = new FontManager();
        }
        this.fontManager.initFonts();
        EventManager.register((Object)(this.rotate = new Class5()));
        EventManager.register((Object)new Class34());
        this.commandManager.addCommands();
        if (Class296.c4n && Class296.cr4ckm3 && Class296.If && Class296.y0u && ((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
            this.moduleManager.addModules();
        }
        this.fileManager.load();
        (this.altFileMgr = new Class220()).loadFiles();
        this.musicMgr = new Class108();
        Class128.notifications.clear();
        Display.setTitle("Hanabi 1.4.2");
    }
    
    public void stopClient() {
        try {
            this.fileManager.save();
        }
        catch (Exception ex) {
            System.err.println("Failed to save settings:");
            ex.printStackTrace();
        }
    }
    
    static {
        final ArrayList<Character> list = new ArrayList<Character>();
        for (final char c : (char[])"Hanabi".toCharArray()) {
            if (Character.toUpperCase(c) == c) {
                list.add(c);
            }
        }
        final char[] array2 = new char[list.size()];
        for (int j = 0; j < list.size(); ++j) {
            array2[j] = (char)list.get(j);
        }
        CLIENT_INITIALS = new String(array2);
    }
}
