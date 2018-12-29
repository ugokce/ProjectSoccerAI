package arhrs.movement.sccr.BetterAIPack.DecisionTree;

import arhrs.movement.sccr.BetterAIPack.PlayerType;
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;

public interface GameData {
   
    public SoccerGame getGame();
    public SoccerPlayer getPlayer();
    public double getShootRange();
    public double getShootDistance();

    public PlayerType getPLtype();
    
}
