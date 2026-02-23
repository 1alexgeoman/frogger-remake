package uk.ac.nott.cs.comp2013.froggerApp.controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import uk.ac.nott.cs.comp2013.froggerApp.model.*;

/**
 * Main class for FroggerApp.
 */
public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	private Label timerLabel;
	private long remainingTime;

	public static void main(String[] args) {
		launch(args);
	}

	@Override

	/**
	 * Starts the application.
	 *
	 * @param primaryStage primary stage
	 */
	public void start(Stage primaryStage) throws Exception {
	    setupBackground(primaryStage);
		addItems();
		background.start();
		primaryStage.show();
		start();  
	}
	/**
	 * Adds game items to background.
	 */
	private void addItems(){
		background.add(new Log("/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("/log3.png", 150, 440, 166, 0.75));
		background.add(new Log("/logs.png", 300, 0, 276, -2));
		background.add(new Log("/logs.png", 300, 400, 276, -2));
		background.add(new Log("/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("/log3.png", 150, 490, 329, 0.75));

		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));

		animal = new Animal("/froggerUp.png");
		background.add(animal);
		background.add(new Obstacle("/truck1Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("/truck1Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("/truck1Right.png", 600, 649, 1, 120, 120));
		background.add(new Obstacle("/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("/car1Left.png", 500, 490, -5, 50, 50));
		background.add(new digit(0, 30, 475, 760));
	}
	private void setupBackground(Stage primaryStage){
		background = new MyStage();
		BackgroundImage froggerback = new BackgroundImage("/iKogsKW.png");
		background.add(froggerback);
		double imageWidth = froggerback.getWidth();
		double imageHeight = froggerback.getHeight();
		Scene scene  = new Scene(background,imageWidth,imageHeight);
		primaryStage.setScene(scene);

		timerLabel = new Label("Time: 20s");
		timerLabel.setStyle("-fx-font-size: 27; -fx-text-fill: RED; -fx-font-family:Impact;");
		timerLabel.setLayoutX(imageWidth/2 - 50);
		timerLabel.setLayoutY(760);
		background.getChildren().add(timerLabel);
		remainingTime = 20;

	}
	/**
	 * Creates and starts the game timer.
	 */
	public void createTimer() {
		final long[] startTime = {System.currentTimeMillis()};
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
				int elapsedSeconds = (int) ((System.currentTimeMillis() - startTime[0]) / 1000);
				int newRemainingTime = 20 - elapsedSeconds;
				if (newRemainingTime != remainingTime) {
					remainingTime = newRemainingTime;
					timerLabel.setText("Time: " + remainingTime + "s");
					if (remainingTime <= 0) {
						stopGame("You Have Lost The Game!", "Time ran out!");
					}
				}
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
				for (End end : background.getObjects(End.class)) {
					if (end.isActivated() && !end.checkReset()) {
						remainingTime = 20;
						startTime[0] = System.currentTimeMillis();
						timerLabel.setText("Time: " + remainingTime + "s");
						end.setReset();
					}
				}

				displayLives();
            	if (animal.getStop()) {
            		stopGame("You have won the game!", "Your High Score: "+animal.getPoints()+"!");
            	}
				if (animal.getLives() ==0){
					stopGame("You ran out of lives", "Your Final Score was: "+animal.getPoints());
				}
            }
        };
    }
	/**
	 * Stops the game and shows alert.
	 *
	 * @param title   title for alert box
	 * @param message alert message
	 */
	private void stopGame(String title, String message) {
		background.stopMusic();
		stop();
		background.stop();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(message);
		alert.setContentText("Highest Possible Score: 800");
		alert.show();
	}
	/**
	 * Starts the game.
	 */
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }
	/**
	 * Stops the game timer.
	 */
    public void stop() {
        timer.stop();
    }

	/**
	 * Updates score display.
	 *
	 * @param score current score
	 */
    public void setNumber(int score) {
		background.getChildren().removeIf(node -> node instanceof digit);
		if (score < 0) {
			score = -score;
		}

		int shift = 0;
		do {
			int lastDigit = score % 10;
			background.add(new digit(lastDigit, 30, 475 - shift, 760));
			score = score / 10;
			shift += 30;
		} while (score > 0);
	}

	/**
	 * Displays remaining lives.
	 */
	private void displayLives() {
		background.getChildren().removeIf(node -> node instanceof ImageView && "heart".equals(node.getId()));
		for (int i = 0; i < animal.getLives(); i++) {
			ImageView heart = new ImageView(new Image("/heart.png", 30, 30, true, true));
			heart.setId("heart");
			heart.setX(10 + i * 35);
			heart.setY(760);
			background.getChildren().add(heart);
		}
	}
}
