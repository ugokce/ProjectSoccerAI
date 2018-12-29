package arhrs.movement.sccr.BetterAIPack.Actions;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionTreeNode;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;

public class Action implements DecisionTreeNode {
    @Override
    public Action makeDecision(GameData game) {
        return this;
    }
}
