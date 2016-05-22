package com.norwand.game.management.gamedata.items;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 22/05/2016.
 */
public class BossKey extends Item {

    public BossKey() {
        this.displayName = "Clé de boss";
        this.itemDescription = "Clé de boss";
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(395);
    }

    @Override
    public void onUse() {

    }
}
