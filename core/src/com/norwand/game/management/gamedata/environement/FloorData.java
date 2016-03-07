package com.norwand.game.management.gamedata.environement;

import com.badlogic.gdx.files.FileHandle;
import com.norwand.game.management.gamedata.environement.entities.Entity;
import com.norwand.game.management.gamedata.environement.tileentities.TileEntity;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.StringUtility;
import com.norwand.game.utility.objects.AnimatedSprite;

/**
 * Object that is used to extract floordata from a floor file and to create a
 * floor object out of it. This is the default <code>FloorData</code> object,
 * that doesn't handle entities and tileentities. You should consider extends
 * this class for all maps in the game.
 */
public class FloorData {

    public Tile[] tiles;
    public int width;
    public int height;

    public Entity[] entities;

    public TileEntity[] tileentities;

    /**
     * Creates a new FloorData object using the file at the filepath location. <br>
     * Warning : using this constructor will set the entity and tileentities of
     * this floor to empty arrays.
     */
    public FloorData(FileHandle file) {
	this.entities = new Entity[] {};
	this.tileentities = new TileEntity[] {};
	String fs = file.readString();
	String[] parts = fs.split("\\[");
	int[] phy = null, bg1 = null, bg2 = null, fg1 = null, fg2 = null;
	for (int i = 0; i < parts.length; ++i)
	    if (parts[i].startsWith("header]")) {
		String tmp = parts[i].split("width=")[1].split("\n")[0];
		width = Integer.parseInt(tmp.substring(0, tmp.length() - 1));
		tmp = parts[i].split("height=")[1].split("\n")[0];
		height = Integer.parseInt(tmp.substring(0, tmp.length() - 1));
	    } else if (parts[i].startsWith("layer]")) {
		String name = parts[i].split("type=")[1].split("\n")[0];
		name = name.substring(0, name.length() - 1);
		String layer = parts[i].split("type=")[1];
		layer.replaceAll("\n", "");
		layer = layer.split("data=")[1];
		String[] sids = layer.split(",");
		int[] ids = new int[sids.length];
		for (int j = 0; j < ids.length; j++)
		    try {
			ids[j] = Integer.parseInt(StringUtility
				.getNumbers(sids[j]));
		    } catch (Exception e) {
		    }
		if (name.equals("physics"))
		    phy = ids;// no switch
		else if (name.equals("bg1"))
		    bg1 = ids;
		else if (name.equals("bg2"))
		    bg2 = ids;
		else if (name.equals("fg1"))
		    fg1 = ids;
		else if (name.equals("fg2"))
		    fg2 = ids;
	    }
	tiles = new Tile[width * height];
	for (int i = 0; i < width * height; i++) {
	    try {
		tiles[i] = new Tile(converttiletype(phy[i] - 1),
			new AnimatedSprite[] {
				ImagesHolder.tileset
					.getTileAnimation(bg1[i] - 1),
				ImagesHolder.tileset
					.getTileAnimation(bg2[i] - 1) },
			new AnimatedSprite[] {
				ImagesHolder.tileset
					.getTileAnimation(fg1[i] - 1),
				ImagesHolder.tileset
					.getTileAnimation(fg2[i] - 1) });
	    } catch (Exception e) {
		System.err.println("Couldn't create tile " + i
			+ " when creating a floor.");
	    }
	}
    }

    /** Converts Tiled physics ID to tile object IDs. */
    private int converttiletype(int i) {
	switch (i) {
	case TILEVALUE_SOLID:
	    return Tile.TYPE_SOLID;
	case TILEVALUE_AIR:
	    return Tile.TYPE_NORMAL;
	case TILEVALUE_ICE:
	    return Tile.TYPE_ICE;
	case TILEVALUE_WATER:
	    return Tile.TYPE_WATER;
	case TILEVALUE_LAVA:
	    return Tile.TYPE_LAVA;
	case TILEVALUE_ACID:
	    return Tile.TYPE_ACID;
	case TILEVALUE_VOID:
	    return Tile.TYPE_VOID;
	}
	System.err
		.println("Conversion could not be done, returned Normal tile type.");
	return Tile.TYPE_NORMAL;
    }

    public static final int TILEVALUE_SOLID = 1101;
    public static final int TILEVALUE_AIR = 1102;
    public static final int TILEVALUE_ICE = 1103;
    public static final int TILEVALUE_WATER = 1104;
    public static final int TILEVALUE_LAVA = 1105;
    public static final int TILEVALUE_ACID = 1106;
    public static final int TILEVALUE_VOID = 1107;
}
