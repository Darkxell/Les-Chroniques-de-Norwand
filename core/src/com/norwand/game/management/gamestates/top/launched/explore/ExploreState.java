package com.norwand.game.management.gamestates.top.launched.explore;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;

/**
 * This unseen by the user state represents all of the exploration possible. It
 * contains all the states where you see your player, the world around you...<br>
 * For exemples see <code>PlayState</code> or <code>CutsceneState.</code><br>
 * THis state will draw the world in it's print() method, before calling his
 * son's print one.
 */
public class ExploreState extends GameState {

    public ExploreState(GameState parent) {
	super(parent);
	this.substate = new PlayState(this);
    }

    @Override
    public void update() {
	substate.update();
    }

    @Override
    public void print(Pixmap g) {
	// TODO : print world.
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
