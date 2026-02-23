package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.scene.image.Image;
/**
 * Represents a moving log in the game.
 */
public class Log extends Actor {
	/**
	 * Moves the log and resets its position if out of bounds.
	 * @param now current timestamp
	 */
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	/**
	 * Constructs a Log object.
	 * @param imageLink image path
	 * @param size      log size
	 * @param xpos      x-coordinate
	 * @param ypos      y-coordinate
	 * @param s         speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
