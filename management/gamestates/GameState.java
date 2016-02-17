package management.gamestates;

import java.awt.Graphics2D;

/** A part of the state tree. */
public abstract class GameState {

    /** The state above in the state tree. */
    public GameState parent;

    public GameState substate;

    public abstract void update();

    public abstract void print(Graphics2D g);
}
