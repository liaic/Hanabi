package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import ClassSub.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.client.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import com.darkmagician6.eventapi.*;
import java.util.function.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import java.util.*;
import org.apache.commons.lang3.*;
import net.minecraft.potion.*;

public class ChestStealer extends Mod
{
    public static boolean isChest;
    private Value<Double> delay;
    private Value<Boolean> onlychest;
    private Value<Boolean> trash;
    Class191 time;
    private int[] itemHelmet;
    private int[] itemChestplate;
    private int[] itemLeggings;
    private int[] itemBoots;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public ChestStealer() {
        super("ChestStealer", Category.PLAYER);
        this.delay = new Value<Double>("ChestStealer_Delay", 30.0, 0.0, 1000.0, 10.0);
        this.onlychest = new Value<Boolean>("ChestStealer_NoGameMenu", false);
        this.trash = new Value<Boolean>("ChestStealer_PickTrash", false);
        this.time = new Class191();
        this.itemHelmet = new int[] { 298, 302, 306, 310, 314 };
        this.itemChestplate = new int[] { 299, 303, 307, 311, 315 };
        this.itemLeggings = new int[] { 300, 304, 308, 312, 316 };
        this.itemBoots = new int[] { 301, 305, 309, 313, 317 };
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (!ChestStealer.isChest && this.onlychest.getValueState()) {
            return;
        }
        if (Minecraft.func_71410_x().field_71439_g.field_71070_bA != null && Minecraft.func_71410_x().field_71439_g.field_71070_bA instanceof ContainerChest) {
            final ContainerChest containerChest = (ContainerChest)Minecraft.func_71410_x().field_71439_g.field_71070_bA;
            if (this.isChestEmpty(containerChest)) {
                ChestStealer.mc.field_71439_g.func_71053_j();
            }
            for (int i = 0; i < containerChest.func_85151_d().func_70302_i_(); ++i) {
                if (containerChest.func_85151_d().func_70301_a(i) != null && this.time.isDelayComplete((long)(Object)this.delay.getValueState() + (long)new Random().nextInt(100)) && (this.itemIsUseful(containerChest, i) || this.trash.getValueState())) {
                    if (new Random().nextInt(100) <= 80) {
                        Minecraft.func_71410_x().field_71442_b.func_78753_a(containerChest.field_75152_c, i, 0, 1, (EntityPlayer)Minecraft.func_71410_x().field_71439_g);
                        this.time.reset();
                    }
                }
            }
        }
    }
    
    private boolean isChestEmpty(final ContainerChest containerChest) {
        for (int i = 0; i < containerChest.func_85151_d().func_70302_i_(); ++i) {
            if (containerChest.func_85151_d().func_70301_a(i) != null && (this.itemIsUseful(containerChest, i) || this.trash.getValueState())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPotionNegative(final ItemStack itemStack) {
        return ((ItemPotion)itemStack.func_77973_b()).func_77832_l(itemStack).stream().map(ChestStealer::lambda$isPotionNegative$0).anyMatch(Potion::func_76398_f);
    }
    
    private boolean itemIsUseful(final ContainerChest containerChest, final int n) {
        final ItemStack func_70301_a = containerChest.func_85151_d().func_70301_a(n);
        final Item func_77973_b = func_70301_a.func_77973_b();
        return func_77973_b instanceof ItemFood || (func_77973_b instanceof ItemPotion && !this.isPotionNegative(func_70301_a)) || (func_77973_b instanceof ItemSword && this.isBestSword(containerChest, func_70301_a)) || (func_77973_b instanceof ItemArmor && this.isBestArmor(containerChest, func_70301_a)) || (func_77973_b instanceof ItemBlock && !Scaffold_.blacklistedBlocks.contains(Block.func_149634_a(func_77973_b)));
    }
    
    private float getSwordDamage(final ItemStack itemStack) {
        float n = 0.0f;
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (first.isPresent()) {
            n = (float)((AttributeModifier)first.get()).func_111164_d();
        }
        return n + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
    }
    
    private boolean isBestSword(final ContainerChest containerChest, final ItemStack itemStack) {
        final float swordDamage = this.getSwordDamage(itemStack);
        float n = 0.0f;
        for (int i = 0; i < 45; ++i) {
            if (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                final float swordDamage2 = this.getSwordDamage(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c());
                if (swordDamage2 >= n) {
                    n = swordDamage2;
                }
            }
        }
        for (int j = 0; j < containerChest.func_85151_d().func_70302_i_(); ++j) {
            if (containerChest.func_85151_d().func_70301_a(j) != null) {
                final float swordDamage3 = this.getSwordDamage(containerChest.func_85151_d().func_70301_a(j));
                if (swordDamage3 >= n) {
                    n = swordDamage3;
                }
            }
        }
        return swordDamage == n;
    }
    
    private boolean isBestArmor(final ContainerChest containerChest, final ItemStack itemStack) {
        final float n = (float)((ItemArmor)itemStack.func_77973_b()).field_77879_b;
        float n2 = 0.0f;
        if (isContain(this.itemHelmet, Item.func_150891_b(itemStack.func_77973_b()))) {
            for (int i = 0; i < 45; ++i) {
                if (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d() && isContain(this.itemHelmet, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b()))) {
                    final float n3 = (float)((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b()).field_77879_b;
                    if (n3 > n2) {
                        n2 = n3;
                    }
                }
            }
            for (int j = 0; j < containerChest.func_85151_d().func_70302_i_(); ++j) {
                if (containerChest.func_85151_d().func_70301_a(j) != null && isContain(this.itemHelmet, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(j).func_77973_b()))) {
                    final float n4 = (float)((ItemArmor)containerChest.func_85151_d().func_70301_a(j).func_77973_b()).field_77879_b;
                    if (n4 > n2) {
                        n2 = n4;
                    }
                }
            }
        }
        if (isContain(this.itemChestplate, Item.func_150891_b(itemStack.func_77973_b()))) {
            for (int k = 0; k < 45; ++k) {
                if (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75216_d() && isContain(this.itemChestplate, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75211_c().func_77973_b()))) {
                    final float n5 = (float)((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75211_c().func_77973_b()).field_77879_b;
                    if (n5 > n2) {
                        n2 = n5;
                    }
                }
            }
            for (int l = 0; l < containerChest.func_85151_d().func_70302_i_(); ++l) {
                if (containerChest.func_85151_d().func_70301_a(l) != null && isContain(this.itemChestplate, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(l).func_77973_b()))) {
                    final float n6 = (float)((ItemArmor)containerChest.func_85151_d().func_70301_a(l).func_77973_b()).field_77879_b;
                    if (n6 > n2) {
                        n2 = n6;
                    }
                }
            }
        }
        if (isContain(this.itemLeggings, Item.func_150891_b(itemStack.func_77973_b()))) {
            for (int n7 = 0; n7 < 45; ++n7) {
                if (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n7).func_75216_d() && isContain(this.itemLeggings, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n7).func_75211_c().func_77973_b()))) {
                    final float n8 = (float)((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n7).func_75211_c().func_77973_b()).field_77879_b;
                    if (n8 > n2) {
                        n2 = n8;
                    }
                }
            }
            for (int n9 = 0; n9 < containerChest.func_85151_d().func_70302_i_(); ++n9) {
                if (containerChest.func_85151_d().func_70301_a(n9) != null && isContain(this.itemLeggings, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(n9).func_77973_b()))) {
                    final float n10 = (float)((ItemArmor)containerChest.func_85151_d().func_70301_a(n9).func_77973_b()).field_77879_b;
                    if (n10 > n2) {
                        n2 = n10;
                    }
                }
            }
        }
        if (isContain(this.itemBoots, Item.func_150891_b(itemStack.func_77973_b()))) {
            for (int n11 = 0; n11 < 45; ++n11) {
                if (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n11).func_75216_d() && isContain(this.itemBoots, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n11).func_75211_c().func_77973_b()))) {
                    final float n12 = (float)((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n11).func_75211_c().func_77973_b()).field_77879_b;
                    if (n12 > n2) {
                        n2 = n12;
                    }
                }
            }
            for (int n13 = 0; n13 < containerChest.func_85151_d().func_70302_i_(); ++n13) {
                if (containerChest.func_85151_d().func_70301_a(n13) != null && isContain(this.itemBoots, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(n13).func_77973_b()))) {
                    final float n14 = (float)((ItemArmor)containerChest.func_85151_d().func_70301_a(n13).func_77973_b()).field_77879_b;
                    if (n14 > n2) {
                        n2 = n14;
                    }
                }
            }
        }
        return n == n2;
    }
    
    public static boolean isContain(final int[] array, final int n) {
        return ArrayUtils.contains(array, n);
    }
    
    private static Potion lambda$isPotionNegative$0(final PotionEffect potionEffect) {
        return Potion.field_76425_a[potionEffect.func_76456_a()];
    }
}
