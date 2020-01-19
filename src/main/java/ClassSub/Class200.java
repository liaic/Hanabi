package ClassSub;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.util.*;

public class Class200
{
    private static Minecraft mc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class200() {
        super();
    }
    
    public static Entity getEntity(final double n) {
        return (getEntity(n, 0.0, 0.0f) == null) ? null : ((Entity)((Object[])getEntity(n, 0.0, 0.0f))[0]);
    }
    
    public static Object[] getEntity(final double n, final double n2, final float n3) {
        final Entity func_175606_aa = Class200.mc.func_175606_aa();
        Object o = null;
        if (func_175606_aa == null || Class200.mc.field_71441_e == null) {
            return null;
        }
        Class200.mc.field_71424_I.func_76320_a("pick");
        final Vec3 func_174824_e = func_175606_aa.func_174824_e(0.0f);
        final Vec3 func_70676_i = func_175606_aa.func_70676_i(0.0f);
        final Vec3 func_72441_c = func_174824_e.func_72441_c(func_70676_i.field_72450_a * n, func_70676_i.field_72448_b * n, func_70676_i.field_72449_c * n);
        Object o2 = null;
        final float n4 = 1.0f;
        final List func_72839_b = Class200.mc.field_71441_e.func_72839_b(func_175606_aa, func_175606_aa.func_174813_aQ().func_72321_a(func_70676_i.field_72450_a * n, func_70676_i.field_72448_b * n, func_70676_i.field_72449_c * n).func_72314_b((double)n4, (double)n4, (double)n4));
        double n5 = n;
        for (int i = 0; i < func_72839_b.size(); ++i) {
            final Entity entity = (Entity)func_72839_b.get(i);
            if (entity.func_70067_L()) {
                final float func_70111_Y = entity.func_70111_Y();
                final AxisAlignedBB func_72314_b = entity.func_174813_aQ().func_72314_b((double)func_70111_Y, (double)func_70111_Y, (double)func_70111_Y).func_72314_b(n2, n2, n2);
                final MovingObjectPosition func_72327_a = func_72314_b.func_72327_a(func_174824_e, func_72441_c);
                if (func_72314_b.func_72318_a(func_174824_e)) {
                    if (0.0 < n5 || n5 == 0.0) {
                        o = entity;
                        o2 = ((func_72327_a == null) ? func_174824_e : func_72327_a.field_72307_f);
                        n5 = 0.0;
                    }
                }
                else if (func_72327_a != null) {
                    final double func_72438_d = func_174824_e.func_72438_d(func_72327_a.field_72307_f);
                    if (func_72438_d < n5 || n5 == 0.0) {
                        final boolean b = false;
                        if (entity == func_175606_aa.field_70154_o && !b) {
                            if (n5 == 0.0) {
                                o = entity;
                                o2 = func_72327_a.field_72307_f;
                            }
                        }
                        else {
                            o = entity;
                            o2 = func_72327_a.field_72307_f;
                            n5 = func_72438_d;
                        }
                    }
                }
            }
        }
        if (n5 < n && !(o instanceof EntityLivingBase) && !(o instanceof EntityItemFrame)) {
            o = null;
        }
        Class200.mc.field_71424_I.func_76319_b();
        if (o != null && o2 != null) {
            return new Object[] { o, o2 };
        }
        return null;
    }
    
    static {
        Class200.mc = Minecraft.func_71410_x();
    }
}
