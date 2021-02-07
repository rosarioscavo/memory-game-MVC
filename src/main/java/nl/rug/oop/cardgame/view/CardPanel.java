package nl.rug.oop.cardgame.view;

import nl.rug.oop.cardgame.controller.actions.FlipAction;
import nl.rug.oop.cardgame.model.card.VisibleCard;
import nl.rug.oop.cardgame.view.textures.CardTextures;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {
    private final JLabel card;
    private static ImageIcon back;
    private final ImageIcon front;

    /**
     * Custom panel to draw a card
     *
     * @param card the image attached to a JLabel of the card
     */
    public CardPanel(VisibleCard card) {
        super();
        configuration();
        this.card = new JLabel();

        this.front = CardTextures.getTexture(card.getNameCard());
        this.card.setIcon(back);
        add(this.card);
        //In this way the user interact with a controller
        this.card.addMouseListener(new FlipAction(card));
    }

    /**
     * The actual design of the card panels
     * Minimalistic but stylized
     */
    private void configuration() {
        Color background = new Color(0xd6, 0x6f, 0x50);
        setBackground(background);
        Dimension size = new Dimension(100, 100);
        setMaximumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setVisible(true);
        setBorder(BorderFactory.createLineBorder(new Color(0x91, 0x57, 0x46), 7));
    }

    /**
     * Setter for the image on the back of the card
     *
     * @param image image to be used
     */
    public static void setBack(ImageIcon image) {
        back = image;
    }

    /**
     * Sets the card to display its Front
     */
    public void setVisible() {
        card.setIcon(front);
    }

    /**
     * Sets the card to display its Back
     */
    public void setHidden() {
        card.setIcon(back);
    }

}
