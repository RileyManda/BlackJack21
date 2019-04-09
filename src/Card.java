import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Card extends Parent {
    private static final int CARD_WIDTH = 100;//card width
    private static final int CARD_HEIGHT = 120;//card height
    //Rank
    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES;
   }
    //Suit
    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        final int value;
        Rank(int value) {
            this.value = value;
        }

        String faceValue() {
            return ordinal() < 9 ? String.valueOf(value) : name().substring(0, 1);
        }
    }

    public final Suit suit;
    public final Rank rank;
    public final int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

        //Card UI
        Rectangle card_rec = new Rectangle(CARD_WIDTH, CARD_HEIGHT);
        card_rec.setArcWidth(20);
        card_rec.setArcHeight(20);
        card_rec.setFill(Color.WHITE);


        //Text on Cards
        //cardtext
         Text ctext = new Text(toString());
        ctext.setWrappingWidth(70);
        getChildren().add(new StackPane(card_rec,ctext));

        Text ftext = new Text(rank.faceValue());
        ftext.setFont(Font.font(18));
        ftext.setX(CARD_WIDTH - ftext.getLayoutBounds().getWidth() - 10);
        ftext.setY(ftext.getLayoutBounds().getHeight());
    }

    //display rank and suit names
    @Override
    public String toString() {
        return rank.toString() + " OF " + suit.toString();
    }
}