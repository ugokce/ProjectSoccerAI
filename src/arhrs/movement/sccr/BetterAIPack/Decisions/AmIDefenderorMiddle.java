/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Decisions;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionCase;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.sccr.BetterAIPack.PlayerType;
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;

/**
 *
 * @author Burak Kara
 */
public class AmIDefenderorMiddle implements DecisionCase {

    boolean i_am = true;
    @Override
    public boolean Check(GameData gamedata) {
        SoccerPlayer soccerPlayer = gamedata.getPlayer();
        if(gamedata.getPLtype() == PlayerType.Middle || gamedata.getPLtype() == PlayerType.Defence)
        {
           i_am = true; 
        }
        else
        {
            i_am = false; 
        }
        
      // return VectorCalculator.RandomReverse(i_am);
        return i_am;
    }
    
}
