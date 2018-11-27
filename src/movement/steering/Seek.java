package arhrs.movement.steering;

import math.geom2d.Vector2D;
import arhrs.movement.KinematicInfo;
import arhrs.movement.StaticInfo;

public class Seek implements SteeringBehavior {

    Vector2D targetPosition;

    double maxacceleration = 0.5;

    public Seek(Vector2D targetPosition) {
        this.targetPosition = targetPosition;
    }

    @Override
    public SteeringInfo getSteering(StaticInfo staticInfo, KinematicInfo kinematicInfo) {
        Vector2D linear = targetPosition.minus(staticInfo.getPosition());
        double rotation =0;

        if (linear.norm()>maxacceleration)
        {
            linear= linear.normalize().times(maxacceleration);
        }

        return new SteeringInfo(linear,rotation, SteeringInfo.SteeringType.Dynamic);
    }

    @Override
    public void setTarget(StaticInfo targetStatic) {
        targetPosition = targetStatic.getPosition();
    }
}
