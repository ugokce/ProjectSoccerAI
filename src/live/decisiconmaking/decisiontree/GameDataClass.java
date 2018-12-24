/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package live.decisiconmaking.decisiontree;

import arhrs.movement.sccr.internal.SoccerGame;
import arhrs.movement.sccr.internal.SoccerPlayer;

/**
 *
 * @author Uğurcan
 */
public class GameDataClass implements GameData{
     SoccerGame game;
    SoccerPlayer player;
     double shootDistance=10;

    public GameDataClass(SoccerGame game, SoccerPlayer player,double  ShootDistance) {
        this.game = game;
        this.player = player;
        this.shootDistance = ShootDistance;
    }

     @Override
    public SoccerGame getGame() {
        return game;
    }

     @Override
    public SoccerPlayer getPlayer() {
        return player;
    }

    @Override
    public double getShootRange() {
        return shootDistance;
    }
    
    
}
