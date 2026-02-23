package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    private TestActor actor;
    private final TestActor overlappingActor1 = new TestActor();
    private final TestActor overlappingActor2 = new TestActor();
    private final TestActor nonOverlappingActor = new TestActor();

    @BeforeAll
    static void initJavaFX() {
        //Initialize JavaFX runtime
        Platform.startup(() -> {});
    }

    @BeforeEach
    void setUp() {
        World world = new TestWorld();
        actor = new TestActor();
        world.add(actor);
        overlappingActor1.setX(actor.getX());
        overlappingActor1.setY(actor.getY());
        overlappingActor2.setX(actor.getX());
        overlappingActor2.setY(actor.getY() + 5);
        nonOverlappingActor.setX(actor.getX() + 100);
        nonOverlappingActor.setY(actor.getY() + 100);
        world.add(overlappingActor1);
        world.add(overlappingActor2);
        world.add(nonOverlappingActor);
    }

    @Test
    void testGetIntersectingObjects() {
        actor.setFitWidth(50);
        actor.setFitHeight(50);
        List<TestActor> intersectingObjects = actor.getIntersectingObjects(TestActor.class);
        assertEquals(2, intersectingObjects.size());
        assertTrue(intersectingObjects.contains(overlappingActor1));
        assertTrue(intersectingObjects.contains(overlappingActor2));
        assertFalse(intersectingObjects.contains(nonOverlappingActor));
    }

    @Test
    void testGetOneIntersectingObject() {
        TestActor intersectingObject = actor.getOneIntersectingObject(TestActor.class);
        assertNotNull(intersectingObject);
        assertEquals(overlappingActor1, intersectingObject);
    }


    // Helper classes
    static class TestActor extends Actor {
        @Override
        public void act(long now) {
            // No-op for testing
        }
    }

    static class TestWorld extends World {
        @Override
        public void act(long now) {
            // No-op for testing
        }
    }
}
