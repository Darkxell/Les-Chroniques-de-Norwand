package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.drop.DropKey;
import com.norwand.game.management.gamedata.environement.entities.monsters.BossColoseum;
import com.norwand.game.management.gamedata.environement.entities.monsters.Drake;
import com.norwand.game.management.gamedata.environement.tileentities.LockedDoor;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Coloseum extends Floor {
    public Floor_Coloseum(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/coloseum.txt")), playerpointer);

        addEntity(new BossColoseum(this, 13, 13));

                setTileAt(12, 20, new WarpZone(getTileAt(12, 20), 2, 1) {
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

        setTileAt(12, 0,new WarpZone(getTileAt(12, 0), 24, 15) {
            @Override
            public Floor getDestination() {
            return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(13, 0,new WarpZone(getTileAt(13, 0), 24, 15) {
            @Override
            public Floor getDestination() {
            return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(14, 0,new WarpZone(getTileAt(14, 0), 24, 15) {
            @Override
            public Floor getDestination() {
            return new Floor_Wastelands(GameData.get().player);
            }
        });
    }

	@Override
	public String getDisplayName() {
		return "Colisée";
	}

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/pocketdestroyer.ogg";
    }
}
