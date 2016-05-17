package com.norwand.game.management.gamedata.items.Equipable.Boots;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class ScaleBoots extends Boots {

    public ScaleBoots() {
        this.displayName = "Bottes en ecailles";
        this.itemDescription = "Des bottes en peau de reptiles.";
        this.armor = 2;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(218);
    }
}
