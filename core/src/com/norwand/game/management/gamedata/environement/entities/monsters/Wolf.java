package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.DoubleRectangle;

public class Wolf extends Monster {

    public Wolf(Floor roompointer, double x, double y) {
	super(roompointer, x, y);
    }

	/**Timer until the next jump of the wolf. 
	Can be negative, it means that the wolf is jumping.*/
	private int nextjumpin = 200;
    private int spritecounter = 10;
	private MathVector jumpdirection;
	
    @Override
    public void update() {
		--nextjumpin;
	if(nextjumpin == 0){
		jumpdirection = new MathVector(GameData.get().player.x - posX, GameData.get().player.y - posY);
	}else if(nextjumpin < -20){
		nextjumpin = 200;
	}
	if (nextjumpin < 0){
		Position temp = jumpdirection.getFixedTranslation(posX, posY, 0.1);
		if (canBeAt(temp.x, temp.y)) {
	    posX = temp.x;
	    posY = temp.y;
		}
	}
	--spritecounter;
	if (spritecounter < 0)
	    spritecounter = 50;
	if(knockback())
	    GameData.get().player.info.health -= 0.5;
    }

    @Override
    public Pixmap getCurrentSprite() {
	if(nextjumpin < 0)
		return ImagesHolder.entityset.getTile(633);
	return ImagesHolder.entityset.getTile((spritecounter < 35) ? 625 : 633);
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
	return new DoubleRectangle(posX - 0.35, posY - 0.35, 0.7, 0.7);
    }

    @Override
    public void onhit(double damage) {
	kill();
    }

    @Override
    public void onAct() {
    }// Does nothing

}
