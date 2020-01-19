package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import ClassSub.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.inventory.*;
import java.lang.reflect.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.player.*;
import java.util.function.*;
import java.util.stream.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.potion.*;

public class InvCleaner extends Mod
{
    public Value<Boolean> autoclose;
    public static Class191 timer;
    public final Set<Integer> blacklistedItemIDs;
    public ItemStack[] bestArmorSet;
    public ItemStack bestSword;
    public ItemStack bestPickAxe;
    public ItemStack bestBow;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public InvCleaner() {
        super("InvCleaner", Category.PLAYER);
        this.autoclose = new Value<Boolean>("InvCleaner_AutoToggle", false);
        this.blacklistedItemIDs = new HashSet<Integer>();
        InvCleaner.timer = new Class191();
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotion eventPreMotion) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, Exception {
        if (InvCleaner.mc.field_71439_g.field_70173_aa % 2 == 0 && new Random().nextInt(1) == 0) {
            this.bestArmorSet = this.getBestArmorSet();
            this.bestSword = this.getBestItem(ItemSword.class, (Comparator)Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::getSwordDamage));
            this.bestPickAxe = this.getBestItem(ItemPickaxe.class, (Comparator)Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::getMiningSpeed));
            this.bestBow = this.getBestItem(ItemBow.class, (Comparator)Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::getBowPower));
            final Optional first = InvCleaner.mc.field_71439_g.field_71069_bz.field_75151_b.stream().filter(Slot::func_75216_d).filter(InvCleaner::lambda$onUpdate$0).filter(InvCleaner::lambda$onUpdate$1).filter(this::lambda$onUpdate$2).findFirst();
            if (first.isPresent()) {
                this.dropItem(((Slot)first.get()).field_75222_d);
            }
            else if ((boolean)this.autoclose.getValueState()) {
                this.set(false);
            }
        }
    }
    
    public void dropItem(final int n) {
        InvCleaner.mc.field_71442_b.func_78753_a(0, n, 1, 4, (EntityPlayer)InvCleaner.mc.field_71439_g);
    }
    
    public boolean isItemBlackListed(final ItemStack itemStack) {
        final Item func_77973_b = itemStack.func_77973_b();
        return this.blacklistedItemIDs.contains(Item.func_150891_b(func_77973_b)) || (func_77973_b instanceof ItemBow && !this.bestBow.equals(itemStack)) || (func_77973_b instanceof ItemTool && !this.bestPickAxe.equals(itemStack)) || func_77973_b instanceof ItemFishingRod || func_77973_b instanceof ItemGlassBottle || func_77973_b instanceof ItemBucket || func_77973_b instanceof ItemEgg || func_77973_b instanceof ItemSnowball || (func_77973_b instanceof ItemSword && !this.bestSword.equals(itemStack)) || (func_77973_b instanceof ItemArmor && !this.bestArmorSet[((ItemArmor)func_77973_b).field_77881_a].equals(itemStack)) || (func_77973_b instanceof ItemPotion && this.isPotionNegative(itemStack));
    }
    
    public ItemStack getBestItem(final Class<? extends Item> clazz, final Comparator comparator) {
        return (ItemStack)InvCleaner.mc.field_71439_g.field_71069_bz.field_75151_b.stream().map(Slot::func_75211_c).filter(Objects::nonNull).filter(InvCleaner::lambda$getBestItem$3).max(comparator).orElse(null);
    }
    
    public ItemStack[] getBestArmorSet() {
        final ItemStack[] array = new ItemStack[4];
        for (final ItemStack itemStack : (List)InvCleaner.mc.field_71439_g.field_71069_bz.field_75151_b.stream().filter(Slot::func_75216_d).map(Slot::func_75211_c).filter(InvCleaner::lambda$getBestArmorSet$4).collect(Collectors.toList())) {
            final ItemArmor itemArmor = (ItemArmor)itemStack.func_77973_b();
            final ItemStack itemStack2 = array[itemArmor.field_77881_a];
            if (itemStack2 == null || this.getArmorDamageReduction(itemStack) > this.getArmorDamageReduction(itemStack2)) {
                array[itemArmor.field_77881_a] = itemStack;
            }
        }
        return array;
    }
    
    public double getSwordDamage(final ItemStack itemStack) {
        double func_111164_d = 0.0;
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (first.isPresent()) {
            func_111164_d = ((AttributeModifier)first.get()).func_111164_d();
        }
        return func_111164_d + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
    }
    
    public double getBowPower(final ItemStack itemStack) {
        double func_111164_d = 0.0;
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (first.isPresent()) {
            func_111164_d = ((AttributeModifier)first.get()).func_111164_d();
        }
        return func_111164_d + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
    }
    
    public double getMiningSpeed(final ItemStack itemStack) {
        double func_111164_d = 0.0;
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (first.isPresent()) {
            func_111164_d = ((AttributeModifier)first.get()).func_111164_d();
        }
        return func_111164_d + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
    }
    
    public double getArmorDamageReduction(final ItemStack itemStack) {
        return ((ItemArmor)itemStack.func_77973_b()).field_77879_b + EnchantmentHelper.func_77508_a(new ItemStack[] { itemStack }, DamageSource.func_76365_a((EntityPlayer)InvCleaner.mc.field_71439_g));
    }
    
    public boolean isPotionNegative(final ItemStack itemStack) {
        return ((ItemPotion)itemStack.func_77973_b()).func_77832_l(itemStack).stream().map(InvCleaner::lambda$isPotionNegative$5).anyMatch(Potion::func_76398_f);
    }
    
    private boolean stackIsUseful(final int n) {
        final ItemStack func_75211_c = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c();
        boolean b = false;
        if (func_75211_c.func_77973_b() instanceof ItemSword || func_75211_c.func_77973_b() instanceof ItemPickaxe || func_75211_c.func_77973_b() instanceof ItemAxe) {
            for (int i = 0; i < 45; ++i) {
                if (i != n) {
                    if (InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d()) {
                        final ItemStack func_75211_c2 = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                        if (((func_75211_c2 != null && func_75211_c2.func_77973_b() instanceof ItemSword) || func_75211_c2.func_77973_b() instanceof ItemAxe || func_75211_c2.func_77973_b() instanceof ItemPickaxe) && getItemDamage(func_75211_c2) + EnchantmentHelper.func_152377_a(func_75211_c2, EnumCreatureAttribute.UNDEFINED) > getItemDamage(func_75211_c) + EnchantmentHelper.func_152377_a(func_75211_c, EnumCreatureAttribute.UNDEFINED)) {
                            b = true;
                            break;
                        }
                    }
                }
            }
        }
        else if (func_75211_c.func_77973_b() instanceof ItemArmor) {
            for (int j = 0; j < 45; ++j) {
                if (n != j) {
                    if (InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(j).func_75216_d()) {
                        final ItemStack func_75211_c3 = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(j).func_75211_c();
                        if (func_75211_c3 != null && func_75211_c3.func_77973_b() instanceof ItemArmor) {
                            final List<Integer> list = Arrays.asList(298, 314, 302, 306, 310);
                            final List<Integer> list2 = Arrays.asList(299, 315, 303, 307, 311);
                            final List<Integer> list3 = Arrays.asList(300, 316, 304, 308, 312);
                            final List<Integer> list4 = Arrays.asList(301, 317, 305, 309, 313);
                            if (list.contains(Item.func_150891_b(func_75211_c3.func_77973_b())) && list.contains(Item.func_150891_b(func_75211_c.func_77973_b()))) {
                                if (list.indexOf(Item.func_150891_b(func_75211_c.func_77973_b())) < list.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                    b = true;
                                    break;
                                }
                            }
                            else if (list2.contains(Item.func_150891_b(func_75211_c3.func_77973_b())) && list2.contains(Item.func_150891_b(func_75211_c.func_77973_b()))) {
                                if (list2.indexOf(Item.func_150891_b(func_75211_c.func_77973_b())) < list2.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                    b = true;
                                    break;
                                }
                            }
                            else if (list3.contains(Item.func_150891_b(func_75211_c3.func_77973_b())) && list3.contains(Item.func_150891_b(func_75211_c.func_77973_b()))) {
                                if (list3.indexOf(Item.func_150891_b(func_75211_c.func_77973_b())) < list3.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                    b = true;
                                    break;
                                }
                            }
                            else if (list4.contains(Item.func_150891_b(func_75211_c3.func_77973_b())) && list4.contains(Item.func_150891_b(func_75211_c.func_77973_b())) && list4.indexOf(Item.func_150891_b(func_75211_c.func_77973_b())) < list4.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int k = 0; k < 45; ++k) {
            if (n != k) {
                if (InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75216_d()) {
                    final ItemStack func_75211_c4 = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75211_c();
                    if (func_75211_c4 != null && (func_75211_c4.func_77973_b() instanceof ItemSword || func_75211_c4.func_77973_b() instanceof ItemAxe || func_75211_c4.func_77973_b() instanceof ItemBow || func_75211_c4.func_77973_b() instanceof ItemFishingRod || func_75211_c4.func_77973_b() instanceof ItemArmor || func_75211_c4.func_77973_b() instanceof ItemAxe || func_75211_c4.func_77973_b() instanceof ItemPickaxe || Item.func_150891_b(func_75211_c4.func_77973_b()) == 346)) {
                        func_75211_c4.func_77973_b();
                        if (Item.func_150891_b(func_75211_c.func_77973_b()) == Item.func_150891_b(func_75211_c4.func_77973_b())) {
                            b = true;
                            break;
                        }
                    }
                }
            }
        }
        return Item.func_150891_b(func_75211_c.func_77973_b()) != 367 && (Item.func_150891_b(func_75211_c.func_77973_b()) == 30 || Item.func_150891_b(func_75211_c.func_77973_b()) == 259 || Item.func_150891_b(func_75211_c.func_77973_b()) == 262 || Item.func_150891_b(func_75211_c.func_77973_b()) == 264 || Item.func_150891_b(func_75211_c.func_77973_b()) == 265 || Item.func_150891_b(func_75211_c.func_77973_b()) == 346 || Item.func_150891_b(func_75211_c.func_77973_b()) == 384 || Item.func_150891_b(func_75211_c.func_77973_b()) == 345 || Item.func_150891_b(func_75211_c.func_77973_b()) == 296 || Item.func_150891_b(func_75211_c.func_77973_b()) == 336 || Item.func_150891_b(func_75211_c.func_77973_b()) == 266 || Item.func_150891_b(func_75211_c.func_77973_b()) == 280 || func_75211_c.func_82837_s() || (!b && (func_75211_c.func_77973_b() instanceof ItemArmor || func_75211_c.func_77973_b() instanceof ItemAxe || func_75211_c.func_77973_b() instanceof ItemBow || func_75211_c.func_77973_b() instanceof ItemSword || func_75211_c.func_77973_b() instanceof ItemPotion || func_75211_c.func_77973_b() instanceof ItemFlintAndSteel || func_75211_c.func_77973_b() instanceof ItemEnderPearl || func_75211_c.func_77973_b() instanceof ItemBlock || func_75211_c.func_77973_b() instanceof ItemFood || func_75211_c.func_77973_b() instanceof ItemPickaxe)));
    }
    
    static float getItemDamage(final ItemStack itemStack) {
        final Multimap func_111283_C = itemStack.func_111283_C();
        if (!func_111283_C.isEmpty()) {
            final Iterator iterator = func_111283_C.entries().iterator();
            if (iterator.hasNext()) {
                final AttributeModifier attributeModifier = (AttributeModifier)((Map.Entry<K, AttributeModifier>)iterator.next()).getValue();
                double func_111164_d;
                if (attributeModifier.func_111169_c() != 1 && attributeModifier.func_111169_c() != 2) {
                    func_111164_d = attributeModifier.func_111164_d();
                }
                else {
                    func_111164_d = attributeModifier.func_111164_d() * 100.0;
                }
                if (attributeModifier.func_111164_d() > 1.0) {
                    return 1.0f + (float)func_111164_d;
                }
                return 1.0f;
            }
        }
        return 1.0f;
    }
    
    private static Potion lambda$isPotionNegative$5(final PotionEffect potionEffect) {
        return Potion.field_76425_a[potionEffect.func_76456_a()];
    }
    
    private static boolean lambda$getBestArmorSet$4(final ItemStack itemStack) {
        return itemStack.func_77973_b() instanceof ItemArmor;
    }
    
    private static boolean lambda$getBestItem$3(final Class clazz, final ItemStack itemStack) {
        return itemStack.func_77973_b().getClass().equals(clazz);
    }
    
    private boolean lambda$onUpdate$2(final Slot slot) {
        return this.isItemBlackListed(slot.func_75211_c());
    }
    
    private static boolean lambda$onUpdate$1(final Slot slot) {
        return !slot.func_75211_c().equals(InvCleaner.mc.field_71439_g.func_70694_bm());
    }
    
    private static boolean lambda$onUpdate$0(final Slot slot) {
        return Arrays.stream(InvCleaner.mc.field_71439_g.field_71071_by.field_70460_b).noneMatch(slot.func_75211_c()::equals);
    }
}
