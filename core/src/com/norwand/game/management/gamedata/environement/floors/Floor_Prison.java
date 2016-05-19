package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.Mimic;
import com.norwand.game.management.gamedata.environement.entities.monsters.Wolf;
import com.norwand.game.management.gamedata.environement.tileentities.SignPost;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjFem;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjMasc;
import com.norwand.game.management.gamedata.environement.tileentities.allies.PnjTuto;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;

public class Floor_Prison extends Floor {
    Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    public Floor_Prison(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/prison.txt")), playerpointer);

        addTileEntity(new PnjTuto(this,10.5,9.5,"Je suis Tuto."));
        addEntity(new Wolf(this, 21, 10));
        addTileEntity(new SignPost(this,
                "Prison du royaume",
                4.5,
                4.5));
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

    @Override
    public String getDisplayName() {
        return "Prison";
    }

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/prison.ogg";
    }
}
