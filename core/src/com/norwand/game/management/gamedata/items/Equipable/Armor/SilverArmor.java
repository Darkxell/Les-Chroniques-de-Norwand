package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by ASUS on 17/05/2016.
 */
public class SilverArmor extends Armor {

    public SilverArmor() {
        this.displayName = "Armure d'argent";
        this.itemDescription = "Une lourde armure en argent.";
        this.damage = 0;
        this.armor = 6;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(33);
    }
}
