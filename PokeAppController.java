import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.prefs.Preferences;

public class PokeAppController{

    @FXML
    private AnchorPane base;

    @FXML
    private VBox vBox;

    @FXML
    private HBox selectGenOrReg;

    @FXML
    private ChoiceBox<String> chosenGenOrReg;

    @FXML
    private ToggleButton generationToggle;

    @FXML
    private ToggleGroup select;

    @FXML
    private ToggleButton regionToggle;

    @FXML
    private ChoiceBox<String> chosenPokemon;

    @FXML
    private ProgressBar loadingBar;

    @FXML
    private Label loadingText;

    @FXML
    private HBox spritesView;

    @FXML
    private ImageView sprite;

    @FXML
    private ImageView spriteShiny;

    @FXML
    private Label pokeName;

    @FXML
    private ChoiceBox<String> chosenPokeVar;

    private String spriteURL = "testPic.jpg";

    private String spriteShinyURL = "testPic.jpg";
    
    public static final String genOrReg = "toggle_key";

   public ObservableList<String> regions = FXCollections.observableArrayList(
           "Kanto", "Johto", "Hoenn", "Sinnoh", "Unova",
           "Kalos", "Alola", "Galar");
           
   public ObservableList<String> generations = FXCollections.observableArrayList(
           "Generation I", "Generation II", "Generation III", "Generation IV",
           "Generation V", "Generation VI","Generation VII",
           "Generation VIII");
           
    private String view;

    private URL url;

    private Scanner scan;

    private String rawData;

    private final Gson gson = new Gson();

   public void initialize()
   {
   //choice boxes
   chosenGenOrReg.setOnAction(event -> {
       try {
           handleGenRegSelect();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   });
   chosenPokemon.setOnAction(event-> {
       try {
           handlePokeSelect();
       } catch (IOException e) {
          throw new RuntimeException(e);
       }
   });
   chosenPokeVar.setOnAction(event-> {
       try {
           handleVarSelect();
       } catch (IOException e) {
          throw new RuntimeException(e);
       }
   });
   
   //buttons
   generationToggle.setOnAction(event -> handleToggle());
   regionToggle.setOnAction(event -> handleToggle());
   //check preferences
   Preferences pref = Preferences.userNodeForPackage(PokeAppController.class);
   this.view = pref.get(genOrReg, "genView");
   if (view.equals("genView")){
       generationToggle.setSelected(true);
   }
   else {
       regionToggle.setSelected(true);
   }
   //populate dropdowns
   handleToggle();
   }
   
    private void handleToggle()
    {
      if (generationToggle.isSelected()) 
      {
          view = "genView";
          chosenGenOrReg.setItems(generations);
      }
      else if (regionToggle.isSelected())
      {
          view = "regView";
          chosenGenOrReg.setItems(regions);
      }
      Preferences pref = Preferences.userNodeForPackage(PokeAppController.class);
      pref.put(genOrReg, view);
      chosenGenOrReg.setValue(chosenGenOrReg.getItems().get(0));
      chosenPokemon.setValue(chosenPokemon.getItems().get(0));
      chosenPokeVar.setValue(chosenPokeVar.getItems().get(0));
      chosenPokemon.setVisible(false);
      chosenPokeVar.setVisible(false);
      spritesView.setVisible(false);
      pokeName.setVisible(false);
    }
    

    private void handleGenRegSelect() throws IOException {
        if(chosenGenOrReg.getValue()==null){
         return;
        }
        chosenPokemon.setVisible(true);
        ObservableList<String> pokemonList;
        if(view.equals("genView")){
            url = new URL("https://pokeapi.co/api/v2/generation/"+(generations.indexOf(chosenGenOrReg.getValue())+1));
            scan = new Scanner(url.openStream());
            rawData = scan.nextLine();
            Generation gen = gson.fromJson(rawData,Generation.class);
            pokemonList = FXCollections.observableArrayList(gen.getPokeList());
        }
        else{
            url = new URL("https://pokeapi.co/api/v2/region/"+(regions.indexOf(chosenGenOrReg.getValue())+1));
            scan = new Scanner(url.openStream());
            rawData = scan.nextLine();
            Region r = gson.fromJson(rawData,Region.class);
            RegionalDex reg = new RegionalDex(r);
            pokemonList = FXCollections.observableArrayList(reg.getPokeList());
        }
        chosenPokemon.setItems(pokemonList);
    }
    private void handlePokeSelect() throws IOException{
        if(chosenPokemon.getValue()==null){
         return;
        }
        ObservableList<String> pokeVarieties;
        url = new URL("https://pokeapi.co/api/v2/pokemon-species/"+chosenPokemon.getValue());
        scan = new Scanner(url.openStream());
        rawData = scan.nextLine();
        PokemonSpecies species = gson.fromJson(rawData,PokemonSpecies.class);
        pokeVarieties = FXCollections.observableArrayList(species.getVarieties());
        chosenPokeVar.setVisible(true);
        chosenPokeVar.setItems(pokeVarieties);
        chosenPokeVar.setValue(pokeVarieties.getFirst());
        pokeName.setVisible(true);
        pokeName.setText(species.getDisplayName());
        url = new URL("https://pokeapi.co/api/v2/pokemon/"+chosenPokeVar.getValue());
        scan = new Scanner(url.openStream());
        rawData = scan.nextLine();
        PokemonSprites sprites = gson.fromJson(rawData,PokemonSprites.class);
        spritesView.setVisible(true);
        spriteURL = sprites.getSprites()[0];
        spriteShinyURL = sprites.getSprites()[1];
        sprite.setImage(new Image(spriteURL));
        spriteShiny.setImage(new Image(spriteShinyURL));
    }
    private void handleVarSelect() throws IOException{
        if(chosenPokeVar.getValue()==null){
         return;
        }
        url = new URL("https://pokeapi.co/api/v2/pokemon/"+chosenPokeVar.getValue());
        scan = new Scanner(url.openStream());
        rawData = scan.nextLine();
        PokemonSprites sprites = gson.fromJson(rawData,PokemonSprites.class);
        spriteURL = sprites.getSprites()[0];
        spriteShinyURL = sprites.getSprites()[1];
        sprite.setImage(new Image(spriteURL));
        spriteShiny.setImage(new Image(spriteShinyURL));
    }
}


