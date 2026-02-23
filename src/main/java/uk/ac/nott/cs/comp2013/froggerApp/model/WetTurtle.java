package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.scene.image.Image;
/**
 * Represents a moving turtle in the game.
 */
public class WetTurtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;

	/**
	 * Animates the wetTurtle and moves it across the screen.
	 * @param now current timestamp
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/**
	 * Constructs a wetTurtle object.
	 * @param xpos x-coordinate
	 * @param ypos y-coordinate
	 * @param s    speed
	 * @param w    width
	 * @param h    height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("TurtleAnimation1.png", h, w, true, true);
		turtle2 = new Image("TurtleAnimation2Wet.png", h, w, true, true);
		turtle3 = new Image("TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
