package com.norwand.game.management.gamedata.items.Equipable.Ring;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class PlatinumRing extends Ring {

    public PlatinumRing() {
        this.displayName = "Anneau en platine";
        this.itemDescription = "Un anneau en platine";
        this.damage = 0;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(486);
    }
}
