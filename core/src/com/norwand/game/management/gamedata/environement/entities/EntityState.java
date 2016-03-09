package com.norwand.game.management.gamedata.environement.entities;

import java.awt.Graphics2D;

public abstract class EntityState {
    /** The entity the state belongs to. */
    protected Entity parententity;

    public EntityState(Entity parent) {
	this.parententity = parent;
    }

    /** Prints the state. */
    public abstract void print(Graphics2D g2d);

    /** Updates the state. */
    public abstract void update();
}
