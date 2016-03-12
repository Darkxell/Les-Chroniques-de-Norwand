package com.norwand.game.management.gamedata.player.capacities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.Position;

/** A teleport capacity. Allows you to teleport where you want. */
public class Cap_Teleport extends Capacity {

    @Override
    public Pixmap getCapIcon() {
	return ImagesHolder.capacityset.getTile(0);
    }

    @Override
    public PlayerState getPlayerState(Player pointer, Position cappos) {
	return null;
    }

}
