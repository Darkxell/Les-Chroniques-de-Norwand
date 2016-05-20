package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.Hellbat;
import com.norwand.game.management.gamedata.environement.entities.monsters.IceMonster;
import com.norwand.game.management.gamedata.environement.entities.monsters.Mimic;
import com.norwand.game.management.gamedata.environement.entities.monsters.MiniSnowBoss;
import com.norwand.game.management.gamedata.environement.entities.monsters.Wolf;
import com.norwand.game.management.gamedata.environement.tileentities.Chest;
import com.norwand.game.management.gamedata.environement.tileentities.SignPost;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.items.Consumable.HealthPot;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.CopperNecklace;
import com.norwand.game.management.gamedata.items.Equipable.Ring.CopperRing;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Snow extends Floor {
    Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    public Floor_Snow(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/snow.txt")), playerpointer);

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

        addEntity(new Wolf(this, 8.5, 7.5));
        addEntity(new Wolf(this, 9.5, 11.5));
        addEntity(new Wolf(this, 3.5, 15.5));
        addEntity(new Wolf(this, 19.5, 13.5));
        addEntity(new Wolf(this, 21.5, 3.5));

        addEntity(new Hellbat(this, 18.5, 40.5));
        addEntity(new Hellbat(this, 25.5, 54.5));
        addEntity(new Hellbat(this, 49.5, 49.5));
        addEntity(new Hellbat(this, 61.5, 57.5));
        addEntity(new Hellbat(this, 89.5, 53.5));
        addEntity(new Hellbat(this, 79.5, 21.5));
        addEntity(new Hellbat(this, 55.5, 10.5));
        addEntity(new Hellbat(this, 35.5, 7.5));

        addTileEntity(new Chest(this, 65.5, 40.5, new Object[]{ new CopperRing()}, "Anneau de cuivre x1"));

        addEntity(new MiniSnowBoss(this, 71, 38));

        addEntity(new IceMonster(this, 67, 13));
        addEntity(new IceMonster(this, 65, 15));
    }

    @Override
    public String getDisplayName() {
        return "Forêt des Murmures";
    }

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/allthingsend2.ogg";
    }
}
