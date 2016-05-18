package com.norwand.game.management.gamestates.top.menu.home;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.environement.floors.Floor_Prison;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.music.MusicHolder;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Palette;

/**
 * State that represents the main menu of the game. This is the openning state
 * by default.
 */
public class HomeState extends GameState {

    public HomeState(GameState parent) {
	    super(parent);
        MusicHolder.switchBGM(MainGame.ASSETSPATH + "audio/bgm/adventures.mp3");
    }

    /** Internal counter. */
    private int counter;

    @Override
    public void update() {
	    ++counter;
        //Start the music
        if (!MusicHolder.currentMusic.isPlaying())
            MusicHolder.currentMusic.play();
    }

    @Override
    public void print(Pixmap g) {
	g.setColor(Palette.BABYBLUE);
	g.fill();
	g.drawPixmap(ImagesHolder.gui.hometop, 0,
		((counter < 128) ? 128 - counter : 0));
	g.drawPixmap(ImagesHolder.gui.homebot, 0, g.getHeight()
		- ((counter / 2 < 64) ? counter / 2 : 64));
	if (counter > 150)
	    g.drawPixmap((counter > 165) ? ImagesHolder.gui.hometext
		    : ImagesHolder.gui.hometexttsp, 60, g.getHeight() / 2 - 33);
	if (counter > 185)
	    g.drawPixmap((counter % 80 < 40) ? ImagesHolder.gui.start1
		    : ImagesHolder.gui.start2, 88, g.getHeight() / 2 + 25);
    }

    @Override
    public void onPress(UserEvent e) {
	    parent.parent.substate = new LaunchedState(parent.parent);
        MusicHolder.switchBGM(MainGame.ASSETSPATH + "audio/bgm/biohazard.mp3");
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
