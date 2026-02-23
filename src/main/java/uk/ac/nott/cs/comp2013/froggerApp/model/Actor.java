package uk.ac.nott.cs.comp2013.froggerApp.model;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * Represents an abstract Actor in the game.
 */
public abstract class Actor extends ImageView{

    /**
     * Moves the actor by specified x and y offsets.
     *
     * @param dx change in x-coordinate
     * @param dy change in y-coordinate
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Gets the World containing this actor.
     *
     * @return the parent World
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Gets the width, height of the actor.
     *
     * @return width in local bounds
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Finds intersecting objects of the specified type.
     * @param cls the class of the objects
     * @param <A> the type of the objects
     * @return a list of intersecting objects
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    /**
     * Gets one intersecting objects of the specified type.
     * @param cls the class of the objects
     * @param <A> the type of the objects
     * @return a list of intersecting objects
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    /**
     * Performs the actor's behavior.
     * @param now current time in nanoseconds
     */

    public abstract void act(long now);


}
