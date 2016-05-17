package com.norwand.game.management.gamedata.items.Equipable.Necklace;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class GoldenNecklace extends Necklace {

    public GoldenNecklace() {
        this.displayName = "Collier precieux";
        this.itemDescription = "Un collier en or orné d'une énorme perle";
        this.armor = 1;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {

        return ImagesHolder.itemset.getTile(8);
    }
}
