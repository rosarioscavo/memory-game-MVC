package nl.rug.oop.cardgame.controller.buttons;

import nl.rug.oop.cardgame.controller.actions.ResetAction;
import nl.rug.oop.cardgame.model.Game;

import javax.swing.*;

public class ResetButton extends JButton {

    /**
     * Custom JButton that resets the game
     *
     * @param game the game to be reset
     */
    public ResetButton(Game game) {
        super(new ResetAction(game));
    }
}
