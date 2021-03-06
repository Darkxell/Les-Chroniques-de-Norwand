package com.norwand.game.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.utility.objects.BitmapFont;

/** Holds different Pixmaps holding the Image sets. */
public abstract class ImagesHolder {

    private static boolean isinstancied = false;

    /** Instanciate all of the ressources holded by this class. */
    public static void create(String assetspath) {
	try {
	    Pixmap enti = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/entities.png"));
	    entityset = new Entityset(16, enti);
	    enti.dispose();
	    Pixmap part = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/particles.png"));
	    particleset = new Particleset(16, part);
	    part.dispose();
	    Pixmap item = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/items.png"));
	    itemset = new Itemset(16, item);
	    item.dispose();
	    Pixmap tset = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/tileset.png"));
	    tileset = new Tileset(16, tset);
	    tset.dispose();
	    Pixmap pset = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/player.png"));
	    playerset = new Playerset(16, pset);
	    pset.dispose();
	    Pixmap cset = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/capacities.png"));
	    capacityset = new Capacityset(32, cset);
	    cset.dispose();
	    Pixmap pgui = new Pixmap(
		    Gdx.files.internal(assetspath + "textures/gui.png"));
	    gui = new GuiSubImages(pgui);
	    pgui.dispose();
	    Pixmap bmft = new Pixmap(
		    Gdx.files.internal(assetspath + "textures/font.png"));
	    font8x8 = new BitmapFont(bmft);
	    bmft.dispose();
	    isinstancied = true;
	} catch (Exception e) {
	    e.printStackTrace();
	    dispose();
	}
    }

    /** Disposes all the ressouces holded by this class. */
    public static void dispose() {
	tileset.dispose();
	tileset = null;
	entityset.dispose();
	entityset = null;
	particleset.dispose();
	particleset = null;
	itemset.dispose();
	itemset = null;
	playerset.dispose();
	playerset = null;
	capacityset.dispose();
	capacityset = null;
	gui.dispose();
	gui = null;
	font8x8.dispose();
	font8x8 = null;
	isinstancied = false;
    }

    /** Returns true if the pixmaps in this class are created and not disposed. */
    public static boolean isInstancied() {
	return isinstancied;
    }

    public static GuiSubImages gui;

    public static Tileset tileset;
    public static Entityset entityset;
    public static Particleset particleset;
    public static Itemset itemset;
    public static Playerset playerset;
    public static Capacityset capacityset;
    public static BitmapFont font8x8;

}
