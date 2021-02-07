package nl.rug.oop.cardgame.model;

import nl.rug.oop.cardgame.model.card.Card;
import nl.rug.oop.cardgame.model.card.VisibleCard;
import nl.rug.oop.cardgame.view.WinDialog;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;

import static java.util.Collections.shuffle;

public class Game extends Observable {
    ArrayList<VisibleCard> table;
    private final int numPairs;
    private Deck deck;
    private int indexLastCard;
    private int completedPair;
    private boolean gameCompleted;

    /**
     * Game constructor
     *
     * @param numPairs input the number of card pairs you would like to play with
     */
    public Game(int numPairs) {
        this.numPairs = numPairs;
        indexLastCard = -1;
        completedPair = 0;
        gameCompleted = false;
        deck = new Deck(numPairs);
        table = new ArrayList<>();
        CreateTable();
    }

    /**
     * Resets the game and reshuffles the cards
     */
    public void reset() {
        deck = new Deck(numPairs);
        table = new ArrayList<>();
        indexLastCard = -1;
        gameCompleted = false;
        completedPair = 0;
        CreateTable();
        setChanged();
        notifyObservers("RESET");
    }

    /**
     * Create a new table to store the card pairs and also shuffle them
     */
    private void CreateTable() {
        for (Card card : deck.getCards()) {
            //first card
            table.add(new VisibleCard(card, 0, false));
            //second card
            table.add(new VisibleCard(card, 1, false));
        }

        shuffle(table);
    }

    /**
     * Getter for the table variable
     *
     * @return a list of all the cards that have been paired and shuffled
     */
    public ArrayList<VisibleCard> getTable() {
        return table;
    }

    /**
     * Private function used by the game to reset a wrong guess of any two cards that do not match
     *
     * @param index1 index of card 1 in the table
     * @param index2 index of card 2 in the table
     * @param card1  first card to reset
     * @param card2  second card to reset
     */
    private void hideCardPair(int index1, int index2, VisibleCard card1, VisibleCard card2) {
        Timer timer = new Timer(1000, e -> {
            flipACard(index1, card1);
            flipACard(index2, card2);

            setChanged();
            notifyObservers();
            ((Timer) e.getSource()).stop();
        });
        timer.start();
    }

    /**
     * Flips over a single card using the Card flip function
     *
     * @param index index of the card in the table
     * @param card  actual card to be flipped
     */
    private void flipACard(int index, VisibleCard card) {
        card.flip();
        table.set(index, card);
    }

    /**
     * Private function used by the game to set a correctly guessed pair of cards to have a true in their completed field
     * this prevents them from being flipped again and also makes them stay face up and allows  us to count how many pairs are left
     *
     * @param index1 index of card 1 in the table
     * @param index2 index of card 2 in the table
     * @param card1  first card to be completed
     * @param card2  second card to be completed
     */
    private void setCompletedPair(int index1, int index2, VisibleCard card1, VisibleCard card2) {
        card1.setCompleted();
        card2.setCompleted();
        table.set(index1, card1);
        table.set(index2, card2);
        completedPair++;
    }

    /**
     * Checks if all pairs have been completed (Win Condition)
     *
     * @return true if all pairs are finished
     */
    public boolean isGameCompleted() {
        if (completedPair == numPairs) {
            gameCompleted = true;
        }
        return gameCompleted;
    }

    /**
     * Tries to flip the card clicked on by the player prevents them from incorrect moves
     *
     * @param card the card that was clicked
     */
    public void takeACard(VisibleCard card) {
        int index = table.indexOf(card);

        //if the user clicked a card that its pair is already completed or
        //clicked two times the same card
        if (card.isCompleted() || indexLastCard == index) {
            return;
        }

        setChanged();
        flipACard(index, card);

        //if there wasn't a card selected before the new card
        if (indexLastCard == -1) {
            indexLastCard = index;
            notifyObservers();
        } else {
            //return true for the counter
            notifyObservers(Boolean.TRUE);
            VisibleCard lastCard = table.get(indexLastCard);

            if (card.isSameCard(lastCard)) {
                setCompletedPair(index, indexLastCard, card, lastCard);
                if (isGameCompleted()) {
                    new WinDialog(this);
                }
            } else {
                hideCardPair(index, indexLastCard, card, lastCard);
            }
            indexLastCard = -1;
        }

    }
}
