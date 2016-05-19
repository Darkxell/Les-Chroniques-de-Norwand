package com.norwand.game.management.gamedata.player;

import com.norwand.game.management.gamedata.items.Consumable.BigHealthPot;
import com.norwand.game.management.gamedata.items.Consumable.HealthPot;
import com.norwand.game.management.gamedata.items.Consumable.MegaBigHealthPot;
import com.norwand.game.management.gamedata.items.Consumable.UltraMegaBigHealthPot;
import com.norwand.game.management.gamedata.items.Equipable.Armor.AlloyArmor;
import com.norwand.game.management.gamedata.items.Equipable.Armor.Armor;
import com.norwand.game.management.gamedata.items.Equipable.Armor.CopperArmor;
import com.norwand.game.management.gamedata.items.Equipable.Armor.IronArmor;
import com.norwand.game.management.gamedata.items.Equipable.Armor.LeatherArmor;
import com.norwand.game.management.gamedata.items.Equipable.Armor.OrichalcumArmor;
import com.norwand.game.management.gamedata.items.Equipable.Armor.ScaleArmor;
import com.norwand.game.management.gamedata.items.Equipable.Armor.SteelArmor;
import com.norwand.game.management.gamedata.items.Equipable.Boots.Boots;
import com.norwand.game.management.gamedata.items.Equipable.Boots.HardenedBoots;
import com.norwand.game.management.gamedata.items.Equipable.Boots.LeatherBoots;
import com.norwand.game.management.gamedata.items.Equipable.Boots.ScaleBoots;
import com.norwand.game.management.gamedata.items.Equipable.Equipable;
import com.norwand.game.management.gamedata.items.Equipable.Helmet.Helmet;
import com.norwand.game.management.gamedata.items.Equipable.Helmet.IronHelmet;
import com.norwand.game.management.gamedata.items.Equipable.Helmet.LeatherHelmet;
import com.norwand.game.management.gamedata.items.Equipable.Helmet.SteelHelm;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.BluegemNecklace;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.CopperNecklace;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.GoldenNecklace;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.GreengemNecklace;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.LittlePendent;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.Necklace;
import com.norwand.game.management.gamedata.items.Equipable.Necklace.RedgemNecklace;
import com.norwand.game.management.gamedata.items.Equipable.Ring.CopperRing;
import com.norwand.game.management.gamedata.items.Equipable.Ring.GoldRing;
import com.norwand.game.management.gamedata.items.Equipable.Ring.PlatinumRing;
import com.norwand.game.management.gamedata.items.Equipable.Ring.Ring;
import com.norwand.game.management.gamedata.items.Equipable.Ring.SilverRing;
import com.norwand.game.management.gamedata.items.Equipable.Ring.WoodenRing;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield.ManatarmShield;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield.MasterpieceShield;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield.SteelShield;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Shield.WoodenShield;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.AlloySword;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.ButterKnife;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.ChichKebab;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.CopperSword;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.IronSword;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Sword.SteelSword;
import com.norwand.game.management.gamedata.items.Equipable.Weapon.Weapon;
import com.norwand.game.management.gamedata.items.Item;
import com.norwand.game.management.gamedata.player.capacities.Cap_FrostWalker;
import com.norwand.game.management.gamedata.player.capacities.Cap_Teleport;
import com.norwand.game.management.gamedata.player.capacities.debug_Cap_1;
import com.norwand.game.management.gamedata.player.capacities.debug_Cap_3;

/**
 * Represents the player inventory.
 */
public class Inventory {

    /**
     * The list of items in the player inventory.
     */
    public Item[] items = new Item[]{};
    /**
     * The list of non equipped equipables in the player inventory.
     */
    public Equipable[] equipables = new Equipable[]{};
    /**
     * The list of capacities in the player inventory.
     */
    public Capacity[] capacity = new Capacity[]{};

    /**
     * The Armor of the player
     */
    public Armor armor;
    /**
     * The Boots of the player
     */
    public Boots boots;
    /**
     * The Helmet of the player
     */
    public Helmet helmet;
    /**
     * The Necklace of the player
     */
    public Necklace necklace;
    /**
     * The Ring of the player
     */
    public Ring ring;

    /**
     * The first weapon of the player
     */
    public Weapon weapon1;
    /**
     * The second weapon of the player
     */
    public Weapon weapon2;

    /**
     * The first capacity slot of the player.
     */
    public Capacity slot_cap1 = null /*new Cap_Teleport()*/;
    /**
     * The second capacity slot of the player.
     */
    public Capacity slot_cap2;
    /**
     * The third capacity slot of the player.
     */
    public Capacity slot_cap3;

    /**
     * The first quickitem in the quickitems slots.
     */
    public Item quickItem1 = null;
    /**
     * The second quickitem in the quickitems slots.
     */
    public Item quickItem2 = null;

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
     *
     * @param i the item that must be removed
     */
    public void removeItem(Item i) {
        if (quickItem1 == i) {
            quickItem1 = null;
            return;
        } else if (quickItem2 == i) {
            quickItem2 = null;
            return;
        } else
            removeItemFromArray(i);
    }

    private void removeItemFromArray(Item i) {
        int newLenght = items.length - 1;
        if (newLenght < 0)
            newLenght = 0;
        Item[] newItems = new Item[newLenght];
        int removeId = -1;
        for (int j = 0; j < items.length; j++)
            if (items[j] == i)
                removeId = j;
        if (removeId == -1)
            System.err.println("Item non trouvé. Délétion impossible.");
        else {
            System.arraycopy(items, 0, newItems, 0, removeId);
            System.arraycopy(items, removeId + 1, newItems, removeId, newLenght
                    - removeId);
            items = newItems;
        }
    }


    /**
     * delete the specified equipable
     *
     * @param e
     */
    public void removeEquipable(Equipable e) {

        int newLenght = equipables.length - 1;
        if (newLenght < 0)
            newLenght = 0;
        Equipable[] newEquipables = new Equipable[newLenght];
        int removeId = -1;
        for (int i = 0; i < equipables.length; i++)
            if (equipables[i] == e)
                removeId = i;
        if (removeId == -1)
            System.err.println("Equipable non trouvé. Délétion impossible.");
        else {
            System.arraycopy(equipables, 0, newEquipables, 0, removeId);
            System.arraycopy(equipables, removeId + 1, newEquipables, removeId, newLenght - removeId);
            equipables = newEquipables;
        }
    }

    /**
     * Remove the specified capacity
     *
     * @param c the capacity that must be removed
     */
    public void removeCapacity(Capacity c) {

        int newLenght = capacity.length - 1;

        if (newLenght < 0)
            newLenght = 0;

        Capacity[] newCapacity = new Capacity[newLenght];
        int removeId = -1;

        for (int i = 0; i < capacity.length; i++)
            if (capacity[i] == c)
                removeId = i;

        if (removeId == -1)
            System.err.println("Capacité non trouvée. Délétion impossible.");

        else {
            System.arraycopy(capacity, 0, newCapacity, 0, removeId);
            System.arraycopy(capacity, removeId + 1, newCapacity, removeId, newLenght - removeId);
            capacity = newCapacity;
        }
    }

    /**
     * Add the specified item to the items list
     *
     * @param i the item that must be added
     */
    public void addItem(Item i) {
        Item[] newItems = new Item[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[items.length] = i;
        items = newItems;
    }

    /**
     * Add the specified equipable to the equipable list
     *
     * @param e the equipable that must be added
     */
    public void addEquipable(Equipable e) {
        Equipable[] newEquipable = new Equipable[equipables.length + 1];
        System.arraycopy(equipables, 0, newEquipable, 0, equipables.length);
        newEquipable[equipables.length] = e;
        equipables = newEquipable;
    }

    /**
     * Add the specified capacity to the capacity list
     *
     * @param c the capacity that must be added
     */
    public void addCapacity(Capacity c) {
        Capacity[] newCapacity = new Capacity[capacity.length + 1];
        System.arraycopy(capacity, 0, newCapacity, 0, capacity.length);
        newCapacity[capacity.length] = c;
        capacity = newCapacity;
    }

    /**
     * Equip the specified item
     *
     * @param i the item that must be equiped
     */
    public void equipItem(Item i) {
        if (quickItem1 == null) {
            quickItem1 = i;
            removeItemFromArray(i);
        } else if (quickItem1 != null && quickItem2 == null) {
            quickItem2 = quickItem1;
            quickItem1 = i;
            removeItemFromArray(i);
        } else if (quickItem1 != null && quickItem2 != null) {
            Item temp1 = quickItem1;
            Item temp2 = quickItem2;
            quickItem1 = i;
            quickItem2 = temp1;
            addItem(temp2);
            removeItemFromArray(i);
        }
    }

    /**
     * Equip the specified capacity
     *
     * @param c the capacity that must be equiped
     */
    public void equipCapacity(Capacity c) {
        if (slot_cap1 == null)
            slot_cap1 = c;

        else if (slot_cap2 == null)
            slot_cap2 = c;

        else if (slot_cap3 == null)
            slot_cap3 = c;

        else {
            Capacity temp1 = slot_cap1;
            Capacity temp2 = slot_cap2;
            Capacity temp3 = slot_cap3;
            slot_cap1 = c;
            slot_cap2 = temp1;
            slot_cap3 = temp2;
            addCapacity(temp3);
        }

        removeCapacity(c);
    }

    /**
     * Equip the specified equipable
     *
     * @param e the equipable that must be equiped
     */
    public void equipEquipable(Equipable e) {
        if (e instanceof Armor) {
            if (armor == null)
                armor = (Armor) e;
            else {
                Armor temp = armor;
                armor = (Armor) e;
                addEquipable(temp);
            }
        } else if (e instanceof Boots) {
            if (boots == null)
                boots = (Boots) e;
            else {
                Boots temp = boots;
                boots = (Boots) e;
                addEquipable(temp);
            }
        } else if (e instanceof Helmet) {
            if (helmet == null)
                helmet = (Helmet) e;
            else {
                Helmet temp = helmet;
                helmet = (Helmet) e;
                addEquipable(temp);
            }
        } else if (e instanceof Necklace) {
            if (necklace == null)
                necklace = (Necklace) e;
            else {
                Necklace temp = necklace;
                necklace = (Necklace) e;
                addEquipable(temp);
            }
        } else if (e instanceof Ring) {
            if (ring == null)
                ring = (Ring) e;
            else {
                Ring temp = ring;
                ring = (Ring) e;
                addEquipable(temp);
            }
        } else if (e instanceof Weapon) {

            if (weapon1 == null)
                weapon1 = (Weapon) e;

            else if (weapon2 == null)
                weapon2 = (Weapon) e;

            else {
                Weapon temp1 = weapon1;
                Weapon temp2 = weapon2;
                weapon1 = (Weapon) e;
                weapon2 = temp1;
                addEquipable(temp2);
            }
        } else {
            System.out.println("Erreur.");
            return;
        }

        removeEquipable(e);
    }

    /**
     * Returns the total armor rating of the equipped items of this inventory.
     */
    public double getTotalArmor() {
        double totarmor = 5;

        if (ring != null)
            totarmor += ring.getArmor();

        if (helmet != null)
            totarmor += helmet.getArmor();

        if (boots != null)
            totarmor += boots.getArmor();

        if (armor != null)
            totarmor += armor.getArmor();

        if (necklace!= null)
            totarmor += necklace.getArmor();

        if (weapon1 != null)
            totarmor += weapon1.getArmor();

        if (weapon2 != null)
            totarmor += weapon2.getArmor();

        return totarmor;
    }

    /**
     * Returns the total damage rating of the equipped items of this inventory.
     */
    public double getTotalDamage() {
        double totdegat = 1;

        if (ring != null)
            totdegat += ring.getDamage();

        if (helmet != null)
            totdegat += helmet.getDamage();

        if (boots != null)
            totdegat += boots.getDamage();

        if (armor != null)
            totdegat += armor.getDamage();

        if (necklace != null)
            totdegat += necklace.getDamage();

        if (weapon1 != null)
            totdegat += weapon1.getDamage();

        if (weapon2 != null)
            totdegat += weapon2.getDamage();

        return totdegat;
    }
}