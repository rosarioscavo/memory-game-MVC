package nl.rug.oop.cardgame.view;

import nl.rug.oop.cardgame.controller.ButtonMenu;
import nl.rug.oop.cardgame.controller.actions.FlipAction;
import nl.rug.oop.cardgame.model.Counter;
import nl.rug.oop.cardgame.model.Game;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    /**
     * frame constructor for the game, has the preset design
     *
     * @param game the game containing the regular game model as well as the number of cards in play
     */
    public Frame(Game game) {
        super("Memory game");
        Counter moves = new Counter();
        game.addObserver(moves);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlipAction.setGame(game);
        DrawPanel panel = new DrawPanel(game);
        add(panel, BorderLayout.CENTER);
        add(new CounterPanel(moves), BorderLayout.SOUTH);

        setJMenuBar(new ButtonMenu(game));

        setPreferredSize(new Dimension(1300, 800));

        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }
}
