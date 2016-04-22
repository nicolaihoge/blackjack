package no.nicolai.blackjack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by nicolaihoge on 22.04.2016.
 */
public class SuitTest {

    @org.junit.Test
    public void testToString() throws Exception {
        Suit suit = Suit.CLUBS;
        assertThat(suit.toString(), is("\u2663"));

    }
}