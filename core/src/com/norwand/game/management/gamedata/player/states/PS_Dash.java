package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Directions;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

public class PS_Dash extends PlayerState {
    /** Construcs a new dashing state using a position. */
    public PS_Dash(Player player, Position p) {
	super(player);
	double dist = p.getDistanceFrom(new Position(player.x, player.y));
	this.framelength = (int) (dist / DASHSPEED);
	this.direction = new MathVector(p.x - player.x, p.y - player.y);
    }

    /** The speed of the dash. */
    private static final double DASHSPEED = 1.1;
    /** The length of this state in frames. */
    private int framelength;
    /** The direction of this dashing state. */
    private MathVector direction;

    @Override
    public void update() {
	--framelength;
	if (framelength < 0)
	    player.state = new PS_Iddle(player);
	Position newpos = direction.getFixedTranslation(player.x, player.y,
		DASHSPEED);
	if (player.canBeAt(newpos.x, player.y))
	    player.x = newpos.x;
	if (player.canBeAt(player.x, newpos.y))
	    player.y = newpos.y;
    }

    @Override
    public Pixmap getSprite() {
	switch (player.facing) {
	case Directions.SOUTH:
	    return ImagesHolder.playerset.getTile(0);
	case Directions.NORTH:
	    return ImagesHolder.playerset.getTile(96);
	case Directions.EAST:
	    return ImagesHolder.playerset.getTile(64);
	case Directions.WEST:
	    return ImagesHolder.playerset.getTile(32);
	default:
	    return null;
	}
    }

    @Override
    public void onTap(Position pos) {
    }

    @Override
    public void onMoveTo(Position pos) {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onSkillUsed(Position pos, Capacity capacity) {
    }

}
