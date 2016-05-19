package com.norwand.game.management.gamedata.player.capacities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.management.gamedata.player.states.PS_WaterFreeze;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.Position;

/**
 * Created by Valentin Marechal on 19/05/2016.
 */
public class Cap_FrostWalker extends Capacity {

    @Override
    public Pixmap getCapIcon() {
        return ImagesHolder.capacityset.getTile(5);
    }

    @Override
    public PlayerState getPlayerState(Player pointer, Position cappos) {
        return new PS_WaterFreeze(pointer, cappos);
    }
}
