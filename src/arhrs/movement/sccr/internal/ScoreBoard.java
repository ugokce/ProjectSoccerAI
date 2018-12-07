package arhrs.movement.sccr.internal;


import arhrs.movement.BasicGameEntity;
import arhrs.movement.StaticInfo;

public class ScoreBoard extends BasicGameEntity implements GoalListener {
    private int[] score= new int[2];

    public ScoreBoard( StaticInfo pos) {
        super(new ScoreBoardImage(), pos);
        ((ScoreBoardImage)shape).setScoreBoard(this);
    }

    @Override
    public void goalScored(int team) {
        score[team]++;
    }


    public int getScore(int team) {
        return score[team];
    }
}
