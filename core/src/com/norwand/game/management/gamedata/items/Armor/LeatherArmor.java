package com.norwand.game.management.gamedata.items.Armor;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class LeatherArmor extends Armor {

    public LeatherArmor() {
        this.displayName = "Armure de cuir";
        this.itemDescription = "Une armure faite de cuir.";
        this.damage = 0;
        this.armor = 1;

    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.tileset.getTile(25);
    }

    @Override
    public void onUse() {
        //TOFO
    }
}
