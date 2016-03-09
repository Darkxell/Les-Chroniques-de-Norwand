package com.norwand.game.management.gamedata.environement.entities;

import java.awt.Graphics2D;

import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.utility.Directions;
import com.norwand.game.utility.objects.DoubleRectangle;

public abstract class Entity {

    /** Pointer to the room containing the entity. */
    public Floor roompointer;
    /** The X position of the entity in its room. */
    public double posX;
    /** The Y position of the entity in its room. */
    public double posY;

    /** The health of the entity. */
    public double hp = 1;

    /**
     * The direction faced by the entity. This may not be relevent depending on
     * the entity, like an item drop may not face something else than down. This
     * is mainly for display purposes but not only.
     */
    public int facing = Directions.SOUTH;

    /** The state of this entity. */
    public EntityState state;

    public Entity(Floor roompointer, double x, double y) {
	this.roompointer = roompointer;
	this.posX = x;
	this.posY = y;
    }

    /** updates the entity. */
    public abstract void update();

    /** prints the entity on the graphics object. */
    public abstract void print(Graphics2D g2d);

    /** Returns the hitbox of this entity. */
    public abstract DoubleRectangle getHitbox(double posX, double posY);

    /** Called when the entity is hit by the player. */
    public abstract void onhit(double damage);

    /** Deletes this entity from its parent room. */
    public void kill() {
	this.roompointer.deleteEntity(this);
    }
}
