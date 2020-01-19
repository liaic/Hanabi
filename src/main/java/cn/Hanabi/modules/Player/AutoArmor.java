package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.gui.inventory.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import ClassSub.*;
import java.util.*;
import net.minecraft.enchantment.*;

public class AutoArmor extends Mod
{
    private Class191 timeHelper;
    public Class191 timer;
    public Class191 droptimer;
    private Value<Boolean> openInv;
    private Value<Double> delay;
    private Value inventoryKeepTimeVal;
    private Value insant;
    private ArrayList openList;
    private ArrayList closeList;
    public static boolean complete;
    private static boolean openedInventory;
    private int[] itemHelmet;
    private int[] itemChestplate;
    private int[] itemLeggings;
    private int[] itemBoots;
    private HashMap<ItemStack, Long> armorContains;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public AutoArmor() {
        super("AutoArmor", Category.PLAYER);
        this.timeHelper = new Class191();
        this.timer = new Class191();
        this.droptimer = new Class191();
        this.openInv = new Value<Boolean>("AutoArmor_SortInInv", true);
        this.delay = new Value<Double>("AutoArmor_Delay", 60.0, 0.0, 1000.0, 10.0);
        this.inventoryKeepTimeVal = new Value("AutoArmor_TimeInInv", (T)1000.0, (T)0.0, (T)10000.0, 100.0);
        this.insant = new Value("AutoArmor_Insant", (T)false);
        this.openList = new ArrayList();
        this.closeList = new ArrayList();
        this.itemHelmet = new int[] { 298, 302, 306, 310, 314 };
        this.itemChestplate = new int[] { 299, 303, 307, 311, 315 };
        this.itemLeggings = new int[] { 300, 304, 308, 312, 316 };
        this.armorContains = new HashMap<ItemStack, Long>();
        this.itemBoots = new int[] { 301, 305, 309, 313, 317 };
    }
    
    @EventTarget
    public void onEvent(final EventUpdate eventUpdate) {
        if (AutoArmor.mc.field_71439_g == null) {
            AutoArmor.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0DPacketCloseWindow(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c));
            return;
        }
        if (AutoArmor.mc.field_71462_r != null && !(AutoArmor.mc.field_71462_r instanceof GuiInventory)) {
            if (AutoArmor.openedInventory) {
                AutoArmor.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0DPacketCloseWindow(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c));
                AutoArmor.openedInventory = false;
            }
            return;
        }
        final boolean b = (this.openInv.getValueState() && AutoArmor.mc.field_71462_r != null && AutoArmor.mc.field_71462_r instanceof GuiInventory) || !(boolean)this.openInv.getValueState();
        boolean b2 = true;
        for (final String s : this.getArmors()) {
            b2 = false;
            final int slotByName = this.getSlotByName(s);
            int bestInInventory = this.getBestInInventory(s);
            boolean b3 = true;
            if (bestInInventory != -1) {
                b3 = (this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c()) > this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(slotByName).func_75211_c()));
            }
            if (b3 && bestInInventory != -1 && !this.armorContains.containsKey(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c())) {
                this.armorContains.put(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c(), System.currentTimeMillis());
            }
            if (b) {
                if (bestInInventory != -1 && AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(slotByName).func_75216_d() && this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c()) < this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(slotByName).func_75211_c())) {
                    bestInInventory = -1;
                }
                if (this.timer.isDelayComplete((long)(Object)this.delay.getValueState()) && bestInInventory != -1 && this.armorContains.containsKey(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c()) && System.currentTimeMillis() - this.armorContains.get(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c()) >= 200L) {
                    this.putOnItem(slotByName, bestInInventory);
                    this.armorContains.remove(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c());
                    this.timer.reset();
                }
                final Iterator<Integer> iterator2 = this.findArmor(s).iterator();
                while (iterator2.hasNext()) {
                    final int intValue = (int)iterator2.next();
                    int n = 0;
                    if (slotByName != -1) {
                        n = ((this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(slotByName).func_75211_c()) >= this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue).func_75211_c())) ? 1 : 0);
                    }
                    if (n != 0) {
                        b2 = false;
                        if (!this.droptimer.isDelayComplete(300L)) {
                            continue;
                        }
                        this.droptimer.reset();
                    }
                }
            }
        }
        if (b2) {
            AutoArmor.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0DPacketCloseWindow(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c));
            AutoArmor.openedInventory = false;
        }
    }
    
    private void changeArmor() {
        final String[] array = { "boots", "leggings", "chestplate", "helmet" };
        for (int i = 0; i < 4; ++i) {
            if (this.insant.getValueState() || this.timeHelper.isDelayComplete((long)(Object)this.delay.getValueState())) {
                final int bestArmor = this.getBestArmor(array[i]);
                if (bestArmor != -1) {
                    AutoArmor.complete = false;
                    if (AutoArmor.mc.field_71439_g.field_71071_by.field_70460_b[i] == null) {
                        AutoArmor.mc.field_71442_b.func_78753_a(0, bestArmor, 0, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
                        this.timeHelper.reset();
                    }
                    else if (isBetter(this.getInventoryItem(bestArmor), AutoArmor.mc.field_71439_g.field_71071_by.field_70460_b[i].func_77973_b())) {
                        AutoArmor.mc.field_71442_b.func_78753_a(0, 8 - i, 0, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
                        this.timeHelper.reset();
                    }
                }
                else {
                    AutoArmor.complete = true;
                }
            }
        }
    }
    
    private int getBestArmor(final String s) {
        return this.getBestInInventory(s);
    }
    
    public static boolean isBetter(final Item item, final Item item2) {
        return item instanceof ItemArmor && item2 instanceof ItemArmor && ((ItemArmor)item).field_77879_b > ((ItemArmor)item2).field_77879_b;
    }
    
    private Item getInventoryItem(final int n) {
        return (AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c() == null) ? null : AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c().func_77973_b();
    }
    
    private void clearLists() {
        for (final ItemStack itemStack : this.closeList) {
            ItemStack itemStack2 = null;
            final InventoryPlayer field_71071_by = AutoArmor.mc.field_71439_g.field_71071_by;
            for (int i = 0; i < 45; ++i) {
                final ItemStack func_75211_c = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                if (func_75211_c != null && itemStack == func_75211_c) {
                    itemStack2 = itemStack;
                }
            }
            if (itemStack2 == null) {
                this.closeList.remove(itemStack);
            }
        }
    }
    
    private void putOnItem(final int n, final int n2) {
        if (Class21.abuses < 0) {
            this.dropOldArmor(n2);
            return;
        }
        if (n != -1 && AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c() != null) {
            this.dropOldArmor(n);
        }
        this.inventoryAction(n2);
    }
    
    private void dropOldArmor(final int n) {
        AutoArmor.mc.field_71439_g.field_71069_bz.func_75144_a(n, 0, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
        AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n, 1, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
    }
    
    private void inventoryAction(final int n) {
        AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n, 1, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
    }
    
    private List<String> getArmors() {
        return Arrays.asList("helmet", "leggings", "chestplate", "boots");
    }
    
    private int[] getIdsByName(final String s) {
        int n = -1;
        switch (s.hashCode()) {
            case -1220934547: {
                if (s.equals("helmet")) {
                    n = 0;
                    break;
                }
                break;
            }
            case 93922241: {
                if (s.equals("boots")) {
                    n = 1;
                    break;
                }
                break;
            }
            case 1069952181: {
                if (s.equals("chestplate")) {
                    n = 2;
                    break;
                }
                break;
            }
            case 1735676010: {
                if (s.equals("leggings")) {
                    n = 3;
                    break;
                }
                break;
            }
        }
        switch (n) {
            case 0: {
                return this.itemHelmet;
            }
            case 1: {
                return this.itemBoots;
            }
            case 2: {
                return this.itemChestplate;
            }
            case 3: {
                return this.itemLeggings;
            }
            default: {
                return new int[0];
            }
        }
    }
    
    private List<Integer> findArmor(final String s) {
        final int[] array = (int[])this.getIdsByName(s);
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 9; i < AutoArmor.mc.field_71439_g.field_71069_bz.func_75138_a().size(); ++i) {
            final ItemStack func_75211_c = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
            if (func_75211_c != null) {
                final int func_150891_b = Item.func_150891_b(func_75211_c.func_77973_b());
                int[] array2;
                for (int length = (array2 = array).length, j = 0; j < length; ++j) {
                    if (func_150891_b == array2[j]) {
                        list.add(i);
                    }
                }
            }
        }
        return list;
    }
    
    private int getBestInInventory(final String s) {
        int n = -1;
        final Iterator<Integer> iterator = this.findArmor(s).iterator();
        while (iterator.hasNext()) {
            final int intValue = (int)iterator.next();
            if (n == -1) {
                n = intValue;
            }
            if (AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue) != null) {
                if (!(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue).func_75211_c().func_77973_b() instanceof ItemArmor)) {
                    continue;
                }
                if (this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue).func_75211_c()) <= this.getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c())) {
                    continue;
                }
                n = intValue;
            }
        }
        return n;
    }
    
    private int getSlotByName(final String s) {
        int n = -1;
        int n2 = -1;
        switch (s.hashCode()) {
            case -1220934547: {
                if (s.equals("helmet")) {
                    n2 = 0;
                    break;
                }
                break;
            }
            case 93922241: {
                if (s.equals("boots")) {
                    n2 = 1;
                    break;
                }
                break;
            }
            case 1069952181: {
                if (s.equals("chestplate")) {
                    n2 = 2;
                    break;
                }
                break;
            }
            case 1735676010: {
                if (s.equals("leggings")) {
                    n2 = 3;
                    break;
                }
                break;
            }
        }
        switch (n2) {
            case 0: {
                n = 5;
                break;
            }
            case 1: {
                n = 8;
                break;
            }
            case 2: {
                n = 6;
                break;
            }
            case 3: {
                n = 7;
                break;
            }
        }
        return n;
    }
    
    private double getProtectionValue(final ItemStack itemStack) {
        if (!(itemStack.func_77973_b() instanceof ItemArmor)) {
            return 0.0;
        }
        return ((ItemArmor)itemStack.func_77973_b()).field_77879_b + (100 - ((ItemArmor)itemStack.func_77973_b()).field_77879_b * 4) * EnchantmentHelper.func_77506_a(Enchantment.field_180310_c.field_77352_x, itemStack) * 4 * 0.0075 + EnchantmentHelper.func_77506_a(Enchantment.field_77329_d.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180309_e.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_77327_f.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180308_g.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180317_h.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180308_g.field_77352_x, itemStack);
    }
    
    private int getValence(final ItemStack itemStack) {
        int n = 0;
        if (itemStack == null) {
            return 0;
        }
        if (itemStack.func_77973_b() instanceof ItemArmor) {
            n += ((ItemArmor)itemStack.func_77973_b()).field_77879_b;
        }
        if (itemStack != null && itemStack.func_77942_o()) {
            n = n + (int)itemStack.func_77986_q().func_150305_b(0).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(1).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(2).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(3).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(4).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(5).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(6).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(7).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(8).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(9).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(34).func_74769_h("lvl");
        }
        return n + (int)this.getProtectionValue(itemStack) + (itemStack.func_77958_k() - itemStack.func_77952_i());
    }
}
