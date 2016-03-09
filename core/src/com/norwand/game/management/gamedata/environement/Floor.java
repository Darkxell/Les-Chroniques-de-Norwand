package com.norwand.game.management.gamedata.environement;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.environement.entities.Entity;
import com.norwand.game.management.gamedata.environement.tileentities.TileEntity;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamedata.player.Player;

/**
 * Represents a part of the world around the player. It includes the tiles of
 * the current floor instance, all of the entities and tileentities on this
 * instance.
 */
public class Floor {

    /**
     * Constructs a floor object from a FloorData object and a pointer to the
     * player.
     */
    public Floor(FloorData data, Player playerpointer) {
	tiles = data.tiles;
	width = data.width;
	height = data.height;
	this.playerpointer = playerpointer;
    }

    /** Pointer to the player object. */
    protected Player playerpointer;

    /** The tiles of this floor */
    protected Tile[] tiles;
    /** Represents the width of this floor. */
    public int width;
    /** Represents the height of this floor. */
    public int height;

    /** The list of entities of this floor. */
    protected Entity[] entities;
    /** The list of tileentities of this floor. */
    protected TileEntity[] tileentities;

    /** Updates this floor. This inclues the tiles, entities and tileentities. */
    public void update() {
	for (int i = 0; i < tiles.length; i++)
	    try {
		tiles[i].update();
	    } catch (Exception e) {
	    }
    }

    /**
     * Print this floor on the g Pixmap at the wanted coordinates.
     * 
     * @param g
     *            the graphic object.
     * @param x
     *            the x position where to draw the floor. This value represents
     *            the x position on the floor to be drawn on the left side.
     * @param y
     *            the y position where to draw the floor. This value represents
     *            the y position on the floor to be drawn on the top side.
     * */
    public void printOn(Pixmap g, double x, double y) {
	// print background
	for (int i = 0; i < width; i++)
	    for (int j = 0; j < height; j++) {
		try {
		    for (int j2 = 0; j2 < tiles[i + j * width].background.length; j2++)
			g.drawPixmap(tiles[i + j * width].background[j2]
				.getCurrentFrame(), (int) (16 * (i + x)),
				(int) (16 * (j + y)));
		} catch (Exception e) {
		}
	    }
	// Print player
	g.drawPixmap(playerpointer.getSprite(),
		(int) ((playerpointer.x + x) * 16)
			- (playerpointer.getSprite().getWidth() / 2),
		(int) ((playerpointer.y + y) * 16)
			- (playerpointer.getSprite().getHeight() / 2));
	// Print entities n stuff

	// Print foreground
	for (int i = 0; i < width; i++)
	    for (int j = 0; j < height; j++) {
		try {
		    for (int j2 = 0; j2 < tiles[i + j * width].foreground.length; j2++)
			g.drawPixmap(tiles[i + j * width].foreground[j2]
				.getCurrentFrame(), (int) (16 * (i + x)),
				(int) (16 * (j + y)));
		} catch (Exception e) {
		}
	    }
    }

    /** Gets the tile at the wanted coordinates in this floor. */
    public Tile getTileAt(int x, int y) {
	if (!(x > width || y > height || y < 0 || x < 0))
	    return tiles[x + (width * y)];
	else {
	    System.err.println("Unknown tile at coords : " + x + "/" + y
		    + " , returned default type.");
	    return new Tile(Tile.TYPE_NORMAL, null, null);
	}
    }
    
    /**Gets the physics at the wanted float coordinates. This returns the first encountered tileEntity physics, or by default the tile physics under. If no tileEntity is found nor */

    /** Deletes this entity from this floor. */
    public void deleteEntity(Entity pointer) {
	Entity[] newentities = new Entity[entities.length - 1];
	int removeid = -1;
	for (int i = 0; i < entities.length; i++)
	    if (entities[i] == pointer)
		removeid = i;
	if (removeid == -1)
	    System.err.println("Entitée non trouvée. Délétion impossible.");
	else {
	    System.arraycopy(entities, 0, newentities, 0, removeid);
	    System.arraycopy(entities, removeid + 1, newentities, removeid,
		    entities.length - 1 - removeid);
	    this.entities = newentities;
	}
    }

    /** Adds this entity to this floor. */
    public void addEntity(Entity toAdd) {
	Entity[] entities2 = new Entity[entities.length + 1];
	System.arraycopy(entities, 0, entities2, 0, entities.length);
	entities2[entities.length] = toAdd;
	entities = entities2;
    }

}
