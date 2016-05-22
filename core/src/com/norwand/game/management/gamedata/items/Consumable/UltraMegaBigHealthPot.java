package com.norwand.game.management.gamedata.items.Consumable;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.resources.ImagesHolder;

/**
 * Created by Valentin Marechal on 27/04/2016.
 */
public class UltraMegaBigHealthPot extends Consumable {
    public UltraMegaBigHealthPot() {
        this.displayName = "Ultra Mega Grosse potion de vie";
        this.itemDescription = "Bla bla... très grosse potion de vie blablabla....";
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(651);
    }

    @Override
    public void onUse() {
        GameData.get().player.info.health += 5;
        if (GameData.get().player.info.health > GameData.get().player.info.maxhealth)
            GameData.get().player.info.health = GameData.get().player.info.maxhealth;

        GameData.get().player.inventory.removeItem(this);
    }
}
