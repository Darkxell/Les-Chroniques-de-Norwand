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
	/*setTileAt(44, 49,new WarpZone(getTileAt(44, 49), 2, 1) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});*/
	
    }

}
