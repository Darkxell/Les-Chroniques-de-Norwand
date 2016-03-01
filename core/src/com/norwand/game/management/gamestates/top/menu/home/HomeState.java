package com.norwand.game.management.gamestates.top.menu.home;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;

/**
 * State that represents the main menu of the game. This is the openning state
 * by default.
 */
public class HomeState extends GameState {

    public HomeState(GameState parent) {
	super(parent);
    }

    @Override
    public void update() {
    }

    @Override
    public void print(Pixmap g) {
	g.setColor(Color.CYAN);
	g.drawRectangle(80, g.getHeight()/2-30, 80, 20);
	g.drawRectangle(100, g.getHeight()/2+5, 40, 10);
    }

    @Override
    public void onPress(UserEvent e) {
	parent.parent.substate = new LaunchedState(parent.parent);
    }

    @Override
    public void onDrag(UserEvent e) {
    }

    @Override
    public void onRelease(UserEvent e) {
    }

    @Override
    public void onKeyPressed(UserEvent e) {
    }

    @Override
    public void onKeyReleased(UserEvent e) {
    }

    @Override
    public void onType(UserEvent e) {
    }

}
