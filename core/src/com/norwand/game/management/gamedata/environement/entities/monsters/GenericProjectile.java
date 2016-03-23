package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

public class GenericProjectile extends Monster {

    public GenericProjectile(Floor roompointer, double x, double y) {
	super(roompointer, x, y);
	this.actable = true;
    }

    private int spritecounter = 25;

    @Override
    public void update() {
	--spritecounter;
	if (spritecounter < 0)
	    spritecounter = 50;
	double x = GameData.get().player.x;
    }

    @Override
    public Pixmap getCurrentSprite() {
	return ImagesHolder.entityset.getTile((spritecounter < 25) ? 737 : 745);
    }

    @Override
    public void onAct() {

    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void onhit(double damage) {
	// TODO Auto-generated method stub

    }

}
