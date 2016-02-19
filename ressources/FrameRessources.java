package ressources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** Holds the ressources for the frame. */
public class FrameRessources {

    // TODO : find something else that fits for group work.
    private static final String FOLDERPATH = "C:\\Users\\Darkxell_mc\\workspace\\Les Chroniques de Norwand\\src\\res\\";

    /** Gets a BufferedImage object from a image file filepath. */
    public static BufferedImage readfile(String filepath) {
	try {
	    BufferedImage start = ImageIO.read(new File(filepath));
	    return start;
	} catch (IOException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    private static BufferedImage icons = readfile(FOLDERPATH
	    + "textures\\frame\\frameicons.png");
    private static BufferedImage shadows = readfile(FOLDERPATH
	    + "textures\\frame\\frameshadow.png");

    public static BufferedImage swadow_topleft = shadows.getSubimage(0, 0, 10,
	    10);
    public static BufferedImage swadow_topright = shadows.getSubimage(11, 0,
	    10, 10);
    public static BufferedImage swadow_botleft = shadows.getSubimage(0, 11, 10,
	    10);
    public static BufferedImage swadow_botright = shadows.getSubimage(11, 11,
	    10, 10);

    public static BufferedImage swadow_bot = shadows.getSubimage(11, 11, 1, 10);
    public static BufferedImage swadow_top = shadows.getSubimage(22, 0, 1, 10);
    public static BufferedImage swadow_left = shadows.getSubimage(0, 22, 10, 1);
    public static BufferedImage swadow_right = shadows.getSubimage(11, 22, 10,
	    1);

    public static BufferedImage close = icons.getSubimage(0, 0, 29, 20);
    public static BufferedImage close_active = icons.getSubimage(30, 0, 29, 20);
    public static BufferedImage minimize = icons.getSubimage(0, 21, 29, 20);
    public static BufferedImage minimize_active = icons.getSubimage(30, 21, 29,
	    20);
    public static BufferedImage controls = icons.getSubimage(0, 42, 29, 20);
    public static BufferedImage controls_active = icons.getSubimage(30, 42, 29,
	    20);
}
