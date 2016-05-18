package com.norwand.game.management.gamestates.top.launched.explore.dialog;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.StreamUtils;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.LaunchedState;
import com.norwand.game.management.gamestates.top.launched.explore.play.PlayState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.BitmapFont;

import java.util.ArrayList;

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
    private int firstLineLength = 0;
    private int secondLineLength = 0;

    //private int tic = counter/40;

    private ArrayList<String> wordsList = new ArrayList<String>();
    private ArrayList<String> wordsListSecondLine = new ArrayList<String>();

    // Position of the word in the sentence.
    private int posInWordsList = 0;
    private int posEndOfTheFirstLine = 0;
    private int posEndOfTheSecondLine = 0;


    public DialogState(GameState parent, String message) {
        super(parent);
        //message = message.toUpperCase();
        this.message = message;

        //Save the words (the words, not the world, but still) to get them in the right order later
        for (final String word : message.split(" ")){
            if (word != null) {
                wordsList.add(word);
                wordsListSecondLine.add(word);
            }
        }

        //firstline
        for (String word : wordsList) {
            System.out.println("Word = " + word);

            firstLineLength = bitmapFont.getLength(firstLine + word + " ");
            System.out.println("firstLineLenght AVANT le if = " + firstLineLength);

            //firstLine
            if (firstLineLength <= 198) {
                System.out.println("firstLine = " + firstLine);
                posInWordsList = (firstLine + word + " ").length();
                posEndOfTheFirstLine = posInWordsList;
                System.out.println("posInWordsList = " + posInWordsList);
                firstLine = message.substring(0, posInWordsList);
                System.out.println("firstLine APRES = " + firstLine);

                System.out.println("WOOOOOOOOORD = " + word);
                wordsListSecondLine.remove(word);
            }
            else {
                break;
            }
            System.out.println("--------------------------------");
        }

        //secondLine & nextMessage
        for (String word : wordsListSecondLine) {
            System.out.println("Word = " + word);

            secondLineLength = bitmapFont.getLength(secondLine + word + " ");
            System.out.println("secondLineLenght AVANT le if = " + secondLineLength);

            //secondLine
            if (secondLineLength <= 198) {
                System.out.println("secondLine = " + secondLine);
                posInWordsList = (secondLine + word + " ").length();
                posEndOfTheSecondLine = posEndOfTheFirstLine + posInWordsList;
                System.out.println("posInWordsList = " + posInWordsList);
                System.out.println("posEndOfTheFirstLine = " + posEndOfTheFirstLine);
                try {
                    secondLine = message.substring(posEndOfTheFirstLine, posEndOfTheFirstLine + posInWordsList);
                }
                catch (IndexOutOfBoundsException e) {
                    secondLine = message.substring(posEndOfTheFirstLine);
                }
                System.out.println("secondLine APRES = " + secondLine);
            }
            //nextMessage
            else {
                nextMessage = message.substring(posEndOfTheSecondLine);
                System.out.println("next message = " + nextMessage);
                break;
            }
            System.out.println("--------------------------------");
        }
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

        bitmapFont.printStringOn(g, firstLine, posX, posY);
        bitmapFont.printStringOn(g, secondLine, posX, posY + 20);
    }

    @Override
    public void onPress(UserEvent e) {
        if (nextMessage.equals("") || nextMessage.equals(" ")) {
            System.out.println("--------- nextMessage ---------- = " + nextMessage);
            parent.substate = new PlayState(parent);
        }
        else {
            System.out.println("Else");
            System.out.println("Message : " + message);
            parent.substate = new DialogState(MainGame.game.state.substate.substate, nextMessage);
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
