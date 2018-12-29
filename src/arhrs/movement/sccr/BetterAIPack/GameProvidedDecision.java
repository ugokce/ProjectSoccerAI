/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.Decision;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionCase;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionTreeNode;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;

/**
 *
 * @author Uğurcan
 */
public class GameProvidedDecision extends Decision {

    DecisionCase dCase;
    
    public GameProvidedDecision(DecisionTreeNode trueNode, DecisionTreeNode falseNode,DecisionCase dcase) {
        super(trueNode, falseNode);
        this.dCase = dcase;
    }

    @Override
    protected DecisionTreeNode getBranch(GameData gameData) {

       
                 if(dCase.Check(gameData))
                     return trueNode.makeDecision(gameData);
               else return falseNode.makeDecision(gameData);
               
    }
    
}
