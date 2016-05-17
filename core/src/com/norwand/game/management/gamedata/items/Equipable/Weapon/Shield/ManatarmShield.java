package com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class ManatarmShield extends Shield {

    public ManatarmShield(){
        this.displayName = "Boucier de soldat";
        this.itemDescription = "Un bouclier en metal leger porte par les soldats.";
        this.armor = 4;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(915);
    }
}
