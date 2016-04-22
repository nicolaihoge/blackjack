package no.nicolai.blackjack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by nicolaihoge on 22.04.2016.
 */
public class PlayerTest {

    @Test
    public void dealToBust()  {
        Player player = new Player("Player");
        player.setStayValue(22);
        player.deal(new Card(Suit.CLUBS, Value.EIGHT));
        assertThat(player.nextMove(), is(Move.DRAW));
        player.deal(new Card(Suit.CLUBS, Value.EIGHT));
        assertThat(player.nextMove(), is(Move.DRAW));
        player.deal(new Card(Suit.CLUBS, Value.EIGHT));
        assertThat(player.nextMove(), is(Move.BUST));
    }

    @Test
    public void dealToStay() {
        Player player = new Player("Player");
        player.setStayValue(15);
        player.deal(new Card(Suit.CLUBS, Value.TEN));
        assertThat(player.nextMove(), is(Move.DRAW));
        player.deal(new Card(Suit.CLUBS, Value.FIVE));
        assertThat(player.nextMove(), is(Move.STAY));
    }

    @Test
    public void dealPastStayButNotBust() {
        Player player = new Player("Player");
        player.setStayValue(15);
        player.deal(new Card(Suit.CLUBS, Value.TEN));
        assertThat(player.nextMove(), is(Move.DRAW));
        player.deal(new Card(Suit.CLUBS, Value.EIGHT));
        assertThat(player.nextMove(), is(Move.STAY));
    }

    @Test
    public void dealToTwentyOne() {
        Player player = new Player("Player");
        player.setStayValue(21);
        player.deal(new Card(Suit.CLUBS, Value.JACK));
        assertThat(player.nextMove(), is(Move.DRAW));
        player.deal(new Card(Suit.CLUBS, Value.ACE));
        assertThat(player.nextMove(), is(Move.STAY));
    }
}