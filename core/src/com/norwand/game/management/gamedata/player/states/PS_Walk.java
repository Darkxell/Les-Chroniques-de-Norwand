package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Directions;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

/**
 * Walking state of the player. In this state, the player walks. (Why are you
 * even reading this documentation?)
 */
public class PS_Walk extends PlayerState {

    public PS_Walk(Player player, MathVector direction) {
	super(player);
	this.direction = direction;
    }

    private MathVector direction;

    @Override
    public void update() {
	// movespeed is 0.17 here.
	Position newpos = direction
		.getFixedTranslation(player.x, player.y, 0.17);
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
	direction = new MathVector(pos.x - player.x, pos.y - player.y);
    }

    @Override
    public void onStop() {
	player.state = new PS_Iddle(player);
    }

    @Override
    public void onSkillUsed(Position pos, Capacity capacity) {

    }

}
