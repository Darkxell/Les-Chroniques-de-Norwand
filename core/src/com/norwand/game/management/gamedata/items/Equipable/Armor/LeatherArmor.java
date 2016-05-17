package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class LeatherArmor extends Armor {

    public LeatherArmor() {
        this.displayName = "Armure de cuir";
        this.itemDescription = "Une armure faite de cuir.";
        this.damage = 0;
        this.armor = 2;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(25);
    }
}
