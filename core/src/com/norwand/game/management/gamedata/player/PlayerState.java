package com.norwand.game.management.gamedata.player;

import com.badlogic.gdx.graphics.Pixmap;

/** Represents a single state that belongs to a player. */
public abstract class PlayerState {

    /** Pointer to the player object. Can be usefull when switching state. */
    @SuppressWarnings("unused")
    private Player player;

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

    // TODO : controls
}
