package no.nicolai.blackjack;

import java.util.Set;

/**
 *
 */
public class Blackjack {

    public static int BLACKJACK = 21;

    static public int handScore(Set<Card> cards) {
        int handScore = 0;
        for (Card card : cards) {
            handScore += card.getPointValue();
        }
        return handScore;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printHands(Player player1, Player player2) {
        //clearScreen();
        System.out.println(player1);
        System.out.println(player2);

    }

    public static void main( String[] args ) {
        Deck deck = new Deck();
        Player sam = new Player("Sam");
        Player dealer = new Player("Dealer");

        sam.deal(deck.draw());
        sam.deal(deck.draw());
        sam.setStayValue(17);

        dealer.deal(deck.draw());
        dealer.deal(deck.draw());

        System.out.println();

        if (handScore(dealer.getHand()) == BLACKJACK) {
            System.out.println("Dealer wins.");
        } else if (handScore(sam.getHand()) == BLACKJACK) {
            System.out.println("Sam wins");
        } else {
            while (sam.nextMove() == Move.DRAW) {
                sam.deal(deck.draw());
            }
            dealer.setStayValue(handScore(sam.getHand()));
            while (dealer.nextMove() == Move.DRAW) {
                dealer.deal(deck.draw());
            }

        }

    }
}
