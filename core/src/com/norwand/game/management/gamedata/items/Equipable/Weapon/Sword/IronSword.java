package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class IronSword extends Sword {

    public IronSword(){
        this.displayName = "Epée en fer";
        this.itemDescription = "Une épée forgée de fer";
        this.damage = 4;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(619);
    }
}
