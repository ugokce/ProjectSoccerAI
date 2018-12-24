/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.GoztepeAI.PlayerAI;
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import arhrs.movement.sccr.BetterAIPack.State;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import live.decisiconmaking.decisiontree.GameData;
import live.decisiconmaking.decisiontree.GameDataClass;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public class BetterAI implements  PlayerAI{

    
    public SoccerPlayer ballOwner;
    private Vector2D kickTarget;
    public  double ShootDistance=10;
    
    
    @Override
    public void init(SoccerPlayer soccerPlayer, SoccerGame game) {
        
    }

    @Override
    public SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
      
        GameData gdata = new GameDataClass(game, soccerPlayer,ShootDistance);
         
        /*
            Action action = root.makeDecision(gdata);
            System.out.println(action);
            System.out.println("-------------------------------------------");*/
        
        
        ballOwner = getBallOwner(game);
       kickTarget = game.getGoalAreaCenter(game.opponent(soccerPlayer.getTeam()));
       if(ballOwner.getTeam() == soccerPlayer.getTeam())
        {
            //my team have the ball
            if(ballOwner == soccerPlayer)
            {
                //i have the ball
                if(FreeToRunForward(soccerPlayer,game))
                {
                    //i can walk to the goal, its free
                   
                    // drive the ball through the goal(funtion call)
                    //calculating the magnitude of vector to learn distance between player and goal
                   double magnitude = Math.sqrt((kickTarget.minus(soccerPlayer.getPosition()).x()*kickTarget.minus(soccerPlayer.getPosition()).x())+(kickTarget.minus(soccerPlayer.getPosition()).y()*kickTarget.minus(soccerPlayer.getPosition()).y()));
                   if(magnitude<=ShootDistance)//if distance less or equal than shootDistance we can shoot
                   {
                       //maybe 
                       
                   }
                    
                }
                else
                {
                    
                    //there is an opponent player in front of me
                    
                    
                }
            }
            else
            {
                //my teammate have the ball
                
                
            }
            
        }
        else
        {
            //other team have the ball
            
        }
        
        
       return null;
    }

    @Override
    public SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private SoccerPlayer getBallOwner(SoccerGame game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean FreeToRunForward(SoccerPlayer soccerPlayer, SoccerGame game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
