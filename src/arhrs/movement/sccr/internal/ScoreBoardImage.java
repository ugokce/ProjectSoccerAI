package arhrs.movement.sccr.internal;

import arhrs.movement.Renderable;//live.movement.Renderable;
import arhrs.movement.StaticInfo;//movement.StaticInfo;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

public class ScoreBoardImage implements Renderable {


    public static final float ScoreBoardCellWidth = 15;
    public static final float ScoreBoardCellHeight = 20;
    public static final Color ScoreBoardColor = Color.white;
    public static final float ScoreBoardMargin = 2;
    ScoreBoard scoreBoard;


    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    @Override
    public void render(StaticInfo pos, Graphics g) {
        g.setColor(SimpleSoccerPlayer.PlayerColors[0]);
        
        g.fillRect((float) pos.getPosition().x(),(float) pos.getPosition().y(),ScoreBoardCellWidth,ScoreBoardCellHeight);
        g.setColor(SimpleSoccerPlayer.PlayerColors[1]);
        g.fillRect((float) pos.getPosition().x()+ScoreBoardCellWidth,(float) pos.getPosition().y(),ScoreBoardCellWidth,ScoreBoardCellHeight);

        g.setColor(ScoreBoardColor);
        g.drawRect((float) pos.getPosition().x(),(float) pos.getPosition().y(),ScoreBoardCellWidth,ScoreBoardCellHeight);
        g.drawRect((float) pos.getPosition().x()+ScoreBoardCellWidth,(float) pos.getPosition().y(),ScoreBoardCellWidth,ScoreBoardCellHeight);


        g.drawString(""+scoreBoard.getScore(0),(float) pos.getPosition().x()+ScoreBoardMargin, (float)pos.getPosition().y()+ScoreBoardMargin);
        g.drawString(""+scoreBoard.getScore(1),(float) pos.getPosition().x()+ScoreBoardCellWidth+ScoreBoardMargin, (float)pos.getPosition().y()+ScoreBoardMargin);
    }



    @Override
    public double getRadius() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
