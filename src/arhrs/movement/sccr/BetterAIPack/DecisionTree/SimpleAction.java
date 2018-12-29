package arhrs.movement.sccr.BetterAIPack.DecisionTree;

import arhrs.movement.sccr.BetterAIPack.Actions.Action;
import arhrs.movement.sccr.BetterAIPack.Actions.Action;
import arhrs.movement.steering.SteeringBehavior;

public class SimpleAction extends Action {
    String actionText;

    public SimpleAction(String actionText) {
        this.actionText = actionText;
    }

    public String toString()
    {
        return actionText;
    }

    @Override
    public SteeringBehavior getSteering() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
