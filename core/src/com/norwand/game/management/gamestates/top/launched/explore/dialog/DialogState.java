package com.norwand.game.management.gamestates.top.launched.explore.dialog;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.PixmapUtility;

public class DialogState extends GameState {

    /** Stored pointer to the LaunchedState GameData attribute. */
    GameData datapointer = ((LaunchedState) parent.parent).data;

    public DialogState(GameState parent) {
	super(parent);
    }

    @Override
    public void update() {
    }

    @Override
    public void print(Pixmap g) {
	datapointer.currentfloor.printOn(g, (g.getWidth() / 32)
		- datapointer.player.cam.x, (g.getHeight() / 32)
		- datapointer.player.cam.y);

	Pixmap dialog = null;
	try {
	    dialog = PixmapUtility.getPixmapPart(ImagesHolder.gui, 256, 112,
		    208, 48);
	} catch (Exception e) {
	}
	g.drawPixmap(dialog, 16, g.getHeight() - 64);
	dialog.dispose();
    }

    @Override
    public void onPress(UserEvent e) {
	parent.substate = new PlayState(parent);
    }

    @Override
    public void onDrag(UserEvent e) {
    }

    @Override
    public void onRelease(UserEvent e) {
    }

    @Override
    public void onKeyPressed(UserEvent e) {
    }

    @Override
    public void onKeyReleased(UserEvent e) {
    }

    @Override
    public void onType(UserEvent e) {
    }

}
