package com.norwand.game.management.gamedata.player.states;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.gamedata.player.Capacity;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerState;
import com.norwand.game.utility.objects.Position;

public class PS_Iddle extends PlayerState {

    public PS_Iddle(Player player) {
	super(player);
    }

    @Override
    public void update() {
    }

    @Override
    public Pixmap getSprite() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void onTap(Position pos) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onMoveTo(Position pos) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onStop() {
	// TODO Auto-generated method stub

    }

    @Override
    public void onSkillUsed(Position pos, Capacity capacity) {
	// TODO Auto-generated method stub

    }

}
