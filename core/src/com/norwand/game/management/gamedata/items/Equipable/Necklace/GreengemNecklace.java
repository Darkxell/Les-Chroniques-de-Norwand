package com.norwand.game.management.gamedata.items.Equipable.Necklace;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class GreengemNecklace extends Necklace {

    public GreengemNecklace() {
        this.displayName = "Collier gemme verte";
        this.itemDescription = "Un collier avec une gemme verte";
        this.armor = 0;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {

        return ImagesHolder.itemset.getTile(5);
    }
}
