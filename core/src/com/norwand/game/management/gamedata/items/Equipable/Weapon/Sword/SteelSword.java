package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class SteelSword extends Sword {

    public SteelSword(){
        this.displayName = "Epee en acier";
        this.itemDescription = "Une epee forgee de acier";
        this.damage = 3;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(619);
    }
}
