/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;

/**
 *
 * @author Burak Kara
 */
public class AmIDefender implements DecisionCase {

    @Override
    public boolean Check(GameData gamedata) {
        SoccerGame game = gamedata.getGame();
        SoccerPlayer soccerPlayer = gamedata.getPlayer();
        return false;
    }
    
}
