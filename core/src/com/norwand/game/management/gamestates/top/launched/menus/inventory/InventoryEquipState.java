package com.norwand.game.management.gamestates.top.launched.menus.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.MainGame;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.items.Equipable.Armor.Armor;
import com.norwand.game.management.gamedata.items.Equipable.Boots.Boots;
import com.norwand.game.management.gamedata.items.Equipable.Equipable;
import com.norwand.game.management.gamedata.items.Equipable.Helmet.Helmet;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.Necklace;
import com.norwand.game.management.gamedata.items.Equipable.Ring.Ring;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Weapon;
import com.norwand.game.management.gamedata.player.Inventory;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.launched.explore.ExploreState;
import com.norwand.game.resources.ImagesHolder;

import java.util.ArrayList;
import java.util.Arrays;

public class InventoryEquipState extends GameState {

    public InventoryEquipState(GameState parent) {
        super(parent);
        Inventory inv = GameData.get().player.inventory;
        for (int i = 0; i < inv.equipables.length; ++i) {
            if (inv.equipables[i] instanceof Ring)
                validEquip.add(inv.equipables[i]);
        }
    }

    private int counter, cursorposition, cursopositionEquip;
    private byte arrowAnimation = 40;
    private byte arrowPosition = 0;

    private ArrayList<Equipable> validEquip = new ArrayList<Equipable>();

    @Override
    public void update() {
        --arrowAnimation;
        ++counter;
        if (counter > 70)
            counter = 0;
        if (cursorposition > GameData.get().player.inventory.equipables.length - 1 || cursorposition < 0)
            cursorposition = 0;
        if (arrowAnimation <= 0)
            arrowAnimation = 43;
    }

    @Override
    public void print(Pixmap g) {
        Inventory inv = GameData.get().player.inventory;
        g.drawPixmap(ImagesHolder.gui.inventoryEquipTop, 0, 0);
        for (int i = 64; i < g.getHeight() - 32; i += 16) {
            g.drawPixmap(ImagesHolder.gui.inventoryEquipMid, 0, i);
        }

        //equip
        for (int i = 0; i < validEquip.size(); ++i) {
            g.drawPixmap(validEquip.get(i).getSprite(), 17 + 21 * (i % 9), 67 + 21 * (i / 9));
            if (i == cursorposition)
                InventoryState.printCursor(g, 13 + 21 * (i % 9), 63 + 21 * (i / 9), 16, 16, counter < 35);
        }

        g.drawPixmap(ImagesHolder.gui.inventoryEquipMid, 0, g.getHeight() - 32);

        //description Item

        g.drawPixmap(ImagesHolder.gui.inventoryEquipSelect, 0, g.getHeight() - 32);
        g.drawPixmap(ImagesHolder.gui.inventoryEquipBot, 0, g.getHeight() - 16);

        if (inv.ring == null)
            g.drawPixmap(ImagesHolder.gui.ringSlot, 27, 26);
        else
            g.drawPixmap(inv.ring.getSprite(), 27, 26);

        if (inv.helmet == null)
            g.drawPixmap(ImagesHolder.gui.helmetSlot, 52, 26);
        else
            g.drawPixmap(inv.helmet.getSprite(), 52, 26);

        if (inv.boots == null)
            g.drawPixmap(ImagesHolder.gui.bootsSlot, 77, 26);
        else
            g.drawPixmap(inv.boots.getSprite(), 77, 26);

        if (inv.armor == null)
            g.drawPixmap(ImagesHolder.gui.armorSlot, 102, 26);
        else
            g.drawPixmap(inv.armor.getSprite(), 102, 26);

        if (inv.necklace == null)
            g.drawPixmap(ImagesHolder.gui.necklaceSlot, 127, 26);
        else
            g.drawPixmap(inv.necklace.getSprite(), 127, 26);

        if (inv.weapon1 == null)
            g.drawPixmap(ImagesHolder.gui.weapon1Slot, 162, 26);
        else
            g.drawPixmap(inv.weapon1.getSprite(), 162, 26);

        if (inv.weapon2 == null)
            g.drawPixmap(ImagesHolder.gui.weapon2Slot, 187, 26);
        else
            g.drawPixmap(inv.weapon2.getSprite(), 187, 26);

        g.drawPixmap(ImagesHolder.gui.selectArrowDown, (arrowPosition >= 5) ? 166 + 25 * (arrowPosition - 5) : 31 + 25 * arrowPosition, (arrowAnimation <= 20) ? 46 : 45);

    }

    @Override
    public void onPress(UserEvent e) {
        Inventory inv = GameData.get().player.inventory;
        //return on the explore state
        if (e.x > 188 && e.y > 4 && e.x < 236 && e.y < 20) {
            parent.parent.substate = new ExploreState(parent.parent);
        }

        //field of equipments
        else if (e.y > 62 && e.y < MainGame.getBufferHeight() - 32 && e.x > 9 && e.x < 208) {
            int newCursorposition = (e.x - 13) / 21 + (e.y - 63) / 21 * 9;
            if (validEquip.size() > newCursorposition && newCursorposition >= 0) {
                cursorposition = newCursorposition;
                cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));

                System.out.println("cursorposition : " + cursorposition);
                System.out.println("cursopositionEquip : " + cursopositionEquip);
                System.out.println();
            }
        }

        //buttons
        else if (e.y > MainGame.getBufferHeight() - 32 && e.y <= MainGame.getBufferHeight() - 16) {
            Inventory i = GameData.get().player.inventory;

            //delete button
            if (e.x > 177 && e.x <= 193) {
                System.out.println("delete");
                validEquip.remove(cursorposition);
                inv.removeEquipable(inv.equipables[cursopositionEquip]);
            }

            //equip button
            else if (e.x > 193 && e.x <= 209) {
                System.out.println("equip");
                if(cursopositionEquip >= 0) {
                    System.out.println(inv.equipables[cursopositionEquip]);
                    inv.equipEquipable(inv.equipables[cursopositionEquip]);
                }
            }

        }

        //slots
        else if (e.y > 23 && e.y < 44) {
            cursorposition = 0;

            //ring slot
            if (e.x > 24 && e.x < 45) {
                arrowPosition = 0;
                validEquip.clear();
                for (int i = 0; i < inv.equipables.length; ++i) {
                    if (inv.equipables[i] instanceof Ring)
                        validEquip.add(inv.equipables[i]);
                }

                if(validEquip.size() > 0)
                    cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));
                else
                    cursopositionEquip = -1;
            }

            //helmet slot
            else if (e.x > 49 && e.x < 70) {
                arrowPosition = 1;
                validEquip.clear();
                for (int i = 0; i < inv.equipables.length; ++i) {
                    if (inv.equipables[i] instanceof Helmet)
                        validEquip.add(inv.equipables[i]);
                }
                if(validEquip.size() > 0)
                    cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));
                else
                    cursopositionEquip = -1;
            }

            //boots slot
            else if (e.x > 74 && e.x < 95) {
                arrowPosition = 2;
                validEquip.clear();
                for (int i = 0; i < inv.equipables.length; ++i) {
                    if (inv.equipables[i] instanceof Boots)
                        validEquip.add(inv.equipables[i]);
                }
                if(validEquip.size() > 0)
                    cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));
                else
                    cursopositionEquip = -1;
            }

            //armor slot
            else if (e.x > 99 && e.x < 120) {
                arrowPosition = 3;
                validEquip.clear();
                for (int i = 0; i < inv.equipables.length; ++i) {
                    if (inv.equipables[i] instanceof Armor)
                        validEquip.add(inv.equipables[i]);
                }
                if(validEquip.size() > 0)
                    cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));
                else
                    cursopositionEquip = -1;
            }

            //necklace slot
            else if (e.x > 124 && e.x < 145) {
                arrowPosition = 4;
                validEquip.clear();
                for (int i = 0; i < inv.equipables.length; ++i) {
                    if (inv.equipables[i] instanceof Necklace)
                        validEquip.add(inv.equipables[i]);
                }
                if(validEquip.size() > 0)
                    cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));
                else
                    cursopositionEquip = -1;
            }

            //weapon1 slot
            else if (e.x > 159 && e.x < 180) {
                arrowPosition = 5;
                validEquip.clear();
                for (int i = 0; i < inv.equipables.length; ++i) {
                    if (inv.equipables[i] instanceof Weapon)
                        validEquip.add(inv.equipables[i]);
                }
                if(validEquip.size() > 0)
                    cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));
                else
                    cursopositionEquip = -1;
            }

            //weapon2 slot
            else if (e.x > 184 && e.x < 205) {
                arrowPosition = 6;
                validEquip.clear();
                for (int i = 0; i < inv.equipables.length; ++i) {
                    if (inv.equipables[i] instanceof Weapon)
                        validEquip.add(inv.equipables[i]);
                }
                if(validEquip.size() > 0)
                    cursopositionEquip = Arrays.asList(inv.equipables).indexOf(validEquip.get(cursorposition));
                else
                    cursopositionEquip = -1;
            }

            System.out.println("cursorposition :" + cursorposition);
            System.out.println("cursopositionEquip : " + cursopositionEquip);
            System.out.println();
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
