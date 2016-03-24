package com.norwand.game.management.gamestates.top.launched.explore.dialog;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.BitmapFont;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class DialogState extends GameState {
    private String message;

    /** Stored pointer to the LaunchedState GameData attribute. */
    GameData datapointer = ((LaunchedState) parent.parent).data;

    public DialogState(GameState parent) {
        super(parent);
    }

    public DialogState(GameState parent, String message) {
        super(parent);
        this.message = message;
    }

    @Override
    public void update() {
    }

    @Override
    public void print(Pixmap g) {

        datapointer.currentfloor.printOn(g, 7.5 - datapointer.player.cam.x,
            (((double) (g.getHeight())) / 32d) - datapointer.player.cam.y);
        g.drawPixmap(ImagesHolder.gui.dialog, 16, g.getHeight() - 64);

        print(g, message);
    }

    /**
     * Display a String in a Pixmap.
     * @param g the Pixmap where the message is displayed
     * @param message the message displayed
     */
    public void print(final Pixmap g, String message) {
        BitmapFont bitmapFont = ImagesHolder.font8x8;
        int posX = g.getWidth() / 10;
        int posY = g.getHeight() - 64 + 11;

        for (final String word: message.split(" ")){

            //Line break
            if (posX + bitmapFont.getLength(word) >= g.getWidth()*9/10) {
                posX = g.getWidth()/10;
                posY += 20;
            }
            else  if (posX != g.getWidth()/10){
                bitmapFont.printStringOn(g, " ", posX, posY);
                posX += bitmapFont.getLength(" ");
            }

            //Display of each character

            //TODO : display char after char

            //ANIMATIONS : TRY 1
            /*Timer timer = new Timer();

            for(int i = 0; i < word.length(); i++) {
                final int finalI = i;
                final int finalPosY = posY;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("I'M IN!");
                        bitmapFont.printStringOn(g, "" + word.charAt(finalI), posX[0], finalPosY);
                        posX[0] += bitmapFont.getLength(""+word.charAt(finalI));
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, 1000);
            }*/


            //ANIMATIONS : TRY 2
            /*for(int i = 0; i < word.length(); i++) {
                System.out.println("I'M IN!");
                bitmapFont.printStringOn(g, "" + word.charAt(i), posX[0], posY);
                posX[0] += bitmapFont.getLength(""+word.charAt(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/

            bitmapFont.printStringOn(g, word, posX, posY);
            posX += bitmapFont.getLength(word);
        }
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
