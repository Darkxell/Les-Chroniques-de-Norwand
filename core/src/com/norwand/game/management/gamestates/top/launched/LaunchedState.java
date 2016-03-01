package com.norwand.game.management.gamestates.top.launched;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.ExploreState;

/**
 * This state is unseen by the user, and represents the parent state of all
 * other states that includes A running game. Basically, anything exept the main
 * menu of the game.
 */
public class LaunchedState extends GameState {

    /** The gamedata of this launchedstate. */
    public GameData data = new GameData();

    public LaunchedState(GameState parent) {
	super(parent);
	this.substate = new ExploreState(this);
    }

    @Override
    public void update() {
	substate.update();
    }

    @Override
    public void print(Pixmap g) {
	substate.print(g);
    }

    @Override
    public void onPress(UserEvent e) {
	substate.onPress(e);
    }

    @Override
    public void onDrag(UserEvent e) {
	substate.onDrag(e);
    }

    @Override
    public void onRelease(UserEvent e) {
	substate.onRelease(e);
    }

    @Override
    public void onKeyPressed(UserEvent e) {
	substate.onKeyPressed(e);
    }

    @Override
    public void onKeyReleased(UserEvent e) {
	substate.onKeyReleased(e);
    }

    @Override
    public void onType(UserEvent e) {
	substate.onType(e);
    }

}
