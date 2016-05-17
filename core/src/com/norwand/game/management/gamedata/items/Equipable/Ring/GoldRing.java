package com.norwand.game.management.gamedata.items.Equipable.Ring;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class GoldRing extends Ring {

    public GoldRing() {
        this.displayName = "Anneau en or";
        this.itemDescription = "Un anneau en or";
        this.damage = 0;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(481);
    }
}
