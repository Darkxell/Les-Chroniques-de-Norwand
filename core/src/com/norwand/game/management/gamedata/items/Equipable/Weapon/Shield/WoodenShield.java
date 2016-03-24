package com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class WoodenShield extends Shield {

    public WoodenShield(){
        this.displayName = "Boucier de bois";
        this.itemDescription = "Un bouclier en bois.";
        this.armor = 2;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(912);
    }
}
