package arhrs.movement.sccr.internal.GoztepeAI;


import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;

public interface PlayerAI {

    void init(SoccerPlayer soccerPlayer, SoccerGame game);
    SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game);
    SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game);
}
