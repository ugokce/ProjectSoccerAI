/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Decisions;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionCase;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.sccr.BetterAIPack.VectorCalculator;
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
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
   
    double ourDist = VectorCalculator.CalculateMagnitude(game.getBallPosition(), soccerPlayer.getPosition());
        for(int i=0;i<game.getPlayerCount(soccerPlayer.getTeam());i++)
        {
                 double otherDist = VectorCalculator.CalculateMagnitude(game.getBallPosition(), game.getPlayer(soccerPlayer.getTeam(), i).getPosition());
                 if(ourDist>otherDist)
                 {
                     return false;
                 }
        
        }
     return true;
      
          
    }
    
}
