package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class CopperSword extends Sword {

    public CopperSword(){
        this.displayName = "Epee en cuivre";
        this.itemDescription = "Une epee en cuivre pour débutant";
        this.damage = 1;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(618);
    }
}
