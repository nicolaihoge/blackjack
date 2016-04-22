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

    private static void winner(Player player) {
        System.out.println(player.getName() + " wins!");
        System.exit(0);
    }

    private static void printScore(Player player) {
        System.out.println(player.getName() + " score: " + handScore(player.getHand()));
    }

    private static void play(Deck deck, Player player) {
        Move nextMove = player.nextMove();
        while (nextMove == Move.DRAW) {
            System.out.println(player.getName() + " " + nextMove);
            player.deal(deck.draw());
            printScore(player);
            nextMove = player.nextMove();
        }
        System.out.println(player.getName() + " " + nextMove);
    }


    public static void main( String[] args ) {
        Deck deck = new Deck();
        Player sam = new Player("Sam");
        Player dealer = new Player("Dealer");

        sam.deal(deck.draw());
        sam.deal(deck.draw());
        sam.setStayValue(17);
        printScore(sam);

        dealer.deal(deck.draw());
        dealer.deal(deck.draw());
        printScore(dealer);

        System.out.println();

        if (handScore(dealer.getHand()) == BLACKJACK) {
            winner(dealer);
        } else if (handScore(sam.getHand()) == BLACKJACK) {
            winner(sam);
        } else {
            play(deck, sam);

            if (sam.nextMove() == Move.BUST) {
                winner(dealer);
            }

            dealer.setStayValue(handScore(sam.getHand()));
            play(deck, dealer);

            if (dealer.nextMove() == Move.BUST) {
                winner(sam);
            } else {
                int samScore = handScore(sam.getHand());
                int dealerScore = handScore(dealer.getHand());

                if (dealerScore >= samScore) {
                    winner(dealer);
                } else {
                    winner(sam);
                }
            }

        }

    }

}
