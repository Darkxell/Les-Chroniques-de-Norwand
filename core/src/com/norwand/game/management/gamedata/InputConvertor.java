package com.norwand.game.management.gamedata;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerCamera;
import com.norwand.game.utility.objects.Position;

/**
 * Class that manages the userevents and converts them to trigger the player
 * action methods at the right time.
 */
public class InputConvertor {
    private int anchorX;
    private int anchorY;
    private int framecount;

    public void onPress(UserEvent e, Player pointer) {
	anchorX = e.x;
	anchorY = e.y;
	framecount = 25;
    }

    public void onDrag(UserEvent e, Player pointer) {
	pointer.onMoveTo(convertPosition(new Position(e.x, e.y), pointer.cam));
    }

    public void onRelease(UserEvent e, Player pointer) {
	pointer.onStop();
	if (framecount > 0 && e.x <= anchorX + 5 && e.x >= anchorX - 5
		&& e.y <= anchorY + 5 && e.y >= anchorY - 5) {
	    pointer.onTap(convertPosition(new Position(e.x, e.y), pointer.cam));
	}
    }

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    public void onKeyPressed(UserEvent e, Player pointer) {
	switch (e.value) {
	case Keys.LEFT:
	    left = true;
	    break;
	case Keys.RIGHT:
	    right = true;
	    break;
	case Keys.UP:
	    up = true;
	    break;
	case Keys.DOWN:
	    down = true;
	    break;
	}
    }

    public void onKeyReleased(UserEvent e, Player pointer) {
	switch (e.value) {
	case Keys.LEFT:
	    left = false;
	    break;
	case Keys.RIGHT:
	    right = false;
	    break;
	case Keys.UP:
	    up = false;
	    break;
	case Keys.DOWN:
	    down = false;
	    break;
	}
    }

    public void onType(UserEvent e, Player pointer) {
    }

    public void update(Player pointer) {
	if (framecount > 0)
	    --framecount;
	Position add = getAdditive();
	if (add.x != 0 || add.y != 0)
	    pointer.onMoveTo(new Position(pointer.x + add.x, pointer.y + add.y));
    }

    /**
     * Converts the position in pixels on the screen to a real position in the
     * game using the floor position.
     */
    public Position convertPosition(Position inpixels, PlayerCamera screen) {
	return new Position(screen.x + ((inpixels.x - 120) / 16), screen.x
		+ ((inpixels.y - (240 * Gdx.graphics.getHeight()
			/ Gdx.graphics.getWidth() / 2)) / 16));
    }

    private Position getAdditive() {
	return new Position(right ? 1 : left ? -1 : 0, down ? 1 : up ? -1 : 0);
    }
}
