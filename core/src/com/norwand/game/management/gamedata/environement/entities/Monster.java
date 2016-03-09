package com.norwand.game.management.gamedata.environement.entities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.Position;

public abstract class Monster extends Entity {

    public Monster(Floor roompointer, double x, double y) {
	super(roompointer, x, y);
    }

    @Override
    public abstract void update();

    @Override
    public abstract Pixmap getCurrentSprite();

    @Override
    public abstract DoubleRectangle getHitbox(double posX, double posY);

    @Override
    public abstract void onhit(double damage);

    /**
     * knockback the player from this monster if it collides with the player
     * hitbox.
     */
    public void knockback() {
	// TODO : this, needs player states
	Player p = GameData.get().player;
	DoubleRectangle hitbox = getHitbox(super.posX, super.posY);
	DoubleRectangle pr = p.hitbox.getRectangle(new Position(p.x, p.y));
	if (pr.intersects(hitbox) /* && !(p.state instanceof PS_Knockback) */) {
	    /*
	     * p.state = new PS_Knockback( new MathVector(PlayerInfo.posX -
	     * super.posX, PlayerInfo.posY - super.posY), 9); 
	     * PlayerInfo.health -= 0.25;
	     */
	}

    }

}
