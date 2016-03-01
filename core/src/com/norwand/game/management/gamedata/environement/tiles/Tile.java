package com.norwand.game.management.gamedata.environement.tiles;

public class Tile {

    public Tile() {

    }

    /** The physics of the tile. */
    public int type;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SOLID = 1;
    public static final int TYPE_ICE = 2;
    public static final int TYPE_WATER = 3;
    public static final int TYPE_LAVA = 4;
    public static final int TYPE_ACID = 5;
    public static final int TYPE_VOID = 6;

    public AnimatedSprite[] background;
    public AnimatedSprite[] foreground;
}
