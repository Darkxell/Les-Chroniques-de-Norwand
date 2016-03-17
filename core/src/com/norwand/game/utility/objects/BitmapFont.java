package com.norwand.game.utility.objects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Disposable;
import com.norwand.game.utility.PixmapUtility;

/**
 * Represents a font using textures. All of the letters are inside 8*8 Pixmap
 * objects.
 */
public class BitmapFont implements Disposable {

    private Pixmap[] caracters;

    /** The length in pixels of the space caracter. */
    public static final int SPACELENGTH = 4;

    /** Constructs a new BitmapFont using the letters pixmap. */
    public BitmapFont(Pixmap source) {
	int width = source.getWidth() / 8, height = source.getHeight() / 8;
	caracters = new Pixmap[height * width];
	for (int i = 0; i < width; i++)
	    for (int j = 0; j < height; j++)
		try {
		    caracters[i + j * width] = PixmapUtility.getPixmapPart(
			    source, i * 8, j * 8, 8, 8);
		} catch (Exception e) {
		    e.printStackTrace();
		}
    }

    @Override
    public void dispose() {
	for (int i = 0; i < caracters.length; i++) {
	    try {
		caracters[i].dispose();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    /** Gets the length in pixels of the given string using this font. */
    public int getLength(String s) {
	int length = 0;
	for (int i = 0; i < s.length(); i++)
	    if (s.charAt(i) == ' ')
		length += SPACELENGTH;
	    else
		length += 8;
	return length;
    }

    /**
     * Prints the wanted String at the wanted coordonates on the support using
     * this bitmapfont.
     */
    public void printStringOn(Pixmap support, String towrite, int x, int y) {
	int offset = 0;
	for (int i = 0; i < towrite.length(); i++) {
	    if (towrite.charAt(i) == ' ')
		offset += SPACELENGTH;
	    else {
		support.drawPixmap(getChar(towrite.charAt(i)), x + offset, y);
		offset += 8;
	    }
	}
    }

    /** Gets a 8*8 pixmap representing this character. */
    public Pixmap getChar(char c) {
	return caracters[convertChar(c)];
    }

    /**
     * Converts this char to the ID of the wanted character. If no id is found
     * for this char, returns the pixel checkerboard.
     */
    public static int convertChar(char toconvert) {
	switch (toconvert) {
	case 'A':
	    return 0;
	case 'B':
	    return 1;
	case 'C':
	    return 2;
	case 'D':
	    return 3;
	case 'E':
	    return 4;
	case 'F':
	    return 5;
	case 'G':
	    return 6;
	case 'H':
	    return 7;
	case 'I':
	    return 8;
	case 'J':
	    return 9;
	case 'K':
	    return 10;
	case 'L':
	    return 11;
	case 'M':
	    return 12;
	case 'N':
	    return 13;
	case 'O':
	    return 14;
	case 'P':
	    return 15;
	case 'Q':
	    return 16;
	case 'R':
	    return 17;
	case 'S':
	    return 18;
	case 'T':
	    return 19;
	case 'U':
	    return 20;
	case 'V':
	    return 21;
	case 'W':
	    return 22;
	case 'X':
	    return 23;
	case 'Y':
	    return 24;
	case 'Z':
	    return 25;
	case 'a':
	    return 26;
	case 'b':
	    return 27;
	case 'c':
	    return 28;
	case 'd':
	    return 29;
	case 'e':
	    return 30;
	case 'f':
	    return 31;
	case 'g':
	    return 32;
	case 'h':
	    return 33;
	case 'i':
	    return 34;
	case 'j':
	    return 35;
	case 'k':
	    return 36;
	case 'l':
	    return 37;
	case 'm':
	    return 38;
	case 'n':
	    return 39;
	case 'o':
	    return 40;
	case 'p':
	    return 41;
	case 'q':
	    return 42;
	case 'r':
	    return 43;
	case 's':
	    return 44;
	case 't':
	    return 45;
	case 'u':
	    return 46;
	case 'v':
	    return 47;
	case 'w':
	    return 48;
	case 'x':
	    return 49;
	case 'y':
	    return 50;
	case 'z':
	    return 51;
	case '1':
	    return 52;
	case '2':
	    return 53;
	case '3':
	    return 54;
	case '4':
	    return 55;
	case '5':
	    return 56;
	case '6':
	    return 57;
	case '7':
	    return 58;
	case '8':
	    return 59;
	case '9':
	    return 60;
	case '0':
	    return 61;
	case '/':
	    return 62;
	case '*':
	    return 63;
	case '-':
	    return 64;
	case '+':
	    return 65;
	case '.':
	    return 66;
	case ',':
	    return 67;
	case ';':
	    return 68;
	case ':':
	    return 69;
	case '^':
	    return 70;
	case '¨':
	    return 71;
	case '%':
	    return 72;
	case '?':
	    return 73;
	case '!':
	    return 74;
	case '§':
	    return 75;
	case '$':
	    return 76;
	case '€':
	    return 77;
	case '(':
	    return 78;
	case ')':
	    return 79;
	case '[':
	    return 80;
	case ']':
	    return 81;
	case '{':
	    return 82;
	case '}':
	    return 83;
	case '\\':
	    return 84;
	case '&':
	    return 85;
	case '²':
	    return 86;
	case '"':
	    return 87;
	case '\'':
	    return 88;
	case '|':
	    return 89;
	case '°':
	    return 90;
	case '=':
	    return 91;
	case '<':
	    return 92;
	case '>':
	    return 93;
	case '£':
	    return 94;
	case '¤':
	    return 95;
	case 'µ':
	    return 100;
	case '\n':
	    return 101;
	case '#':
	    return 102;
	case 'é':
	    return 104;
	case 'è':
	    return 105;
	case 'à':
	    return 106;
	case 'ê':
	    return 107;
	case 'ë':
	    return 108;
	case 'ô':
	    return 109;
	case 'ö':
	    return 110;
	case 'ç':
	    return 111;
	case 'î':
	    return 112;
	case 'ï':
	    return 113;
	case 'û':
	    return 114;
	case 'ù':
	    return 115;
	case 'â':
	    return 116;
	default:
	    return 103;
	}
    }
}
