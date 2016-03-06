package com.norwand.game.management.gamedata.player;

/** Camera that follows the player. */
public class PlayerCamera {

    public PlayerCamera(Player target) {
	this.target = target;
    }

    public Player target;

    public double x;
    public double y;

    public void update() {
	x = target.x;
	y = target.y;
    }
}
