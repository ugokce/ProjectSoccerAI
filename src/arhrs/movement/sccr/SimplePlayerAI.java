package arhrs.movement.sccr;

import arhrs.movement.sccr.internal.GoztepeAI.PlayerAI;
import arhrs.movement.sccr.internal.*;
import arhrs.movement.sccr.internal.SoccerPlayer;
import arhrs.movement.steering.Seek;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import math.geom2d.Vector2D;

public class SimplePlayerAI implements PlayerAI {


    Vector2D kickTarget;

    @Override
    public void init(SoccerPlayer soccerPlayer, SoccerGame game) {
       //topu nereye doğru vuracak onu buluyor(hangşi kale)
        kickTarget = game.getGoalAreaCenter(game.opponent(soccerPlayer.getTeam()));
    }

    @Override
    public SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
      //Burada futbolcunun hareket algoritması yazılacak
        return new Seek(game.getBallPosition());
    }

    @Override
    public SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game) {


        SoccerPlayer p = game.getPlayer(0,0);

//topun hareketini eğer vurulacak top varsa topa vurup döndürüyor

        if (kickTarget!= null)
            return new SteeringInfo(kickTarget.minus(soccerPlayer.getPosition()),0, SteeringInfo.SteeringType.Kinematic);
        else return SteeringInfo.NoSteering;

    }
}
