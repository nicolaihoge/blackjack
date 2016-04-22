package no.nicolai.blackjack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple Blackjack.
 */
public class BlackjackTest
{

    @org.junit.Test
    public void getHandScore() {
        Set<Card> cards = new HashSet<Card>();
        cards.add(new Card(Suit.CLUBS, Value.EIGHT));
        cards.add(new Card(Suit.CLUBS, Value.THREE));
        cards.add(new Card(Suit.CLUBS, Value.ACE));

        int handScore = Blackjack.handScore(cards);
        assertThat(handScore, is(22));
    }
}
