package com.norwand.game.management.gamedata.environement.tileentities;


import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

import java.util.Objects;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class Chest extends TileEntity {

    private boolean isOpened = false;
    private Object[] content;

    public Chest(Floor roompointer, double x, double y, Object[] contener) {
        super(Tile.TYPE_SOLID,roompointer, x, y);
        actable = true;
        this.content = contener;
    }

    @Override
    public void update() {

    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.itemset.getTile((isOpened) ? 257 : 233);
    }

    @Override
    public void onAct() {
        isOpened = true;
        actable = false;
        for(int i = 0 ; i < content.length ; ++i) {
            if(content[i] instanceof Capacity)
                GameData.get().player.inventory.addCapacity((Capacity) content[i]);
            //else if other types
            else if(content[i] instanceof Item)
                GameData.get().player.inventory.addItem((Item) content[i]);
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
