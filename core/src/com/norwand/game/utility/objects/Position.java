package com.norwand.game.utility.objects;

/** Represents a floatpoint position in a 2 dimentionnal space. */
public class Position {

    /** The x coordinate of this position. */
    public double x;
    /** The y coordinate of this position. */
    public double y;

    public Position(double x, double y) {
	this.x = x;
	this.y = y;
    }

    /** adds the position p to this position. */
    public void add(Position p) {
	this.x += p.x;
	this.y += p.y;
    }

    /** Gets the distance between this point and the point p. */
    public double getDistanceFrom(Position p) {
	return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
}
