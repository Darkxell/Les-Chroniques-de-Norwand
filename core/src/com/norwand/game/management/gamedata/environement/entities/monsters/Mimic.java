package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

public class Mimic extends Monster {

    public Mimic(Floor roompointer, double x, double y) {
	super(roompointer, x, y);
    }

    private int spritecounter = 25;

    @Override
    public void update() {
	--spritecounter;
	if (spritecounter < 0)
	    spritecounter = 50;
    }

    @Override
    public Pixmap getCurrentSprite() {
	return ImagesHolder.entityset.getTile((spritecounter < 25) ? 832 : 840);
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
	return null;
    }

    @Override
    public void onhit(double damage) {
	kill();
    }

}