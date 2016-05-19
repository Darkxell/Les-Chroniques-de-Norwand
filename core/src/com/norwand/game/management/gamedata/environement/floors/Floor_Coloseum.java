package com.norwand.game.management.gamedata.environement.floors;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.environement.entities.drop.DropKey;
import com.norwand.game.management.gamedata.environement.entities.monsters.BossColoseum;
import com.norwand.game.management.gamedata.environement.entities.monsters.Drake;
import com.norwand.game.management.gamedata.environement.entities.monsters.DungeonBoss;
import com.norwand.game.management.gamedata.environement.tileentities.LockedDoor;
import com.norwand.game.management.gamedata.environement.tiles.WarpZone;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.states.PS_Iddle;
import com.norwand.game.management.gamestates.top.launched.explore.dialog.DialogState;

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


    private boolean starttextshown;
    @Override
    public void update(){
        super.update();
        if(!starttextshown){
            GameData.get().player.state = new PS_Iddle(GameData.get().player);
            MainGame.game.state.substate.substate.substate = new DialogState(
                    MainGame.game.state.substate.substate, "Et voici le tant attendu POCKETDESTROYER, et face a lui notre dernier prisonier!" +
                    "Qui sortira de ce combat a mort?" +
                    "Note: Dasher sur ennemi lui infligera des dégâts, essayez d'esquiver ses attaques et ne le laissez pas s'approcher de vous! Bonne chance!");
            starttextshown = true;
        }
        if (playerpointer.y > 20 && entities.length != 0){
            GameData.get().player.y = 19;
            GameData.get().player.state = new PS_Iddle(GameData.get().player);
            MainGame.game.state.substate.substate.substate = new DialogState(
                    MainGame.game.state.substate.substate, "Je ne dois pas fuir mon ennemi!");
        } else if (playerpointer.y < 3 && entities.length != 0){
            GameData.get().player.y = 5;
            GameData.get().player.state = new PS_Iddle(GameData.get().player);
            MainGame.game.state.substate.substate.substate = new DialogState(
                    MainGame.game.state.substate.substate, "Je ne dois pas fuir mon ennemi!");
        }
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
