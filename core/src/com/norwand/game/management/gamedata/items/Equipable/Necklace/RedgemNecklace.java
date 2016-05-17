package com.norwand.game.management.gamedata.items.Equipable.Necklace;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class RedgemNecklace extends Necklace {

    public RedgemNecklace() {
        this.displayName = "Collier gemme rouge";
        this.itemDescription = "Un collier avec une gemme rouge";
        this.armor = 0;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {

        return ImagesHolder.itemset.getTile(3);
    }
}
