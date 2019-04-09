import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck extends App  {
    private Card[] cards;
    public Card[] dealerhand = new Card[2];
    public Card[] playerhand = new Card[5];

    public Deck() {
       this.cards = new Card[52];

       /**Test Cases***********************************************************/
       //Dealer Test Case
       this.dealerhand[0] = new Card(Card.Suit.SPADES,Card.Rank.JACK);
      this.dealerhand[1] = new Card(Card.Suit.HEARTS, Card.Rank.NINE);

        //Billy Test Case
      /** this.playerhand[0] = new Card(Card.Suit.SPADES,Card.Rank.TWO);
        this.playerhand[1] = new Card(Card.Suit.DIAMONDS, Card.Rank.TWO);
        this.playerhand[2] = new Card(Card.Suit.HEARTS, Card.Rank.TWO);
        this.playerhand[3] = new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR);
        this.playerhand[4] = new Card(Card.Suit.CLUBS, Card.Rank.FIVE);**/

        //Lemmy test Case
      /**  this.playerhand[0] = new Card(Card.Suit.SPADES,Card.Rank.ACE);
        this.playerhand[1] = new Card(Card.Suit.HEARTS, Card.Rank.SEVEN);
        this.playerhand[2] = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);**/

        //Andrew Test Case
      /**this.playerhand[0] = new Card(Card.Suit.DIAMONDS,Card.Rank.KING);
        this.playerhand[1] = new Card(Card.Suit.SPADES, Card.Rank.FOUR);
        this.playerhand[2] = new Card(Card.Suit.CLUBS, Card.Rank.FOUR);**/



        //Carla Test Case
        this.playerhand[0] = new Card(Card.Suit.CLUBS,Card.Rank.QUEEN);
        this.playerhand[1] = new Card(Card.Suit.SPADES, Card.Rank.SIX);
        this.playerhand[2] = new Card(Card.Suit.DIAMONDS, Card.Rank.NINE);

        shuffle();
    }
    //Shuffle though the Deck
     private final void shuffle() {
        int i = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
    }


  //Get the Users Hand and return the cards for computation
    public Card playerDeck() {
        Card ucard = null;
        int index;
        while (ucard == null) {
            index =  (int) (Math.random() * playerhand.length);
            ucard = playerhand[index];//cards index
            playerhand[index] = null;
            System.out.println("Player has "+ucard);
        }
        return ucard;
    }
    //Get the Dealers Hand and return the cards for computation
    public Card dealerDeck() {
        Card dcard = null;
        while (dcard == null) {
           // cards[]= dcard{3,4,6,7};
            int index =  (int) (Math.random() * dealerhand.length);
            dcard = dealerhand[index];//cards index
            dealerhand[index] = null;
            System.out.println("Dealer has "+dcard);
        }
        return dcard;
    }

@Override
public void start(Stage primaryStage) throws Exception {

}

}