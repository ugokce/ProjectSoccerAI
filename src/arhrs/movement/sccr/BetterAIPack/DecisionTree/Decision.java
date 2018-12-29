package arhrs.movement.sccr.BetterAIPack.DecisionTree;

import arhrs.movement.sccr.BetterAIPack.Actions.Action;

public abstract class Decision implements DecisionTreeNode{

    protected DecisionTreeNode trueNode;
    protected DecisionTreeNode falseNode;

    protected abstract DecisionTreeNode getBranch(GameData gameData);

    public Decision(DecisionTreeNode trueNode, DecisionTreeNode falseNode) {
        this.trueNode = trueNode;
        this.falseNode = falseNode;
    }

    @Override
    public Action makeDecision(GameData game) {
        DecisionTreeNode decisionTreeNode = getBranch(game);
        return decisionTreeNode.makeDecision(game);
    }
}
