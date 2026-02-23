package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurtleTest {


    private Turtle turtle;

    @BeforeAll
    static void initJavaFX() {
        //Initialize JavaFX runtime
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    void setUp() {
        //Initialize a Turtle object
        turtle = new Turtle(100, 200, 2, 130, 130);
    }

    //Make sure the turtle moves
    @Test
    void testTurtleMovement() {
        double initialX = turtle.getX();
        turtle.act(System.currentTimeMillis());
        assertEquals(initialX + turtle.speed, turtle.getX());
    }

    //Make sure that the turtle can go in both directions and return back to its original position
    @Test
    void testTurtleLoopingRightToLeft() {
        turtle.setX(650);
        turtle.speed = 2;
        turtle.act(System.currentTimeMillis());
        assertEquals(-200, turtle.getX());
    }

    @Test
    void testTurtleLoopingLeftToRight() {
        turtle.setX(-100);
        turtle.speed = -2;
        turtle.act(System.currentTimeMillis());
        assertEquals(600, turtle.getX());
    }
}
