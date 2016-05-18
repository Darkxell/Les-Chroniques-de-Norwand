package com.norwand.game.management.music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicHolder {
    public static Music currentMusic;

    public static void switchBGM(String pathToSet){
        if (currentMusic != null) {
            currentMusic.stop();
            currentMusic.dispose();
        }
        try {
            currentMusic = Gdx.audio.newMusic(Gdx.files.internal(pathToSet));
            currentMusic.play();
        } catch (Exception e) {
            System.err.println("Error chargement musique : ");
            e.printStackTrace();
        }
    }
}
