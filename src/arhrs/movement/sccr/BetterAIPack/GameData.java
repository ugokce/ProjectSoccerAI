package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;

public interface GameData {
   
    public SoccerGame getGame();
    public SoccerPlayer getPlayer();
    public double getShootRange();
    
}
