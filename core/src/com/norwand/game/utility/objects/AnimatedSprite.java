package com.norwand.game.utility.objects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Disposable;

/**
 * Represents an animated image. The frames are skipped using the update()
 * method.
 */
public class AnimatedSprite implements Disposable {

    /**
     * Has a maximum size of 256 images inside. Stores the different frames of
     * the animated sprite.
     */
    private Pixmap[] frames;
    /** Pointer to the current frame. */
    private byte framecounter = 0;
    /**
     * integer decreased each update, is set to maxupdate upon reaching 0 and
     * increments the framecounter by 1.
     */
    private byte updater;
    /** The ammount of update calls needed to skip uone frame. */
    private byte maxupdate;

    /**
     * Constructs a new AnimatedSprite. This object will share the same
     * ressources as the frames array.
     * 
     * @param frames
     *            the frames of the annimated sprite.
     * @param fpu
     *            number of update calls needed to skip one frame.
     */
    public AnimatedSprite(Pixmap[] frames, byte fpu) {
	this.frames = frames;
	this.updater = fpu;
	this.maxupdate = fpu;
    }

    /**
     * Creates a non animated animated sprite. Yes you can, calling the update
     * method won't do anything, and getting the current frame will always
     * return the texture.
     */
    public AnimatedSprite(Pixmap texture) {
	this.frames = new Pixmap[] { texture };
    }

    @Override
    public void dispose() {
	for (int i = 0; i < frames.length; i++)
	    frames[i].dispose();
    }

    public void update() {
	if (frames.length > 1)
	    if (updater < 0) {
		updater = maxupdate;
		if (framecounter == frames.length - 1)
		    framecounter = 0;
		else
		    ++framecounter;
	    } else
		--updater;
    }

    /**
     * Gets the current frame of this annimated texture. Copy this pixmap if you
     * intend to modify it, as drawing on it will definitively change the game
     * ressources. Don't forget to dispose of the clone if you clone it, but do
     * NOT dispose of the returned pixmap.<br>
     * Use <code>AnimatedSprite.dispose()</code> instead.
     */
    public Pixmap getCurrentFrame() {
	return frames[framecounter];
    }
}
