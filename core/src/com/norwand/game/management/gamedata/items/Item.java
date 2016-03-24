package com.norwand.game.management.gamedata.items;

import com.badlogic.gdx.graphics.Pixmap;

/** Items in the game */
public abstract class Item {

    /** The name of the object */
    protected String displayName;
    /** The description of the object */
    protected String itemDescription;

    public String getDisplayName() {
	return this.displayName;
    }

    /** Gets the sprite of this item (16x16 Pixmap usually from the itemset) */
    public abstract Pixmap getSprite();

    /**
     * Returns a string description of this item, intended to display in the
     * inventory.
     */
    public String getItemDescription() {
	return this.itemDescription;
    }

    @Override
    public String toString() {
	return "Item : " + getItemDescription();
    }

    /**
     * Uses this item. If it is a consumable for exemple, do an effect and
     * remove it from its slot.
     */
    public abstract void onUse();
}
