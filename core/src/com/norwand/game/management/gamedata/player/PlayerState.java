package com.norwand.game.management.gamedata.player;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.utility.objects.Position;

/** Represents a single state that belongs to a player. */
public abstract class PlayerState {

    /** Pointer to the player object. Can be usefull when switching state. */
    protected Player player;

    /** Constructs a new PlayerState using the link to the player. */
    public PlayerState(Player player) {
	this.player = player;
    }

    /** Updates this state to the next frame. */
    public abstract void update();

    /**
     * Returns a rectangular pixmap used to draw the player in its current
     * state.
     */
    public abstract Pixmap getSprite();

    /** Called when the user taps the screen (mosly dash) */
    public abstract void onTap(Position pos);

    /** Called when the user long presses or drags. */
    public abstract void onMoveTo(Position pos);

    /** Called when the player stop moving. */
    public abstract void onStop();

    /** Called when the user uses a skill at the position pos. */
    public abstract void onSkillUsed(Position pos, Capacity capacity);
}
