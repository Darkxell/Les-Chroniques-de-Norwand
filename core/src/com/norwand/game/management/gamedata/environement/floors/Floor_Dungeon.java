package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tileentities.Chest;
import com.norwand.game.management.gamedata.environement.tileentities.LockedDoor;
import com.norwand.game.management.gamedata.environement.tileentities.SignPost;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.items.Key;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.capacities.Cap_FrostWalker;

public class Floor_Dungeon extends Floor {
    /**
     * Constructs a floor object from a FloorData object and a pointer to the
     * player.
     *
     * @param playerpointer
     */
    public Floor_Dungeon(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH + "maps/demodungeon.txt")), playerpointer);

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

        addTileEntity(new Chest(this, 55.5, 52.5, new Object[]{new Cap_FrostWalker()}, "Vous avez trouvez une nouvelle capacité : pour l'équiper aller dans l'inventaire, page de capacité et équipez là."));
        addTileEntity(new LockedDoor(this, 55.5, 48.5));
        addTileEntity(new Chest(this, 55.5, 17.5, new Object[]{new Key()}, "Vous avez trouvez une grosse clé. A quoi peut elle donc servir ...?"));
    }

    @Override
    public String getDisplayName() {
        return "Donjon";
    }

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/allthingsend2.mp3";
    }
}
