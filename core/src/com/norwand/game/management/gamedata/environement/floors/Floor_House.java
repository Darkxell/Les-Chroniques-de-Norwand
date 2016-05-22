package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.Hellbat;
import com.norwand.game.management.gamedata.environement.entities.monsters.Tree;
import com.norwand.game.management.gamedata.environement.entities.monsters.Wolf;
import com.norwand.game.management.gamedata.environement.tileentities.Chest;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjMerchant;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.items.Consumable.HealthPot;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.CopperNecklace;
import com.norwand.game.management.gamedata.player.Player;

/**
 * Created by V-SSK on 22/05/2016.
 */
public class Floor_House extends Floor {
    Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    public Floor_House(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/house3.txt")), playerpointer);

        addTileEntity(new PnjMerchant(this, 13.5, 18.5, "L'épée céleste se situe dans le coffre...     Prends la et ne reviens jamais !"));

        setTileAt(12, 24, new WarpZone(getTileAt(12, 24), 27.5, 12.5) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(0, 6, new WarpZone(getTileAt(0, 6), 13, 2) {
            @Override
            public Floor getDestination() {
                return new Floor_HouseRoom2(GameData.get().player);
            }
        });
    }

        @Override
        public String getDisplayName() {
            return "Maison";
        }

    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/etherealrealms.ogg";
    }

}
