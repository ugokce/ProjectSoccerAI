package arhrs.movement.sccr.internal;

import arhrs.movement.KinematicInfo;
import arhrs.movement.StaticInfo;
import arhrs.movement.steering.Friction;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;

public class FatigueBehavior implements SteeringBehavior {
    public static final double FatigeSlowDownRatio = 0.1;
    public static final double FatigueSpeed = 0.6;

    @Override
    public SteeringInfo getSteering(StaticInfo staticInfo, KinematicInfo kinematicInfo) {
        if (kinematicInfo.getVelocity().norm()> FatigueSpeed)
        {
            return new SteeringInfo(kinematicInfo.getVelocity().opposite().normalize().times(FatigeSlowDownRatio),0, SteeringInfo.SteeringType.Dynamic);
        }
        return SteeringInfo.NoSteering;
    }

    @Override
    public void setTarget(StaticInfo targetStatic) {

    }
}
