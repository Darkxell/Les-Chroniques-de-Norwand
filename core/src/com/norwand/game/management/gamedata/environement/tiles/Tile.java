package com.norwand.game.management.gamedata.environement.tiles;

import com.norwand.game.utility.objects.AnimatedSprite;

public class Tile {

    public Tile(byte type, AnimatedSprite[] background,
                AnimatedSprite[] foreground) {
        this.background = background;
        this.foreground = foreground;
        this.type = type;
    }

    /**
     * The physics of the tile.
     */
    public byte type;
    public static final byte TYPE_NORMAL = 0;
    public static final byte TYPE_SOLID = 1;
    public static final byte TYPE_ICE = 2;
    public static final byte TYPE_WATER = 3;
    public static final byte TYPE_LAVA = 4;
    public static final byte TYPE_ACID = 5;
    public static final byte TYPE_VOID = 6;

    public AnimatedSprite[] background;
    public AnimatedSprite[] foreground;

    public void update() {

        if(background != null)
            for (int i = 0; i < background.length; i++)
                background[i].update();

        if(foreground != null)
            for (int i = 0; i < foreground.length; i++)
                foreground[i].update();

    }
}
