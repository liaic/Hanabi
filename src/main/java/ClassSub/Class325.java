package ClassSub;

import java.util.*;

private class Class325
{
    private Class235 loc;
    private Class325 parent;
    private ArrayList<Class235> path;
    private double squareDistanceToFromTarget;
    private double cost;
    private double totalCost;
    final Class101 this$0;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class325(final Class101 this$0, final Class235 loc, final Class325 parent, final ArrayList<Class235> path, final double squareDistanceToFromTarget, final double cost, final double totalCost) {
        this.this$0 = this$0;
        super();
        this.loc = null;
        this.parent = null;
        this.loc = loc;
        this.parent = parent;
        this.path = path;
        this.squareDistanceToFromTarget = squareDistanceToFromTarget;
        this.cost = cost;
        this.totalCost = totalCost;
    }
    
    public Class235 getLoc() {
        return this.loc;
    }
    
    public Class325 getParent() {
        return this.parent;
    }
    
    public ArrayList<Class235> getPath() {
        return this.path;
    }
    
    public double getSquareDistanceToFromTarget() {
        return this.squareDistanceToFromTarget;
    }
    
    public double getCost() {
        return this.cost;
    }
    
    public void setLoc(final Class235 loc) {
        this.loc = loc;
    }
    
    public void setParent(final Class325 parent) {
        this.parent = parent;
    }
    
    public void setPath(final ArrayList<Class235> path) {
        this.path = path;
    }
    
    public void setSquareDistanceToFromTarget(final double squareDistanceToFromTarget) {
        this.squareDistanceToFromTarget = squareDistanceToFromTarget;
    }
    
    public void setCost(final double cost) {
        this.cost = cost;
    }
    
    public double getTotalCost() {
        return this.totalCost;
    }
    
    public void setTotalCost(final double totalCost) {
        this.totalCost = totalCost;
    }
}
