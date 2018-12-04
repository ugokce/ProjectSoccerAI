package arhrs.movement;

import arhrs.movement.steering.Arrive;
import arhrs.movement.steering.Seek;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import math.geom2d.Vector2D;

public class FollowPath<Index> implements SteeringBehavior {
    Path<Vector2D,Index> path;
    Index currentIndex = null;


    public FollowPath(Path<Vector2D, Index> path) {
        this.path = path;
    }

    @Override
    public SteeringInfo getSteering(StaticInfo staticInfo, KinematicInfo kinematicInfo) {

        Vector2D futurePos = staticInfo.position.plus(kinematicInfo.velocity);

        currentIndex = path.getIndex(futurePos,currentIndex);

        Arrive arrive = new Arrive(path.getPosition(currentIndex));
        return arrive.getSteering(staticInfo,kinematicInfo);
    }

    @Override
    public void setTarget(StaticInfo targetStatic) {

    }
}
