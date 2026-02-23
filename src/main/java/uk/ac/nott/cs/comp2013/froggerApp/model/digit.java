package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.scene.image.Image;

/**
 * Represents a digit displayed in the game.
 */
public class digit extends Actor{
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Constructs a digit object.
	 * @param n   the number to display
	 * @param dim the size of the digit
	 * @param x   the x-coordinate
	 * @param y   the y-coordinate
	 */
	public digit(int n, int dim, int x, int y) {
		im1 = new Image("/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
