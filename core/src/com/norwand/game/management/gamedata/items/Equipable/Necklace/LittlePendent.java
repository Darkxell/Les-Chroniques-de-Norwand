package com.norwand.game.management.gamedata.items.Equipable.Necklace;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class LittlePendent extends Necklace {

    public LittlePendent() {
        this.displayName = "Petit pendentif";
        this.itemDescription = "Un petit pendentif";
        this.armor = 0;
        this.damage = 1;
    }

    @Override
    public Pixmap getSprite() {

        return ImagesHolder.itemset.getTile(0);
    }
}
