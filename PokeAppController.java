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
    private ChoiceBox<String> chosenGenOrReg;

    @FXML
    private ChoiceBox<String> chosenPokeVar;

    @FXML
    private ChoiceBox<String> chosenPokemon;

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
    //In the same order as the API IDs
    private String[] genList = new String[]{"1st Generation","2nd Generation",
    "3rd Generation","4th Generation","5th Generation","6th Generation",
    "7th Generation","8th Generation","9th Generation"};
    //In the same order as the API IDs
    private String[] regList = new String[]{"Kanto","Johto","Hoenn","Sinnoh",
    "Unova","Kalos","Alola","Galar","Hisui","Paldea"};

    private String[] pokemonList;

    private String[] pokeVarieties;

    private String spriteURL;

    private String spriteShinyURL;


}
