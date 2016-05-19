package com.norwand.game.management.gamedata.environement.tileentities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamestates.top.launched.explore.dialog.DialogState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

/**
 * Use it to heal yourself to full.
 */
public class HealFountain extends TileEntity {

    public HealFountain(Floor roompointer, double x, double y) {
        super(Tile.TYPE_SOLID, roompointer, x, y);
        actable = true;
    }

    @Override
    public void update() {
    }

    @Override
    public Pixmap getCurrentSprite() {
        return ImagesHolder.tileset.getTile(981);
    }

    @Override
    public void onAct() {
        MainGame.game.state.substate.substate.substate = new DialogState(
                MainGame.game.state.substate.substate, "Vous buvez a la fontaine, vous vous sentez rempli d'énérgie.");
        GameData.get().player.info.health = GameData.get().player.info.maxhealth;
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
        return new DoubleRectangle(posX - 0.4, posY - 0.4, 0.8, 0.8);
    }

    @Override
    public void onhit(double damage) {
    }
}
