package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by ASUS on 17/05/2016.
 */
public class DarkArmor extends Armor {

    public DarkArmor() {
        this.displayName = "Armure sombre";
        this.itemDescription = "Une armure en alliage mystique.";
        this.damage = 0;
        this.armor = 8;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(32);
    }
}
