package cn.Hanabi.modules.Render;

import cn.Hanabi.events.*;
import cn.Hanabi.modules.*;
import ClassSub.*;
import cn.Hanabi.modules.Player.*;
import net.minecraft.client.gui.*;
import java.util.*;
import com.darkmagician6.eventapi.*;

public class 乐杰客户�? extends Mod
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public 乐杰客户�?() {
        super("乐杰客户�?", Category.RENDER);
    }
    
    @EventTarget
    public void onRender(final EventRender2D eventRender2D) {
        final FontRenderer fontRendererObj = 乐杰客户�?.mc.fontRendererObj;
        final ScaledResolution scaledResolution = new ScaledResolution(乐杰客户�?.mc);
        fontRendererObj.drawString("乐杰我爱你❤", 5, 5, 16777215);
        final ArrayList<Mod> list = new ArrayList<Mod>(ModManager.modules);
        list.sort(this::lambda$onRender$0);
        int n = 0;
        for (final Mod mod : list) {
            if (mod.getState()) {
                final String chinese = this.getChinese(mod.getName());
                fontRendererObj.drawString(chinese, scaledResolution.getScaledWidth() - fontRendererObj.getStringWidth(chinese), n * fontRendererObj.FONT_HEIGHT, 16777215);
                ++n;
            }
        }
        Class120.INSTANCE.drawNotifications();
        Class344.INSTANCE.renderOverlay();
        if (ModManager.getModule("StaffAnalyzer").isEnabled() && StaffAnalyzer.ui != null) {
            StaffAnalyzer.ui.draw();
        }
    }
    
    public String getChinese(final String s) {
        switch (s) {
            case "AutoSword": {
                return "自动�?";
            }
            case "Criticals": {
                return "暴击";
            }
            case "KillAura": {
                return "�?妈光�?";
            }
            case "Velocity": {
                return "无击�?";
            }
            case "Scaffold": {
                return "自动搭路";
            }
            case "Fly": {
                return "飞行";
            }
            case "NoSlow": {
                return "无减�?";
            }
            case "Speed": {
                return "加�??";
            }
            case "Sprint": {
                return "强制疾跑";
            }
            case "Strafe": {
                return "灵活运动";
            }
            case "AutoArmor": {
                return "自动装备";
            }
            case "ChestStealer": {
                return "自动偷箱";
            }
            case "Nucker": {
                return "自动挖床";
            }
            case "InvMove": {
                return "背包移动";
            }
            case "StaffAnalyzer": {
                return "客服分析";
            }
            case "NoFall": {
                return "无掉落伤�?";
            }
            case "TP2Bed": {
                return "传�?�床";
            }
            case "BedESP": {
                return "床�?�视";
            }
            case "Chams": {
                return "人物上色";
            }
            case "ChestESP": {
                return "箱子透视";
            }
            case "ESP": {
                return "人物透视";
            }
            case "Fullbright": {
                return "夜视";
            }
            case "HitAnimation": {
                return "格挡动画";
            }
            case "Nametags": {
                return "命名�?";
            }
            case "Projectiles": {
                return "投掷物预�?";
            }
            case "AntiBot": {
                return "反假�?";
            }
            case "AntiFall": {
                return "防止掉落";
            }
            case "AutoL": {
                return "自动扣L";
            }
            case "IRC": {
                return "跨服聊天";
            }
            case "PacketMotior": {
                return "发包监视�?";
            }
            case "SpeedMine": {
                return "快�?�挖�?";
            }
            case "Teams": {
                return "组队判断";
            }
            case "Hitbox": {
                return "增大碰撞�?";
            }
            case "Reach": {
                return "长臂�?";
            }
            default: {
                return s;
            }
        }
    }
    
    private int lambda$onRender$0(final FontRenderer fontRenderer, final Mod mod, final Mod mod2) {
        return fontRenderer.getStringWidth(this.getChinese(mod2.getName())) - fontRenderer.getStringWidth(this.getChinese(mod.getName()));
    }
}
