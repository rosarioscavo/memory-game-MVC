package nl.rug.oop.cardgame.view;

import nl.rug.oop.cardgame.model.Game;
import nl.rug.oop.cardgame.model.card.VisibleCard;
import nl.rug.oop.cardgame.view.textures.CardBackTexture;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class DrawPanel extends JPanel implements Observer {
    private ArrayList<CardPanel> cards;
    private final Game game;

    /**
     * Custom Panel which contains the game itself
     *
     * @param game game with settings to be used
     */
    public DrawPanel(Game game) {
        super();
        this.game = game;
        this.game.addObserver(this);

        cards = new ArrayList<>();

        Color background = new Color(0x99, 0x48, 0x2f);
        setBackground(background);
        setVisible(true);
        setOpaque(true);

        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        //add cards to the panel
        addCards();
    }

    /**
     * Adds card panels for each card in the game
     */
    private void addCards() {
        CardPanel.setBack(CardBackTexture.getTexture());

        for (VisibleCard card : game.getTable()) {
            cards.add(new CardPanel(card));
        }

        for (CardPanel panel : cards) {
            add(panel);
        }
    }

    /**
     * Function to paint the cards that should be visible in this game
     */
    private void paintCards() {
        int i = 0;
        for (VisibleCard card : game.getTable()) {
            if (card.isVisible())
                cards.get(i).setVisible();
            else
                cards.get(i).setHidden();

            i++;
        }
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
        if (arg == "RESET") {
            cards = new ArrayList<>();

            Component[] componentList = getComponents();
            for (Component c : componentList) {
                remove(c);
            }
            addCards();
            revalidate();
        }

        paintCards();

    }
}
