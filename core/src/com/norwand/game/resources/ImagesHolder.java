package com.norwand.game.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

/** Holds different Pixmaps holding the Image sets. */
public abstract class ImagesHolder {

    private static boolean isinstancied = false;

    /** Instanciate all of the ressources holded by this class. */
    public static void create(String assetspath) {
	try {
	    entities = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/entities.png"));
	    particles = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/particles.png"));
	    items = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/items.png"));
	    tileset_source = new Pixmap(Gdx.files.internal(assetspath
		    + "textures/tileset.png"));
	    tileset = new Tileset(16, tileset_source);
	    gui =  new Pixmap(Gdx.files.internal(assetspath
		    + "textures/gui/gui.png"));
	    isinstancied = true;
	} catch (Exception e) {
	    e.printStackTrace();
	    dispose();
	}
    }

    /** Disposes all the ressouces holded by this class. */
    public static void dispose() {
	entities.dispose();
	entities = null;
	particles.dispose();
	particles = null;
	items.dispose();
	items = null;
	tileset_source.dispose();
	tileset_source = null;
	tileset.dispose();
	tileset = null;
	gui.dispose();
	gui = null;
	isinstancied = false;
    }

    /** Returns true if the pixmaps in this class are created and not disposed. */
    public boolean isInstancied() {
	return isinstancied;
    }

    public static Pixmap entities;
    public static Pixmap items;
    public static Pixmap particles;
    public static Pixmap tileset_source;
    public static Tileset tileset;
    public static Pixmap gui;

}
