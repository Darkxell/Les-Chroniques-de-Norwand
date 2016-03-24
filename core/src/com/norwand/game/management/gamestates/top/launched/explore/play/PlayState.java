package com.norwand.game.management.gamestates.top.launched.explore.play;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.InputConvertor;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.gamestates.top.launched.menus.InGameMenuState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Palette;
import com.norwand.game.utility.objects.Position;

/**
 * This is the main state of the game. This state draws the environement, your
 * player and the HUD. THis is basically where you explore the world you're in,
 * you fight...<br>
 * The user inputs recorded by this state will be redirected to the player
 * Object after processing.
 */
public class PlayState extends GameState {

    /** Stored pointer to the LaunchedState GameData attribute. */
    private GameData datapointer = ((LaunchedState) parent.parent).data;

    /**
     * The actived capacity. Equals 0 if no capacity is actived. Can be from 0
     * to 3.
     */
    private byte activedcapacity;
    /** Local boolean to show if the act button shows up or not. */
    private boolean canact = false;
    /**
     * the height of the act button. the bigger this value is, the more it
     * appears on the screen.
     */
    private int actheight = 0;

    public PlayState(GameState parent) {
	super(parent);
    }

    @Override
    public void update() {
	datapointer.update();
	canact = datapointer.currentfloor.canPlayerAct();
	if (canact) {
	    if (actheight < 37)
		actheight += 2;
	} else {
	    if (actheight > 0)
		actheight -= 2;
	}
    }

    @Override
    public void print(Pixmap g) {
	datapointer.currentfloor.printOn(g, 7.5 - datapointer.player.cam.x,
		(((double) (g.getHeight())) / 32d) - datapointer.player.cam.y);
	// --------------
	for (int i = 0; i < 5; i++) {
	    g.drawPixmap(ImagesHolder.gui.heart, 5 + 16 * i, 6);
	}
	g.drawPixmap(ImagesHolder.gui.menubutton, 188, 4);
	g.drawPixmap(ImagesHolder.gui.actbutton, 134, actheight - 34);
	// --------------
	g.drawPixmap(ImagesHolder.gui.capacitiesbar, 20, g.getHeight() - 32);
	g.setColor(Palette.GREEN);
	if (datapointer.player.inventory.slot_cap1 != null)
	    g.drawPixmap(datapointer.player.inventory.slot_cap1.getCapIcon(),
		    36, g.getHeight() - 32);
	if (activedcapacity == 1)
	    g.drawRectangle(37, g.getHeight() - 31, 30, 30);
	if (datapointer.player.inventory.slot_cap2 != null)
	    g.drawPixmap(datapointer.player.inventory.slot_cap2.getCapIcon(),
		    68, g.getHeight() - 32);
	if (activedcapacity == 2)
	    g.drawRectangle(69, g.getHeight() - 31, 30, 30);
	if (datapointer.player.inventory.slot_cap3 != null)
	    g.drawPixmap(datapointer.player.inventory.slot_cap3.getCapIcon(),
		    100, g.getHeight() - 32);
	if (activedcapacity == 3)
	    g.drawRectangle(101, g.getHeight() - 31, 30, 30);
	// --------------
	g.drawPixmap(ImagesHolder.gui.itemgui, 192, g.getHeight() - 32);
	if (datapointer.player.inventory.quickItem1 != null)
	    g.drawPixmap(datapointer.player.inventory.quickItem1.getSprite(),
		    196, MainGame.getBufferHeight() - 23);
	if (datapointer.player.inventory.quickItem2 != null)
	    g.drawPixmap(datapointer.player.inventory.quickItem2.getSprite(),
		    220, MainGame.getBufferHeight() - 23);
    }

    public void onPress(UserEvent e) {
	if (e.x > 192 && e.y > MainGame.getBufferHeight() - 32 && e.x < 216) {
	    if (datapointer.player.inventory.quickItem1 != null)
		datapointer.player.inventory.quickItem1.onUse();
	} else if (e.x > 216 && e.y > MainGame.getBufferHeight() - 32) {
	    if (datapointer.player.inventory.quickItem2 != null)
		datapointer.player.inventory.quickItem2.onUse();
	} else if (e.x > 188 && e.y > 4 && e.x < 236 && e.y < 20) {
	    parent.parent.substate = new InGameMenuState(parent.parent);
	} else if (canact && e.x > 134 && e.y > 4 && e.x < 282 && e.y < 20) {
	    datapointer.currentfloor.actClosest();
	} else if (e.y > MainGame.getBufferHeight() - 32 && e.x > 36
		&& e.x < 68
		&& datapointer.player.inventory.getCapFromId((byte) 1) != null) {
	    activedcapacity = (byte) ((activedcapacity == 1) ? 0 : 1);
	} else if (e.y > MainGame.getBufferHeight() - 32 && e.x > 68
		&& e.x < 100
		&& datapointer.player.inventory.getCapFromId((byte) 2) != null) {
	    activedcapacity = (byte) ((activedcapacity == 2) ? 0 : 2);
	} else if (e.y > MainGame.getBufferHeight() - 32 && e.x > 100
		&& e.x < 132
		&& datapointer.player.inventory.getCapFromId((byte) 3) != null) {
	    activedcapacity = (byte) ((activedcapacity == 3) ? 0 : 3);
	} else if (activedcapacity != 0) {
	    byte a = activedcapacity;
	    activedcapacity = 0;
	    try {
		datapointer.player.state.onSkillUsed(InputConvertor
			.convertPosition(new Position(e.x, e.y),
				datapointer.player.cam),
			datapointer.player.inventory.getCapFromId(a));
	    } catch (Exception ex) {
		System.err.println("Failed to use the capacity.\nLogs:");
		ex.printStackTrace();
	    }
	} else {
	    datapointer.playerinputconvertor.onPress(e);
	}

    }

    public void onDrag(UserEvent e) {
	datapointer.playerinputconvertor.onDrag(e);
    }

    public void onRelease(UserEvent e) {
	datapointer.playerinputconvertor.onRelease(e);
    }

    public void onKeyPressed(UserEvent e) {
	datapointer.playerinputconvertor.onKeyPressed(e);
	switch (e.value) {
	case Keys.A:
	    activedcapacity = (byte) ((activedcapacity == 1 || datapointer.player.inventory
		    .getCapFromId((byte) 1) == null) ? 0 : 1);
	    break;
	case Keys.Z:
	    activedcapacity = (byte) ((activedcapacity == 2 || datapointer.player.inventory
		    .getCapFromId((byte) 2) == null) ? 0 : 2);
	    break;
	case Keys.E:
	    activedcapacity = (byte) ((activedcapacity == 3 || datapointer.player.inventory
		    .getCapFromId((byte) 3) == null) ? 0 : 3);
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
