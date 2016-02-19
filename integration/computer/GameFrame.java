package integration.computer;

import java.awt.Color;

import integration.MainGame;

import javax.swing.JFrame;

/** A custom Frame that holds the game. */
public class GameFrame {

    public MainGame game;
    
    public static final int DEFAULT_WIDTH = 740;
    public static final int DEFAULT_HEIGHT = 520;

    private JFrame frame;
    private GameCanvas canvas;

    /** Creates a new GameFrame object. */
    public GameFrame(MainGame g) {
	game = g;
	this.frame = new JFrame("Les chroniques de Norwand");
	this.frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	this.frame.setUndecorated(true);
	this.frame.setLocationRelativeTo(null);
	this.frame.setBackground(new Color(0,0,0,0));
	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// this.frame.setIconImage();

	this.frame.setVisible(true);

	this.canvas = new GameCanvas(this);
	this.canvas.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	this.frame.setContentPane(this.canvas);

    }

    /** Gets the GameCanvas Object. */
    public GameCanvas getCanvas() {
	return this.canvas;
    }

    /**
     * Moves the frame to the specified X and Y coordinates on your screen. The
     * x and Y coordinates are the top left corner.
     */
    public void moveTo(int x, int y) {
	this.frame.setLocation(x, y);
    }

    public void minimize() {
	frame.setState(JFrame.ICONIFIED);
    }

    /**
     * Changes the size of the frame the the desired value. This method changes
     * the size of the frame, the inner canvas and the shadows.
     */
    public void changeSize(int width, int height) {
	this.frame.setSize(width, height);
	this.canvas.setSize(width, height);
    }
}
