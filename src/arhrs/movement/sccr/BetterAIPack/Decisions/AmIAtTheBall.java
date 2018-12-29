/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Decisions;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionCase;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;

/**
 *
 * @author Burak Kara
 */
public class AmIAtTheBall implements DecisionCase{

    
    @Override
    public boolean Check(GameData gamedata) {
        
        SoccerGame game = gamedata.getGame();
        SoccerPlayer soccerPlayer = gamedata.getPlayer();
        double ourDist = Math.sqrt((game.getBallPosition().minus(soccerPlayer.getPosition()).x()*game.getBallPosition().minus(soccerPlayer.getPosition()).x())+(game.getBallPosition().minus(soccerPlayer.getPosition()).y()*game.getBallPosition().minus(soccerPlayer.getPosition()).y()));
        return ourDist <= 11;
    }
    
}
