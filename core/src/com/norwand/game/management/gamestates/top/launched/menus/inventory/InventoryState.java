package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.ExploreState;
import com.norwand.game.resources.ImagesHolder;
import com.sun.org.apache.xpath.internal.SourceTree;

import sun.applet.Main;

public class InventoryState extends GameState {

    public InventoryState(GameState parent) {
        super(parent);
    }

    private int counter;
    private int cursorposition;

    @Override
    public void update() {
        ++counter;
        if (counter > 70)
            counter = 0;
        if (cursorposition > GameData.get().player.inventory.items.length - 1 || cursorposition < 0)
            cursorposition = 0;
    }

    @Override
    public void print(Pixmap g) {
        Inventory inv = GameData.get().player.inventory;
        g.drawPixmap(ImagesHolder.gui.inventorytop1, 0, 0);
        for (int i = 32; i < g.getHeight() - 32; i += 16)
            g.drawPixmap(ImagesHolder.gui.inventorymid1, 0, i);
        for (int i = 0; i < inv.items.length; i++) {
            g.drawPixmap(inv.items[i].getSprite(), 57 + 21 * (i % 7),
                    35 + 21 * (i / 7));
            if (i == cursorposition)
                printCursor(g, 53 + 21 * (i % 7), 31 + 21 * (i / 7), 16, 16, counter < 35);
        }
        g.drawPixmap(ImagesHolder.gui.inventorymid1, 0, g.getHeight() - 32);
        if (cursorposition <= inv.items.length - 1 && cursorposition >= 0)
            ImagesHolder.font8x8.printStringOn(g, inv.items[cursorposition].getItemDescription(), 58, g.getHeight() - 28);
        g.drawPixmap(ImagesHolder.gui.inventoryselect1, 0, g.getHeight() - 32);
        g.drawPixmap(ImagesHolder.gui.inventorybot1, 0, g.getHeight() - 16);
        int h = g.getHeight() - 32;
        g.drawPixmap(ImagesHolder.gui.x32Box, 9, h / 3 + 16);
        g.drawPixmap(ImagesHolder.gui.x32Box, 9, h - h / 3 + 16);
        ImagesHolder.font8x8.printStringOn(g, "Inventory : Items", 5, 7);

        if (inv.quickItem1 != null)
            g.drawPixmap(inv.quickItem1.getSprite(), 17, h / 3 + 24);
        if (inv.quickItem2 != null)
            g.drawPixmap(inv.quickItem2.getSprite(), 17, h - h / 3 + 24);
        g.drawPixmap(ImagesHolder.gui.inventoryarrow, 220,
                g.getHeight() / 2 - 16);
    }

    @Override
    public void onPress(UserEvent e) {
        if (e.x > 188 && e.y > 4 && e.x < 236 && e.y < 20) {
            parent.parent.substate = new ExploreState(parent.parent);
        } else if (e.y > 32 && e.x > 53 && e.x < 208 && e.y < MainGame.getBufferHeight() - 32) {
            int newCursorposition = (e.x - 57) / 21 + (e.y - 35) / 21 * 7;
            if (GameData.get().player.inventory.items.length - 1 >= newCursorposition && newCursorposition >= 0) {
                cursorposition = newCursorposition;
            }
        }
        //buttons deletes, quick stack, use
        else if (e.y > MainGame.getBufferHeight() - 32 && e.y <= MainGame.getBufferHeight() - 16) {
            Inventory i = GameData.get().player.inventory;
            //button delete
            if (e.x > 161 && e.x < 177) {
                i.removeItem(i.items[cursorposition]);
            }
            //button quick stack
            else if (e.x > 177 && e.x < 193) {
                i.equipItem(i.items[cursorposition]);
            }
            //button use
            else if (e.x > 193 && e.x < 208) {
                i.items[cursorposition].onUse();
            }
        }
        //switch page
        else if (e.x > 220 && e.x < 236 && e.y > MainGame.getBufferHeight() / 2 - 16 && e.y < MainGame.getBufferHeight() / 2 + 32)
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

    /**
     * Draws a selectcursor of the wanted size at the wanted coordinates on the
     * g Pixmap. The cursor is smaller by one pixel on each side if the "state"
     * boolean is true, allwoing to make pretty animated cursors easily. This
     * will fail if the ImageHolder is not instancied.
     */
    public static void printCursor(Pixmap g, int x, int y, int height,
                                   int width, boolean state) {
        g.drawPixmap(ImagesHolder.gui.inventorycursorNW, (state) ? x : x + 1,
                (state) ? y : y + 1);
        g.drawPixmap(ImagesHolder.gui.inventorycursorNE, (state) ? x + width
                : x + width - 1, (state) ? y : y + 1);
        g.drawPixmap(ImagesHolder.gui.inventorycursorSW, (state) ? x : x + 1,
                (state) ? y + height : y + height - 1);
        g.drawPixmap(ImagesHolder.gui.inventorycursorSE, (state) ? x + height
                : x + height - 1, (state) ? y + height : y + height - 1);
    }
}
