import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BlackJack extends App {

    private Deck deck = new Deck();

    private Parent appScene() {
        dealer = new Hand(dealerCards.getChildren());
        player = new Hand(playerCards.getChildren());
        //[Reset & SetCards Buttons]
        btnReset = new Button("Reset");
        setCards = new Button("Play");
        //[Dealer Score & Player Score Text]
        dealerScore = new Text("Dealer: ");
        playerScore = new Text("Player: ");

        //App UI[START]
        root.setPrefSize(800, 600);
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgb(17,41,83)");

        rootLayout.setPadding(new Insets(5, 5, 5, 5));

        /*BG UI START*/
        //Left BG
        leftBG.setArcWidth(50);
        leftBG.setArcHeight(50);
        leftBG.setFill(Color.grayRgb(1,0.2));
        //Right BG
        rightBG.setArcWidth(400);
        rightBG.setArcHeight(50);
        rightBG.setFill(Color.WHITE);
        /*BG UI END*/

        //[Right & Left VBox Start]
        // LEFT Vertical Box
        leftVBox.setAlignment(Pos.TOP_CENTER);
        // LEFT Vertical Box Views[dealerScore, dealerCards, message, playerCards, playerScore]
        leftVBox.getChildren().addAll(dealerScore, dealerCards, message, playerCards, playerScore);
        // RIGHT VBox UI & Views
        rightVBox.setAlignment(Pos.CENTER);
        //HBox buttons
        buttonsHBox.setAlignment(Pos.CENTER);
        rightVBox.getChildren().addAll(btnReset,setCards, buttonsHBox);

        // Adding Viiews to root  layout
        rootLayout.getChildren().addAll(new StackPane(leftBG, leftVBox), new StackPane(rightBG, rightVBox));
        root.getChildren().addAll(background, rootLayout);

        //[Dealer Score & Player Score Text UI/Graphics]
        dealerScore.setFill(Color.WHITE);
        playerScore.setFill(Color.WHITE);

        /*Buttons UI START*/
        //reset button UI
        btnReset.setTextFill(Color.WHITE);
        btnReset.setStyle("-fx-background-color: rgb(17,41,83)");
        btnReset.setCursor(Cursor.HAND);
        btnReset.setMinWidth(80.0);
        btnReset.setPrefWidth(80.0);
        btnReset.setMaxWidth(80.0);
        btnReset.setTooltip(resettp);


        //setCards button UI
        setCards.setTextFill(Color.WHITE);
        setCards.setStyle("-fx-background-color: rgb(17,41,83)");
        setCards.setCursor(Cursor.HAND);
        setCards.setMinWidth(80.0);
        setCards.setPrefWidth(80.0);
        setCards.setMaxWidth(80.0);
        setCards.setTooltip(pgametp);
        /*Buttons UI END*/

        //MESSAGE VIEW PRIPERTIES
        message.setFill(Color.WHITE);



        // bind btn reset,playerScore,dealerScore to text,value & playable property
        btnReset.disableProperty().bind(playable);
        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
        dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.valueProperty().asString()));
        player.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                calcScore();
            }
        });
        //Button Listeners
        dealer.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                calcScore();
            }
        });

        //reset game
        btnReset.setOnAction(event -> resetGame());

        //Set Cards Player and Dealer Cards
        setCards.setOnAction(event -> {
           // disablePlay();//disable play button
            player.takeCard(deck.playerDeck());
            while (dealer.valueProperty().get() < 15 || dealer.valueProperty().get() < deck.dealerhand.length) {
                dealer.takeCard(deck.dealerDeck());
            }

           calcScore();

        });
        return root;
    }
    //Calculate Score method
 public void calcScore() {//Calculate Score
    playable.set(false);
     int dealerValue = dealer.valueProperty().get();
     int playerValue = player.valueProperty().get();
     String winner;
     if (dealerValue == 21 || playerValue > 21 || dealerValue == playerValue
             || (dealerValue < 21 && dealerValue > playerValue)) {
         winner = dname;
     }
     else{
         winner = pname;
     }
     message.setText(winner + " WINS");

 }
 //Reset Game
    void resetGame() {
        dealer.reset();
        player.reset();
        message.setText("");
        playable.set(true);

    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(appScene()));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("BlackJack 21");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}