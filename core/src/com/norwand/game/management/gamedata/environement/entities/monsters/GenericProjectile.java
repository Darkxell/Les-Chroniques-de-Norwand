package com.norwand.game.management.gamedata.environement.entities.monsters;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.entities.Monster;
import com.norwand.game.utility.objects.AnimatedSprite;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.Hitbox;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * This class denotes a generic projectile. This can be extended to create easy
 * to use custom projectiles or created directly. <br>
 * By default, the projectile AI is: follow a single line until it reaches an
 * unreachable position. It then kills itself.
 */
public class GenericProjectile extends Monster {

    /** Creates a generic projectile. */
    public GenericProjectile(Floor roompointer, double x, double y,
	    double speed, Hitbox h, AnimatedSprite sprite, MathVector direction) {
	super(roompointer, x, y);
	this.hitbox = h;
	this.sprite = sprite;
	this.speed = speed;
    }

    private Hitbox hitbox;
    private AnimatedSprite sprite;
    private MathVector direction;
    private double speed;

    @Override
    public void update() {
	sprite.update();
	Position temp = direction.getFixedTranslation(posX, posY, speed);
	if (canBeAt(temp.x, temp.y)) {
	    posX = temp.x;
	    posY = temp.y;
	} else
	    kill();

    }

    @Override
    public Pixmap getCurrentSprite() {
	return sprite.getCurrentFrame();
    }

    @Override
    public void onAct() {
	// Not actable by default
    }

    @Override
    public DoubleRectangle getHitbox(double posX, double posY) {
	return hitbox.getRectangle(new Position(posX, posY));
    }

    @Override
    public void onhit(double damage) {
    }

}
