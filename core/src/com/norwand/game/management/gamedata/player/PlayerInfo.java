package com.norwand.game.management.gamedata.player;

import com.norwand.game.utility.objects.Hitbox;

/** Holds generic information about the player. */
public class PlayerInfo {

    public PlayerInfo() {

    }

    /** The player Hitbox. */
    public Hitbox hitbox = new Hitbox(0.9, 0.9);
    /** The current player health. */
    public float health = 5f;
    /** THe maximum health ammout of the player. */
    public float maxhealth = 5;
    /** The ammount of money the player is holding. */
    public int cash;
}
