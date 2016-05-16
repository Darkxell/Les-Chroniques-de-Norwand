package com.norwand.game.resources;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Disposable;
import com.norwand.game.utility.PixmapUtility;

/** Holds the subimages of the gui set. */
public class GuiSubImages implements Disposable {

    public GuiSubImages(Pixmap p) {
	instanciate(p);
    }

    public void instanciate(Pixmap set) {
	try {
	    menubutton = PixmapUtility.getPixmapPart(set, 256, 160, 48, 16);
	    actbutton = PixmapUtility.getPixmapPart(set, 304, 160, 48, 16);
	    capacitiesbar = PixmapUtility.getPixmapPart(set, 256, 176, 128, 32);
	    itemgui = PixmapUtility.getPixmapPart(set, 256, 256, 48, 32);
	    dialog = PixmapUtility.getPixmapPart(set, 256, 112, 208, 48);
	    hometext = PixmapUtility.getPixmapPart(set, 256, 208, 128, 46);
	    hometexttsp = PixmapUtility.getPixmapPart(set, 384, 208, 128, 46);
	    inventorytop1 = PixmapUtility.getPixmapPart(set, 0, 304, 240, 32);
	    inventorybot1 = PixmapUtility.getPixmapPart(set, 0, 352, 240, 16);
	    inventorymid1 = PixmapUtility.getPixmapPart(set, 0, 336, 240, 16);
	    x32Box = PixmapUtility.getPixmapPart(set, 0, 368, 32, 32);
	    inventoryarrow = PixmapUtility.getPixmapPart(set, 240, 304, 16, 48);
	    hometop = PixmapUtility.getPixmapPart(set, 0, 0, 240, 48);
	    homebot = PixmapUtility.getPixmapPart(set, 0, 48, 240, 64);
	    start1 = PixmapUtility.getPixmapPart(set, 352, 160, 64, 16);
	    start2 = PixmapUtility.getPixmapPart(set, 416, 160, 64, 16);
	    inventoryselect1 = PixmapUtility
		    .getPixmapPart(set, 0, 400, 240, 16);
	    inventorycursorNW = PixmapUtility.getPixmapPart(set, 32, 368, 8, 8);
	    inventorycursorNE = PixmapUtility.getPixmapPart(set, 40, 368, 8, 8);
	    inventorycursorSW = PixmapUtility.getPixmapPart(set, 32, 376, 8, 8);
	    inventorycursorSE = PixmapUtility.getPixmapPart(set, 40, 376, 8, 8);
        ringSlot = PixmapUtility.getPixmapPart(set, 48, 384, 16, 16);
        helmetSlot = PixmapUtility.getPixmapPart(set, 64, 384, 16, 16);
        bootsSlot = PixmapUtility.getPixmapPart(set, 80, 384, 16, 16);
        armorSlot = PixmapUtility.getPixmapPart(set, 96, 384, 16, 16);
        necklaceSlot = PixmapUtility.getPixmapPart(set, 112, 384, 16, 16);
        weapon1Slot = PixmapUtility.getPixmapPart(set, 144, 384, 16, 16);
        weapon2Slot = PixmapUtility.getPixmapPart(set, 160, 384, 16, 16);
        selectArrowUp = PixmapUtility.getPixmapPart(set, 48, 368, 8, 8);
        selectArrowDown = PixmapUtility.getPixmapPart(set, 48, 376, 8, 8);
        inventoryEquipTop = PixmapUtility.getPixmapPart(set, 0, 416 , 240, 64);
        inventoryEquipMid = PixmapUtility.getPixmapPart(set, 0, 480 , 240, 16);
        inventoryEquipBot = PixmapUtility.getPixmapPart(set, 0, 496 , 240, 16);
        inventoryEquipSelect = PixmapUtility.getPixmapPart(set, 0, 288, 240, 16);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void dispose() {
	// TODO : dispose of the pixmaps below and set them to null.
    }

    public Pixmap menubutton;
    public Pixmap actbutton;
    public Pixmap capacitiesbar;
    public Pixmap itemgui;
    public Pixmap dialog;
    public Pixmap hometext;
    public Pixmap hometexttsp;
    public Pixmap inventorytop1;
    public Pixmap inventorybot1;
    public Pixmap inventorymid1;
    public Pixmap inventoryselect1;
    public Pixmap x32Box;
    public Pixmap inventoryarrow;
    public Pixmap hometop;
    public Pixmap homebot;
    public Pixmap start1;
    public Pixmap start2;
    public Pixmap inventorycursorNW;
    public Pixmap inventorycursorNE;
    public Pixmap inventorycursorSW;
    public Pixmap inventorycursorSE;
    public Pixmap ringSlot;
    public Pixmap helmetSlot;
    public Pixmap bootsSlot;
    public Pixmap armorSlot;
    public Pixmap necklaceSlot;
    public Pixmap weapon1Slot;
    public Pixmap weapon2Slot;
    public Pixmap selectArrowUp;
    public Pixmap selectArrowDown;
    public Pixmap inventoryEquipTop;
    public Pixmap inventoryEquipMid;
    public Pixmap inventoryEquipBot;
    public Pixmap inventoryEquipSelect;

}
