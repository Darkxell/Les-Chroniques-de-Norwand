package com.norwand.game.management.gamestates.top.menu;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.menu.home.HomeState;

public class MenuState extends GameState {
    
    public MenuState(GameState parent) {
	super(parent);
	this.substate = new HomeState(this);
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
