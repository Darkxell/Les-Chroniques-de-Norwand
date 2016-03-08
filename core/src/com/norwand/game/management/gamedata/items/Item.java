package com.norwand.game.management.gamedata.items;


import com.badlogic.gdx.graphics.Pixmap;

/**Items in the game*/
public abstract class Item {

    private String displayName;

    public String getDisplayName(){
        return this.displayName;
    }

    public abstract Pixmap getSprite();

    public abstract void onUse();
}
