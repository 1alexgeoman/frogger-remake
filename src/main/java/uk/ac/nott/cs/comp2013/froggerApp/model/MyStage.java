package uk.ac.nott.cs.comp2013.froggerApp.model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * Represents the game stage with music functionality.
 */
public class MyStage extends World {
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
	}
	/**
	 * Plays background music.
	 */
	public void playMusic() {
		String musicFile = "src/main/resources/Snake_Charmer.mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	/**
	 * Stops background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
