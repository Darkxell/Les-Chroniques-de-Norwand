package com.norwand.game.utility.objects;

import com.norwand.game.utility.Directions;

/**
 * Reprensents a mathematical 2D vector.
 */
public class MathVector {

    public double x;
    public double y;

    /**
     * Builds a mathematical vector.
     */
    public MathVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns the translation of the point by this vector.
     */
    public Position getTranslation(double x, double y) {
        return new Position(x + this.x, y + this.y);
    }

    /**
     * returns the translation of the point by this vector.
     */
    public Position getTranslation(Position pos) {
        return new Position(pos.x + this.x, pos.y + this.y);
    }

    /**
     * Gets the translation of the point by this vector, but with a set norma.
     * This method basically just uses the vector direction.
     */
    public Position getFixedTranslation(double x, double y, double length) {
        double z = Math.sqrt((this.x * this.x) + (this.y * this.y));
        double y2 = this.y * length / z;
        double x2 = this.x * length / z;
        return new Position(x + x2, y + y2);
    }

    /**
     * Returns the basic length of this vector.
     */
    public double getBasicLength() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Gets the overall direction of this vector.
     */
    public byte getOverallDirection() {
        if (Math.abs(x) < Math.abs(y))
            return (y > 0) ? Directions.SOUTH : Directions.NORTH;
        else
            return (x > 0) ? Directions.EAST : Directions.WEST;
    }

    /**
     * Dunno if it's works but it would propably
     * @return
     */
    public byte getAffinedOverallDirection() {

        double angle;
        if(x >= 0)
            angle = 2 * Math.atan(y/(x + Math.sqrt(x*x + y*y)));
        else
            angle = - Math.PI;


        if(angle > - Math.PI / 8 && angle < Math.PI / 8)
            return Directions.EAST;

        else if(angle > Math.PI / 8 && angle < 3*Math.PI / 8)
            return Directions.NORTH_EAST;

        else if(angle > 3*Math.PI / 8 && angle < 5*Math.PI / 8)
            return Directions.NORTH;

        else if (angle < 5*Math.PI / 8 && angle < 7*Math.PI / 8)
            return Directions.NORTH_WEST;

        else if(angle > 7*Math.PI / 8 && x < 0)
            return Directions.WEST;

        else if(angle < - Math.PI / 8 && angle > -3*Math.PI / 8)
            return Directions.SOUTH_EAST;

        else if (angle < -3*Math.PI / 8 && angle > -5*Math.PI / 8)
            return Directions.SOUTH;

        else
            return Directions.SOUTH_WEST;
    }

}
