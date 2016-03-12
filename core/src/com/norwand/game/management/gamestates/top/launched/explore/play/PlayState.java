package com.norwand.game.management.gamestates.top.launched.explore.play;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Palette;
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

    /**
     * The actived capacity. Equals 0 if no capacity is actived. Can be from 0
     * to 3.
     */
    private byte activedcapacity;

    public PlayState(GameState parent) {
	super(parent);
    }

    @Override
    public void update() {
	datapointer.update();
    }

    @Override
    public void print(Pixmap g) {
	datapointer.currentfloor.printOn(g, 7.5 - datapointer.player.cam.x,
		(((double) (g.getHeight())) / 32d) - datapointer.player.cam.y);
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
	g.drawPixmap(cap, 20, g.getHeight() - 32);
	cap.dispose();
	g.setColor(Palette.GREEN);
	try {
	    g.drawPixmap(datapointer.player.inventory.slot_cap1.getCapIcon(),
		    36, g.getHeight() - 32);
	    if (activedcapacity == 1)
		g.drawRectangle(37, g.getHeight() - 31, 30, 30);
	} catch (Exception e) {
	}
	try {
	    g.drawPixmap(datapointer.player.inventory.slot_cap2.getCapIcon(),
		    68, g.getHeight() - 32);
	    if (activedcapacity == 2)
		g.drawRectangle(69, g.getHeight() - 31, 30, 30);
	} catch (Exception e) {
	}
	try {
	    g.drawPixmap(datapointer.player.inventory.slot_cap3.getCapIcon(),
		    100, g.getHeight() - 32);
	    if (activedcapacity == 3)
		g.drawRectangle(101, g.getHeight() - 31, 30, 30);
	} catch (Exception e) {
	}
	Pixmap it = null;
	try {
	    it = PixmapUtility
		    .getPixmapPart(ImagesHolder.gui, 256, 256, 48, 32);
	} catch (Exception e) {
	}
	g.drawPixmap(it, 192, g.getHeight() - 32);
	it.dispose();
    }

    public void onPress(UserEvent e) {
	if (e.y > MainGame.getBufferHeight() - 32 && e.x > 36 && e.x < 68) {
	    if (activedcapacity == 1)
		activedcapacity = 0;
	    else
		activedcapacity = 1;
	} else if (e.y > MainGame.getBufferHeight() - 32 && e.x > 68
		&& e.x < 100) {
	    if (activedcapacity == 2)
		activedcapacity = 0;
	    else
		activedcapacity = 2;
	} else if (e.y > MainGame.getBufferHeight() - 32 && e.x > 100
		&& e.x < 132) {
	    if (activedcapacity == 3)
		activedcapacity = 0;
	    else
		activedcapacity = 3;
	} else {
	    datapointer.playerinputconvertor.onPress(e);
	}

    }

    public void onDrag(UserEvent e) {
	if (!(e.y > MainGame.getBufferHeight() - 32 && e.x > 36 && e.x < 132))
	    datapointer.playerinputconvertor.onDrag(e);
    }

    public void onRelease(UserEvent e) {
	datapointer.playerinputconvertor.onRelease(e);
    }

    public void onKeyPressed(UserEvent e) {
	datapointer.playerinputconvertor.onKeyPressed(e);
	switch (e.value) {
	case Keys.A:
	    activedcapacity = (byte) ((activedcapacity == 1) ? 0 : 1);
	    break;
	case Keys.Z:
	    activedcapacity = (byte) ((activedcapacity == 2) ? 0 : 2);
	    break;
	case Keys.E:
	    activedcapacity = (byte) ((activedcapacity == 3) ? 0 : 3);
	    break;
	}
    }

    public void onKeyReleased(UserEvent e) {
	datapointer.playerinputconvertor.onKeyReleased(e);
    }

    public void onType(UserEvent e) {
	datapointer.playerinputconvertor.onType(e);
    }

}
