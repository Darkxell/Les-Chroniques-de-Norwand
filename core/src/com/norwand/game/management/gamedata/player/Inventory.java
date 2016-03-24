package com.norwand.game.management.gamedata.player;

import com.norwand.game.management.gamedata.items.Consumable.HealthPot;
import com.norwand.game.management.gamedata.items.Equipable.Armor.Armor;
import com.norwand.game.management.gamedata.items.Equipable.Boots.Boots;
import com.norwand.game.management.gamedata.items.Equipable.Equipable;
import com.norwand.game.management.gamedata.items.Equipable.Helmet.Helmet;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.Necklace;
import com.norwand.game.management.gamedata.items.Equipable.Ring.Ring;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Weapon;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.management.gamedata.player.capacities.Cap_Teleport;

/** Represents the player inventory. */
public class Inventory {

    /** The list of items in the player inventory. */
    public Item[] items = new Item[] { new HealthPot(), new HealthPot(),
	    new HealthPot() ,new HealthPot(), new HealthPot(),
	    new HealthPot() ,new HealthPot(), new HealthPot(),
	    new HealthPot() ,new HealthPot(), new HealthPot(),
	    new HealthPot() ,new HealthPot(), new HealthPot(),
	    new HealthPot() ,new HealthPot(), new HealthPot(),
	    new HealthPot()};
    /** The list of non equipped equipables in the player inventory. */
    public Equipable[] equipables = new Equipable[] {};
    /** The list of capacities in the player inventory. */
    public Capacity[] capacity = new Capacity[] {};

    /** The Armor of the player */
    public Armor armor;

    /** The Boots of the player */
    public Boots boots;

    /** The Helmet of the player */
    public Helmet helmet;

    /** The Necklace of the player */
    public Necklace necklace;

    /** The Ring of the player */
    public Ring ring;

    /** The first weapon of the player */
    public Weapon weapon1;

    /** The second weapon of the player */
    public Weapon weapon2;

    /** The first capacity slot of the player. */
    public Capacity slot_cap1 = new Cap_Teleport();
    /** The segond capacity slot of the player. */
    public Capacity slot_cap2 = null;
    /** The third capacity slot of the player. */
    public Capacity slot_cap3 = null;

    /** The first quickitem in the quickitems slots. */
    public Item quickItem1 = null;
    /** The second quickitem in the quickitems slots. */
    public Item quickItem2 = new HealthPot();


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

    /**
     * Remove the specified item from the items list
     * @param i the item that must be removed
     */
    public void removeItem(Item i) {
        int newLenght = items.length - 1;
        if(newLenght < 0)
            newLenght = 0;
        Item[] newItems = new Item[newLenght];
        int removeId = -1;
        for(int j = 0 ; j < items.length ; j++)
            if(items[j] == i)
                removeId = j;
        if(removeId == -1)
            System.err.println("Item non trouvé. Délétion impossible.");
        else {
            System.arraycopy(items, 0, newItems, 0, removeId);
            System.arraycopy(items, removeId + 1, newItems, removeId,
                    newLenght - removeId);
        }
    }

    /**
     * Remove the specified equipable
     * @param e the equipable that must be removed
     */
    public void removeEquipable(Equipable e){
        int newLenght = equipables.length - 1;
        if(newLenght < 0)
            newLenght = 0;
        Equipable[] newEquipables = new Equipable[newLenght];
        int removeId = -1;
        for(int i = 0 ; i < equipables.length ; i++)
            if(equipables[i] == e)
                removeId = i;
        if(removeId == -1)
            System.err.println("Equipable non trouvé. Délétion impossible.");
        else{
            System.arraycopy(items, 0, newEquipables, 0, removeId);
            System.arraycopy(items, removeId + 1, newEquipables, removeId,
                    newLenght - removeId);
        }
    }

    /**
     * Remove the specified capacity
     * @param c the capacity that must be removed
     */
    public void removeCapacity(Capacity c){
        int newLenght = capacity.length - 1;
        if(newLenght < 0)
            newLenght = 0;
        Capacity[] newCapacity = new Capacity[newLenght];
        int removeId = -1;
        for(int i = 0 ; i < capacity.length ; i++)
            if(capacity[i] == c)
                removeId = i;
        if(removeId == -1)
            System.err.println("Capacité non trouvé. Délétion impossible.");
        else{
            System.arraycopy(items, 0, newCapacity, 0, removeId);
            System.arraycopy(items, removeId + 1, newCapacity, removeId,
                    newLenght - removeId);
        }
    }

    /**
     * Add the specified item to the items list
     * @param i the item that must be added
     */
    public void addItem(Item i){
        Item[] newItems = new Item[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[items.length] = i;
        items = newItems;
    }

    /**
     * Add the specified equipable to the equipable list
     * @param e the equipable that must be added
     */
    public void addEquipable(Equipable e){
        Equipable[] newEquipable = new Equipable[equipables.length + 1];
        System.arraycopy(equipables, 0, newEquipable, 0, equipables.length);
        newEquipable[items.length] = e;
        equipables = newEquipable;
    }

    /**
     * Add the specified capacity to the capacity list
     * @param c the capacity that must be added
     */
    public void addCapacity(Capacity c){
        Capacity[] newCapacity = new Capacity[capacity.length + 1];
        System.arraycopy(capacity, 0, newCapacity, 0, capacity.length);
        newCapacity[capacity.length] = c;
        capacity = newCapacity;
    }

    /**
     * Equip the specified item
     * @param i the item that must be equiped
     */
    public void equipItem(Item i){
        if(quickItem1 == null)
            quickItem1 = i;

        if(quickItem1 != null && quickItem2 == null){
            quickItem2 = quickItem1;
            quickItem1 = i;
        }

        if(quickItem1 != null && quickItem2 != null){
            Item temp1 = quickItem1;
            Item temp2 = quickItem2;
            quickItem1 = i;
            quickItem2 = temp1;
            addItem(temp2);
        }
    }

    /**
     * Equip the specified capacity
     * @param c the capacity that must be equiped
     */
    public void equipCapacity(Capacity c){

        if(slot_cap1 == null)
            slot_cap1 = c;

        if(slot_cap1 != null && slot_cap2 == null){
            slot_cap2 = slot_cap1;
            slot_cap1 = c;
        }

        if(slot_cap1 != null && slot_cap2 != null && slot_cap3 == null){
            Capacity temp1 = slot_cap1;
            Capacity temp2 = slot_cap2;
            slot_cap1 = c;
            slot_cap2 = temp1;
            slot_cap3 = temp2;
        }

        if(slot_cap1 != null && slot_cap2 != null && slot_cap3 != null){
            Capacity temp1 = slot_cap1;
            Capacity temp2 = slot_cap2;
            Capacity temp3 = slot_cap3;
            slot_cap1 = c;
            slot_cap2 = temp1;
            slot_cap3 = temp2;
            addCapacity(temp3);
        }
    }

    /**
     * Equip the specified equipable
     * @param e the equipable that must be equiped
     */
    public void equipEquipable(Equipable e){
        if(e instanceof Armor){
            if(armor == null)
                armor = (Armor)e;
            else{
                Armor temp = armor;
                armor = (Armor)e;
                addEquipable(e);
            }
        }

        else if(e instanceof Boots){
            if(boots == null)
                boots = (Boots)e;
            else{
                Boots temp = boots;
                boots = (Boots)e;
                addEquipable(e);
            }
        }

        else if(e instanceof Helmet){
            if(helmet == null)
                helmet = (Helmet)e;
            else{
                Helmet temp = helmet;
                helmet = (Helmet)e;
                addEquipable(e);
            }
        }

        else if(e instanceof Necklace){
            if(necklace == null)
                necklace = (Necklace)e;
            else{
                Necklace temp = necklace;
                necklace = (Necklace)e;
                addEquipable(e);
            }
        }
        else if(e instanceof Ring){
            if(ring == null)
                ring = (Ring)e;
            else{
                Ring temp = ring;
                ring = (Ring)e;
                addEquipable(e);
            }
        }

        else if(e instanceof Weapon){
            if(weapon1 == null)
                weapon1 = (Weapon)e;

            if(weapon1 == null && weapon2 != null){
                weapon2 = weapon1;
                weapon1 = (Weapon)e;
            }

            if(weapon1 != null && weapon2 != null){
                Weapon temp1 = weapon1;
                Weapon temp2 = weapon2;
                weapon1 = (Weapon)e;
                weapon2 = temp1;
                addEquipable(temp2);
            }
        }
        else
            System.out.println("Erreur.");
    }
}