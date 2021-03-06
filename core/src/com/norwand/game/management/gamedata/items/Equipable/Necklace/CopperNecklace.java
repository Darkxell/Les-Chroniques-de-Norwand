package com.norwand.game.management.gamedata.items.Equipable.Necklace;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class CopperNecklace extends Necklace {

    public CopperNecklace() {
        this.displayName = "Collier de cuivre";
        this.itemDescription = "Un collier fait en cuivre";
        this.armor = 0;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {

        return ImagesHolder.itemset.getTile(2);
    }
}
