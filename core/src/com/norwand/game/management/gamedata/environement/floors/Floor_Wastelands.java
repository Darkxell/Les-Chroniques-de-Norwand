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
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.items.Consumable.HealthPot;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.CopperNecklace;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Wastelands extends Floor {
    Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    public Floor_Wastelands(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/wastelands.txt")), playerpointer);

        addEntity(new Hellbat(this, 21, 19));
        addEntity(new Hellbat(this, 20, 18));
        addEntity(new Hellbat(this, 30, 32));
        addEntity(new Hellbat(this, 31, 31));
        addEntity(new Hellbat(this, 35, 43));
        addEntity(new Hellbat(this, 25, 44));
        addEntity(new Hellbat(this, 29, 42));
        addEntity(new Hellbat(this, 46, 37));
        addEntity(new Hellbat(this, 50, 40));
        addEntity(new Tree(this, 53.5, 35.5));
        addEntity(new Wolf(this, 36, 44));
        addTileEntity(new Chest(this, 56.5, 33.5, new Object[]{new HealthPot(), new CopperNecklace()},"Vous avez obtenu Potion x1 et Collier de cuivre x1."));


        setTileAt(44, 49, new WarpZone(getTileAt(44, 49), 16, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(45, 49, new WarpZone(getTileAt(45, 49), 17, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(46, 49, new WarpZone(getTileAt(46, 49), 18, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(47, 49, new WarpZone(getTileAt(47, 49), 19, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(48, 49, new WarpZone(getTileAt(48, 49), 20, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(49, 49, new WarpZone(getTileAt(49, 49), 21, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(50, 49, new WarpZone(getTileAt(50, 49), 22, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });
        setTileAt(51, 49, new WarpZone(getTileAt(51, 49), 23, 1) {
            @Override
            public Floor getDestination() {
                return new Floor_WastelandsS(GameData.get().player);
            }
        });

    }

    @Override
    public String getDisplayName() {
        return "Terres Désolées";
    }

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/etherealrealms.ogg";
    }
}
