package com.norwand.game.management.gamedata.items.Consumable;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 27/04/2016.
 */
public class MegaBigHealthPot extends Item {
    public MegaBigHealthPot() {
        this.displayName = "Mega Grosse potion de vie";
        this.itemDescription = "Encore plus grosse potion de vie, permet de récupérer encore plus de vie.";
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(635);
    }

    @Override
    public void onUse() {
        GameData.get().player.info.health += 9;
        if (GameData.get().player.info.health > GameData.get().player.info.maxhealth)
            GameData.get().player.info.health = GameData.get().player.info.maxhealth;

        GameData.get().player.inventory.removeItem(this);
    }
}
