package com.norwand.game.resources;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Disposable;
import com.norwand.game.utility.PixmapUtility;

public abstract class PixmapSet implements Disposable {

    /** The inner array of pixmaps. */
    protected Pixmap[] tiles;

    /**
     * Creates a new pixmapset using the source. the inner pixmaps don't share
     * the same data array as the source.
     */
    public PixmapSet(int tilesize, Pixmap source) {
	int width = source.getWidth() / tilesize, height = source.getHeight()
		/ tilesize;
	tiles = new Pixmap[height * width];
	for (int i = 0; i < width; i++)
	    for (int j = 0; j < height; j++) {
		try {
		    tiles[i + j * width] = PixmapUtility.getPixmapPart(source,
			    i * tilesize, j * tilesize, tilesize, tilesize);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
    }

    @Override
    public void dispose() {
	if (tiles != null)
	    for (int i = 0; i < tiles.length; i++)
		tiles[i].dispose();
    }

    /** Returns the tile of raw id ID in the tile array. */
    public Pixmap getTile(int id) {
	try {
	    return tiles[id];
	} catch (Exception e) {
	    return null;
	}
    }
}
