package nl.rug.oop.cardgame.model;

import java.util.Observable;
import java.util.Observer;

/**
 * It's responsible for counting player's moves
 */
public class Counter extends Observable implements Observer {
    private final int DEFAULT_VALUE = 0;
    private int counter;

    /**
     * Set the moves counter to 0
     */
    public Counter() {
        this.counter = DEFAULT_VALUE;
    }

    /**
     * Increases the number of moves
     */
    public void increment() {
        counter++;
        setChanged();
        notifyObservers();
    }

    /**
     * Method to get the number of moves
     *
     * @return number of moves
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Sets the counter to its default value
     */
    public void reset() {
        counter = DEFAULT_VALUE;
        setChanged();
        notifyObservers();
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an {@code Observable} object's
     * {@code notifyObservers} method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg == Boolean.TRUE)
            increment();
        else if (arg == "RESET")
            reset();
    }
}
