package com.norwand.game.management.gamedata.environement;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.entities.Entity;
import com.norwand.game.management.gamedata.environement.tileentities.TileEntity;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.utility.objects.Position;

/**
 * Represents a part of the world around the player. It includes the tiles of
 * the current floor instance, all of the entities and tileentities on this
 * instance.
 */
public abstract class Floor {

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
    protected Entity[] entities = new Entity[] {};
    /** The list of tileentities of this floor. */
    protected TileEntity[] tileentities = new TileEntity[] {};

    /** Updates this floor. This inclues the tiles, entities and tileentities. */
    public void update() {
	for (int i = 0; i < tiles.length; i++)
	    tiles[i].update();
	for (int i = 0; i < entities.length; i++)
	    entities[i].update();
	for (int i = 0; i < tileentities.length; i++)
	    tileentities[i].update();
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
		if (tiles[i + j * width].background != null)
		    for (int j2 = 0; j2 < tiles[i + j * width].background.length; j2++)
			g.drawPixmap(tiles[i + j * width].background[j2]
				.getCurrentFrame(), (int) (16 * (i + x)),
				(int) (16 * (j + y)));
	    }
	// Print player
	g.drawPixmap(playerpointer.getSprite(),
		(int) ((playerpointer.x + x) * 16)
			- (playerpointer.getSprite().getWidth() / 2),
		(int) ((playerpointer.y + y) * 16)
			- (playerpointer.getSprite().getHeight() / 2));
	// Print entities n stuff
	for (int j = 0; j < entities.length; j++)
	    g.drawPixmap(entities[j].getCurrentSprite(),
		    (int) (16 * (entities[j].posX + x))
			    - (entities[j].getCurrentSprite().getWidth() / 2),
		    (int) (16 * (entities[j].posY + y))
			    - (entities[j].getCurrentSprite().getHeight() / 2));

	for (int j = 0; j < tileentities.length; j++)
	    g.drawPixmap(
		    tileentities[j].getCurrentSprite(),
		    (int) (16 * (tileentities[j].posX + x))
			    - (tileentities[j].getCurrentSprite().getWidth() / 2),
		    (int) (16 * (tileentities[j].posY + y))
			    - (tileentities[j].getCurrentSprite().getHeight() / 2));
	// Print foreground
	for (int i = 0; i < width; i++)
	    for (int j = 0; j < height; j++)
		if (tiles[i + j * width].foreground != null)
		    for (int j2 = 0; j2 < tiles[i + j * width].foreground.length; j2++)
			g.drawPixmap(tiles[i + j * width].foreground[j2]
				.getCurrentFrame(), (int) (16 * (i + x)),
				(int) (16 * (j + y)));
    }

    /** Gets the tile at the wanted coordinates in this floor. */
    public Tile getTileAt(int x, int y) {
	if (!(x >= width || y >= height || y < 0 || x < 0))
	    return tiles[x + (width * y)];
	else {
	    System.err.println("Unknown tile at coords : " + x + "/" + y
		    + " , returned default template tile (normal type).");
	    return new Tile(Tile.TYPE_NORMAL, null, null);
	}
    }

    /**
     * Returns the x/y position of the tile t in this floor. Returns null if no
     * tile is found.
     */
    public Position getTilePosition(Tile t) {
	for (int i = 0; i < tiles.length; i++)
	    if (tiles[i] == t)
		return new Position(i % width, (int) i / width);
	return null;
    }

    /** Sets the tile at the wanted position to the wanted tile. */
    public void setTileAt(int x, int y, Tile t) {
	tiles[x + (width * y)] = t;
    }

    /**
     * Gets the physics at the wanted float coordinates. This returns the first
     * encountered tileEntity physics, or by default the tile physics under.
     */
    public byte getPhysicsAt(double x, double y) {
	return getPhysicsAt(new Position(x, y));
    }

    /**
     * Gets the physics at the wanted position. This returns the first
     * encountered tileEntity physics, or by default the tile physics under.
     */
    public byte getPhysicsAt(Position p) {
	for (int i = 0; i < tileentities.length; i++)
	    if (tileentities[i].getHitbox(tileentities[i].posX,
		    tileentities[i].posY).isInside(p))
		return tileentities[i].getPhysics();
	return getTileAt((int) p.x, (int) p.y).type;
    }

    /** Returns true if the player is close to an actable entity or tileentity. */
    public boolean canPlayerAct() {
	Position playerpos = new Position(GameData.get().player.x,
		GameData.get().player.y);
	for (int i = 0; i < entities.length; i++)
	    if (entities[i].canActWith()
		    && playerpos.getDistanceFrom(new Position(entities[i].posX,
			    entities[i].posY)) < 1.5)
		return true;
	for (int i = 0; i < tileentities.length; i++)
	    if (tileentities[i].canActWith()
		    && playerpos.getDistanceFrom(new Position(
			    tileentities[i].posX, tileentities[i].posY)) < 1.5)
		return true;
	return false;
    }

    /**
     * Interacts with the closest entity or tileentity it founds, calling its
     * onAct() method.
     */
    public void actClosest() {
	int te_id = -1, e_id = -1;
	double te_dist = Double.MAX_VALUE, e_dist = Double.MAX_VALUE;
	Position playerpos = new Position(GameData.get().player.x,
		GameData.get().player.y);
	for (int i = 0; i < entities.length; i++)
	    if (entities[i].canActWith()
		    && new Position(entities[i].posX, entities[i].posY)
			    .getDistanceFrom(playerpos) < e_dist) {
		e_dist = new Position(entities[i].posX, entities[i].posY)
			.getDistanceFrom(playerpos);
		e_id = i;
	    }
	for (int i = 0; i < tileentities.length; i++)
	    if (tileentities[i].canActWith()
		    && new Position(tileentities[i].posX, tileentities[i].posY)
			    .getDistanceFrom(playerpos) < e_dist) {
		te_dist = new Position(tileentities[i].posX,
			tileentities[i].posY).getDistanceFrom(playerpos);
		te_id = i;
	    }
	if (te_dist != -1 && e_dist != -1)
	    if (te_dist < e_dist)
		tileentities[te_id].onAct();
	    else
		entities[e_id].onAct();
    }

    /**
     * Returns the closest Default type tile position. The returned position is
     * the middle of the tile. This cannot return a position outside of this
     * floor.
     */
    public Position getClosestRespawnPoint(Position from) {
	int x = (int) from.x, y = (int) from.y;
	if (getPhysicsAt(x + 0.5, y + 0.5) == Tile.TYPE_NORMAL)
	    return new Position(x + 0.5, y + 0.5);
	for (int dist = 1; dist < 15; ++dist)
	    for (int i = -dist; i <= dist; ++i)
		for (int j = -dist; j <= dist; ++j)
		    if (x + i >= 0
			    && x + i < width
			    && y + j >= 0
			    && y + j < height
			    && getPhysicsAt(x + 0.5 + i, y + 0.5 + j) == Tile.TYPE_NORMAL)
			return new Position(x + 0.5 + i, y + 0.5 + j);
	System.err.println("Could not return a respawn point from " + from.x
		+ "/" + from.y + ".");
	return from;
    }

    /** Deletes this entity from this floor. */
    public void deleteEntity(Entity pointer) {
	if (entities.length == 0)
	    return;
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

    /** Deletes this tileentity from this floor. */
    public void deleteTileEntity(TileEntity pointer) {
	if (tileentities.length == 0)
	    return;
	TileEntity[] newentities = new TileEntity[tileentities.length - 1];
	int removeid = -1;
	for (int i = 0; i < tileentities.length; i++)
	    if (tileentities[i] == pointer)
		removeid = i;
	if (removeid == -1)
	    System.err.println("Entitée non trouvée. Délétion impossible.");
	else {
	    System.arraycopy(tileentities, 0, newentities, 0, removeid);
	    System.arraycopy(tileentities, removeid + 1, newentities, removeid,
		    tileentities.length - 1 - removeid);
	    this.tileentities = newentities;
	}
    }

    /** Adds this tileentity to this floor. */
    public void addTileEntity(TileEntity toAdd) {
	TileEntity[] entities2 = new TileEntity[tileentities.length + 1];
	System.arraycopy(tileentities, 0, entities2, 0, tileentities.length);
	entities2[tileentities.length] = toAdd;
	tileentities = entities2;
    }

    /**
     * Gets the Entities of this floor. The returned array entities share the
     * same datas as the real floor entities.
     */
    public Entity[] getEntities() {
	return this.entities;
    }

    /**
     * Gets the TileEntities of this floor. The returned array tileEntities
     * share the same datas as the real floor tileEntities.
     */
    public Entity[] getTileEntities() {
	return this.tileentities;
    }
	
	/**
	* Returns the display name of this floor. This is used for the map and for 
	* the transitionstate.
	*/
	public abstract String getDisplayName();

}
