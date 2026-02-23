package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.scene.image.Image;

/**
 * Represents the endpoint in the game.
 */
public class End extends Actor{
	boolean activated = false;
	private boolean resetHandled = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	/**
	 * Constructs an End object.
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("/End.png", 60, 60, true, true));
	}

	/**
	 * Marks the endpoint as activated.
	 */
	public void setEnd() {
		setImage(new Image("/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * Checks if the endpoint is activated.
	 * @return true if activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Checks if reset handling is complete.
	 * @return true if reset is handled
	 */
	public boolean checkReset() {
		return resetHandled;
	}

	/**
	 * Marks the reset as handled.
	 */
	public void setReset() {
		resetHandled = true;
	}

}
