package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.DungeonBoss;
import com.norwand.game.management.gamedata.environement.entities.monsters.Hellbat;
import com.norwand.game.management.gamedata.environement.entities.monsters.Mimic;
import com.norwand.game.management.gamedata.environement.entities.monsters.SoldierDungeon;
import com.norwand.game.management.gamedata.environement.entities.monsters.Wolf;
import com.norwand.game.management.gamedata.environement.tileentities.BossLockedDoor;
import com.norwand.game.management.gamedata.environement.tileentities.Chest;
import com.norwand.game.management.gamedata.environement.tileentities.HealFountain;
import com.norwand.game.management.gamedata.environement.tileentities.LockedDoor;
import com.norwand.game.management.gamedata.environement.tileentities.SignPost;
import com.norwand.game.management.gamedata.environement.tiles.PressurePlate;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.items.BossKey;
import com.norwand.game.management.gamedata.items.Key;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.capacities.Cap_FrostWalker;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.AnimatedSprite;

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

        addTileEntity(new HealFountain(this, 16.5, 28.5));
        addTileEntity(new Chest(this, 55.5, 52.5, new Object[]{new Cap_FrostWalker()}, "Vous avez trouvez une nouvelle capacité! Pour l'équiper, allez dans l'inventaire, page de capacités et équipez là."));
        addTileEntity(new LockedDoor(this, 55.5, 48.5));
        addTileEntity(new BossLockedDoor(this, 9.5, 14.5));
        addTileEntity(new Chest(this, 55.5, 17.5, new Object[]{new Key()}, "Vous avez trouvé une petite clé. Vous pouvez ouvrir une porte fermée."));
        addTileEntity(new Chest(this, 54.5, 4.5, new Object[]{new BossKey()}, "Vous avez trouvé une clé de boss. Vous pouvez maintenement ouvrir un salle de boss"));

        //addEntity(new SoldierDungeon(this, 38, 47));

        addEntity(new DungeonBoss(this, 9.5, 4.5));

        addEntity(new Wolf(this, 36.5, 16.5));
        addEntity(new Wolf(this, 37.5, 18.5));
        addEntity(new Wolf(this, 39.5, 16.5));
        addEntity(new Wolf(this, 40.5, 17.5));

        addEntity(new Hellbat(this, 55.5, 23.5));
        addEntity(new Hellbat(this, 56.5, 17.5));
        addEntity(new Hellbat(this, 56.5, 38.5));
        addEntity(new Hellbat(this, 57.5, 55.5));
        addEntity(new Hellbat(this, 22.5, 39.5));
        addEntity(new Hellbat(this, 23.5, 40.5));
        addEntity(new Hellbat(this, 25.5, 39.5));
        addEntity(new Hellbat(this, 22.5, 35.5));
        addEntity(new Hellbat(this, 14.5, 56.5));
        addEntity(new Hellbat(this, 10.5, 54.5));
        addEntity(new Hellbat(this, 6.5, 51.5));
        addEntity(new Hellbat(this, 2.5, 57.5));
        addEntity(new Hellbat(this, 2.5, 48.5));
        addEntity(new Hellbat(this, 54.5, 2.5));
        addEntity(new Hellbat(this, 57.5, 4.5));

        setTileAt(3, 53, new PressurePlate(3, 53) {
            @Override
            public void onTrigger() {
                setTileAt(8, 44, new Tile(Tile.TYPE_NORMAL, new AnimatedSprite[]{ImagesHolder.tileset.getTileAnimation(320)}, null));
                setTileAt(9, 44, new Tile(Tile.TYPE_NORMAL, new AnimatedSprite[]{ImagesHolder.tileset.getTileAnimation(322)}, null));
            }
        });

        setTileAt(44, 21, new PressurePlate(44, 21) {
            @Override
            public void onTrigger() {
                setTileAt(44, 30, new Tile(Tile.TYPE_NORMAL, new AnimatedSprite[]{ImagesHolder.tileset.getTileAnimation(325)}, null));
            }
        });
    }

    @Override
    public String getDisplayName() {
        return "Donjon";
    }

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/donotrun.ogg";
    }
}
