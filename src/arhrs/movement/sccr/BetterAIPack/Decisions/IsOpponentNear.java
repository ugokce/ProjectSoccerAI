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
import java.awt.geom.Line2D;
import math.geom2d.Vector2D;
import org.newdawn.slick.*;

/**
 *
 * @author Uğurcan
 */
public class IsOpponentNear implements DecisionCase{

    private double diffLimit=10;

    
    @Override
    public boolean Check(GameData gamedata) {
       
        boolean isNotFree=true;
        SoccerGame game = gamedata.getGame();
        SoccerPlayer soccerPlayer = gamedata.getPlayer();
        int opponentTeam = game.opponent(soccerPlayer.getTeam());
        Vector2D opponentGoal = game.getGoalAreaCenter(opponentTeam);
        
        double diffOur = VectorCalculator.CalculateMagnitude(soccerPlayer.getPosition(), opponentGoal);
 
             for(int i=0;i<game.getPlayerCount(opponentTeam);i++)
             {
                 if((diffOur+diffLimit)<Math.sqrt(VectorCalculator.CalculateMagnitude(game.getPlayer(opponentTeam, i).getPosition(), soccerPlayer.getPosition())*VectorCalculator.CalculateMagnitude(game.getPlayer(opponentTeam, i).getPosition(), soccerPlayer.getPosition())*VectorCalculator.CalculateMagnitude(game.getPlayer(opponentTeam, i).getPosition(), opponentGoal)))
                 {
                     isNotFree= true;
                 }
                 else
                 {
                     
                     isNotFree= false;
                 }
                 
                 
             }
             
            
      return isNotFree;
    }
    
}
