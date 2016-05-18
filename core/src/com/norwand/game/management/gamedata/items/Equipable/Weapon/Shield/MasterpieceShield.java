package com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.resources.ImagesHolder;

public class MasterpieceShield extends Shield {

    public MasterpieceShield(){
        this.displayName = "Boucier de maitre";
        this.itemDescription = "Un bouclier fait par un artisan d'exception.";
        this.armor = 8;
        this.damage = 0;
    }

    @Override
    public Pixmap getSprite() {
        return ImagesHolder.itemset.getTile(918);
    }
}
