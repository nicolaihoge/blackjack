package no.nicolai.blackjack;

/**
 * Card value
 */
public enum Value {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K"),
    ACE(11, "A");
    private int pointValue;
    private String string;

    private Value(int pointValue, String string) {
        this.pointValue = pointValue;
        this.string = string;
    }

    public int getPointValue() {
        return pointValue;
    }

    @Override
    public String toString () {
        return string;
    }
}
