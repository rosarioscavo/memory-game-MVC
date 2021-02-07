package nl.rug.oop.cardgame.view.textures;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardBackTexture {
    private static ImageIcon back;

    static {

        try {
            BufferedImage image = ImageIO.read(new File("src" + File.separator + "resources" + File.separator + "textures" + File.separator + "back.png"));
            Image scaledImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            back = new ImageIcon(scaledImage);
        } catch (IOException e) {
            System.out.println("Image not found");
        }

    }

    /**
     * Getter for the texture of the backs of all the cards
     *
     * @return the back texture
     */
    public static ImageIcon getTexture() {
        return back;
    }
}
