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
import arhrs.movement.steering.SteeringInfo;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public class Dribling extends Action{
    //burada objemiz seek gibi her action için spesifik(mesela topu kap,bölgeme dön tarzı) steeringbehaviour lar alacak ve gerektiğinde onları döndürecek.
    
 
    SoccerGame game;
    SoccerPlayer player;
     public  Dribling( SoccerGame game ,SoccerPlayer plyr)
    {
       this.player = plyr;
        this.game = game;
    }
    
    
    @Override
    public SteeringBehavior getSteering()
    {
        this.target=game.getGoalAreaCenter(game.opponent(player.getTeam()));
        return new Seek(game.getBallPosition());
       
    }
}
