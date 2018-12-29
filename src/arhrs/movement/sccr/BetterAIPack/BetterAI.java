/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.UserProvidedDecision;
import arhrs.movement.sccr.BetterAIPack.Actions.Action;
import arhrs.movement.sccr.BetterAIPack.Actions.DefenceInGoalArea;
import arhrs.movement.sccr.BetterAIPack.Actions.Dribling;
import arhrs.movement.sccr.BetterAIPack.Actions.Pass;
import arhrs.movement.sccr.BetterAIPack.Actions.RunToBase;
import arhrs.movement.sccr.BetterAIPack.Actions.Shoot;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.SimpleAction;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionTreeNode;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.Decision;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionCase;
import arhrs.movement.sccr.BetterAIPack.Decisions.AmIAtTheBall;
import arhrs.movement.sccr.BetterAIPack.Decisions.AmIClosestToTheBallInMyTeam;
import arhrs.movement.sccr.BetterAIPack.Decisions.AmIDefender;
import arhrs.movement.sccr.BetterAIPack.Decisions.AmINearTheGoal;
import arhrs.movement.sccr.BetterAIPack.Decisions.IsOpponentNear;
import arhrs.movement.sccr.BetterAIPack.Decisions.IsOpponentNearGoal;
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
        root = buildMyDecisionTree(game,soccerPlayer,playerBase);
    }

    
    @Override
    public SteeringBehavior getSteering(SoccerPlayer soccerPlayer, SoccerGame game) {
      
        GameData gdata = new GameDataClass(game, soccerPlayer,ShootDistance,playerType);
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
    
      private static DecisionTreeNode buildMyDecisionTree(SoccerGame game,SoccerPlayer player,Vector2D basePOS) {
        Action dribble = new Dribling(game, player);
        Action pass = new Pass( player, game,basePOS);
        Action shoot  = new Shoot(game,player.getTeam());
        Action DefenceInGoalArea= new DefenceInGoalArea(game);
        Action runToBase= new RunToBase(basePOS);
        
        
        
        Decision AmIDefender = new GameProvidedDecision(runToBase, DefenceInGoalArea, new AmIDefender());
       Decision IsOpponentNearGoal = new GameProvidedDecision(DefenceInGoalArea, AmIDefender, new IsOpponentNearGoal());
        Decision opponentIsNear = new GameProvidedDecision(pass, dribble, new IsOpponentNear() );
        Decision AmInearGoal = new GameProvidedDecision(shoot, opponentIsNear, new AmINearTheGoal());
        Decision AmIatTheBall = new GameProvidedDecision(AmInearGoal,DefenceInGoalArea ,new AmIAtTheBall());
        Decision AmIClosestToBallInmyTeam = new GameProvidedDecision(AmIatTheBall, runToBase,new AmIClosestToTheBallInMyTeam());




        return AmIClosestToBallInmyTeam;
    }

   
    
}
