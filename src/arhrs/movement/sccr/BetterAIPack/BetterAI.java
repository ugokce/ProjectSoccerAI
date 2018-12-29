/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.UserProvidedDecision;
import arhrs.movement.sccr.BetterAIPack.Actions.Action;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.SimpleAction;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionTreeNode;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.Decision;
import arhrs.movement.sccr.internal.PlayerAI; 
import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;
//import arhrs.movement.sccr.BetterAIPack.State;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import math.geom2d.Vector2D;

/**
 *
 * @author Uğurcan
 */
public class BetterAI implements  PlayerAI{

    
    public SoccerPlayer ballOwner;
    private Vector2D kickTarget;
    public  double ShootDistance=10;
    PlayerType playerType;
    public Vector2D playerBase;
    DecisionTreeNode root;
    public BetterAI(PlayerType AiType) {
    
       playerType = AiType;
      
    }
    
    
    @Override
    public void init(SoccerPlayer soccerPlayer, SoccerGame game) {
        
        Vector2D initalPOS = soccerPlayer.getPosition();
        playerBase = playerType.caculateBasePos(playerType, initalPOS, soccerPlayer.getTeam(), game);
        root = buildMyDecisionTree();
    }

    
    @Override
    public SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
      
        GameData gdata = new GameDataClass(game, soccerPlayer,ShootDistance,playerType);
        SteeringBehavior behaviour;
         
       
        
            Action action = root.makeDecision(gdata);
            kickTarget =action.getTarget();
            return action.getSteering();
            
            

    }

    @Override
    public SteeringInfo getBallSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
          if (kickTarget!= null)
            return new SteeringInfo(kickTarget.minus(soccerPlayer.getPosition()),0, SteeringInfo.SteeringType.Kinematic);
        else return SteeringInfo.getNoSteering();
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
