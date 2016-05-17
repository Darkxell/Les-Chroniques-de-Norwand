package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class Needle extends Sword {

    public Needle(){
        this.displayName = "Aiguille à coudre";
        this.itemDescription = "Vos poings seraient plus efficaces";
        this.damage = 0.10;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(763);
    }
}
