package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_WastelandsS extends Floor {

    public Floor_WastelandsS(Player playerpointer) {
	super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
		+ "maps/wastelands-south.txt")), playerpointer);
	setTileAt(16, 0,new WarpZone(getTileAt(16, 0), 44, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	setTileAt(17, 0,new WarpZone(getTileAt(17, 0), 45, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	setTileAt(18, 0,new WarpZone(getTileAt(18, 0), 46, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	setTileAt(19, 0,new WarpZone(getTileAt(19, 0), 47, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	setTileAt(20, 0,new WarpZone(getTileAt(20, 0), 48, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	setTileAt(21, 0,new WarpZone(getTileAt(21, 0), 49, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	setTileAt(22, 0,new WarpZone(getTileAt(22, 0), 50, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	setTileAt(23, 0,new WarpZone(getTileAt(23, 0), 51, 47) {
	    @Override
	    public Floor getDestination() {
		return new Floor_Wastelands(GameData.get().player);
	    }
	});
	
	setTileAt(0, 11,new WarpZone(getTileAt(0, 11), 34, 12) {
	    @Override
	    public Floor getDestination() {
		return new Floor_SnowTown(GameData.get().player);
	    }
	});
    }

}
