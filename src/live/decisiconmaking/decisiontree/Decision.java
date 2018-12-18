package live.decisiconmaking.decisiontree;

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
