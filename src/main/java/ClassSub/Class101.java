package ClassSub;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.block.*;

public class Class101
{
    private Class235 startVec3;
    private Class235 endVec3;
    private ArrayList<Class235> path;
    private ArrayList<Class325> hubs;
    private ArrayList<Class325> hubsToWork;
    private double minDistanceSquared;
    private boolean nearest;
    private static Class235[] flatCardinalDirections;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class101(final Class235 class235, final Class235 class236) {
        super();
        this.path = new ArrayList<Class235>();
        this.hubs = new ArrayList<Class325>();
        this.hubsToWork = new ArrayList<Class325>();
        this.minDistanceSquared = 9.0;
        this.nearest = true;
        this.startVec3 = class235.addVector(0.0, 0.0, 0.0).floor();
        this.endVec3 = class236.addVector(0.0, 0.0, 0.0).floor();
    }
    
    public ArrayList<Class235> getPath() {
        return this.path;
    }
    
    public void compute() {
        this.compute(1000, 4);
    }
    
    public void compute(final int n, final int n2) {
        this.path.clear();
        this.hubsToWork.clear();
        final ArrayList<Class235> list = new ArrayList<Class235>();
        list.add(this.startVec3);
        this.hubsToWork.add(new Class325(this.startVec3, (Class325)null, list, this.startVec3.squareDistanceTo(this.endVec3), 0.0, 0.0));
    Label_0401:
        for (int i = 0; i < n; ++i) {
            Collections.sort(this.hubsToWork, new Class201());
            int n3 = 0;
            if (this.hubsToWork.size() == 0) {
                break;
            }
            for (final Class325 class325 : new ArrayList<Class325>(this.hubsToWork)) {
                if (++n3 > n2) {
                    break;
                }
                this.hubsToWork.remove(class325);
                this.hubs.add(class325);
                final Class235[] flatCardinalDirections = Class101.flatCardinalDirections;
                for (int length = flatCardinalDirections.length, j = 0; j < length; ++j) {
                    final Class235 floor = class325.getLoc().add(flatCardinalDirections[j]).floor();
                    if (checkPositionValidity(floor, false) && this.addHub(class325, floor, 0.0)) {
                        break Label_0401;
                    }
                }
                final Class235 floor2 = class325.getLoc().addVector(0.0, 1.0, 0.0).floor();
                if (checkPositionValidity(floor2, false) && this.addHub(class325, floor2, 0.0)) {
                    break Label_0401;
                }
                final Class235 floor3 = class325.getLoc().addVector(0.0, -1.0, 0.0).floor();
                if (checkPositionValidity(floor3, false) && this.addHub(class325, floor3, 0.0)) {
                    break Label_0401;
                }
            }
        }
        if (this.nearest) {
            Collections.sort(this.hubs, new Class201());
            this.path = ((Class325)this.hubs.get(0)).getPath();
        }
    }
    
    public static boolean checkPositionValidity(final Class235 class235, final boolean b) {
        return checkPositionValidity((int)class235.getX(), (int)class235.getY(), (int)class235.getZ(), b);
    }
    
    public static boolean checkPositionValidity(final int n, final int n2, final int n3, final boolean b) {
        final BlockPos blockPos = new BlockPos(n, n2, n3);
        final BlockPos blockPos2 = new BlockPos(n, n2 + 1, n3);
        final BlockPos blockPos3 = new BlockPos(n, n2 - 1, n3);
        return !isBlockSolid(blockPos) && !isBlockSolid(blockPos2) && (isBlockSolid(blockPos3) || !b) && isSafeToWalkOn(blockPos3);
    }
    
    private static boolean isBlockSolid(final BlockPos blockPos) {
        return Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c().func_149730_j() || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockSlab || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockStairs || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockCactus || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockChest || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockEnderChest || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockSkull || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPane || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockFence || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockWall || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockGlass || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPistonBase || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPistonExtension || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPistonMoving || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockStainedGlass || Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockTrapDoor;
    }
    
    private static boolean isSafeToWalkOn(final BlockPos blockPos) {
        return !(Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockFence) && !(Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockWall);
    }
    
    public Class325 isHubExisting(final Class235 class235) {
        for (final Class325 class236 : this.hubs) {
            if (class236.getLoc().getX() == class235.getX() && class236.getLoc().getY() == class235.getY() && class236.getLoc().getZ() == class235.getZ()) {
                return class236;
            }
        }
        for (final Class325 class237 : this.hubsToWork) {
            if (class237.getLoc().getX() == class235.getX() && class237.getLoc().getY() == class235.getY() && class237.getLoc().getZ() == class235.getZ()) {
                return class237;
            }
        }
        return null;
    }
    
    public boolean addHub(final Class325 parent, final Class235 loc, final double cost) {
        final Class325 hubExisting = this.isHubExisting(loc);
        double totalCost = cost;
        if (parent != null) {
            totalCost += parent.getTotalCost();
        }
        if (hubExisting == null) {
            if ((loc.getX() == this.endVec3.getX() && loc.getY() == this.endVec3.getY() && loc.getZ() == this.endVec3.getZ()) || (this.minDistanceSquared != 0.0 && loc.squareDistanceTo(this.endVec3) <= this.minDistanceSquared)) {
                this.path.clear();
                (this.path = parent.getPath()).add(loc);
                return true;
            }
            final ArrayList<Class235> list = new ArrayList<Class235>(parent.getPath());
            list.add(loc);
            this.hubsToWork.add(new Class325(loc, parent, list, loc.squareDistanceTo(this.endVec3), cost, totalCost));
        }
        else if (hubExisting.getCost() > cost) {
            final ArrayList<Class235> path = new ArrayList<Class235>(parent.getPath());
            path.add(loc);
            hubExisting.setLoc(loc);
            hubExisting.setParent(parent);
            hubExisting.setPath(path);
            hubExisting.setSquareDistanceToFromTarget(loc.squareDistanceTo(this.endVec3));
            hubExisting.setCost(cost);
            hubExisting.setTotalCost(totalCost);
        }
        return false;
    }
    
    static {
        Class101.flatCardinalDirections = new Class235[] { new Class235(1.0, 0.0, 0.0), new Class235(-1.0, 0.0, 0.0), new Class235(0.0, 0.0, 1.0), new Class235(0.0, 0.0, -1.0) };
    }
}
