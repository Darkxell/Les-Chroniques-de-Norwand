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

public class Floor_Snow extends Floor {

    public Floor_Snow(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/snow.txt")), playerpointer);
        addTileEntity(new SignPost(this, "whatever", 25, 27));

        setTileAt(99, 25, new WarpZone(getTileAt(99, 25), 1, 2.5) {
            @Override
            public Floor getDestination() {
                return new Floor_SnowTown(GameData.get().player);
            }
        });
        setTileAt(72, 8, new WarpZone(getTileAt(72, 8), 38.5, 58) {
            @Override
            public Floor getDestination() {
                return new Floor_Dungeon(GameData.get().player);
            }
        });

    }

    @Override
    public String getDisplayName() {
        return "Forêt des Murmures";
    }
}
