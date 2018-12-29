/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import arhrs.movement.sccr.BetterAIPack.DecisionTree.GameData;
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
     PlayerType PLtype;

 

    public GameDataClass(SoccerGame game, SoccerPlayer player,double  ShootDistance,PlayerType Ptype) {
        this.game = game;
        this.player = player;
        this.shootDistance = ShootDistance;
        this.PLtype = Ptype;
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

    @Override
    public double getShootDistance() {
        return shootDistance;
    }

    @Override
    public PlayerType getPLtype() {
       return  PLtype;
    }
    
    
}
