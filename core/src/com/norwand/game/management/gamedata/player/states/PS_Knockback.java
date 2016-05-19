package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.management.gamestates.top.launched.menus.misc.GameOverState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Directions;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * State of the player representing it being knocked back. The player can't do
 * anything while being knocked back. This deals no dammage, you have to hurt
 * the player from an entity or environnement update() or knockback() method.
 */
public class PS_Knockback extends PlayerState {

    public PS_Knockback(Player player, MathVector direction) {
        super(player);
        this.direction = direction;
        this.length = 7;
    }

    public PS_Knockback(Player player, MathVector direction, int length) {
        this(player, direction);
        this.length = length;
    }

    /**
     * The knockback speed in tiles per frame.
     */
    private final double KS = 0.17;
    /**
     * The length of the knockback action, in frames.
     */
    private int length;
    private MathVector direction;

    @Override
    public void update() {
        if (player.info.health <= 0)
            MainGame.game.state.substate.substate.substate = new GameOverState(MainGame.game.state.substate.substate);
        --length;
        if (length < 0)
            player.state = new PS_Iddle(player);
        Position newpos = direction.getFixedTranslation(player.x, player.y, KS);
        if (player.canBeAt(newpos.x, player.y))
            player.x = newpos.x;
        if (player.canBeAt(player.x, newpos.y))
            player.y = newpos.y;
    }

    @Override
    public Pixmap getSprite() {
        switch (player.facing) {
            case Directions.SOUTH:
                return ImagesHolder.playerset.getTile((length % 4 < 2) ? 12 : 13);
            case Directions.WEST:
                return ImagesHolder.playerset.getTile((length % 4 < 2) ? 44 : 45);
            case Directions.EAST:
                return ImagesHolder.playerset.getTile((length % 4 < 2) ? 76 : 77);
            case Directions.NORTH:
                return ImagesHolder.playerset.getTile((length % 4 < 2) ? 108 : 109);
        }
        System.err.println("Unknown player direction, returned null.");
        return null;
    }

    @Override
    public void onTap(Position pos) {
    }

    @Override
    public void onMoveTo(Position pos) {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onSkillUsed(Position pos, Capacity capacity) {
    }

}
