package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Coloseum extends Floor {

    public Floor_Coloseum(Player playerpointer) {
	super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
		+ "maps/coloseum.txt")), playerpointer);
	setTileAt(12, 20,new WarpZone(getTileAt(12, 20), 2, 1) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Prison(GameData.get().player);
	    }
	});
	setTileAt(13, 20,new WarpZone(getTileAt(13, 20), 2, 1) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Prison(GameData.get().player);
	    }
	});
	setTileAt(14, 20,new WarpZone(getTileAt(14, 20), 2, 1) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Prison(GameData.get().player);
	    }
	});
    }

}