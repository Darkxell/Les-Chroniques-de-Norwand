package management.gamestates;

import java.awt.Graphics2D;

/**
 * The top State of the state tree. It should only be used in the MainGame
 * class, and is the only one not to have a parent.<br/>
 * The usual GameState methods here only callse its son methods.
 */
public class TopState extends GameState {

    @Override
    public void update() {
	substate.update();
    }

    @Override
    public void print(Graphics2D g) {
	substate.print(g);
    }

}
