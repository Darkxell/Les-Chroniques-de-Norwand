package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by ASUS on 17/05/2016.
 */
public class IronArmor extends Armor {

    public IronArmor() {
        this.displayName = "Armure de fer";
        this.itemDescription = "Une armure ordinaire en fer forgé.";
        this.damage = 0;
        this.armor = 5;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(29);
    }
}
