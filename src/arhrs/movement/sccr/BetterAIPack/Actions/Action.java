package arhrs.movement.sccr.BetterAIPack.Actions;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionTreeNode;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.steering.SteeringBehavior;
import math.geom2d.Vector2D;



public abstract class Action implements DecisionTreeNode {
    
    Vector2D target;
  
    
    public void setTarget(Vector2D target) {
        this.target = target;
        
    }

    public Vector2D getTarget() {
        return target;
    }
    @Override
    public Action makeDecision(GameData game) {
        return this;
    }
    public abstract SteeringBehavior getSteering();
}
