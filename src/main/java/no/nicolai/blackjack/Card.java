package no.nicolai.blackjack;

/**
 * A single playing card
 */
public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit.toString() + value.toString();
    }

    public int getPointValue() {
        return value.getPointValue();
    }
}
