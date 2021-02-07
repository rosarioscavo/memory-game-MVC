package nl.rug.oop.cardgame.model;

import nl.rug.oop.cardgame.model.card.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    /**
     * Constructor for a Deck of cards
     */
    public Deck() {
        cards = new ArrayList<>();
        addCards();
        //necessary to not always have the same cards
        shuffle();
    }

    /**
     * Overloaded constructor for a deck of cards
     *
     * @param size the size of the arraylist of cards in the deck
     */
    public Deck(int size) {
        this();
        if (size < cards.size())
            deleteElements(size);
    }

    /**
     * adds cards to the Deck
     */
    public void addCards() {
        cards.addAll(Arrays.asList(Card.values()));
    }

    /**
     * Allows us to truncate the list of cards to a certain length
     *
     * @param num the new size of the array
     */
    private void deleteElements(int num) {
        cards = new ArrayList<>(cards.subList(0, num));
    }

    /**
     * shuffles the order of the deck of cards
     */
    private void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Getter for the card arraylist
     *
     * @return the deck of cards as an ArrayList
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
}
