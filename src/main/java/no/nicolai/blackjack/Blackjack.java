package no.nicolai.blackjack;

import java.util.Set;

/**
 *
 */
public class Blackjack {

    static public int handScore(Set<Card> cards) {
        int handScore = 0;
        for (Card card : cards) {
            handScore += card.getPointValue();
        }
        return handScore;
    }

    public static void main( String[] args ) {
        System.out.println( "Play Blackjack!" );
    }
}
