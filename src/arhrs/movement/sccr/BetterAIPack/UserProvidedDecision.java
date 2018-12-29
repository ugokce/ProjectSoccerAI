package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.BetterAIPack.Decision;
import arhrs.movement.sccr.BetterAIPack.DecisionTreeNode;
import arhrs.movement.sccr.BetterAIPack.GameData;

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
