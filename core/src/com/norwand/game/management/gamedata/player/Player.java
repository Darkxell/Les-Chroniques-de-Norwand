package com.norwand.game.management.gamedata.player;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Directions;
import com.norwand.game.utility.objects.Position;

/** Object that represents the playable player. */
public class Player {

    /** The direction faced by the player. */
    public int facing = Directions.SOUTH;
    /** The x position of the player in the current floor. */
    public int x = 5;
    /** The y position of the player in the current floor. */
    public int y = 11;
    /** Player specific information. */
    public PlayerInfo info;
    /**
     * The current state of the player. This represents what the player is
     * currently doing and allows to get the correct player sprite at any
     * moment.
     */
    public PlayerState state;

    /** The player inventory. */
    public Inventory inventory;

    public void update() {

    }

    /**
     * Gets the sprite of the player at this moment. The returned pixmap MUST be
     * Undisposable, meaning it doesn't allow drawing, but you don' need (and
     * musn't) dispose of it.
     */
    public Pixmap getSprite() {
	return ImagesHolder.tileset.getTile(3);
    }

    /** Called when the user taps the screen (mosly dash) */
    public void onTap(Position pos) {

    }

    /** Called when the user long presses or drags. */
    public void onMoveTo(Position pos) {

    }

    /** Called when the player stop moving. */
    public void onStop() {

    }

    /** Called when the user uses a skill at the position pos. */
    public void onSkillUsed(Position pos, Capacity capacity) {

    }

}
