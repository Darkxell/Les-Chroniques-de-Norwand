package com.norwand.game.management.gamestates.top.launched.explore.play;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;

/**
 * THis is the main state of the game. This state draws the environement, your
 * player and the HUD. THis is basically where you explore the world you're in,
 * you fight...<br>
 * The user inputs recorded by this state will be redirected to the player
 * Object after processing.
 */
public class PlayState extends GameState {

    /** Stored pointer to the LaunchedState GameData attribute. */
    GameData datapointer = ((LaunchedState) parent.parent).data;

    public PlayState(GameState parent) {
	super(parent);
    }

    @Override
    public void update() {
	datapointer.update();
    }

    @Override
    public void print(Pixmap g) {
    }

    public void onPress(UserEvent e) {
	datapointer.player.onPress(e);
    }

    public void onDrag(UserEvent e) {
	datapointer.player.onDrag(e);
    }

    public void onRelease(UserEvent e) {
	datapointer.player.onRelease(e);
    }

    public void onKeyPressed(UserEvent e) {
	datapointer.player.onKeyPressed(e);
    }

    public void onKeyReleased(UserEvent e) {
	datapointer.player.onKeyReleased(e);
    }

    public void onType(UserEvent e) {
	datapointer.player.onType(e);
    }

}
