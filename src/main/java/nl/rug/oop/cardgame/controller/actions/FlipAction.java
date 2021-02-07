package nl.rug.oop.cardgame.controller.actions;

import nl.rug.oop.cardgame.model.Game;
import nl.rug.oop.cardgame.model.card.VisibleCard;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class FlipAction extends MouseInputAdapter {

    private final VisibleCard card;
    private static Game game;

    /**
     * Action used to flip the image on a card
     *
     * @param card the card to be flipped
     */
    public FlipAction(VisibleCard card) {
        this.card = card;
    }

    /**
     * MousePressed event that will call the take a card function
     *
     * @param e the mouseEvent data
     */
    @Override
    public void mousePressed(MouseEvent e) {
        game.takeACard(card);
    }

    public static void setGame(Game game_card) {
        game = game_card;
    }
}
