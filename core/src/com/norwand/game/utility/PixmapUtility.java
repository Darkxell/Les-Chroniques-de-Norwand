package com.norwand.game.utility;

import com.badlogic.gdx.graphics.Pixmap;

/** Utility class to manipulate pixmaps. */
public abstract class PixmapUtility {

    /**
     * This method gets a specific rectangular region of a pixmap and return a
     * new pixmap (not sharing the data buffer). Make sure to dispose of the old
     * pixmap if you don't use it anymore.
     * 
     * @throws Exception
     *             if the selection is not contained inside the source.
     * @param source
     *            The scource pixmap. The resulted image will be the specified
     *            part of this one.
     * @param cornerX
     *            The left border of the returned image.
     * @param cornerY
     *            The top border of the returned image.
     * @param height
     *            The height of the selection.
     * @param width
     *            The width of the selection.
     */
    public static Pixmap getPixmapPart(Pixmap source, int cornerX, int cornerY,
	    int height, int width) throws Exception {
	Pixmap toreturn = new Pixmap(height, width, source.getFormat());
	try {
	    for (int i = 0; i < height; i++) {
		for (int j = 0; j < width; j++) {
		    toreturn.drawPixel(i, j,
			    source.getPixel(cornerX + i, cornerY + j));
		}
	    }
	    return toreturn;
	} catch (Exception e) {
	    toreturn.dispose();
	    throw new Exception("Selection out of bound exeption.");
	}
    }

}
