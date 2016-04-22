package no.nicolai.blackjack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 */
public class ValueTest {

    @org.junit.Test
    public void pointValue() {
        Value value = Value.ACE;
        assertThat(value.getPointValue(), is(11));
    }

}