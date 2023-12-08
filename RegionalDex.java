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
   *The list of pokemon for use with the application
   */
   private String[] pokemon;
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
      int i = 0;
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
      pokemon = new String[pokeListSorted.size()];
      for(String p:pokeListSorted){
         pokemon[i]=p;
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
      return pokemon;
   }
}