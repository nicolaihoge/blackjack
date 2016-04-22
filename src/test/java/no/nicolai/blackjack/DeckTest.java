package no.nicolai.blackjack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by nicolaihoge on 22.04.2016.
 */
public class DeckTest {


    @Test
    public void newDeck() {
        Deck deck = new Deck();
        assertThat(deck.getCards().size(), is(52));
    }
}