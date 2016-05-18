package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.ExploreState;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 18/05/2016.
 */
public class InventorySaveState extends GameState {

    /**
     * Creates a new GameState with his parent. The parent is used to change
     * states inside the game, and therefore not needed for a
     * <code>TopState</code> Instance.
     *
     * @param parent
     */
    public InventorySaveState(GameState parent) {
        super(parent);
    }

    @Override
    public void update() {

    }

    @Override
    public void print(Pixmap g) {
        //TOP
        g.drawPixmap(ImagesHolder.gui.inventorySaveTop, 0, 0);
        ImagesHolder.font8x8.printStringOn(g, "SAUVEGARDE", 5, 7);

        //MID
        g.drawPixmap(ImagesHolder.gui.inventorySaveSaveButton, 10, (g.getHeight() - 32) / 2);
        g.drawPixmap(ImagesHolder.gui.inventorySaveOptionsButton, 114, (g.getHeight() - 32) / 2);

        //BOT
        g.drawPixmap(ImagesHolder.gui.inventorySaveBot, 0, g.getHeight() - 32);

        g.drawPixmap(ImagesHolder.gui.inventorySaveCreditsButton, 16, g.getHeight() - 32);

        //switch page
        g.drawPixmap(ImagesHolder.gui.inventoryarrow, 220, g.getHeight() / 2 - 16);
    }

    @Override
    public void onPress(UserEvent e) {
        //return on the explore state
        if (e.x > 188 && e.y > 4 && e.x < 236 && e.y < 20)
            parent.parent.substate = new ExploreState(parent.parent);

        //switch page
        else if (e.x > 220 && e.x < 236 && e.y > MainGame.getBufferHeight() / 2 - 16 && e.y < MainGame.getBufferHeight() / 2 + 32)
            parent.substate = new InventoryState(parent);

        //buttons save & options
        else if (e.y > (MainGame.getBufferHeight() - 32) / 2 && e.y < (MainGame.getBufferHeight() - 32) / 2 + 32) {
            //Save button
            if(e.x > 10 && e.x < 96)
                save();

            //Options button
            else if(e.x > 100 && e.x < 206)
                options();
        }

        //Credits button
        else if (e.x > 16 && e.x < 64 && e.y > MainGame.getBufferHeight() - 32 && e.y < MainGame.getBufferHeight() + 16)
            credits();
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

    public void save() {
        System.out.println("save");
    }

    public void options() {
        System.out.println("options");
    }

    public void credits() {
        System.out.println("credits");
    }
}
