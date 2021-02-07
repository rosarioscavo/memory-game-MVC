package nl.rug.oop.cardgame.model.card;

import java.util.Objects;

/**
 * id=0 first card, 1 second card. It's used to compare two VisibileCard(look at the equals method)
 */
public class VisibleCard {
    private final Card nameCard;
    private final int id;
    private boolean visible;
    private boolean completed;

    /**
     * Constructor for a visible card
     *
     * @param nameCard the name of the card
     * @param id       the unique ID of the Card
     * @param visible  boolean whether or not the card is visible
     */
    public VisibleCard(Card nameCard, int id, boolean visible) {
        this.nameCard = nameCard;
        this.id = id;
        this.visible = visible;
        this.completed = false;
    }

    /**
     * Getter for completed
     *
     * @return whether card pair has been completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Getter for the card's name
     *
     * @return the name of the card
     */
    public Card getNameCard() {
        return nameCard;
    }

    /**
     * Getter for visible
     *
     * @return whether the card is visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Flips the card by changing its visible field to its logical negation
     */
    public void flip() {
        this.visible = !this.visible;
    }

    /**
     * Set the card to be part of a completed pair
     */
    public void setCompleted() {
        this.completed = true;
    }

    /**
     * Compares this card against another card
     *
     * @param card other card to compare against
     * @return if both cards are the same
     */
    public boolean isSameCard(VisibleCard card) {
        return card.getNameCard() == this.nameCard;
    }

    /**
     * Overridden object equals function
     *
     * @param o object to compare this one to
     * @return whether both objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisibleCard that = (VisibleCard) o;
        return id == that.id &&
                nameCard == that.nameCard;
    }

    /**
     * Overridden hashcode generator to use the card's ID
     *
     * @return the hash code of this card's ID
     */
    @Override
    public int hashCode() {
        return Objects.hash(nameCard, id);
    }
}
