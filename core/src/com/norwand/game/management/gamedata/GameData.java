package com.norwand.game.management.gamedata;

import com.badlogic.gdx.Gdx;
import com.norwand.game.MainGame;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.FloorData;
import com.norwand.game.management.gamedata.player.Player;

/**
 * Holds the ram data of the entiere game.<br/>
 * This includes player position, infos, monsters, current map... but excludes
 * Ressources and savefiles.
 */
public class GameData {

    /**
     * Default GameData constructor.
     * 
     * @see GameData(SaveFile)
     */
    public GameData() {

    }

    /*
     * TODO public GameData(SaveFile){}
     */

    /** The player object. This object contains all of the needed player data. */
    public Player player = new Player();
    public InputConvertor playerinputconvertor = new InputConvertor();

    /**
     * The current Floor. This includes the physical and graphical physics, the
     * entities and more.
     */
    public Floor currentfloor = new Floor(new FloorData(
	    Gdx.files.internal(MainGame.ASSETSPATH + "maps/prison.txt")),
	    this.player);

    /** Updates the data of the game. */
    public void update() {
	playerinputconvertor.update();
	try {
	    player.update();
	} catch (Exception e) {
	    System.err.println("Couldn't update the player in the gamedata.");
	}
	try {
	    currentfloor.update();
	} catch (Exception e) {
	    System.err
		    .println("Couldn't update the current floor in the gamedata.");
	}
    }

}
