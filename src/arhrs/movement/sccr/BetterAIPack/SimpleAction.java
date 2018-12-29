package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.BetterAIPack.Action;

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
