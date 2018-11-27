package arhrs.movement;


import arhrs.movement.steering.Face;
import arhrs.movement.steering.Wander;
import math.geom2d.Vector2D;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Bootstrap;

import java.awt.geom.Rectangle2D;

public class MovementDemo extends StateBasedGame {
    private static final int DemoWidth = 800;
    private static final int DemoHeight = 600;
    private final int movementPanel=0;



    public MovementDemo(String name) {
        super(name);
        addState(new MovementPanel());
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        getState(movementPanel).init(gameContainer,this);
        enterState(movementPanel);
    }

    MovementPanel getPanel()
    {
        return (MovementPanel) getState(movementPanel);
    }

    public static void main(String[] args) {
        MovementDemo demo = new MovementDemo("Movement Demo");

        Renderable ballShape = new Ball(Color.red,10);
        GameEntity staticBall = new BasicGameEntity(ballShape,new StaticInfo(new Vector2D(50,250),0.5));
        MovingEntity movingBall = new MovingEntity( ballShape,
                                                    new StaticInfo(new Vector2D(250,250), 2.3, StaticInfo.OrientationType.Explicit),
                                                    new KinematicInfo(new Vector2D(0,1),0),
                                                    new Rectangle2D.Double(0,0,DemoWidth-2*MovementPanel.FRAME_WIDTH,DemoHeight-2*MovementPanel.FRAME_WIDTH));

        MovingEntity movingBall2 = new MovingEntity( ballShape,
                new StaticInfo(new Vector2D(50,250), 2.3, StaticInfo.OrientationType.Explicit),
                new KinematicInfo(new Vector2D(0,1),0),
                new Rectangle2D.Double(0,0,DemoWidth-2*MovementPanel.FRAME_WIDTH,DemoHeight-2*MovementPanel.FRAME_WIDTH));

        MovingEntity movingBall3 = new MovingEntity( ballShape,
                new StaticInfo(new Vector2D(250,50), 2.3, StaticInfo.OrientationType.Explicit),
                new KinematicInfo(new Vector2D(0,1),0),
                new Rectangle2D.Double(0,0,DemoWidth-2*MovementPanel.FRAME_WIDTH,DemoHeight-2*MovementPanel.FRAME_WIDTH));


        LineSegmentsPath path = new LineSegmentsPath();
        path.addNode(new Vector2D(30,30));
        path.addNode(new Vector2D(100,450));
        path.addNode(new Vector2D(500,150));
        path.addNode(new Vector2D(500,450));
        path.addNode(new Vector2D(20,450));


        movingBall.setSteeringBehavior(new Wander());
        movingBall.setCollisionHandler(new SimpleCollision(ballShape.getRadius()));

        movingBall2.setSteeringBehavior(new Wander());
        movingBall2.setCollisionHandler(new SimpleCollision(ballShape.getRadius()));
        movingBall3.setSteeringBehavior(new Wander());
        movingBall3.setCollisionHandler(new SimpleCollision(ballShape.getRadius()));

        demo.getPanel().addEntity(staticBall);
        demo.getPanel().addEntity(movingBall);

        demo.getPanel().addEntity(movingBall2);
        demo.getPanel().addEntity(movingBall3);

        Bootstrap.runAsApplication(demo,DemoWidth,DemoHeight,false);

    }


}
