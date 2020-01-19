package cn.Hanabi.modules.Render;

import cn.Hanabi.events.*;
import cn.Hanabi.modules.*;
import ClassSub.*;
import cn.Hanabi.modules.Player.*;
import net.minecraft.client.gui.*;
import java.util.*;
import com.darkmagician6.eventapi.*;

public class 乐杰客户端 extends Mod
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public 乐杰客户端() {
        super("乐杰客户端", Category.RENDER);
    }
    
    @EventTarget
    public void onRender(final EventRender2D eventRender2D) {
        final FontRenderer field_71466_p = 乐杰客户端.mc.field_71466_p;
        final ScaledResolution scaledResolution = new ScaledResolution(乐杰客户端.mc);
        field_71466_p.func_78276_b("乐杰我爱你❤", 5, 5, 16777215);
        final ArrayList<Mod> list = new ArrayList<Mod>(ModManager.modules);
        list.sort(this::lambda$onRender$0);
        int n = 0;
        for (final Mod mod : list) {
            if (mod.getState()) {
                final String chinese = this.getChinese(mod.getName());
                field_71466_p.func_78276_b(chinese, scaledResolution.func_78326_a() - field_71466_p.func_78256_a(chinese), n * field_71466_p.field_78288_b, 16777215);
                ++n;
            }
        }
        Class128.INSTANCE.drawNotifications();
        Class287.INSTANCE.renderOverlay();
        if (ModManager.getModule("StaffAnalyzer").isEnabled() && StaffAnalyzer.ui != null) {
            StaffAnalyzer.ui.draw();
        }
    }
    
    public String getChinese(final String s) {
        int n = -1;
        switch (s.hashCode()) {
            case -640688786: {
                if (s.equals("AutoSword")) {
                    n = 0;
                    break;
                }
                break;
            }
            case -1903846252: {
                if (s.equals("Criticals")) {
                    n = 1;
                    break;
                }
                break;
            }
            case -540863999: {
                if (s.equals("KillAura")) {
                    n = 2;
                    break;
                }
                break;
            }
            case -2096062211: {
                if (s.equals("Velocity")) {
                    n = 3;
                    break;
                }
                break;
            }
            case -832703466: {
                if (s.equals("Scaffold")) {
                    n = 4;
                    break;
                }
                break;
            }
            case 70739: {
                if (s.equals("Fly")) {
                    n = 5;
                    break;
                }
                break;
            }
            case -1956802686: {
                if (s.equals("NoSlow")) {
                    n = 6;
                    break;
                }
                break;
            }
            case 80089127: {
                if (s.equals("Speed")) {
                    n = 7;
                    break;
                }
                break;
            }
            case -1811812806: {
                if (s.equals("Sprint")) {
                    n = 8;
                    break;
                }
                break;
            }
            case -1808126673: {
                if (s.equals("Strafe")) {
                    n = 9;
                    break;
                }
                break;
            }
            case -657463120: {
                if (s.equals("AutoArmor")) {
                    n = 10;
                    break;
                }
                break;
            }
            case -2139416549: {
                if (s.equals("ChestStealer")) {
                    n = 11;
                    break;
                }
                break;
            }
            case -1950786180: {
                if (s.equals("Nucker")) {
                    n = 12;
                    break;
                }
                break;
            }
            case -671121598: {
                if (s.equals("InvMove")) {
                    n = 13;
                    break;
                }
                break;
            }
            case 1794360198: {
                if (s.equals("StaffAnalyzer")) {
                    n = 14;
                    break;
                }
                break;
            }
            case -1957200644: {
                if (s.equals("NoFall")) {
                    n = 15;
                    break;
                }
                break;
            }
            case -1814680725: {
                if (s.equals("TP2Bed")) {
                    n = 16;
                    break;
                }
                break;
            }
            case 1985847649: {
                if (s.equals("BedESP")) {
                    n = 17;
                    break;
                }
                break;
            }
            case 65070882: {
                if (s.equals("Chams")) {
                    n = 18;
                    break;
                }
                break;
            }
            case 1616551649: {
                if (s.equals("ChestESP")) {
                    n = 19;
                    break;
                }
                break;
            }
            case 68962: {
                if (s.equals("ESP")) {
                    n = 20;
                    break;
                }
                break;
            }
            case 1630422633: {
                if (s.equals("Fullbright")) {
                    n = 21;
                    break;
                }
                break;
            }
            case -1490529967: {
                if (s.equals("HitAnimation")) {
                    n = 22;
                    break;
                }
                break;
            }
            case 1906169156: {
                if (s.equals("Nametags")) {
                    n = 23;
                    break;
                }
                break;
            }
            case 728636298: {
                if (s.equals("Projectiles")) {
                    n = 24;
                    break;
                }
                break;
            }
            case 817727205: {
                if (s.equals("AntiBot")) {
                    n = 25;
                    break;
                }
                break;
            }
            case -420154851: {
                if (s.equals("AntiFall")) {
                    n = 26;
                    break;
                }
                break;
            }
            case 63629405: {
                if (s.equals("AutoL")) {
                    n = 27;
                    break;
                }
                break;
            }
            case 72762: {
                if (s.equals("IRC")) {
                    n = 28;
                    break;
                }
                break;
            }
            case -1056061822: {
                if (s.equals("PacketMotior")) {
                    n = 29;
                    break;
                }
                break;
            }
            case 361250074: {
                if (s.equals("SpeedMine")) {
                    n = 30;
                    break;
                }
                break;
            }
            case 80681366: {
                if (s.equals("Teams")) {
                    n = 31;
                    break;
                }
                break;
            }
            case -2133145224: {
                if (s.equals("Hitbox")) {
                    n = 32;
                    break;
                }
                break;
            }
            case 78834003: {
                if (s.equals("Reach")) {
                    n = 33;
                    break;
                }
                break;
            }
        }
        switch (n) {
            case 0: {
                return "自动剑";
            }
            case 1: {
                return "暴击";
            }
            case 2: {
                return "杀妈光环";
            }
            case 3: {
                return "无击退";
            }
            case 4: {
                return "自动搭路";
            }
            case 5: {
                return "飞行";
            }
            case 6: {
                return "无减速";
            }
            case 7: {
                return "加速";
            }
            case 8: {
                return "强制疾跑";
            }
            case 9: {
                return "灵活运动";
            }
            case 10: {
                return "自动装备";
            }
            case 11: {
                return "自动偷箱";
            }
            case 12: {
                return "自动挖床";
            }
            case 13: {
                return "背包移动";
            }
            case 14: {
                return "客服分析";
            }
            case 15: {
                return "无掉落伤害";
            }
            case 16: {
                return "传送床";
            }
            case 17: {
                return "床透视";
            }
            case 18: {
                return "人物上色";
            }
            case 19: {
                return "箱子透视";
            }
            case 20: {
                return "人物透视";
            }
            case 21: {
                return "夜视";
            }
            case 22: {
                return "格挡动画";
            }
            case 23: {
                return "命名牌";
            }
            case 24: {
                return "投掷物预判";
            }
            case 25: {
                return "反假人";
            }
            case 26: {
                return "防止掉落";
            }
            case 27: {
                return "自动扣L";
            }
            case 28: {
                return "跨服聊天";
            }
            case 29: {
                return "发包监视器";
            }
            case 30: {
                return "快速挖掘";
            }
            case 31: {
                return "组队判断";
            }
            case 32: {
                return "增大碰撞箱";
            }
            case 33: {
                return "长臂猿";
            }
            default: {
                return s;
            }
        }
    }
    
    private int lambda$onRender$0(final FontRenderer fontRenderer, final Mod mod, final Mod mod2) {
        return fontRenderer.func_78256_a(this.getChinese(mod2.getName())) - fontRenderer.func_78256_a(this.getChinese(mod.getName()));
    }
}
