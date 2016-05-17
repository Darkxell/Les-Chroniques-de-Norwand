package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by ASUS on 17/05/2016.
 */
public class OrichalcumArmor extends Armor {

    public OrichalcumArmor() {
        this.displayName = "Armure d'orichalque";
        this.itemDescription = "Une rarissime armure en orichalque.";
        this.damage = 0;
        this.armor = 10;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(35);
    }
}
