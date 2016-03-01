package com.norwand.game.utility.objects;

/** Represents a hitbox. Thge hitbox is not relative to a position. */
public class Hitbox {

    private DoubleRectangle box;

    /** Creates a hitbox using a doubleRectangle. */
    public Hitbox(DoubleRectangle rect) {
	box = rect;
    }

    /** Creates a squared hitbox using half its size. */
    public Hitbox(double halfsize) {
	box = new DoubleRectangle(0, 0, halfsize * 2, halfsize * 2);
    }

    /** Creates a new Hitbox of the wanted size. */
    public Hitbox(double width, double height) {
	box = new DoubleRectangle(0, 0, width, height);
    }

    /**
     * Returns a DoubleRectangle centered around the center point of the size of
     * this hitbox.
     */
    public DoubleRectangle getRectangle(Position center) {
	return new DoubleRectangle(center.x - (box.width / 2), center.y
		- (box.height / 2), box.width, box.height);
    }
}
