package com.norwand.game.management.gamedata.environement.tileentities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamestates.top.launched.explore.dialog.DialogState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

public class SignPost extends TileEntity {

    public SignPost(Floor roompointer, double x, double y) {
	super(Tile.TYPE_SOLID, roompointer, x, y);
	actable = true;
    }

    @Override
    public void update() {
    }

    @Override
    public Pixmap getCurrentSprite() {
	return ImagesHolder.tileset.getTile(470);
    }

    @Override
    public void onAct() {
	MainGame.game.state.substate.substate.substate = new DialogState(
		MainGame.game.state.substate.substate);
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
	return new DoubleRectangle(posX - 0.4, posY - 0.4, 0.8, 0.8);
    }

    @Override
    public void onhit(double damage) {
    }

}
