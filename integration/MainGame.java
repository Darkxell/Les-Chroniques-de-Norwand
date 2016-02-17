package integration;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import management.gamestates.GameState;
import management.gamestates.TopState;

/**
 * The game object. This object can be graphically drawn by calling the
 * <code>getFrame()</code> method. It will also play the sounds automatically. <br/>
 * Calling the kill() method will stop this Game object from doing anything.
 */
public final class MainGame {

    /** The top state of the game. */
    public GameState currentstate = new TopState();

    /**
     * Gets a buffered Image representing the current state of the Game. This is
     * CPU calculated. The returned Image is manually Double Buffered, for no
     * chance of flickering.
     * 
     * @return BufferedImage The image representing the frame. 240*160 px,
     *         undefined definition, RGB no Alpha.
     */
    public BufferedImage getFrame() {
	if (currentstate == null)
	    return null;
	BufferedImage buffer = new BufferedImage(240, 160,
		BufferedImage.TYPE_INT_RGB), frame = new BufferedImage(240,
		160, BufferedImage.TYPE_INT_RGB);
	this.currentstate.print((Graphics2D) frame.getGraphics());
	buffer.getGraphics().drawImage(frame, 0, 0, null);
	return buffer;
    }

    /**
     * Updates the state tree of the game, calling the TopState update() method.
     */
    public void update() {
	if (currentstate != null)
	    currentstate.update();
	else
	    System.err.println("Tried to update a killed Maingame object.");
    }

    /**
     * Kills this object, releasing all of it's ressources. And preventing any
     * of its calls to do anything.
     */
    public void kill() {
	this.currentstate = null;
    }

}
