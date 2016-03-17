package com.norwand.game.resources;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.utility.objects.AnimatedSprite;

/** A tileset. holds tiles. */
public class Tileset extends PixmapSet {

    public Tileset(int tilesize, Pixmap source) {
	super(tilesize, source);
    }

    /**
     * Returns the annimated sprite of the wanted tile tileset. This is
     * unoptimized, and should not be used in the gameloop.
     */
    public AnimatedSprite getTileAnimation(int id) {
	if (id == -1)
	    return null;
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
