package com.norwand.game.management.gamestates.top.launched.explore.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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

    int xp = 0;
    int yp = 0;

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
	for (int i = 0; i < datapointer.currentfloor.width; i++)
	    for (int j = 0; j < datapointer.currentfloor.height; j++) {
		try {
		    g.drawPixmap(datapointer.currentfloor.tiles[i + j
			    * datapointer.currentfloor.width].background[0]
			    .getCurrentFrame(), (i + xp) * 16, (j + yp) * 16);
		} catch (Exception e) {
		}
	    }
	for (int i = 0; i < datapointer.currentfloor.width; i++)
	    for (int j = 0; j < datapointer.currentfloor.height; j++) {
		try {
		    g.drawPixmap(datapointer.currentfloor.tiles[i + j
			    * datapointer.currentfloor.width].background[1]
			    .getCurrentFrame(), (i + xp) * 16, (j + yp) * 16);
		} catch (Exception e) {
		}
	    }
	//--------------
	Pixmap heart = null;
	try {
	    heart = PixmapUtility.getPixmapPart(ImagesHolder.gui, 256, 16, 16, 16);
	} catch (Exception e) {
	}
	for (int i = 0; i < 5; i++) {
	    g.drawPixmap(heart, 5 + 16*i, 6);
	}
	heart.dispose();
	Pixmap menu = null;
	try {
	   menu = PixmapUtility.getPixmapPart(ImagesHolder.gui, 256, 161, 48, 16);
	} catch (Exception e) {
	}
	g.drawPixmap(menu, 188, 4);
	menu.dispose();
	Pixmap cap = null;
	try {
	   cap = PixmapUtility.getPixmapPart(ImagesHolder.gui, 256, 177, 128, 32);
	} catch (Exception e) {
	}
	g.drawPixmap(cap, 20, 240 * Gdx.graphics.getHeight()
		/ Gdx.graphics.getWidth()-32);
	cap.dispose();
    }

    public void onPress(UserEvent e) {
	datapointer.player.onPress(e);
    }

    public void onDrag(UserEvent e) {
	datapointer.player.onDrag(e);
    }

    public void onRelease(UserEvent e) {
	datapointer.player.onRelease(e);
    }

    public void onKeyPressed(UserEvent e) {
	datapointer.player.onKeyPressed(e);
	if (e.value == Keys.LEFT) {
	    xp++;
	}
	if (e.value == Keys.RIGHT) {
	    xp--;
	}
	if (e.value == Keys.UP) {
	    yp++;
	}
	if (e.value == Keys.DOWN) {
	    yp--;
	}
    }

    public void onKeyReleased(UserEvent e) {
	datapointer.player.onKeyReleased(e);
    }

    public void onType(UserEvent e) {
	datapointer.player.onType(e);
    }

}
