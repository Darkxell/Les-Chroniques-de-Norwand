package com.norwand.game.management.gamedata.items;


public abstract class Equipable extends Item{

    /** The amout of armor that the object will give to the player */
    protected double armor;
    /** The amout of damage that the object deals */
    protected double damage;

    /** return the armor of the object */
    public double getArmor() {
        return this.armor;
    }

    /** return the damages that the object deals */
    public double getDamage() {
        return this.damage;
    }
}
