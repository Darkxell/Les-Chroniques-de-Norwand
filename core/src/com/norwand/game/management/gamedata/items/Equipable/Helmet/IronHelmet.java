package com.norwand.game.management.gamedata.items.Equipable.Helmet;


import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class IronHelmet extends Helmet{

    public IronHelmet() {
        this.displayName = "Casque de fer";
        this.itemDescription = "Un casque de fer";
        this.armor = 1;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.tileset.getTile(361);
    }

    @Override
    public void onUse() {

    }
}
