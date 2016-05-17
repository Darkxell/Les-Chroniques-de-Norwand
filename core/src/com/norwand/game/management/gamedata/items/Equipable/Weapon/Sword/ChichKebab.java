package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class ChichKebab extends Sword {

    public ChichKebab(){
        this.displayName = "La Broche du Kebabier";
        this.itemDescription = "La broche du chef Momo";
        this.damage = 6;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(676);
    }
}
