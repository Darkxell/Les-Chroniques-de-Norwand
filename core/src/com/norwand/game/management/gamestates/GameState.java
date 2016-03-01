package com.norwand.game.management.gamestates;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;

/** A part of the state tree. */
public abstract class GameState {

    /** The state above in the state tree. */
    public GameState parent;

    /**
     * The actual state below in the state tree. Can be null if this state is a
     * leaf.
     */
    public GameState substate;

    /**
     * Creates a new GameState with his parent. The parent is used to change
     * states inside the game, and therefore not needed for a
     * <code>TopState</code> Instance.
     */
    public GameState(GameState parent) {
	this.parent = parent;
    }

    /** Updates this state and his son if it has one. */
    public abstract void update();

    /**
     * Prints this state and his son if he has one using the specified graphics
     * object.
     */
    public abstract void print(Pixmap g);

    /** Called when the user presses the screen with a mouse or his finger. */
    public abstract void onPress(UserEvent e);

    /** Called when the user drags his mouse or his finger on the screen. */
    public abstract void onDrag(UserEvent e);

    /** Called when the user releases the screen with a mouse or his finger. */
    public abstract void onRelease(UserEvent e);

    /** Called when the user presses a key on his keyboard. */
    public abstract void onKeyPressed(UserEvent e);

    /** Called when the user releases a key on his keyboard. */
    public abstract void onKeyReleased(UserEvent e);

    /** Called when the user types in a key. */
    public abstract void onType(UserEvent e);
}