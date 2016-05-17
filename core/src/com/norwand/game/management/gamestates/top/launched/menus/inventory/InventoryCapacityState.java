package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.ExploreState;
import com.norwand.game.resources.ImagesHolder;

import java.util.Arrays;

public class InventoryCapacityState extends GameState {

    private int counter;
    private int cursorposition;

    public InventoryCapacityState(GameState parent) {
        super(parent);
    }

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
        for (int i = 0; i < inv.capacity.length; ++i) {
            g.drawPixmap(inv.capacity[i].getCapIcon(), 12 + 40 * (i % 5), 70 + 40 * (i / 5));
            if(i == cursorposition)
                InventoryState.printCursor(g, 12 + 40 * (i % 5) - 4, 70 + 40 * (i / 5) - 4, 32, 32, counter < 35);
        }

        g.drawPixmap(ImagesHolder.gui.inventoryEquipMid, 0, g.getHeight() - 32);

        g.drawPixmap(ImagesHolder.gui.inventoryEquipSelect, 0, g.getHeight() - 32);
        g.drawPixmap(ImagesHolder.gui.inventoryEquipBot, 0, g.getHeight() - 16);

        if (inv.slot_cap1 != null)
            g.drawPixmap(inv.slot_cap1.getCapIcon(), 60, 25);

        if (inv.slot_cap2 != null)
            g.drawPixmap(inv.slot_cap2.getCapIcon(), 93, 26);

        if (inv.slot_cap3 != null)
            g.drawPixmap(inv.slot_cap3.getCapIcon(), 125, 26);

    }

    @Override
    public void onPress(UserEvent e) {
        Inventory inv = GameData.get().player.inventory;
        //return on the explore state
        if (e.x > 188 && e.y > 4 && e.x < 236 && e.y < 20)
            parent.parent.substate = new ExploreState(parent.parent);

        //switch page
        else if (e.x > 220 && e.x < 236 && e.y > MainGame.getBufferHeight() / 2 - 16 && e.y < MainGame.getBufferHeight() / 2 + 32)
            parent.substate = new InventoryCapacityState(parent);

        //field of capacities
        else if (e.y > 62 && e.y < MainGame.getBufferHeight() - 32 && e.x > 9 && e.x < 208) {
            int newCursorposition = (e.x - 12) / 40 + (e.y - 70) / 40 * 5;
            if (inv.capacity.length > newCursorposition && newCursorposition >= 0)
                cursorposition = newCursorposition;
        }

        //buttons
        else if (e.y > MainGame.getBufferHeight() - 32 && e.y <= MainGame.getBufferHeight() - 16) {
            Inventory i = GameData.get().player.inventory;

            //delete button
            if (e.x > 177 && e.x <= 193) {
                if(cursorposition >= 0 && cursorposition < inv.capacity.length)
                    inv.removeCapacity(inv.capacity[cursorposition]);
            }

            //equip button
            else if (e.x > 193 && e.x <= 209) {
                if(cursorposition >= 0 && cursorposition < inv.capacity.length)
                    inv.equipCapacity(inv.capacity[cursorposition]);
            }
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
