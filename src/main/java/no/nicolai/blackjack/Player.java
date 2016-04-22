package no.nicolai.blackjack;

import java.util.HashSet;
import java.util.Set;

import static no.nicolai.blackjack.Blackjack.BLACKJACK;

/**
 */
public class Player {
    private String name;
    private Set<Card> hand;
    private int stayValue = 0;

    public Player(String name) {
        this.name = name;
        hand = new HashSet<Card>();
    }

    public String getName() {
        return name;
    }

    public Set<Card> getHand() {
        return hand;
    }

    public void setStayValue(int stayValue) {
        this.stayValue = stayValue;
    }

    public Move nextMove() {
        int score = Blackjack.handScore(hand);
        Move move;
        if (score > BLACKJACK) {
            move = Move.BUST;
        }
        else if (score >= stayValue) {
            move = Move.STAY;
        }
        else {
            move = Move.DRAW;
        }
        return move;
    }

    public void deal(Card card) {
        hand.add(card);
        System.out.println(toString());
    }

    public String toString () {
        StringBuffer sb = new StringBuffer();
        sb.append(name);
        sb.append(":");
        for (Card card : hand) {
            sb.append(card + " ");
        }
        return sb.toString();
    }
}
