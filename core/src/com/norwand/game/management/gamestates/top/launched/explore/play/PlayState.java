package com.norwand.game.management.gamestates.top.launched.explore.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.PixmapUtility;

/**
 * THis is the main state of the game. This state draws the environement, your
 * player and the HUD. THis is basically where you explore the world you're in,
 * you fight...<br>
 * The user inputs recorded by this state will be redirected to the player
 * Object after processing.
 */
public class PlayState extends GameState {

    /** Stored pointer to the LaunchedState GameData attribute. */
    GameData datapointer = ((LaunchedState) parent.parent).data;

    public PlayState(GameState parent) {
	super(parent);
    }

    @Override
    public void update() {
	datapointer.update();
    }

    @Override
    public void print(Pixmap g) {
	datapointer.currentfloor.printOn(g, (g.getWidth()/32)-datapointer.player.cam.x,
		(g.getHeight()/32)-datapointer.player.cam.y);
	// --------------
	Pixmap heart = null;
	try {
	    heart = PixmapUtility.getPixmapPart(ImagesHolder.gui, 256, 16, 16,
		    16);
	} catch (Exception e) {
	}
	for (int i = 0; i < 5; i++) {
	    g.drawPixmap(heart, 5 + 16 * i, 6);
	}
	heart.dispose();
	Pixmap menu = null;
	try {
	    menu = PixmapUtility.getPixmapPart(ImagesHolder.gui, 256, 160, 48,
		    16);
	} catch (Exception e) {
	}
	g.drawPixmap(menu, 188, 4);
	menu.dispose();
	Pixmap cap = null;
	try {
	    cap = PixmapUtility.getPixmapPart(ImagesHolder.gui, 256, 176, 128,
		    32);
	} catch (Exception e) {
	}
	g.drawPixmap(cap, 20,
		240 * Gdx.graphics.getHeight() / Gdx.graphics.getWidth() - 32);
	cap.dispose();
    }

    public void onPress(UserEvent e) {
	datapointer.playerinputconvertor.onPress(e, datapointer.player);
    }

    public void onDrag(UserEvent e) {
	datapointer.playerinputconvertor.onDrag(e, datapointer.player);
    }

    public void onRelease(UserEvent e) {
	datapointer.playerinputconvertor.onRelease(e, datapointer.player);
    }

    public void onKeyPressed(UserEvent e) {
	datapointer.playerinputconvertor.onKeyPressed(e, datapointer.player);
    }

    public void onKeyReleased(UserEvent e) {
	datapointer.playerinputconvertor.onKeyReleased(e, datapointer.player);
    }

    public void onType(UserEvent e) {
	datapointer.playerinputconvertor.onType(e, datapointer.player);
    }

}
