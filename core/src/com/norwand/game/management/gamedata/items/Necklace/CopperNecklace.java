package com.norwand.game.management.gamedata.items.Necklace;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class CopperNecklace extends Necklace {

    public CopperNecklace() {
        this.displayName = "Collier de cuivre";
        this.itemDescription = "Un collier fait de cuivre";
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.tileset.getTile(0);
    }

    @Override
    public void onUse() {

    }
}
