package arhrs.movement.steering;

import arhrs.movement.KinematicInfo;
import arhrs.movement.StaticInfo;
import arhrs.util.RandomUtils;

public class Friction implements SteeringBehavior {
    private static final double MinSpeed = 0.0001;
    private static final double NoiseRange = 0.2;
    private double frictionCoefficient;

    public Friction(double frictionCoefficient) {
        this.frictionCoefficient = frictionCoefficient;
    }

    @Override
    public SteeringInfo getSteering(StaticInfo staticInfo, KinematicInfo kinematicInfo) {
        if (kinematicInfo.getVelocity().norm()>MinSpeed) {
            double noise = NoiseRange*RandomUtils.nextDouble();
            return new SteeringInfo(kinematicInfo.getVelocity().opposite().normalize().times(frictionCoefficient).rotate(noise), 0, SteeringInfo.SteeringType.Dynamic);

        }
        return SteeringInfo.NoSteering;
    }

    @Override
    public void setTarget(StaticInfo targetStatic) {

    }
}
