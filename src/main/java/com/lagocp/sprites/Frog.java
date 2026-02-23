package com.lagocp.sprites;


import com.lagocp.gameEngine.sprite.Sprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Frog extends Sprite {
    /**
     * Constructs a Frog object with specified attributes.
     *
     * @param x      the x-coordinate of the frog
     * @param y      the y-coordinate of the frog
     * @param width  the width of the frog
     * @param height the height of the frog
     * @param gc     the GraphicsContext used to render the frog
     */
    public Frog(double x, double y, double width, double height, GraphicsContext gc) {
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
