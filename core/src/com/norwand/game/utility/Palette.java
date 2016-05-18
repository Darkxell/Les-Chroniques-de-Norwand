package com.norwand.game.utility;

import com.badlogic.gdx.graphics.Color;

/** Palette that holds the 16 default color objects. */
public abstract class Palette {

    public static final Color DARKBLUE = newColor(20, 12, 28);
    public static final Color PURPLE = newColor(69, 36, 52);
    public static final Color BLUE = newColor(48, 52, 109);
    public static final Color DARKGREY = newColor(77, 73, 77);
    public static final Color BROWN = newColor(134, 77, 48);
    public static final Color DARKGREEN = newColor(52, 101, 36);
    public static final Color RED = newColor(211, 69, 73);
    public static final Color LIGHTGREY = newColor(117, 113, 97);
    public static final Color LIGHTBLUE = newColor(89, 125, 207);
    public static final Color ORANGE = newColor(211, 125, 44);
    public static final Color BABYBLUE = newColor(134, 150, 162);
    public static final Color GREEN = newColor(109, 170, 44);
    public static final Color LIGHTPINK = newColor(211, 170, 154);
    public static final Color TURQUOISE = newColor(108, 194, 203);
    public static final Color YELLOW = newColor(219, 215, 93);
    public static final Color SNOWWHITE = newColor(223, 239, 215);

    /**
     * Creates a new instance of color object using the RGB values wanted.<br/>
     * The values should be in 0-255 range, alpha is by default 255.
     */
    public static Color newColor(int r, int g, int b) {
	return new Color(((float) (r)) / 255f, ((float) (g)) / 255f,
		((float) (b)) / 255f, 1);
    }
	
	/**
     * Creates a new instance of color object using the RGBA values wanted.<br/>
     * The values should be in 0-255 range.
     */
    public static Color newColorAlpha(int r, int g, int b, int a) {
	return new Color(((float) (r)) / 255f, ((float) (g)) / 255f,
		((float) (b)) / 255f, ((float) (a)) / 255f);
    }
}
