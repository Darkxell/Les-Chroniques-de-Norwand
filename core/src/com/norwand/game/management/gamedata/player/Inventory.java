package com.norwand.game.management.gamedata.player;

import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.management.gamedata.items.Equipable.Equipable;
import com.norwand.game.management.gamedata.player.capacities.Cap_Teleport;

/** Represents the player inventory. */
public class Inventory {

    /** The list of items in the player inventory. */
    public Item[] items;
    /** The list of non equipped equipables in the player inventory. */
    public Equipable[] equipables;
    /** The list of capacities in the player inventory. */
    public Capacity[] capacity;

    /** The first capacity slot of the player. */
    public Capacity slot_cap1 = new Cap_Teleport();
    /** The segond capacity slot of the player. */
    public Capacity slot_cap2 = null;
    /** The third capacity slot of the player. */
    public Capacity slot_cap3 = null;

    public Capacity getCapFromId(byte id) {
	switch (id) {
	case 1:
	    return slot_cap1;
	case 2:
	    return slot_cap2;
	case 3:
	    return slot_cap3;
	default:
	    return null;
	}
    }

}
