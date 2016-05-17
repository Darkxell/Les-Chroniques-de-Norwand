package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class ButterKnife extends Sword {

    public ButterKnife(){
        this.displayName = "Couteau à beurre";
        this.itemDescription = "Vos poings seraient plus efficaces";
        this.damage = 0.25;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(829);
    }
}
