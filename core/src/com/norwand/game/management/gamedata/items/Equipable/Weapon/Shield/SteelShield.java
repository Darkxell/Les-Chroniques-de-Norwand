package com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class SteelShield extends Shield {

    public SteelShield(){
        this.displayName = "Boucier en acier";
        this.itemDescription = "Un solide bouclier d'acier.";
        this.armor = 6;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(916);
    }
}
