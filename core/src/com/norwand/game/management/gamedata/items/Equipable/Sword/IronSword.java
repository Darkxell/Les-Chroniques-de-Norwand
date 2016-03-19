package com.norwand.game.management.gamedata.items.Equipable.Sword;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class IronSword extends Sword{

    public IronSword(){
        this.displayName = "Ep�e en fer";
        this.itemDescription = "Une �p�e forg�e de fer";
        this.damage = 1;
        this.armor = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.tileset.getTile(616);
    }

    @Override
    public void onUse() {
        //TODO
    }
}
