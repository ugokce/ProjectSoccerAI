package arhrs.movement.steering;


import arhrs.movement.KinematicInfo;
import arhrs.movement.StaticInfo;
import math.geom2d.Vector2D;

public interface SteeringBehavior {
    SteeringInfo getSteering(StaticInfo staticInfo, KinematicInfo kinematicInfo);

    void setTarget(StaticInfo targetStatic);
}
