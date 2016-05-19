package com.norwand.game.management.gamedata.environement.tileentities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.management.gamedata.items.Key;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class LockedDoor extends TileEntity {

    public LockedDoor(Floor roompointer, double x, double y) {
        super(Tile.TYPE_SOLID, roompointer, x, y);
        actable = true;
    }

    @Override
    public void update() {

    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.tileset.getTile(1079);
    }

    @Override
    public void onAct() {
        Item keyToDelete = null;
        Inventory inv = GameData.get().player.inventory;

        for (int i = 0; i < inv.items.length; ++i) {
            if (inv.items[i] instanceof Key) {
                keyToDelete = inv.items[i];
                break;
            }
        }
        if (keyToDelete != null) {
            inv.removeItem(keyToDelete);
           kill();
        }

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.5, posY - 0.5, 1, 1);
    }

    @Override
    public void onhit(double damage) {

    }
}
