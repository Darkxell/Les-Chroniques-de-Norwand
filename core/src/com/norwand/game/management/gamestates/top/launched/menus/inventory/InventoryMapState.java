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
public class InventoryMapState extends GameState {
    /**
     * Creates a new GameState with his parent. The parent is used to change
     * states inside the game, and therefore not needed for a
     * <code>TopState</code> Instance.
     *
     * @param parent
     */
    public InventoryMapState(GameState parent) {
        super(parent);
    }

    @Override
    public void update() {

    }

    @Override
    public void print(Pixmap g) {
        //TOP
        g.drawPixmap(ImagesHolder.gui.inventoryMapTop, 0, 0);
        ImagesHolder.font8x8.printStringOn(g, "CARTE", 5, 7);

        //MID
        for (int i = 48; i < g.getHeight() - 32; i += 16)
            g.drawPixmap(ImagesHolder.gui.inventoryMapMid, 0, i);

        //BOT
        g.drawPixmap(ImagesHolder.gui.inventoryEquipBot, 0, g.getHeight() - 32);

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
            parent.substate = new InventorySaveState(parent);
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
