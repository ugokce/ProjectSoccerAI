package arhrs.movement.sccr.internal;


import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;

public interface PlayerAI {

    void init(SoccerPlayer soccerPlayer, SoccerGame game);
    SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game);
    SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game);
}
