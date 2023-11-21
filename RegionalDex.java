import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashSet;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
*A class for storing regional pokedex information for the application
*
*@author Cat Weidner
*/
public class RegionalDex{
   /**
   *The display name of the region
   */
   private String name;
   /**
   *The list of Pokemon objects for use with the application
   */
   private Pokemon[] pokemon;
   /**
   *The constructor.
   *Takes a Region object as a parameter and builds the pokedex for that region.
   *
   *@param r the region to build a dex for
   */
   public RegionalDex(Region r)throws MalformedURLException, IOException{
      this.name = r.getDisplayName();
      //Setting up temp variables for API calls
      URL url;
      Scanner scan;
      String rawData;
      Pokedex dex;
      HashSet<String> pokeList = new HashSet<String>();
      PokemonSpecies tempSpec;
      PokemonSprites[] tempPics;
      int i = 0;
      int j;
      Pokemon tempMon;
      Gson gson = new Gson();
      //Create the list of pokemon IDs
      for(String dexName:r.getDexes()){
         url = new URL("https://pokeapi.co/api/v2/pokedex/"+dexName);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         dex = gson.fromJson(rawData,Pokedex.class);
         for(String poke:dex.getPokeList()){
            pokeList.add(poke);
         }
      }
      //Sort the list in alphabetical order
      ArrayList<String> pokeListSorted = new ArrayList<String>(pokeList);
      Collections.sort(pokeListSorted);
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
   public String getName(){
      return name;
   }
   /**
   *Returns a list of pokemon names in this region
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
   /**
   *A test method for printing a given pokemon's display name
   *
   *@param the index of the pokemon
   */
   public void testPrintMonName(int n){
      if(n<pokemon.length)System.out.println(pokemon[n].getDisplayName());
      else System.out.println("There aren't that many entries in the dex.");
   }
}