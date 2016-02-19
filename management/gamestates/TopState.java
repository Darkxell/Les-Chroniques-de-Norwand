package management.gamestates;

import java.awt.Graphics2D;

import utility.UserEvent;

/**
 * The top State of the state tree. It should only be used in the MainGame
 * class, and is the only one not to have a parent.<br/>
 * The usual GameState methods here only callse its son methods.
 */
public class TopState extends GameState {

    /**Creates a new <code>TopState</code>*/
    public TopState(){
	 super.substate = new DebugState();
    }
    
    @Override
    public void update() {
	substate.update();
    }

    @Override
    public void print(Graphics2D g) {
	substate.print(g);
    }

    @Override
    public void onPress(UserEvent e) {
	substate.onPress(e);
    }

    @Override
    public void onDrag(UserEvent e) {
	substate.onDrag(e);
    }

    @Override
    public void onRelease(UserEvent e) {
	substate.onRelease(e);
    }

    @Override
    public void onKeyPressed(UserEvent e) {
	substate.onKeyPressed(e);
    }

    @Override
    public void onKeyReleased(UserEvent e) {
	substate.onKeyReleased(e);
    }

}
