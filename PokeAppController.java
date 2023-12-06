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
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

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
   
   
   public ObservableList<String> regions = FXCollections.observableArrayList("Kanto", "Johto", "Hoenn", "Sinnoh", "Unova", "Kalos", "Alola", "Galar");
   public ObservableList<String> generations = FXCollections.observableArrayList("Generation I", "Generation II", "Generation III", "Generation IV", "Generation V", "Generation VI","Generation VII", "Generation VIII");

   public void initialize()
   {

   //choice boxxes
   chosenGenOrReg.setOnAction(event -> handleGenerationToggle());
   
   //buttons
   generationToggle.setOnAction(event -> handleGenerationToggle());
   regionToggle.setOnAction(event -> handleRegionToggle());
   }
   
    private void handleGenerationToggle()
    {
      if (generationToggle.isSelected()) 
      {

          //chosenGenOrReg.getItems().addAll(generations);

          // issue with the parmater type in the addAll java fx method so i leave it commentd out
          // as to not break the build
      }
      else 
      {
          // chosenGenOrReg.getItems().setItems(null)
      }
    }
    
    private void handleRegionToggle()
    {
      if (regionToggle.isSelected())
      {
          //chosenGenOrReg.getItems().addAll(regions);

          // or .setItems(regions)
      }
      else
      {
         // chosenGenOrReg.getItems().setItems(null)
      }
   } 

}


