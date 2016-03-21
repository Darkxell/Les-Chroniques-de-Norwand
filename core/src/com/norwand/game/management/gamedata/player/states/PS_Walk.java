package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.environement.tiles.Tile;
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
    private short countdown = 5;
    private byte count = 3;

    @Override
    public void update() {
	if (GameData.get().currentfloor.getPhysicsAt(player.x, player.y) == Tile.TYPE_WATER)
	    player.state = new PS_Drown(player);
	--countdown;
	if (countdown < 0) {
	    countdown = 10;// Frames per sprite
	    --count;
	    if (count < 0)
		count = 3;
	}
	player.facing = direction.getOverallDirection();

	// movespeed is 0.15 here.
	Position newpos = direction.getFixedTranslation(player.x, player.y,
		0.15);
	if (player.canBeAt(newpos.x, player.y))
	    player.x = newpos.x;
	if (player.canBeAt(player.x, newpos.y))
	    player.y = newpos.y;
    }

    @Override
    public Pixmap getSprite() {
	switch (player.facing) {
	case Directions.SOUTH:
	    return ImagesHolder.playerset.getTile(0 + count);
	case Directions.NORTH:
	    return ImagesHolder.playerset.getTile(96 + count);
	case Directions.EAST:
	    return ImagesHolder.playerset.getTile(64 + count);
	case Directions.WEST:
	    return ImagesHolder.playerset.getTile(32 + count);
	default:
	    return null;
	}
    }

    @Override
    public void onTap(Position pos) {
	player.state = new PS_Dash(player, pos);
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
	player.state = capacity.getPlayerState(player, pos);
    }

}
