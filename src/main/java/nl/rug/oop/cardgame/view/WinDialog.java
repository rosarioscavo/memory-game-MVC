package nl.rug.oop.cardgame.view;

import nl.rug.oop.cardgame.controller.buttons.ResetButton;
import nl.rug.oop.cardgame.model.Game;

import javax.swing.*;
import java.awt.*;

public class WinDialog extends JDialog {

    private static final JFrame frame = new JFrame();
    private final JTextArea message;

    /**
     * Dialog box that tells the player they win and allows them to play again
     *
     * @param game the game they have won
     */
    public WinDialog(Game game) {
        super(frame, "YOU WIN", true);
        JPanel panel = new JPanel();
        ResetButton replay = new ResetButton(game);
        replay.setBackground(new Color(0x2b, 0x1a, 0x15));
        replay.setFont(new Font("ComicSans", Font.BOLD, 26));
        replay.setForeground(Color.WHITE);
        replay.addActionListener(e -> dispose());

        message = new JTextArea("Congratulations! You've Won!");
        messageSettings();

        panel.setBackground(new Color(0x99, 0x48, 0x2f));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(message);
        panel.add(replay);
        add(panel);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void messageSettings() {
        message.setForeground(Color.WHITE);
        message.setLineWrap(true);
        message.setEditable(false);
        message.setFocusable(false);
        message.setWrapStyleWord(true);
        message.setPreferredSize(new Dimension(250, 75));
        message.setBackground(new Color(0x99, 0x48, 0x2f));
        message.setFont(new Font("ComicSans", Font.BOLD, 22));
    }
}
