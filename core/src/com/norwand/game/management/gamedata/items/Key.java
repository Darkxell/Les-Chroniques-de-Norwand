package com.norwand.game.management.gamedata.items;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class Key extends Item{

    public Key() {
        this.displayName = "Clé";
        this.itemDescription = "Petite clé";
        this.itemDescription = "Petite clé";
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(392);
    }

    @Override
    public void onUse() {

    }
}
