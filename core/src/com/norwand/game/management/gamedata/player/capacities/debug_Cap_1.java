package com.norwand.game.management.gamedata.player.capacities;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.management.gamedata.player.states.PS_Teleport;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.Position;

/**
 * Created by Valentin Marechal on 17/05/2016.
 */
public class debug_Cap_1 extends Capacity{
    @Override
    public Pixmap getCapIcon() {
        return ImagesHolder.capacityset.getTile(4);
    }

    @Override
    public PlayerState getPlayerState(Player pointer, Position cappos) {
        return new PS_Teleport(pointer, cappos);
    }
}
