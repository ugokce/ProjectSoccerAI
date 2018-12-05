/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.internal;

import arhrs.movement.sccr.internal.GoztepeAI.PlayerAI;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;

/**
 *
 * @author Uğurcan
 */
public class BetterAI implements  PlayerAI{

    @Override
    public void init(SoccerPlayer soccerPlayer, SoccerGame game) {
        
    }

    @Override
    public SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
