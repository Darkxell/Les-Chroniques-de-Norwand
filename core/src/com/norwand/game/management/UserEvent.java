package com.norwand.game.management;

import com.badlogic.gdx.Input.Buttons;

/** Represents an event by the user. */
public class UserEvent {

    public static final byte TYPE_KEYEVENT = 0;
    public static final byte TYPE_FEVENT = 1;
    public static final byte TYPE_MEVENT = 2;
    public static final byte TYPE_KTYPEDEVENT = 3;

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
    /**
     * In case of a Keyboard type event only, stores the inputed character. <br/>
     * Nope, this is not an Undertale reference.
     */
    public char chara;
    /** The x coordinate of the event in a MOUSE or FINGER event. */
    public int x;
    /** The y coordinate of the event in a MOUSE or FINGER event. */
    public int y;

    /** Detailled constructore for a fully planned Userevent. */
    public UserEvent(byte type, int value, char chara, int x, int y) {
	this.type = type;
	this.value = value;
	this.chara = chara;
	this.x = x;
	this.y = y;
    }

    /** Default constructor for a Key Event. */
    public UserEvent(int value) {
	type = TYPE_KEYEVENT;
	this.value = value;
    }

    /** Default constructor for a Mouse Event. */
    public UserEvent(int value, int x, int y) {
	this.type = TYPE_MEVENT;
	this.value = value;
	this.x = x;
	this.y = y;
    }
    
    /**Default constructor for a KeyTyped Event.*/
    public UserEvent(char chara){
	this.type = TYPE_KTYPEDEVENT;
	this.chara = chara;
    }
    
    /**Default constructor for a TouchEvent*/
    public UserEvent(int x,int y){
	this.type = TYPE_MEVENT;
	this.value = Buttons.LEFT;
	this.x = x;
	this.y = y;
    }
}
