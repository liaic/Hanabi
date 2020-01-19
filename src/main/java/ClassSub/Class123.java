package ClassSub;

import net.minecraft.client.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.item.*;

public class Class123
{
    public static Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class123() {
        super();
    }
    
    public void dropSlot(final int n) {
        Class123.mc.field_71442_b.func_78753_a(new GuiInventory((EntityPlayer)Class123.mc.field_71439_g).field_147002_h.field_75152_c, n, 1, 4, (EntityPlayer)Class123.mc.field_71439_g);
    }
    
    public static ItemStack getStackInSlot(final int n) {
        return Class123.mc.field_71439_g.field_71071_by.func_70301_a(n);
    }
    
    public static boolean isBestArmorOfTypeInInv(final ItemStack itemStack) {
        try {
            if (itemStack == null) {
                return false;
            }
            if (itemStack.func_77973_b() == null) {
                return false;
            }
            if (itemStack.func_77973_b() != null && !(itemStack.func_77973_b() instanceof ItemArmor)) {
                return false;
            }
            final ItemArmor itemArmor = (ItemArmor)itemStack.func_77973_b();
            final int armorProt = getArmorProt(itemStack);
            for (int i = 0; i < 4; ++i) {
                final ItemStack itemStack2 = Class123.mc.field_71439_g.field_71071_by.field_70460_b[i];
                final int armorProt2;
                if (itemStack2 != null && ((ItemArmor)itemStack2.func_77973_b()).field_77881_a == itemArmor.field_77881_a && (armorProt2 = getArmorProt(itemStack2)) >= armorProt) {
                    return false;
                }
            }
            for (int j = 0; j < Class123.mc.field_71439_g.field_71071_by.func_70302_i_() - 4; ++j) {
                final ItemStack func_70301_a = Class123.mc.field_71439_g.field_71071_by.func_70301_a(j);
                if (func_70301_a != null && func_70301_a.func_77973_b() instanceof ItemArmor) {
                    final ItemArmor itemArmor2 = (ItemArmor)func_70301_a.func_77973_b();
                    final int armorProt3;
                    if (itemArmor2.field_77881_a == itemArmor.field_77881_a && itemArmor2 != itemArmor && (armorProt3 = getArmorProt(func_70301_a)) >= armorProt) {
                        return false;
                    }
                }
            }
        }
        catch (Exception ex) {}
        return true;
    }
    
    public static boolean hotbarHas(final Item item) {
        for (int i = 0; i <= 36; ++i) {
            final ItemStack func_70301_a = Minecraft.func_71410_x().field_71439_g.field_71071_by.func_70301_a(i);
            if (func_70301_a != null && func_70301_a.func_77973_b() == item) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean hotbarHas(final Item item, final int n) {
        for (int i = 0; i <= 36; ++i) {
            final ItemStack func_70301_a = Minecraft.func_71410_x().field_71439_g.field_71071_by.func_70301_a(i);
            if (func_70301_a != null && func_70301_a.func_77973_b() == item && getSlotID(func_70301_a.func_77973_b()) == n) {
                return true;
            }
        }
        return false;
    }
    
    public static int getSlotID(final Item item) {
        for (int i = 0; i <= 36; ++i) {
            final ItemStack func_70301_a = Minecraft.func_71410_x().field_71439_g.field_71071_by.func_70301_a(i);
            if (func_70301_a != null && func_70301_a.func_77973_b() == item) {
                return i;
            }
        }
        return -1;
    }
    
    public static ItemStack getItemBySlotID(final int n) {
        for (int i = 0; i <= 36; ++i) {
            final ItemStack func_70301_a = Minecraft.func_71410_x().field_71439_g.field_71071_by.func_70301_a(i);
            if (func_70301_a != null && getSlotID(func_70301_a.func_77973_b()) == n) {
                return func_70301_a;
            }
        }
        return null;
    }
    
    public static int getArmorProt(final ItemStack itemStack) {
        int n = -1;
        if (itemStack != null && itemStack.func_77973_b() != null && itemStack.func_77973_b() instanceof ItemArmor) {
            n = ((ItemArmor)itemStack.func_77973_b()).func_82812_d().func_78044_b(getItemType(itemStack)) + EnchantmentHelper.func_77508_a(new ItemStack[] { itemStack }, DamageSource.field_76377_j);
        }
        return n;
    }
    
    public static int getBestSwordSlotID(final ItemStack itemStack, final double n) {
        for (int i = 0; i <= 36; ++i) {
            final ItemStack func_70301_a = Minecraft.func_71410_x().field_71439_g.field_71071_by.func_70301_a(i);
            if (func_70301_a != null && func_70301_a == itemStack && getSwordDamage(func_70301_a) == getSwordDamage(itemStack)) {
                return i;
            }
        }
        return -1;
    }
    
    private static double getSwordDamage(final ItemStack itemStack) {
        double func_111164_d = 0.0;
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (first.isPresent()) {
            func_111164_d = ((AttributeModifier)first.get()).func_111164_d();
        }
        return func_111164_d + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
    }
    
    public boolean isBestChest(final int n) {
        if (getStackInSlot(n) != null && getStackInSlot(n).func_77973_b() != null && getStackInSlot(n).func_77973_b() instanceof ItemArmor) {
            final int n2 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(n).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(n))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(n) }, DamageSource.field_76377_j);
            if (Class123.mc.field_71439_g.field_71071_by.field_70460_b[2] != null) {
                final ItemArmor itemArmor = (ItemArmor)Class123.mc.field_71439_g.field_71071_by.field_70460_b[2].func_77973_b();
                final ItemStack itemStack = Class123.mc.field_71439_g.field_71071_by.field_70460_b[2];
                final ItemArmor itemArmor2 = (ItemArmor)getStackInSlot(n).func_77973_b();
                final int n3 = ((ItemArmor)itemStack.func_77973_b()).func_82812_d().func_78044_b(getItemType(itemStack)) + EnchantmentHelper.func_77508_a(new ItemStack[] { itemStack }, DamageSource.field_76377_j);
                if (n3 > n2 || n3 == n2) {
                    return false;
                }
            }
            for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
                if (getStackInSlot(i) != null && Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemArmor) {
                    final int n4 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(i))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(i) }, DamageSource.field_76377_j);
                    final ItemArmor itemArmor3 = (ItemArmor)getStackInSlot(n).func_77973_b();
                    final ItemArmor itemArmor4 = (ItemArmor)getStackInSlot(i).func_77973_b();
                    if (itemArmor3.field_77881_a == 1 && itemArmor4.field_77881_a == 1 && n4 > n2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isBestHelmet(final int n) {
        if (getStackInSlot(n) != null && getStackInSlot(n).func_77973_b() != null && getStackInSlot(n).func_77973_b() instanceof ItemArmor) {
            final int n2 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(n).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(n))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(n) }, DamageSource.field_76377_j);
            if (Class123.mc.field_71439_g.field_71071_by.field_70460_b[3] != null) {
                final ItemArmor itemArmor = (ItemArmor)Class123.mc.field_71439_g.field_71071_by.field_70460_b[3].func_77973_b();
                final ItemStack itemStack = Class123.mc.field_71439_g.field_71071_by.field_70460_b[3];
                final ItemArmor itemArmor2 = (ItemArmor)getStackInSlot(n).func_77973_b();
                final int n3 = ((ItemArmor)itemStack.func_77973_b()).func_82812_d().func_78044_b(getItemType(itemStack)) + EnchantmentHelper.func_77508_a(new ItemStack[] { itemStack }, DamageSource.field_76377_j);
                if (n3 > n2 || n3 == n2) {
                    return false;
                }
            }
            for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
                if (getStackInSlot(i) != null && Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemArmor) {
                    final int n4 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(i))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(i) }, DamageSource.field_76377_j);
                    final ItemArmor itemArmor3 = (ItemArmor)getStackInSlot(n).func_77973_b();
                    final ItemArmor itemArmor4 = (ItemArmor)getStackInSlot(i).func_77973_b();
                    if (itemArmor3.field_77881_a == 0 && itemArmor4.field_77881_a == 0 && n4 > n2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isBestLeggings(final int n) {
        if (getStackInSlot(n) != null && getStackInSlot(n).func_77973_b() != null && getStackInSlot(n).func_77973_b() instanceof ItemArmor) {
            final int n2 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(n).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(n))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(n) }, DamageSource.field_76377_j);
            if (Class123.mc.field_71439_g.field_71071_by.field_70460_b[1] != null) {
                final ItemArmor itemArmor = (ItemArmor)Class123.mc.field_71439_g.field_71071_by.field_70460_b[1].func_77973_b();
                final ItemStack itemStack = Class123.mc.field_71439_g.field_71071_by.field_70460_b[1];
                final ItemArmor itemArmor2 = (ItemArmor)getStackInSlot(n).func_77973_b();
                final int n3 = ((ItemArmor)itemStack.func_77973_b()).func_82812_d().func_78044_b(getItemType(itemStack)) + EnchantmentHelper.func_77508_a(new ItemStack[] { itemStack }, DamageSource.field_76377_j);
                if (n3 > n2 || n3 == n2) {
                    return false;
                }
            }
            for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
                if (getStackInSlot(i) != null && Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemArmor) {
                    final int n4 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(i))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(i) }, DamageSource.field_76377_j);
                    final ItemArmor itemArmor3 = (ItemArmor)getStackInSlot(n).func_77973_b();
                    final ItemArmor itemArmor4 = (ItemArmor)getStackInSlot(i).func_77973_b();
                    if (itemArmor3.field_77881_a == 2 && itemArmor4.field_77881_a == 2 && n4 > n2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isBestBoots(final int n) {
        if (getStackInSlot(n) != null && getStackInSlot(n).func_77973_b() != null && getStackInSlot(n).func_77973_b() instanceof ItemArmor) {
            final int n2 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(n).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(n))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(n) }, DamageSource.field_76377_j);
            if (Class123.mc.field_71439_g.field_71071_by.field_70460_b[0] != null) {
                final ItemArmor itemArmor = (ItemArmor)Class123.mc.field_71439_g.field_71071_by.field_70460_b[0].func_77973_b();
                final ItemStack itemStack = Class123.mc.field_71439_g.field_71071_by.field_70460_b[0];
                final ItemArmor itemArmor2 = (ItemArmor)getStackInSlot(n).func_77973_b();
                final int n3 = ((ItemArmor)itemStack.func_77973_b()).func_82812_d().func_78044_b(getItemType(itemStack)) + EnchantmentHelper.func_77508_a(new ItemStack[] { itemStack }, DamageSource.field_76377_j);
                if (n3 > n2 || n3 == n2) {
                    return false;
                }
            }
            for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
                if (getStackInSlot(i) != null && Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemArmor) {
                    final int n4 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(i))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(i) }, DamageSource.field_76377_j);
                    final ItemArmor itemArmor3 = (ItemArmor)getStackInSlot(n).func_77973_b();
                    final ItemArmor itemArmor4 = (ItemArmor)getStackInSlot(i).func_77973_b();
                    if (itemArmor3.field_77881_a == 3 && itemArmor4.field_77881_a == 3 && n4 > n2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isBestSword(final int n) {
        return this.getBestWeapon() == n;
    }
    
    public static int getItemType(final ItemStack itemStack) {
        if (itemStack.func_77973_b() instanceof ItemArmor) {
            return ((ItemArmor)itemStack.func_77973_b()).field_77881_a;
        }
        return -1;
    }
    
    public static float getItemDamage(final ItemStack itemStack) {
        final Multimap func_111283_C = itemStack.func_111283_C();
        final Iterator iterator;
        if (!func_111283_C.isEmpty() && (iterator = func_111283_C.entries().iterator()).hasNext()) {
            final AttributeModifier attributeModifier = (AttributeModifier)((Map.Entry<K, AttributeModifier>)iterator.next()).getValue();
            final double n = (attributeModifier.func_111169_c() != 1 && attributeModifier.func_111169_c() != 2) ? attributeModifier.func_111164_d() : (attributeModifier.func_111164_d() * 100.0);
            return (attributeModifier.func_111164_d() > 1.0) ? (1.0f + (float)n) : 1.0f;
        }
        return 1.0f;
    }
    
    public boolean hasItemMoreTimes(final int n) {
        final ArrayList<ItemStack> list = new ArrayList<ItemStack>();
        list.clear();
        for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
            if (!list.contains(getStackInSlot(i))) {
                list.add(getStackInSlot(i));
            }
            else if (getStackInSlot(i) == getStackInSlot(n)) {
                return true;
            }
        }
        return false;
    }
    
    public int getBestWeaponInHotbar() {
        final int field_70461_c = Class123.mc.field_71439_g.field_71071_by.field_70461_c;
        int n = -1;
        float n2 = 1.0f;
        for (int i = 0; i < 9; i = (byte)(i + 1)) {
            final ItemStack func_70301_a = Class123.mc.field_71439_g.field_71071_by.func_70301_a(i);
            final float n3;
            if (func_70301_a != null && (n3 = getItemDamage(func_70301_a) + EnchantmentHelper.func_152377_a(func_70301_a, EnumCreatureAttribute.UNDEFINED)) > n2) {
                n2 = n3;
                n = i;
            }
        }
        if (n != -1) {
            return n;
        }
        return field_70461_c;
    }
    
    public int getBestWeapon() {
        final int field_70461_c = Class123.mc.field_71439_g.field_71071_by.field_70461_c;
        int n = -1;
        float n2 = 1.0f;
        for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); i = (byte)(i + 1)) {
            final ItemStack stackInSlot;
            final float n3;
            if (getStackInSlot(i) != null && (stackInSlot = getStackInSlot(i)) != null && stackInSlot.func_77973_b() != null && stackInSlot.func_77973_b() instanceof ItemSword && (n3 = getItemDamage(stackInSlot) + EnchantmentHelper.func_152377_a(stackInSlot, EnumCreatureAttribute.UNDEFINED)) > n2) {
                n2 = n3;
                n = i;
            }
        }
        if (n != -1) {
            return n;
        }
        return field_70461_c;
    }
    
    public int getArmorProt(final int n) {
        int n2 = -1;
        if (getStackInSlot(n) != null && getStackInSlot(n).func_77973_b() != null && getStackInSlot(n).func_77973_b() instanceof ItemArmor) {
            n2 = ((ItemArmor)Class123.mc.field_71439_g.field_71071_by.func_70301_a(n).func_77973_b()).func_82812_d().func_78044_b(getItemType(Class123.mc.field_71439_g.field_71071_by.func_70301_a(n))) + EnchantmentHelper.func_77508_a(new ItemStack[] { Class123.mc.field_71439_g.field_71071_by.func_70301_a(n) }, DamageSource.field_76377_j);
        }
        return n2;
    }
    
    public static int getFirstItem(final Item item) {
        for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
            if (getStackInSlot(i) != null && getStackInSlot(i).func_77973_b() != null && getStackInSlot(i).func_77973_b() == item) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean isBestSword(final ItemStack itemStack, final int n) {
        if (itemStack != null && itemStack.func_77973_b() instanceof ItemSword) {
            for (int i = 0; i < Class123.mc.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
                final ItemStack func_70301_a = Class123.mc.field_71439_g.field_71071_by.func_70301_a(i);
                if (func_70301_a != null && func_70301_a.func_77973_b() instanceof ItemSword && getItemDamage(func_70301_a) >= getItemDamage(itemStack) && n != i) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static {
        Class123.mc = Minecraft.func_71410_x();
    }
}
