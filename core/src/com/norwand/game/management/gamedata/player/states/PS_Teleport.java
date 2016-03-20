package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.Position;

public class PS_Teleport extends PlayerState {

    public PS_Teleport(Player player, Position p) {
	super(player);
	tpto = p;
    }

    /** The position the player is gonna teleport to in the current floor. */
    private Position tpto;
    /** THe state iterator. */
    private byte counter = 15;

    @Override
    public void update() {
	if (counter == 15) {
	    if (player.canBeAt(tpto.x, tpto.y)) {
		player.x = tpto.x;
		player.y = tpto.y;
	    } else {
		Position p = GameData.get().currentfloor
			.getClosestRespawnPoint(tpto);
		player.x = p.x;
		player.y = p.y;
	    }
	}
	--counter;
	if (counter < 0)
	    player.state = new PS_Iddle(player);
    }

    @Override
    public Pixmap getSprite() {
	if (counter > 10)
	    return ImagesHolder.playerset.getTile(8);
	else if (counter > 6)
	    return ImagesHolder.playerset.getTile(9);
	else if (counter > 3)
	    return ImagesHolder.playerset.getTile(10);
	else
	    return ImagesHolder.playerset.getTile(11);
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
