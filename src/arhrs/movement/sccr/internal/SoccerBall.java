package arhrs.movement.sccr.internal;


import arhrs.movement.*;
import arhrs.movement.steering.Friction;
import arhrs.movement.steering.SteeringInfo;
import math.geom2d.Vector2D;
import org.newdawn.slick.Color;

import java.awt.geom.Rectangle2D;

public class SoccerBall extends MovingEntity implements GoalListener {
    public static final Color BallColor = Color.black;
    public static final float BallRadius = 5;
    public static final double FrictionCoefficient = 0.05;
    private static final double MinBallSpeed = 0.0001;

    Vector2D initialPosition;

    public SoccerBall( Vector2D initialPosition, Rectangle2D bounds) {
        super(new Ball(BallColor,BallRadius), new StaticInfo(initialPosition,0), KinematicInfo.Zero(), bounds);
        setCollisionHandler(new SimpleCollision(BallRadius));
        setSteeringBehavior(new Friction(FrictionCoefficient));
        this.initialPosition= initialPosition;
        setMaxVelocity(SoccerGame.MaxBallSpeed);
    }

    public Vector2D getPosition() {
        return staticInfo.getPosition().clone();
    }

    void setKinematic(SteeringInfo steeringInfo)
    {
        if (steeringInfo.linear.norm()<MinBallSpeed)
            kinematicInfo = new KinematicInfo(new Vector2D(0,0),0);
        else kinematicInfo = new KinematicInfo(steeringInfo.linear.normalize().times(SoccerGame.MaxBallSpeed),0);
    }

    @Override
    public void goalScored(int team) {
        staticInfo.setPosition(initialPosition.clone());
        kinematicInfo = KinematicInfo.Zero();
    }
}
