import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PokeAppController {

    @FXML
    private AnchorPane base;

    @FXML
    private ChoiceBox<?> chosenGenOrReg;

    @FXML
    private ChoiceBox<?> chosenPokeVar;

    @FXML
    private ChoiceBox<?> chosenPokemon;

    @FXML
    private ToggleButton generationToggle;

    @FXML
    private ProgressBar loadingBar;

    @FXML
    private Label loadingText;

    @FXML
    private Label pokeName;

    @FXML
    private ToggleButton regionToggle;

    @FXML
    private ToggleGroup select;

    @FXML
    private HBox selectGenOrReg;

    @FXML
    private ImageView sprite;

    @FXML
    private ImageView spriteShiny;

    @FXML
    private HBox spritesView;

    @FXML
    private VBox vBox;

}
