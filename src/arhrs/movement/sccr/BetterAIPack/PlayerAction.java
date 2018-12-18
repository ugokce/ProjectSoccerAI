/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import live.decisiconmaking.decisiontree.Action;

/**
 *
 * @author Uğurcan
 */
public class PlayerAction extends Action{
    
    SteeringInfo playerBehaviour;
            
    public  PlayerAction(SteeringInfo behaviour )
    {
        this.playerBehaviour = behaviour;
    }
    
    
    public SteeringInfo getSteering()
    {
        
        return this.playerBehaviour;
    }
}
