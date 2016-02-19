package utility;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/** Represents an event by the user. */
public class UserEvent {

    public static final byte TYPE_KEYEVENT = 0;
    public static final byte TYPE_FEVENT = 1;
    public static final byte TYPE_MEVENT = 2;

    /**
     * The type of the event. Can be either KEY, FINGER or MOUSE. <br/>
     * 
     * @see UserEvent.TYPE_KEYEVENT
     * @see UserEvent.TYPE_FEVENT
     * @see UserEvent.TYPE_MEVENT
     **/
    public byte type;
    /**
     * The value of the event. Can be either the ID of the pressed key in a
     * KEYEVENT, or the ID of the mouse button pressed.
     */
    public int value;
    /** The x coordinate of the event in a MOUSE or FINGER event. */
    public int x;
    /** The y coordinate of the event in a MOUSE or FINGER event. */
    public int y;

    /** Builds an UserEvent using an existing awt <code>KeyEvent</code> */
    public UserEvent(KeyEvent e) {
	this.type = TYPE_KEYEVENT;
	this.value = e.getKeyCode();
    }

    /** Builds an UserEvent using an existing awt <code>MouseEvent</code> */
    public UserEvent(MouseEvent e) {
	this.type = TYPE_MEVENT;
	this.value = e.getButton();
	this.x = e.getX();
	this.y = e.getY();
    }
    /*
     * public UserEvent(FingerEvent e){
     * 
     * } TODO
     */

}
