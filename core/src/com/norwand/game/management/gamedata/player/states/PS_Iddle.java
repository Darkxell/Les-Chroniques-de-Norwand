package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.Directions;
import com.norwand.game.utility.objects.MathVector;
import com.norwand.game.utility.objects.Position;

public class PS_Iddle extends PlayerState {

    public PS_Iddle(Player player) {
	super(player);
    }

    @Override
    public void update() {
	// Does nothing I guess?
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
	// TODO : dash here
    }

    @Override
    public void onMoveTo(Position pos) {
	player.state = new PS_Walk(player, new MathVector(pos.x - player.x,
		pos.y - player.y));
    }

    @Override
    public void onStop() {
	// Does nothing either I guess. Should never be called anyways.
    }

    @Override
    public void onSkillUsed(Position pos, Capacity capacity) {
	// TODO : use skill here. Welp, need some skills to use too.
    }

}