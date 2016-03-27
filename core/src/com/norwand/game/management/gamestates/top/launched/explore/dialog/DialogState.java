package com.norwand.game.management.gamestates.top.launched.explore.dialog;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.StringUtility;
import com.norwand.game.utility.objects.BitmapFont;

public class DialogState extends GameState {
    private String message;
    private int counter;

    /** Stored pointer to the LaunchedState GameData attribute. */
    GameData datapointer = ((LaunchedState) parent.parent).data;

    public DialogState(GameState parent, String message) {
        super(parent);
        this.message = message;
    }

    @Override
    public void update() {
        ++counter;
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
        int tic = counter/10;
        int posX = g.getWidth() / 10;
        int posY = g.getHeight() - 64 + 11;
        Array<String> wordsList = new Array<String>();
        int posInWordsList = 0;

        //Save the words to get them in the right order later
        for (final String word : message.split(" ")){
            if (word != null) {
                wordsList.add(word);
            }
        }
        
        for (final String word : wordsList){

            //Line break and space input
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
            for (int j = 0; j < tic; j++) {
                if (j <= bitmapFont.getLength(wordsList.get(posInWordsList))
                        && wordsList.get(posInWordsList) != null) {
                    bitmapFont.printStringOn(g,
                            ""+wordsList.get(posInWordsList).charAt(j),
                            posX + j*bitmapFont.getLength(""+wordsList.get(posInWordsList).charAt(j)),
                            posY);
                }
                else {
                    bitmapFont.printStringOn(g, " ", posX + (tic+1)*bitmapFont.getLength(" "), posY);
                    posInWordsList++;
                    j = 0;
                }
            }





            /*bitmapFont.printStringOn(
                    g,
                    (tic <= bitmapFont.getLength(word)) ?
                            ""+word.charAt(tic) :
                            " ",
                    posX + tic*bitmapFont.getLength(" "),
                    posY);*/

            //Print the whole word
            //bitmapFont.printStringOn(g, word, posX, posY);

            posX += bitmapFont.getLength(wordsList.get(posInWordsList));
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
