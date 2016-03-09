package com.norwand.game.management.gamedata.environement.tileentities;

import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Entity;

public abstract class TileEntity extends Entity {

    public TileEntity(byte type, Floor roompointer, double x, double y) {
	super(roompointer, x, y);
    }

    protected byte type;

    /** Gets the physics of this tileentity. */
    public byte getPhysics() {
	return this.type;
    }
}
