package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by V-SSK on 22/05/2016.
 */
public class HeavenlySword extends Sword {
    public HeavenlySword(){
        this.displayName = "Epée céleste";
        this.itemDescription = "Epée très puissante";
        this.damage = 8;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(681);
    }
}
