/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import live.decisiconmaking.decisiontree.GameData;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public class AmIClosestToTheBallInMyTeam implements DecisionCase {


    @Override
    public boolean Check(GameData gamedata) {
        
    SoccerGame game = gamedata.getGame();
    SoccerPlayer soccerPlayer = gamedata.getPlayer();
    double ourDist = Math.sqrt((game.getBallPosition().minus(soccerPlayer.getPosition()).x()*game.getBallPosition().minus(soccerPlayer.getPosition()).x())+(game.getBallPosition().minus(soccerPlayer.getPosition()).y()*game.getBallPosition().minus(soccerPlayer.getPosition()).y()));
        for(int i=0;i<game.getPlayerCount(soccerPlayer.getTeam());i++)
        {
                 double otherDist = Math.sqrt((game.getBallPosition().minus(game.getPlayer(soccerPlayer.getTeam(), i).getPosition()).x()*game.getBallPosition().minus(game.getPlayer(soccerPlayer.getTeam(), i).getPosition()).x())+(game.getBallPosition().minus(game.getPlayer(soccerPlayer.getTeam(), i).getPosition()).y()*game.getBallPosition().minus(game.getPlayer(soccerPlayer.getTeam(), i).getPosition()).y()));
                 if(ourDist>otherDist)
                 {
                     return false;
                 }
        
        }
        
    
     return true;
      
          
    }
    
}
