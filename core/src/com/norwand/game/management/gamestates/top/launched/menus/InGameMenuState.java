package com.norwand.game.management.gamestates.top.launched.menus;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.menus.inventory.InventoryState;
import com.norwand.game.utility.Palette;

public class InGameMenuState extends GameState {

    public InGameMenuState(GameState parent) {
	super(parent);
	substate = new InventoryState(this);
    }

    @Override
    public void update() {
	substate.update();
    }

    @Override
    public void print(Pixmap g) {
	g.setColor(Palette.DARKGREY);
	g.fillRectangle(0, 0, g.getWidth(), g.getHeight());
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
