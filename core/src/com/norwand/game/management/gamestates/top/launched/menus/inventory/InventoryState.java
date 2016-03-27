package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Inventory;
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
	Inventory inv = GameData.get().player.inventory;
	g.drawPixmap(ImagesHolder.gui.inventorytop1, 0, 0);
	for (int i = 32; i < g.getHeight() - 32; i += 16)
	    g.drawPixmap(ImagesHolder.gui.inventorymid1, 0, i);
	for (int i = 0; i < inv.items.length; i++) {
	    g.drawPixmap(inv.items[i].getSprite(), 57 + 21 * (i % 7),
		    35 + 21 * (i / 7));
	}
	g.drawPixmap(ImagesHolder.gui.inventorymid1, 0, g.getHeight() - 32);
	g.drawPixmap(ImagesHolder.gui.inventoryselect1, 0, g.getHeight() - 32);
	g.drawPixmap(ImagesHolder.gui.inventorybot1, 0, g.getHeight() - 16);
	int h = g.getHeight() - 32;
	g.drawPixmap(ImagesHolder.gui.x32Box, 9, h / 3 + 16);
	g.drawPixmap(ImagesHolder.gui.x32Box, 9, h - h / 3 + 16);
	ImagesHolder.font8x8.printStringOn(g, "Inventory : Items", 5, 7);

	if (inv.quickItem1 != null)
	    g.drawPixmap(inv.quickItem1.getSprite(), 17, h / 3 + 24);
	if (inv.quickItem2 != null)
	    g.drawPixmap(inv.quickItem2.getSprite(), 17, h - h / 3 + 24);

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
