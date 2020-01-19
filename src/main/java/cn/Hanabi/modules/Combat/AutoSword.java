package cn.Hanabi.modules.Combat;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.item.*;
import ClassSub.*;
import cn.Hanabi.*;
import net.minecraft.entity.player.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.inventory.*;
import java.util.function.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import java.util.*;

public class AutoSword extends Mod
{
    private ItemStack bestSword;
    private ItemStack prevBestSword;
    private boolean shouldSwitch;
    public Class191 timer;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public AutoSword() {
        super("AutoSword", Category.COMBAT);
        this.shouldSwitch = false;
        this.timer = new Class191();
    }
    
    @EventTarget
    private void onUpdate(final EventUpdate eventUpdate) {
        if (Class69.username.length() < 1) {
            System.exit(0);
        }
        if (AutoSword.mc.field_71439_g.field_70173_aa % 7 == 0) {
            if (AutoSword.mc.field_71439_g.field_71075_bZ.field_75098_d || (AutoSword.mc.field_71439_g.field_71070_bA != null && AutoSword.mc.field_71439_g.field_71070_bA.field_75152_c != 0)) {
                return;
            }
            this.bestSword = this.getBestItem(ItemSword.class, (Comparator)Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::getSwordDamage));
            if (this.bestSword == null) {
                return;
            }
            int hotbarHas = Class123.hotbarHas(this.bestSword.func_77973_b(), 0) ? 1 : 0;
            if (hotbarHas != 0) {
                if (Class123.getItemBySlotID(0) != null) {
                    if (Class123.getItemBySlotID(0).func_77973_b() instanceof ItemSword) {
                        hotbarHas = ((this.getSwordDamage(Class123.getItemBySlotID(0)) >= this.getSwordDamage(this.bestSword)) ? 1 : 0);
                    }
                }
                else {
                    hotbarHas = 0;
                }
            }
            if (this.prevBestSword == null || !this.prevBestSword.equals(this.bestSword) || hotbarHas == 0) {
                this.shouldSwitch = true;
                this.prevBestSword = this.bestSword;
            }
            else {
                this.shouldSwitch = false;
            }
            int bestSwordSlotID = Class123.getBestSwordSlotID(this.bestSword, this.getSwordDamage(this.bestSword));
            switch (bestSwordSlotID) {
                case 0: {
                    bestSwordSlotID = 36;
                    break;
                }
                case 1: {
                    bestSwordSlotID = 37;
                    break;
                }
                case 2: {
                    bestSwordSlotID = 38;
                    break;
                }
                case 3: {
                    bestSwordSlotID = 39;
                    break;
                }
                case 4: {
                    bestSwordSlotID = 40;
                    break;
                }
                case 5: {
                    bestSwordSlotID = 41;
                    break;
                }
                case 6: {
                    bestSwordSlotID = 42;
                    break;
                }
                case 7: {
                    bestSwordSlotID = 43;
                    break;
                }
                case 8: {
                    bestSwordSlotID = 44;
                    break;
                }
            }
            if (Hanabi.flag < 0) {
                AutoSword.mc.field_71439_g.field_71069_bz.func_75144_a(bestSwordSlotID, 0, 4, (EntityPlayer)AutoSword.mc.field_71439_g);
                AutoSword.mc.field_71442_b.func_78753_a(AutoSword.mc.field_71439_g.field_71069_bz.field_75152_c, bestSwordSlotID, 1, 4, (EntityPlayer)AutoSword.mc.field_71439_g);
            }
            if (this.shouldSwitch && this.timer.isDelayComplete(1000L)) {
                AutoSword.mc.field_71442_b.func_78753_a(0, bestSwordSlotID, 0, 2, (EntityPlayer)AutoSword.mc.field_71439_g);
                this.timer.reset();
            }
        }
    }
    
    private ItemStack getBestItem(final Class<? extends Item> clazz, final Comparator comparator) {
        return (ItemStack)AutoSword.mc.field_71439_g.field_71069_bz.field_75151_b.stream().map(Slot::func_75211_c).filter(Objects::nonNull).filter(AutoSword::lambda$getBestItem$0).max(comparator).orElse(null);
    }
    
    private double getSwordDamage(final ItemStack itemStack) {
        double func_111164_d = 0.0;
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (first.isPresent()) {
            func_111164_d = ((AttributeModifier)first.get()).func_111164_d();
        }
        return func_111164_d + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
    }
    
    private static boolean lambda$getBestItem$0(final Class clazz, final ItemStack itemStack) {
        return itemStack.func_77973_b().getClass().equals(clazz);
    }
}
