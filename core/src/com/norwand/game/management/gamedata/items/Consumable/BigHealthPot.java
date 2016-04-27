package com.norwand.game.management.gamedata.items.Consumable;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 27/04/2016.
 */
public class BigHealthPot extends Item {
    public BigHealthPot() {
        this.displayName = "Grosse potion de vie";
        this.itemDescription = "Grosse potion de vie, permet de récupérer plus de vie.";
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(633);
    }

    @Override
    public void onUse() {
        GameData.get().player.info.health += 5;
        if (GameData.get().player.info.health > GameData.get().player.info.maxhealth)
            GameData.get().player.info.health = GameData.get().player.info.maxhealth;

        GameData.get().player.inventory.removeItem(this);
    }
}
