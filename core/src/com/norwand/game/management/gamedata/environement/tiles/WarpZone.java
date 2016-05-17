package com.norwand.game.management.gamedata.environement.tiles;

import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.transition.TransitionState;
import com.norwand.game.utility.objects.AnimatedSprite;
import com.norwand.game.utility.objects.Position;

/**
 * A special type of tile that warps the player to an other location in an other
 * floor.
 */
public abstract class WarpZone extends Tile {

    /**
     * The X destination of this warpzone in the destination floor.
     */
    private double tox;
    /**
     * The Y destination of this warpzone in the destination floor.
     */
    private double toy;

    /**
     * Creates a new WarpZone tile.
     */
    public WarpZone(byte type, AnimatedSprite[] background,
                    AnimatedSprite[] foreground, double x, double y) {
        super(type, background, foreground);
        tox = x;
        toy = y;
    }

    /**
     * Creates a new Warpzone tile using an existing tile. The data of the two
     * tiles are shared.
     */
    public WarpZone(Tile source, double x, double y) {
        super(source.type, source.background, source.foreground);
        tox = x;
        toy = y;
    }

    /**
     * Gets the destination floor of this warp zone.
     */
    public abstract Floor getDestination();

    /**
     * Returns the X destination of this warpzone in the destination floor.
     */
    public double getToX() {
        return tox;
    }

    /**
     * Returns the Y destination of this warpzone in the destination floor.
     */
    public double getToY() {
        return toy;
    }

    @Override
    public void update() {
        super.update();
        Position p = GameData.get().currentfloor.getTilePosition(this);
        if ((int) (GameData.get().player.x) == p.x
                && (int) (GameData.get().player.y) == p.y) {
            MainGame.game.state.substate.substate.substate = new TransitionState(
                    MainGame.game.state.substate.substate, getDestination(), tox, toy
            );
        }
    }

}
