package com.norwand.game.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.norwand.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Les Chroniques de Norwand";
		config.addIcon("desktop/assets/textures/gui/icon.png", FileType.Internal);
		@SuppressWarnings("unused")
		LwjglApplication app = new LwjglApplication(new MainGame("desktop/assets/"), config);
	}
}
