package com.norwand.game.management.gamedata.items;


import com.badlogic.gdx.graphics.Pixmap;

/**Items in the game*/
public abstract class Item {

    /** The name of the object */
    protected String displayName;
    /** The description of the object */
    protected String itemDescription;

    public String getDisplayName(){
        return this.displayName;
    }

    public abstract Pixmap getSprite();

    public String getItemDescription(){
        return this.itemDescription;
    }

    /** Describe what the item must do when it is used */
    public abstract void onUse();
}
