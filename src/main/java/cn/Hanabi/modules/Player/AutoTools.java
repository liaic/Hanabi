package cn.Hanabi.modules.Player;

import cn.Hanabi.modules.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.network.play.client.*;
import net.minecraft.world.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class AutoTools extends Mod
{
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public AutoTools() {
        super("AutoTools", Category.PLAYER);
    }
    
    public Entity getItems(final double n) {
        Entity entity = null;
        double n2 = n;
        for (final Entity entity2 : AutoTools.mc.field_71441_e.field_72996_f) {
            if (AutoTools.mc.field_71439_g.field_70122_E && AutoTools.mc.field_71439_g.field_70124_G && entity2 instanceof EntityItem) {
                final double n3 = (double)AutoTools.mc.field_71439_g.func_70032_d(entity2);
                if (n3 > n2) {
                    continue;
                }
                n2 = n3;
                entity = entity2;
            }
        }
        return entity;
    }
    
    @EventTarget
    public void onAttack(final EventPacket eventPacket) {
        if (eventPacket.getPacket() instanceof C02PacketUseEntity && ((C02PacketUseEntity)eventPacket.getPacket()).func_149565_c().equals((Object)C02PacketUseEntity.Action.ATTACK) && !AutoTools.mc.field_71439_g.func_70113_ah()) {
            this.bestSword(((C02PacketUseEntity)eventPacket.getPacket()).func_149564_a((World)AutoTools.mc.field_71441_e));
        }
    }
    
    @EventTarget
    public void onClickBlock(final EventPostMotion eventPostMotion) {
        if (!AutoTools.mc.field_71439_g.func_70113_ah() && AutoTools.mc.field_71442_b.func_181040_m() && !Objects.isNull(AutoTools.mc.field_71476_x.func_178782_a())) {
            this.bestTool(AutoTools.mc.field_71476_x.func_178782_a().func_177958_n(), AutoTools.mc.field_71476_x.func_178782_a().func_177956_o(), AutoTools.mc.field_71476_x.func_178782_a().func_177952_p());
        }
    }
    
    public void bestSword(final Entity entity) {
        int field_70461_c = 0;
        float func_150931_i = -1.0f;
        for (int i = 36; i < 45; ++i) {
            if (((Object[])AutoTools.mc.field_71439_g.field_71069_bz.field_75151_b.toArray())[i] != null && entity != null) {
                final ItemStack func_75211_c = AutoTools.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                if (func_75211_c != null && func_75211_c.func_77973_b() instanceof ItemSword) {
                    final ItemSword itemSword = (ItemSword)func_75211_c.func_77973_b();
                    if (itemSword.func_150931_i() > func_150931_i) {
                        field_70461_c = i - 36;
                        func_150931_i = itemSword.func_150931_i();
                    }
                }
            }
        }
        if (func_150931_i > -1.0f) {
            AutoTools.mc.field_71439_g.field_71071_by.field_70461_c = field_70461_c;
            AutoTools.mc.field_71442_b.func_78765_e();
        }
    }
    
    public void bestTool(final int n, final int n2, final int n3) {
        final int func_149682_b = Block.func_149682_b(AutoTools.mc.field_71441_e.func_180495_p(new BlockPos(n, n2, n3)).func_177230_c());
        int field_70461_c = 0;
        float func_150997_a = -1.0f;
        for (int i = 36; i < 45; ++i) {
            try {
                final ItemStack func_75211_c = AutoTools.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                if ((func_75211_c.func_77973_b() instanceof ItemTool || func_75211_c.func_77973_b() instanceof ItemSword || func_75211_c.func_77973_b() instanceof ItemShears) && func_75211_c.func_150997_a(Block.func_149729_e(func_149682_b)) > func_150997_a) {
                    field_70461_c = i - 36;
                    func_150997_a = func_75211_c.func_150997_a(Block.func_149729_e(func_149682_b));
                }
            }
            catch (Exception ex) {}
        }
        if (func_150997_a != -1.0f) {
            AutoTools.mc.field_71439_g.field_71071_by.field_70461_c = field_70461_c;
            AutoTools.mc.field_71442_b.func_78765_e();
        }
    }
}
