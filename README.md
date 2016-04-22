# blackjack

To run:
mvn exec:java

To test:
mvn test

COMMENTS:

Fun assignment. This was done by someone who has hardly done any coding for the last two years. Naive solution,
very little clean-up and refactoring. Took me three hours, but at least half of that was spent creating a git repo that
 worked and getting IntelliJ to work as I wanted. Plus I had forgotten just about all IntelliJ shortcuts,
 which cost me at least another 20 minutes :-)

PROBLEMS WITH THE ASSIGNMENT:

* Aces are usually 1 or 11 in BlackJack, otherwise players can bust before the game starts
* Its called Blackjack but doesn't really follow the rules, this is a bit confusing
* Who wins when Sam and dealer has same score? Usually this is a push where no one wins, this can happen if both Sam and dealer gets a 21 on the first two cards.
* The assignment text says that the dealer should draw until he has a higher score than Sam, which is unusual I think
* Hard to automatically test for correctness.
* Probably need some standard output, and a way to feed a "rigged" deck for predictable results.

