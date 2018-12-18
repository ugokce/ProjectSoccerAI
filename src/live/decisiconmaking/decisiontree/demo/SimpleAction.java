package live.decisiconmaking.decisiontree.demo;

import live.decisiconmaking.decisiontree.Action;

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
