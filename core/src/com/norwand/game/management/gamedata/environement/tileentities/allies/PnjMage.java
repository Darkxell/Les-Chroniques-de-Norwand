package com.norwand.game.management.gamedata.environement.tileentities.allies;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tileentities.TileEntity;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamestates.top.launched.explore.dialog.DialogState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

/**
 * Created by ASUS on 19/05/2016.
 */
public class PnjMage extends TileEntity {

    private String message;
    private int sprite_counter;

    public PnjMage(Floor roompointer, double x, double y, String message) {
        super(Tile.TYPE_SOLID, roompointer, x, y);
        actable = true;
        this.message = message;
    }

    @Override
    public void update() {
        ++sprite_counter;
        if (sprite_counter >= 50)
            sprite_counter = 0;
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.entityset.getTile((sprite_counter < 25) ? 1799 : 1807);
    }

    @Override
    public void onAct() {
        MainGame.game.state.substate.substate.substate = new DialogState(MainGame.game.state.substate.substate, message);
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.5, posY - 0.5, 1, 1);
    }

    @Override
    public void onhit(double damage) {

    }
}
