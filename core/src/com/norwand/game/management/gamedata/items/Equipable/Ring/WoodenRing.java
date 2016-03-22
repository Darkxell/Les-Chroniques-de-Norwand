package com.norwand.game.management.gamedata.items.Equipable.Ring;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class WoodenRing extends Ring {

    public WoodenRing() {
        this.displayName = "Anneau en bois";
        this.itemDescription = "Un anneau fait de bois";
        this.damage = 0;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.tileset.getTile(456);
    }
}
