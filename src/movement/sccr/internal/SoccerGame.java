package arhrs.movement.sccr.internal;

import math.geom2d.Point2D;
import math.geom2d.Vector2D;

public interface SoccerGame {

    public static final float FRAME_WIDTH = 40;
    public static final double KickDistance = 1;
    public static final float CenterCircleRadius = 80;
    public static final float PenaltyAreaHeight = 300;
    public static final float PenalyAreaWidth = 200;
    public static final float GoalAreaHeight = 140;
    public static final float GoalAreaWidth = 70;
    public static final float GoalHeight = 80;
    public static final float CenterPointRadius = 5;
    public static final double MaxBallSpeed = 5;


    Vector2D getBallPosition();
    Vector2D getBallVelocity();
    int getPlayerCount(int team);
    SoccerPlayer getPlayer(int team,int index);

    // returns the opponent team
    int opponent(int team);

    //returns the middle point of GoalArea of team
    Vector2D getGoalAreaCenter(int team);

    float getWidth();
    float getHeight();



}
