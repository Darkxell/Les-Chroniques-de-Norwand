package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.Mimic;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Prison extends Floor {

    public Floor_Prison(Player playerpointer) {
	super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
		+ "maps/prison.txt")), playerpointer);
	addEntity(new Mimic(this, 21, 9.5));
    }
}
