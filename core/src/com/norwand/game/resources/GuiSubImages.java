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
	    heart = PixmapUtility.getPixmapPart(set, 256, 16, 16, 16);
	    menubutton = PixmapUtility.getPixmapPart(set, 256, 160, 48, 16);
	    actbutton = PixmapUtility.getPixmapPart(set, 304, 160, 48, 16);
	    capacitiesbar = PixmapUtility.getPixmapPart(set, 256, 176, 128, 32);
	    itemgui = PixmapUtility.getPixmapPart(set, 256, 256, 48, 32);
	    dialog = PixmapUtility.getPixmapPart(set, 256, 112, 208, 48);
	    hometext = PixmapUtility.getPixmapPart(set, 256, 208, 128, 46);
	    inventorytop1 = PixmapUtility.getPixmapPart(set, 0, 304, 240, 32);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void dispose() {
	// TODO
    }

    public Pixmap heart;
    public Pixmap menubutton;
    public Pixmap actbutton;
    public Pixmap capacitiesbar;
    public Pixmap itemgui;
    public Pixmap dialog;
    public Pixmap hometext;
    public Pixmap inventorytop1;
}
