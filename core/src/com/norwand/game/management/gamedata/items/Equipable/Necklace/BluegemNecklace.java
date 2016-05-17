package com.norwand.game.management.gamedata.items.Equipable.Necklace;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class BluegemNecklace extends Necklace {

    public BluegemNecklace() {
        this.displayName = "Collier gemme bleue";
        this.itemDescription = "Un collier avec une gemme bleue";
        this.armor = 0;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {

        return ImagesHolder.itemset.getTile(7);
    }
}
