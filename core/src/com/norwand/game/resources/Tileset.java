package com.norwand.game.resources;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Disposable;
import com.norwand.game.utility.PixmapUtility;
import com.norwand.game.utility.objects.AnimatedSprite;

/** A tileset. holds tiles. */
public class Tileset implements Disposable {

    private Pixmap[] tiles;

    /**
     * Creates a tileset using the source. the inner tiles don't share the same
     * data array as the source.
     */
    public Tileset(int tilesize, Pixmap source) {
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

    /** Returns the annimated sprite of the wanted tile tileset. */
    public AnimatedSprite getTileAnimation(int id) {
	switch (id) {
	case 565:
	    return new AnimatedSprite(new Pixmap[] { tiles[565], tiles[1013] },
		    (byte) 45);
	case 566:
	    return new AnimatedSprite(new Pixmap[] { tiles[566], tiles[1014] },
		    (byte) 59);
	case 1536:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1536], tiles[1544] }, (byte) 25);
	case 1537:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1537], tiles[1545] }, (byte) 25);
	case 1538:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1538], tiles[1546] }, (byte) 25);
	case 1568:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1568], tiles[1576] }, (byte) 25);
	case 1569:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1569], tiles[1577] }, (byte) 25);
	case 1570:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1570], tiles[1578] }, (byte) 25);
	}
	try {
	    return new AnimatedSprite(tiles[id]);
	} catch (Exception e) {
	    return null;
	}
    }

}
