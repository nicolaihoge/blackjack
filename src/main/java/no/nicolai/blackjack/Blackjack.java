package no.nicolai.blackjack;

import java.util.List;

/**
 *
 */
public class Blackjack {

    public static int BLACKJACK = 21;

    static public int handScore(List<Card> cards) {
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

    private static void play(Deck deck, Player player) {
        Move nextMove = player.nextMove();
        while (nextMove == Move.DRAWS) {
            System.out.println(player.getName() + " " + nextMove);
            player.deal(deck.draw());
            printHand(player);
            nextMove = player.nextMove();
        }
        System.out.println(player.getName() + " " + nextMove);
    }

    private static void printHand(Player player) {
        System.out.println(player + "Score: " + handScore(player.getHand()));
    }

    public static void main( String[] args ) {
        Deck deck = new Deck();
        Player sam = new Player("Sam");
        Player dealer = new Player("Dealer");

        sam.deal(deck.draw());
        sam.deal(deck.draw());
        sam.setStayValue(17);
        printHand(sam);

        dealer.deal(deck.draw());
        dealer.deal(deck.draw());
        printHand(dealer);

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
