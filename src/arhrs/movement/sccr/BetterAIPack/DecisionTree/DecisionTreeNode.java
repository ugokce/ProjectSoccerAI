package arhrs.movement.sccr.BetterAIPack.DecisionTree;

import arhrs.movement.sccr.BetterAIPack.Actions.Action;

public interface DecisionTreeNode {
    Action makeDecision(GameData game);
}
