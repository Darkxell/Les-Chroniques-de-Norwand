package integration.computer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import ressources.FrameRessources;
import utility.UserEvent;

public class GameCanvas extends JPanel {

    private static final long serialVersionUID = 1L;
    private GameFrame parent;

    /**
     * The Width of the internal display script. This is equals to the original
     * GameBoyAdvence screensize.
     */
    public static final int ScreenWidth = 240;
    /**
     * The Height of the internal display script. This is equals to the original
     * GameBoyAdvence screensize.
     */
    public static final int ScreenHeight = 160;

    private boolean isCursorExtends;

    private int mouseX;
    private int mouseY;
    private boolean isMouseInside;
    private boolean isMouseOnCorner;

    public GameCanvas(GameFrame parent) {
	this.parent = parent;
	this.setOpaque(false);
	this.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseReleased(MouseEvent e) {
		if (isMouseInside && mouseY < 30 && mouseX > getWidth() - 39
			&& mouseY > 10 && mouseX < getWidth() - 10)
		    System.exit(0);
		if (isMouseInside && mouseY < 30 && mouseY > 10
			&& mouseX > getWidth() - 68 && mouseX < getWidth() - 39)
		    parent.minimize();
		isMouseOnCorner = false;
		parent.game.onRelease(new UserEvent(e));
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
		isMouseOnCorner = e.getY() > getHeight() - 20
			&& e.getX() > getWidth() - 20;
			parent.game.onPress(new UserEvent(e));
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		isMouseInside = false;
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
		isMouseInside = true;
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
	    }
	});
	this.addMouseMotionListener(new MouseMotionListener() {

	    @Override
	    public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	    }

	    @Override
	    public void mouseDragged(MouseEvent e) {
		if (mouseY < 30 && mouseY > 10)
		    parent.moveTo(e.getXOnScreen() - mouseX, e.getYOnScreen()
			    - mouseY);
		if (isMouseOnCorner) {
		    parent.changeSize((e.getX() > 260) ? e.getX() + 10 : 260,
			    (e.getY() > 200) ? e.getY() + 10 : 200);
		}
		parent.game.onDrag(new UserEvent(e));
	    }
	});
	this.addKeyListener(new KeyListener() {

	    @Override
	    public void keyTyped(KeyEvent e) {
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
		parent.game.onKeyReleased(new UserEvent(e));
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
		parent.game.onKeyPressed(new UserEvent(e));
	    }
	});
    }

    @Override
    public void paintComponent(Graphics gr) {
	if ((mouseY > getHeight() - 20 && mouseX > getWidth() - 20)
		|| this.isMouseOnCorner) {
	    if (!isCursorExtends) {
		this.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
		isCursorExtends = true;
	    }
	} else if (isCursorExtends) {
	    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	    isCursorExtends = false;
	}

	gr.drawImage(FrameRessources.swadow_topleft, 0, 0, null);
	for (int i = 10; i < getWidth() - 10; ++i) {
	    gr.drawImage(FrameRessources.swadow_top, i, 0, null);
	    gr.drawImage(FrameRessources.swadow_bot, i, getHeight() - 10, null);
	}
	gr.drawImage(FrameRessources.swadow_topright, getWidth() - 10, 0, null);
	gr.drawImage(FrameRessources.swadow_botleft, 0, getHeight() - 10, null);
	gr.drawImage(FrameRessources.swadow_botright, getWidth() - 10,
		getHeight() - 10, null);
	for (int i = 10; i < getHeight() - 10; ++i) {
	    gr.drawImage(FrameRessources.swadow_left, 0, i, null);
	    gr.drawImage(FrameRessources.swadow_right, getWidth() - 10, i, null);
	}

	gr.setColor(Color.WHITE);
	gr.fillRect(39, 10, getWidth() - 107, 20);

	gr.drawImage(
		(isMouseInside && mouseY < 30 && mouseX > getWidth() - 39
			&& mouseY > 10 && mouseX < getWidth() - 10) ? FrameRessources.close_active
			: FrameRessources.close, getWidth() - 39, 10, null);
	gr.drawImage(
		(isMouseInside && mouseY < 30 && mouseY > 10 && mouseX < 39 && mouseX > 10) ? FrameRessources.controls_active
			: FrameRessources.controls, 10, 10, null);
	gr.drawImage(
		(isMouseInside && mouseY < 30 && mouseY > 10
			&& mouseX > getWidth() - 68 && mouseX < getWidth() - 39) ? FrameRessources.minimize_active
			: FrameRessources.minimize, getWidth() - 68, 10, null);

	gr.setColor(Color.GRAY);
	gr.drawString("Les Chroniques de Norwand", 45, 25);

	try {
	    gr.drawImage(parent.game.getFrame(), 10, 30, getWidth() - 20,
		    getHeight() - 40, null);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	gr.dispose();
    }

    @Override
    public void update(Graphics gr) {
	this.repaint();
    }
}
