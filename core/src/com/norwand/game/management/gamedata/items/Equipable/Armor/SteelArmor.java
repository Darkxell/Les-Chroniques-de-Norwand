package com.norwand.game.management.gamedata.items.Equipable.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class SteelArmor extends Armor {

    public SteelArmor() {
        this.displayName = "Armure d'acier";
        this.itemDescription = "Une armure forgée en acier robuste.";
        this.damage = 0;
        this.armor = 7;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(30);
    }
}
