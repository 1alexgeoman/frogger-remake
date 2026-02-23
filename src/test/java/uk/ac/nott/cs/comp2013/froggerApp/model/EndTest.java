package uk.ac.nott.cs.comp2013.froggerApp.model;
import javafx.application.Platform;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EndTest {
    private End end;

    @BeforeAll
    static void initJavaFX() {
        //Initialize JavaFX runtime
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    void setUp() {
        //Initialize the End object
        end = new End(0,0);
    }

    //Call set end and then check the image has been changed and that end is activated
    @Test
    void testSetEnd() {
        end.setEnd();
        Image expectedImage = new Image("/FrogEnd.png");
        assertEquals(expectedImage.getUrl(), end.getImage().getUrl());
        assertTrue(end.isActivated());
    }

    //Call set end and then check that if it's been called once it can't be called again (second frog can't come to the end zone)
    @Test
    void testSingleActivation() {
        end.setEnd();
        boolean activatedAgain = false;
        if (!end.isActivated()) {
            end.setEnd();
            activatedAgain = true;
        }
        assertTrue(end.isActivated());
        assertFalse(activatedAgain);
    }

}
