package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Wastelands extends Floor {

    public Floor_Wastelands(Player playerpointer) {
	super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
		+ "maps/wastelands.txt")), playerpointer);
	setTileAt(44, 49,new WarpZone(getTileAt(44, 49), 16, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(45, 49,new WarpZone(getTileAt(45, 49), 17, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(46, 49,new WarpZone(getTileAt(46, 49), 18, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(47, 49,new WarpZone(getTileAt(47, 49), 19, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(48, 49,new WarpZone(getTileAt(48, 49), 20, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(49, 49,new WarpZone(getTileAt(49, 49), 21, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(50, 49,new WarpZone(getTileAt(50, 49), 22, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(51, 49,new WarpZone(getTileAt(51, 49), 23, 1.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	
    }

}
