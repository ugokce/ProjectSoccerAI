package arhrs.movement.steering;


import math.geom2d.Vector2D;
import arhrs.movement.KinematicInfo;
import arhrs.movement.StaticInfo;

/**
 * Created by dindar.oz on 9/22/2017.
 */
public class Face implements SteeringBehavior {

    SteeringBehavior align;

    StaticInfo target;

    public Face(StaticInfo target) {
        this.target = target;
    }

    @Override
    public SteeringInfo getSteering(StaticInfo staticInfo, KinematicInfo kinematicInfo) {

        Vector2D direction = target.getPosition().minus(staticInfo.getPosition());

        if (direction.norm()==0)
            return SteeringInfo.getNoSteering();

        double orientation = Math.atan2(direction.y(),direction.x());

        //Kinematic newTarget = new Kinematic(target.position,orientation,target.velocity,target.rotation);
        align = new Align(new StaticInfo(target.getPosition(),orientation));

        return align.getSteering(staticInfo,kinematicInfo);
    }

    @Override
    public void setTarget(StaticInfo targetStatic) {
        target = targetStatic;
    }
}
