package com.norwand.game.management.gamedata.environement;

import com.norwand.game.management.gamedata.environement.entities.Entity;
import com.norwand.game.management.gamedata.environement.tileentities.TileEntity;
import com.norwand.game.management.gamedata.environement.tiles.Tile;

/**
 * Represents a part of the world around the player. It includes the tiles of
 * the current floor instance, all of the entities and tileentities on this
 * instance.
 */
public class Floor {

    public Floor(FloorData data) {
	tiles = data.tiles;
	width = data.width;
	height = data.height;
    }

    public Tile[] tiles;
    public int width;
    public int height;

    public Entity[] entities;

    public TileEntity[] tileentities;

    /** Updates this floor. This inclues the tiles, entities and tileentities. */
    public void update() {
	for (int i = 0; i < tiles.length; i++) {
	    tiles[i].update();
	}
    }

}
