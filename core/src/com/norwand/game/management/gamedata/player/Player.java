package com.norwand.game.management.gamedata.player;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.Floor;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Directions;
import com.norwand.game.utility.objects.Hitbox;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/** Object that represents the playable player. */
public class Player {

    /** The camera following the player. */
    public PlayerCamera cam = new PlayerCamera(this);
    /** The direction faced by the player. */
    public int facing = Directions.SOUTH;
    /** The x position of the player in the current floor. */
    public double x = 1;
    /** The y position of the player in the current floor. */
    public double y = 3;
    /** Player specific information. */
    public PlayerInfo info;
    /**
     * The current state of the player. This represents what the player is
     * currently doing and allows to get the correct player sprite at any
     * moment.
     */
    public PlayerState state;
    /** The player inventory. */
    public Inventory inventory;
    /** The player hitbox */
    public Hitbox hitbox = new Hitbox(0.35);

    /** Updates the player. */
    public void update() {
	this.cam.update();
    }

    /**
     * Gets the sprite of the player at this moment. The returned pixmap MUST be
     * Undisposable, meaning it doesn't allow drawing, but you don' need (and
     * musn't) dispose of it.
     */
    public Pixmap getSprite() {
	return ImagesHolder.tileset.getTile(3381);
    }

    /** Called when the user taps the screen (mosly dash) */
    public void onTap(Position pos) {
	if (canBeAt(pos)) {
	    x = pos.x;
	    y = pos.y;
	}
    }

    /** Called when the user long presses or drags. */
    public void onMoveTo(Position pos) {
	double speed = 0.25;
	MathVector v = new MathVector(pos.x - x, pos.y - y);
	Position newpos = v.getFixedTranslation(x, y, speed);
	if (canBeAt(newpos.x, y))
	    x = newpos.x;
	if (canBeAt(x, newpos.y))
	    y = newpos.y;
    }

    /** Called when the player stop moving. */
    public void onStop() {

    }

    /** Called when the user uses a skill at the position pos. */
    public void onSkillUsed(Position pos, Capacity capacity) {

    }

    /**
     * Predicate that returns true if and only if the player can ba at the
     * potition p in the current floor.
     */
    public boolean canBeAt(Position p) {
	return canBeAt(p.x, p.y);
    }

    /**
     * Predicate that returns true if and only if the player can ba at the
     * potition x,y in the current floor.
     */
    public boolean canBeAt(double x, double y) {
	try {
	    Floor f = GameData.get().currentfloor;
	    Position[] cardinals = hitbox.getRectangle(new Position(x, y))
		    .getCardinals();
	    for (int i = 0; i < cardinals.length; i++)
		if (f.getTileAt((int) (cardinals[i].x), (int) (cardinals[i].y)).type == Tile.TYPE_SOLID)
		    return false;
	    return true;
	} catch (Exception e) {
	    return true;
	}
    }
}
