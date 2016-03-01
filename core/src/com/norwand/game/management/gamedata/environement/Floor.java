package com.norwand.game.management.gamedata.environement;

/**
 * Represents a part of the world around the player. It includes the tiles of
 * the current floor instance, all of the entities and tileentities on this
 * instance.
 */
public class Floor {

    public Floor(FloorData data) {

    }

    public Tile[] tiles;
    public int width;
    public int height;

    public Entity[] entities;

    public TileEntities[] tileentities;

    /** Updates this floor. This inclues the tiles, entities and tileentities. */
    public void update() {

    }

}
