package arhrs.movement;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;

import java.awt.geom.Rectangle2D;

public class MovingEntity extends BasicGameEntity
{


    private double MaxVelocity = 1;
    private double MaxRotation = 0.1;
    private static final double TIME_COEFFICIENT = 0.2;
    protected KinematicInfo kinematicInfo;
    Rectangle2D bounds;



    protected SteeringBehavior steeringBehavior;
    protected CollisionHandler collisionHandler;




    public MovingEntity(Renderable shape, StaticInfo staticInfo, KinematicInfo kinematicInfo, Rectangle2D bounds) {
        super(shape, staticInfo);
        this.kinematicInfo = kinematicInfo;
        this.bounds = bounds;
    }

    protected void setMaxVelocity(double maxVelocity)
    {
        MaxVelocity = maxVelocity;
    }

    void setMaxRotation(double maxRotation)
    {
        MaxRotation = maxRotation;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) {
        super.update(gameContainer, stateBasedGame, i);

        SteeringInfo steeringInfo = (steeringBehavior != null) ?
                                    steeringBehavior.getSteering(staticInfo,kinematicInfo):SteeringInfo.getNoSteering();


        kinematicInfo.update(steeringInfo,1*TIME_COEFFICIENT,MaxVelocity,MaxRotation);


        staticInfo.update(kinematicInfo,steeringInfo,1* TIME_COEFFICIENT);

        if (collisionHandler!=null)
             collisionHandler.handle(this);
    }

    public SteeringBehavior getSteeringBehavior() {
        return steeringBehavior;
    }

    public void setSteeringBehavior(SteeringBehavior steeringBehavior) {
        this.steeringBehavior = steeringBehavior;
    }


    public void setCollisionHandler(CollisionHandler collisionHandler)
    {
        this.collisionHandler = collisionHandler;
    }


    public void setBounds(Rectangle2D bounds) {
        this.bounds = bounds;
    }

    public KinematicInfo getKinematicInfo() {
        return kinematicInfo;
    }
}
