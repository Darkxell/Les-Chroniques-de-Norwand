package com.norwand.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.norwand.game.management.UserEvent;
import com.norwand.game.management.gamestates.GameState;
import com.norwand.game.management.gamestates.top.TopState;
import com.norwand.game.resources.ImagesHolder;
import com.norwand.game.utility.objects.FramesCounter;

/** The maingame object. */
public class MainGame extends ApplicationAdapter implements InputProcessor {

    /** Static pointer to the last constructed MainGame object. */
    public static MainGame game;

    /** Constructs a maingame object with the assets path. */
    public MainGame(String assetsPath) {
	super();
	MainGame.ASSETSPATH = assetsPath;
	game = this;
    }

    /**
     * The path of the game assets. THis is a static variable that is changed
     * each time you create a new MainGame object with a different assets path.
     */
    public static String ASSETSPATH;
    /**
     * Should be a TopState anyways. If you don't understand this, refer to the
     * pattern Strategy for GameStates and see <code>GameState</code>
     * documentation.
     */
    public GameState state;

    @Override
    public void create() {
	widthbackup = Gdx.graphics.getWidth();
	heightbackup = Gdx.graphics.getHeight();
	Gdx.input.setInputProcessor(this);
	Pixmap.setFilter(Pixmap.Filter.NearestNeighbour);
	state = new TopState();
	Thread updater = new Thread(new Runnable() {
	    @Override
	    public void run() {
		long milistart = System.currentTimeMillis();
		int frame = 0;
		for (;;) {
		    while (milistart + (frame * 20) > System
			    .currentTimeMillis()) {
			try {
			    Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		    }
		    ++frame;
		    try {
			if (SHOWUPS) {
			    if (ups == null)
				ups = new FramesCounter();
			    System.out.println("UPS counter : " + ups.calcFPS()
				    + "/sec");
			}
			update();
		    } catch (Exception e) {
			System.err
				.println("Couldn't update the gameData.\nLogs :");
			e.printStackTrace();
		    }
		}
	    }
	});
	ImagesHolder.create(ASSETSPATH);
	updater.start();
    }

    /**
     * The spritebatch used to draw on the application. This is locally stored
     * and changed each time the app changes in size.
     */
    SpriteBatch batch = null;
    /**
     * Backup of the used pixmap to draw on the batch. This is locally stored so
     * it tries to always be in the same memoryheap zone.
     */
    Pixmap pbackup = null;
    /** The width of the application. */
    private int widthbackup;
    /** The height of the application. */
    private int heightbackup;
    /** Fps counter. */
    private FramesCounter fps;
    /** Ups counter. */
    private FramesCounter ups;
    private static final boolean SHOWFPS = false;
    private static final boolean SHOWUPS = false;

    @Override
    public void render() {
	if (SHOWFPS) {
	    if (fps == null)
		fps = new FramesCounter();
	    System.out.println("FPS : " + fps.calcFPS() + "/sec");
	}
	if (batch == null) {
	    batch = new SpriteBatch(1);
	    pbackup = new Pixmap(240, 240 * Gdx.graphics.getHeight()
		    / Gdx.graphics.getWidth(), Pixmap.Format.RGB888);
	}
	if (widthbackup != Gdx.graphics.getWidth()
		|| heightbackup != Gdx.graphics.getHeight()) {
	    batch.dispose();
	    batch = new SpriteBatch(1);
	    pbackup.dispose();
	    pbackup = new Pixmap(240, 240 * Gdx.graphics.getHeight()
		    / Gdx.graphics.getWidth(), Pixmap.Format.RGB888);
	    widthbackup = Gdx.graphics.getWidth();
	    heightbackup = Gdx.graphics.getHeight();
	}
	pbackup.setColor(Color.BLACK);
	pbackup.fill();
	try {
	    state.print(pbackup);
	} catch (Exception e) {
	    System.err
		    .println("Could not print the current state to the buffer for some reasons.\nLogs :");
	    e.printStackTrace();
	}
	Texture t = new Texture(pbackup);
	batch.begin();
	batch.draw(t, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	batch.end();
	t.dispose();
    }

    /**
     * Method called 50 times a second by an internal thread. <br/>
     * updates this game to its next frame.
     */
    private void update() {
	this.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	state.update();
    }

    @Override
    public boolean keyDown(int keycode) {
	try {
	    state.onKeyPressed(new UserEvent(keycode));
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}

    }

    @Override
    public boolean keyUp(int keycode) {
	try {
	    state.onKeyReleased(new UserEvent(keycode));
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public boolean keyTyped(char character) {
	try {
	    state.onType(new UserEvent(character));
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	try {
	    state.onPress(new UserEvent(button, scaleXdown(screenX),
		    scaleYdown(screenY)));
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	try {
	    state.onRelease(new UserEvent(button, scaleXdown(screenX),
		    scaleYdown(screenY)));
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
	try {
	    state.onDrag(new UserEvent(scaleXdown(screenX), scaleYdown(screenY)));
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
	return true; // unused
    }

    @Override
    public boolean scrolled(int amount) {
	return true; // unused
    }

    /**
     * Return the X position of a point on the buffer given the position of a
     * point in the screen.
     */
    private int scaleXdown(int x) {
	return x * 240 / Gdx.graphics.getWidth();
    }

    /**
     * Return the Y position of a point on the buffer given the position of a
     * point in the screen.
     */
    private int scaleYdown(int y) {
	return y * 240 / Gdx.graphics.getWidth();
	// Maths here. Yes it works.
    }

    /** Returns the buffer height. Buffer width is ALWAYS 240. */
    public static int getBufferHeight() {
	return 240 * Gdx.graphics.getHeight() / Gdx.graphics.getWidth();
    }
}
