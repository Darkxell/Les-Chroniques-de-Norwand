package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by ASUS on 17/05/2016.
 */
public class ScaleArmor extends Armor {

    public ScaleArmor() {
        this.displayName = "Armure d'ecaille";
        this.itemDescription = "Une solide armure d'ecailles.";
        this.damage = 0;
        this.armor = 2;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(27);
    }
}
