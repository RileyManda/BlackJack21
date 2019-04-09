import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.stage.Stage;

public  class Hand extends App {
    private ObservableList<Node> cards;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    Hand(ObservableList<Node> cards) {
        this.cards = cards;

    }
    void takeCard(Card card) {
        cards.add(card);
        if (card.rank == Card.Rank.ACE) {
            ace++;
        }
        //Changing Value of Ace to 1 if card.value > 21
        if (value.get() + card.value > 21 && ace > 0) {
            value.set(value.get() + card.value - 10);
            ace--;
        }
        else {
            //Set default ace value:11 and get value of card
            value.set(value.get() + card.value);
        }
    }
    //reset game[clear all cards and set scor value and ace to 0]
    void reset() {
        cards.clear();
        value.set(0);//score value
        ace = 0;

    }
    SimpleIntegerProperty valueProperty() {
        return value;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}