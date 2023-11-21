import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.Arrays;
/**
*A class for storing generational dex data for the app
*
*@author Cat Weidner
*/
public class GenerationalDex{
   /**
   *The display name of the generation
   */
   private String name;
   /**
   *An array of Pokemon in the given generation
   */
   private Pokemon[] pokemon;
   /**
   *The constructor!
   *Takes a generation and builds a pokedex for the app to use
   *
   *@param gen the generation to build a dex for
   */
   public GenerationalDex(Generation gen)throws MalformedURLException, IOException{
      name = gen.getDisplayName();
      //Setting up temp variables for API calls
      URL url;
      Scanner scan;
      String rawData;
      PokemonSpecies tempSpec;
      PokemonSprites[] tempPics;
      int i=0;
      int j;
      Pokemon tempMon;
      Gson gson = new Gson();
      //Sorting the list of pokemon
      String[] pokeListSorted = Arrays.sort(gen.getPokeList(), String.CASE_INSENSITIVE_ORDER); 
      pokemon = new Pokemon[pokeList.size()];
      //Building the dex using for loops and API calls
      for(String poke:pokeListSorted){
         url = new URL("https://pokeapi.co/api/v2/pokemon-species/"+poke);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         tempSpec = gson.fromJson(rawData,PokemonSpecies.class);
         tempPics = new PokemonSprites[tempSpec.getVarieties().length];
         j = 0;
         for(String var:tempSpec.getVarieties()){
            url = new URL("https://pokeapi.co/api/v2/pokemon/"+var);
            scan = new Scanner(url.openStream());
            rawData = scan.nextLine();
            PokemonSprites temp = gson.fromJson(rawData,PokemonSprites.class);
            tempPics[j] = temp;
            j++;
         }
         tempMon=new Pokemon(tempSpec,tempPics);
         pokemon[i]=tempMon;
         i++;
      }  
   }
   /**
   *Returns the display name, intended for use
   *with app visuals
   *
   *@return display name
   */
   public getName(){
      return name;
   }
   /**
   *Returns a list of pokemon names in this generation
   *intended for use with app visuals
   *
   *@return list of pokemon names
   */
   public String[] getPokeList(){
      String[] temp = new String[pokemon.length];
      int i=0;
      for(Pokemon poke:pokemon){
         temp[i]=poke.getDisplayName();
         i++;
      }
      return temp;
   }
   /**
   *Returns the pokemon for the given index, intended
   *for use on click, needs an index value
   *
   *@return pokemon at index
   */
   public Pokemon getPokemon(int index){
      return pokemon[index];
   }
}