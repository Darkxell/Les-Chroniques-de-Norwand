package com.norwand.game.management.gamedata;

import com.badlogic.gdx.Gdx;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamedata.player.Player;
import com.norwand.game.management.gamedata.player.PlayerCamera;
import com.norwand.game.utility.objects.Position;

/**
 * <p>
 * Class that manages the userevents and converts them to trigger the player
 * action methods at the right time.
 * </p>
 * <p>
 * This class calls the following methods of the parsed player object accorded
 * to its converstion rules:<br>
 * <code>void onTap(Position pos);<br>
 * void onMoveTo(Position pos);<br>
 * void onStop();</code><br>
 * You should note that there is no
 * <code> void onSkillUsed(Position pos, Capacity capacity)</code> calls, as
 * this method should be called directly from the playstate.
 * </p>
 * <p>
 * This class only calls the methods from an update loop, storing the events and
 * processing them during the next update. This may seems unefficient, but
 * prevents some inconcistancy glitches that would result in short flicker of
 * the player sprites and artifacts around his transparent sprite parts.
 * </p>
 */
public class InputConvertor {

    /**
     * Is true if the user has his finger/mouse pressed on the screen. Can be
     * false when it shouldn't in some rare cases.
     */
    private boolean pressed;
    /**
     * The last position recorded by the onPress() method (on the screen). used
     * to trigger the onTap() player event.
     */
    private Position anchor;
    /** The ammount of frames left to trigger the onTap() method of the player. */
    private int framecount;
    /**
     * is true if and only if the next update() call will trigger the ontap()
     * method of the parsed player.
     */
    private boolean nexttap;
    /**
     * is true if and only if the next update() call will trigger the onstop()
     * method of the parsed player.
     */
    private boolean nextstop;
    /**
     * Position updated by any move of the mose/finger. THis anchor is used to
     * trigger the onMove() method.
     */
    private Position movingAnchor;

    /** Called when the user presses the screen. */
    public void onPress(UserEvent e) {
	pressed = true;
	movingAnchor = new Position(e.x, e.y);
	anchor = new Position(e.x, e.y);
	framecount = 20;
	// time you fave in frames (50f = 1sec) to unpress to dash.
    }

    /** Called when the user drags on the screen. */
    public void onDrag(UserEvent e) {
	pressed = true;// just in case.
	movingAnchor = new Position(e.x, e.y);
    }

    /** Called when the user releases the screen */
    public void onRelease(UserEvent e) {
	pressed = false;
	if (framecount > 0
		&& anchor.getDistanceFrom(new Position(e.x, e.y)) < 15)
	    nexttap = true;
	nextstop = true;
    }

    /** Called when the user presses a key. */
    public void onKeyPressed(UserEvent e) {
    }

    /** Called when the user releases a key. */
    public void onKeyReleased(UserEvent e) {
    }

    /** Called when the user types in a character on his keyboard. */
    public void onType(UserEvent e) {
    }

    /**
     * Updates this inputConvertor. This calls the wanted triggerable methods in
     * the right order if they need a call.
     */
    public void update(Player pointer) {
	--framecount;
	if (pressed) {
	    pointer.onMoveTo(convertPosition(movingAnchor, pointer.cam));
	}
	if (nextstop) {
	    nextstop = false;
	    pointer.onStop();
	}
	if (nexttap) {
	    nexttap = false;
	    pointer.onTap(convertPosition(anchor, pointer.cam));
	}
    }

    /**
     * Converts the position in pixels on the screen to a real position in the
     * game using the floor position. This only works if the player is centered
     * in the camera.
     */
    public static  Position convertPosition(Position inpixels, PlayerCamera screen) {
	return new Position(screen.x + ((inpixels.x - 120) / 16), screen.y
		+ ((inpixels.y - (240 * Gdx.graphics.getHeight()
			/ Gdx.graphics.getWidth() / 2)) / 16));
    }

}
