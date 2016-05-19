package com.norwand.game.management.gamedata.environement.entities.drop;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.items.Key;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class DropKey extends DropItem {

    public DropKey(Floor roompointer, double x, double y) {
        super(roompointer, x, y);
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.itemset.getTile(392);
    }

    @Override
    public void onPickUp() {
        GameData.get().player.inventory.addItem(new Key());
    }
}
