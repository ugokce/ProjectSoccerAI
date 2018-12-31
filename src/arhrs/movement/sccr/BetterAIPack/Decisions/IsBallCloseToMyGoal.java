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
 * @author Burak Kara
 */
public class IsBallCloseToMyGoal implements DecisionCase{

    @Override
    public boolean Check(GameData gamedata) {
        
        SoccerGame game = gamedata.getGame();
        SoccerPlayer soccerPlayer = gamedata.getPlayer();
        Vector2D ourGoal = game.getGoalAreaCenter(soccerPlayer.getTeam());
        if(VectorCalculator.CalculateMagnitude(ourGoal, game.getBallPosition())<=300)
        {
            return true;
        }
        else
            return false;
        
        
        
       
        
        
        
        
    }
    
}
