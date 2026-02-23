package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.scene.image.Image;
/**
 * Represents an obstacle in the game.
 */
public class Obstacle extends Actor {
	public int speed;

	/**
	 * Moves the obstacle and resets its position if out of bounds.
	 * @param now current timestamp
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	/**
	 * Constructs a Log object.
	 * @param imageLink image path
	 * @param xpos      x-coordinate
	 * @param ypos      y-coordinate
	 * @param s         speed
	 * @param w         width
	 * @param h         height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
