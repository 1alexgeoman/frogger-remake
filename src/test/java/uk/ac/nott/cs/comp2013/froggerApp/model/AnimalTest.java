package uk.ac.nott.cs.comp2013.froggerApp.model;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.input.KeyEvent;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;



class AnimalTest {

    private Animal animal;

    @BeforeAll
    static void initJavaFX() {
        //Initialize JavaFX runtime
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    void setUp() {
        //Set up the Animal with an example image
        animal = new Animal("/froggerUp.png");
    }

    //Simulate movement and assert the changing of their images
    @Test
    void testMovementUp() {
        double initialY = animal.getY();
        //Simulate pressing the W key
        KeyEvent keyPress = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.W, false, false, false, false);
        animal.getOnKeyPressed().handle(keyPress);

        //Verify movement up
        assertEquals(initialY - 26.6, animal.getY());

        //Verify correct image is displayed
        Image expectedImage = new Image("/froggerUpJump.png");
        assertEquals(expectedImage.getUrl(), animal.getImage().getUrl());
    }

    @Test
    void testMovementLeft() {
        double initialX = animal.getX();
        //Simulate pressing the A key
        KeyEvent keyPress = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.A, false, false, false, false);
        animal.getOnKeyPressed().handle(keyPress);

        //Verify movement left
        assertEquals(initialX - 21.2, animal.getX());

        //Verify correct image is displayed
        Image expectedImage = new Image("/froggerLeftJump.png");
        assertEquals(expectedImage.getUrl(), animal.getImage().getUrl());
    }

    @Test
    void testMovementDown() {//Don't move down this one because the frog is already at the bottom of the map, just verify the image
        double initialY = animal.getY();
        //Simulate pressing the S key
        KeyEvent keyPress = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.S, false, false, false, false);
        animal.getOnKeyPressed().handle(keyPress);

        //Verify correct image is displayed
        Image expectedImage = new Image("/froggerDownJump.png");
        assertEquals(expectedImage.getUrl(), animal.getImage().getUrl());
    }

    @Test
    void testMovementRight() {
        double initialX = animal.getX();
        //Simulate pressing the D key
        KeyEvent keyPress = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.D, false, false, false, false);
        animal.getOnKeyPressed().handle(keyPress);

        //Verify movement right
        assertEquals(initialX + 21.2, animal.getX());

        //Verify correct image is displayed
        Image expectedImage = new Image("/froggerRightJump.png");
        assertEquals(expectedImage.getUrl(), animal.getImage().getUrl());
    }

    //Test collison with vehicle
    @Test
    void testCollision() {
        //Set initial position
        int initialXY = 100;
        animal.setY(initialXY);
        animal.setX(initialXY);
        Obstacle obstacle = new Obstacle("/truck1Right.png", initialXY, initialXY, 1, 120, 120);

        MyStage testStage = new MyStage();
        testStage.add(animal);
        testStage.add(obstacle);

        //Call act and check the car death is set to true
        animal.act(System.currentTimeMillis());
        assertTrue(animal.isCarDeath());
    }

    @Test
    void testWaterCollision() {
        //Set the position of the frog to just above the water
        int initialY = 450;
        animal.setY(initialY);
        animal.setX(100);

        //Add the animal to my test environment
        MyStage testStage = new MyStage();
        testStage.add(animal);

        //Simulate the frog moving into the water and then call act to see if the water-death works
        animal.move(0, -50);
        animal.act(System.currentTimeMillis());
        System.out.println((animal.getY()));
        assertTrue(animal.isWaterDeath());

    }
}