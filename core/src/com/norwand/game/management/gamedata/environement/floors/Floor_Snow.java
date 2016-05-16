package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.Mimic;
import com.norwand.game.management.gamedata.environement.tileentities.SignPost;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Snow extends Floor {

    public Floor_Snow(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
            + "maps/snow.txt")), playerpointer);
        addTileEntity(new SignPost(this, "whatever", 25, 27));
		
		setTileAt(99, 25,new WarpZone(getTileAt(99, 25), 1, 2) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
	setTileAt(99, 25,new WarpZone(getTileAt(99, 25), 1.5, 2.5) {
	    @Override
	    public Floor getDestination() {
		return new Floor_WastelandsS(GameData.get().player);
	    }
	});
    }

}
