package arhrs.movement.sccr.BetterAIPack.DecisionTree;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.Decision;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.DecisionTreeNode;
import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
import arhrs.movement.steering.SteeringBehavior;

import java.util.Scanner;

public class UserProvidedDecision extends Decision {

    String testQuestion;
    
    public UserProvidedDecision(DecisionTreeNode trueNode, DecisionTreeNode falseNode, String testQuestion) {
        super(trueNode, falseNode);
        this.testQuestion = testQuestion;
    }

    @Override
    protected DecisionTreeNode getBranch(GameData gameData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(testQuestion);

        String answer  = scanner.next();

        if (answer.toLowerCase().equals("no")|| answer.toLowerCase().equals("n"))
            return falseNode.makeDecision(gameData);
        else return trueNode.makeDecision(gameData);
    }

}
