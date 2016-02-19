package management.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;

import utility.UserEvent;

public class DebugState extends GameState {

    @Override
    public void update() {
    }

    @Override
    public void print(Graphics2D g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 240, 160);
    }

    @Override
    public void onPress(UserEvent e) {
    }

    @Override
    public void onDrag(UserEvent e) {
    }

    @Override
    public void onRelease(UserEvent e) {
    }

    @Override
    public void onKeyPressed(UserEvent e) {
    }

    @Override
    public void onKeyReleased(UserEvent e) {
    }

}
