package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.tileentities.Chest;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjMerchant;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.items.Consumable.HealthPot;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.CopperNecklace;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.HeavenlySword;
import com.norwand.game.management.gamedata.player.Player;

/**
 * Created by V-SSK on 22/05/2016.
 */
public class Floor_HouseRoom2 extends Floor {
    Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    public Floor_HouseRoom2(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/HouseRoom2.txt")), playerpointer);

       addTileEntity(new Chest(this, 1.5, 1.5, new Object[]{new HeavenlySword()}, "Vous avez obtenu épée céleste."));
        setTileAt(13, 1, new WarpZone(getTileAt(13, 1), 1.5, 6.5) {
            @Override
            public Floor getDestination() {
                return new Floor_House(GameData.get().player);
            }
        });
    }

    @Override
    public String getDisplayName() {
        return "Sous sol";
    }

    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/etherealrealms.ogg";
    }

}
