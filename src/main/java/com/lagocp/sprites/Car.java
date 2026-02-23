package com.lagocp.sprites;

import com.lagocp.gameEngine.sprite.Sprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Car extends Sprite {
    /**
     * Constructs a Car object with specified attributes.
     *
     * @param x      the x-coordinate of the car
     * @param y      the y-coordinate of the car
     * @param width  the width of the car
     * @param height the height of the car
     * @param gc     the GraphicsContext used to render the car
     */
    public Car(double x, double y, double width, double height, GraphicsContext gc) {
        super(x, y, width, height, gc);
    }

    @Override
    public boolean didCollideWith(Sprite other) {
        return false;
    }

    @Override
    public boolean didCollideWithTopWall(Canvas canvas) {
        return false;
    }

    @Override
    public boolean didCollideWithBotWall(Canvas canvas) {
        return false;
    }

    @Override
    public boolean didCollideWithLeftWall(Canvas canvas) {
        return false;
    }

    @Override
    public boolean didCollideWithRightWall(Canvas canvas) {
        return false;
    }

    @Override
    public void render(GraphicsContext gc) {

    }
}
