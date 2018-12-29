/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack.Actions;

import arhrs.movement.steering.Arrive;
import arhrs.movement.steering.Seek;
import arhrs.movement.steering.SteeringBehavior;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public class RunToBase extends Action{

     
            
    public  RunToBase(Vector2D target )
    {
      
        this.target = target;
        
    }
    
    
    @Override
    public SteeringBehavior getSteering()
    {
        return new Arrive(target);
    }
    
}
