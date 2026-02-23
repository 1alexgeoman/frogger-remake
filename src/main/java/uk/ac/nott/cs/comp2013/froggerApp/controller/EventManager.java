package uk.ac.nott.cs.comp2013.froggerApp.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import uk.ac.nott.cs.comp2013.froggerApp.model.Actor;
import uk.ac.nott.cs.comp2013.froggerApp.model.World;

import java.util.List;
/**
 * EventManager is responsible for handling keyboard events within the application.
 */

public class  EventManager {

    private final World world;

    public EventManager(World world) {
        this.world = world;
    }

    /**
     * Initialises the event manager by setting up key press and release handlers on the given Scene.
     * @param scene
     */
    public void initialise(Scene scene) {
        scene.setOnKeyPressed(this::handleKeyPressed);
        scene.setOnKeyReleased(this::handleKeyReleased);
    }
    /**
     * Handles a key press event and delegates it to the World and its Actors.
     * @param event event that was pressed
     */
    private void handleKeyPressed(KeyEvent event) {
        if (world.getOnKeyPressed() != null) {
            world.getOnKeyPressed().handle(event);
        }

        List<Actor> actors = world.getObjects(Actor.class);
        for (Actor actor : actors) {
            if (actor.getOnKeyPressed() != null) {
                actor.getOnKeyPressed().handle(event);
            }
        }
    }

    /**
     * Handles a key press event and delegates it to the World and its Actors.
     * @param event event that was pressed
     */
    private void handleKeyReleased(KeyEvent event) {
        if (world.getOnKeyReleased() != null) {
            world.getOnKeyReleased().handle(event);
        }

        List<Actor> actors = world.getObjects(Actor.class);
        for (Actor actor : actors) {
            if (actor.getOnKeyReleased() != null) {
                actor.getOnKeyReleased().handle(event);
            }
        }
    }
}
