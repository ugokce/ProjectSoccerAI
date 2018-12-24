package live.decisiconmaking.decisiontree.demo;

import live.decisiconmaking.decisiontree.Action;
import live.decisiconmaking.decisiontree.Decision;
import live.decisiconmaking.decisiontree.DecisionTreeNode;

public class DecisionTreeDemo {
    public static void main(String[] args) {
        DecisionTreeNode root = buildMyDecisionTree();

        while (true) {
            Action action = root.makeDecision(null);
            System.out.println(action);
            System.out.println("-------------------------------------------");
            
        }
    }

    private static DecisionTreeNode buildMyDecisionTree() {
        Action dribble = new SimpleAction("I am dribbleing");
        Action pass = new SimpleAction("I am passing");
        Action shoot  = new SimpleAction("I am shooting");
        Action runToBall= new SimpleAction( "I am running to ball" );
        Action runToBase= new SimpleAction( "I am running to my base" );


        Decision opponentIsNear = new UserProvidedDecision(pass, dribble,"Is opponent near?");
        Decision nearGoal = new UserProvidedDecision(shoot, opponentIsNear,"Am I near the goal?");
        Decision atTheBall = new UserProvidedDecision(nearGoal, runToBall,"Am I at the ball?");
        Decision closestToBall = new UserProvidedDecision(atTheBall, runToBase,"Am I closest to the ball in my team?");




        return closestToBall;
    }
}
