package no.nicolai.blackjack;

/**
 */
public enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES;

    @Override
    public String toString() {
        return String.valueOf(name().charAt(0));
    }
}
