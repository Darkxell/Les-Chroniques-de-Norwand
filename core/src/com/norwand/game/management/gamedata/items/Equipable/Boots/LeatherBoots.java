package com.norwand.game.management.gamedata.items.Equipable.Boots;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class LeatherBoots extends Boots {

    public LeatherBoots() {
        this.displayName = "Bottes de cuir";
        this.itemDescription = "Des bottes en cuir.";
        this.armor = 1;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.tileset.getTile(216);
    }
}
