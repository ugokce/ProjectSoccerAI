package arhrs.movement.tag;


import arhrs.movement.MovementPanel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class TagGame extends BasicGameState {

    public static final int TagTimeOutTime = 1000;

    MovementPanel area;
    List<TagPlayer> players = new ArrayList<>();
    TagPlayer tag;
    TagPlayer previousTag;
    int tagTimeOut;

    public TagGame() {
        this.area = new MovementPanel();
    }

    void addPlayer(TagPlayer tagPlayer)
    {
        players.add(tagPlayer);
        tagPlayer.setGame(this);
        tagPlayer.setBounds(area.getBounds());
        area.addEntity(tagPlayer);
    }

    void setTag(TagPlayer player)
    {
        if (tag != player)
        {
            previousTag = tag;
            tag = player;
            tagTimeOut = TagTimeOutTime;

        }
        notifyTagChanged(player);
    }

    private void notifyTagChanged(TagPlayer player) {
        for (TagGameListener tagGameListener: players
             ) {
            tagGameListener.tagChanged(player);
        }
    }




    private void checkTagging() {
        if (tag==null)
            return;
        for (TagPlayer player :
                players) {
            if (tag == player)
                continue;

            if (tag.isTouching(player))
            {
                setTag(player);
                return;
            }
        }
    }




    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        area.init(gameContainer,stateBasedGame);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        area.render(gameContainer,stateBasedGame,graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        area.update(gameContainer,stateBasedGame,i);
        if (tagTimeOut>0)
        {
            tagTimeOut--;
            if (tagTimeOut==0)
                tag.tagStart(tag);
            return;
        }

        checkTagging();


    }
}
