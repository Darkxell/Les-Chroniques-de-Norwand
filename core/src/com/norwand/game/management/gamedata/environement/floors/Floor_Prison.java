package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.Mimic;
import com.norwand.game.management.gamedata.environement.tileentities.SignPost;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Prison extends Floor {

    public Floor_Prison(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
            + "maps/prison.txt")), playerpointer);
        addEntity(new Mimic(this, 21, 9.5));
        addTileEntity(new SignPost(this, "Don't kill Arya. This is a test. But don't. Please. One more line for the road.", 4.5, 4.5));
        setTileAt(1, 0, new WarpZone(getTileAt(1, 0), 13, 18) {
            @Override
            public Floor getDestination() {
            return new Floor_Coloseum(GameData.get().player);
            }
        });
        setTileAt(2, 0, new WarpZone(getTileAt(2, 0), 13, 18) {
            @Override
            public Floor getDestination() {
            return new Floor_Coloseum(GameData.get().player);
            }
        });
        setTileAt(3, 0, new WarpZone(getTileAt(3, 0), 13, 18) {
            @Override
            public Floor getDestination() {
            return new Floor_Coloseum(GameData.get().player);
            }
        });
    }
}
