package no.nicolai.blackjack;

/**
 */
public enum Suit {


    HEARTS("\u2665"), DIAMONDS("\u2666"), CLUBS("\u2663"), SPADES("\u2660");

    private String string;

    private Suit(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
