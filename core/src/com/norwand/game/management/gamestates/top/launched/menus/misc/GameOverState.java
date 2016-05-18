package com.norwand.game.management.gamestates.top.launched.menus.misc;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.player.states.PS_Iddle;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.TopState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;
import com.norwand.game.management.music.MusicHolder;
import com.norwand.game.resources.ImagesHolder;

import sun.applet.Main;

/**
 * Created by Valentin Marechal on 18/05/2016.
 */
public class GameOverState extends GameState {
    /**Pointer to the game data.*/
    private GameData datapointer = GameData.get();
    private int counter = 0;

    /**Creates a new transitionstate.*/
    public GameOverState(GameState parent) {
        super(parent);
    }

    @Override
    public void update() {
        counter++;
        //Lower the volume of the current music
        if (counter < 50) {
            MusicHolder.currentMusic.setVolume((float) (50 - counter) / 50);
        }
    }

    @Override
    public void print(Pixmap g) {
        datapointer.currentfloor.printOn(g, 7.5 - datapointer.player.cam.x,
                (((double) (g.getHeight())) / 32d) - datapointer.player.cam.y);
        for (float i = 0; i < datapointer.player.info.maxhealth; ++i) {
            if (datapointer.player.info.health >= 1f + i)
                g.drawPixmap(ImagesHolder.entityset.getTile(2688),
                        (int) (10 + (16 * i)), 5);
            else if (datapointer.player.info.health <= i )
                g.drawPixmap(ImagesHolder.entityset.getTile(2692),
                        (int) (10 + (16 * i)), 5);
            else if (datapointer.player.info.health == i + 0.75f)
                g.drawPixmap(ImagesHolder.entityset.getTile(2689),
                        (int) (10 + (16 * i)), 5);
            else if (datapointer.player.info.health == i + 0.5f)
                g.drawPixmap(ImagesHolder.entityset.getTile(2690),
                        (int) (10 + (16 * i)), 5);
            else if (datapointer.player.info.health == i + 0.25f)
                g.drawPixmap(ImagesHolder.entityset.getTile(2691),
                        (int) (10 + (16 * i)), 5);
        }
        g.drawPixmap(ImagesHolder.gui.menubutton, 188, 4);
        g.drawPixmap(ImagesHolder.gui.capacitiesbar, 20, g.getHeight() - 32);
        if (datapointer.player.inventory.slot_cap1 != null)
            g.drawPixmap(datapointer.player.inventory.slot_cap1.getCapIcon(),
                    36, g.getHeight() - 32);
        if (datapointer.player.inventory.slot_cap2 != null)
            g.drawPixmap(datapointer.player.inventory.slot_cap2.getCapIcon(),
                    68, g.getHeight() - 32);
        if (datapointer.player.inventory.slot_cap3 != null)
            g.drawPixmap(datapointer.player.inventory.slot_cap3.getCapIcon(),
                    100, g.getHeight() - 32);
        g.drawPixmap(ImagesHolder.gui.itemgui, 192, g.getHeight() - 32);
        if (datapointer.player.inventory.quickItem1 != null)
            g.drawPixmap(datapointer.player.inventory.quickItem1.getSprite(),
                    196, MainGame.getBufferHeight() - 23);
        if (datapointer.player.inventory.quickItem2 != null)
            g.drawPixmap(datapointer.player.inventory.quickItem2.getSprite(),
                    220, MainGame.getBufferHeight() - 23);

        //Start printing the dark thing
        g.setColor(0.9911f,0.9372f,0.8431f,(counter<50)?counter/50f:1f);
        g.fillRectangle(0,0,g.getWidth(),g.getHeight());

        if( counter > 50 ){
            String s = "GAME OVER ...";
            int length = ImagesHolder.font8x8.getLength(s);
            ImagesHolder.font8x8.printStringOn(g,s,120-(length/2),(g.getHeight()/2 < counter-50)?g.getHeight()/2:counter-50);
        }
    }


    public void onPress(UserEvent e) {
        if(counter >= 100) {
            MainGame.game.state = new TopState();
        }
    }

    public void onDrag(UserEvent e) {
    }

    public void onRelease(UserEvent e) {
    }

    public void onKeyPressed(UserEvent e) {
    }

    public void onKeyReleased(UserEvent e) {
    }

    public void onType(UserEvent e) {
    }
}
