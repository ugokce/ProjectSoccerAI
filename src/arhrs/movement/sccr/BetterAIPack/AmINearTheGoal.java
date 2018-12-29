/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public class AmINearTheGoal implements DecisionCase{

    @Override
    public boolean Check(GameData gamedata) {
        
         SoccerGame game = gamedata.getGame();
         SoccerPlayer soccerPlayer = gamedata.getPlayer();
         Vector2D kickTarget = game.getGoalAreaCenter(game.opponent(soccerPlayer.getTeam()));
         double magnitude = Math.sqrt((kickTarget.minus(soccerPlayer.getPosition()).x()*kickTarget.minus(soccerPlayer.getPosition()).x())+(kickTarget.minus(soccerPlayer.getPosition()).y()*kickTarget.minus(soccerPlayer.getPosition()).y()));
        
         
        return gamedata.getShootRange()<magnitude;
        
    }
    
}
