package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.resources.ImagesHolder;

public class InventoryCapacityState extends GameState {

    private int counter;
    private int cursorposition;

    public InventoryCapacityState(GameState parent) { super(parent); }

    @Override
    public void update() {
        ++counter;
        if (counter > 70)
            counter = 0;
        if (cursorposition > GameData.get().player.inventory.capacity.length - 1 || cursorposition < 0)
            cursorposition = 0;
    }

    @Override
    public void print(Pixmap g) {
        Inventory inv = GameData.get().player.inventory;

        //TOP
        g.drawPixmap(ImagesHolder.gui.inventoryCapacityTop, 0, 0);

        //MID
        for (int i = 64; i < g.getHeight() - 32; i += 16) {
            g.drawPixmap(ImagesHolder.gui.inventoryEquipMid, 0, i);
        }

        //switch page
        g.drawPixmap(ImagesHolder.gui.inventoryarrow, 220, g.getHeight() / 2 - 16);

        //capacities
        for(int i = 0 ; i < inv.capacity.length ; ++i) {
            g.drawPixmap(inv.capacity[i].getCapIcon(), 17 + 21 * (i % 9), 67 + 21 * (i / 9));
        }

        g.drawPixmap(ImagesHolder.gui.inventoryEquipMid, 0, g.getHeight() - 32);

        g.drawPixmap(ImagesHolder.gui.inventoryEquipSelect, 0, g.getHeight() - 32);
        g.drawPixmap(ImagesHolder.gui.inventoryEquipBot, 0, g.getHeight() - 16);

        if(inv.slot_cap1 != null)
            g.drawPixmap(inv.slot_cap1.getCapIcon(), 60, 25);

        if(inv.slot_cap2 != null)
            g.drawPixmap(inv.slot_cap2.getCapIcon(), 93, 26);

        if(inv.slot_cap3 != null)
            g.drawPixmap(inv.slot_cap3.getCapIcon(), 125, 26);

    }

    @Override
    public void onPress(UserEvent e) {

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
