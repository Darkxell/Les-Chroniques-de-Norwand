package com.norwand.game.management.gamedata.items;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.resources.ImagesHolder;


/**Health potion that regenerates HP*/
public class HealthPot extends Item{
    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(632);
    }

    @Override
    public void onUse() {
        GameData.get().player.info.health += 3;
    }
}
