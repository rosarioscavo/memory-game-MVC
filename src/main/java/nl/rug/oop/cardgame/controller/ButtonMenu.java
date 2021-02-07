package nl.rug.oop.cardgame.controller;

import nl.rug.oop.cardgame.controller.buttons.ResetButton;
import nl.rug.oop.cardgame.model.Game;

import javax.swing.*;

public class ButtonMenu extends JMenuBar {

    /**
     * Constructor for our reset button bar
     *
     * @param game the game in which the bar was added and will effect
     */
    public ButtonMenu(Game game) {

        add(new ResetButton(game));
    }
}
