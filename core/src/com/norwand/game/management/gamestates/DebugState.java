package com.norwand.game.management.gamestates;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.management.UserEvent;

public class DebugState extends GameState {

    public DebugState(GameState parent) {
	super(parent);
    }

    private int dotX=50;
    private int dotY=50;
    private Color c = Color.GREEN;
    
    @Override
    public void update() {
    }

    @Override
    public void print(Pixmap g) {
	g.setColor(Color.CYAN);
	g.drawRectangle(0, 0, 110, 20);
	g.drawRectangle(0, g.getHeight()-20, 110, 20);
	g.setColor(c);
	g.drawPixel(dotX, dotY);
    }

    @Override
    public void onPress(UserEvent e) {
	dotX = e.x;
	dotY = e.y;
	c = Color.RED;
    }

    @Override
    public void onDrag(UserEvent e) {
	dotX = e.x;
	dotY = e.y;
    }

    @Override
    public void onRelease(UserEvent e) {
	dotX = e.x;
	dotY = e.y;
	c = Color.GREEN;
    }

    @Override
    public void onKeyPressed(UserEvent e) {
	switch (e.value) {
	case Keys.LEFT:
	    --dotX;
	    break;
	case Keys.RIGHT:
	    ++dotX;
	    break;
	case Keys.UP:
	    --dotY;
	    break;
	case Keys.DOWN:
	    ++dotY;
	    break;
	}
    }

    @Override
    public void onKeyReleased(UserEvent e) {
    }

    @Override
    public void onType(UserEvent e) {
    }

}
