package uk.ac.nott.cs.comp2013.froggerApp.controller;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.ac.nott.cs.comp2013.froggerApp.model.MyStage;
import uk.ac.nott.cs.comp2013.froggerApp.model.digit;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private MyStage background;
    private Main main;

    @BeforeAll
    static void initJavaFX() {
        //Initialize JavaFX runtime
        Platform.startup(() -> {});
    }

    @Test
    void testSetNumber() {
        background = new MyStage();
        main = new Main();
        main.background = background;
        int number = 123;
        main.setNumber(number);

        digit digit1 = background.getObjects(digit.class).get(0);
        digit digit2 = background.getObjects(digit.class).get(1);
        digit digit3 = background.getObjects(digit.class).get(2);
        
        assertEquals(3, background.getObjects(digit.class).size());
        assertTrue(digit1.getImage().getUrl().endsWith("/3.png"));
        assertTrue(digit2.getImage().getUrl().endsWith("/2.png"));
        assertTrue(digit3.getImage().getUrl().endsWith("/1.png"));
    }
}
