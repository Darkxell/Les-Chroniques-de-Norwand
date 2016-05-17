package com.norwand.game.management.gamedata.items.Equipable.Helmet;


import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class SteelHelm extends Helmet{

    public SteelHelm() {
        this.displayName = "Casque en cuir";
        this.itemDescription = "Un casque de cuir pour aventurier";
        this.armor = 5;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(364);
    }
}
