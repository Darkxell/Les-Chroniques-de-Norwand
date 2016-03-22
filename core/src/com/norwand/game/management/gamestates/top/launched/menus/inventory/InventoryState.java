package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.ExploreState;
import com.norwand.game.resources.ImagesHolder;

public class InventoryState extends GameState {

    public InventoryState(GameState parent) {
	super(parent);
    }

    @Override
    public void update() {

    }

    @Override
    public void print(Pixmap g) {
	g.drawPixmap(ImagesHolder.gui.inventorytop1, 0, 0);
    }

    @Override
    public void onPress(UserEvent e) {
	if (e.x > 188 && e.y > 4 && e.x < 236 && e.y < 20) {
	    parent.parent.substate = new ExploreState(parent.parent);
	}
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
