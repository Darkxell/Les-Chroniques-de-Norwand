package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_SnowTown extends Floor {

    public Floor_SnowTown(Player playerpointer) {
	super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
		+ "maps/snowvillage.txt")), playerpointer);
	setTileAt(34, 12,new WarpZone(getTileAt(34, 12), 0.5, 11.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(0, 2,new WarpZone(getTileAt(0, 2), 98.5, 25.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Snow(GameData.get().player);
	    }
	});
    }

}
