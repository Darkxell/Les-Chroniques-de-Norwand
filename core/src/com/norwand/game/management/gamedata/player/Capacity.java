package com.norwand.game.management.gamedata.player;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.utility.objects.Position;

/** Object that represents a capacity, skill usable by the player. */
public abstract class Capacity {

    /** Gets the capacity icon sprite. */
    public abstract Pixmap getCapIcon();

    /** Gets the player state using the position where the capacity was called. */
    public abstract PlayerState getPlayerState(Player pointer, Position cappos);

}
