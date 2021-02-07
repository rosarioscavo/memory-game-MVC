package nl.rug.oop.cardgame.view;

import javax.swing.*;
import java.awt.*;

public class SettingsDialog extends JDialog {
    private final JSpinner cardNumber;
    private static final JFrame frame = new JFrame();
    private final JButton start;
    private final JTextArea message;

    /**
     * Dialog box that allows the player to choose how many card pairs they want to play with
     */
    public SettingsDialog() {
        super(frame, "Game Settings", true);
        JPanel panel = new JPanel();
        SpinnerNumberModel range = new SpinnerNumberModel(10, 1, 25, 1);
        cardNumber = new JSpinner(range);
        start = new JButton("Start");
        start.addActionListener(e -> dispose());
        panel.setBackground(new Color(0x99, 0x48, 0x2f));

        Font font = new Font("ComicSans", Font.BOLD, 36);
        startSettings(font);
        cardNumber.setFont(font);

        message = new JTextArea("How many pairs do you want to play with? ");
        messageSettings();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(message);
        panel.add(cardNumber);
        panel.add(start);

        add(panel);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Set Properties to the message
     */
    private void messageSettings() {
        message.setLineWrap(true);
        message.setEditable(false);
        message.setFocusable(false);
        message.setBackground(UIManager.getColor("Label.background"));
        message.setWrapStyleWord(true);
        message.setPreferredSize(new Dimension(250, 75));
        message.setForeground(Color.WHITE);
        message.setBackground(new Color(0x99, 0x48, 0x2f));
        message.setFont(new Font("ComicSans", Font.BOLD, 22));
    }

    /**
     * Set Properties to the start button
     */
    private void startSettings(Font font) {
        start.setFont(font);
        start.setBackground(new Color(0x2b, 0x1a, 0x15));
        start.setForeground(Color.WHITE);
    }

    /**
     * Getter for the number of card pairs the player wants to play with
     *
     * @return the number that the player inputted in the JSlider when they clicked the button
     */
    public int getNumPairs() {
        try {
            cardNumber.commitEdit();
        } catch (java.text.ParseException e) {
            System.out.println("Invalid number of pairs entered");
        }
        return (Integer) cardNumber.getValue();
    }

}
