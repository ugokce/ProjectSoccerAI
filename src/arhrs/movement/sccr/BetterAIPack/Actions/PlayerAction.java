/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Actions;

import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;

/**
 *
 * @author Uğurcan
 */
public class PlayerAction extends Action{
    //burada objemiz seek gibi her action için spesifik(mesela topu kap,bölgeme dön tarzı) steeringbehaviour lar alacak ve gerektiğinde onları döndürecek.
    
    public SteeringBehavior playerBehaviour;
            
    public  PlayerAction(SteeringBehavior behaviour )
    {
        this.playerBehaviour = behaviour;
    }
    
    
    public SteeringBehavior getSteering()
    {
        
        return this.playerBehaviour;
    }
}
