package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.monsters.Hellbat;
import com.norwand.game.management.gamedata.environement.entities.monsters.Wolf;
import com.norwand.game.management.gamedata.environement.tileentities.SignPost;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.states.PS_Iddle;
import com.norwand.game.management.gamestates.top.launched.explore.dialog.DialogState;

public class Floor_WastelandsS extends Floor {
    Music music = Gdx.audio.newMusic(Gdx.files.internal(getMusicPath()));

    public Floor_WastelandsS(Player playerpointer) {
        super(new FloorData(Gdx.files.internal(MainGame.ASSETSPATH
                + "maps/wastelands-south.txt")), playerpointer);

        setTileAt(16, 0, new WarpZone(getTileAt(16, 0), 44, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(17, 0, new WarpZone(getTileAt(17, 0), 45, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(18, 0, new WarpZone(getTileAt(18, 0), 46, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(19, 0, new WarpZone(getTileAt(19, 0), 47, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(20, 0, new WarpZone(getTileAt(20, 0), 48, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(21, 0, new WarpZone(getTileAt(21, 0), 49, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(22, 0, new WarpZone(getTileAt(22, 0), 50, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(23, 0, new WarpZone(getTileAt(23, 0), 51, 47) {
            @Override
            public Floor getDestination() {
                return new Floor_Wastelands(GameData.get().player);
            }
        });
        setTileAt(27, 11, new WarpZone(getTileAt(27, 11), 12.5, 22) {
            @Override
            public Floor getDestination() {
                return new Floor_House(GameData.get().player);
            }
        });
        setTileAt(0, 11, new WarpZone(getTileAt(0, 11), 33.5, 12) {
            @Override
            public Floor getDestination() {
                return new Floor_SnowTown(GameData.get().player);
            }
        });

        addTileEntity(new SignPost(this, "Ici s'est déroulée l'embuscade de la croisée des chemins où, durant la seconde Grande Guerre, la troupe inquisitrice dirigée par le lieutenant Aurik Rhen a été décimée.", 10.5, 11.5));
    }

    @Override
    public void update() {
        super.update();
        if (GameData.get().player.y > 19) {
            GameData.get().player.y = 18;
            GameData.get().player.state = new PS_Iddle(GameData.get().player);
            MainGame.game.state.substate.substate.substate = new DialogState(
                    MainGame.game.state.substate.substate, "Je ne devrais pas aller ici, c'est une zone de forte activité humaine...");
        }
    }

    @Override
    public String getDisplayName() {
        return "Terres Désolées - Sud";
    }

    @Override
    public String getMusicPath() {
        return MainGame.ASSETSPATH + "audio/bgm/etherealrealms.ogg";
    }
}
