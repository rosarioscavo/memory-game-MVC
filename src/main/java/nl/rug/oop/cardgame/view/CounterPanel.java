package nl.rug.oop.cardgame.view;

import nl.rug.oop.cardgame.model.Counter;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CounterPanel extends JPanel implements Observer {
    private final Counter moves;

    /**
     * Custom panel to display a counter which we use to track the number of moves performed by the player each round
     *
     * @param moves the counter which will be displayed
     */
    public CounterPanel(Counter moves) {
        setBackground(Color.gray);
        setPreferredSize(new Dimension(100, 60));
        this.moves = moves;
        this.moves.addObserver(this);
        setBackground(new Color(0x2b, 0x1a, 0x15));
    }

    /**
     * Draws the number of the counter
     *
     * @param g Graphics component used for drawing
     */
    private void drawCounter(Graphics g) {
        Dimension dimension = getSize();
        g.setFont(new Font("ComicSans", Font.BOLD, 36));
        g.setColor(Color.WHITE);
        g.drawString("Score: ", dimension.width / 2 - 90, dimension.height / 2 + 10);
        g.drawString(String.valueOf(moves.getCounter()), dimension.width / 2 + 25, dimension.height / 2 + 10);
    }

    /**
     * Custom implementation of the paintComponent function that draws te counter
     *
     * @param g Graphics component used for drawing
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCounter(g);
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
        repaint();
    }
}
