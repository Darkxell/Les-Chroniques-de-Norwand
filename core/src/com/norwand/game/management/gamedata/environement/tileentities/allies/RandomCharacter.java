package com.norwand.game.management.gamedata.environement.tileentities.allies;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tileentities.TileEntity;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

/**
 * Created by V-SSK on 19/05/2016.
 */
public class RandomCharacter extends TileEntity {
    public RandomCharacter(Floor roompointer, double x, double y) {
        super(Tile.TYPE_SOLID, roompointer, x, y);
    }

    private int sprite[] = {976, 977, 978, 979, 1024, 1025, 1026, 1027, 1072, 1073};
    private int randomChar = (int)(Math.random()*(sprite.length));

    @Override
    public void update() {

    }

    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile(sprite[randomChar]);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.5, posY - 0.5, 1, 1);
    }

    @Override
    public void onhit(double damage) {

    }
}



