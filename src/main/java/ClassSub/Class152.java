package ClassSub;

import net.minecraft.client.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.*;
import net.minecraft.potion.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.entity.item.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;

public class Class152
{
    private static Minecraft mc;
    private static Random rand;
    public static boolean spectator;
    public static ArrayList<Integer> blackList;
    static double x;
    static double y;
    static double z;
    static double xPreEn;
    static double yPreEn;
    static double zPreEn;
    static double xPre;
    static double yPre;
    static double zPre;
    private static Vec3 lastLoc;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class152() {
        super();
    }
    
    private static void preInfiniteReach(final double n, final double n2, final double n3, final ArrayList<Vec3> list, final ArrayList<Vec3> list2, final Vec3 vec3, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
    }
    
    private static void postInfiniteReach() {
    }
    
    public static boolean infiniteReach(final double n, final double n2, final double n3, final ArrayList<Vec3> list, final ArrayList<Vec3> list2, final EntityLivingBase entityLivingBase) {
        int n4 = 0;
        Class152.xPreEn = entityLivingBase.field_70165_t;
        Class152.yPreEn = entityLivingBase.field_70163_u;
        Class152.zPreEn = entityLivingBase.field_70161_v;
        Class152.xPre = Class152.mc.field_71439_g.field_70165_t;
        Class152.yPre = Class152.mc.field_71439_g.field_70163_u;
        Class152.zPre = Class152.mc.field_71439_g.field_70161_v;
        int n5 = 1;
        boolean b = false;
        final boolean func_70093_af = Class152.mc.field_71439_g.func_70093_af();
        list2.clear();
        list.clear();
        final double n6 = n2 / n;
        int n7 = 0;
        for (int n8 = 0; n8 < n; ++n8) {
            ++n7;
            if (n2 * n7 > n) {
                break;
            }
        }
        MovingObjectPosition movingObjectPosition = null;
        if (rayTraceWide(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v), false, false, true) || (movingObjectPosition = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), Class152.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), entityLivingBase.field_70161_v), false, false, true)) != null) {
            final MovingObjectPosition rayTracePos;
            if ((rayTracePos = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, Class152.mc.field_71439_g.field_70163_u, entityLivingBase.field_70161_v), false, false, true)) != null || (movingObjectPosition = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), Class152.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), entityLivingBase.field_70161_v), false, false, true)) != null) {
                MovingObjectPosition movingObjectPosition2 = null;
                if (rayTracePos == null) {
                    movingObjectPosition2 = movingObjectPosition;
                }
                if (movingObjectPosition == null) {
                    movingObjectPosition2 = rayTracePos;
                }
                if (movingObjectPosition2 != null) {
                    if (movingObjectPosition2.func_178782_a() == null) {
                        return false;
                    }
                    final BlockPos func_178782_a = movingObjectPosition2.func_178782_a();
                    b = true;
                    Class152.y = func_178782_a.func_177984_a().func_177956_o();
                    Class152.yPreEn = func_178782_a.func_177984_a().func_177956_o();
                    Block block = null;
                    Boolean b2 = false;
                    for (int n9 = 0; n9 < n3; ++n9) {
                        final MovingObjectPosition rayTracePos2 = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, (double)(func_178782_a.func_177956_o() + n9), Class152.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, (double)(func_178782_a.func_177956_o() + n9), entityLivingBase.field_70161_v), false, false, true);
                        if (rayTracePos2 != null) {
                            if (rayTracePos2.func_178782_a() != null) {
                                final Block func_177230_c = Class152.mc.field_71441_e.func_180495_p(rayTracePos2.func_178782_a()).func_177230_c();
                                if (func_177230_c.func_149688_o() == Material.field_151579_a) {
                                    final boolean b3 = block instanceof BlockFence;
                                    Class152.y = func_178782_a.func_177956_o() + n9;
                                    Class152.yPreEn = func_178782_a.func_177956_o() + n9;
                                    if (b3) {
                                        ++Class152.y;
                                        ++Class152.yPreEn;
                                        if (n9 + 1 > n3) {
                                            b2 = false;
                                            break;
                                        }
                                    }
                                    b2 = true;
                                    break;
                                }
                                block = func_177230_c;
                            }
                        }
                    }
                    final double n10 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                    final double n11 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                    if (!(boolean)b2) {
                        return false;
                    }
                }
            }
            else {
                final MovingObjectPosition rayTracePos3 = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v), false, false, false);
                if (rayTracePos3 != null && rayTracePos3.field_72308_g == null) {
                    Class152.y = Class152.mc.field_71439_g.field_70163_u;
                    Class152.yPreEn = Class152.mc.field_71439_g.field_70163_u;
                }
                else {
                    Class152.y = Class152.mc.field_71439_g.field_70163_u;
                    Class152.yPreEn = entityLivingBase.field_70163_u;
                }
            }
        }
        if (n5 == 0) {
            return false;
        }
        if (func_70093_af) {
            Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.STOP_SNEAKING));
        }
        for (int i = 0; i < n7; ++i) {
            ++n4;
            if (i == 1 && b) {
                Class152.x = Class152.mc.field_71439_g.field_70165_t;
                Class152.y = Class152.yPreEn;
                Class152.z = Class152.mc.field_71439_g.field_70161_v;
                sendPacket(false, list, list2);
            }
            if (i != n7 - 1) {
                final double n12 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                final double n13 = Class152.mc.field_71439_g.field_70163_u - Class152.yPreEn;
                final double n14 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                final double n15 = n6 * i;
                Class152.x = Class152.mc.field_71439_g.field_70165_t - n12 * n15;
                Class152.y = Class152.mc.field_71439_g.field_70163_u - n13 * (b ? 1.0 : n15);
                Class152.z = Class152.mc.field_71439_g.field_70161_v - n14 * n15;
                sendPacket(false, list, list2);
            }
            else {
                final double n16 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                final double n17 = Class152.mc.field_71439_g.field_70163_u - Class152.yPreEn;
                final double n18 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                final double n19 = n6 * i;
                Class152.x = Class152.mc.field_71439_g.field_70165_t - n16 * n19;
                Class152.y = Class152.mc.field_71439_g.field_70163_u - n17 * (b ? 1.0 : n19);
                Class152.z = Class152.mc.field_71439_g.field_70161_v - n18 * n19;
                sendPacket(false, list, list2);
                final double n20 = Class152.x - Class152.xPreEn;
                final double n21 = Class152.z - Class152.zPreEn;
                final double n22 = Class152.y - entityLivingBase.field_70163_u;
                final double sqrt = Math.sqrt(n20 * n20 + n21 * n21);
                if (sqrt > 4.0) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = Class152.yPreEn;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                }
                else if (sqrt > 0.05 && b) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = Class152.yPreEn;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                }
                if (Math.abs(n22) < n3 && Class152.mc.field_71439_g.func_70032_d((Entity)entityLivingBase) >= 4.0f) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = entityLivingBase.field_70163_u;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                    attackInf(entityLivingBase);
                }
                else {
                    n5 = 0;
                }
            }
        }
        for (int j = list2.size() - 2; j > -1; --j) {
            Class152.x = ((Vec3)list2.get(j)).field_72450_a;
            Class152.y = ((Vec3)list2.get(j)).field_72448_b;
            Class152.z = ((Vec3)list2.get(j)).field_72449_c;
            sendPacket(false, list, list2);
        }
        Class152.x = Class152.mc.field_71439_g.field_70165_t;
        Class152.y = Class152.mc.field_71439_g.field_70163_u;
        Class152.z = Class152.mc.field_71439_g.field_70161_v;
        sendPacket(false, list, list2);
        if (n5 == 0) {
            if (func_70093_af) {
                Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.START_SNEAKING));
            }
            list2.clear();
            list.clear();
            return false;
        }
        if (func_70093_af) {
            Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.START_SNEAKING));
        }
        return true;
    }
    
    public static boolean infiniteReach(final double n, final double n2, final double n3, final ArrayList<Vec3> list, final ArrayList<Vec3> list2, final BlockPos blockPos) {
        list2.clear();
        list.clear();
        final double n4 = n2 / n;
        int n5 = 0;
        for (int n6 = 0; n6 < n; ++n6) {
            ++n5;
            if (n2 * n5 > n) {
                break;
            }
        }
        int n7 = 0;
        final double xPreEn = blockPos.func_177958_n() + 0.5;
        final double y = blockPos.func_177956_o() + 1.0;
        final double zPreEn = blockPos.func_177952_p() + 0.5;
        Class152.xPreEn = xPreEn;
        Class152.yPreEn = y;
        Class152.zPreEn = zPreEn;
        Class152.xPre = Class152.mc.field_71439_g.field_70165_t;
        Class152.yPre = Class152.mc.field_71439_g.field_70163_u;
        Class152.zPre = Class152.mc.field_71439_g.field_70161_v;
        int n8 = 1;
        boolean b = false;
        final boolean func_70093_af = Class152.mc.field_71439_g.func_70093_af();
        MovingObjectPosition movingObjectPosition = null;
        if (rayTraceWide(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, y, zPreEn), false, false, true) || (movingObjectPosition = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), Class152.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, y + Class152.mc.field_71439_g.func_70047_e(), zPreEn), false, false, true)) != null) {
            final MovingObjectPosition rayTracePos;
            if ((rayTracePos = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, Class152.mc.field_71439_g.field_70163_u, zPreEn), false, false, true)) != null || (movingObjectPosition = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), Class152.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), zPreEn), false, false, true)) != null) {
                MovingObjectPosition movingObjectPosition2 = null;
                if (rayTracePos == null) {
                    movingObjectPosition2 = movingObjectPosition;
                }
                if (movingObjectPosition == null) {
                    movingObjectPosition2 = rayTracePos;
                }
                if (movingObjectPosition2 != null) {
                    if (movingObjectPosition2.func_178782_a() == null) {
                        return false;
                    }
                    final BlockPos func_178782_a = movingObjectPosition2.func_178782_a();
                    b = true;
                    Class152.y = func_178782_a.func_177984_a().func_177956_o();
                    Class152.yPreEn = func_178782_a.func_177984_a().func_177956_o();
                    Block block = null;
                    Boolean b2 = false;
                    for (int n9 = 0; n9 < n3; ++n9) {
                        final MovingObjectPosition rayTracePos2 = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, (double)(func_178782_a.func_177956_o() + n9), Class152.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, (double)(func_178782_a.func_177956_o() + n9), zPreEn), false, false, true);
                        if (rayTracePos2 != null) {
                            if (rayTracePos2.func_178782_a() != null) {
                                final Block func_177230_c = Class152.mc.field_71441_e.func_180495_p(rayTracePos2.func_178782_a()).func_177230_c();
                                if (func_177230_c.func_149688_o() == Material.field_151579_a) {
                                    final boolean b3 = block instanceof BlockFence;
                                    Class152.y = func_178782_a.func_177956_o() + n9;
                                    Class152.yPreEn = func_178782_a.func_177956_o() + n9;
                                    if (b3) {
                                        ++Class152.y;
                                        ++Class152.yPreEn;
                                        if (n9 + 1 > n3) {
                                            b2 = false;
                                            break;
                                        }
                                    }
                                    b2 = true;
                                    break;
                                }
                                block = func_177230_c;
                            }
                        }
                    }
                    final double n10 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                    final double n11 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                    if (!(boolean)b2) {
                        return false;
                    }
                }
            }
            else {
                final MovingObjectPosition rayTracePos3 = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, y, zPreEn), false, false, false);
                if (rayTracePos3 != null && rayTracePos3.field_72308_g == null) {
                    Class152.y = Class152.mc.field_71439_g.field_70163_u;
                    Class152.yPreEn = Class152.mc.field_71439_g.field_70163_u;
                }
                else {
                    Class152.y = Class152.mc.field_71439_g.field_70163_u;
                    Class152.yPreEn = y;
                }
            }
        }
        if (n8 == 0) {
            return false;
        }
        if (func_70093_af) {
            Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.STOP_SNEAKING));
        }
        for (int i = 0; i < n5; ++i) {
            ++n7;
            if (i == 1 && b) {
                Class152.x = Class152.mc.field_71439_g.field_70165_t;
                Class152.y = Class152.yPreEn;
                Class152.z = Class152.mc.field_71439_g.field_70161_v;
                sendPacket(false, list, list2);
            }
            if (i != n5 - 1) {
                final double n12 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                final double n13 = Class152.mc.field_71439_g.field_70163_u - Class152.yPreEn;
                final double n14 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                final double n15 = n4 * i;
                Class152.x = Class152.mc.field_71439_g.field_70165_t - n12 * n15;
                Class152.y = Class152.mc.field_71439_g.field_70163_u - n13 * (b ? 1.0 : n15);
                Class152.z = Class152.mc.field_71439_g.field_70161_v - n14 * n15;
                sendPacket(false, list, list2);
            }
            else {
                final double n16 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                final double n17 = Class152.mc.field_71439_g.field_70163_u - Class152.yPreEn;
                final double n18 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                final double n19 = n4 * i;
                Class152.x = Class152.mc.field_71439_g.field_70165_t - n16 * n19;
                Class152.y = Class152.mc.field_71439_g.field_70163_u - n17 * (b ? 1.0 : n19);
                Class152.z = Class152.mc.field_71439_g.field_70161_v - n18 * n19;
                sendPacket(false, list, list2);
                final double n20 = Class152.x - Class152.xPreEn;
                final double n21 = Class152.z - Class152.zPreEn;
                final double n22 = Class152.y - y;
                final double sqrt = Math.sqrt(n20 * n20 + n21 * n21);
                if (sqrt > 4.0) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = Class152.yPreEn;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                }
                else if (sqrt > 0.05 && b) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = Class152.yPreEn;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                }
                if (Math.abs(n22) < n3 && Class152.mc.field_71439_g.func_70011_f(xPreEn, y, zPreEn) >= 4.0) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = y;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                    Class152.mc.field_71439_g.func_71038_i();
                    Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, EnumFacing.UP));
                    Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.UP));
                }
                else {
                    n8 = 0;
                }
            }
        }
        for (int j = list2.size() - 2; j > -1; --j) {
            Class152.x = ((Vec3)list2.get(j)).field_72450_a;
            Class152.y = ((Vec3)list2.get(j)).field_72448_b;
            Class152.z = ((Vec3)list2.get(j)).field_72449_c;
            sendPacket(false, list, list2);
        }
        Class152.x = Class152.mc.field_71439_g.field_70165_t;
        Class152.y = Class152.mc.field_71439_g.field_70163_u;
        Class152.z = Class152.mc.field_71439_g.field_70161_v;
        sendPacket(false, list, list2);
        if (n8 == 0) {
            if (func_70093_af) {
                Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.START_SNEAKING));
            }
            list2.clear();
            list.clear();
            return false;
        }
        if (func_70093_af) {
            Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.START_SNEAKING));
        }
        return true;
    }
    
    public static boolean infiniteReach(final Vec3 vec3, final Vec3 vec4, final double n, final double n2, final double n3, final ArrayList<Vec3> list, final ArrayList<Vec3> list2) {
        list2.clear();
        list.clear();
        final double n4 = n2 / n;
        int n5 = 0;
        for (int n6 = 0; n6 < n; ++n6) {
            ++n5;
            if (n2 * n5 > n) {
                break;
            }
        }
        int n7 = 0;
        Class152.xPreEn = vec4.field_72450_a;
        Class152.yPreEn = vec4.field_72448_b;
        Class152.zPreEn = vec4.field_72449_c;
        Class152.xPre = Class152.mc.field_71439_g.field_70165_t;
        Class152.yPre = Class152.mc.field_71439_g.field_70163_u;
        Class152.zPre = Class152.mc.field_71439_g.field_70161_v;
        int n8 = 1;
        boolean b = false;
        final boolean func_70093_af = Class152.mc.field_71439_g.func_70093_af();
        MovingObjectPosition movingObjectPosition = null;
        if (rayTraceWide(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(vec4.field_72450_a, vec4.field_72448_b, vec4.field_72449_c), false, false, true) || (movingObjectPosition = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), Class152.mc.field_71439_g.field_70161_v), new Vec3(vec4.field_72450_a, vec4.field_72448_b + Class152.mc.field_71439_g.func_70047_e(), vec4.field_72449_c), false, false, true)) != null) {
            final MovingObjectPosition rayTracePos;
            if ((rayTracePos = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(vec4.field_72450_a, Class152.mc.field_71439_g.field_70163_u, vec4.field_72449_c), false, false, true)) != null || (movingObjectPosition = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), Class152.mc.field_71439_g.field_70161_v), new Vec3(vec4.field_72450_a, Class152.mc.field_71439_g.field_70163_u + Class152.mc.field_71439_g.func_70047_e(), vec4.field_72449_c), false, false, true)) != null) {
                MovingObjectPosition movingObjectPosition2 = null;
                if (rayTracePos == null) {
                    movingObjectPosition2 = movingObjectPosition;
                }
                if (movingObjectPosition == null) {
                    movingObjectPosition2 = rayTracePos;
                }
                if (movingObjectPosition2 != null) {
                    if (movingObjectPosition2.func_178782_a() == null) {
                        return false;
                    }
                    final BlockPos func_178782_a = movingObjectPosition2.func_178782_a();
                    b = true;
                    Class152.y = func_178782_a.func_177984_a().func_177956_o();
                    Class152.yPreEn = func_178782_a.func_177984_a().func_177956_o();
                    Block block = null;
                    Boolean b2 = false;
                    for (int n9 = 0; n9 < n3; ++n9) {
                        final MovingObjectPosition rayTracePos2 = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, (double)(func_178782_a.func_177956_o() + n9), Class152.mc.field_71439_g.field_70161_v), new Vec3(vec4.field_72450_a, (double)(func_178782_a.func_177956_o() + n9), vec4.field_72449_c), false, false, true);
                        if (rayTracePos2 != null) {
                            if (rayTracePos2.func_178782_a() != null) {
                                final Block func_177230_c = Class152.mc.field_71441_e.func_180495_p(rayTracePos2.func_178782_a()).func_177230_c();
                                if (func_177230_c.func_149688_o() == Material.field_151579_a) {
                                    final boolean b3 = block instanceof BlockFence;
                                    Class152.y = func_178782_a.func_177956_o() + n9;
                                    Class152.yPreEn = func_178782_a.func_177956_o() + n9;
                                    if (b3) {
                                        ++Class152.y;
                                        ++Class152.yPreEn;
                                        if (n9 + 1 > n3) {
                                            b2 = false;
                                            break;
                                        }
                                    }
                                    b2 = true;
                                    break;
                                }
                                block = func_177230_c;
                            }
                        }
                    }
                    final double n10 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                    final double n11 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                    if (!(boolean)b2) {
                        return false;
                    }
                }
            }
            else {
                final MovingObjectPosition rayTracePos3 = rayTracePos(new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v), new Vec3(vec4.field_72450_a, vec4.field_72448_b, vec4.field_72449_c), false, false, false);
                if (rayTracePos3 != null && rayTracePos3.field_72308_g == null) {
                    Class152.y = Class152.mc.field_71439_g.field_70163_u;
                    Class152.yPreEn = Class152.mc.field_71439_g.field_70163_u;
                }
                else {
                    Class152.y = Class152.mc.field_71439_g.field_70163_u;
                    Class152.yPreEn = vec4.field_72448_b;
                }
            }
        }
        if (n8 == 0) {
            return false;
        }
        if (func_70093_af) {
            Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.STOP_SNEAKING));
        }
        for (int i = 0; i < n5; ++i) {
            ++n7;
            if (i == 1 && b) {
                Class152.x = Class152.mc.field_71439_g.field_70165_t;
                Class152.y = Class152.yPreEn;
                Class152.z = Class152.mc.field_71439_g.field_70161_v;
                sendPacket(false, list, list2);
            }
            if (i != n5 - 1) {
                final double n12 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                final double n13 = Class152.mc.field_71439_g.field_70163_u - Class152.yPreEn;
                final double n14 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                final double n15 = n4 * i;
                Class152.x = Class152.mc.field_71439_g.field_70165_t - n12 * n15;
                Class152.y = Class152.mc.field_71439_g.field_70163_u - n13 * (b ? 1.0 : n15);
                Class152.z = Class152.mc.field_71439_g.field_70161_v - n14 * n15;
                sendPacket(false, list, list2);
            }
            else {
                final double n16 = Class152.mc.field_71439_g.field_70165_t - Class152.xPreEn;
                final double n17 = Class152.mc.field_71439_g.field_70163_u - Class152.yPreEn;
                final double n18 = Class152.mc.field_71439_g.field_70161_v - Class152.zPreEn;
                final double n19 = n4 * i;
                Class152.x = Class152.mc.field_71439_g.field_70165_t - n16 * n19;
                Class152.y = Class152.mc.field_71439_g.field_70163_u - n17 * (b ? 1.0 : n19);
                Class152.z = Class152.mc.field_71439_g.field_70161_v - n18 * n19;
                sendPacket(false, list, list2);
                final double n20 = Class152.x - Class152.xPreEn;
                final double n21 = Class152.z - Class152.zPreEn;
                final double n22 = Class152.y - vec4.field_72448_b;
                final double sqrt = Math.sqrt(n20 * n20 + n21 * n21);
                if (sqrt > 4.0) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = Class152.yPreEn;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                }
                else if (sqrt > 0.05 && b) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = Class152.yPreEn;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                }
                if (Math.abs(n22) < n3) {
                    Class152.x = Class152.xPreEn;
                    Class152.y = vec4.field_72448_b;
                    Class152.z = Class152.zPreEn;
                    sendPacket(false, list, list2);
                }
                else {
                    n8 = 0;
                }
            }
        }
        for (int j = list2.size() - 2; j > -1; --j) {
            Class152.x = ((Vec3)list2.get(j)).field_72450_a;
            Class152.y = ((Vec3)list2.get(j)).field_72448_b;
            Class152.z = ((Vec3)list2.get(j)).field_72449_c;
            sendPacket(false, list, list2);
        }
        Class152.x = Class152.mc.field_71439_g.field_70165_t;
        Class152.y = Class152.mc.field_71439_g.field_70163_u;
        Class152.z = Class152.mc.field_71439_g.field_70161_v;
        sendPacket(false, list, list2);
        if (n8 == 0) {
            if (func_70093_af) {
                Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.START_SNEAKING));
            }
            list2.clear();
            list.clear();
            return false;
        }
        if (func_70093_af) {
            Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class152.mc.field_71439_g, C0BPacketEntityAction.Action.START_SNEAKING));
        }
        return true;
    }
    
    public static void attackInf(final EntityLivingBase entityLivingBase) {
        Class152.mc.field_71439_g.func_71038_i();
        Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C02PacketUseEntity((Entity)entityLivingBase, C02PacketUseEntity.Action.ATTACK));
        final float func_152377_a = EnchantmentHelper.func_152377_a(Class152.mc.field_71439_g.func_70694_bm(), entityLivingBase.func_70668_bt());
        final boolean b = Class152.mc.field_71439_g.field_70143_R > 0.0f && !Class152.mc.field_71439_g.field_70122_E && !Class152.mc.field_71439_g.func_70617_f_() && !Class152.mc.field_71439_g.func_70090_H() && !Class152.mc.field_71439_g.func_70644_a(Potion.field_76440_q) && Class152.mc.field_71439_g.field_70154_o == null;
        if (func_152377_a > 0.0f) {
            Class152.mc.field_71439_g.func_71047_c((Entity)entityLivingBase);
        }
    }
    
    public static void sendPacket(final boolean b, final ArrayList<Vec3> list, final ArrayList<Vec3> list2) {
        Class152.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(Class152.x, Class152.y, Class152.z, true));
        list2.add(new Vec3(Class152.x, Class152.y, Class152.z));
    }
    
    public static MovingObjectPosition rayTracePos(final Vec3 vec3, final Vec3 vec4, final boolean b, final boolean b2, final boolean b3) {
        final float n = ((float[])getFacePosRemote(vec4, vec3))[0];
        final double radians = Math.toRadians(normalizeAngle(n));
        final double radians2 = Math.toRadians(normalizeAngle(n) + 180.0f);
        final double n2 = 2.1;
        final double n3 = 2.1;
        final Vec3 vec5 = new Vec3(vec3.field_72450_a + Math.cos(radians) * n2, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians) * n2);
        final Vec3 vec6 = new Vec3(vec3.field_72450_a + Math.cos(radians2) * n2, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians2) * n2);
        final Vec3 vec7 = new Vec3(vec4.field_72450_a + Math.cos(radians) * n2, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians) * n2);
        final Vec3 vec8 = new Vec3(vec4.field_72450_a + Math.cos(radians2) * n2, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians2) * n2);
        final Vec3 vec9 = new Vec3(vec3.field_72450_a + Math.cos(radians) * n3, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians) * n3);
        final Vec3 vec10 = new Vec3(vec3.field_72450_a + Math.cos(radians2) * n3, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians2) * n3);
        final Vec3 vec11 = new Vec3(vec4.field_72450_a + Math.cos(radians) * n3, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians) * n3);
        final Vec3 vec12 = new Vec3(vec4.field_72450_a + Math.cos(radians2) * n3, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians2) * n3);
        final MovingObjectPosition func_147447_a = Class152.mc.field_71441_e.func_147447_a(vec5, vec7, b, b2, b3);
        final MovingObjectPosition func_147447_a2 = Class152.mc.field_71441_e.func_147447_a(vec3, vec4, b, b2, b3);
        final MovingObjectPosition func_147447_a3 = Class152.mc.field_71441_e.func_147447_a(vec6, vec8, b, b2, b3);
        final MovingObjectPosition movingObjectPosition = null;
        final MovingObjectPosition movingObjectPosition2 = null;
        if (func_147447_a2 != null || func_147447_a != null || func_147447_a3 != null || movingObjectPosition != null || movingObjectPosition2 != null) {
            if (b3) {
                if (movingObjectPosition2 != null && (getBlock(movingObjectPosition2.func_178782_a()).func_149688_o() != Material.field_151579_a || movingObjectPosition2.field_72308_g != null)) {
                    return movingObjectPosition2;
                }
                if (movingObjectPosition != null && (getBlock(movingObjectPosition.func_178782_a()).func_149688_o() != Material.field_151579_a || movingObjectPosition.field_72308_g != null)) {
                    return movingObjectPosition;
                }
                if (func_147447_a3 != null && (getBlock(func_147447_a3.func_178782_a()).func_149688_o() != Material.field_151579_a || func_147447_a3.field_72308_g != null)) {
                    return func_147447_a3;
                }
                if (func_147447_a != null && (getBlock(func_147447_a.func_178782_a()).func_149688_o() != Material.field_151579_a || func_147447_a.field_72308_g != null)) {
                    return func_147447_a;
                }
                if (func_147447_a2 != null && (getBlock(func_147447_a2.func_178782_a()).func_149688_o() != Material.field_151579_a || func_147447_a2.field_72308_g != null)) {
                    return func_147447_a2;
                }
            }
            else {
                if (movingObjectPosition2 != null) {
                    return movingObjectPosition2;
                }
                if (movingObjectPosition != null) {
                    return movingObjectPosition;
                }
                if (func_147447_a3 != null) {
                    return func_147447_a3;
                }
                if (func_147447_a != null) {
                    return func_147447_a;
                }
                if (func_147447_a2 != null) {
                    return func_147447_a2;
                }
            }
        }
        if (func_147447_a2 != null) {
            return func_147447_a2;
        }
        if (func_147447_a3 != null) {
            return func_147447_a3;
        }
        if (func_147447_a != null) {
            return func_147447_a;
        }
        if (movingObjectPosition2 != null) {
            return movingObjectPosition2;
        }
        if (movingObjectPosition == null) {
            return null;
        }
        return movingObjectPosition;
    }
    
    public static boolean rayTraceWide(final Vec3 vec3, final Vec3 vec4, final boolean b, final boolean b2, final boolean b3) {
        final float func_76142_g = MathHelper.func_76142_g(normalizeAngle(((float[])getFacePosRemote(vec4, vec3))[0]) + 180.0f);
        final double radians = Math.toRadians(func_76142_g);
        final double radians2 = Math.toRadians(func_76142_g + 180.0f);
        final double n = 2.1;
        final double n2 = 2.1;
        final Vec3 vec5 = new Vec3(vec3.field_72450_a + Math.cos(radians) * n, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians) * n);
        final Vec3 vec6 = new Vec3(vec3.field_72450_a + Math.cos(radians2) * n, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians2) * n);
        final Vec3 vec7 = new Vec3(vec4.field_72450_a + Math.cos(radians) * n, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians) * n);
        final Vec3 vec8 = new Vec3(vec4.field_72450_a + Math.cos(radians2) * n, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians2) * n);
        final Vec3 vec9 = new Vec3(vec3.field_72450_a + Math.cos(radians) * n2, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians) * n2);
        final Vec3 vec10 = new Vec3(vec3.field_72450_a + Math.cos(radians2) * n2, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians2) * n2);
        final Vec3 vec11 = new Vec3(vec4.field_72450_a + Math.cos(radians) * n2, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians) * n2);
        final Vec3 vec12 = new Vec3(vec4.field_72450_a + Math.cos(radians2) * n2, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians2) * n2);
        final MovingObjectPosition func_147447_a = Class152.mc.field_71441_e.func_147447_a(vec5, vec7, b, b2, b3);
        final MovingObjectPosition func_147447_a2 = Class152.mc.field_71441_e.func_147447_a(vec3, vec4, b, b2, b3);
        final MovingObjectPosition func_147447_a3 = Class152.mc.field_71441_e.func_147447_a(vec6, vec8, b, b2, b3);
        final MovingObjectPosition movingObjectPosition = null;
        final MovingObjectPosition movingObjectPosition2 = null;
        if (b3) {
            return (func_147447_a != null && getBlock(func_147447_a.func_178782_a()).func_149688_o() != Material.field_151579_a) || (func_147447_a2 != null && getBlock(func_147447_a2.func_178782_a()).func_149688_o() != Material.field_151579_a) || (func_147447_a3 != null && getBlock(func_147447_a3.func_178782_a()).func_149688_o() != Material.field_151579_a) || (movingObjectPosition != null && getBlock(movingObjectPosition.func_178782_a()).func_149688_o() != Material.field_151579_a) || (movingObjectPosition2 != null && getBlock(movingObjectPosition2.func_178782_a()).func_149688_o() != Material.field_151579_a);
        }
        return func_147447_a != null || func_147447_a2 != null || func_147447_a3 != null || movingObjectPosition2 != null || movingObjectPosition != null;
    }
    
    public static void blinkToPosFromPos(final Vec3 vec3, final Vec3 vec4, final double n) {
        final double n2 = vec3.field_72450_a - vec4.field_72450_a;
        final double n3 = vec3.field_72448_b - vec4.field_72448_b;
        final double n4 = vec3.field_72449_c - vec4.field_72449_c;
        final double field_72450_a = vec3.field_72450_a;
        final double field_72448_b = vec3.field_72448_b;
        final double field_72449_c = vec3.field_72449_c;
        final double field_72450_a2 = vec4.field_72450_a;
        final double field_72448_b2 = vec4.field_72448_b;
        final double field_72449_c2 = vec4.field_72449_c;
        final double sqrt = Math.sqrt(n2 * n2 + n3 * n3 + n4 * n4);
        final double n5 = n / sqrt;
        int n6 = 0;
        for (int n7 = 0; n7 < sqrt; ++n7) {
            ++n6;
            if (n * n6 > sqrt) {
                break;
            }
        }
        for (int i = 0; i < n6; ++i) {
            final double n8 = field_72450_a - field_72450_a2;
            final double n9 = field_72448_b - field_72448_b2;
            final double n10 = field_72449_c - field_72449_c2;
            final double n11 = n5 * i;
            Class152.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(field_72450_a - n8 * n11, field_72448_b - n9 * n11, field_72449_c - n10 * n11, true));
        }
        Class152.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(field_72450_a2, field_72448_b2, field_72449_c2, true));
    }
    
    public static boolean isBlacklisted(final Entity entity) {
        final Iterator<Integer> iterator = Class152.blackList.iterator();
        while (iterator.hasNext()) {
            if (entity.func_145782_y() == iterator.next()) {
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList<EntityLivingBase> getClosestEntitiesToEntity(final float n, final Entity entity) {
        final ArrayList<Entity> list = (ArrayList<Entity>)new ArrayList<EntityLivingBase>();
        for (final EntityLivingBase next : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (isNotItem(next) && !entity.func_70028_i((Entity)(EntityLivingBase)next)) {
                final EntityLivingBase entityLivingBase = (EntityLivingBase)next;
                if (entity.func_70032_d((Entity)entityLivingBase) >= n) {
                    continue;
                }
                list.add(entityLivingBase);
            }
        }
        return (ArrayList<EntityLivingBase>)list;
    }
    
    public float getDistanceToEntityFromEntity(final Entity entity, final Entity entity2) {
        final float n = (float)(entity.field_70165_t - entity2.field_70165_t);
        final float n2 = (float)(entity.field_70163_u - entity2.field_70163_u);
        final float n3 = (float)(entity.field_70161_v - entity2.field_70161_v);
        return MathHelper.func_76129_c(n * n + n2 * n2 + n3 * n3);
    }
    
    public static ArrayList<EntityLivingBase> getClosestEntities(final float n) {
        final ArrayList<Entity> list = (ArrayList<Entity>)new ArrayList<EntityLivingBase>();
        for (final EntityLivingBase next : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (isNotItem(next) && !(next instanceof EntityPlayerSP)) {
                final EntityLivingBase entityLivingBase = (EntityLivingBase)next;
                if (!validEntity((Entity)entityLivingBase)) {
                    continue;
                }
                if (Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase) >= n) {
                    continue;
                }
                list.add(entityLivingBase);
            }
        }
        return (ArrayList<EntityLivingBase>)list;
    }
    
    private static boolean validEntity(final Entity entity) {
        return entity != null && entity != Class152.mc.field_71439_g && !entity.func_70005_c_().equalsIgnoreCase("?6Dealer") && !entity.field_70128_L && !Class152.mc.field_71439_g.field_70128_L && (!(entity instanceof EntityPlayer) || (!Teams.isOnSameTeam(entity) && !AntiBot.isBot(entity))) && entity instanceof EntityLivingBase;
    }
    
    public static EntityLivingBase getClosestEntity(final float n) {
        EntityLivingBase entityLivingBase = null;
        float func_70032_d = n;
        for (final EntityLivingBase next : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (isNotItem(next) && !(next instanceof EntityPlayerSP)) {
                final EntityLivingBase entityLivingBase2 = (EntityLivingBase)next;
                if (!validEntity((Entity)entityLivingBase2)) {
                    continue;
                }
                if (Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase2) >= func_70032_d) {
                    continue;
                }
                func_70032_d = Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase2);
                entityLivingBase = entityLivingBase2;
            }
        }
        return entityLivingBase;
    }
    
    public static EntityLivingBase getClosestEntitySkipValidCheck(final float n) {
        EntityLivingBase entityLivingBase = null;
        float func_70032_d = n;
        for (final EntityLivingBase next : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (isNotItem(next) && !(next instanceof EntityPlayerSP)) {
                final EntityLivingBase entityLivingBase2 = (EntityLivingBase)next;
                if (Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase2) >= func_70032_d) {
                    continue;
                }
                func_70032_d = Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase2);
                entityLivingBase = entityLivingBase2;
            }
        }
        return entityLivingBase;
    }
    
    public static EntityLivingBase getClosestEntityToEntity(final float n, final Entity entity) {
        EntityLivingBase entityLivingBase = null;
        float func_70032_d = n;
        for (final EntityLivingBase next : Minecraft.func_71410_x().field_71441_e.field_72996_f) {
            if (isNotItem(next) && !entity.func_70028_i((Entity)(EntityLivingBase)next)) {
                final EntityLivingBase entityLivingBase2 = (EntityLivingBase)next;
                if (entity.func_70032_d((Entity)entityLivingBase2) >= func_70032_d) {
                    continue;
                }
                func_70032_d = entity.func_70032_d((Entity)entityLivingBase2);
                entityLivingBase = entityLivingBase2;
            }
        }
        return entityLivingBase;
    }
    
    public static boolean isNotItem(final Object o) {
        return o instanceof EntityLivingBase;
    }
    
    public static void faceEntity(final Entity entity) {
        facePos(new Vec3(entity.field_70165_t - 0.5, entity.field_70163_u + (entity.func_70047_e() - entity.field_70131_O / 1.5), entity.field_70161_v - 0.5));
    }
    
    public static void faceBlock(final BlockPos blockPos) {
        facePos(getVec3(blockPos));
    }
    
    public static Vec3 getVec3(final BlockPos blockPos) {
        return new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
    }
    
    public static BlockPos getBlockPos(final Vec3 vec3) {
        return new BlockPos(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
    }
    
    public static void facePos(final Vec3 vec3) {
        final double n = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n4 = (double)MathHelper.func_76133_a(n * n + n3 * n3);
        final float n5 = (float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f;
        final float n6 = (float)(-(Math.atan2(n2, n4) * 180.0 / 3.141592653589793));
        Minecraft.func_71410_x().field_71439_g.field_70177_z += MathHelper.func_76142_g(n5 - Minecraft.func_71410_x().field_71439_g.field_70177_z);
        Minecraft.func_71410_x().field_71439_g.field_70125_A += MathHelper.func_76142_g(n6 - Minecraft.func_71410_x().field_71439_g.field_70125_A);
    }
    
    public static float[] getFacePos(final Vec3 vec3) {
        final double n = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        return new float[] { Minecraft.func_71410_x().field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f - Minecraft.func_71410_x().field_71439_g.field_70177_z), Minecraft.func_71410_x().field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-(Math.atan2(n2, MathHelper.func_76133_a(n * n + n3 * n3)) * 180.0 / 3.141592653589793)) - Minecraft.func_71410_x().field_71439_g.field_70125_A) };
    }
    
    public static float[] getFacePosRemote(final Vec3 vec3, final Vec3 vec4) {
        final double n = vec4.field_72450_a - vec3.field_72450_a;
        final double n2 = vec4.field_72448_b - vec3.field_72448_b;
        final double n3 = vec4.field_72449_c - vec3.field_72449_c;
        return new float[] { MathHelper.func_76142_g((float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f), MathHelper.func_76142_g((float)(-(Math.atan2(n2, MathHelper.func_76133_a(n * n + n3 * n3)) * 180.0 / 3.141592653589793))) };
    }
    
    public static float[] getFacePosEntity(final Entity entity) {
        if (entity == null) {
            return new float[] { Minecraft.func_71410_x().field_71439_g.field_70759_as, Minecraft.func_71410_x().field_71439_g.field_70125_A };
        }
        return getFacePos(new Vec3(entity.field_70165_t - 0.5, entity.field_70163_u + (entity.func_70047_e() - entity.field_70131_O / 1.5), entity.field_70161_v - 0.5));
    }
    
    public static float[] getFacePosEntityRemote(final EntityLivingBase entityLivingBase, final Entity entity) {
        if (entity == null) {
            return new float[] { entityLivingBase.field_70759_as, entityLivingBase.field_70125_A };
        }
        return getFacePosRemote(new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + entity.func_70047_e(), entityLivingBase.field_70161_v), new Vec3(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v));
    }
    
    public static void smoothFacePos(final Vec3 vec3) {
        final double n = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n4 = (double)MathHelper.func_76133_a(n * n + n3 * n3);
        final float n5 = (float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f;
        final float n6 = (float)(-(Math.atan2(n2, n4) * 180.0 / 3.141592653589793));
        final float n7 = 5.0f;
        if (MathHelper.func_76142_g(n5 - Minecraft.func_71410_x().field_71439_g.field_70177_z) <= n7 * 2.0f) {
            if (MathHelper.func_76142_g(n5 - Minecraft.func_71410_x().field_71439_g.field_70177_z) < -n7 * 2.0f) {}
        }
        if (MathHelper.func_76142_g(n6 - Minecraft.func_71410_x().field_71439_g.field_70125_A) <= n7 * 4.0f) {
            if (MathHelper.func_76142_g(n6 - Minecraft.func_71410_x().field_71439_g.field_70125_A) < -n7 * 4.0f) {}
        }
    }
    
    public static void smoothFacePos(final Vec3 vec3, final double n) {
        final double n2 = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n3 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n4 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n5 = (double)MathHelper.func_76133_a(n2 * n2 + n4 * n4);
        final float n6 = (float)(Math.atan2(n4, n2) * 180.0 / 3.141592653589793) - 90.0f;
        final float n7 = (float)(-(Math.atan2(n3, n5) * 180.0 / 3.141592653589793));
    }
    
    public static float getPlayerBlockDistance(final BlockPos blockPos) {
        return getPlayerBlockDistance(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p());
    }
    
    public static float getPlayerBlockDistance(final double n, final double n2, final double n3) {
        return getBlockDistance((float)(Minecraft.func_71410_x().field_71439_g.field_70165_t - n), (float)(Minecraft.func_71410_x().field_71439_g.field_70163_u - n2), (float)(Minecraft.func_71410_x().field_71439_g.field_70161_v - n3));
    }
    
    public static float getBlockDistance(final float n, final float n2, final float n3) {
        return MathHelper.func_76129_c((n - 0.5f) * (n - 0.5f) + (n2 - 0.5f) * (n2 - 0.5f) + (n3 - 0.5f) * (n3 - 0.5f));
    }
    
    public static ArrayList<EntityItem> getNearbyItems(final int n) {
        final ArrayList<Entity> list = (ArrayList<Entity>)new ArrayList<EntityItem>();
        for (final EntityItem next : Minecraft.func_71410_x().field_71441_e.func_72910_y()) {
            if (!(next instanceof EntityItem)) {
                continue;
            }
            final EntityItem entityItem = (EntityItem)next;
            if (Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityItem) >= n) {
                continue;
            }
            list.add(entityItem);
        }
        return (ArrayList<EntityItem>)list;
    }
    
    public static EntityItem getClosestItem(final float n) {
        EntityItem entityItem = null;
        for (final EntityItem next : Minecraft.func_71410_x().field_71441_e.func_72910_y()) {
            if (!(next instanceof EntityItem)) {
                continue;
            }
            final EntityItem entityItem2 = (EntityItem)next;
            if (Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityItem2) >= n) {
                continue;
            }
            entityItem = entityItem2;
        }
        return entityItem;
    }
    
    public static Entity getClosestItemOrXPOrb(final float n) {
        Entity entity = null;
        for (final Entity next : Minecraft.func_71410_x().field_71441_e.func_72910_y()) {
            if (!(next instanceof EntityItem) && !(next instanceof EntityXPOrb)) {
                continue;
            }
            final Entity entity2 = (Entity)next;
            if (Minecraft.func_71410_x().field_71439_g.func_70032_d(entity2) >= n) {
                continue;
            }
            entity = entity2;
        }
        return entity;
    }
    
    private static final float limitAngleChange(final float n, final float n2, final float n3) {
        float n4 = n2 - n;
        if (n4 > n3) {
            n4 = n3;
        }
        else if (n4 < -n3) {
            n4 = -n3;
        }
        return n + n4;
    }
    
    public static double normalizeAngle(final double n) {
        return (n + 360.0) % 360.0;
    }
    
    public static float normalizeAngle(final float n) {
        return (n + 360.0f) % 360.0f;
    }
    
    public static int getItemIndexHotbar(final int n) {
        for (int i = 0; i < 9; ++i) {
            final ItemStack func_70301_a = Class152.mc.field_71439_g.field_71071_by.func_70301_a(i);
            if (func_70301_a != null) {
                if (n == Item.func_150891_b(func_70301_a.func_77973_b())) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static boolean isBlockPosAir(final BlockPos blockPos) {
        return Class152.mc.field_71441_e.func_180495_p(blockPos).func_177230_c().func_149688_o() == Material.field_151579_a;
    }
    
    public static Block getBlockRelativeToEntity(final Entity entity, final double n) {
        return getBlock(new BlockPos(entity.field_70165_t, entity.field_70163_u + n, entity.field_70161_v));
    }
    
    public static BlockPos getBlockPosRelativeToEntity(final Entity entity, final double n) {
        return new BlockPos(entity.field_70165_t, entity.field_70163_u + n, entity.field_70161_v);
    }
    
    public static Block getBlock(final BlockPos blockPos) {
        return Class152.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    public static Vec3 getLastGroundLocation() {
        return Class152.lastLoc;
    }
    
    public static void updateLastGroundLocation() {
        if (Class152.mc.field_71439_g.field_70122_E) {
            Class152.lastLoc = new Vec3(Class152.mc.field_71439_g.field_70165_t, Class152.mc.field_71439_g.field_70163_u, Class152.mc.field_71439_g.field_70161_v);
        }
    }
    
    public static IBlockState getBlockState(final BlockPos blockPos) {
        return Class152.mc.field_71441_e.func_180495_p(blockPos);
    }
    
    static {
        Class152.mc = Minecraft.func_71410_x();
        Class152.rand = new Random();
        Class152.blackList = new ArrayList<Integer>();
        Class152.lastLoc = null;
    }
}
