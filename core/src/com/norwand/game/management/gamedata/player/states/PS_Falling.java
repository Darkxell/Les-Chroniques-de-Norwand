package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.GameData;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.Position;

/**
 * Created by Valentin Marechal on 18/05/2016.
 */
public class PS_Falling extends PlayerState{

    public PS_Falling(Player player) {
        super(player);
    }

    private int counter;

    @Override
    public void update() {
        ++counter;
        if(counter > 39){
            player.state = new PS_Iddle(player);
            Position respawn = GameData.get().currentfloor.getClosestRespawnPoint(new Position(player.x,player.y));
            player.x = respawn.x;
            player.y = respawn.y;
            player.info.health -= 0.25;
        }
    }

    @Override
    public Pixmap getSprite() {

            return  ImagesHolder.playerset.getTile(104+(counter/10));
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
