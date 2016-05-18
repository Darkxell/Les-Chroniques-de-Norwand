package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.ExploreState;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 18/05/2016.
 */
public class InventoryResumeState extends GameState {

    private int counter = 0;

    /**
     * Creates a new GameState with his parent. The parent is used to change
     * states inside the game, and therefore not needed for a
     * <code>TopState</code> Instance.
     *
     * @param parent
     */
    public InventoryResumeState(GameState parent) {
        super(parent);
    }

    @Override
    public void update() {
        ++counter;
        if(counter >= 40)
            counter = 0;
    }

    @Override
    public void print(Pixmap g) {

        Inventory inv = GameData.get().player.inventory;

        //TOP
        g.drawPixmap(ImagesHolder.gui.inventorySaveTop, 0, 0);
        ImagesHolder.font8x8.printStringOn(g, "PERSONNAGE", 5, 7);

        String armor = toString().valueOf(inv.getTotalArmor());
        String damage = toString().valueOf(inv.getTotalDamage());

        ImagesHolder.font8x8.printStringOn(g, "ARMURE : " + armor, 5, ((g.getHeight() + 16) / 2));
        ImagesHolder.font8x8.printStringOn(g, "DEGATS : " + damage, 5, ((g.getHeight() - 16 ) / 2));

        //Mid
        g.drawPixmap(ImagesHolder.gui.x32Box, 104, (g.getHeight() - 16) / 2);

        g.drawPixmap(ImagesHolder.playerset.getTile(counter/10), 112, g.getHeight() / 2);

        /*if(counter > 0 && counter <= 10)
            g.drawPixmap(ImagesHolder.playerset.getTile(0), 112, g.getHeight() / 2);

        else if (counter > 10 && counter <= 20)
            g.drawPixmap(ImagesHolder.playerset.getTile(1), 112, g.getHeight() / 2);

        else if (counter > 20 && counter <= 30)
            g.drawPixmap(ImagesHolder.playerset.getTile(2), 112, g.getHeight() / 2);

        else
            g.drawPixmap(ImagesHolder.playerset.getTile(3), 112, g.getHeight() / 2);*/

    }

    @Override
    public void onPress(UserEvent e) {
        //return on the InventoryEquipState
        if (e.x > 188 && e.y > 4 && e.x < 236 && e.y < 20)
            parent.substate = new InventoryEquipState(parent);
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
