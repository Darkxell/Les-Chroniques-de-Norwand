package integration.computer;

import integration.MainGame;

/** The launchable class for the computer integration. */
public class LesChroniquesDeNorwand {

    /** Launches the game in a Custom JFrame object to be played on a computer. */
    public static void main(String[] args) {
	GameFrame frame = new GameFrame(new MainGame());
	Thread t = new Thread(new Runnable() {
	    @Override
	    public void run() {
		long milistart = System.currentTimeMillis();
		int cframe = 0;
		for (;;) {
		    while (milistart + (cframe * 20) > System
			    .currentTimeMillis()) {
			try {
			    Thread.sleep(2);
			} catch (InterruptedException e) {
			}
		    }
		    ++cframe;
		    try {
			frame.getCanvas().update(null);// DRAW
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    try {
			frame.game.update();// UPDATE
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    }
	});
	t.start();
    }

}
