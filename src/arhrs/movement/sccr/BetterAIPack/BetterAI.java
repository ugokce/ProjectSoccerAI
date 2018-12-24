/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.internal.PlayerAI; 
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
import arhrs.movement.sccr.BetterAIPack.State;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import live.decisiconmaking.decisiontree.Action;
import live.decisiconmaking.decisiontree.Decision;
import live.decisiconmaking.decisiontree.DecisionTreeNode;
import live.decisiconmaking.decisiontree.GameData;
import live.decisiconmaking.decisiontree.GameDataClass;
import live.decisiconmaking.decisiontree.demo.SimpleAction;
import live.decisiconmaking.decisiontree.demo.UserProvidedDecision;
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
        SteeringBehavior behaviour;
         
       
        /*
            Action action = root.makeDecision(gdata);
            System.out.println(action);
            System.out.println("-------------------------------------------");*/
        
        
      
       
      
          
            
     
        
        
       return null;
    }

    @Override
    public SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      private static DecisionTreeNode buildMyDecisionTree() {
        Action dribble = new SimpleAction("I am dribbleing");
        Action pass = new SimpleAction("I am passing");
        Action shoot  = new SimpleAction("I am shooting");
        Action runToBall= new SimpleAction( "I am running to ball" );
        Action runToBase= new SimpleAction( "I am running to my base" );


        Decision opponentIsNear = new UserProvidedDecision(pass, dribble,"Is opponent near?");
        Decision nearGoal = new UserProvidedDecision(shoot, opponentIsNear,"Am I near the goal?");
        Decision atTheBall = new UserProvidedDecision(nearGoal, runToBall,"Am I at the ball?");
        Decision closestToBall = new UserProvidedDecision(atTheBall, runToBase,"Am I closest to the ball in my team?");




        return closestToBall;
    }

   
    
}
