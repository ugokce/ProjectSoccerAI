package arhrs.movement.sccr;

import arhrs.movement.sccr.internal.PlayerAI;
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import arhrs.movement.steering.Seek;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import math.geom2d.Vector2D;

public class DummyAI implements PlayerAI {


    Vector2D kickTarget;

    @Override
    public void init(SoccerPlayer soccerPlayer, SoccerGame game) {
        kickTarget = game.getGoalAreaCenter(game.opponent(soccerPlayer.getTeam()));
    }

    @Override
    public SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game) {


        return null;
    }

    @Override
    public SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game) {


        SoccerPlayer p = game.getPlayer(0,0);



        if (kickTarget!= null)
            return new SteeringInfo(kickTarget.minus(soccerPlayer.getPosition()),0, SteeringInfo.SteeringType.Kinematic);
        else return SteeringInfo.getNoSteering();

    }
}
