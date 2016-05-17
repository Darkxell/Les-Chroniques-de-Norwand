package com.norwand.game.management.gamedata.items.Equipable.Boots;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class HardenedBoots extends Boots {

    public HardenedBoots() {
        this.displayName = "Bottes solides";
        this.itemDescription = "Des bottes en cuir renforcées.";
        this.armor = 4;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(224);
    }
}
