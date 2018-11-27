package arhrs.movement.tag;


import arhrs.movement.KinematicInfo;
import arhrs.movement.StaticInfo;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import math.geom2d.Vector2D;

public class NewTagBehavor implements SteeringBehavior {
    @Override
    public SteeringInfo getSteering(StaticInfo staticInfo, KinematicInfo kinematicInfo) {
        return new SteeringInfo(new Vector2D(0,0),0, SteeringInfo.SteeringType.Kinematic);
    }

    @Override
    public void setTarget(StaticInfo targetStatic) {

    }
}
