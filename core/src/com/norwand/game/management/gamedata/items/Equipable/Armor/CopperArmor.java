package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by ASUS on 17/05/2016.
 */
public class CopperArmor extends Armor {

    public CopperArmor() {
        this.displayName = "Armure de cuivre";
        this.itemDescription = "Une armure en cuivre de base.";
        this.damage = 0;
        this.armor = 3;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(24);
    }
}
