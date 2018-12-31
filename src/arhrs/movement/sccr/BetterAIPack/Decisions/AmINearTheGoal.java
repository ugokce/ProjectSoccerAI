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
public class AmINearTheGoal implements DecisionCase{

    @Override
    public boolean Check(GameData gamedata) {
        
         SoccerGame game = gamedata.getGame();
         SoccerPlayer soccerPlayer = gamedata.getPlayer();
         Vector2D kickTarget = game.getGoalAreaCenter(game.opponent(soccerPlayer.getTeam()));
         double magnitude = VectorCalculator.CalculateMagnitude(soccerPlayer.getPosition(), kickTarget);
        if(magnitude<=200)
        {
            return true;
        }
        else
            return false;
         
        
        
    }
    
}
