package com.norwand.game.management.gamedata.environement.tileentities;

import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Entity;

/**
 * Tileentities are like entities in behavior, but has a defined physic.<br>
 * This means that if you call the <code>getPhysicsAt(Position p)</code> method
 * of the floor object containing this tileentity and the wanted position is
 * inside this tileentity hitbox, then this physic will be returned.
 * */
public abstract class TileEntity extends Entity {

    public TileEntity(byte type, Floor roompointer, double x, double y) {
	super(roompointer, x, y);
	this.type = type;
    }

    /** The physics of this tileentity. */
    protected byte type;

    /** Gets the physics of this tileentity. */
    public byte getPhysics() {
	return this.type;
    }
}
