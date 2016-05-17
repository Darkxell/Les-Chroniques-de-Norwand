package com.norwand.game.management.gamedata.items.Equipable.Ring;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class CopperRing extends Ring {

    public CopperRing() {
        this.displayName = "Anneau en cuivre";
        this.itemDescription = "Un anneau en cuivre";
        this.damage = 0;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(468);
    }
}
