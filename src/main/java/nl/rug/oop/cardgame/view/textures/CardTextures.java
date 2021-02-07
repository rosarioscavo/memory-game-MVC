package nl.rug.oop.cardgame.view.textures;

import nl.rug.oop.cardgame.model.card.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

public class CardTextures {
    private static final EnumMap<Card, ImageIcon> textures;

    static {
        textures = new EnumMap<>(Card.class);
        BufferedImage image;
        for (Card card : Card.values()) {
            try {
                image = ImageIO.read(new File("src" + File.separator + "resources" + File.separator + "textures" + File.separator + card + ".png"));
                Image scaledImage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                textures.put(card, icon);
            } catch (IOException e) {
                System.out.println("Image not found");
            }
        }

    }

    /**
     * Getter for the texture of a card
     *
     * @param card card whose texture we want
     * @return the texture of the card
     */
    public static ImageIcon getTexture(Card card) {
        return textures.get(card);
    }

}
