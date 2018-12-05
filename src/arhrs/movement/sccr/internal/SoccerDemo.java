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

        SimpleSoccerPlayer T1def1 = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());
        SimpleSoccerPlayer T1def2 = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());
        SimpleSoccerPlayer T1ort1 = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());
        SimpleSoccerPlayer T1ort2 = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());
        SimpleSoccerPlayer T1for = new SimpleSoccerPlayer(demo.getGameState(),0,new SimplePlayerAI());

        SimpleSoccerPlayer T2def1 = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());
        SimpleSoccerPlayer T2def2 = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());
        SimpleSoccerPlayer T2ort1 = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());
        SimpleSoccerPlayer T2ort2 = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());
        SimpleSoccerPlayer T2for = new SimpleSoccerPlayer(demo.getGameState(),1,new SimplePlayerAI());

        demo.getGameState().addPlayer(0,T1def1);
        demo.getGameState().addPlayer(0,T1def2);
        demo.getGameState().addPlayer(0,T1ort1);
        demo.getGameState().addPlayer(0,T1ort2);
        demo.getGameState().addPlayer(0,T1for); 
        
        demo.getGameState().addPlayer(1,T2def1);
        demo.getGameState().addPlayer(1,T2def2);
        demo.getGameState().addPlayer(1,T2ort1);
        demo.getGameState().addPlayer(1,T2ort2);
        demo.getGameState().addPlayer(1,T2for);
        Bootstrap.runAsApplication(demo,DemoWidth,DemoHeight,false);

    }


}
