package arhrs.movement.tag;


import arhrs.movement.KinematicInfo;
import arhrs.movement.StaticInfo;
import math.geom2d.Vector2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Bootstrap;

public class TagGameDemo extends StateBasedGame {
    public static final int movementArea=0;

    public TagGameDemo(String name, BasicGameState area) {
        super(name);
        addState(area);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        getState(movementArea).init(gameContainer,this);

        enterState(movementArea);
    }
    public static void main(String[] args) {

        TagGame tagGame = new TagGame();

        TagPlayer tp1 = new TagPlayer(  new StaticInfo(new Vector2D(215,250),10),
                                        new KinematicInfo(new Vector2D(0,0),0));

        TagPlayer tp2 = new TagPlayer(  new StaticInfo(new Vector2D(15,250),10),
                                        new KinematicInfo(new Vector2D(0,0),0));

        TagPlayer tp3 = new TagPlayer(  new StaticInfo(new Vector2D(215,50),10),
                                         new KinematicInfo(new Vector2D(0,0),0));

        TagPlayer tp4 = new TagPlayer(  new StaticInfo(new Vector2D(15,50),10),
                                        new KinematicInfo(new Vector2D(0,0),0));


        tagGame.addPlayer(tp1);
        tagGame.addPlayer(tp2);
        tagGame.addPlayer(tp3);
        tagGame.addPlayer(tp4);
        tagGame.setTag(tp1);

        TagGameDemo demo = new TagGameDemo("TagGame Demo",tagGame);
        Bootstrap.runAsApplication(demo,800,600,false);
    }
}
