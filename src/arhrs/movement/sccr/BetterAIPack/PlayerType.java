/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.SoccerGame;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public enum PlayerType {
    
    Defence,Middle,Forward;
    
    public Vector2D caculateBasePos(PlayerType plType,Vector2D initialPOS,int team,SoccerGame game)
    {
        switch(plType)
        {
            case Forward:{
                if (team==0) {
                    return new Vector2D(initialPOS.x()+(game.getWidth()/2),initialPOS.y() );
                }
                else
                {
                    return new Vector2D(initialPOS.x()-(game.getWidth()/2),initialPOS.y() );
                }
            }
            default:
            {
                if(team == 0)
                {
                    return new Vector2D(initialPOS.x()+(game.getWidth()/10),initialPOS.y() );
                }
                else
                {
                     return new Vector2D(initialPOS.x()-(game.getWidth()/10),initialPOS.y() );
                }
            }
            
        }
        
    }
    
}
