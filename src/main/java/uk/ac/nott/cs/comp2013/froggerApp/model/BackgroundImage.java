package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor {

	@Override
	public void act(long now) {
		
		
	}
	/**
	 * Background image set
	 * @param imageLink link
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
