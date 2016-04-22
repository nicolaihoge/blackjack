package no.nicolai.blackjack;

import java.util.*;

/**
 */
public class Deck {
    private Stack<Card> cards = new Stack<Card>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards.push(new Card(suit, value));
            }
        }
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card draw() {
        return cards.pop();
    }
}
