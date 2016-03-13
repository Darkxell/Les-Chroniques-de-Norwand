package com.norwand.game.management.gamestates.top.launched.explore.dialog;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;
import com.norwand.game.resources.ImagesHolder;

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
	datapointer.currentfloor.printOn(g, 7.5 - datapointer.player.cam.x,
		(((double) (g.getHeight())) / 32d) - datapointer.player.cam.y);
	g.drawPixmap(ImagesHolder.gui.dialog, 16, g.getHeight() - 64);
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
