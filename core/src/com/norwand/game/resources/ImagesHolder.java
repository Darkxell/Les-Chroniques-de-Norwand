package com.norwand.game.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

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
	    gui = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/gui/gui.png"));
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
	gui.dispose();
	gui = null;
	isinstancied = false;
    }

    /** Returns true if the pixmaps in this class are created and not disposed. */
    public static boolean isInstancied() {
	return isinstancied;
    }

    public static Pixmap gui;

    public static Tileset tileset;
    public static Entityset entityset;
    public static Particleset particleset;
    public static Itemset itemset;

}
