package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Dungeon extends Floor {
    Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    /**
     * Constructs a floor object from a FloorData object and a pointer to the
     * player.
     *
     * @param playerpointer
     */
    public Floor_Dungeon(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH+ "maps/demodungeon.txt")), playerpointer);

        setTileAt(37, 59, new WarpZone(getTileAt(37, 59), 72.5, 9) {
            @Override
            public Floor getDestination() {
                return new Floor_Snow(GameData.get().player);
            }
        });
        setTileAt(38, 59, new WarpZone(getTileAt(38, 59), 72.5, 9) {
            @Override
            public Floor getDestination() {
                return new Floor_Snow(GameData.get().player);
            }
        });
        setTileAt(39, 59, new WarpZone(getTileAt(39, 59), 72.5, 9) {
            @Override
            public Floor getDestination() {
                return new Floor_Snow(GameData.get().player);
            }
        });
    }

    @Override
    public String getDisplayName() {
        return "Dongeon";
    }

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/allthingsend2.mp3";
    }

    @Override
    public Music getMusic() {
        return music;
    }
}
