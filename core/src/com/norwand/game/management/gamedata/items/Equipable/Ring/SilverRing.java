package com.norwand.game.management.gamedata.items.Equipable.Ring;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class SilverRing extends Ring {

    public SilverRing() {
        this.displayName = "Anneau en argent";
        this.itemDescription = "Un anneau en argent pur";
        this.damage = 0;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(482);
    }
}
