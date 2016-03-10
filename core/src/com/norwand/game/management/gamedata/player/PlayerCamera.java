package com.norwand.game.management.gamedata.player;

import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/** Camera that follows the player. */
public class PlayerCamera {

    public PlayerCamera(Player target) {
	this.target = target;
    }

    public Player target;

    public double x;
    public double y;

    /**
     * Updates this camera "entity". Makes its pathfinding ai get it closer to
     * the player.
     */
    public void update() {
	MathVector dir = new MathVector(target.x - x, target.y - y);
	Position p = dir.getFixedTranslation(x, y, dir.getBasicLength() / 10);
	x = p.x;
	y = p.y;
    }
}
