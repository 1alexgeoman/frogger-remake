package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitTest {

    @BeforeAll
    static void initJavaFX() {
        //Initialize JavaFX runtime
        Platform.startup(() -> {
        });
    }

    //Make sure the right digit is displayed
    @Test
    void testDigitRendering() {
        digit digit = new digit(5, 50, 100, 200);

        Image actualImage = digit.getImage();
        double actualX = digit.getX();
        double actualY = digit.getY();

        assertNotNull(actualImage);
        assertTrue(actualImage.getUrl().endsWith("/5.png"));
        assertEquals(100, actualX);
        assertEquals(200, actualY);
    }
}
