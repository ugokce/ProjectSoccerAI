/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Decisions;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionCase;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.sccr.BetterAIPack.PlayerType;
import arhrs.movement.sccr.BetterAIPack.VectorCalculator;
import arhrs.movement.sccr.internal.SoccerPlayer;

/**
 *
 * @author Burak Kara
 */
public class AmIForward implements DecisionCase {

    @Override
    public boolean Check(GameData gamedata) {
        SoccerPlayer soccerPlayer = gamedata.getPlayer();
        return gamedata.getPLtype() == PlayerType.Forward || gamedata.getPLtype() == PlayerType.Middle;
    }
    
}
