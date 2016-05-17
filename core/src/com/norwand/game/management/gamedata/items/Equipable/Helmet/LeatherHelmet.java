package com.norwand.game.management.gamedata.items.Equipable.Helmet;


import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class LeatherHelmet extends Helmet{

    public LeatherHelmet() {
        this.displayName = "Casque en cuir";
        this.itemDescription = "Un casque de cuir pour aventurier";
        this.armor = 1;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(368);
    }
}
