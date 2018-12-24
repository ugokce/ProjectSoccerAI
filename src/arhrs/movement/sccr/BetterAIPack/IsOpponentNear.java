/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import java.awt.geom.Line2D;
import live.decisiconmaking.decisiontree.GameData;
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
        Vector2D opponentGoal = game.getGoalAreaCenter(game.opponent(soccerPlayer.getTeam()));
        int opponentTeam = game.opponent(soccerPlayer.getTeam());
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
             
            
      return VectorCalculator.RandomReverse(isNotFree);
    }
    
}
