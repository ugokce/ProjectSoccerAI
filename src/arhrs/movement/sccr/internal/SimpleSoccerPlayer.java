package arhrs.movement.sccr.internal;


import arhrs.movement.*;
import arhrs.movement.steering.SteeringBehavior;
import arhrs.movement.steering.SteeringInfo;
import arhrs.util.VectorUtils;
import math.geom2d.Vector2D;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import java.util.concurrent.*;

class SimpleSoccerPlayer extends MovingEntity implements SoccerPlayer,GoalListener {

    boolean disqualified = false;
    private static final float PlayerRadius = 10;
    public static final Color[] PlayerColors = new Color[]{Color.red, Color.blue};
    public static final double PlayerMaxVelocity = 2;
    private static final double FatigueStamina = 50;
    private static final SteeringBehavior FatigueSteering = new FatigueBehavior();
    public static final double StaminaIncrement = 1;
    public static final double MaxStamina = 100;
    public static final double MinStamina = 0;
    private static final double StaminaPenalty = 0.8;
    private static final long TimeOut = 300; // MILLISECONDS

    protected final SoccerGameState gameState;
    private final int team;


    private Vector2D initialPosition;
    private SteeringInfo ballSteering;

    private PlayerAI playerAI;
    private double stamina;

    public void setPlayerAI(PlayerAI playerAI) {
        this.playerAI = playerAI;
    }


    void setInitialPosition(Vector2D pos)
    {
        initialPosition = pos;
    }

    public SimpleSoccerPlayer(SoccerGameState gameState, int team, PlayerAI playerAI ) {
        super(new SoccerPlayerImage(PlayerColors[team],PlayerRadius), new StaticInfo(new Vector2D(0,0),0, StaticInfo.OrientationType.VelocityBased), KinematicInfo.Zero(),gameState.getBounds());
        setCollisionHandler(new SimpleCollision(PlayerRadius));
        ((SoccerPlayerImage)shape).setPlayer(this);
        this.playerAI = playerAI;
        this.gameState = gameState;
        this.team = team;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        super.init(gameContainer, stateBasedGame);
        staticInfo.setPosition(initialPosition);
        stamina = MaxStamina;
        setBounds(gameState.getBounds());
        playerAI.init(this,gameState);
        disqualified = false;
    }

    @Override
    public final void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) {
/*
        steeringBehavior = playerAI.getSteering(this,gameState);
        if (canKickBall())
            ballSteering = playerAI.getBallSteering(this,gameState);
*/

        if (disqualified)
            return;

        performAICall();
        applyPlayerLimits();

        super.update(gameContainer,stateBasedGame,i);

    }

    private void performAICall() {
        Integer result = null;
        ExecutorService executor = Executors.newCachedThreadPool();
        SoccerPlayer sp = this;
        Callable<Integer> task = new Callable<Integer>() {
            public Integer call() {
                steeringBehavior = playerAI.getSteering(sp,gameState);
                if (canKickBall())
                    ballSteering = playerAI.getBallSteering(sp,gameState);
                return 0;
            }
        };
        Future<Integer> future = executor.submit(task);
        try {
            result = future.get(TimeOut, TimeUnit.MILLISECONDS);


        } catch (TimeoutException ex) {
            if (!gameState.gameOver) {
                System.out.println(ex);
                System.out.println("Team" + team + " disqualified due to timeout violation!");
                disqualify();
                gameState.disqualify(this);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            // handle the interrupts
        } catch (ExecutionException e) {
            if (!gameState.gameOver) {
                System.out.println(e);
                System.out.println("Team" + team + " disqualified due to INTERNAL exception!");
                disqualify();
                gameState.disqualify(this);
            }
        }
        finally {
            future.cancel(true);
        }
    }

    private void disqualify() {
        disqualified = true;
        ((SoccerPlayerImage)shape).setColor(Color.gray);
    }

    private void applyPlayerLimits() {

        setMaxVelocity(PlayerMaxVelocity);
        stamina += StaminaIncrement;
        stamina -= staminaPenalty();
        stamina = (stamina>MaxStamina ) ?  MaxStamina : (stamina<MinStamina) ? MinStamina : stamina;
        if (stamina < FatigueStamina)
            steeringBehavior = FatigueSteering;


    }

    private double staminaPenalty() {
        double speed = kinematicInfo.getVelocity().norm();
        if (speed>FatigueBehavior.FatigueSpeed)
            return StaminaPenalty*(speed-FatigueBehavior.FatigueSpeed);
        return 0;
    }

    private boolean canKickBall() {
        return (VectorUtils.distance(staticInfo.getPosition(),gameState.getBall().getPosition())<3*SoccerGame.KickDistance);
    }


    @Override
    public Vector2D getInitialPosition() {
        return initialPosition.clone();
    }

    public Vector2D getPosition(){
        return staticInfo.getPosition();
    }

    @Override
    public Vector2D getVelocity() {
        return kinematicInfo.getVelocity().clone();
    }

    @Override
    public int getTeam() {
        return team;
    }

    @Override
    public double getStamina() {
        return stamina;
    }

    @Override
    public double getFatigueStamina() {
        return FatigueStamina;
    }

    @Override
    public double getFatigueSpeed() {
        return FatigueBehavior.FatigueSpeed;
    }

    @Override
    public double getMaxStamina() {
        return MaxStamina;
    }

    @Override
    public double getMinStamina() {
        return MinStamina;
    }

    @Override
    public double getMaxSpeed() {
        return PlayerMaxVelocity;
    }

    @Override
    public double getStaminaIncrement() {
        return StaminaIncrement;
    }

    SteeringInfo getBallSteering() {
        return ballSteering;
    }

    @Override
    public final void goalScored(int team) {
        staticInfo.setPosition(initialPosition.clone());
        kinematicInfo = KinematicInfo.Zero();
        stamina = MaxStamina;
    }
}
