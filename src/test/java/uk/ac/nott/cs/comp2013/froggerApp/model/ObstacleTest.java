package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObstacleTest {

    private Obstacle obstacle;

    @BeforeAll
    static void initJavaFX() {
        // Initialize JavaFX runtime
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    void setUp() {
        // Initialize an Obstacle object
        obstacle = new Obstacle("/truck1Right.png", 100, 200, 2, 120, 120);
    }

    // Test obstacle movement
    @Test
    void testObstacleMovement() {
        double initialX = obstacle.getX();
        obstacle.act(System.currentTimeMillis());
        assertEquals(initialX + obstacle.speed, obstacle.getX());
    }

    //Make sure that the obstacle can go in both directions and return back to its original position
    @Test
    void testObstacleLoopingRightToLeft() {
        obstacle.setX(650);
        obstacle.speed = 2;
        obstacle.act(System.currentTimeMillis());
        assertEquals(-200, obstacle.getX());
    }
    @Test
    void testObstacleLoopingLeftToRight() {
        obstacle.setX(-100);
        obstacle.speed = -2;
        obstacle.act(System.currentTimeMillis());
        assertEquals(600, obstacle.getX());
    }
}