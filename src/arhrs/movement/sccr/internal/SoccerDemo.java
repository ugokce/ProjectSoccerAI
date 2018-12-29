package arhrs.movement.sccr.internal;


import arhrs.movement.sccr.BetterAIPack.BetterAI;
import arhrs.movement.sccr.BetterAIPack.PlayerType;
import arhrs.movement.sccr.SimplePlayerAI;
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

      //  SimpleSoccerPlayer p11 = new SimpleSoccerPlayer(demo.getGameState(),0,new SoccerBot(0));
      //  SimpleSoccerPlayer p12 = new SimpleSoccerPlayer(demo.getGameState(),0,new SoccerBot(1));
      //  SimpleSoccerPlayer p13 = new SimpleSoccerPlayer(demo.getGameState(),0,new SoccerBot(2));
      //  SimpleSoccerPlayer p14 = new SimpleSoccerPlayer(demo.getGameState(),0,new SoccerBot(3));
      //  SimpleSoccerPlayer p15 = new SimpleSoccerPlayer(demo.getGameState(),0,new SoccerBot(4));

        
      
        SimpleSoccerPlayer p11 = new SimpleSoccerPlayer(demo.getGameState(),0,new BetterAI(PlayerType.Forward));
        SimpleSoccerPlayer p12 = new SimpleSoccerPlayer(demo.getGameState(),0,new BetterAI(PlayerType.Defence));
        SimpleSoccerPlayer p13 = new SimpleSoccerPlayer(demo.getGameState(),0,new BetterAI(PlayerType.Defence));
        SimpleSoccerPlayer p14 = new SimpleSoccerPlayer(demo.getGameState(),0,new BetterAI(PlayerType.Middle));
        SimpleSoccerPlayer p15 = new SimpleSoccerPlayer(demo.getGameState(),0,new BetterAI(PlayerType.Middle));

        SimpleSoccerPlayer p21 = new SimpleSoccerPlayer(demo.getGameState(),1,new BetterAI(PlayerType.Forward));
        SimpleSoccerPlayer p22 = new SimpleSoccerPlayer(demo.getGameState(),1,new BetterAI(PlayerType.Defence));
        SimpleSoccerPlayer p23 = new SimpleSoccerPlayer(demo.getGameState(),1,new BetterAI(PlayerType.Defence));
        SimpleSoccerPlayer p24 = new SimpleSoccerPlayer(demo.getGameState(),1,new BetterAI(PlayerType.Middle));
        SimpleSoccerPlayer p25 = new SimpleSoccerPlayer(demo.getGameState(),1,new BetterAI(PlayerType.Middle));


        demo.getGameState().addPlayer(0,p11);
        demo.getGameState().addPlayer(0,p12);
        demo.getGameState().addPlayer(0,p13);
        demo.getGameState().addPlayer(0,p14);
        demo.getGameState().addPlayer(0,p15);
        demo.getGameState().addPlayer(1,p21);
        demo.getGameState().addPlayer(1,p22);
        demo.getGameState().addPlayer(1,p23);
        demo.getGameState().addPlayer(1,p24);
        demo.getGameState().addPlayer(1,p25);




        Bootstrap.runAsApplication(demo,DemoWidth,DemoHeight,false);

    }


}
