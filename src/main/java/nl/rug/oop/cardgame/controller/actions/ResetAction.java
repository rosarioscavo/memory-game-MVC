package nl.rug.oop.cardgame.controller.actions;

import nl.rug.oop.cardgame.model.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetAction extends AbstractAction {
    private final Game game;

    /**
     * Action used for the reset button, resets the cards in the game, shuffles them and resets the counter
     *
     * @param game game to be rest
     */
    public ResetAction(Game game) {
        super("Reset the game");
        this.game = game;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        game.reset();
    }
}
