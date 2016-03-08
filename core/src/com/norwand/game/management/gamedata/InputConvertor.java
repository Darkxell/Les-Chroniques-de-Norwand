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

    private boolean pressed;
    private Position anchor;
    private int framecount;

    public void onPress(UserEvent e, Player pointer) {
	pressed = true;
	anchor = convertPosition(new Position(e.x, e.y), pointer.cam);
	framecount = 25;
    }

    public void onDrag(UserEvent e, Player pointer) {
	anchor = convertPosition(new Position(e.x, e.y), pointer.cam);
    }

    public void onRelease(UserEvent e, Player pointer) {
	pressed = false;
	pointer.onStop();
	Position temp = convertPosition(new Position(e.x, e.y), pointer.cam);
	if (framecount > 0 && temp.x <= anchor.x + 1 && temp.x >= anchor.x - 1
		&& temp.y <= anchor.y + 1 && temp.y >= anchor.y - 1)
	    pointer.onTap(temp);
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
	else if (pressed
		&& anchor.getDistanceFrom(new Position(pointer.x, pointer.y)) > 0.5)
	    pointer.onMoveTo(anchor);
    }

    /**
     * Converts the position in pixels on the screen to a real position in the
     * game using the floor position. This only works if the player is centered
     * in the camera.
     */
    private Position convertPosition(Position inpixels, PlayerCamera screen) {
	return new Position(screen.x + ((inpixels.x - 120) / 16), screen.y
		+ ((inpixels.y - (240 * Gdx.graphics.getHeight()
			/ Gdx.graphics.getWidth() / 2)) / 16));
    }

    /** gets a position adding the 4 directionnal booleens. */
    private Position getAdditive() {
	Position pos = new Position(0, 0);
	if (left)
	    --pos.x;
	if (right)
	    ++pos.x;
	if (up)
	    --pos.y;
	if (down)
	    ++pos.y;
	return pos;
    }
}
