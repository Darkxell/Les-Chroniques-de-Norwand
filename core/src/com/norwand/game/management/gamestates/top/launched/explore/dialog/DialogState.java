package com.norwand.game.management.gamestates.top.launched.explore.dialog;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.StreamUtils;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.BitmapFont;

public class DialogState extends GameState {
    private String message;
    private int counter;
    private String firstLine = "";
    private String secondLine = "";
    //String for the next words, that will be display after this window of dialog.
    private String nextMessage = "";
    //Stored pointer to the LaunchedState GameData attribute.
    private GameData datapointer = ((LaunchedState) parent.parent).data;
    private BitmapFont bitmapFont = ImagesHolder.font8x8;

    //private int tic = counter/40;

    private Array<String> wordsList = new Array<String>();

    // Position of the word in the sentence.
    //private int posInWordsList = 0;

    public DialogState(GameState parent, String message) {
        super(parent);
        this.message = message;

        //firstline, secondline

        //reste dans nextmessage
    }

    @Override
    public void update() {
        ++counter;
    }

    /**
     * Display a String in a Pixmap.
     * @param g the Pixmap where the message is displayed
     */
    @Override
    public void print(Pixmap g) {
        datapointer.currentfloor.printOn(g, 7.5 - datapointer.player.cam.x,
            (((double) (g.getHeight())) / 32d) - datapointer.player.cam.y);
        g.drawPixmap(ImagesHolder.gui.dialog, 16, g.getHeight() - 64);

        int posX = g.getWidth() / 10;
        int posY = g.getHeight() - 64 + 11;
        final int WINDOWLIMIT = g.getHeight() - 64 + 11 + 40;
        System.out.println(WINDOWLIMIT);





        //Save the words (the words, not the world, but still) to get them in the right order later
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

            //Management of additional words
            if (posY >= WINDOWLIMIT) {
                nextMessage += word + " ";
            }

            //Display character after character
            /*for (int j = 0; j < tic; j++) {
                if (j < wordsList.get(posInWordsList).length()
                        && wordsList.get(posInWordsList) != null) {
                    System.out.println("------------------------------------------ IF ------------------------------------------");
                    System.out.println("bitmapFont.getLength(wordsList.get(posInWordsList))   :   " + bitmapFont.getLength(wordsList.get(posInWordsList)));
                    System.out.println("wordsList.get(posInWordsList)   :   " +  "\"" + wordsList.get(posInWordsList) + "\"");
                    System.out.println("wordsList.get(posInWordsList).length()   :   " +  "\"" + wordsList.get(posInWordsList).length() + "\"");
                    bitmapFont.printStringOn(g,
                            ""+wordsList.get(posInWordsList).charAt(j),
                            posX + j*bitmapFont.getLength(""+word.charAt(j)),
                            posY);
                }
                else {
                    System.out.println("----------------------------------------- ELSE -----------------------------------------");
                    bitmapFont.printStringOn(g, " ", posX + (tic+1)*bitmapFont.getLength(" "), posY);
                    posInWordsList++;
                    j = tic;
                }
            }*/

            /*bitmapFont.printStringOn(
                    g,
                    (tic <= bitmapFont.getLength(word)) ?
                            ""+word.charAt(tic) :
                            " ",
                    posX + tic*bitmapFont.getLength(" "),
                    posY);*/

            //Print the whole word if it belong to this window of dialog
            if(posY < WINDOWLIMIT)
                bitmapFont.printStringOn(g, word, posX, posY);
            //System.out.println("posY = " + posY);

            posX += bitmapFont.getLength(word);
        }
    }

    @Override
    public void onPress(UserEvent e) {
	    if (nextMessage.equals("")) {
            System.out.println("nextMessage= " + nextMessage);
            parent.substate = new PlayState(parent);
        }
        else {
            System.out.println("Else");
            System.out.println("Message : " + message);
            parent.substate = new DialogState(MainGame.game.state.substate.substate, nextMessage /*"This is a test for a dialog. A bla bla bla bla!"*/);
            nextMessage = "";
        }

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
