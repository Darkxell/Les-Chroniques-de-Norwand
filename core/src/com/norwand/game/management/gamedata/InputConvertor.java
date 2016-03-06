package com.norwand.game.management.gamedata;

import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.player.Player;

/**
 * Class that manages the userevents and converts them to trigger the player
 * action methods at the right time.
 */
public class InputConvertor {
    private boolean ispressed;
    private boolean ismoving;

    public void onPress(UserEvent e, Player pointer) {
	ispressed = true;
    }

    public void onDrag(UserEvent e, Player pointer) {
    }

    public void onRelease(UserEvent e, Player pointer) {
	ispressed = false;
    }

    public void onKeyPressed(UserEvent e, Player pointer) {
    }

    public void onKeyReleased(UserEvent e, Player pointer) {
    }

    public void onType(UserEvent e, Player pointer) {
    }

    public void update() {

    }
}
