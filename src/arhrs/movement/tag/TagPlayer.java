package arhrs.movement.tag;




import arhrs.movement.*;
import arhrs.movement.steering.*;

import arhrs.util.RandomUtils;
import math.geom2d.Vector2D;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import java.security.SecureRandom;
import java.util.Random;

public class TagPlayer extends MovingEntity implements TagGameListener {

    public final static int TagPlayerRadius= 10;
    public final static Color normalColor = Color.blue;
    public final static Color tagColor = Color.red;


    public final static SteeringBehavior newTagBehavior = new NewTagBehavor();
    public final static SteeringBehavior tagBehavior = new Arrive(new Vector2D(0,0));
    public final static SteeringBehavior nonTagBehavior = new Wander();



    TagGame game;
    TagPlayer tag;
    TagPlayer target;

    public TagPlayer(StaticInfo pos, KinematicInfo kinematic) {

        super(new Ball(normalColor,TagPlayerRadius),pos,kinematic, null);
        staticInfo.setOrientationType(StaticInfo.OrientationType.Explicit);
        setCollisionHandler(new SimpleCollision(TagPlayerRadius));
    }


    public void setGame(TagGame game) {
        this.game = game;
    }

    @Override
    public void tagChanged(TagPlayer newTag) {

        if (tag != newTag) {
            boolean aha = true;
        }
        tag = newTag;

        ((BasicRenderable)shape).setColor( (this == tag )? tagColor:normalColor);
        setSteeringBehavior( this == tag ? newTagBehavior:nonTagBehavior);
        staticInfo.setOrientationType(this == tag ? StaticInfo.OrientationType.VelocityBased: StaticInfo.OrientationType.Explicit);
        if (tag != this)
            target= tag;
    }

    private void chooseTarget() {
        TagPlayer p = game.players.get(RandomUtils.nextInt(game.players.size()));
        while (p==tag) {
            p = game.players.get(RandomUtils.nextInt(game.players.size()));
        }
        target = p;

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) {
        if (target != null)
            steeringBehavior.setTarget(target.staticInfo);
        super.update(gameContainer, stateBasedGame, i);
    }

    @Override
    public void tagStart(TagPlayer newTag) {
        setSteeringBehavior( this == tag ? tagBehavior:nonTagBehavior);
        if (this==tag)
            chooseTarget();
    }

    public boolean isTouching(TagPlayer player) {
        Ball b1 = (Ball) shape;
        Ball b2 = (Ball) player.getShape();

        return (staticInfo.getPosition().minus(player.staticInfo.getPosition()).norm()< b1.getRadius()+b2.getRadius());
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        super.init(gameContainer, stateBasedGame);
        setBounds(game.area.getBounds());
    }
}
