package com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class AlloySword extends Sword {

    public AlloySword(){
        this.displayName = "Epee en alliage";
        this.itemDescription = "Une epee en alliage mystique";
        this.damage = 8;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(617);
    }
}
