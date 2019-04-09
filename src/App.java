import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.swing.*;

public abstract class App extends Application {
    //Variables
    public Button btnReset,setCards;
    public JButton nextButton; // next button
    public Text message = new Text();

    public String dname = "DEALER";
    public String pname = "PLAYER";

    public  Text dealerScore,playerScore;
    public int ace = 0;


    //tooltips
    Tooltip pgametp = new Tooltip("Play  Game");
    Tooltip resettp = new Tooltip("Reset  Game");

    //Hand Vars
    public Hand dealer, player;

    //App Views
    public HBox dealerCards = new HBox(20);
    public HBox playerCards = new HBox(20);
    HBox rootLayout = new HBox(5);

    //App UI

    //Game pane
    Pane root = new Pane();
    Region background = new Region();
    //right BG
    Rectangle rightBG = new Rectangle(90, 200);
    //Left BG
    Rectangle leftBG = new Rectangle(650, 560);

    //Left VBox
    VBox leftVBox = new VBox(50);
    //right VBox
    VBox rightVBox = new VBox(20);

    //Button HBox
    HBox buttonsHBox = new HBox(15);
    //playable boolean property
    SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

}
