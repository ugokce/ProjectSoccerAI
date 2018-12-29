package arhrs.movement.sccr.BetterAIPack.DecisionTree;

import arhrs.movement.sccr.BetterAIPack.Actions.Action;
import arhrs.movement.sccr.BetterAIPack.Actions.Action;

public class SimpleAction extends Action {
    String actionText;

    public SimpleAction(String actionText) {
        this.actionText = actionText;
    }

    public String toString()
    {
        return actionText;
    }

}
