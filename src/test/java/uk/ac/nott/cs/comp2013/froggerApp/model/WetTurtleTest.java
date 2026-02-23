package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WetTurtleTest {

    private WetTurtle wetTurtle;

    @BeforeAll
    static void initJavaFX() {
        //Initialize JavaFX runtime
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    void setUp() {
        //Initialize a Turtle object
        wetTurtle = new WetTurtle(100, 200, 2, 130, 130);
    }

    //Make sure the turtle moves
    @Test
    void testWetTurtleMovement() {
        double initialX = wetTurtle.getX();
        wetTurtle.act(System.currentTimeMillis());
        assertEquals(initialX + wetTurtle.speed, wetTurtle.getX());
    }

    //Make sure that the turtle can go in both directions and return back to its original position
    @Test
    void testWetTurtleLoopingRightToLeft() {
        wetTurtle.setX(650);
        wetTurtle.speed = 2;
        wetTurtle.act(System.currentTimeMillis());
        assertEquals(-200, wetTurtle.getX());
    }

    @Test
    void testWetTurtleLoopingLeftToRight() {
        wetTurtle.setX(-100);
        wetTurtle.speed = -2;
        wetTurtle.act(System.currentTimeMillis());
        assertEquals(600, wetTurtle.getX());
    }

    //Test sinking behavior make sure that it reports its state correctly
    @Test
    void testSinkingBehavior() {
        long now = System.currentTimeMillis();
        wetTurtle.act(now + (900000000 * 3)); //Time when state is sunk
        assertTrue(wetTurtle.isSunk());

        wetTurtle.act(now + (900000000 * 4)); //Time when state is not sunk
        assertFalse(wetTurtle.isSunk());
    }
}
