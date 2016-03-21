package com.norwand.game.management.gamedata.player;

import com.badlogic.gdx.Gdx;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.utility.objects.DoubleRectangle;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/** Camera that follows the player. */
public class PlayerCamera {

    public PlayerCamera(Player target) {
	this.target = target;
    }

    public Player target;
    /** The x position of the camera. */
    public double x;
    /** The y position of the camera. */
    public double y;

    /**
     * Updates this camera "entity". Makes its pathfinding ai get it closer to
     * the player.
     */
    public void update() {
	MathVector dir = new MathVector(target.x - x, target.y - y);
	Position p = dir.getFixedTranslation(x, y, dir.getBasicLength() / 9);
	DoubleRectangle zone = getFloorInnerRectangle();

	if (x < zone.x || x > zone.x + zone.width) {
	    if (x < zone.x || x > zone.x + zone.width)
		x += ((2 * zone.x + zone.width) / 2 - x) / 10;
	} else {
	    if (p.x > zone.x && p.x < zone.x + zone.width)
		x = p.x;
	}

	if (y < zone.y || y > zone.y + zone.height) {
	    if (y < zone.y || y > zone.y + zone.height)
		y += ((2 * zone.y + zone.height) / 2 - y) / 10;
	} else {
	    if (p.y > zone.y && p.y < zone.y + zone.height)
		y = p.y;
	}

    }

    /**
     * Returns a doubleRectangle representing where the camera entity can be in
     * the current frame to only pring the floor interior when printed. This
     * only works assuming the cammera x/y position is printed at the center of
     * the screen.
     * 
     * @return The double rectangle representing the possible positions, in the
     *         gameengine coordinates. The returned rectangle might have a
     *         negative Width/height if there is no way the camera can fit
     *         inside the room.
     */
    public DoubleRectangle getFloorInnerRectangle() {
	double pheight = 15 * Gdx.graphics.getHeight()
		/ Gdx.graphics.getWidth() + 1, pwidth = 15;
	// Not really sure why the +1 here, seems like it fixes a floatpoint
	// problem. Works fine this way.
	return new DoubleRectangle(pwidth / 2, pheight / 2,
		GameData.get().currentfloor.width - pwidth,
		GameData.get().currentfloor.height - pheight);
    }

}
