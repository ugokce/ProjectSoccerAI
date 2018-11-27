package arhrs.movement.sccr.internal;


import arhrs.movement.sccr.SimplePlayerAI;
import math.geom2d.Vector2D;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Bootstrap;

public class SoccerDemo extends StateBasedGame {
    private static final int DemoWidth = 1000;
    private static final int DemoHeight = 600;
    private final int pitch =0;

 //deneme deneme masaustu 2

    
    
    
    public SoccerDemo(String name) {
        super(name);
        addState(new SoccerGameState());
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        getState(pitch).init(gameContainer,this);
        enterState(pitch);
    }

    SoccerGameState getGameState()
    {
        return (SoccerGameState) getState(pitch);
    }

    public static void main(String[] args) {
        SoccerDemo demo = new SoccerDemo("Soccer Demo");

        SimpleSoccerPlayer p1 = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());
        SimpleSoccerPlayer pl1 = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());
        SimpleSoccerPlayer pl2 = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());



        SimpleSoccerPlayer pl3 = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());
        SimpleSoccerPlayer pl4 = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());
        SimpleSoccerPlayer pl5 = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());


        demo.getGameState().addPlayer(0,p1);
        demo.getGameState().addPlayer(0,pl1);
        demo.getGameState().addPlayer(0,pl2);
        demo.getGameState().addPlayer(1,pl3);
        demo.getGameState().addPlayer(1,pl4);
        demo.getGameState().addPlayer(1,pl5);

        Bootstrap.runAsApplication(demo,DemoWidth,DemoHeight,false);

    }


}
