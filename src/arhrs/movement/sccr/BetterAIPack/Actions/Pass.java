/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Actions;

import arhrs.movement.sccr.BetterAIPack.VectorCalculator;
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import arhrs.movement.steering.Arrive;
import arhrs.movement.steering.Seek;
import arhrs.movement.steering.SteeringBehavior;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public class Pass extends Action{

    SoccerPlayer player;
    SoccerGame game;
    Vector2D base;
     public  Pass(SoccerPlayer player,SoccerGame game,Vector2D base )
    {
        this.player = player;
        this.game = game;
        this.base = base;
    }
    public Vector2D findClosestTeamMate()
    {
        double distance=game.getWidth();
        Vector2D POS = new Vector2D(0,0);
        for (int i = 0; i < game.getPlayerCount(player.getTeam()); i++) 
        {
              if(distance>VectorCalculator.CalculateMagnitude(player.getPosition(), game.getPlayer(player.getTeam(), i).getPosition()))
              {
               distance=VectorCalculator.CalculateMagnitude(player.getPosition(), game.getPlayer(player.getTeam(), i).getPosition());
               POS =  game.getPlayer(player.getTeam(), i).getPosition();
              }
        }
        return POS;
        
    }
    
    @Override
    public SteeringBehavior getSteering()
    {
        this.target = findClosestTeamMate();
        return new Arrive(base);
    }
    
}
