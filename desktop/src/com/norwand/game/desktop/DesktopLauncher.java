package com.norwand.game.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.norwand.game.MainGame;

/** The main launcher for the desktop application. */
public class DesktopLauncher {

    public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	config.title = "Les Chroniques de Norwand";
	config.addIcon("assets/textures/gui/icon.png", FileType.Internal);
	@SuppressWarnings("unused")
	LwjglApplication app = new LwjglApplication(new MainGame("assets/"),
		config);
    }

}