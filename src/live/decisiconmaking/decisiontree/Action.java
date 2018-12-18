package live.decisiconmaking.decisiontree;

public class Action implements DecisionTreeNode {
    @Override
    public Action makeDecision(GameData game) {
        return this;
    }
}
