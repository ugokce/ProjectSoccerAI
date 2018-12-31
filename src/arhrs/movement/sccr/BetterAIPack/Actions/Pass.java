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
import arhrs.movement.steering.NoSteering;
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
    public Vector2D findOpenTeamMate()
    {
        double distance=game.getWidth();
        Vector2D POS = null;
        for (int i = 0; i < game.getPlayerCount(player.getTeam()); i++) 
        {
            Vector2D teamMatePos = game.getPlayer(player.getTeam(), i).getPosition();
            if(teamMatePos != player.getPosition())
              for(int k=0;k<game.getPlayerCount(game.opponent(player.getTeam()));k++)
              {
                  Vector2D oppoPos = game.getPlayer(game.opponent(player.getTeam()), k).getPosition();
                  double oppoTOus = VectorCalculator.CalculateMagnitude(player.getPosition(), oppoPos);
                  double oppoTOteamMate = VectorCalculator.CalculateMagnitude(oppoPos,teamMatePos);
                  if(VectorCalculator.CalculateMagnitude(player.getPosition(),teamMatePos)<(11+(oppoTOus+oppoTOteamMate)))
                  {
                      POS = teamMatePos;
                  }
              }
        }
        return POS;
        
    }
    
    @Override
    public SteeringBehavior getSteering()
    {
        this.target = findOpenTeamMate();
        return new Seek(game.getBallPosition());
    }
    
}
