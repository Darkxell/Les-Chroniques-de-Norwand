package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.Position;

public class PS_Drown extends PlayerState {

    public PS_Drown(Player player) {
	super(player);
    }

    private int counter;

    @Override
    public void update() {
	++counter;
	if(counter > 100){
	    player.state = new PS_Iddle(player);
	    Position respawn = GameData.get().currentfloor.getClosestRespawnPoint(new Position(player.x,player.y));
	    player.x = respawn.x;
	    player.y = respawn.y;
	}
    }

    @Override
    public Pixmap getSprite() {
	if (counter < 5)
	    return ImagesHolder.playerset.getTile(72);
	else if (counter < 10)
	    return ImagesHolder.playerset.getTile(73);
	else
	    return (counter % 40 < 20) ? ImagesHolder.playerset.getTile(74)
		    : ImagesHolder.playerset.getTile(75);
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
