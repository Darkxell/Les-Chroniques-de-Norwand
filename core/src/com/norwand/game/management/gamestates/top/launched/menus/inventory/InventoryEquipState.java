package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.resources.ImagesHolder;

public class InventoryEquipState extends GameState{

    public InventoryEquipState(GameState parent) {
        super(parent);
    }

    private int counter, cursorposition;

    @Override
    public void update() {
        ++counter;
        if (counter > 70)
            counter = 0;
        if(cursorposition > GameData.get().player.inventory.equipables.length -1 || cursorposition < 0)
            cursorposition = 0;
    }

    @Override
    public void print(Pixmap g) {
        Inventory inv = GameData.get().player.inventory;
        g.drawPixmap(ImagesHolder.gui.inventoryEquipTop, 0, 0);
        for (int i = 64; i < g.getHeight() - 32; i += 16)
            g.drawPixmap(ImagesHolder.gui.inventoryEquipMid, 0, i);

        //equip

        g.drawPixmap(ImagesHolder.gui.inventoryEquipMid, 0, g.getHeight() - 32);

        //description Item

        g.drawPixmap(ImagesHolder.gui.inventoryEquipSelect, 0, g.getHeight() - 32);
        g.drawPixmap(ImagesHolder.gui.inventoryEquipBot, 0, g.getHeight() - 16);

        if(inv.ring == null)
            g.drawPixmap(ImagesHolder.gui.ringSlot, 0, 0);
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
