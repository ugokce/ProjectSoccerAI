/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Actions;

import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import arhrs.movement.steering.Seek;
import arhrs.movement.steering.SteeringBehavior;
import math.geom2d.Vector2D;

/**
 *
 * @author Burak Kara
 */
public class DefenceInGoalArea extends Action
{
    
    SoccerGame game;
            
     public  DefenceInGoalArea(SoccerGame game )
    {
       
        this.game = game;
    }
    
    
    @Override
    public SteeringBehavior getSteering()
    {
        return new Seek(game.getBallPosition());
    }
}
