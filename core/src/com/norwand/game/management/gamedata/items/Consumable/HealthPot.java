package com.norwand.game.management.gamedata.items.Consumable;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.resources.ImagesHolder;

/** Health potion that regenerates HP */
public class HealthPot extends Item {

    public HealthPot() {
	this.displayName = "Potion de vie";
	this.itemDescription = "Potion de vie, permet de récuperer ... de la vie.";
    }

    @Override
    public Pixmap getSprite() {
	return ImagesHolder.itemset.getTile(632);
    }

    @Override
    public void onUse() {
	GameData.get().player.info.health += 3;
	if (GameData.get().player.info.health > GameData.get().player.info.maxhealth)
	    GameData.get().player.info.health = GameData.get().player.info.maxhealth;

    GameData.get().player.inventory.removeItem(this);
    }
}
